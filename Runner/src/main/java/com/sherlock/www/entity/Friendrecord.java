package com.sherlock.www.entity;

/**
 * Friendrecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */
//记录好友的一个类
public class Friendrecord implements java.io.Serializable {

	// Fields

	private Long id;
	//用户名字
	private String selfname;
	//用户的好友名字
	private String friendname;

	// Constructors

	/** default constructor */
	public Friendrecord() {
	}

	/** full constructor */
	public Friendrecord(String selfname, String friendname) {
		this.selfname = selfname;
		this.friendname = friendname;
	}
	
	public Friendrecord(Long id, String selfname, String friendname) {
		super();
		this.id = id;
		this.selfname = selfname;
		this.friendname = friendname;
	}

	// Property accessors
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getSelfname() {
		return this.selfname;
	}

	public void setSelfname(String selfname) {
		this.selfname = selfname;
	}
	public String getFriendname() {
		return this.friendname;
	}

	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}

	@Override
	public String toString() {
		return "Friendrecord [id=" + id + ", selfname=" + selfname + ", friendname=" + friendname + "]";
	}

}