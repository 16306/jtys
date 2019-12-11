package com.mapper;

import com.entity.Notice;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NoticeMapper {
    int deleteByPrimaryKey(Long noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Long noticeId);

    Notice getAll();

    void batchDeleteNotice(List<Long> ids);

    List<Notice> getNoticeList(Long hospitalId,@Param("title")String title,@Param("publisher")String publisher);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);
}