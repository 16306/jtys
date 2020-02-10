package com.service;

import com.entity.*;
import com.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FamilyAppService {
    @Autowired
    private FamilyMemberMapper familyMemberMapper;

    @Autowired
    private FamilyMapper familyMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private DoctorGroupMapper doctorGroupMapper;

    @Autowired
    private FamilyDoctorMapper familyDoctorMapper;

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private HealthKnowledgeMapper healthKnowledgeMapper;

    @Autowired
    private FollowUpMapper followUpMapper;

    /**
     * familyAPP登录功能
     *
     * @param familyMember
     * @return
     */
    public FamilyMember login(FamilyMember familyMember) {
        FamilyMember member = familyMemberMapper.selectByCardId(familyMember.getCardId());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (null != member && passwordEncoder.matches(familyMember.getPassword(), member.getPassword())) {
            member.setPassword("protected");
            return member;
        }
        return null;
    }

    /**
     * 查找相同familyId的家庭成员
     *
     * @param familyId
     * @return
     */
    public List<FamilyMember> getAllMember(Long familyId) {
        List<FamilyMember> members = new ArrayList<>();
        List<FamilyMember> list = familyMemberMapper.getAllMemberList(familyId);
        if (null != list) {
            for (FamilyMember familyMember : list) {
                familyMember.setPassword("protected");
                members.add(familyMember);
            }
        }
        return members;
    }

    public List<Doctor> getDoctor(Long familyId) {

        FamilyDoctor familyDoctor = familyDoctorMapper.selectByFamilyId(familyId);
        List<Doctor> doctors = doctorMapper.getDoctorList(familyDoctor.getDoctorGroupId());
        if (null != doctors) {
            return doctors;
        }
        return new ArrayList<>();
    }

    public Map<Object, Object> getContractContent(Long familyId) {
        Map<Object, Object> result = new HashMap<>();
        FamilyDoctor familyDoctor = familyDoctorMapper.selectByFamilyId(familyId);
        if (null != familyDoctor)
        {
            Family family = familyMapper.selectByPrimaryKey(familyDoctor.getFamilyId());
            DoctorGroup doctorGroup = doctorGroupMapper.selectByPrimaryKey(familyDoctor.getDoctorGroupId());
            if (null != family && null != doctorGroup) {
                result.put("familyHouseholderName", family.getHouseholderName());
                result.put("doctorGroupLeaderName", doctorGroup.getGroupLeaderName());
                result.put("contractTime", familyDoctor.getDateOfContract());
                result.put("duration", familyDoctor.getContractDuration());
                result.put("content", familyDoctor.getContractContent());
                return result;
            }
        }
        return null;
    }


    /**
     * 查找家庭所在的医院的通知
     *
     * @param familyId
     * @param title
     * @param publisher
     * @return
     */
    public List<Notice> getAllNotice(Long familyId, String title, String publisher) {
        Family family = familyMapper.selectByPrimaryKey(familyId);
        List<Notice> notice = null;
        if (null != family) {
            notice = noticeMapper.getNoticeList(family.getHospitalId(), title, publisher);
        }
        return notice;
    }

    /**
     * 查找所有过审了的健康知识
     *
     * @return
     */
    public List<HealthKnowledge> getAllHealthKnowledge(String title) {
        return healthKnowledgeMapper.getHealthKnowledgeList("1", title);
    }

    /**
     * 创建随访记录
     *
     * @param record
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int createFollowUp(FollowUp record) {
        FollowUp followUp = followUpMapper.getLastOne();
        if (null == followUp) {
            record.setFollowUpId((long) 0);
        } else {
            record.setFollowUpId(followUp.getFollowUpId() + 1);
        }
        return followUpMapper.insert(record);
    }


}
