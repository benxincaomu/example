package org.sft.sample.web.user.controller;

import org.sft.sample.web.user.model.User;
import org.sft.sample.web.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author benxi
 *
 *         2016年6月27日
 */
@RestController
@RequestMapping("web/user")
public class UserController {
	@Resource
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "addUser", method = { RequestMethod.POST, RequestMethod.GET })
    public User addUser(User user) {
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
	@GetMapping("findUsers")
	public List<User> getUsers(String userName){
		
		return userService.findUsers(userName);
	}
	public void getMenus() {
		
	}
}
