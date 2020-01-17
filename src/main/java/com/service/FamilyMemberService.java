package com.service;

import com.entity.FamilyMember;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.FamilyMemberMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamilyMemberService
{
  @Autowired
  private FamilyMemberMapper familyMemberMapper;

  @Transactional(rollbackFor=Exception.class)
  public int deleteByPrimaryKey(Long familyMemberId)
  {
    return familyMemberMapper.deleteByPrimaryKey(familyMemberId);
  }

  @Transactional(rollbackFor=Exception.class)
  public int insert(FamilyMember record)
  {
    return familyMemberMapper.insert(record);
  }

  /**
   * 得到某家庭的所有家庭成员
   * @param familyId
   * @param page
   * @param limit
   * @param mark
   * @return 一个分页器
   */
  public PageInfo<FamilyMember> getAllMemberList(Long familyId,int page,int limit,int mark)
  {

    if(mark==1) {
      PageHelper.startPage(page, limit);      //分页核心代码
    }
    List<FamilyMember> list = familyMemberMapper.getAllMemberList(familyId);
    return new PageInfo<>(list);
  }

  /**
   * 得到某家庭的所有家庭成员
   * @param familyId
   * @return 列表
   */
  public List<FamilyMember> getAllMember(Long familyId)
  {
    return familyMemberMapper.getAllMemberList(familyId);
  }

  public FamilyMember selectByPrimaryKey(Long familyMemberId)
  {
    return familyMemberMapper.selectByPrimaryKey(familyMemberId);
  }

  /**
   * 得到FamilyMember最新记录
   * @return
   */
  public FamilyMember getLastOne()
  {
    FamilyMember familyMember = new FamilyMember();
    familyMember.setFamilyMemberId((long) 1);
    if(familyMemberMapper.getLastOne() == null)
    {
      return familyMember;
    }
    return familyMemberMapper.getLastOne();
  }

  @Transactional(rollbackFor=Exception.class)
  public int updateByPrimaryKey(FamilyMember record)
  {
    return familyMemberMapper.updateByPrimaryKey(record);
  }
}
