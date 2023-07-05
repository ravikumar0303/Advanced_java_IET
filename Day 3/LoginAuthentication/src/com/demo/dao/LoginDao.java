package com.demo.dao;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public interface LoginDao {

	MyUser authenticateUser(String uname, String passwd);

	

	int registerUser(RegisterUser ob, MyUser u);

}
