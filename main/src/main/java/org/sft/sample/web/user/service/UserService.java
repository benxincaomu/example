package org.sft.sample.web.user.service;

import org.sft.sample.web.user.model.User;

/**
 * @author benxi
 *
 * 2016年6月27日
 */
public interface UserService {
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return
	 */
	User getUserById(String id);
	
	/**
	 *  根据用户名查询用户
	 * @param userName  用户名
	 * @return
	 */
	User findUserByUserName(String userName);
	
}
