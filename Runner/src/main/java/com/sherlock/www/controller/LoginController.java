package com.sherlock.www.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sherlock.www.common.exception.MemberServiceException;
import com.sherlock.www.common.util.CodeCaptchaServlet;
import com.sherlock.www.common.util.MD5Util;
import com.sherlock.www.dao.MemberInfoMapper;
import com.sherlock.www.entity.Memberinfo;
import com.sherlock.www.service.IMemberService;

@Controller
public class LoginController {
	
	@Autowired
	IMemberService mem;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	MemberInfoMapper memMapper;
	
	@RequestMapping("/autologin")
	public String autologin(){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		Cookie[] cookies = attr.getRequest().getCookies();
		for(Cookie cookie : cookies ){
			System.out.println(cookie);
		}
		return "hello";
	}
	
	@RequestMapping("/login.action")
	public String login(Model model,@RequestParam(value="username",required=false) String nickname,
						@RequestParam(value="password",required=false) String password,
						@RequestParam(value="authCode",required=false) String authCode) throws MemberServiceException{
		ServletRequestAttributes arre = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		String vcode = (String) arre.getRequest().getSession().getAttribute(CodeCaptchaServlet.VERCODE_KEY);
		System.out.println(nickname + password + vcode + authCode);
		if(nickname == null || password == null){
			model.addAttribute("error", "fail1");
			return "../login";
		}
		if(authCode.equals(vcode)){
			Memberinfo memberinfo = mem.login(nickname, password);
			System.out.println(memberinfo);
			if(memberinfo != null){
				if(redisTemplate.opsForValue().get(nickname) == null){
				redisTemplate.opsForValue().set(nickname,"1",24, TimeUnit.HOURS);
				memMapper.addPoint(nickname, 50);
				}
				model.addAttribute("nickname", nickname);
				model.addAttribute("memberinfo", memberinfo);
				List<Memberinfo> findMemberinfoByNum = mem.findMemberinfoByNum(10);
				model.addAttribute("point", findMemberinfoByNum);
				return "member/activity";
			}else{
				model.addAttribute("error","fail2");
				return "../login";
			}
		}else{
			model.addAttribute("error", "fail3");
			return "../login";
		}	
	}
	
	@RequestMapping("getpassword")
	public String setPassword(Model model,@RequestParam(value="userName",required=false) String nickname,
			@RequestParam(value="passwdQuestion",required=false) String pwdQuestion,
			@RequestParam(value="passwdAnswer",required=false) String pwdAnswer) throws MemberServiceException{
		System.out.println(nickname + pwdQuestion + pwdAnswer);
		String backPasswd = mem.getBackPasswd(nickname, pwdQuestion, pwdAnswer);
		System.out.println(backPasswd);
		if(backPasswd.equals("error")){
			model.addAttribute("msg", "密码修改失败，用户名或提示问题错误");
		}else{
		model.addAttribute("msg", "密码修改成功，新密码为" + backPasswd);
			}
		return "../passwd_missing";
	}
	
	@RequestMapping("/aaa.action")
	public String point(Model model) throws MemberServiceException{
		List<Memberinfo> findMemberinfoByNum = mem.findMemberinfoByNum(10);
		model.addAttribute("point", findMemberinfoByNum);
		return "../login";
		
	}
	/**
	 * 修改个人信息
	 * @param model
	 * @return
	 * @throws MemberServiceException 
	 */
	@RequestMapping("modify1.action")
	public String modify1(Model model,@RequestParam(value="nickname")String nickname,
									 @RequestParam(value="oldPasswd")String oldPasswd,
									 @RequestParam(value="newPasswd")String newPasswd,
									 @RequestParam(value="newPasswdre")String newPasswdre,
									 @RequestParam(value="passwdQuestion")String passwdQuestion,
									 @RequestParam(value="passwdAnswer")String passwdAnswer,
									 @RequestParam(value="email")String email,
									 @RequestParam(value="gender")String gender,
									 @RequestParam(value="provinceCity")String provinceCity,
									 @RequestParam(value="phone")String phone,
									 @RequestParam(value="address")String address) throws MemberServiceException{
		Memberinfo member = new Memberinfo();
		member.setNickname(nickname);
		member.setPassword(MD5Util.encodeToHex(newPasswd));
		member.setPasswordanswer(passwdAnswer);
		member.setEmail(email);
		member.setPasswordquestion(passwdQuestion);
		member.setAddress(address);
		member.setGender(gender);
		member.setPhone(phone);
		member.setProvincecity(provinceCity);
		System.out.println(member);
		model.addAttribute("nickname",nickname);
		mem.saveOrUpDate(member, oldPasswd);
		return "member/modify";
	}
	@RequestMapping("modify2.action")
	public String modify(Model model,@RequestParam(value="nickname")String nickname){
		model.addAttribute("nickname",nickname);
		return "member/modify";
	}

}
