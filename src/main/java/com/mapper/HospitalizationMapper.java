package com.mapper;

import com.entity.Hospitalization;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HospitalizationMapper {
    int deleteByPrimaryKey(Long hospitalizationId);

    int insert(Hospitalization record);

    int insertSelective(Hospitalization record);

    Hospitalization selectByPrimaryKey(Long hospitalizationId);

    Hospitalization getLastOne();

    Hospitalization selectByCaseId(Long caseId);

    int updateByPrimaryKeySelective(Hospitalization record);

    int updateByPrimaryKey(Hospitalization record);
}