package com.service;

import com.entity.Measurement;
import com.entity.SelfCheck;
import com.mapper.DeviceMapper;
import com.mapper.MeasurementMapper;
import com.mapper.SelfCheckMapper;
import com.util.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  private List<SelfCheck> getAllSelfCheckByCardId(String cardId)
  {
    return selfCheckMapper.selectByCardId(cardId);
  }

  public MyPageHelper<Map<String,Object>> getMeasurementCheckByCardId(Long measurementId,String cardId,int page,int limit)
  {
    List<SelfCheck> selfChecks = getAllSelfCheckByCardId(cardId);
    Measurement measurement = measurementMapper.selectByPrimaryKey(measurementId);
    List<Map<String, Object>> list= new ArrayList<Map<String, Object>>();
    Map<String, Object> result = new HashMap<>();
    for(SelfCheck selfCheck : selfChecks)
    {
      if(selfCheck.getMeasurementId().equals(measurementId))
      {
        result.put("measurement",measurement.getMeasurementType());
        result.put("measurementTime",selfCheck.getMeasurementTime());
        result.put("measurementResult",selfCheck.getMeasurementResult());
        result.put("measurementUnit",measurement.getUnit());
        result.put("selfCheckId",selfCheck.getSelfCheckId());
        list.add(result);
      }
    }
    return new MyPageHelper<>(list, page, limit);
  }

}
