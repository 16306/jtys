package com.mapper;

import com.entity.FileImg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FileImgMapper {

    FileImg findByUuid(String uuid);

    int insert(FileImg record);

    int insertSelective(FileImg record);
}