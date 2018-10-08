package com.sherlock.www.entity;

import java.util.Date;


/**
 * Messagerecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class Messagerecord implements java.io.Serializable {

	// Fields

	private Long id;
	//发送者
	private String sender;
	//接收者
	private String receiver;
	//发送时间
	private Date senddate;
	//信息主题
	private String title;
	//信息内容
	private String content;
	//发送状态	0：发送成功但未删除	1：发送成功且删除
	private Long senderstatus;
	//接收状态	0：成功接收但未删除	1：成功接收且删除
	private Long receiverstatus;
	//信息阅读状态	0：未读	1：已读
	private Long status;

	// Constructors

	/** default constructor */
	public Messagerecord() {
	}

	/** minimal constructor */
	public Messagerecord(String sender, String receiver, Date senddate,
			String title, String content) {
		this.sender = sender;
		this.receiver = receiver;
		this.senddate = senddate;
		this.title = title;
		this.content = content;
	}

	/** full constructor */
	public Messagerecord(String sender, String receiver, Date senddate,
			String title, String content, Long senderstatus,
			Long receiverstatus, Long status) {
		this.sender = sender;
		this.receiver = receiver;
		this.senddate = senddate;
		this.title = title;
		this.content = content;
		this.senderstatus = senderstatus;
		this.receiverstatus = receiverstatus;
		this.status = status;
	}

	// Property accessors
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Date getSenddate() {
		return this.senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Long getSenderstatus() {
		return this.senderstatus;
	}

	public void setSenderstatus(Long senderstatus) {
		this.senderstatus = senderstatus;
	}
	public Long getReceiverstatus() {
		return this.receiverstatus;
	}

	public void setReceiverstatus(Long receiverstatus) {
		this.receiverstatus = receiverstatus;
	}
	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Messagerecord [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", senddate=" + senddate
				+ ", title=" + title + ", content=" + content + ", senderstatus=" + senderstatus + ", receiverstatus="
				+ receiverstatus + ", status=" + status + "]";
	}
	
}