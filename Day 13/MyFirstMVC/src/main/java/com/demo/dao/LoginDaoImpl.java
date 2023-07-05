package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.MyUser;

@Repository
public class LoginDaoImpl implements LoginDao{
   @Autowired
   private JdbcTemplate jdbcTemplate;

@Override
public MyUser validateUser(String unm, String passwd) {
	return jdbcTemplate.queryForObject("select * from user where uname=? and password=?",new Object[]{unm,passwd},
			BeanPropertyRowMapper.newInstance(MyUser.class));
}
   
}
