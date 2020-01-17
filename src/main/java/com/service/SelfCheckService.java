package com.service;

import com.mapper.MeasurementMapper;
import com.mapper.SelfCheckMapper;
import com.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfCheckService
{
  @Autowired
  private SelfCheckMapper selfCheckMapper;

  @Autowired
  private FamilyMemberService familyMemberService;

  @Autowired
  private MeasurementMapper measurementMapper;

  @Autowired
  private DeviceMapper deviceMapper;



}
