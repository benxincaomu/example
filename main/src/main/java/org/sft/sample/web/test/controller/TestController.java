package org.sft.sample.web.test.controller;

import org.sft.sample.web.test.model.TestModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunft
 *
 *         2016年6月24日
 */
@Controller
@RequestMapping("test")
public class TestController {

	@ResponseBody
	@PostMapping("bind")
	public TestModel testBinding(TestModel testModel) {
		return testModel;
	}
}
