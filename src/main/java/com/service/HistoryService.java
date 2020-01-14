package com.service;

import com.entity.AllergyHistory;
import com.entity.FamilyHistory;
import com.entity.ObstericalHistory;
import com.entity.OperationHistory;
import com.entity.PastHistory;
import com.mapper.AllergyHistoryMapper;
import com.mapper.FamilyHistoryMapper;
import com.mapper.ObstericalHistoryMapper;
import com.mapper.OperationHistoryMapper;
import com.mapper.PastHistoryMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistoryService
{

  @Autowired
  private AllergyHistoryMapper allergyHistoryMapper;

  @Autowired
  private FamilyHistoryMapper familyHistoryMapper;

  @Autowired
  private ObstericalHistoryMapper obstericalHistoryMapper;

  @Autowired
  private OperationHistoryMapper operationHistoryMapper;

  @Autowired
  private PastHistoryMapper pastHistoryMapper;

  public List<AllergyHistory> getAllergyHistory(String cardId)
  {
    List<AllergyHistory> allergyHistories = allergyHistoryMapper.selectByCardId(cardId);
    if(null != allergyHistories)
    {
      return allergyHistories;
    }
    return null;
  }

  public List<FamilyHistory> getFamilyHistory(String cardId)
  {
    List<FamilyHistory> familyHistories = familyHistoryMapper.selectByCardId(cardId);
    if(null != familyHistories)
    {
      return familyHistories;
    }
    return null;
  }

  public List<ObstericalHistory> getObstericalHistory(String cardId)
  {
    List<ObstericalHistory> obstericalHistories = obstericalHistoryMapper.selectByCardId(cardId);
    if(null != obstericalHistories)
    {
      return obstericalHistories;
    }
    return null;
  }

  public List<OperationHistory> getOperationHistory(String cardId)
  {
    List<OperationHistory> operationHistories = operationHistoryMapper.selectByCardId(cardId);
    if(null != operationHistories)
    {
      return operationHistories;
    }
    return null;
  }

  public List<PastHistory> getPastHistory(String cardId)
  {
    List<PastHistory> pastHistories = pastHistoryMapper.selectByCardId(cardId);
    if(null != pastHistories)
    {
      return pastHistories;
    }
    return null;
  }

  @Transactional(rollbackFor=Exception.class)
  public int createAllergyHistory(AllergyHistory record)
  {
    AllergyHistory item = allergyHistoryMapper.getAll();
    if(null == item)
    {
      record.setAllergyId((long)0);
    }
    else
    {
      record.setAllergyId(item.getAllergyId()+1);
    }
    return allergyHistoryMapper.insert(record);
  }

  @Transactional(rollbackFor=Exception.class)
  public int createFamilyHistory(FamilyHistory record)
  {
    FamilyHistory item = familyHistoryMapper.getAll();
    if(null == item)
    {
      record.setFamilyHistoryId((long)0);
    }
    else
    {
      record.setFamilyHistoryId(item.getFamilyHistoryId()+1);
    }
    return familyHistoryMapper.insert(record);
  }

  @Transactional(rollbackFor=Exception.class)
  public int createObstericalHistory(ObstericalHistory record)
  {
    ObstericalHistory item = obstericalHistoryMapper.getAll();
    if(null == item)
    {
      record.setObstericalId((long)0);
    }
    else
    {
      record.setObstericalId(item.getObstericalId()+1);
    }
    return obstericalHistoryMapper.insert(record);
  }

  @Transactional(rollbackFor=Exception.class)
  public int createOperationHistory(OperationHistory record)
  {
    OperationHistory item = operationHistoryMapper.getAll();
    if(null == item)
    {
      record.setOperationId((long)0);
    }
    else
    {
      record.setOperationId(item.getOperationId()+1);
    }
    return operationHistoryMapper.insert(record);
  }


  @Transactional(rollbackFor=Exception.class)
  public int createPastHistory(PastHistory record)
  {
    PastHistory item = pastHistoryMapper.getAll();
    if(null == item)
    {
      record.setPastId((long)0);
    }
    else
    {
      record.setPastId(item.getPastId()+1);
    }
    return pastHistoryMapper.insert(record);
  }

}
