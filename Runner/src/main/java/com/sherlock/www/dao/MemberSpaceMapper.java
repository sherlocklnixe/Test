package com.sherlock.www.dao;

import com.sherlock.www.entity.Memberspace;

public interface MemberSpaceMapper{
	 Memberspace selectSpace(long id);
	 void insertSpace(Memberspace space);
}