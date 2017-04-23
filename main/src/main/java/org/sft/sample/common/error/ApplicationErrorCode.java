package org.sft.sample.common.error;

public enum ApplicationErrorCode {
	SYSTEM_ERROR("-1","系统异常"),
	VALIDATECODE_FAILURE("1000","验证码错误"),
	USERNAME_OR_PASSWORD_FAILURE("10001","用户名或密码错误:%s"),
	RESOURCE_NOT_EXIST("40004", "指定的资源不存在"),
	DATA_VALIDATE_FAILURE("99999","数据校验失败"),
	;

	private String code;
	private String message;

	private ApplicationErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	

}
