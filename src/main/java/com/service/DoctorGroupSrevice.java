package com.service;

import com.entity.DoctorGroup;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DoctorGroupMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorGroupSrevice
{
  @Autowired
  private DoctorGroupMapper doctorGroupMapper;

  @Transactional(rollbackFor=Exception.class)
  public int deleteByPrimaryKey(Long doctorGroupId)
  {
    return doctorGroupMapper.deleteByPrimaryKey(doctorGroupId);
  }

  @Transactional(rollbackFor=Exception.class)
  public int insert(DoctorGroup record)
  {
    return doctorGroupMapper.insert(record);
  }

  public PageInfo<DoctorGroup> getAllDoctorGroupList(Long hospitalId, String name, String groupLeaderName,String serviceArea,int page,int limit,int mark)
  {

    if(mark==1) {
      PageHelper.startPage(page, limit);      //分页核心代码
    }
    List<DoctorGroup> list = doctorGroupMapper.getAllDoctorGroupList(hospitalId,name,groupLeaderName,serviceArea);
    return new PageInfo<>(list);
  }

  public List<DoctorGroup> getAllDoctorGroupList(Long hospitalId, String name, String groupLeaderName,String serviceArea)
  {
    return doctorGroupMapper.getAllDoctorGroupList(hospitalId,name,groupLeaderName,serviceArea);
  }

  public DoctorGroup selectByPrimaryKey(Long familyMemberId)
  {
    return doctorGroupMapper.selectByPrimaryKey(familyMemberId);
  }

  public DoctorGroup getAll()
  {
    DoctorGroup doctorGroup = new DoctorGroup();
    doctorGroup.setDoctorGroupId((long) 1);
    if(doctorGroupMapper.getAll() == null)
    {
      return doctorGroup;
    }
    return doctorGroupMapper.getAll();
  }

  @Transactional(rollbackFor=Exception.class)
  public int updateByPrimaryKey(DoctorGroup record)
  {
    return doctorGroupMapper.updateByPrimaryKey(record);
  }
}
