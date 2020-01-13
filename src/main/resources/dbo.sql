/*
 Navicat Premium Data Transfer

 Source Server         : 5454
 Source Server Type    : SQL Server
 Source Server Version : 11002100
 Source Host           : .:1433
 Source Catalog        : jtys
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 11002100
 File Encoding         : 65001

 Date: 13/01/2020 20:23:48
*/


-- ----------------------------
-- Table structure for allergy_history_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[allergy_history_form]') AND type IN ('U'))
	DROP TABLE [dbo].[allergy_history_form]
GO

CREATE TABLE [dbo].[allergy_history_form] (
  [card_id] varchar(30) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [allergen] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [describe] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [allergy_id] bigint  IDENTITY(1,1) NOT NULL
)
GO

ALTER TABLE [dbo].[allergy_history_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for case_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[case_form]') AND type IN ('U'))
	DROP TABLE [dbo].[case_form]
GO

CREATE TABLE [dbo].[case_form] (
  [card_id] varchar(30) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [type] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [hospital] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [date] datetime2(7)  NOT NULL,
  [Case_id] bigint  NOT NULL
)
GO

ALTER TABLE [dbo].[case_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of case_form
-- ----------------------------
INSERT INTO [dbo].[case_form] VALUES (N'452123199405075678', N'1', N'1', N'2020-01-11 23:55:10.0000000', N'1')
GO


-- ----------------------------
-- Table structure for Complaint_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Complaint_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Complaint_form]
GO

CREATE TABLE [dbo].[Complaint_form] (
  [id] bigint  NOT NULL,
  [complainant] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [doctor_id] bigint  NOT NULL,
  [content] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [time] datetime2(7)  NOT NULL
)
GO

ALTER TABLE [dbo].[Complaint_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for device_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[device_form]') AND type IN ('U'))
	DROP TABLE [dbo].[device_form]
GO

CREATE TABLE [dbo].[device_form] (
  [device_id] bigint  NOT NULL,
  [model] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [equipment_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [type] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [purchase_time] datetime2(7)  NOT NULL,
  [purchaser] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [price] float(53)  NOT NULL,
  [purchase_quantity] bigint  NOT NULL
)
GO

ALTER TABLE [dbo].[device_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for doctor_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[doctor_form]') AND type IN ('U'))
	DROP TABLE [dbo].[doctor_form]
GO

CREATE TABLE [dbo].[doctor_form] (
  [doctor_id] bigint  NOT NULL,
  [name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [age] int  NOT NULL,
  [sex] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [card_id] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [duty] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [department] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [phone] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [doctor_group_id] bigint  NOT NULL,
  [hospital_id] bigint  NOT NULL
)
GO

ALTER TABLE [dbo].[doctor_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of doctor_form
-- ----------------------------
INSERT INTO [dbo].[doctor_form] VALUES (N'1', N'张三', N'38', N'男', N'452123198105061234', N'主任', N'心脑', N'13878754236', N'1', N'1')
GO

INSERT INTO [dbo].[doctor_form] VALUES (N'2', N'李五', N'45', N'男', N'452123789654231572', N'医师', N'心脑', N'15246786698', N'2', N'1')
GO


-- ----------------------------
-- Table structure for doctor_group_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[doctor_group_form]') AND type IN ('U'))
	DROP TABLE [dbo].[doctor_group_form]
GO

CREATE TABLE [dbo].[doctor_group_form] (
  [doctor_group_id] bigint  NOT NULL,
  [name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [group_leader_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [group_leader_phone] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [second_leader_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [second_leader_phone] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [speciality] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [service_area] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [hospital_id] bigint  NOT NULL
)
GO

ALTER TABLE [dbo].[doctor_group_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of doctor_group_form
-- ----------------------------
INSERT INTO [dbo].[doctor_group_form] VALUES (N'1', N'1', N'张三', N'123564', N'李四', N'345453', N'心脑', N'桂林', N'1')
GO

INSERT INTO [dbo].[doctor_group_form] VALUES (N'2', N'2', N'李五', N'15246786698', N'万流', N'15278365498', N'心脑', N'灵川', N'1')
GO


-- ----------------------------
-- Table structure for evaluation_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[evaluation_form]') AND type IN ('U'))
	DROP TABLE [dbo].[evaluation_form]
GO

CREATE TABLE [dbo].[evaluation_form] (
  [evaluation_id] bigint  NOT NULL,
  [evaluator] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [doctor_id] bigint  NOT NULL,
  [evaluation_content] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [time] datetime2(7)  NOT NULL
)
GO

ALTER TABLE [dbo].[evaluation_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of evaluation_form
-- ----------------------------
INSERT INTO [dbo].[evaluation_form] VALUES (N'1', N'张5', N'1', N'123', N'2020-01-08 22:14:37.0000000')
GO


-- ----------------------------
-- Table structure for family_doctor_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[family_doctor_form]') AND type IN ('U'))
	DROP TABLE [dbo].[family_doctor_form]
GO

CREATE TABLE [dbo].[family_doctor_form] (
  [family_doctor_id] bigint  NOT NULL,
  [doctor_group_id] bigint  NOT NULL,
  [family_id] bigint  NOT NULL,
  [date_of_contract] datetime2(7)  NOT NULL,
  [contract_content] text COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [contract_duration] int  NOT NULL
)
GO

ALTER TABLE [dbo].[family_doctor_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of family_doctor_form
-- ----------------------------
INSERT INTO [dbo].[family_doctor_form] VALUES (N'2', N'-1', N'6', N'2019-12-05 01:04:38.0000000', N'合同内容', N'1')
GO

INSERT INTO [dbo].[family_doctor_form] VALUES (N'3', N'-1', N'7', N'2019-12-05 01:04:38.0000000', N'合同内容', N'1')
GO

INSERT INTO [dbo].[family_doctor_form] VALUES (N'4', N'2', N'8', N'2020-01-06 11:50:30.0000000', N'合同内容', N'1')
GO


-- ----------------------------
-- Table structure for family_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[family_form]') AND type IN ('U'))
	DROP TABLE [dbo].[family_form]
GO

CREATE TABLE [dbo].[family_form] (
  [family_id] bigint  NOT NULL,
  [householder_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [population] int  NOT NULL,
  [householder_phone] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [address] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [hospital_id] bigint  NOT NULL
)
GO

ALTER TABLE [dbo].[family_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of family_form
-- ----------------------------
INSERT INTO [dbo].[family_form] VALUES (N'1', N'黎明', N'3', N'13878890236', N'广西桂林灵川县灵田村', N'1')
GO

INSERT INTO [dbo].[family_form] VALUES (N'3', N'滴滴滴', N'2', N'13578555434', N'啦啦啦啦', N'1')
GO

INSERT INTO [dbo].[family_form] VALUES (N'4', N'黎明', N'0', N'13878890236', N'广西桂林灵川县灵田村', N'1')
GO

INSERT INTO [dbo].[family_form] VALUES (N'5', N'大大', N'0', N'13878770256', N'广西桂林', N'1')
GO

INSERT INTO [dbo].[family_form] VALUES (N'6', N'回聊', N'0', N'15248763468', N'中国', N'1')
GO

INSERT INTO [dbo].[family_form] VALUES (N'7', N'解决', N'0', N'13568975468', N'桂林', N'1')
GO

INSERT INTO [dbo].[family_form] VALUES (N'8', N'大黄蜂', N'0', N'15246786685', N'灵川', N'1')
GO


-- ----------------------------
-- Table structure for family_history_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[family_history_form]') AND type IN ('U'))
	DROP TABLE [dbo].[family_history_form]
GO

CREATE TABLE [dbo].[family_history_form] (
  [family_history_id] bigint  NOT NULL,
  [card_id] varchar(30) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [relation] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [illness_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [describe] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[family_history_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for family_member_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[family_member_form]') AND type IN ('U'))
	DROP TABLE [dbo].[family_member_form]
GO

CREATE TABLE [dbo].[family_member_form] (
  [family_member_id] bigint  NOT NULL,
  [name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [age] int  NOT NULL,
  [sex] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [card_id] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [phone] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [password] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [family_id] bigint  NOT NULL,
  [emergency_contact_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [emergency_contact_phone] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[family_member_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of family_member_form
-- ----------------------------
INSERT INTO [dbo].[family_member_form] VALUES (N'1', N'黎明加', N'25', N'男', N'452123199405075678', N'13878960568', N'$2a$10$eRLP1HGgBZAtt8lNuZJvaurvxutABHcudbbvIsby3WNYsxce/c0Sy', N'1', N'黎明', N'13878960568')
GO

INSERT INTO [dbo].[family_member_form] VALUES (N'2', N'黎明否', N'18', N'男', N'452456200101023412', N'13435689764', N'$2a$10$aLEqDLbqw87GfKDfLAiXeeoVaEDYaIgC6zlTd45XByqKrfYt7IJYK', N'1', N'黎明', N'13435689764')
GO

INSERT INTO [dbo].[family_member_form] VALUES (N'3', N'黎明', N'56', N'男', N'453123497402067612', N'13845678965', N'$2a$10$7JA51d9WF0wpWrVcGygNh.4v.DeNaDYpQVW4unplsh2fa1wDDG7si', N'1', N'黎明否', N'13845678965')
GO

INSERT INTO [dbo].[family_member_form] VALUES (N'4', N'滴水', N'18', N'男', N'452123200201015874', N'15278963356', N'$2a$10$moD/PwVvyCqi6kKO7eXu0Os96V539loi8W/DRSr07g1hx0TV5ZRrm', N'3', N'滴滴滴', N'13578555434')
GO

INSERT INTO [dbo].[family_member_form] VALUES (N'5', N'滴滴滴', N'45', N'男', N'452123197524311254', N'13578555434', N'$2a$10$TOgVOOrjsEGrkJMo/JAVR.Mp4rco7Z.eq6aqc9mzo50JGM59iTtvG', N'3', N'滴滴滴', N'13578555434')
GO


-- ----------------------------
-- Table structure for Follow_up_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Follow_up_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Follow_up_form]
GO

CREATE TABLE [dbo].[Follow_up_form] (
  [Follow_up_id] bigint  NOT NULL,
  [doctor] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [accompanying] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [type] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [time] datetime2(7)  NOT NULL,
  [content] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [family_id] bigint  NOT NULL,
  [family_member_id] bigint  NOT NULL,
  [health_assessment] text COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [doctor_id] bigint  NOT NULL,
  [status] int  NOT NULL
)
GO

ALTER TABLE [dbo].[Follow_up_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Follow_up_form
-- ----------------------------
INSERT INTO [dbo].[Follow_up_form] VALUES (N'0', N'张三', N'无', N'走访', N'2019-01-12 12:30:30.0000000', N'医疗后回访', N'1', N'1', N'健康', N'1', N'1')
GO

INSERT INTO [dbo].[Follow_up_form] VALUES (N'1', N'张三', N'无', N'走访', N'2019-01-13 12:30:30.0000000', N'医疗后回访', N'1', N'1', N'健康', N'1', N'1')
GO


-- ----------------------------
-- Table structure for Health_knowledge_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Health_knowledge_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Health_knowledge_form]
GO

CREATE TABLE [dbo].[Health_knowledge_form] (
  [Health_knowledge_id] bigint  NOT NULL,
  [title] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [publisher_id] bigint  NOT NULL,
  [review_status] varchar(5) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [reviewer] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [review_time] datetime2(7)  NULL,
  [content] text COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[Health_knowledge_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Health_knowledge_form
-- ----------------------------
INSERT INTO [dbo].[Health_knowledge_form] VALUES (N'1', N'2', N'1', N'1', N'李四', N'2019-11-03 10:55:30.0000000', N'123456')
GO

INSERT INTO [dbo].[Health_knowledge_form] VALUES (N'2', N'2', N'1', N'-1', N'李四', N'2019-11-03 11:04:16.0000000', N'123456')
GO

INSERT INTO [dbo].[Health_knowledge_form] VALUES (N'3', N'3', N'3', N'0', NULL, NULL, N'789945643123')
GO

INSERT INTO [dbo].[Health_knowledge_form] VALUES (N'4', N'4', N'2', N'0', NULL, NULL, N'444444')
GO


-- ----------------------------
-- Table structure for hospital_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[hospital_form]') AND type IN ('U'))
	DROP TABLE [dbo].[hospital_form]
GO

CREATE TABLE [dbo].[hospital_form] (
  [hospital_id] bigint  NOT NULL,
  [hospital_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [address] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [corporate] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [phone] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[hospital_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of hospital_form
-- ----------------------------
INSERT INTO [dbo].[hospital_form] VALUES (N'1', N'桂林人民医院', N'桂林市', N'政府', N'0771-885965')
GO


-- ----------------------------
-- Table structure for Hospitalization_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Hospitalization_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Hospitalization_form]
GO

CREATE TABLE [dbo].[Hospitalization_form] (
  [Hospitalization_id] bigint  NOT NULL,
  [case_id] bigint  NOT NULL,
  [Hospitalization_number] bigint  NOT NULL,
  [disease_type] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [physician_number] bigint  NOT NULL,
  [chief_physician] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [admission_time] datetime2(7)  NOT NULL,
  [discharge_time] datetime2(7)  NOT NULL
)
GO

ALTER TABLE [dbo].[Hospitalization_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for Inspection_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Inspection_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Inspection_form]
GO

CREATE TABLE [dbo].[Inspection_form] (
  [Inspection_id] bigint  NOT NULL,
  [case_id] bigint  NOT NULL,
  [inspection_item] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [inspection_time] datetime2(7)  NOT NULL,
  [ inspection_conclusion] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[Inspection_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Inspection_form
-- ----------------------------
INSERT INTO [dbo].[Inspection_form] VALUES (N'1', N'1', N'1', N'2020-01-11 23:55:31.0000000', N'1')
GO


-- ----------------------------
-- Table structure for Measurement_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Measurement_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Measurement_form]
GO

CREATE TABLE [dbo].[Measurement_form] (
  [Measurement_id] bigint  NOT NULL,
  [measurement_type] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [unit] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[Measurement_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for Medication_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Medication_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Medication_form]
GO

CREATE TABLE [dbo].[Medication_form] (
  [Medication_id] bigint  NOT NULL,
  [case_id] bigint  NOT NULL,
  [ drug_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [medication_time] datetime2(7)  NOT NULL,
  [precautions] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [start_time] datetime2(7)  NOT NULL
)
GO

ALTER TABLE [dbo].[Medication_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for menu_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[menu_form]') AND type IN ('U'))
	DROP TABLE [dbo].[menu_form]
GO

CREATE TABLE [dbo].[menu_form] (
  [menu_id] bigint  NOT NULL,
  [menu_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [parent_id] bigint  NULL,
  [rank] int  NOT NULL,
  [url] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [type] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[menu_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of menu_form
-- ----------------------------
INSERT INTO [dbo].[menu_form] VALUES (N'1', N'服务', N'-1', N'1', N'javascript:;', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'2', N'通知公告', N'1', N'2', N'/server/inform', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'3', N'健康知识', N'1', N'2', N'/server/health_knowledge', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'4', N'随访管理', N'1', N'2', N'/server/follow_up', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'5', N'档案', N'-1', N'1', N'javascript:;', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'6', N'病史', N'5', N'2', N'/record/medical_history', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'7', N'检查报告', N'5', N'2', N'/record/inspection', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'8', N'用药记录', N'5', N'2', N'/record/medical_record', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'9', N'自检报告', N'5', N'2', N'/record/self_inspection', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'10', N'预警信息', N'-1', N'1', N'javascript:;', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'11', N'预警状况', N'10', N'2', N'/warning/warning_info', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'12', N'历史信息', N'10', N'2', N'/warning/history_info', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'14', N'我的资料', N'-1', N'1', N'/self_center/my_info', N'button')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'15', N'我的团队', N'-1', N'1', N'/self_center/my_team', N'button')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'16', N'安全设置', N'-1', N'1', N'/changepassword', N'button')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'17', N'通知管理', N'-1', N'1', N'javascript:;', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'18', N'通知发布', N'17', N'2', N'/manager/inform', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'19', N'推送审核', N'17', N'2', N'/manager/audit', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'20', N'历史通知', N'17', N'2', N'/manager/inform_history', N'button')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'21', N'信息', N'-1', N'1', N'javascript:;', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'22', N'用户信息', N'21', N'2', N'/inform/user_family_info', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'23', N'小组信息', N'21', N'2', N'/inform/doctor_group_info', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'24', N'合约管理', N'-1', N'1', N'javascript:;', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'25', N'签约', N'24', N'2', N'/info_manager/user_manager', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'26', N'解约', N'24', N'2', N'/info_manager/doctor_manager', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'27', N'监督管理', N'-1', N'1', N'javascript:;', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'28', N'签约情况', N'27', N'2', N'/supervision/sign', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'29', N'医院信息', N'27', N'2', N'/supervision/hospital', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'30', N'居民反馈', N'27', N'2', N'/supervision/estimate', N'menu')
GO

INSERT INTO [dbo].[menu_form] VALUES (N'31', N'服务信息', N'21', N'2', N'/inform/service_info', N'menu')
GO


-- ----------------------------
-- Table structure for menu_role_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[menu_role_form]') AND type IN ('U'))
	DROP TABLE [dbo].[menu_role_form]
GO

CREATE TABLE [dbo].[menu_role_form] (
  [menu_role_id] bigint  NOT NULL,
  [role_id] bigint  NOT NULL,
  [menu_id] bigint  NOT NULL,
  [jurisdiction] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[menu_role_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of menu_role_form
-- ----------------------------
INSERT INTO [dbo].[menu_role_form] VALUES (N'1', N'1', N'1', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'2', N'1', N'2', N'111100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'3', N'1', N'3', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'4', N'1', N'4', N'111100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'5', N'1', N'5', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'6', N'1', N'6', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'7', N'1', N'7', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'8', N'1', N'8', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'9', N'1', N'9', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'10', N'1', N'10', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'11', N'1', N'11', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'12', N'1', N'12', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'13', N'1', N'14', N'111100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'14', N'1', N'15', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'15', N'1', N'16', N'001100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'17', N'2', N'16', N'001100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'18', N'2', N'17', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'19', N'2', N'18', N'111100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'20', N'2', N'19', N'011100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'21', N'2', N'20', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'22', N'2', N'21', N'111100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'23', N'2', N'22', N'111111')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'24', N'2', N'23', N'111111')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'25', N'2', N'24', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'26', N'2', N'25', N'111100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'27', N'2', N'26', N'111100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'28', N'3', N'18', N'111100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'29', N'3', N'20', N'111100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'30', N'3', N'28', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'32', N'3', N'30', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'33', N'3', N'17', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'34', N'3', N'27', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'35', N'2', N'27', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'36', N'2', N'28', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'37', N'2', N'30', N'000100')
GO

INSERT INTO [dbo].[menu_role_form] VALUES (N'38', N'2', N'31', N'000100')
GO


-- ----------------------------
-- Table structure for Notice_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Notice_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Notice_form]
GO

CREATE TABLE [dbo].[Notice_form] (
  [Notice_id ] bigint  NOT NULL,
  [title] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [content] text COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [time] datetime2(7)  NOT NULL,
  [publisher] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [hospital_id] bigint  NULL
)
GO

ALTER TABLE [dbo].[Notice_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Notice_form
-- ----------------------------
INSERT INTO [dbo].[Notice_form] VALUES (N'4', N'111', N'111', N'2019-10-25 16:41:49.0000000', N'111', NULL)
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'5', N'111', N'111', N'2019-10-25 16:41:49.0000000', N'111', NULL)
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'6', N'111', N'111', N'2019-10-25 16:41:49.0000000', N'111', NULL)
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'7', N'111', N'111', N'2019-10-25 16:41:49.0000000', N'111', NULL)
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'8', N'111', N'111', N'2019-10-25 16:41:49.0000000', N'111', NULL)
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'9', N'111', N'111', N'2019-10-25 16:41:49.0000000', N'111', NULL)
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'10', N'111', N'111', N'2019-10-25 16:41:49.0000000', N'111', NULL)
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'11', N'123', N'123456', N'2019-10-30 19:21:50.0000000', N'李四', N'1')
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'13', N'456', N'<p>&nbsp; &nbsp; &nbsp; &nbsp; 对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。</p><p>&nbsp; &nbsp; &nbsp; &nbsp;对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。</p>', N'2019-10-31 00:31:43.0000000', N'李四', N'1')
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'14', N'test', N'<p>&nbsp; &nbsp; &nbsp; &nbsp; 水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的。</p><p>&nbsp; &nbsp; &nbsp; &nbsp; 水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的。</p>', N'2019-10-31 23:18:03.0000000', N'李四', N'1')
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'15', N'789', N'<p style="text-align: center;">213<b>23</b><i style="font-weight: bold;">213</i><u><i style="font-weight: bold;">123</i>123</u><strike>123</strike></p><p style="text-align: center;"><a target="_self" href="https://www.baidu.com">百度</a></p><p style="text-align: center;"><img src="http://localhost:8080/layui/images/face/6.gif" alt="[吃惊]"><br></p>', N'2019-11-01 10:44:03.0000000', N'李四', N'1')
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'16', N'123', N'<p style="text-align: center;">12321312312321321321111111111111111133333333333333333333</p>', N'2019-11-02 00:09:25.0000000', N'李四', N'1')
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'17', N'525', N'<p>524</p><p>25</p>', N'2019-12-04 21:00:34.0000000', N'李四', N'1')
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'18', N'524', N'42542', N'2019-12-04 21:00:50.0000000', N'李四', N'1')
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'19', N'7275', N'<p><br></p><p>42</p><p>22</p><p>45255</p>', N'2019-12-04 21:01:06.0000000', N'李四', N'1')
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'20', N'2', N'<p><br></p><p>25</p><p>2</p><p>2</p><p>2</p>', N'2019-12-04 00:00:00.0000000', N'李四', N'1')
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'21', N'2', N'<p><br></p><p>24</p><p>2</p><p>2</p><p><br></p>', N'2019-12-04 00:00:00.0000000', N'李四', N'1')
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'22', N'2525', N'2552525', N'2019-12-04 21:01:54.0000000', N'李四', N'1')
GO

INSERT INTO [dbo].[Notice_form] VALUES (N'23', N'123', N'4354045433453<strike>4534343</strike>4535344<u>5343445<i>345345</i>453453453</u>453<b>45343453453</b>', N'2020-01-08 22:26:42.0000000', N'王五', N'1')
GO


-- ----------------------------
-- Table structure for obsterical_history_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[obsterical_history_form]') AND type IN ('U'))
	DROP TABLE [dbo].[obsterical_history_form]
GO

CREATE TABLE [dbo].[obsterical_history_form] (
  [obsterical_id] bigint  NOT NULL,
  [card_id] varchar(30) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [marriage] varchar(25) COLLATE Chinese_PRC_CI_AS  NULL,
  [birth] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[obsterical_history_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for operation_history_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[operation_history_form]') AND type IN ('U'))
	DROP TABLE [dbo].[operation_history_form]
GO

CREATE TABLE [dbo].[operation_history_form] (
  [operation_id] bigint  NOT NULL,
  [card_id] varchar(30) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [operation_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [date] datetime2(7)  NOT NULL,
  [describe] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[operation_history_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for past_history_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[past_history_form]') AND type IN ('U'))
	DROP TABLE [dbo].[past_history_form]
GO

CREATE TABLE [dbo].[past_history_form] (
  [past_id] bigint  NOT NULL,
  [card_id] varchar(30) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [describe] text COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[past_history_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for Purchase_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Purchase_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Purchase_form]
GO

CREATE TABLE [dbo].[Purchase_form] (
  [Purchase_id] bigint  NOT NULL,
  [purchase_family_id] bigint  NOT NULL,
  [purchase_time] datetime2(7)  NOT NULL,
  [device_id] bigint  NOT NULL,
  [handle_id] bigint  NOT NULL
)
GO

ALTER TABLE [dbo].[Purchase_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for role_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[role_form]') AND type IN ('U'))
	DROP TABLE [dbo].[role_form]
GO

CREATE TABLE [dbo].[role_form] (
  [role_id] bigint  NOT NULL,
  [role_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [role_describe] text COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[role_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of role_form
-- ----------------------------
INSERT INTO [dbo].[role_form] VALUES (N'1', N'ROLE_doctor', N'医生')
GO

INSERT INTO [dbo].[role_form] VALUES (N'2', N'ROLE_admin', N'管理员')
GO

INSERT INTO [dbo].[role_form] VALUES (N'3', N'ROLE_government', N'政府监管人员')
GO


-- ----------------------------
-- Table structure for Self_check_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Self_check_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Self_check_form]
GO

CREATE TABLE [dbo].[Self_check_form] (
  [Self_check_id] bigint  NOT NULL,
  [card_id] varchar(30) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [measurement_id] bigint  NOT NULL,
  [measurement_time] datetime2(7)  NOT NULL,
  [measurement_result] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [device_id] bigint  NULL,
  [device_source] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [usage_time] datetime2(7)  NULL
)
GO

ALTER TABLE [dbo].[Self_check_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for Service_record_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Service_record_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Service_record_form]
GO

CREATE TABLE [dbo].[Service_record_form] (
  [Service_id] bigint  NOT NULL,
  [service_time] datetime2(7)  NOT NULL,
  [doctor_group_id] bigint  NOT NULL,
  [family_id] bigint  NOT NULL,
  [family_member_id] bigint  NOT NULL,
  [service_content] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [service_type] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [service_evaluation] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [hospital_id] bigint  NOT NULL
)
GO

ALTER TABLE [dbo].[Service_record_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Service_record_form
-- ----------------------------
INSERT INTO [dbo].[Service_record_form] VALUES (N'1', N'2020-01-07 01:07:56.0000000', N'1', N'1', N'1', N'123', N'123', N'123', N'1')
GO


-- ----------------------------
-- Table structure for Surgery_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Surgery_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Surgery_form]
GO

CREATE TABLE [dbo].[Surgery_form] (
  [Surgery_id] bigint  NOT NULL,
  [case_id] bigint  NOT NULL,
  [surgical_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [operative_time] datetime2(7)  NOT NULL,
  [surgical_description] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [surgeon] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[Surgery_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for Threshold_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Threshold_form]') AND type IN ('U'))
	DROP TABLE [dbo].[Threshold_form]
GO

CREATE TABLE [dbo].[Threshold_form] (
  [id] bigint  NOT NULL,
  [code] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [preset_value] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [measurement_type] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [Measurement_id] bigint  NOT NULL
)
GO

ALTER TABLE [dbo].[Threshold_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for unit_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[unit_form]') AND type IN ('U'))
	DROP TABLE [dbo].[unit_form]
GO

CREATE TABLE [dbo].[unit_form] (
  [unit_id] bigint  NOT NULL,
  [unit_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [corporate] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [phone] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [address] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[unit_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for user_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[user_form]') AND type IN ('U'))
	DROP TABLE [dbo].[user_form]
GO

CREATE TABLE [dbo].[user_form] (
  [uesr_id] bigint  NOT NULL,
  [user_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [password] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [hospital_id] bigint  NOT NULL,
  [doctor_id] bigint  NULL
)
GO

ALTER TABLE [dbo].[user_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_form
-- ----------------------------
INSERT INTO [dbo].[user_form] VALUES (N'1', N'张三', N'$2a$10$f0DEGrkIpYyzcFrf/fTMSOAKl1Y/XHpKaijWdfiWnOOzGTEs8diLi', N'1', N'1')
GO

INSERT INTO [dbo].[user_form] VALUES (N'2', N'李四', N'$2a$10$f0DEGrkIpYyzcFrf/fTMSOAKl1Y/XHpKaijWdfiWnOOzGTEs8diLi', N'1', NULL)
GO

INSERT INTO [dbo].[user_form] VALUES (N'3', N'王五', N'$2a$10$f0DEGrkIpYyzcFrf/fTMSOAKl1Y/XHpKaijWdfiWnOOzGTEs8diLi', N'1', NULL)
GO

INSERT INTO [dbo].[user_form] VALUES (N'4', N'061234', N'$2a$10$gDaYeQt96JykryY0duEBruQhAjI0aMZEBWlUkFkjDNDwn6uThIUhm', N'1', N'1')
GO

INSERT INTO [dbo].[user_form] VALUES (N'5', N'231572', N'$2a$10$DwUPw03bRR8IFBpH/SBmQe1kM0tUm93PrQ9RPEPBDgzpzUcwGIGUW', N'1', N'2')
GO


-- ----------------------------
-- Table structure for user_role_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[user_role_form]') AND type IN ('U'))
	DROP TABLE [dbo].[user_role_form]
GO

CREATE TABLE [dbo].[user_role_form] (
  [user_role_id] bigint  NOT NULL,
  [user_id] bigint  NOT NULL,
  [role_id] bigint  NOT NULL
)
GO

ALTER TABLE [dbo].[user_role_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_role_form
-- ----------------------------
INSERT INTO [dbo].[user_role_form] VALUES (N'1', N'1', N'1')
GO

INSERT INTO [dbo].[user_role_form] VALUES (N'2', N'2', N'2')
GO

INSERT INTO [dbo].[user_role_form] VALUES (N'3', N'3', N'3')
GO

INSERT INTO [dbo].[user_role_form] VALUES (N'4', N'4', N'1')
GO

INSERT INTO [dbo].[user_role_form] VALUES (N'5', N'5', N'1')
GO


-- ----------------------------
-- Table structure for warning_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[warning_form]') AND type IN ('U'))
	DROP TABLE [dbo].[warning_form]
GO

CREATE TABLE [dbo].[warning_form] (
  [warning_id] bigint  NOT NULL,
  [type] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[warning_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for warning_history_form
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[warning_history_form]') AND type IN ('U'))
	DROP TABLE [dbo].[warning_history_form]
GO

CREATE TABLE [dbo].[warning_history_form] (
  [warning_history_id] bigint  NOT NULL,
  [detector] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [card_id] varchar(30) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [content] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [time] datetime2(7)  NOT NULL
)
GO

ALTER TABLE [dbo].[warning_history_form] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Auto increment value for allergy_history_form
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[allergy_history_form]', RESEED, 1)
GO


-- ----------------------------
-- Primary Key structure for table allergy_history_form
-- ----------------------------
ALTER TABLE [dbo].[allergy_history_form] ADD CONSTRAINT [PK__allergy___ACDD0692B618425C] PRIMARY KEY CLUSTERED ([allergy_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table case_form
-- ----------------------------
ALTER TABLE [dbo].[case_form] ADD CONSTRAINT [PK__case_for__D061E8FD498E3BF4] PRIMARY KEY CLUSTERED ([Case_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Complaint_form
-- ----------------------------
ALTER TABLE [dbo].[Complaint_form] ADD CONSTRAINT [PK__Complain__3213E83F49437B52] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table device_form
-- ----------------------------
ALTER TABLE [dbo].[device_form] ADD CONSTRAINT [PK__device_f__3B085D8BAA7D94ED] PRIMARY KEY CLUSTERED ([device_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table doctor_form
-- ----------------------------
ALTER TABLE [dbo].[doctor_form] ADD CONSTRAINT [PK__doctor_f__F399356475020F07] PRIMARY KEY CLUSTERED ([doctor_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table doctor_group_form
-- ----------------------------
ALTER TABLE [dbo].[doctor_group_form] ADD CONSTRAINT [PK__doctor_g__463B200E449502C6] PRIMARY KEY CLUSTERED ([doctor_group_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table evaluation_form
-- ----------------------------
ALTER TABLE [dbo].[evaluation_form] ADD CONSTRAINT [PK__evaluati__827C592D226F05BA] PRIMARY KEY CLUSTERED ([evaluation_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table family_doctor_form
-- ----------------------------
ALTER TABLE [dbo].[family_doctor_form] ADD CONSTRAINT [PK__family_d__012A65C2B4D9B701] PRIMARY KEY CLUSTERED ([family_doctor_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table family_form
-- ----------------------------
ALTER TABLE [dbo].[family_form] ADD CONSTRAINT [PK__family_f__28829CD65028D544] PRIMARY KEY CLUSTERED ([family_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table family_history_form
-- ----------------------------
ALTER TABLE [dbo].[family_history_form] ADD CONSTRAINT [PK__family_h__5AE3CD572887763F] PRIMARY KEY CLUSTERED ([family_history_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table family_member_form
-- ----------------------------
ALTER TABLE [dbo].[family_member_form] ADD CONSTRAINT [PK__family_m__E420B0AC8E5B1F60] PRIMARY KEY CLUSTERED ([family_member_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Follow_up_form
-- ----------------------------
ALTER TABLE [dbo].[Follow_up_form] ADD CONSTRAINT [PK__Follow_u__3615AE697AF0ECC5] PRIMARY KEY CLUSTERED ([Follow_up_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Health_knowledge_form
-- ----------------------------
ALTER TABLE [dbo].[Health_knowledge_form] ADD CONSTRAINT [PK__Health_k__B8658ACB5C6B1637] PRIMARY KEY CLUSTERED ([Health_knowledge_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table hospital_form
-- ----------------------------
ALTER TABLE [dbo].[hospital_form] ADD CONSTRAINT [PK__hospital__DFF4167F01A8435D] PRIMARY KEY CLUSTERED ([hospital_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Hospitalization_form
-- ----------------------------
ALTER TABLE [dbo].[Hospitalization_form] ADD CONSTRAINT [PK__Hospital__58D0F69B61EA7338] PRIMARY KEY CLUSTERED ([Hospitalization_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Inspection_form
-- ----------------------------
ALTER TABLE [dbo].[Inspection_form] ADD CONSTRAINT [PK__Inspecti__81452432C5178F58] PRIMARY KEY CLUSTERED ([Inspection_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Measurement_form
-- ----------------------------
ALTER TABLE [dbo].[Measurement_form] ADD CONSTRAINT [PK__Measurem__264FB4EA01E9207A] PRIMARY KEY CLUSTERED ([Measurement_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Medication_form
-- ----------------------------
ALTER TABLE [dbo].[Medication_form] ADD CONSTRAINT [PK__Medicati__8CBC31C1A3984E44] PRIMARY KEY CLUSTERED ([Medication_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table menu_form
-- ----------------------------
ALTER TABLE [dbo].[menu_form] ADD CONSTRAINT [PK__menu_for__4CA0FADC9E8DF0D8] PRIMARY KEY CLUSTERED ([menu_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table menu_role_form
-- ----------------------------
ALTER TABLE [dbo].[menu_role_form] ADD CONSTRAINT [PK__menu_rol__2C8AF4C3276F2B2D] PRIMARY KEY CLUSTERED ([menu_role_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Notice_form
-- ----------------------------
ALTER TABLE [dbo].[Notice_form] ADD CONSTRAINT [PK__Notice_f__E99E03A33361CF40] PRIMARY KEY CLUSTERED ([Notice_id ])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table obsterical_history_form
-- ----------------------------
ALTER TABLE [dbo].[obsterical_history_form] ADD CONSTRAINT [PK__obsteric__B54EF10E233234DC] PRIMARY KEY CLUSTERED ([obsterical_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table operation_history_form
-- ----------------------------
ALTER TABLE [dbo].[operation_history_form] ADD CONSTRAINT [PK__operatio__9DE171239A0B1AEE] PRIMARY KEY CLUSTERED ([operation_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table past_history_form
-- ----------------------------
ALTER TABLE [dbo].[past_history_form] ADD CONSTRAINT [PK__past_his__30C6ADF4BDA9795D] PRIMARY KEY CLUSTERED ([past_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Purchase_form
-- ----------------------------
ALTER TABLE [dbo].[Purchase_form] ADD CONSTRAINT [PK__Purchase__543D615BB8632628] PRIMARY KEY CLUSTERED ([Purchase_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table role_form
-- ----------------------------
ALTER TABLE [dbo].[role_form] ADD CONSTRAINT [PK__role_for__760965CC8EDDFDC0] PRIMARY KEY CLUSTERED ([role_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Self_check_form
-- ----------------------------
ALTER TABLE [dbo].[Self_check_form] ADD CONSTRAINT [PK__Self_che__372080FF006A8E54] PRIMARY KEY CLUSTERED ([Self_check_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Service_record_form
-- ----------------------------
ALTER TABLE [dbo].[Service_record_form] ADD CONSTRAINT [PK__Service___BD0537B4046A176D] PRIMARY KEY CLUSTERED ([Service_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Surgery_form
-- ----------------------------
ALTER TABLE [dbo].[Surgery_form] ADD CONSTRAINT [PK__Surgery___8F1229ADAA3345BA] PRIMARY KEY CLUSTERED ([Surgery_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Threshold_form
-- ----------------------------
ALTER TABLE [dbo].[Threshold_form] ADD CONSTRAINT [PK__Threshol__3213E83FCF43C535] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table unit_form
-- ----------------------------
ALTER TABLE [dbo].[unit_form] ADD CONSTRAINT [PK__unit_for__D3AF5BD7FF4B594C] PRIMARY KEY CLUSTERED ([unit_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table user_form
-- ----------------------------
ALTER TABLE [dbo].[user_form] ADD CONSTRAINT [PK__user_for__F6462242B5A1F13A] PRIMARY KEY CLUSTERED ([uesr_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table user_role_form
-- ----------------------------
ALTER TABLE [dbo].[user_role_form] ADD CONSTRAINT [PK__user_rol__B8D9ABA2FB7C2AEA] PRIMARY KEY CLUSTERED ([user_role_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table warning_form
-- ----------------------------
ALTER TABLE [dbo].[warning_form] ADD CONSTRAINT [PK__Alert_fo__DA62560F668C9782] PRIMARY KEY CLUSTERED ([warning_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table warning_history_form
-- ----------------------------
ALTER TABLE [dbo].[warning_history_form] ADD CONSTRAINT [PK__warning___DE09EFEA03FD9E8F] PRIMARY KEY CLUSTERED ([warning_history_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

