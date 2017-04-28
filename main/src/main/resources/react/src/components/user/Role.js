import React from "react";
import { Form, Input, Select, Button, InputNumber } from 'antd'
const FormItem = Form.Item

class Role extends React.Component {
    constructor() {
        super()
        this.state = {

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
                            
                        })(<Input type="hidden"/>)}
                    </FormItem>
                    <FormItem label='角色名' {...formItemLayout}>
                        {getFieldDecorator('name', {
                            rules: [
                                { required: true, message: '请输入角色名' }
                            ]
                        })(<Input />)}
                    </FormItem>
                </Form>
            </div>
        )
    }
}
Role=Form.create({})(Role);
export default Role;