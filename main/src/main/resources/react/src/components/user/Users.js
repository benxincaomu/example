import React from "react";
import { Card, Table, Button, message, Modal } from 'antd';
import User from './User'
import $ from "jquery"

class Users extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: [

            ],
            idx: 3,
            userModelShow: false
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
        },"json")
    }

    render() {
        return (
            <div>
                <Card title="用户管理" bordered={false} style={{ width: "100%" }}>
                    <div>
                        <Button className="ant-btn ant-btn-lg" onClick={() => {
                            this.setState({ userModelShow: true });
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
                                    case "0":
                                        sex = "女";
                                        break;
                                    case "1":
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
                        { title: "身高", dataIndex: "height" },
                        {
                            title: "操作", render: (text, record, index) => {
                                return (
                                    <span>
                                        <Button className="ant-btn ant-btn-sm">编辑</Button>&nbsp;&nbsp;

                                        <Button className="ant-btn ant-btn-sm" onClick={() => {
                                            {/* ajax请求后台删除 */
                                            }
                                            let users = [];
                                            console.log(this.state.users.length);
                                            for (let i = 0; i < this.state.users.length; i++) {
                                                if (i != index) {
                                                    users.push(this.state.users[i]);
                                                }
                                            }
                                            this.setState({ users: users });
                                            message.error("删除的是" + record.name);
                                        }}>删除</Button>
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
                <Modal title="新增用户" visible={this.state.userModelShow} onCancel={() => { this.setState({ userModelShow: false }) }} footer={null}>
                    <User afterSubmit={function (values) {

                        values["id"] = this.state.idx++;
                        this.state.users.push(values);
                        this.state.isAdd = false;
                        this.setState(this.state);
                    }.bind(this)} />
                </Modal>
            </div>
        )
    }
}
export default Users;
