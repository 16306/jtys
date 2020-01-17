package com.service;

import com.entity.Doctor;
import com.entity.Family;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DoctorMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorService
{
  @Autowired
  private DoctorMapper doctorMapper;

  @Transactional(rollbackFor=Exception.class)
  public int deleteByPrimaryKey(Long doctorId)
  {
    return doctorMapper.deleteByPrimaryKey(doctorId);
  }

  @Transactional(rollbackFor=Exception.class)
  public int insert(Doctor record)
  {
    return doctorMapper.insert(record);
  }

  public Doctor selectByPrimaryKey(Long familyId)
  {
    return doctorMapper.selectByPrimaryKey(familyId);
  }

  @Transactional(rollbackFor=Exception.class)
  public int updateByPrimaryKey(Doctor record)
  {
    return doctorMapper.updateByPrimaryKey(record);
  }

  /**
   * 查找最后插入的医生，若无则返回一个Doctor对象DoctorId为1
   * @return
   */
  public Doctor getLastOne()
  {
    Doctor doctor = new Doctor();
    doctor.setDoctorId((long) 0);
    if(doctorMapper.getLastOne() == null)
    {
      return doctor;
    }
    return doctorMapper.getLastOne();
  }

  /**
   * 查找所有相对应doctorGroupId的医生
   * @param doctorGroupId
   * @param page
   * @param limit
   * @param mark
   * @return 一个分页器
   */
  public PageInfo<Doctor> getDoctorList(Long doctorGroupId,int page,int limit,int mark)
  {

    if(mark==1) {
      PageHelper.startPage(page, limit);      //分页核心代码
    }
    List<Doctor> list = doctorMapper.getDoctorList(doctorGroupId);
    return new PageInfo<>(list);
  }

  /**
   * 查找所有相对应doctorGroupId的医生
   * @param doctorGroupId
   * @return 医生列表
   */
  public List<Doctor> DoctorList(Long doctorGroupId)
  {
    return doctorMapper.getDoctorList(doctorGroupId);
  }

  public List<Doctor> getAllDoctorList(Long hospitalId)
  {
    return doctorMapper.getAllDoctorList(hospitalId);
  }
}
