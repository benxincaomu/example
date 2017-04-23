import React from "react";
import { hashHistory } from "react-router"
import { Helmet } from "react-helmet";
import { Form, Input, Button, message } from "antd";
import JqueryUtil from "../commons/utils/JqueryUtil";
const FormItem = Form.Item;

class Login extends React.Component {
	constructor() {
		super();
	}


	render() {
		const formItemLayout = {
			/*labelCol: { span: 3},*/
			wrapperCol: { span: 18, offset: 3 }
		}
		const { getFieldDecorator } = this.props.form;
		return (
			<div >
				<Helmet>
					<meta charSet="utf-8" />
					<title>登陆</title>
				</Helmet>

				<Form>
					<div style={{ position: "absolute", width: "400px", height: "200px", left: "50%", top: "45%", margiLeft: "-200px", marginTop: "-100px", border: "1px solid #ccc", padding: "10px", textAlign: "center" }}>
						<h3>简单系统</h3>
						<br />
						<FormItem {...formItemLayout}>
							{getFieldDecorator('userName', {
								rules: [
									{ required: true, message: '请输入用户名' }
								]
							})(<Input placeholder="用户名" />)}
						</FormItem>
						<FormItem  {...formItemLayout}>
							{getFieldDecorator('password', {
								rules: [
									{ required: true, message: '请输入密码' }
								]
							})(<Input type="password" placeholder="密码" />)}
						</FormItem>
						<FormItem  {...formItemLayout}>
							<Button onClick={() => {
								this.props.form.validateFields((errs, values) => {
									if (!errs) {
										JqueryUtil.post("./login/login", values, (data) => {
											if (data.message) {
												message.error(data.message);
											}else{
												hashHistory.push("/");
											}
										}, "json");
									}
								});
							}}>登陆</Button>
						</FormItem>
					</div>
				</Form>
			</div>
		)

	}

}
Login = Form.create({})(Login);
export default Login;