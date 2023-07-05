package com.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	public int method2() {
   	 System.out.println("in method2 in service");
   	 return 10;
    }
    public void getData2(int x) {
   	 System.out.println("in getData service");
    }
    public String getmydata2(int x) {
   	 System.out.println("in getmy Data service"+x);
   	 return "success";
    }

}
