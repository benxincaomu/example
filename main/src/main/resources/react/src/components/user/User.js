import React from "react";
import { Form, Input, Select, Button, InputNumber } from 'antd'
const FormItem = Form.Item
const SelectOption = Select.Option
class AddUser extends React.Component {
  constructor () {
    super()
    this.state = {}
  }
  render () {
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 12}
    }
    const {getFieldDecorator} = this.props.form
    return (
      <div>
        <Form>
          <FormItem label='姓名' {...formItemLayout}>
            {getFieldDecorator('name', {rules: [
                 {required: true,message: '请输入姓名'}
             ]})(<Input/>)}
          </FormItem>
          <FormItem label='性别' {...formItemLayout}>
            {getFieldDecorator('sex', {rules: [
                 {required: true,message: '请选择性别'}
             ]})(<Select>
                   <SelectOption key={0} title='男' value='1'>
                     男
                   </SelectOption>
                   <SelectOption key={10} title='女' value='0'>
                     女
                   </SelectOption>
                 </Select>)}
          </FormItem>
          <FormItem label='年龄' {...formItemLayout}>
            {getFieldDecorator('age', {rules: []})(<Input/>)}
          </FormItem>
          <FormItem label='身高' {...formItemLayout}>
            {getFieldDecorator('height', {rules: []})(<InputNumber/>)}
          </FormItem>
        </Form>
        <Button onClick={function(){
                                     // this.props.afterSubmit()
                                     this.props.form.validateFields(function(errs,values){
                                         if(!errs){
                                             this.props.afterSubmit(values)
                                         }
                                     }.bind(this))
                                 }.bind(this)}>
          提交
        </Button>
      </div>
    )
  }
}
AddUser.propTypes = {
  afterSubmit: React.PropTypes.func
}
AddUser = Form.create({})(AddUser)
export default AddUser
