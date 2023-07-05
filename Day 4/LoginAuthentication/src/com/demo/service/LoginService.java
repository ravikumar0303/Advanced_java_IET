package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public interface LoginService {

	MyUser validateUser(String uname, String passwd);
	int addRegisterUser(RegisterUser r,MyUser u);
}
