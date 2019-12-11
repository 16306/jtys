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

  public Doctor getAll()
  {
    Doctor doctor = new Doctor();
    doctor.setDoctorId((long) 0);
    if(doctorMapper.getAll() == null)
    {
      return doctor;
    }
    return doctorMapper.getAll();
  }

  public PageInfo<Doctor> getDoctorList(Long doctorGroupId,int page,int limit,int mark)
  {

    if(mark==1) {
      PageHelper.startPage(page, limit);      //分页核心代码
    }
    List<Doctor> list = doctorMapper.getDoctorList(doctorGroupId);
    return new PageInfo<>(list);
  }

  public List<Doctor> DoctorList(Long doctorGroupId)
  {
    return doctorMapper.getDoctorList(doctorGroupId);
  }

  public List<Doctor> getAllDoctorList(Long hospitalId)
  {
    return doctorMapper.getAllDoctorList(hospitalId);
  }
}
