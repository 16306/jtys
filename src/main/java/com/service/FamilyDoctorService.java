package com.service;


import com.entity.Doctor;
import com.entity.FamilyDoctor;
import com.entity.User;
import com.mapper.FamilyDoctorMapper;
import com.util.FindUser;
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

  @Autowired
  private DoctorService doctorService;


  /**
   * 查找未签约的家庭
   * @param doctorGroupId
   * @return
   */
  public List<Long> selectByNoContract(Long doctorGroupId)
  {
    List<Long> list = new ArrayList<>();
    for(int i = 0;i < familyDoctorMapper.selectByDoctorGroupId(doctorGroupId).size();i++)
    {
      list.add(familyDoctorMapper.selectByDoctorGroupId(doctorGroupId).get(i).getFamilyId());
    }
    return list;
  }

  public List<FamilyDoctor> selectByDoctorGroupId(Long doctorGroupId)
  {
    List<FamilyDoctor> list = familyDoctorMapper.selectByDoctorGroupId(doctorGroupId);
    return list;
  }

  public List<FamilyDoctor> getFamilyDoctor()
  {
    FindUser findUser = new FindUser();
    User user = findUser.getuser();
    Long doctorId= user.getDoctorId();

    Doctor doctor= doctorService.selectByPrimaryKey(doctorId);

    Long doctorGroupId = doctor.getDoctorGroupId();

    List<FamilyDoctor> familyDoctorList = selectByDoctorGroupId(doctorGroupId);
    return familyDoctorList;
  }

  /**
   * 查找家庭
   * @param familyId
   * @return
   */
  public FamilyDoctor selectByFamilyId(Long familyId)
  {
    return familyDoctorMapper.selectByFamilyId(familyId);
  }

  /**
   * 得到familydoctor表的最后一条记录
   * @return
   */
  public FamilyDoctor getLastOne()
  {
    FamilyDoctor familyDoctor = new FamilyDoctor();
    familyDoctor.setFamilyDoctorId((long) 1);
    if(familyDoctorMapper.getLastOne() == null)
    {
      return familyDoctor;
    }
    return familyDoctorMapper.getLastOne();
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
