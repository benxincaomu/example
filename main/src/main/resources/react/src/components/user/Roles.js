import React from "react";
import { Card, Table, Button, message, Modal } from 'antd';
import { Helmet } from "react-helmet";
import Role from "./Role"
class Roles extends React.Component {
    constructor() {
        super();
        this.state = {
            roles: [],
            modalTitle: "",
            modalShow: false
        }
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
                            this.setState({ modalTitle: "新增角色", modalShow: true });

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
                                            message.info("编辑");
                                        }}>编辑</Button>
                                        &nbsp;
                                        <Button className="ant-btn ant-btn-sm" onClick={() => {
                                            message.info("删除");
                                        }}>删除</Button>
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
                <Modal title={this.state.modalTitle} visible={this.state.modalShow} onCancel={() => { this.setState({ modalShow: false }) }} footer={null}>
                    <Role />
                </Modal>
            </div>
        )
    }
}
export default Roles;