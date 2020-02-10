package com.controller;


import com.entity.*;
import com.github.pagehelper.PageInfo;
import com.service.*;
import com.util.FindUser;
import com.util.MyPageHelper;
import com.util.SetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

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
    private FamilyService familyService;

    @Autowired
    private FamilyMemberService familyMemberService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private CaseService caseService;

    @Autowired
    private SelfCheckService selfCheckService;

    @Autowired
    private WarningService warningService;


    @RequestMapping("/notice")
    @PreAuthorize("hasPermission('/doctor/notice','r')")
    public String notice() {
        return "doctor/notice";
    }

    @RequestMapping("/health_knowledge")
    @PreAuthorize("hasPermission('/doctor/health_knowledge','r')")
    public String inform() {
        return "doctor/health_knowledge";
    }

    @RequestMapping("/follow_up")
    @PreAuthorize("hasPermission('/doctor/follow_up','r')")
    public String followUp() {
        return "doctor/followUp";
    }


    @ResponseBody
    @RequestMapping("/getNoticeBydoctorIdInOneHospital")
    @PreAuthorize("hasPermission('/manager/showNotice','r')")
    public Map<String, Object> getNoticeBydoctorId() {
        FindUser findUser = new FindUser();
        User user = findUser.getuser();
        Long hospitalId = user.getHospitalId();

        PageInfo<Notice> noticeList = noticeService.getNoticeList(hospitalId, null, null, 1, 10, 1);
        return SetData.setdata(noticeList);

    }

    @GetMapping("/addHealthKnowledge")
    public String addHealthKnowledge() {
        return "doctor/addHealthKnowledge";
    }

    @ResponseBody
    @PostMapping(value = "/saveHealthKnowledge")
    public String saveHealthKnowledge(HealthKnowledge healthKnowledge) {
        FindUser findUser = new FindUser();
        User user = findUser.getuser();
        Long doctorId = user.getDoctorId();
        HealthKnowledge healthKnowledge1 = healthKnowledgeService.getLastOng();
        int temp = 0;
        if (null != healthKnowledge1) {
            healthKnowledge.setHealthKnowledgeId(healthKnowledge1.getHealthKnowledgeId() + 1);
            healthKnowledge.setPublisherId(doctorId);
            healthKnowledge.setReviewStatus("0");
            temp = healthKnowledgeService.insert(healthKnowledge);
            if (temp == 1)
                return "success";
        }
        healthKnowledge.setHealthKnowledgeId((long) 0);
        temp = healthKnowledgeService.insert(healthKnowledge);
        if (temp == 1)
            return "success";
        return "error";
    }


    @ResponseBody
    @RequestMapping("/selectHealthKnowledgeByDoctorIdAndHospitalId")
    public Map<String, Object> selectHealthKnowledgeByDoctorIdAndHospitalId(
            @RequestParam("page") int page, @RequestParam("limit") int limit,
            @RequestParam(value = "title", defaultValue = "null") String title) {
        FindUser findUser = new FindUser();
        User user = findUser.getuser();
        Long doctorId = user.getDoctorId();
        PageInfo<HealthKnowledge> healthKnowledgeList = healthKnowledgeService.selectByPublisherId(doctorId, title, page, limit, 1);
        return SetData.setdata(healthKnowledgeList);
    }

    @ResponseBody
    @RequestMapping("/deleteByHealthKnowledgeId")
    public int deleteByHealthKnowledgeId(Long id) {
        return healthKnowledgeService.deleteByPrimaryKey(id);
    }

    @ResponseBody
    @GetMapping("/batchDeleteHealthKnowledge")
    public String batchDeleteHealthKnowledge(String ids) {
        List<String> listIds = Arrays.asList(ids.split(","));
        StringBuilder str = new StringBuilder();
        for (String id : listIds) {
            int i = healthKnowledgeService.deleteByPrimaryKey(Long.parseLong(id));
            if (i == 0) {
                str.append(id);
            }
        }
        if (str.toString().equals("")) {
            return "批量删除成功！";
        }
        return str + "删除失败！";
    }


    @ResponseBody
    @RequestMapping("/selectFollowUpByDoctorId")
    public Map<String, Object> selectFollowUpByDoctorId(
            @RequestParam("page") int page, @RequestParam("limit") int limit,
            @RequestParam(value = "name", defaultValue = "null") String name) {

        MyPageHelper myPageInfo;
        myPageInfo = followUpService.getFollowUpByDoctorIdAndName(page - 1, limit, name);

        if (null != myPageInfo.getList()) {
            return SetData.getStringObjectMap(myPageInfo);
        }
        return SetData.returnNull();

    }

    @ResponseBody
    @RequestMapping("/agreeFollowUpById")
    public int agreeFollowUpById(Long FollowUpId) {
        FollowUp followUp = followUpService.selectByPrimaryKey(FollowUpId);

        followUp.setStatus(1);

        if (followUpService.updateByPrimaryKey(followUp) == 1) {
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @RequestMapping("/disagreeFollowUpById")
    public int disagreeFollowUpById(Long FollowUpId) {
        FollowUp followUp = followUpService.selectByPrimaryKey(FollowUpId);

        followUp.setStatus(0);

        if (followUpService.updateByPrimaryKey(followUp) == 1) {
            return 1;
        }
        return 0;
    }

    @GetMapping("/case")
    @PreAuthorize("hasPermission('/doctor/case','r')")
    public String showCase() {
        return "doctor/case/case";
    }

    @GetMapping("/medical_history")
    @PreAuthorize("hasPermission('/doctor/medical_history','r')")
    public String medicalHistory() {
        return "doctor/history/history";
    }

    @GetMapping("/self_inspection")
    @PreAuthorize("hasPermission('/doctor/self_inspection','r')")
    public String selfInspection() {
        return "doctor/selfCheck/selfCheck";
    }

    @GetMapping("/showFamilyMemberList")
    @PreAuthorize("hasPermission('/doctor/case','r')")
    public String showFamilyMember() {
        return "doctor/case/familyMember";
    }

    @GetMapping("/showMemberList")
    @PreAuthorize("hasPermission('/doctor/medical_history','r')")
    public String showMember() {
        return "doctor/history/member";
    }

    @GetMapping("/showMembers")
    @PreAuthorize("hasPermission('/doctor/self_inspection','r')")
    public String showMembers() {
        return "doctor/selfCheck/showMembers";
    }

    @GetMapping("/getMemberCase")
    @PreAuthorize("hasPermission('/doctor/case','r')")
    public String getMemberCase(Model model, Long id) {
        model.addAttribute("cardId", id);
        return "doctor/case/getMemberCase";
    }

    @GetMapping("/getMemberHistory")
    @PreAuthorize("hasPermission('/doctor/medical_history','r')")
    public String getMemberHistory(Model model, String id) {
        model.addAttribute("cardId", id);
        return "doctor/history/getMemberHistory";
    }

    @GetMapping("/getMemberSelfCheck")
    @PreAuthorize("hasPermission('/doctor/self_inspection','r')")
    public String getMemberSelfCheck(Model model, Long id) {
        model.addAttribute("cardId", id);
        return "doctor/selfCheck/getMemberSelfCheck";
    }

    @ResponseBody
    @GetMapping("/getMemberCaseByCardId")
    @PreAuthorize("hasPermission('/doctor/case','r')")
    public Map<String, Object> getMemberCaseByCardId(String id, @RequestParam("page") int page, @RequestParam("limit") int limit) {
        List<Case> cases = caseService.getAllCase(id);
        MyPageHelper pageInfo = new MyPageHelper<>(cases, page - 1, limit);
        if (null != pageInfo.getList()) {
            return SetData.getStringObjectMap(pageInfo);
        }
        return SetData.returnNull();
    }

    @GetMapping("/showMemberCase")
    @PreAuthorize("hasPermission('/doctor/case','r')")
    public String showMemberCase(Model model, Long id) {
        model.addAttribute("caseId", id);
        return "doctor/case/showMemberCase";
    }

    @ResponseBody
    @RequestMapping("/selectCaseByCaseId")
    public Map<String, Object> selectCaseByCaseId(Long id) {
        Map<String, Object> cases = caseService.getCaseByCaseId(id);
        if (null != cases) {
            return cases;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/selectAllFamily")
    public Map<String, Object> selectAllFamily(
            @RequestParam("page") int page, @RequestParam("limit") int limit,
            @RequestParam(value = "householderName", defaultValue = "null") String householderName) {
        List<FamilyDoctor> familyDoctorList = familyDoctorService.getFamilyDoctor();
        List<Family> list = new ArrayList<>();
        for (FamilyDoctor item : familyDoctorList) {
            Family family = familyService.selectByPrimaryKey(item.getFamilyId());
            int population = familyMemberService.getAllMember(family.getFamilyId()).size();
            family.setPopulation(population);
            if (householderName.equals("null")) {
                list.add(family);
            } else if (family.getHouseholderName().matches(".*" + householderName + ".*")) {
                list.add(family);
            }
        }
        MyPageHelper myPageInfo = new MyPageHelper<>(list, page - 1, limit);
        if (null != myPageInfo.getList()) {
            return SetData.getStringObjectMap(myPageInfo);
        }
        return SetData.returnNull();
    }

    @ResponseBody
    @RequestMapping("/selectAllFamilyMemberByDoctorId")
    public List<FamilyMember> selectAllFamilyMemberByDoctorId() {

        List<FamilyDoctor> familyDoctorList = familyDoctorService.getFamilyDoctor();

        List<FamilyMember> list = new ArrayList<>();

        for (FamilyDoctor item : familyDoctorList) {
            List<FamilyMember> familyMemberList = familyMemberService.getAllMember(item.getFamilyId());
            list.addAll(familyMemberList);
        }
        return list;
    }

    private Map<String, Object> setReturn(List list, MyPageHelper myPageInfo) {
        if (null != list) {
            return SetData.getStringObjectMap(myPageInfo);
        }
        return SetData.returnNull();
    }

    @ResponseBody
    @RequestMapping("/selectAllergyHistoryByCardId")
    public Map<String, Object> selectAllergyHistoryByCardId(String cardId, @RequestParam("page") int page, @RequestParam("limit") int limit) {

        List<AllergyHistory> allergyHistoryList = historyService.getAllergyHistory(cardId);

        MyPageHelper myPageInfo = new MyPageHelper<>(allergyHistoryList, page - 1, limit);

        return setReturn(myPageInfo.getList(), myPageInfo);
    }


    @ResponseBody
    @RequestMapping("/selectFamilyHistoryByCardId")
    public Map<String, Object> selectFamilyHistoryByCardId(String cardId, @RequestParam("page") int page, @RequestParam("limit") int limit) {
        List<FamilyHistory> familyHistoryList = historyService.getFamilyHistory(cardId);

        MyPageHelper myPageInfo = new MyPageHelper<>(familyHistoryList, page - 1, limit);

        return setReturn(myPageInfo.getList(), myPageInfo);
    }

    @ResponseBody
    @RequestMapping("/selectObstericalHistoryByCardId")
    public Map<String, Object> selectObstericalHistoryByCardId(String cardId, @RequestParam("page") int page, @RequestParam("limit") int limit) {
        List<ObstericalHistory> obstericalHistoryList = historyService.getObstericalHistory(cardId);

        MyPageHelper myPageInfo = new MyPageHelper<>(obstericalHistoryList, page - 1, limit);

        return setReturn(myPageInfo.getList(), myPageInfo);
    }

    @ResponseBody
    @RequestMapping("/selectOperationHistoryByCardId")
    public Map<String, Object> selectOperationHistoryByCardId(String cardId, @RequestParam("page") int page, @RequestParam("limit") int limit) {
        List<OperationHistory> operationHistoryList = historyService.getOperationHistory(cardId);

        MyPageHelper myPageInfo = new MyPageHelper<>(operationHistoryList, page - 1, limit);

        return setReturn(myPageInfo.getList(), myPageInfo);
    }

    @ResponseBody
    @RequestMapping("/selectPastHistoryByCardId")
    public Map<String, Object> selectPastHistoryByCardId(String cardId, @RequestParam("page") int page, @RequestParam("limit") int limit) {
        List<PastHistory> pastHistoryList = historyService.getPastHistory(cardId);

        MyPageHelper myPageInfo = new MyPageHelper<>(pastHistoryList, page - 1, limit);

        return setReturn(myPageInfo.getList(), myPageInfo);
    }

    @ResponseBody
    @RequestMapping("/selectPressureCheckByCardId")
    public Map<String, Object> selectPressureCheckByCardId(String cardId, @RequestParam("page") int page, @RequestParam("limit") int limit) {

        MyPageHelper myPageInfo = selfCheckService.getMeasurementCheckByCardId((long) 1, cardId, page - 1, limit);
        return setReturn(myPageInfo.getList(), myPageInfo);
    }

    @ResponseBody
    @RequestMapping("/selectSugarCheckByCardId")
    public Map<String, Object> selectSugarCheckByCardId(String cardId, @RequestParam("page") int page, @RequestParam("limit") int limit) {

        MyPageHelper myPageInfo = selfCheckService.getMeasurementCheckByCardId((long) 2, cardId, page - 1, limit);
        return setReturn(myPageInfo.getList(), myPageInfo);
    }

    @ResponseBody
    @RequestMapping("/selectHeartRateCheckByCardId")
    public Map<String, Object> selectHeartRateCheckByCardId(String cardId, @RequestParam("page") int page, @RequestParam("limit") int limit) {

        MyPageHelper myPageInfo = selfCheckService.getMeasurementCheckByCardId((long) 3, cardId, page - 1, limit);
        return setReturn(myPageInfo.getList(), myPageInfo);
    }

    @ResponseBody
    @RequestMapping("/selectTemperatureCheckByCardId")
    public Map<String, Object> selectTemperatureCheckByCardId(String cardId, @RequestParam("page") int page, @RequestParam("limit") int limit) {

        MyPageHelper myPageInfo = selfCheckService.getMeasurementCheckByCardId((long) 4, cardId, page - 1, limit);
        return setReturn(myPageInfo.getList(), myPageInfo);
    }

    @ResponseBody
    @RequestMapping("/selectWeightCheckByCardId")
    public Map<String, Object> selectWeightCheckByCardId(String cardId, @RequestParam("page") int page, @RequestParam("limit") int limit) {

        MyPageHelper myPageInfo = selfCheckService.getMeasurementCheckByCardId((long) 5, cardId, page - 1, limit);
        return setReturn(myPageInfo.getList(), myPageInfo);
    }


    @ResponseBody
    @RequestMapping("/selectHospitalizationByCardId")
    public List<Hospitalization> selectHospitalizationByCardId(String cardId) {
        List<Hospitalization> hospitalizationList = caseService.getAllHospitalization(cardId);

        if (hospitalizationList != null) {
            return hospitalizationList;
        }
        return new ArrayList<>();

    }

    @ResponseBody
    @RequestMapping("/selectInspectionByCardId")
    public List<Inspection> selectInspectionByCardId(String cardId) {
        List<Inspection> Inspection = caseService.getAllInspection(cardId);

        if (Inspection != null) {
            return Inspection;
        }
        return new ArrayList<>();

    }

    @ResponseBody
    @RequestMapping("/selectMedicationByCardId")
    public List<Medication> selectMedicationByCardId(String cardId) {
        List<Medication> Medication = caseService.getAllMedication(cardId);

        if (Medication != null) {
            return Medication;
        }
        return new ArrayList<>();

    }

    @ResponseBody
    @RequestMapping("/selectSurgeryByCardId")
    public List<Surgery> selectSurgeryByCardId(String cardId) {
        List<Surgery> Surgery = caseService.getAllSurgery(cardId);

        if (Surgery != null) {
            return Surgery;
        }
        return new ArrayList<>();

    }

    @ResponseBody
    @RequestMapping("/selectWarningHistoryByCardId")
    public List<WarningHistory> selectWarningHistoryByCardId(String cardId) {
        return warningService.selectByCardId(cardId);
    }


}
