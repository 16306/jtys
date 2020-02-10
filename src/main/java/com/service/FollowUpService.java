package com.service;

import com.entity.FamilyMember;
import com.entity.FollowUp;
import com.entity.User;
import com.mapper.FamilyMemberMapper;
import com.mapper.FollowUpMapper;
import com.util.FindUser;
import com.util.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FollowUpService {


    @Autowired
    private FollowUpMapper followUpMapper;

    @Autowired
    private FamilyMemberMapper familyMemberMapper;


    public Map<Object,Object> setResult(Object FollowUpId,Object Content,Object Accompanying,Object Time,Object Type,Object Status,Object HealthAssessment,Object Name)
    {
        Map<Object, Object> result = new HashMap<>();
        result.put("followUpId",FollowUpId);
        result.put("content",Content);
        result.put("accompanying",Accompanying);
        result.put("time",Time);
        result.put("type",Type);
        result.put("status",Status);
        result.put("healthAssessment",HealthAssessment);
        result.put("name",Name);
        return result;
    }

    public MyPageHelper<Map<Object, Object>> getFollowUpByDoctorIdAndName(int page,int limit, String name)
    {
        FindUser findUser = new FindUser();
        User user = findUser.getuser();
        Long doctorId= user.getDoctorId();
        List<FollowUp> followUps = followUpMapper.selectByDoctorId(doctorId);
        List<Map<Object, Object>> list= new ArrayList<Map<Object, Object>>();
        Map<Object, Object> result = null;
        for(FollowUp followUp:followUps)
        {
            FamilyMember familyMember = familyMemberMapper.selectByPrimaryKey(followUp.getFamilyMemberId());
            if(null != familyMember)
            {
                if(name.equals("null"))
                {
                    result = setResult(followUp.getFollowUpId(),followUp.getContent(),followUp.getAccompanying(),followUp.getTime(),followUp.getType(),followUp.getStatus(),followUp.getHealthAssessment(),familyMember.getName());
                    list.add(result);
                }
                else if(familyMember.getName().matches(".*"+name+".*"))
                {
                    result = setResult(followUp.getFollowUpId(),followUp.getContent(),followUp.getAccompanying(),followUp.getTime(),followUp.getType(),followUp.getStatus(),followUp.getHealthAssessment(),familyMember.getName());
                    list.add(result);
                }
            }
        }
        return new MyPageHelper<>(list, page, limit);
    }

    public List<FollowUp> selectByPrimaryKeyAndDoctorId(Long followUpId,Long doctorId)
    {
        return followUpMapper.selectByPrimaryKeyAndDoctorId(followUpId, doctorId);

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
