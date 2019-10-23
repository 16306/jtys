package com.mapper;

import com.entity.FamilyMember;

public interface FamilyMemberMapper {
    int deleteByPrimaryKey(Long familyMemberId);

    int insert(FamilyMember record);

    int insertSelective(FamilyMember record);

    FamilyMember selectByPrimaryKey(Long familyMemberId);

    int updateByPrimaryKeySelective(FamilyMember record);

    int updateByPrimaryKey(FamilyMember record);
}