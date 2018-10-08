package com.sherlock.www.dao;

import java.util.List;

import com.sherlock.www.entity.Friendrecord;

import tk.mybatis.mapper.common.Mapper;


public interface FriendrecordMapper{
	
	 List<Friendrecord> selectFriend(String selfname);
	 void deleleFriend(String selfname,String friendname);
	 void addFriend(String selfname,String friendname);
}