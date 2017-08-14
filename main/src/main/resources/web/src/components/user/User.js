import React from "react";
import {Form, Input, Select, Button, InputNumber, message} from "antd";
import JqueryUtil from "../commons/utils/JqueryUtil";
import createBrowserHistory from 'history/createBrowserHistory'

const history = createBrowserHistory()
const FormItem = Form.Item
const SelectOption = Select.Option
class User extends React.Component {
  constructor () {
    super()
    this.state = {}
  }

    handlePasswordBlur(e) {
        const value = e.target.value;
        this.setState({passwordDirty: this.state.passwordDirty || !!value});
    }

    checkConfirm(rule, value, callback) {
        const form = this.props.form;
        if (value && this.state.passwordDirty) {
            form.validateFields(['confirmPassword'], {force: true});
        }
        callback();
    }

    checkPassword(rule, value, callback) {
        const form = this.props.form;
        if (value && value !== form.getFieldValue('password')) {
            callback('两次密码输入不一致');
        } else {
            callback();
        }
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
            <FormItem label='用户名' {...formItemLayout}>
                {getFieldDecorator('userName', {
                    rules: [
                        {required: true, message: '请输入用户名'}
                    ]
                })(<Input/>)}
            </FormItem>
            <FormItem label="密码"  {...formItemLayout}>
                {getFieldDecorator('password', {
                    rules: [{required: true, message: '该项为必填项'}, {validator: this.checkConfirm.bind(this)}]
                })(<Input type="password" onBlur={this.handlePasswordBlur.bind(this)}/>)}
            </FormItem>
            <FormItem label="确认新密码"  {...formItemLayout}>
                {getFieldDecorator('confirmPassword', {
                    rules: [{required: true, message: '该项为必填项'}, {validator: this.checkPassword.bind(this)}]
                })(<Input type="password"/>)}

            </FormItem>
            <FormItem label='昵称' {...formItemLayout}>
                {getFieldDecorator('nickName', {rules: []})(<Input/>)}
          </FormItem>
        </Form>
        <Button onClick={function(){
                                     // this.props.afterSubmit()
                                     this.props.form.validateFields(function(errs,values){
                                         if(!errs){
                                             JqueryUtil.post("./web/user/addUser", values, (data) => {
                                                 if (data.message) {
                                                     message.error(data.message);
                                                 } else {
                                                     history.push("/");
                                                 }
                                             }, "json");
                                         }
                                     }.bind(this))
                                 }.bind(this)}>
          提交
        </Button>
      </div>
    )
  }
}
User.propTypes = {
  afterSubmit: React.PropTypes.func
}
User = Form.create({})(User)
export default User
