package com.mapper;

import com.entity.Notice;

public interface NoticeMapper {
    int deleteByPrimaryKey(Long noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Long noticeId);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}