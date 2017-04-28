import React from "react";
import { Card, Table, Button, message, Modal } from 'antd';

class Roles extends React.Component {
    constructor() {
        super();
        this.state={
            isAdd:false,
            roles:[]
        }
    }

    render() {
        return (
            <div>
                <Card title="角色管理" bordered={false} style={{ width: "100%" }}>
                    <div>
                        <Button className="ant-btn ant-btn-lg" onClick={() => {
                            message.info("新增用户");
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
                <Modal title="新增角色" visible={this.state.isAdd} onCancel={() => { this.setState({ isAdd: false }) }} footer={null}>
                    
                </Modal>
            </div>
        )
    }
}
export default Roles;