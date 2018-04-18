import React from "react";
import $ from "jquery";
import { Form, Input, Button, message } from 'antd';
import PropTypes from 'prop-types';
const FormItem = Form.Item

class Role extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            role: {
                id: "",
                roleName: "",
                description: ""
            },
            id: this.props.id
        }
        this.query.bind(this);
    }

    componentWillMount() {
        this.query(this.props.id);
    }

    componentWillReceiveProps(props) {
        if (!props.id) {
            this.resetState();
            // this.props.form.resetFields();
            return;
        }
        if (props.id == this.state.id) {
            return;
        }

        this.query(props.id);
    }
    query(id) {
        if (id) {

            $.get("./web/role/getRole", { id: id }, (data) => {
                this.setState({ roleId: id, role: data });
            }, "json");
        }
    }

    resetState() {
        this.setState({
            role: {
                id: "",
                roleName: "",
                description: ""
            },
            id: ""
        });
    }


    render() {
        const formItemLayout = {
            labelCol: { span: 6 },
            wrapperCol: { span: 12 }
        }
        const { getFieldDecorator } = this.props.form
        return (
            <div>
                <Form>
                    <FormItem {...formItemLayout}>
                        {getFieldDecorator('id', {
                            initialValue: this.state.role.id,
                        })(<Input type="hidden" />)}
                    </FormItem>
                    <FormItem label='角色名' {...formItemLayout}>
                        {getFieldDecorator('roleName', {
                            initialValue: this.state.role.roleName,
                            rules: [
                                { required: true, message: '请输入角色名' }
                            ]
                        })(<Input />)}
                    </FormItem>
                    <FormItem label='角色描述' {...formItemLayout}>
                        {getFieldDecorator('description', {
                            initialValue: this.state.role.description,
                            rules: [
                                { required: true, message: '请输入角色描述' }
                            ]
                        })(<Input />)}
                    </FormItem>
                    <FormItem wrapperCol={{ offset: 6 }}>
                        <Button onClick={() => {
                            this.props.form.validateFields(function (errs, values) {
                                if (!errs) {
                                    $.post(values.id ? "./web/role/updateRole" : "./web/role/addRole", values, (data) => {
                                        if (data.result> 0) {
                                            message.success("保存成功");
                                            this.props.onSubmit();
                                        } else {
                                            message.error("保存失败");
                                        }
                                    }, "json");

                                }
                            }.bind(this))
                        }}>提交</Button>
                    </FormItem>
                </Form>
            </div>
        )
    }
}
Role.propTypes = {
    onSubmit: PropTypes.func,
    id: PropTypes.string
}
Role.defaultProps = {
    onSubmit: null,
    id: ""

}
Role = Form.create({})(Role);
export default Role;