package com.sherlock.www.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sherlock.www.common.exception.MemberServiceException;
import com.sherlock.www.common.util.MD5Util;
import com.sherlock.www.entity.Memberinfo;
import com.sherlock.www.service.IMemberService;

@Controller
public class RegisterController {
    @Autowired
	IMemberService mem;
    
    
	
	@RequestMapping("register")
	public String doRegister(@RequestParam(value = "nickName", required = false) String nickName,
            @RequestParam(value = "passwd", required = false) String password,
            @RequestParam(value = "passwdre", required = false) String passwdre,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "passwdQuestion", required = false) String passwdQuestion,
            @RequestParam(value = "passwdAnswer", required = false) String passwdAnswer,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "recommender", required = false) String recommender,
            @RequestParam(value = "provinceCity", required = false) String provincecity,
            @RequestParam(value = "age", required = false) Long age,
            @RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "authCode", required = false) String authCode){
			

			Memberinfo memberInfo = new Memberinfo();
			memberInfo.setAddress(address);
			memberInfo.setNickname(nickName);
			memberInfo.setAge(age);
			memberInfo.setEmail(email);
			memberInfo.setGender(gender);
			memberInfo.setRecommender(recommender);
			memberInfo.setRegisterdate(new Date());
			memberInfo.setPoint((long)50);
			memberInfo.setPassword(MD5Util.encodeToHex(password));
			memberInfo.setPasswordanswer(passwdAnswer);
			memberInfo.setPasswordquestion(passwdQuestion);
			memberInfo.setProvincecity(provincecity);
			memberInfo.setPhone(phone);
			System.out.println(memberInfo);
			try {
				mem.registerMemberinfo(memberInfo);
			} catch (MemberServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "../login";
	}
	}

