package com.sherlock.www.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sherlock.www.common.exception.MessengerServiceException;
import com.sherlock.www.entity.Messagerecord;
import com.sherlock.www.service.IMessengerService;

@Controller
public class BoxController {
	
		@Autowired
		IMessengerService message;
		
		/**
		 * 收件箱
		 * @param model
		 * @param nickname
		 * @return
		 * @throws MessengerServiceException
		 */
		@RequestMapping("inbox1.action")
		public String inbox(Model model,@RequestParam(value="nickname")String nickname) throws MessengerServiceException{
			model.addAttribute("nickname",nickname);
			List<Messagerecord> listSendMessage = message.listRecieveMessage(nickname);
			for(Messagerecord messagerecord : listSendMessage){
				System.out.println(messagerecord);
			}
			model.addAttribute("listSendMessage", listSendMessage);
			return "messenger/inbox";
		}
		
		/**
		 * 发件箱 
		 * @param model
		 * @param nickname
		 * @return
		 * @throws MessengerServiceException
		 */
		@RequestMapping("outbox1.action")
		public String outbox(Model model,@RequestParam(value = "nickname")String nickname) throws MessengerServiceException{
			model.addAttribute("nickname",nickname);
			List<Messagerecord> listSendMessage = message.listSendMessage(nickname);
			for(Messagerecord messagerecord : listSendMessage){
				System.out.println(messagerecord);
			}
			model.addAttribute("listSendMessage", listSendMessage);
			return "messenger/outbox";
		}
		
		@RequestMapping("sendInfo1.action")
		public String sendInfo_a(Model model,@RequestParam(value="nickname")String nickname){
			model.addAttribute("nickname", nickname);
			return "messenger/sendInfo";
			
		}
		
		@RequestMapping("sendInfo2.action")
		public String sendInfo_b(Model model,@RequestParam(value="nickname")String nickname,
				@RequestParam(value="receiver")String receiver,
				@RequestParam(value="title")String title,
				@RequestParam(value="content")String content) throws MessengerServiceException{
			model.addAttribute("nickname", nickname);
			Messagerecord messagerecord = new Messagerecord();
			messagerecord.setSender(nickname);
			messagerecord.setReceiver(receiver);
			messagerecord.setTitle(title);
			messagerecord.setContent(content);
			messagerecord.setSenddate(new Date());
			message.saveMessage(messagerecord);
			System.out.println(messagerecord);
			return "messenger/sendInfo";
		}
		
		@RequestMapping("detailMessage.action")
		public String detailMessage_a(Model model,@RequestParam(value="nickname")String nickname,
												  @RequestParam(value="ID")Long id) throws MessengerServiceException{
			model.addAttribute("nickname",nickname);
			System.out.println("id" + id);
			Messagerecord findMessage = message.findMessage(id);
			model.addAttribute("findMessage", findMessage);
			return "messenger/view";
		}
		
		@RequestMapping("delReceiveMessage.action")
		public String delReceiveMessage_a(Model model,@RequestParam(value="nickname")String nickname,
												  @RequestParam(value="ID")Long id) throws MessengerServiceException{
			model.addAttribute("nickname",nickname);
			System.out.println("id" + id);
			message.delRecieveMessage(id);
			return "redirect:inbox1.action";
		}
}
