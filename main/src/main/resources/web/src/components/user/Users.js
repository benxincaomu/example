import React from "react";
import { Card, Table, Button, message, Modal, Popconfirm } from 'antd';
import User from './User';
import $ from "jquery";

class Users extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: [

            ],
            idx: 3,
            userId: "",
            userModelShow: false,
            userModelTitle: ""
        }
        this.query.bind(this);
    }

    componentWillMount() {
        this.query();
    }

    componentDidMount() {

    }

    query() {
        $.get("./web/user/findUsers", {}, (data) => {
            this.setState({ users: data });
        }, "json")
    }

    render() {
        return (
            <div>
                <Card title="用户管理" bordered={false} style={{ width: "100%" }}>
                    <div>
                        <Button className="ant-btn ant-btn-lg" onClick={() => {
                            this.setState({ userModelShow: true, userModelTitle: "新增用户",userId:"" });
                        }}>新增</Button>
                    </div>
                    <br />
                    <Table columns={[
                        { title: "姓名", dataIndex: "name" },
                        {
                            title: "性别", render: (text, record) => {
                                let sex = "";
                                switch (record.sex) {
                                    case 0:
                                        sex = "女";
                                        break;
                                    case 1:
                                        sex = "男";
                                        break;
                                    default:
                                        sex = "未知";
                                        break;
                                }
                                return sex;
                            }
                        },
                        { title: "年龄", dataIndex: "age" },
                        // { title: "身高", dataIndex: "height" },
                        {
                            title: "操作", render: (text, record, index) => {
                                return (
                                    <span>
                                        <Button className="ant-btn ant-btn-sm" onClick={() => {


                                            this.setState({
                                                userId: record.id,
                                                userModelTitle: "修改用户",
                                                userModelShow: true
                                            });
                                        }}>编辑</Button>&nbsp;&nbsp;
                                        <Popconfirm title="确认删除？" onConfirm={() => {
                                            {/* ajax请求后台删除 */ }
                                            $.ajax({
                                                url: "./web/user/user/" + record.id,
                                                type: "DELETE",
                                                success: (data) => {
                                                    this.query();
                                                }
                                            });
                                            message.error("删除的是" + record.name);
                                        }}>
                                            <Button className="ant-btn ant-btn-sm" >删除</Button>
                                        </Popconfirm>
                                        &nbsp;
                                  </span>

                                )
                            }
                        }
                    ]}
                        bordered
                        dataSource={this.state.users}
                        rowKey={(record) => {
                            return record.id;
                        }} />
                </Card>
                <Modal title={this.state.userModelTitle} visible={this.state.userModelShow} onCancel={() => { this.setState({ userModelShow: false }) }} footer={null} destroyOnClose={true}>
                    <User id={this.state.userId} afterSubmit={(values) => {
                        let idx = this.state.idx;
                        values["id"] = idx++;
                        let users = this.state.users;
                        users.push(values);
                        this.setState({ users: users, isAdd: false });
                    }} />
                </Modal>
            </div>
        )
    }
}
export default Users;
