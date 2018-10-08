package com.sherlock.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sherlock.www.common.exception.MessengerServiceException;
import com.sherlock.www.dao.GradeRecordMapper;
import com.sherlock.www.dao.MessageRecordMapper;
import com.sherlock.www.entity.Graderecord;
import com.sherlock.www.entity.Memberinfo;
import com.sherlock.www.entity.Messagerecord;
import com.sherlock.www.service.IMessengerService;

@Service
public class MessengerServiceImpl implements IMessengerService{
	
	@Autowired
	MessageRecordMapper message;
	
	public Integer findNewMessageNum(String nickname) throws MessengerServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public Memberinfo findOneMemberinfo() throws MessengerServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Memberinfo> findFriends(String age, String gender, String city) throws MessengerServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveMessage(Graderecord message) throws MessengerServiceException {
		// TODO Auto-generated method stub
		
	}

	public List<Messagerecord> listSendMessage(String sendName) throws MessengerServiceException {
		
		return message.selectsendMessage(sendName);
	}

	public List<Messagerecord> listRecieveMessage(String recieveName) throws MessengerServiceException {
		// TODO Auto-generated method stub
		return message.selectrecieveMessage(recieveName);
		
	}


	public void saveMessage(Messagerecord messagerecord) throws MessengerServiceException {
		message.insertSend(messagerecord);
	}

	public Messagerecord findMessage(Long id) throws MessengerServiceException {
		
		return message.selectContentById(id);
	}

	public void delRecieveMessage(Long id) throws MessengerServiceException {
		
		message.deleteContentById(id);
	}

	public void delSendMessage(Long id) throws MessengerServiceException {
		
		message.deleteContentById(id);
	}



}
