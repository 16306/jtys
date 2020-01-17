package com.mapper;

import com.entity.Inspection;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface InspectionMapper {
    int deleteByPrimaryKey(Long inspectionId);

    int insert(Inspection record);

    int insertSelective(Inspection record);

    Inspection selectByPrimaryKey(Long inspectionId);

    Inspection getLastOne();

    Inspection selectByCaseId(Long caseId);

    int updateByPrimaryKeySelective(Inspection record);

    int updateByPrimaryKey(Inspection record);
}