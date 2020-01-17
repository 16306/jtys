package com.controller;


import com.entity.AllergyHistory;
import com.entity.Doctor;
import com.entity.FamilyDoctor;
import com.entity.FamilyHistory;
import com.entity.FamilyMember;
import com.entity.FollowUp;
import com.entity.HealthKnowledge;
import com.entity.Hospitalization;
import com.entity.Inspection;
import com.entity.Medication;
import com.entity.Notice;
import com.entity.ObstericalHistory;
import com.entity.OperationHistory;
import com.entity.PastHistory;
import com.entity.Surgery;
import com.entity.User;
import com.entity.WarningHistory;
import com.github.pagehelper.PageInfo;
import com.service.CaseService;
import com.service.DoctorGroupService;
import com.service.DoctorService;
import com.service.FamilyDoctorService;
import com.service.FamilyMemberService;
import com.service.FollowUpService;
import com.service.HealthKnowledgeService;
import com.service.HistoryService;
import com.service.NoticeService;
import com.service.WarningService;
import com.util.FindUser;
import com.util.SetData;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/doctor")
public class DoctorController
{

    @Autowired
    private DoctorGroupService doctorGroupService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private HealthKnowledgeService healthKnowledgeService;

    @Autowired
    private FollowUpService followUpService;

    @Autowired
    private FamilyDoctorService familyDoctorService;

    @Autowired
    private FamilyMemberService familyMemberService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private CaseService caseService;

    @Autowired
    private WarningService warningService;

    @ResponseBody
    @RequestMapping("/getNoticeBydoctorIdInOneHospital")
    @PreAuthorize("hasPermission('/manager/showNotice','r')")
    public Map<String, Object> getNoticeBydoctorId()
    {
        FindUser findUser = new FindUser();
        User user = findUser.getuser();
        Long hospitalId=user.getHospitalId();

        PageInfo<Notice> noticeList = noticeService.getNoticeList(hospitalId,null,null,1,10,1);
        Map<String, Object> map = SetData.setdata(noticeList);
        return map;

    }

    @ResponseBody
    @RequestMapping("/addHealthKnowledge")
    public int addHealthKnowledge(HealthKnowledge healthKnowledge)
    {
        HealthKnowledge healthKnowledge1 = healthKnowledgeService.getLastOng();
        int temp = 0;
        if(null != healthKnowledge1)
        {
            healthKnowledge.setHealthKnowledgeId(healthKnowledge1.getHealthKnowledgeId()+1);
            temp = healthKnowledgeService.insert(healthKnowledge);
            return temp;
        }
        healthKnowledge.setHealthKnowledgeId((long) 0);
        temp = healthKnowledgeService.insert(healthKnowledge);
        return temp;
    }


    @ResponseBody
    @RequestMapping("/selectHealthKnowledgeByDoctorIdAndHospitalId")
    @PreAuthorize("hasPermission('/manager/showHealthKnowledge','r')")
    public Map<String, Object> selectHealthKnowledgeByDoctorIdAndHospitalId(
        HealthKnowledge healthKnowledge)
    {
        FindUser findUser = new FindUser();
        User user = findUser.getuser();
        Long doctorId= user.getDoctorId();

        PageInfo<HealthKnowledge> healthKnowledgeList = healthKnowledgeService.selectByPublisherId(doctorId,1,10,1);
        Map<String, Object> map = SetData.setdata(healthKnowledgeList);
        return map;
    }


    @ResponseBody
    @RequestMapping("/selectFollowUpByDoctorId")
    public List<FollowUp> selectFollowUpByDoctorId()
    {
        FindUser findUser = new FindUser();
        User user = findUser.getuser();
        Long doctorId= user.getDoctorId();

        List<FollowUp> followUpList = followUpService.getFollowUpByDoctorId(doctorId);

        if (followUpList != null)
        {
            return followUpList;
        }
        return null;

    }


    @ResponseBody
    @RequestMapping("/updateFollowUpByDoctorIdAndFollowUpIdAndStatus")
    public Boolean updateFollowUpByDoctorId(@RequestParam(value = "FollowUpId")Long FollowUpId,
                                            @RequestParam(value = "status")int status )
    {
        FindUser findUser = new FindUser();
        User user = findUser.getuser();
        Long doctorId= user.getDoctorId();

        FollowUp followUp= followUpService.selectByPrimaryKey(FollowUpId);

        followUp.setStatus(status);

        if (followUpService.updateByPrimaryKey(followUp)==1)
        {
            return true;
        }
        return false;

    }

