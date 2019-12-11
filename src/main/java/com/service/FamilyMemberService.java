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

  public PageInfo<FamilyMember> getAllMemberList(Long familyId,int page,int limit,int mark)
  {

    if(mark==1) {
      PageHelper.startPage(page, limit);      //分页核心代码
    }
    List<FamilyMember> list = familyMemberMapper.getAllMemberList(familyId);
    return new PageInfo<>(list);
  }

  public List<FamilyMember> getAllMember(Long familyId)
  {
    return familyMemberMapper.getAllMemberList(familyId);
  }

  public FamilyMember selectByPrimaryKey(Long familyMemberId)
  {
    return familyMemberMapper.selectByPrimaryKey(familyMemberId);
  }

  public FamilyMember getAll()
  {
    FamilyMember familyMember = new FamilyMember();
    familyMember.setFamilyMemberId((long) 1);
    if(familyMemberMapper.getAll() == null)
    {
      return familyMember;
    }
    return familyMemberMapper.getAll();
  }

  @Transactional(rollbackFor=Exception.class)
  public int updateByPrimaryKey(FamilyMember record)
  {
    return familyMemberMapper.updateByPrimaryKey(record);
  }
}
