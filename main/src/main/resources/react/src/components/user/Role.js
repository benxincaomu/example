import React from "react";
import $ from "jquery";
import { Form, Input, Select, Button, InputNumber } from 'antd'
const FormItem = Form.Item

class Role extends React.Component {
    constructor() {
        super()
        this.state = {
            role:{},
            id:""
        }
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

                        })(<Input type="hidden" />)}
                    </FormItem>
                    <FormItem label='角色名' {...formItemLayout}>
                        {getFieldDecorator('roleName', {
                            rules: [
                                { required: true, message: '请输入角色名' }
                            ]
                        })(<Input />)}
                    </FormItem>
                    <FormItem label='角色描述' {...formItemLayout}>
                        {getFieldDecorator('description', {
                            rules: [
                                { required: true, message: '请输入角色描述' }
                            ]
                        })(<Input />)}
                    </FormItem>
                    <FormItem wrapperCol={{ offset: 6 }}>
                        <Button onClick={() => {
                            this.props.form.validateFields(function (errs, values) {
                                if (!errs) {
                                    $.post("./web/role/addRole", values, (data) => {
                                        if (data) {
                                            this.props.onSubmit();
                                        }
                                    }, "text");
                                }
                            }.bind(this))
                        }}>提交</Button>
                    </FormItem>
                </Form>
            </div>
        )
    }
}
// Role.propTypes={
//     onSubmit:React.PropTypes.func,
//     id:React.PropTypes.string
// }
Role = Form.create({})(Role);
export default Role;