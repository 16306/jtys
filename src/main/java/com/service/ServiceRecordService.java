package com.service;

import com.entity.*;
import com.mapper.DoctorGroupMapper;
import com.mapper.FamilyMapper;
import com.mapper.FamilyMemberMapper;
import com.mapper.ServiceRecordMapper;
import com.util.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceRecordService {
    @Autowired
    private ServiceRecordMapper serviceRecordMapper;

    @Autowired
    private FamilyMemberMapper familyMemberMapper;

    @Autowired
    private FamilyMapper familyMapper;

    @Autowired
    private DoctorGroupMapper doctorGroupMapper;


    /**
     * 处理数据
     *
     * @param familyMemberName
     * @param familyHouseholderName
     * @param doctorGroupLeaderName
     * @param time
     * @param type
     * @param content
     * @param evaluation
     * @return
     */
    public Map<Object, Object> setResult(Object familyMemberName, Object familyHouseholderName, Object doctorGroupLeaderName, Object time, Object type, Object content, Object evaluation) {
        Map<Object, Object> result = new HashMap<>();
        result.put("familyMemberName", familyMemberName);
        result.put("familyHouseholderName", familyHouseholderName);
        result.put("doctorGroupLeaderName", doctorGroupLeaderName);
        result.put("time", time);
        result.put("type", type);
        result.put("content", content);
        result.put("evaluation", evaluation);
        return result;
    }


    /**
     * 查找某一医院的服务记录，允许通过FamilyMemberName和DoctorLeaderName筛选数据
     *
     * @param id
     * @param page
     * @param limit
     * @param mark
     * @param MemberName
     * @param LeaderName
     * @return 分页器
     */
    public MyPageHelper<Map<Object, Object>> selectByHospitalId(Long id, int page, int limit, int mark, String MemberName, String LeaderName) {
        List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
        ServiceRecordExample example = new ServiceRecordExample();
        ServiceRecordExample.Criteria criteria = example.createCriteria();
        criteria.andHospitalIdEqualTo(id);
        List<ServiceRecord> serviceRecords = serviceRecordMapper.selectByExample(example);
        Map<Object, Object> result = null;
        for (ServiceRecord serviceRecord : serviceRecords) {
            FamilyMember familyMember = familyMemberMapper.selectByPrimaryKey(serviceRecord.getFamilyMemberId());
            Family family = familyMapper.selectByPrimaryKey(serviceRecord.getFamilyId());
            DoctorGroup doctorGroup = doctorGroupMapper.selectByPrimaryKey(serviceRecord.getDoctorGroupId());
            if (null != familyMember && null != family && null != doctorGroup) {
                String familyMemberName = familyMember.getName();
                String familyHouseholderName = family.getHouseholderName();
                String doctorGroupLeaderName = doctorGroup.getGroupLeaderName();
                if (MemberName.equals("null") && LeaderName.equals("null")) {
                    result = setResult(familyMemberName, familyHouseholderName, doctorGroupLeaderName, serviceRecord.getServiceTime(), serviceRecord.getServiceType(), serviceRecord.getServiceContent(), serviceRecord.getServiceEvaluation());
                    list.add(result);
                } else if (familyMemberName.matches(".*" + MemberName + ".*") || doctorGroupLeaderName.matches(".*" + LeaderName + ".*")) {
                    result = setResult(familyMemberName, familyHouseholderName, doctorGroupLeaderName, serviceRecord.getServiceTime(), serviceRecord.getServiceType(), serviceRecord.getServiceContent(), serviceRecord.getServiceEvaluation());
                    list.add(result);
                }
            }
        }
        return new MyPageHelper<>(list, page, limit);
    }

    public List<Map<Object, Object>> getServiceRecordList(Long familyId) {
        List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
        ServiceRecordExample example = new ServiceRecordExample();
        ServiceRecordExample.Criteria criteria = example.createCriteria();
        criteria.andFamilyIdEqualTo(familyId);
        List<ServiceRecord> serviceRecords = serviceRecordMapper.selectByExample(example);
        Map<Object, Object> result = null;
        for (ServiceRecord serviceRecord : serviceRecords) {
            FamilyMember familyMember = familyMemberMapper.selectByPrimaryKey(serviceRecord.getFamilyMemberId());
            Family family = familyMapper.selectByPrimaryKey(serviceRecord.getFamilyId());
            DoctorGroup doctorGroup = doctorGroupMapper.selectByPrimaryKey(serviceRecord.getDoctorGroupId());
            if (null != familyMember && null != family && null != doctorGroup) {
                String familyMemberName = familyMember.getName();
                String familyHouseholderName = family.getHouseholderName();
                String doctorGroupLeaderName = doctorGroup.getGroupLeaderName();
                result = setResult(familyMemberName, familyHouseholderName, doctorGroupLeaderName, serviceRecord.getServiceTime(), serviceRecord.getServiceType(), serviceRecord.getServiceContent(), serviceRecord.getServiceEvaluation());
                list.add(result);
            }
        }
        return list;
    }


}
