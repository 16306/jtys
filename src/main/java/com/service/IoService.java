package com.service;

import com.entity.Doctor;
import com.entity.DoctorGroup;
import com.entity.Family;
import com.entity.FamilyMember;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class IoService
{

  @Autowired
  private FamilyService familyService;

  @Autowired
  private FamilyMemberService familyMemberService;

  @Autowired
  private DoctorService doctorService;

  @Autowired
  private DoctorGroupService doctorGroupService;


  /**
   * 将execl文件里的数据导入数据库
   * @param filename
   * @param file
   * @return
   * @throws IOException
   */
  @Transactional(rollbackFor = Exception.class)
  public String importService(String filename, MultipartFile file) throws IOException
  {
    boolean isExcel2003 = true;
    String str = "";
    if (filename.matches("^.+\\.(?i)(xlsx)$"))
    {
      isExcel2003 = false;
    }
    InputStream is = file.getInputStream();
    Workbook wb = null;
    if (isExcel2003)
    {
      wb = new HSSFWorkbook(is);
    } else
    {
      wb = new XSSFWorkbook(is);
    }
    Sheet sheet = wb.getSheetAt(0);
    if (sheet != null)
    {
      str = "文件上传成功";
    } else
    {
      str = "上传失败sheet为空";
      return str;
    }
    for (int r = 1; r <= sheet.getLastRowNum(); r++)
    {
      Row row = sheet.getRow(r);
      if (row == null)
      {
        continue;
      }
      if (row.getCell(0).getStringCellValue().equals("F"))
      {
        Family family = new Family();
        //从excel第二行开始获取每个单元格的数据
        family.setFamilyId(familyService.getAll().getFamilyId() + 1);
        family.setHouseholderName(row.getCell(1).getStringCellValue());
        family.setPopulation((int) row.getCell(3).getNumericCellValue());
        family.setHouseholderPhone(row.getCell(2).getStringCellValue());
        family.setAddress(row.getCell(4).getStringCellValue());
        family.setHospitalId((long) row.getCell(5).getNumericCellValue());
        if (family.getHouseholderName().isEmpty() || family.getHospitalId() == null || family
            .getAddress().isEmpty() || family.getPopulation() == null || family
            .getHouseholderPhone().isEmpty())
        {
          continue;
        } else if (!family.getHouseholderPhone().matches("^1[3|4|5|7|8]\\d{9}$"))
        {
          str = str + ", 但户主为" + family.getHouseholderName() + "的联系电话错误";
        }

        //保存
        familyService.insert(family);
      } else if (row.getCell(0).getStringCellValue().equals("FM"))
      {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        FamilyMember member = new FamilyMember();
        //从excel第二行开始获取每个单元格的数据
        member.setFamilyMemberId(familyMemberService.getAll().getFamilyMemberId() + 1);
        member.setName(row.getCell(1).getStringCellValue());
        member.setAge((int) row.getCell(2).getNumericCellValue());
        member.setSex(row.getCell(3).getStringCellValue());
        member.setCardId(row.getCell(4).getStringCellValue());
        member.setPhone(row.getCell(5).getStringCellValue());
        String encodedPassword = passwordEncoder.encode(row.getCell(6).getStringCellValue().trim());
        member.setPassword(encodedPassword);
        member.setFamilyId(familyService.getAll().getFamilyId());
        member.setEmergencyContactName(row.getCell(7).getStringCellValue());
        member.setEmergencyContactPhone(row.getCell(8).getStringCellValue());
        if (member.getName().isEmpty() || member.getEmergencyContactName().isEmpty() || member
            .getPassword().isEmpty() || member.getPhone().isEmpty() || member.getCardId().isEmpty()
            || member.getAge() == null || member.getFamilyMemberId() == null || member.getSex()
            .isEmpty() || member.getFamilyId() == null || member.getEmergencyContactPhone()
            .isEmpty())
        {
          continue;
        } else if (!member.getPhone().matches("^1[3|4|5|7|8]\\d{9}$") || !member
            .getEmergencyContactPhone().matches("^1[3|4|5|7|8]\\d{9}$"))
        {
          str = str + ", " + member.getName() + "的联系或紧急联系电话错误";
        }
        familyMemberService.insert(member);
      } else if (row.getCell(0).getStringCellValue().equals("DG"))
      {
        DoctorGroup doctorGroup = new DoctorGroup();
        //从excel第二行开始获取每个单元格的数据
        doctorGroup.setDoctorGroupId(doctorGroupService.getAll().getDoctorGroupId() + 1);
        doctorGroup.setName(row.getCell(1).getStringCellValue());
        doctorGroup.setGroupLeaderName(row.getCell(2).getStringCellValue());
        doctorGroup.setGroupLeaderPhone(row.getCell(3).getStringCellValue());
        doctorGroup.setSecondLeaderName(row.getCell(4).getStringCellValue());
        doctorGroup.setSecondLeaderPhone(row.getCell(5).getStringCellValue());
        doctorGroup.setSpeciality(row.getCell(6).getStringCellValue());
        doctorGroup.setServiceArea(row.getCell(7).getStringCellValue());
        doctorGroup.setHospitalId((long) row.getCell(8).getNumericCellValue());
        if (doctorGroup.getName().isEmpty() || doctorGroup.getDoctorGroupId() == null || doctorGroup
            .getGroupLeaderName().isEmpty() || doctorGroup.getGroupLeaderPhone().isEmpty() || doctorGroup
            .getSecondLeaderName().isEmpty() || doctorGroup.getSecondLeaderPhone().isEmpty() || doctorGroup
            .getHospitalId() == null)
        {
          continue;
        } else if (!doctorGroup.getGroupLeaderPhone().matches("^1[3|4|5|7|8]\\d{9}$"))
        {
          str = str + ", 但" + doctorGroup.getGroupLeaderName() + "的联系电话错误";
        }
        //保存

      }else if (row.getCell(0).getStringCellValue().equals("D"))
      {
        Doctor doctor = new Doctor();
        //从excel第二行开始获取每个单元格的数据
        doctor.setDoctorId(doctorService.getAll().getDoctorId() + 1);
        doctor.setName(row.getCell(1).getStringCellValue());
        doctor.setAge((int) row.getCell(2).getNumericCellValue());
        doctor.setSex(row.getCell(3).getStringCellValue());
        doctor.setCardId(row.getCell(4).getStringCellValue());
        doctor.setDuty(row.getCell(5).getStringCellValue());
        doctor.setDepartment(row.getCell(6).getStringCellValue());
        doctor.setPhone(row.getCell(7).getStringCellValue());
        doctor.setDoctorGroupId((long) row.getCell(8).getNumericCellValue());
        doctor.setHospitalId((long) row.getCell(9).getNumericCellValue());
        if (doctor.getName().isEmpty() || doctor.getDoctorId() == null || doctor
            .getSex().isEmpty() || doctor.getCardId().isEmpty() || doctor
            .getDuty().isEmpty() || doctor.getDepartment().isEmpty() || doctor
            .getAge() == null || doctor.getDoctorGroupId() == null || doctor
            .getPhone().isEmpty() || doctor.getHospitalId() == null)
        {
          continue;
        } else if (!doctor.getPhone().matches("^1[3|4|5|7|8]\\d{9}$"))
        {
          str = str + ", 但" + doctor.getName() + "的联系电话错误";
        }
        //保存
      }

    }
    return str;
  }

  /**
   * 将数据库家庭和医生数据导出
   * @param response
   * @param ids
   * @throws IOException
   */
  @Transactional(rollbackFor = Exception.class)
  public void OutputInfo(HttpServletResponse response, String ids) throws IOException
  {
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet sheet = workbook.createSheet("信息表");
    String fileName = null;

    List<String> listIds = Arrays.asList(ids.split(","));
    List<Long> listId;
    listId = new ArrayList<>();
    for (String id : listIds)
    {
      if(!(id.matches("F") || id.matches("G")))
      {
        listId.add(Long.parseLong(id));
      }
    }
    if(listIds.get(listIds.size() - 1).matches("F"))
    {
      List<Family> List = new ArrayList<>();

      for (Long familyId : listId)
      {
        Family family = familyService.selectByPrimaryKey(familyId);
        List.add(family);
      }

      fileName = "familyinfo" + ".xls";//设置要导出的文件的名字
      //新增数据行，并且设置单元格数据

      int rowNum = 1;

      String[] headers = {"标识", "id", "姓名", "户主电话/Age", "家庭人数/Sex", "地址/CardId", "Phone", "FamilyId",
          "EmergencyContactName", "EmergencyContactPhone"};
      //headers表示excel表中第一行的表头

      HSSFRow row = sheet.createRow(0);

      for (int i = 0; i < headers.length; i++)
      {
        HSSFCell cell = row.createCell(i);
        HSSFRichTextString text = new HSSFRichTextString(headers[i]);
        cell.setCellValue(text);
      }

      //在表中存放查询到的数据放入对应的列
      for (Family family : List)
      {
        java.util.List<FamilyMember> mlist = familyMemberService.getAllMember(family.getFamilyId());
        HSSFRow row1 = sheet.createRow(rowNum);
        row1.createCell(0).setCellValue("F");
        row1.createCell(1).setCellValue(family.getFamilyId());
        row1.createCell(2).setCellValue(family.getHouseholderName());
        row1.createCell(3).setCellValue(family.getHouseholderPhone());
        row1.createCell(4).setCellValue(family.getPopulation());
        row1.createCell(5).setCellValue(family.getAddress());
        row1.createCell(6).setCellValue(family.getHospitalId());
        rowNum++;
        for (FamilyMember familyMember : mlist)
        {
          HSSFRow row2 = sheet.createRow(rowNum);
          row2.createCell(0).setCellValue("FM");
          row2.createCell(1).setCellValue(familyMember.getFamilyMemberId());
          row2.createCell(2).setCellValue(familyMember.getName());
          row2.createCell(3).setCellValue(familyMember.getAge());
          row2.createCell(4).setCellValue(familyMember.getSex());
          row2.createCell(5).setCellValue(familyMember.getCardId());
          row2.createCell(6).setCellValue(familyMember.getPhone());
          row2.createCell(7).setCellValue(familyMember.getFamilyId());
          row2.createCell(8).setCellValue(familyMember.getEmergencyContactName());
          row2.createCell(9).setCellValue(familyMember.getEmergencyContactPhone());
          rowNum++;
        }
      }
    }else if(listIds.get(listIds.size() - 1).matches("G"))
    {
      List<DoctorGroup> List = new ArrayList<>();

      for (Long doctorGroupId : listId)
      {
        DoctorGroup doctorGroup = doctorGroupService.selectByPrimaryKey(doctorGroupId);
        List.add(doctorGroup);
      }

      fileName = "doctorGroupInfo" + ".xls";//设置要导出的文件的名字
      //新增数据行，并且设置单元格数据

      int rowNum = 1;

      String[] headers = {"标识", "id", "组名/姓名", "组长/Age", "组长电话/Sex", "副组长/CardId", "副组长电话/duty", "speciality/department",
          "serviceArea/phone"};
      //headers表示excel表中第一行的表头

      HSSFRow row = sheet.createRow(0);
      //在excel表中添加表头

      for (int i = 0; i < headers.length; i++)
      {
        HSSFCell cell = row.createCell(i);
        HSSFRichTextString text = new HSSFRichTextString(headers[i]);
        cell.setCellValue(text);
      }

      //在表中存放查询到的数据放入对应的列
      for (DoctorGroup doctorGroup : List)
      {
        java.util.List<Doctor> dlist = doctorService.DoctorList(doctorGroup.getDoctorGroupId());
        HSSFRow row1 = sheet.createRow(rowNum);
        row1.createCell(0).setCellValue("DG");
        row1.createCell(1).setCellValue(doctorGroup.getDoctorGroupId());
        row1.createCell(2).setCellValue(doctorGroup.getName());
        row1.createCell(3).setCellValue(doctorGroup.getGroupLeaderName());
        row1.createCell(4).setCellValue(doctorGroup.getGroupLeaderPhone());
        row1.createCell(5).setCellValue(doctorGroup.getSecondLeaderName());
        row1.createCell(6).setCellValue(doctorGroup.getSecondLeaderPhone());
        row1.createCell(7).setCellValue(doctorGroup.getSpeciality());
        row1.createCell(8).setCellValue(doctorGroup.getServiceArea());
        rowNum++;
        for (Doctor doctor : dlist)
        {
          HSSFRow row2 = sheet.createRow(rowNum);
          row2.createCell(0).setCellValue("D");
          row2.createCell(1).setCellValue(doctor.getDoctorId());
          row2.createCell(2).setCellValue(doctor.getName());
          row2.createCell(3).setCellValue(doctor.getAge());
          row2.createCell(4).setCellValue(doctor.getSex());
          row2.createCell(5).setCellValue(doctor.getCardId());
          row2.createCell(6).setCellValue(doctor.getDuty());
          row2.createCell(7).setCellValue(doctor.getDepartment());
          row2.createCell(8).setCellValue(doctor.getPhone());
          rowNum++;
        }
      }
    }

    response.setContentType("application/octet-stream");
    response.setHeader("Content-disposition", "attachment;filename=" + fileName);
    response.flushBuffer();
    workbook.write(response.getOutputStream());
  }

}