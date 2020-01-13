package com.service;

import com.entity.Family;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.FamilyMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamilyService
{
  @Autowired
  private FamilyMapper familyMapper;

  @Autowired
  private FamilyMemberService familyMemberService;

  @Transactional(rollbackFor=Exception.class)
  public int deleteByPrimaryKey(Long familyId)
  {
    return familyMapper.deleteByPrimaryKey(familyId);
  }

  @Transactional(rollbackFor=Exception.class)
  public int insert(Family record)
  {
    return familyMapper.insert(record);
  }

  public Family selectByPrimaryKey(Long familyId)
  {
    return familyMapper.selectByPrimaryKey(familyId);
  }

  @Transactional(rollbackFor=Exception.class)
  public int updateByPrimaryKey(Family record)
  {
    return familyMapper.updateByPrimaryKey(record);
  }

  public Family getAll()
  {
    Family family = new Family();
    family.setFamilyId((long) 0);
    if(familyMapper.getAll() == null)
    {
      return family;
    }
    return familyMapper.getAll();
  }

  /**
   * 查找所有相对应hospitalId的家庭
   * @param hospitalId
   * @param householderName
   * @param householderPhone
   * @param page
   * @param limit
   * @param mark
   * @return 一个分页器
   */
  public PageInfo<Family> getFamilyList(Long hospitalId, String householderName, String householderPhone,int page,int limit,int mark)
  {

    if(mark==1) {
      PageHelper.startPage(page, limit);      //分页核心代码
    }
    List<Family> list = familyMapper.getFamilyList(hospitalId,householderName,householderPhone);
    for(Family family : list)
    {
      int population = familyMemberService.getAllMember(family.getFamilyId()).size();
      family.setPopulation(population);
      updateByPrimaryKey(family);
    }
    return new PageInfo<>(list);
  }

  /**
   * 得到一个医院的所有家庭
   * @param hospitalId
   * @return 列表
   */
  public List<Family> getAllFamilyList(Long hospitalId)
  {
    return familyMapper.getAllFamilyList(hospitalId);
  }




}
