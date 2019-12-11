package com.mapper;

import com.entity.Family;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FamilyMapper {

    int deleteByPrimaryKey(Long familyId);

    int insert(Family record);

    int insertSelective(Family record);

    Family selectByPrimaryKey(Long familyId);

    List<Family> getFamilyList(Long hospitalId,@Param("householderName")String householderName,@Param("householderPhone")String householderPhone);

    List<Family> getAllFamilyList(Long hospitalId);

    Family getAll();

    int updateByPrimaryKeySelective(Family record);

    int updateByPrimaryKey(Family record);
}