package org.sft.sample.common.error;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionResolver {
	@ExceptionHandler(value = Exception.class)
	public Object doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		ApplicationErrorCode errorCode;
		if (ex instanceof ApplicationException) {
			errorCode = ((ApplicationException) ex).getErrorCode();
		} else {
			errorCode = ApplicationErrorCode.SYSTEM_ERROR;
		}
		ex.printStackTrace();
		Map<String, String> map = new HashMap<>();
		map.put("code", errorCode.getCode());
		map.put("message", errorCode.getMessage());
		return map;
	}

}
