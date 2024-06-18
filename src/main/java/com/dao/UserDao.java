package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbc;// PreparedStatement

	// query -> run ->
	// update() : insert update delete
	// query() : select -> multiple records 
	// queryForObject() : select -> single record 

	public void addUser(UserBean user) {
		jdbc.update("insert into users (firstName,email,password) values (?,?,?)", user.getFirstName(), user.getEmail(),
				user.getPassword());
	}

	// multi-record -> List<class>
	public List<UserBean> getAllUsers() {
		return jdbc.query("select * from users", new BeanPropertyRowMapper<>(UserBean.class));
	}

	public void deleteUser(Integer userId) {
		jdbc.update("delete from users where userId = ? ", userId);
	}

	// single-record -> class -> UserBean
	//argument -> controller side ->dao side -> value pass 
	public UserBean getUserByUserId(Integer userId) {
		return jdbc.queryForObject("select * from users where userId = ?",new BeanPropertyRowMapper<>(UserBean.class),new Object[] {userId});//new 
 
		
		//sbi debit card -> blue 2024-jan 
		//sbi debit card -> red 2027-jan 
		
	}
	//return -> dao side -> control side -> data pass 


	//sql->query? 
	//select * from users where firstName = ? 
	//
	// multi-record -> List<class>
		public List<UserBean> getUsersByName(String firstName) {
			return jdbc.query("select * from users where firstName = ? ", new BeanPropertyRowMapper<>(UserBean.class),new Object[] {firstName});
		}

}

