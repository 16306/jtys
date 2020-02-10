package com.service;

import com.entity.Case;
import com.entity.Hospitalization;
import com.entity.Inspection;
import com.entity.Medication;
import com.entity.Surgery;
import com.mapper.CaseMapper;
import com.mapper.HospitalizationMapper;
import com.mapper.InspectionMapper;
import com.mapper.MedicationMapper;
import com.mapper.SurgeryMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CaseService
{

  @Autowired
  private HospitalizationMapper hospitalizationMapper;

  @Autowired
  private MedicationMapper medicationMapper;

  @Autowired
  private SurgeryMapper surgeryMapper;

  @Autowired
  private CaseMapper caseMapper;

  @Autowired
  private InspectionMapper inspectionMapper;


  public List<Case> getAllCase(String cardId)
  {
    List<Case> cases = caseMapper.selectByCardId(cardId);
    if(null != cases)
    {
      return cases;
    }
    return null;
  }


  public List<Hospitalization> getAllHospitalization(String cardId)
  {
    List<Case> cases = caseMapper.selectByCardId(cardId);
    List<Hospitalization> hospitalizations = new ArrayList<>();
    if(null != cases)
    {
      for(Case item : cases)
      {
        if(item.getType().charAt(0) == '1')
        {
          hospitalizations.add(hospitalizationMapper.selectByCaseId(item.getCaseId()));
        }
      }
    }
    return hospitalizations;
  }

  /**
   * 查找用户的检查报告
   * @param cardId 身份证号
   * @return List<Inspection>
   */
  public List<Inspection> getAllInspection(String cardId)
  {
    List<Case> cases = caseMapper.selectByCardId(cardId);
    List<Inspection> inspection = new ArrayList<>();
    if(null != cases)
    {
      for(Case item : cases)
      {
        if(item.getType().charAt(1) == '1')
        {
          inspection.add(inspectionMapper.selectByCaseId(item.getCaseId()));
        }
      }
    }
    return inspection;
  }



  public List<Medication> getAllMedication(String cardId)
  {
    List<Case> cases = caseMapper.selectByCardId(cardId);
    List<Medication> medications = new ArrayList<>();
    if(null != cases)
    {
      for(Case item : cases)
      {
        if(item.getType().charAt(2) == '1')
        {
          medications.add(medicationMapper.selectByCaseId(item.getCaseId()));
        }
      }
    }
    return medications;
  }

  public List<Surgery> getAllSurgery(String cardId)
  {
    List<Case> cases = caseMapper.selectByCardId(cardId);
    List<Surgery> surgeries = new ArrayList<>();
    if(null != cases)
    {
      for(Case item : cases)
      {
        if(item.getType().charAt(3) == '1')
        {
          surgeries.add(surgeryMapper.selectByCaseId(item.getCaseId()));
        }
      }
    }
    return surgeries;
  }

  private void setResult(Map<String,Object> result,int i,Long caseId,int control)
  {
    if(control == 1)
    {
      switch (i)
      {
        case 0:
          result.put("hospitalization",hospitalizationMapper.selectByCaseId(caseId));
          break;
        case 1:
          result.put("inspection",inspectionMapper.selectByCaseId(caseId));
          break;
        case 2:
          result.put("medication",medicationMapper.selectByCaseId(caseId));
          break;
        case 3:
          result.put("surgery",surgeryMapper.selectByCaseId(caseId));
          break;
      }
    }
    else
    {
      switch (i)
      {
        case 0:
          result.put("hospitalization",null);
          break;
        case 1:
          result.put("inspection",null);
          break;
        case 2:
          result.put("medication",null);
          break;
        case 3:
          result.put("surgery",null);
          break;
      }
    }
  }

  public Map<String,Object> getCaseByCaseId(Long caseId)
  {
    Map<String,Object> result = new HashMap<>();
    Case item = caseMapper.selectByPrimaryKey(caseId);
    result.put("case",item);
    for(int i = 0; i < item.getType().length(); i++)
    {
      if(item.getType().charAt(i) == '1')
      {
        setResult(result,i,caseId,1);
      }
      else
      {
        setResult(result,i,caseId,0);
      }

    }
    return result;
  }

  /**
   * 插入病例记录
   * @param record Case
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int createCase(Case record)
  {
    Case item = caseMapper.getLastOne();
    if(null == item)
    {
      record.setCaseId((long)0);
    }
    else
    {
      record.setCaseId(item.getCaseId()+1);
    }
    return caseMapper.insert(record);
  }

  /**
   * 插入检查记录
   * @param record Inspection
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int createInspection(Inspection record)
  {
    Inspection item = inspectionMapper.getLastOne();
    if(null == item)
    {
      record.setInspectionId((long)0);
    }
    else
    {
      record.setInspectionId(item.getInspectionId()+1);
    }
    return inspectionMapper.insert(record);
  }

  /**
   * 插入住院记录
   * @param record Hospitalization
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int createHospitalization(Hospitalization record)
  {
    Hospitalization item = hospitalizationMapper.getLastOne();
    if(null == item)
    {
      record.setHospitalizationId((long)0);
    }
    else
    {
      record.setHospitalizationId(item.getHospitalizationId()+1);
    }
    return hospitalizationMapper.insert(record);
  }

  /**
   * 插入用药记录
   * @param record Medication
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int createMedication(Medication record)
  {
    Medication item = medicationMapper.getLastOne();
    if(null == item)
    {
      record.setMedicationId((long)0);
    }
    else
    {
      record.setMedicationId(item.getMedicationId()+1);
    }
    return medicationMapper.insert(record);
  }

  /**
   * 插入手术记录
   * @param record Surgery
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int createSurgery(Surgery record)
  {
    Surgery item = surgeryMapper.getLastOne();
    if(null == item)
    {
      record.setSurgeryId((long)0);
    }
    else
    {
      record.setSurgeryId(item.getSurgeryId()+1);
    }
    return surgeryMapper.insert(record);
  }

  /**
   * 更新病例记录
   * @param record Case
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int updateCase(Case record)
  {
    if(null != caseMapper.selectByPrimaryKey(record.getCaseId()))
      return caseMapper.updateByPrimaryKey(record);
    return 0;
  }

  /**
   * 更新检查记录
   * @param record Inspection
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int updateInspection(Inspection record)
  {
    if(null != inspectionMapper.selectByPrimaryKey(record.getCaseId()))
      return inspectionMapper.updateByPrimaryKey(record);
    return 0;
  }

  /**
   * 更新住院记录
   * @param record Hospitalization
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int updateHospitalization(Hospitalization record)
  {
    if(null != hospitalizationMapper.selectByPrimaryKey(record.getCaseId()))
      return hospitalizationMapper.updateByPrimaryKey(record);
    return 0;
  }

  /**
   * 更新用药记录
   * @param record Medication
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int updateMedication(Medication record)
  {
    if(null != medicationMapper.selectByPrimaryKey(record.getCaseId()))
      return medicationMapper.updateByPrimaryKey(record);
    return 0;
  }

  /**
   * 更新手术记录
   * @param record Surgery
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int updateSurgery(Surgery record)
  {
    if(null != surgeryMapper.selectByPrimaryKey(record.getCaseId()))
      return surgeryMapper.updateByPrimaryKey(record);
    return 0;
  }

  /**
   * delete病例记录
   * @param record Case
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int deleteCase(Case record)
  {
    if(null != caseMapper.selectByPrimaryKey(record.getCaseId()))
      return caseMapper.deleteByPrimaryKey(record.getCaseId());
    return 0;
  }

  /**
   * delete检查记录
   * @param record Inspection
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int deleteInspection(Inspection record)
  {
    if(null != inspectionMapper.selectByPrimaryKey(record.getCaseId()))
      return inspectionMapper.deleteByPrimaryKey(record.getCaseId());
    return 0;
  }

  /**
   * delete住院记录
   * @param record Hospitalization
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int deleteHospitalization(Hospitalization record)
  {
    if(null != hospitalizationMapper.selectByPrimaryKey(record.getCaseId()))
      return hospitalizationMapper.deleteByPrimaryKey(record.getCaseId());
    return 0;
  }

  /**
   * delete用药记录
   * @param record Medication
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int deleteMedication(Medication record)
  {
    if(null != medicationMapper.selectByPrimaryKey(record.getCaseId()))
      return medicationMapper.deleteByPrimaryKey(record.getCaseId());
    return 0;
  }

  /**
   * delete手术记录
   * @param record Surgery
   * @return int
   */
  @Transactional(rollbackFor=Exception.class)
  public int deleteSurgery(Surgery record)
  {
    if(null != surgeryMapper.selectByPrimaryKey(record.getCaseId()))
      return surgeryMapper.deleteByPrimaryKey(record.getCaseId());
    return 0;
  }

}
