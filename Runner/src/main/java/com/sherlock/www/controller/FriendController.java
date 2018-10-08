package com.sherlock.www.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sherlock.www.common.exception.MemberServiceException;
import com.sherlock.www.entity.Blackrecord;
import com.sherlock.www.entity.Friendrecord;
import com.sherlock.www.entity.Memberinfo;
import com.sherlock.www.service.IMemberService;

@Controller
public class FriendController {
	
	@Autowired
	IMemberService member;
	/**
	 * 好友名单
	 * @param model
	 * @return
	 * @throws MemberServiceException 
	 */
	@RequestMapping("buddyList1.action")
	public String buddyList(Model model,@RequestParam String nickname) throws MemberServiceException{
		System.out.println(nickname);
		model.addAttribute("nickname", nickname);
		List<Friendrecord> list = member.listFriend(nickname);
		ArrayList<Memberinfo> friends = new ArrayList();
		for(Friendrecord friend : list){
			Memberinfo memberinfo = member.findMemberinfoByName(friend.getFriendname());
			friends.add(memberinfo);
		}
		model.addAttribute("friend", friends);
		return "messenger/buddyList";
	}
	
	/**
	 * 黑名单
	 * @param model
	 * @return
	 * @throws MemberServiceException 
	 */
	@RequestMapping("blackList1.action")
	public String blackList(Model model,@RequestParam String nickname) throws MemberServiceException{
		System.out.println(nickname);
		model.addAttribute("nickname", nickname);
		List<Blackrecord> listBlack = member.listBlack(nickname);
		ArrayList<Memberinfo> black = new ArrayList<Memberinfo>();
		for(Blackrecord blackrecord : listBlack){
			Memberinfo memberinfo = member.findMemberinfoByName(blackrecord.getBlackname());
			black.add(memberinfo);
		}
		model.addAttribute("black", black);
		return "messenger/blackList";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("box")
	public String box(Model model){
		return "messenger/box";
	}
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("inbox")
	public String inbox(Model model){
		return "messenger/inbox";
	}
	/**
	 * 好友速配
	 * @param model
	 * @return
	 */
	@RequestMapping("matchFriend1.action")
	public String matchFriend(Model model,@RequestParam(value="nickname",required=false)String nickname){		
		model.addAttribute("nickname",nickname);
		return "messenger/matchFriend";
	}
	@RequestMapping("matchFriend2.action")
	public String matchFriend2(Model model,@RequestParam(value="nickname",required=false)String nickname,
										   @RequestParam(value="age",required=false)String ages,
										   @RequestParam(value="gender",required=false)String gender,
										   @RequestParam(value="provinceCity",required=false)String provincecity) throws MemberServiceException{
		model.addAttribute("nickname",nickname);
		System.out.println("macth" + nickname);
		System.out.println(ages + ":" + gender + ":" + provincecity);
		List<Memberinfo> friends = member.findFriends(ages, gender, provincecity,(long)0);
		model.addAttribute("matchFriend", friends);
		return "messenger/matchFriend";
	}
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("memberList")
	public String memberList(Model model){
		return "messenger/memberList";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("outbox")
	public String outbox(Model model){
		return "messenger/outbox";
	}
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("sendInfo")
	public String sendInfo(Model model){
		return "messenger/sendInfo";
	}
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("view")
	public String view(Model model){
		return "messenger/view";
	}
	/**
	 * 添加到黑名单
	 * @param model
	 * @param selfname
	 * @param blackname
	 * @return
	 * @throws MemberServiceException
	 */
	@RequestMapping("moveToBlack1.action")
	public String moveToBlack(Model model,@RequestParam(value="nickname") String selfname,
							  @RequestParam(value="blackName") String blackname) throws MemberServiceException{
		model.addAttribute("nickname",selfname);
		System.out.println("selfname:" + selfname + "/blackname:"+ blackname);
		member.deleleFriend(selfname, blackname);
		member.moveToBlack(selfname, blackname);
		return "redirect:blackList1.action";		
	}
	/**
	 * 添加好友
	 * @param model
	 * @return
	 * @throws MemberServiceException 
	 */
	@RequestMapping("addFriend1.action")
	public String addFriend(Model model,@RequestParam(value="nickname")String selfname,
										@RequestParam(value="friendname")String friendname) throws MemberServiceException{
										
		model.addAttribute("nickname", selfname);
		System.out.println(selfname+friendname);
		member.saveOrUpdate(selfname, friendname);
		return "redirect:buddyList1.action";
	}
}