    @ResponseBody
    @RequestMapping("/selectAllFamilyMemberByDoctorId")
    public List<FamilyMember> selectAllFamilyMemberByDoctorId()
    {
        FindUser findUser = new FindUser();
        User user = findUser.getuser();
        Long doctorId= user.getDoctorId();

        Doctor doctor= doctorService.selectByPrimaryKey(doctorId);

        Long doctorGroupId = doctor.getDoctorGroupId();

        List<FamilyDoctor> familyDoctorList = familyDoctorService.selectByDoctorGroupId(doctorGroupId);

        List<FamilyMember> list = new LinkedList<>();

        for (FamilyDoctor item : familyDoctorList)
        {
            List<FamilyMember> familyMemberList = familyMemberService.getAllMember(item.getFamilyId());
            list.addAll(familyMemberList);

        }
        return list;
    }


    @ResponseBody
    @RequestMapping("/selectAllergyHistoryByCardId")
    public List<AllergyHistory> selectAllergyHistoryByCardId(@RequestParam(value = "cardId")String cardId)
    {
        List<AllergyHistory> allergyHistoryList = historyService.getAllergyHistory(cardId);

        if (allergyHistoryList != null)
        {
            return allergyHistoryList;
        }
        return null;
    }


    @ResponseBody
    @RequestMapping("/selectFamilyHistoryByCardId")
    public List<FamilyHistory> selectFamilyHistoryByCardId(@RequestParam(value = "cardId")String cardId)
    {
        List<FamilyHistory> familyHistoryList = historyService.getFamilyHistory(cardId);

        if (familyHistoryList != null)
        {
            return familyHistoryList;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/selectObstericalHistoryByCardId")
    public List<ObstericalHistory> selectObstericalHistoryByCardId(@RequestParam(value = "cardId")String cardId)
    {
        List<ObstericalHistory> obstericalHistoryList = historyService.getObstericalHistory(cardId);

        if (obstericalHistoryList != null)
        {
            return obstericalHistoryList;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/selectOperationHistoryByCardId")
    public List<OperationHistory> selectOperationHistoryByCardId(@RequestParam(value = "cardId")String cardId)
    {
        List<OperationHistory> operationHistoryList = historyService.getOperationHistory(cardId);

        if (operationHistoryList != null)
        {
            return operationHistoryList;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/selectPastHistoryByCardId")
    public List<PastHistory> selectPastHistoryByCardId(String cardId)
    {
        List<PastHistory> pastHistoryList = historyService.getPastHistory(cardId);

        if (pastHistoryList != null)
        {
            return pastHistoryList;
        }
        return null;

    }

    @ResponseBody
    @RequestMapping("/selectHospitalizationByCardId")
    public List<Hospitalization> selectHospitalizationByCardId(String cardId)
    {
        List<Hospitalization> hospitalizationList = caseService.getAllHospitalization(cardId);

        if (hospitalizationList != null)
        {
            return hospitalizationList;
        }
        return null;

    }

    @ResponseBody
    @RequestMapping("/selectInspectionByCardId")
    public List<Inspection> selectInspectionByCardId(String cardId)
    {
        List<Inspection> Inspection = caseService.getAllInspection(cardId);

        if (Inspection != null)
        {
            return Inspection;
        }
        return null;

    }

    @ResponseBody
    @RequestMapping("/selectMedicationByCardId")
    public List<Medication> selectMedicationByCardId(String cardId)
    {
        List<Medication> Medication = caseService.getAllMedication(cardId);

        if (Medication != null)
        {
            return Medication;
        }
        return null;

    }

    @ResponseBody
    @RequestMapping("/selectSurgeryByCardId")
    public List<Surgery> selectSurgeryByCardId(String cardId)
    {
        List<Surgery> Surgery = caseService.getAllSurgery(cardId);

        if (Surgery != null)
        {
            return Surgery;
        }
        return null;

    }

    @ResponseBody
    @RequestMapping("/selectWarningHistoryByCardId")
    public List<WarningHistory> selectWarningHistoryByCardId(String cardId)
    {
        return warningService.selectByCardId(cardId);
    }


}
