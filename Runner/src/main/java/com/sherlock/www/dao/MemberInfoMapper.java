package com.sherlock.www.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.sherlock.www.entity.Memberinfo;

import tk.mybatis.mapper.common.Mapper;


public interface MemberInfoMapper{
	
	void insertMember(Memberinfo mem);
	Memberinfo selectUser(Memberinfo mem);
	Memberinfo setPassword(Memberinfo mem);
	void updatePassword(Memberinfo mem);
	List<Memberinfo> selectPoint();
	void updatelatestdate(String nickname,Date date);
	void addPoint(String nickname,long point);
	Memberinfo selectFriendMessage(String nickname);
	List<Memberinfo> matchFriend(@Param("startage")int startage,@Param("endage")int endage,@Param("gender")String gender,@Param("provincecity")String provincecity);
	void updateMemberinfo(@Param("mem")Memberinfo mem,@Param("oldPassword")String oldPassword);
	
    long selectIdByName(String nickname);
}