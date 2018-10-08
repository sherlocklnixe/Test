package com.sherlock.www.dao;


import java.util.List;

import com.sherlock.www.entity.Blackrecord;

import tk.mybatis.mapper.common.Mapper;

public interface BlackRecordMapper {
		List<Blackrecord> selectBlackrecord(String selfname);
		void addBlack(String selfname,String blackname);
}