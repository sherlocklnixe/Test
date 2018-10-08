package com.sherlock.www.service.impl;

import java.util.Date;
import java.util.List;

import javax.swing.plaf.metal.MetalMenuBarUI;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sherlock.www.common.exception.MemberServiceException;
import com.sherlock.www.common.util.MD5Util;
import com.sherlock.www.common.util.RandomChar;
import com.sherlock.www.dao.BlackRecordMapper;
import com.sherlock.www.dao.FriendrecordMapper;
import com.sherlock.www.dao.MemberInfoMapper;
import com.sherlock.www.dao.MemberSpaceMapper;
import com.sherlock.www.entity.Blackrecord;
import com.sherlock.www.entity.Friendrecord;
import com.sherlock.www.entity.Graderecord;
import com.sherlock.www.entity.Memberinfo;
import com.sherlock.www.entity.Memberspace;
import com.sherlock.www.entity.Pointaction;
import com.sherlock.www.entity.Pointrecord;
import com.sherlock.www.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService{
	
	@Autowired
	MemberInfoMapper memberInfoMapper;
	@Autowired
	FriendrecordMapper friendrecrdMapper;
	@Autowired
	MemberSpaceMapper memberspaceMapper;
	@Autowired
	BlackRecordMapper blackrecordMapper;

	public void registerMemberinfo(Memberinfo Memberinfo) throws MemberServiceException {
		if(Memberinfo.getRecommender() != null){
			memberInfoMapper.addPoint(Memberinfo.getRecommender(), (long)50);
		}
		memberInfoMapper.insertMember(Memberinfo);	
	}

	public Memberinfo findMemberinfoByName(String nickname) throws MemberServiceException {
		return memberInfoMapper.selectFriendMessage(nickname);
	}
	
	@Transactional
	public Memberinfo login(String nickname, String password) throws MemberServiceException {
		Memberinfo mem = new Memberinfo();
		mem.setNickname(nickname);
		mem.setPassword(MD5Util.encodeToHex(password));
		Memberinfo selectUser = memberInfoMapper.selectUser(mem);
		if( selectUser != null){
			memberInfoMapper.updatelatestdate(nickname,new Date());
			return selectUser;
		}else{
			return null;
		} 
	}

	public void logout(String nickname) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	public List<Memberinfo> findMemberinfoByNum(int number) throws MemberServiceException {

		return memberInfoMapper.selectPoint();
	}

	public int findMemberinfoOnline() throws MemberServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Graderecord findMemberinfoLevel(Long point) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpDate(Memberinfo Memberinfo, String oldPasswd) throws MemberServiceException {
		
		 memberInfoMapper.updateMemberinfo(Memberinfo, MD5Util.encodeToHex(oldPasswd));;
	}

	public String getBackPasswd(String nickname, String pwdQuestion, String pwdAnswer) throws MemberServiceException {
		String passwd = RandomChar.getChars(RandomChar.RANDOM_ALL, 6);
		Memberinfo memberinfo = new Memberinfo(nickname,MD5Util.encodeToHex(passwd));
		System.out.println(memberinfo.getPassword());
		Memberinfo setPassword = memberInfoMapper.setPassword(new Memberinfo(nickname,pwdQuestion,pwdAnswer));
		System.out.println(setPassword);
		if(setPassword != null){
			memberInfoMapper.updatePassword(memberinfo);	
			return passwd;
		}else{
			return "error";
		}
	}

	public void saveOrUpdate(Memberinfo Memberinfo) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	public void saveOrUpdate(String selfname, String friendname) throws MemberServiceException {

		friendrecrdMapper.addFriend(selfname, friendname);
		String str = selfname;
		selfname = friendname;
		friendname = str;
		friendrecrdMapper.addFriend(selfname, friendname);
	}

	public List<Friendrecord> listFriend(String selfname) throws MemberServiceException {
		
		return friendrecrdMapper.selectFriend(selfname);
	}

	public void moveToBlack(String selfname, String blackname) throws MemberServiceException {
		blackrecordMapper.addBlack(selfname, blackname);
	}

	public List<Blackrecord> listBlack(String selfname) throws MemberServiceException {
		
		return blackrecordMapper.selectBlackrecord(selfname);
	}

	public Friendrecord findFriend(String friend) throws MemberServiceException {
		
		return null;
	}

	public Boolean isMemberspace(String nickname) throws MemberServiceException {
		long id = memberInfoMapper.selectIdByName(nickname);
		Memberspace memberSpace = memberspaceMapper.selectSpace(id);
		System.out.println(memberSpace);
		if(memberSpace != null){
			return true;
		}else{
			return false;
		}
	}

	public void moveToFriend(String selfName, String name_searching) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	public void deleleBlack(String selfName, String black) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	public void deleleFriend(String selfName, String friend) throws MemberServiceException {
		
		friendrecrdMapper.deleleFriend(selfName, friend);
	}

	public void delSpace(Long id) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	public Pointaction findPointactionByPointAction(String actionName) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Pointrecord Pointrecord) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	public void saveorupdateMemberspace(Memberspace space, Memberinfo Memberinfo) throws MemberServiceException {
			memberspaceMapper.insertSpace(space);
	}

	public Memberspace findSpace(Long id) throws MemberServiceException {
		
		return memberspaceMapper.selectSpace(id);
	}

	public List<Memberinfo> match(Long id) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Memberinfo> listMemberinfo() throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Memberinfo> findFriends(String ages, String genders, String provinceCitys, Long id)
			throws MemberServiceException {
		int startage = 0;
		int endage = 0;
		String gender = null;
		String provincecity = null;
		if(genders.equals("null")){
			gender = null;
		}else{
			gender = genders;
		}
		if(provinceCitys.equals("null")){
			provincecity = null;	
		}else{
			provincecity = provinceCitys;
		}
		if(ages.equals("1")){
			startage=10;
			endage=19;
		}
		if(ages.equals("2")){
			startage=20;
			endage=29;
		}
		if(ages.equals("3")){
			startage=30;
			endage=39;
		}
		if(ages.equals("null")){
			startage=0;
			endage=0;
		}
		System.out.println(startage+".."+endage+".."+ gender+ provincecity);
		return memberInfoMapper.matchFriend(startage,endage, gender, provincecity);
	}

	public long selectIdByName(String nickname) throws MemberServiceException {
		
		return memberInfoMapper.selectIdByName(nickname);
	}
}