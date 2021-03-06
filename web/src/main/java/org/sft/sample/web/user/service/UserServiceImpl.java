package org.sft.sample.web.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.sft.sample.web.user.mapper.UserMapper;
import org.sft.sample.web.user.model.User;
import org.springframework.stereotype.Service;

/**
 * @author benxi
 *
 * 2016年6月27日
 */
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;

	@Override
	public int addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public User getUserById(String id) {
		return userMapper.findUserById(id);
	}

	@Override
	public User findUserByUserName(String userName) {
		
		return userMapper.findUserByUserName(userName);
	}

	@Override
	public List<User> findUsers(String userName) {
		return userMapper.findUsers(userName, null);
	}

	@Override
	public int deleteUser(String userId){
		return userMapper.delteUser(userId);
	}
	
	

}
