package com.demo.SpringMyBatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.demo.SpringMyBatis.model.User;

@Mapper
public interface UserMapper {

	@Select("select * from users")
	@Results({ @Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name") })
	List<User> findAll();

	@Insert("insert into users(age,email,first_name,last_name) values(#{age},#{email},#{firstName},#{lastName})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	void insert(User user);

	@Select("update users set first_name=#{firstName},last_name=#{lastName} where email=#{email}")
	void update(User user);

	@Select("delete from users where email=#{email} ")
	void deleteByMail(User user);

}
