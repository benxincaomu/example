import React from "react";
import { Helmet } from "react-helmet";
import { Form, Input, Button, message } from "antd";
import JqueryUtil from "../commons/utils/JqueryUtil";
import PropTypes from "prop-types"

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
			<div style={{textAlign:"center"}}>
				<Helmet>
					<meta charSet="utf-8" />
					<title>登陆</title>
				</Helmet>

				<Form>
					<div /**style={{ position: "absolute", width: "20%", height: "200px", left: "40%", right:"50%", top: "45%", margiLeft: "-200px", marginTop: "-100px", border: "1px solid #ccc", padding: "10px", textAlign: "center" }} */>
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
												this.props.success();
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
Login.propTypes = {
	success:PropTypes.func
}
Login.defaultProps = {
	success:null
}
Login = Form.create({})(Login);
export default Login;