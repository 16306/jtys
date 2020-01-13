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
public class DoctorGroupService
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

  /**
   * 查找所有相对应hospitalId的医生组
   * @param hospitalId
   * @param name
   * @param groupLeaderName
   * @param serviceArea
   * @param page
   * @param limit
   * @param mark
   * @return 一个分页器
   */
  public PageInfo<DoctorGroup> getAllDoctorGroupList(Long hospitalId, String name, String groupLeaderName,String serviceArea,int page,int limit,int mark)
  {

    if(mark==1) {
      PageHelper.startPage(page, limit);      //分页核心代码
    }
    List<DoctorGroup> list = doctorGroupMapper.getAllDoctorGroupList(hospitalId,name,groupLeaderName,serviceArea);
    return new PageInfo<>(list);
  }

  /**
   * 查找所有相对应hospitalId的医生组，现在没用到
   * @param hospitalId
   * @param name
   * @param groupLeaderName
   * @param serviceArea
   * @return 一个医生组列表
   */
  public List<DoctorGroup> getAllDoctorGroupList(Long hospitalId, String name, String groupLeaderName,String serviceArea)
  {
    return doctorGroupMapper.getAllDoctorGroupList(hospitalId,name,groupLeaderName,serviceArea);
  }

  public DoctorGroup selectByPrimaryKey(Long familyMemberId)
  {
    return doctorGroupMapper.selectByPrimaryKey(familyMemberId);
  }

  /**
   * 查找最后插入的医生组，若无则返回一个DoctorGroup对象DoctorGroupId为1
   * @return
   */
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
