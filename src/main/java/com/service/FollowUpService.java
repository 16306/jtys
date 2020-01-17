package com.service;

import com.entity.FollowUp;
import com.mapper.FollowUpMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowUpService {


    @Autowired
    private FollowUpMapper followUpMapper;

    public List<FollowUp> getFollowUpByDoctorId(Long doctorId)
    {
        return followUpMapper.selectByDoctorId(doctorId);

    }

    public List<FollowUp> selectByPrimaryKeyAndDoctorId(Long followUpId,Long doctorId)
    {
        return followUpMapper.selectByPrimaryKeyAndDoctorId( followUpId, doctorId);

    }

    public FollowUp selectByPrimaryKey(Long followUpId)
    {
        return followUpMapper.selectByPrimaryKey(followUpId);

    }

    public int updateByPrimaryKey(FollowUp record)
    {

        return followUpMapper.updateByPrimaryKey(record);
    }

}
