package com.sherlock.www.dao;

import java.util.List;

import com.sherlock.www.entity.Messagerecord;

public interface MessageRecordMapper{
	
	List<Messagerecord> selectsendMessage(String sender);
	List<Messagerecord> selectrecieveMessage(String reciever);
	void insertSend (Messagerecord messagerecord);
	Messagerecord selectContentById(Long id);
	void deleteContentById(Long id);
}