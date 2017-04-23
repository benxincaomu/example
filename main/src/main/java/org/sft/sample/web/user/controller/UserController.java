package org.sft.sample.web.user.controller;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.sft.sample.web.user.model.User;
import org.sft.sample.web.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author benxi
 *
 *         2016年6月27日
 */
@Controller
@RequestMapping("web/user")
public class UserController {
	@Resource
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "addUser", method = { RequestMethod.POST, RequestMethod.GET })
	public User addUser() {
		User user = new User();
		user.setName("管理员");
		user.setUserName("admin");
		user.setPassword(DigestUtils.md5Hex("1234"));
		user.setNickName("管理员");
		userService.addUser(user);
		return user;
	}

	@RequestMapping(value = "getUser/{id}", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
		User user = userService.getUserById(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
}
