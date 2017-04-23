package org.sft.sample.web.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
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
	 * @param user
	 * @return
	 */
	int addUser(User user);
	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return
	 */
	User findUserById(@Param("id") String id);
	
	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return
	 */
	User findUserByUserName(@Param("userName") String userName);
	
	List<User> findUsers(@Param("userName")String userName,@Param("roleId")String roleId);
	
	
	
}
