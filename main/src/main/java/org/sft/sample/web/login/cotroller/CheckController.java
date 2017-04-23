package org.sft.sample.web.login.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("web/check")
@Controller
public class CheckController{
	@ResponseBody
	@RequestMapping(value = "session", method = { RequestMethod.POST, RequestMethod.GET })
	public void checkSession() {

	}
}
