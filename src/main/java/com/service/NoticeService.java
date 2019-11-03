package com.service;

import com.entity.Notice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.NoticeMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticeService
{

  @Autowired
  private NoticeMapper noticeMapper;

  public Notice selectByPrimaryKey(Long noticeId)
  {
    return noticeMapper.selectByPrimaryKey(noticeId);
  }

  public Notice getAll()
  {
    return noticeMapper.getAll();
  }


  public PageInfo<Notice> getNoticeList(Long hospitalId, String title, String publisher,int page,int limit,int mark) {

    if(mark==1) {
      PageHelper.startPage(page, limit);      //分页核心代码
    }
    List<Notice> list = noticeMapper.getNoticeList(hospitalId,title,publisher);
    PageInfo<Notice> pageInfo = new PageInfo<>(list);
    return pageInfo;
  }

  @Transactional
  public void batchDeleteNotice(List<Long> ids)
  {
    noticeMapper.batchDeleteNotice(ids);
  }

  @Transactional
  public int deleteByPrimaryKey(Long noticeId)
  {
    return noticeMapper.deleteByPrimaryKey(noticeId);
  }

  @Transactional
  public int insert(Notice record)
  {
    return noticeMapper.insert(record);
  }

  @Transactional
  public int updateByPrimaryKeySelective(Notice record)
  {
    return noticeMapper.updateByPrimaryKeySelective(record);
  }
}
