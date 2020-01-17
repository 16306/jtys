package com.mapper;

import com.entity.FamilyMember;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FamilyMemberMapper {

    int deleteByPrimaryKey(Long familyMemberId);

    int insert(FamilyMember record);

    int insertSelective(FamilyMember record);

    FamilyMember selectByPrimaryKey(Long familyMemberId);

    FamilyMember selectByCardId(String cardId);

    List<FamilyMember> getAllMemberList(Long familyId);

    FamilyMember getLastOne();

    int updateByPrimaryKeySelective(FamilyMember record);

    int updateByPrimaryKey(FamilyMember record);
}