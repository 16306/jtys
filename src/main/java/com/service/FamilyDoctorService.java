package com.service;


import com.entity.FamilyDoctor;
import com.mapper.FamilyDoctorMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamilyDoctorService
{
  @Autowired
  private FamilyDoctorMapper familyDoctorMapper;

  public List<Long> selectByNoContract(Long doctorGroupId)
  {
    List<Long> list = new ArrayList<>();
    for(int i = 0;i < familyDoctorMapper.selectByDoctorGroupId(doctorGroupId).size();i++)
    {
      list.add(familyDoctorMapper.selectByDoctorGroupId(doctorGroupId).get(i).getFamilyId());
    }
    return list;
  }

  public FamilyDoctor selectByFamilyId(Long familyId)
  {
    return familyDoctorMapper.selectByFamilyId(familyId);
  }

  public FamilyDoctor getAll()
  {
    FamilyDoctor familyDoctor = new FamilyDoctor();
    familyDoctor.setFamilyDoctorId((long) 1);
    if(familyDoctorMapper.getAll() == null)
    {
      return familyDoctor;
    }
    return familyDoctorMapper.getAll();
  }

  @Transactional(rollbackFor=Exception.class)
  public int firstInsert(FamilyDoctor familyDoctor)
  {
    return familyDoctorMapper.insert(familyDoctor);
  }

  @Transactional(rollbackFor=Exception.class)
  public int update(FamilyDoctor record)
  {
    return familyDoctorMapper.updateByPrimaryKeyWithBLOBs(record);
  }

  @Transactional(rollbackFor=Exception.class)
  public int delete(Long id)
  {
    return familyDoctorMapper.deleteByPrimaryKey(id);
  }

}
