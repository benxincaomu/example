package org.sft.sample.web.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class BaseController {

	Object sessionAttr(String attrName) {

		return getSession().getAttribute(attrName);
	}


	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	protected HttpSession getSession() {
		return getRequest().getSession();
	}

}
