package com.mjly.dao;

import java.util.List;

import com.mjly.bean.TUser;

public interface TUserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Wed May 29 14:40:27 CST 2019
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Wed May 29 14:40:27 CST 2019
	 */
	int insert(TUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Wed May 29 14:40:27 CST 2019
	 */
	int insertSelective(TUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Wed May 29 14:40:27 CST 2019
	 */
	TUser selectByPrimaryKey(Integer id);
	
	
	List<TUser>  userList();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Wed May 29 14:40:27 CST 2019
	 */
	int updateByPrimaryKeySelective(TUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Wed May 29 14:40:27 CST 2019
	 */
	int updateByPrimaryKey(TUser record);
}