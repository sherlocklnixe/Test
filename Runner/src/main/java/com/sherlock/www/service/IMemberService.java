package com.sherlock.www.service;

import java.util.List;


import com.sherlock.www.common.exception.MemberServiceException;
import com.sherlock.www.entity.Blackrecord;
import com.sherlock.www.entity.Friendrecord;
import com.sherlock.www.entity.Graderecord;
import com.sherlock.www.entity.Memberinfo;
import com.sherlock.www.entity.Memberspace;
import com.sherlock.www.entity.Pointaction;
import com.sherlock.www.entity.Pointrecord;

public interface IMemberService {
	
	/**
	 * 用户注册
	 * @param Memberinfo	注册信息
	 * @throws MemberServiceException	
	 */
	void registerMemberinfo(Memberinfo Memberinfo) throws MemberServiceException;
	/**
	 * 按照姓名查找用户
	 * @param nickname	姓名
	 * @return	用户信息
	 * @throws MemberServiceException
	 */
	Memberinfo findMemberinfoByName(String nickname) throws MemberServiceException;
	/**
	 * 通过用户名登陆
	 * @param username	用户名
	 * @param passwd	密码
	 * @return	登录用户的信息
	 * @throws MemberServiceException
	 */
	Memberinfo login(String username, String passwd) throws MemberServiceException;
	/**
	 * 退出
	 * @param nickname	用户名
	 * @throws MemberServiceException
	 */
	void logout(String nickname) throws MemberServiceException;
	/**
	 * 查找排名靠前的用户
	 * @param number	靠前的人数
	 * @return	排名靠前的用户的信息
	 * @throws MemberServiceException
	 */
	List<Memberinfo> findMemberinfoByNum(int number) throws MemberServiceException;
	/**
	 * 查找在线用户
	 * @return	在线用户的数量
	 * @throws MemberServiceException
	 */
	int findMemberinfoOnline() throws MemberServiceException;
	/**
	 * 按照积分查找对应的等级
	 * @param point	积分
	 * @return	对应的等级
	 * @throws MemberServiceException
	 */
	Graderecord findMemberinfoLevel(Long point) throws MemberServiceException;
	/**
	 * 保存或更新用户
	 * @param Memberinfo	需要更新的用户
	 * @param oldPasswd		原始密码
	 * @return	更新后的用户的信息
	 * @throws MemberServiceException
	 */
	void saveOrUpDate(Memberinfo Memberinfo, String oldPasswd) throws MemberServiceException;
	/**
	 * 通过提示问题和答案获取密码
	 * @param nickname	用户名	
	 * @param pwdQuestion	提示问题
	 * @param pwdAnswer		提示问题对应的答案
	 * @return	密码
	 * @throws MemberServiceException
	 */
	String getBackPasswd(String nickname, String pwdQuestion, String pwdAnswer) throws MemberServiceException;
	/**
	 * 保存或修改用户信息
	 * @param Memberinfo	用户信息
	 * @throws MemberServiceException
	 */
	void saveOrUpdate(Memberinfo Memberinfo) throws MemberServiceException;
	/**
	 * 保存或修改好友列表
	 * @param selfname	用户名字
	 * @param friendname	好友名字
	 * @throws MemberServiceException
	 */
	void saveOrUpdate(String selfname, String friendname) throws MemberServiceException;
	/**
	 * 查找好友
	 * @param selfname	用户名
	 * @return	好友列表
	 * @throws MemberServiceException
	 */
	List<Friendrecord> listFriend(String selfname) throws MemberServiceException;
	/**
	 * 转移到黑名单
	 * @param selfname	用户名
	 * @param blackname	用户所拉黑的其他会员的名字
	 * @throws MemberServiceException
	 */
	void moveToBlack(String selfname, String blackname) throws MemberServiceException;
	/**
	 * 获取黑名单人员
	 * @param selfname	用户名
	 * @return	名单
	 * @throws MemberServiceException
	 */
	List<Blackrecord> listBlack(String selfname) throws MemberServiceException;
	/**
	 * 查找好友
	 * @param friend	好友名
	 * @return	记录好友的类
	 * @throws MemberServiceException
	 */
	Friendrecord findFriend(String friend) throws MemberServiceException;
	/**
	 * 判断是否有个人空间
	 * @param id	
	 * @return	
	 * @throws MemberServiceException
	 */
	Boolean isMemberspace(String nickname) throws MemberServiceException;
	/**
	 * 添加好友
	 * @param selfName	用户名
	 * @param name_searching
	 * @throws MemberServiceException
	 */
	void moveToFriend(String selfName, String name_searching) throws MemberServiceException;
	/**
	 * 删除黑名单
	 * @param selfName 用户名
	 * @param black	黑名单
	 * @throws MemberServiceException
	 */
	void deleleBlack(String selfName, String black) throws MemberServiceException;
	/**
	 * 删除好友
	 * @param selfName
	 * @param friend
	 * @throws MemberServiceException
	 */
	void deleleFriend(String selfName, String friend) throws MemberServiceException;
	/**
	 * 删除空间
	 * @param id
	 * @throws MemberServiceException
	 */
	void delSpace(Long id) throws MemberServiceException;
	/**
	 * 按照名字查找积分动作
	 * @param actionName
	 * @return
	 * @throws MemberServiceException
	 */
	Pointaction findPointactionByPointAction(String actionName)throws MemberServiceException;
	/**
	 * 保存加积分记录
	 * @param Pointrecord
	 * @throws MemberServiceException
	 */
	void save(Pointrecord Pointrecord) throws MemberServiceException;
	/**
	 * 修改个人空间
	 * @param space
	 * @param Memberinfo
	 * @throws MemberServiceException
	 */
	void saveorupdateMemberspace(Memberspace space, Memberinfo Memberinfo)
					throws MemberServiceException;
	/**
	 * 查找个人空间
	 * @param id
	 * @return
	 * @throws MemberServiceException
	 */
	Memberspace findSpace(Long id) throws MemberServiceException;
	/**
	 * 随机匹配好友
	 * @param id
	 * @return
	 * @throws MemberServiceException
	 */
	long selectIdByName(String nickname) throws MemberServiceException;
	List<Memberinfo> match(Long id) throws MemberServiceException;
	List<Memberinfo> listMemberinfo() throws MemberServiceException;
	List<Memberinfo> findFriends(String ages, String genders,
			String provinceCitys, Long id) throws MemberServiceException ;
}
