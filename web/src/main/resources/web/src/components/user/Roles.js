import React from "react";
import { Card, Table, Button, message, Modal } from 'antd';
import { Helmet } from "react-helmet";
import Role from "./Role";
import Grant from './Grant'
import $ from "jquery";
class Roles extends React.Component {
    constructor() {
        super();
        this.state = {
            roles: [],
            modalTitle: "",
            editModalShow: false,
            roleId: "",
            grantShow: false
        }
        this.query = this.query.bind(this);
    }
    componentWillMount() {
        this.query();
    }
    query() {
        $.get("./web/role/findRoles", {}, (data) => {
            this.setState({ roles: data.list });
        }, "json");
    }

    render() {
        return (
            <div>
                <Helmet>
                    <meta charSet="utf-8" />
                    <title>角色管理</title>
                </Helmet>
                <Card title="角色管理" bordered={false} style={{ width: "100%" }}>
                    <div>
                        <Button className="ant-btn ant-btn-lg" onClick={() => {
                            this.setState({ modalTitle: "新增角色", roleId: "", editModalShow: true });
                        }}>新增</Button>
                    </div>
                    <br />
                    <Table columns={[
                        { title: "角色名", dataIndex: "roleName" },
                        { title: "描述", dataIndex: "description" },
                        { title: "创建时间", dataIndex: "createTime" },
                        {
                            title: "操作", render: (text, record, index) => {
                                return (
                                    <span>
                                        <Button className="ant-btn ant-btn-sm" onClick={() => {
                                            this.setState({ modalTitle: "编辑角色", editModalShow: true, roleId: record.id });
                                        }}>编辑</Button>
                                        &nbsp;
                                        <Button className="ant-btn ant-btn-sm" onClick={() => {
                                            this.setState({ roleId: record.id, grantShow: true })
                                        }}>授权</Button>
                                        &nbsp;
                                        {record.canDeleted &&
                                            <Button className="ant-btn ant-btn-sm" onClick={() => {
                                            }}>删除</Button>
                                        }
                                        &nbsp;
                                  </span>

                                )
                            }
                        }
                    ]}
                        dataSource={this.state.roles}
                        rowKey={(record) => {
                            return record.id;
                        }} />
                </Card>
                <Modal key={this.state.roleId} title={this.state.modalTitle} visible={this.state.editModalShow} onCancel={() => { this.setState({ editModalShow: false }); }} footer={null}>
                    <Role id={this.state.roleId}
                        onSubmit={() => {
                            this.query();
                            this.setState({ editModalShow: false });
                        }} />
                </Modal>
                <Modal title="授权" destroyOnClose={true} visible={this.state.grantShow} onCancel={() => { this.setState({ grantShow: false }); }} footer={null}>
                    <Grant id={this.state.roleId} />
                </Modal>
            </div>
        )
    }
}
export default Roles;