package com.service;


import com.entity.Measurement;
import com.entity.Threshold;
import com.mapper.MeasurementMapper;
import com.mapper.ThresholdMapper;
import com.util.MyPageHelper;
import com.util.SetData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ThresholdService
{

  @Autowired
  private ThresholdMapper thresholdMapper;

  @Autowired
  private MeasurementMapper measurementMapper;

  public Map<String,Object> selectByCardId(String cardId,int page,int limit)
  {
    List<Threshold> thresholds = thresholdMapper.selectByCardId(cardId);
    List<Map<String, Object>> list= new ArrayList<Map<String, Object>>();
    if(null != thresholds)
    {
      for(Threshold threshold:thresholds)
      {
        Map<String, Object> result = new HashMap<>();
        Measurement measurement = measurementMapper.selectByPrimaryKey(threshold.getMeasurementId());
        result.put("thresholdId",threshold.getId());
        result.put("measurementType",threshold.getMeasurementType());
        result.put("presetValue",threshold.getPresetValue());
        result.put("cardId",threshold.getCardId());
        result.put("measurementId",threshold.getMeasurementId());
        result.put("code",threshold.getCode());
        result.put("unit",measurement.getUnit());
        list.add(result);
      }
      return SetData.getStringObjectMap(new MyPageHelper<>(list, page, limit));
    }
    return SetData.returnNull();
  }

  public Threshold selectByPrimaryKey(Long id)
  {
    return thresholdMapper.selectByPrimaryKey(id);
  }

  @Transactional
  public int insert(Threshold threshold)
  {
    threshold.setMeasurementId(Long.parseLong(threshold.getMeasurementType()));
    Measurement measurement = measurementMapper.selectByPrimaryKey(threshold.getMeasurementId());
    threshold.setMeasurementType(measurement.getMeasurementType());
    Threshold last = thresholdMapper.getLastOne();
    if(null == last)
    {
      threshold.setId((long)0);
      return thresholdMapper.insert(threshold);
    }
    else
    {
      threshold.setId(last.getId() + 1);
      return thresholdMapper.insert(threshold);
    }
  }

  @Transactional
  public int update(Threshold threshold)
  {
    threshold.setMeasurementId(Long.parseLong(threshold.getMeasurementType()));
    Measurement measurement = measurementMapper.selectByPrimaryKey(threshold.getMeasurementId());
    threshold.setMeasurementType(measurement.getMeasurementType());
    return thresholdMapper.updateByPrimaryKeySelective(threshold);
  }

  @Transactional
  public int delete(Long id)
  {
    return thresholdMapper.deleteByPrimaryKey(id);
  }

}
