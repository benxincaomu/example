package org.sft.sample.web.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sft.sample.web.user.model.User;

/**
 * @author benxi
 *
 * 2016年6月27日
 */
@Mapper
public interface UserMapper {
	/**
	 * 新增用户
	 * @param user 用户信息
	 * @return 添加结果
	 */
	int addUser(User user);
	/**
	 * 根据id获取用户信息
	 * @param id 用户Id
	 * @return 用户信息
	 */
	User findUserById(@Param("id") String id);
	
	/**
	 * 根据id获取用户信息
	 * @param userName 用户名
	 * @return
	 */
	User findUserByUserName(@Param("userName") String userName);
	
	/**
	 * 
	 * @param userName 用户名
	 * @param roleId 角色ID
	 * @return
	 */
	List<User> findUsers(@Param("userName")String userName,@Param("roleId")String roleId);
	
	/**
	 * 修改用户信息
	 * @param user 用户信息
	 * @return
	 */
	int updateUser(User user);
	
	
	
	
	
	
}
