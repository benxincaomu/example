package org.sft.sample.web.user.controller;

import org.sft.sample.common.utils.SampleResultRender;
import org.sft.sample.web.user.model.User;
import org.sft.sample.web.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author benxi
 *
 *         2016年6月27日
 */
@RestController
@RequestMapping("web/user")
public class UserController{
	@Resource
	private UserService userService;

	@PostMapping(value = "user")
	public User addUser(@RequestBody User user){
		userService.addUser(user);
		return user;
	}

	@GetMapping(value = "user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") String id){
		User user = userService.getUserById(id);
		if(user == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else{
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	/**
	 * 用户列表
	 * @param userName
	 * @return
	 */
	@GetMapping("findUsers")
	public List<User> getUsers(String userName){

		return userService.findUsers(userName);
	}

	/**
	 * 删除用户
	 * 
	 * @param userId
	 * @return
	 */
	@DeleteMapping("user/{userId}")
	public Map<String, Object> deleteUser(@PathVariable String userId){
		return SampleResultRender.render(userService.deleteUser(userId));
	}
}
