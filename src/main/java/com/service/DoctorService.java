package com.service;

import com.entity.Doctor;
import com.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService
{
  @Autowired
  private DoctorMapper doctorMapper;

  public Doctor selectByPrimaryKey(Long doctorId)
  {
    return doctorMapper.selectByPrimaryKey(doctorId);
  }
}
