/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : jtys

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 27/01/2020 12:12:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for allergy_history_form
-- ----------------------------
DROP TABLE IF EXISTS `allergy_history_form`;
CREATE TABLE `allergy_history_form`  (
  `card_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `allergen` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `allergy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`allergy_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of allergy_history_form
-- ----------------------------
INSERT INTO `allergy_history_form` VALUES ('452123197503311254', '777', '777', 1);

-- ----------------------------
-- Table structure for case_form
-- ----------------------------
DROP TABLE IF EXISTS `case_form`;
CREATE TABLE `case_form`  (
  `card_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hospital` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `Case_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Case_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of case_form
-- ----------------------------
INSERT INTO `case_form` VALUES ('452123199405075678', '0100', '1', '1900-01-20 23:55:10', 1);
INSERT INTO `case_form` VALUES ('452123199405075678', '0100', '1', '1900-01-20 16:41:47', 2);
INSERT INTO `case_form` VALUES ('452456200101023412', '0100', '1', '1900-01-20 16:42:23', 3);
INSERT INTO `case_form` VALUES ('452123197503311254', '1111', '1', '1900-01-20 22:25:50', 4);
INSERT INTO `case_form` VALUES ('452123197503311254', '0110', '1', '1900-01-20 23:15:24', 5);

-- ----------------------------
-- Table structure for complaint_form
-- ----------------------------
DROP TABLE IF EXISTS `complaint_form`;
CREATE TABLE `complaint_form`  (
  `id` bigint(20) NOT NULL,
  `complainant` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `doctor_id` bigint(20) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for device_form
-- ----------------------------
DROP TABLE IF EXISTS `device_form`;
CREATE TABLE `device_form`  (
  `device_id` bigint(20) NOT NULL,
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `equipment_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `purchase_time` datetime(0) NULL DEFAULT NULL,
  `purchaser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `purchase_quantity` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for doctor_form
-- ----------------------------
DROP TABLE IF EXISTS `doctor_form`;
CREATE TABLE `doctor_form`  (
  `doctor_id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `card_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `duty` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `doctor_group_id` bigint(20) NULL DEFAULT NULL,
  `hospital_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`doctor_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor_form
-- ----------------------------
INSERT INTO `doctor_form` VALUES (1, '张三', 38, '男', '452123198105061234', '主任', '心脑', '13878754236', 1, 1);
INSERT INTO `doctor_form` VALUES (2, '李五', 45, '男', '452123789654231572', '医师', '心脑', '15246786698', 2, 1);

-- ----------------------------
-- Table structure for doctor_group_form
-- ----------------------------
DROP TABLE IF EXISTS `doctor_group_form`;
CREATE TABLE `doctor_group_form`  (
  `doctor_group_id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `group_leader_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `group_leader_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `second_leader_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `second_leader_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `speciality` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `service_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hospital_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`doctor_group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor_group_form
-- ----------------------------
INSERT INTO `doctor_group_form` VALUES (1, '1', '张三', '123564', '李四', '345453', '心脑', '桂林', 1);
INSERT INTO `doctor_group_form` VALUES (2, '2', '李五', '15246786698', '万流', '15278365498', '心脑', '灵川', 1);

-- ----------------------------
-- Table structure for evaluation_form
-- ----------------------------
DROP TABLE IF EXISTS `evaluation_form`;
CREATE TABLE `evaluation_form`  (
  `evaluation_id` bigint(20) NOT NULL,
  `evaluator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `doctor_id` bigint(20) NULL DEFAULT NULL,
  `evaluation_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`evaluation_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluation_form
-- ----------------------------
INSERT INTO `evaluation_form` VALUES (1, '张5', 1, '123', '1900-01-20 22:14:37');
INSERT INTO `evaluation_form` VALUES (2, '22', 1, '252', '1900-01-20 22:17:30');
INSERT INTO `evaluation_form` VALUES (3, '453', 1, '2222', '1900-01-20 22:17:47');
INSERT INTO `evaluation_form` VALUES (4, '225', 1, '41414', '1900-01-20 22:18:00');
INSERT INTO `evaluation_form` VALUES (5, '552', 1, '2752', '1900-01-20 22:18:12');
INSERT INTO `evaluation_form` VALUES (6, '666', 1, '7527', '1900-01-20 22:18:23');
INSERT INTO `evaluation_form` VALUES (7, '777', 1, '777', '1900-01-20 22:18:35');
INSERT INTO `evaluation_form` VALUES (8, '888', 1, '888', '1900-01-20 22:18:46');
INSERT INTO `evaluation_form` VALUES (9, '999', 1, '999', '1900-01-20 22:18:59');
INSERT INTO `evaluation_form` VALUES (10, '1010', 1, '1010', '1900-01-20 22:19:12');
INSERT INTO `evaluation_form` VALUES (11, '1111', 1, '1111', '1900-01-20 22:19:24');

-- ----------------------------
-- Table structure for family_doctor_form
-- ----------------------------
DROP TABLE IF EXISTS `family_doctor_form`;
CREATE TABLE `family_doctor_form`  (
  `family_doctor_id` bigint(20) NOT NULL,
  `doctor_group_id` bigint(20) NULL DEFAULT NULL,
  `family_id` bigint(20) NULL DEFAULT NULL,
  `date_of_contract` datetime(0) NULL DEFAULT NULL,
  `contract_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `contract_duration` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`family_doctor_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of family_doctor_form
-- ----------------------------
INSERT INTO `family_doctor_form` VALUES (2, -1, 6, '1900-01-20 01:04:38', '合同内容', 1);
INSERT INTO `family_doctor_form` VALUES (3, -1, 7, '1900-01-20 01:04:38', '合同内容', 1);
INSERT INTO `family_doctor_form` VALUES (4, 1, 8, '1900-01-20 11:50:30', '合同内容', 1);
INSERT INTO `family_doctor_form` VALUES (5, -1, 1, '1900-01-20 19:55:29', '123456', 1);
INSERT INTO `family_doctor_form` VALUES (6, -1, 5, '2020-01-24 16:17:32', '合同内容', 1);

-- ----------------------------
-- Table structure for family_form
-- ----------------------------
DROP TABLE IF EXISTS `family_form`;
CREATE TABLE `family_form`  (
  `family_id` bigint(20) NOT NULL,
  `householder_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `population` int(11) NULL DEFAULT NULL,
  `householder_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hospital_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`family_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of family_form
-- ----------------------------
INSERT INTO `family_form` VALUES (1, '黎明', 2, '13878890236', '广西桂林灵川县灵田村', 1);
INSERT INTO `family_form` VALUES (3, '滴滴滴', 2, '13578555434', '啦啦啦啦', 1);
INSERT INTO `family_form` VALUES (4, '黎明', 1, '13878890236', '广西桂林灵川县灵田村', 1);
INSERT INTO `family_form` VALUES (5, '大大', 0, '13878770256', '广西桂林', 1);
INSERT INTO `family_form` VALUES (6, '回聊', 0, '15248763468', '中国', 1);
INSERT INTO `family_form` VALUES (7, '解决', 1, '13568975468', '桂林', 1);
INSERT INTO `family_form` VALUES (8, '大黄蜂', 1, '15246786685', '灵川', 1);

-- ----------------------------
-- Table structure for family_history_form
-- ----------------------------
DROP TABLE IF EXISTS `family_history_form`;
CREATE TABLE `family_history_form`  (
  `family_history_id` bigint(20) NOT NULL,
  `card_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `relation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `illness_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`family_history_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of family_history_form
-- ----------------------------
INSERT INTO `family_history_form` VALUES (1, '452123197503311254', '123', '123', '123');

-- ----------------------------
-- Table structure for family_member_form
-- ----------------------------
DROP TABLE IF EXISTS `family_member_form`;
CREATE TABLE `family_member_form`  (
  `family_member_id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `card_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `family_id` bigint(20) NULL DEFAULT NULL,
  `emergency_contact_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emergency_contact_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`family_member_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of family_member_form
-- ----------------------------
INSERT INTO `family_member_form` VALUES (2, '黎明否', 18, '男', '452456200101023412', '13435689764', '$2a$10$aLEqDLbqw87GfKDfLAiXeeoVaEDYaIgC6zlTd45XByqKrfYt7IJYK', 1, '黎明', '13435689764');
INSERT INTO `family_member_form` VALUES (3, '黎明', 56, '男', '453123497402067612', '13845678965', '$2a$10$7JA51d9WF0wpWrVcGygNh.4v.DeNaDYpQVW4unplsh2fa1wDDG7si', 1, '黎明否', '13845678965');
INSERT INTO `family_member_form` VALUES (4, '滴水', 18, '男', '452123200201015874', '15278963356', '$2a$10$moD/PwVvyCqi6kKO7eXu0Os96V539loi8W/DRSr07g1hx0TV5ZRrm', 3, '滴滴滴', '13578555434');
INSERT INTO `family_member_form` VALUES (5, '滴滴滴', 45, '男', '452123197524311254', '13578555434', '$2a$10$TOgVOOrjsEGrkJMo/JAVR.Mp4rco7Z.eq6aqc9mzo50JGM59iTtvG', 3, '滴滴滴', '13578555434');
INSERT INTO `family_member_form` VALUES (6, '大黄蜂', 45, '男', '452123197503311254', '13578773265', '$2a$10$TOgVOOrjsEGrkJMo/JAVR.Mp4rco7Z.eq6aqc9mzo50JGM59iTtvG', 8, '123132', '12313456456');
INSERT INTO `family_member_form` VALUES (7, '解武', 19, '男', '452132456856235689', '13878785469', '$2a$10$2qS4cJX16ns5.SrDikVedefe61VgF1YfwjnI3465k7aoEVJFRji6G', 7, '解决', '13878775462');
INSERT INTO `family_member_form` VALUES (8, '黎明', 14, '男', '453334537864636752', '13801315373', '$2a$10$Te1uTWF9rJU.gr/3mVAgiepuzAJECu0BFc6Kpg9wUFBsrr0GwfS6e', 4, '123', '13221143463');

-- ----------------------------
-- Table structure for follow_up_form
-- ----------------------------
DROP TABLE IF EXISTS `follow_up_form`;
CREATE TABLE `follow_up_form`  (
  `Follow_up_id` bigint(20) NOT NULL,
  `doctor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `accompanying` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `family_id` bigint(20) NULL DEFAULT NULL,
  `family_member_id` bigint(20) NULL DEFAULT NULL,
  `health_assessment` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `doctor_id` bigint(20) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Follow_up_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of follow_up_form
-- ----------------------------
INSERT INTO `follow_up_form` VALUES (0, '张三', '无', '走访', '1900-01-20 12:30:30', '医疗后回访', 1, 2, '健康', 1, 1);
INSERT INTO `follow_up_form` VALUES (1, '张三', '无', '走访', '1900-01-20 12:30:30', '医疗后回访', 1, 2, '健康', 1, 1);

-- ----------------------------
-- Table structure for health_knowledge_form
-- ----------------------------
DROP TABLE IF EXISTS `health_knowledge_form`;
CREATE TABLE `health_knowledge_form`  (
  `Health_knowledge_id` bigint(20) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `publisher_id` bigint(20) NULL DEFAULT NULL,
  `review_status` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reviewer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `review_time` datetime(0) NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of health_knowledge_form
-- ----------------------------
INSERT INTO `health_knowledge_form` VALUES (1, '2', 1, '1', '李四', '1900-01-20 10:55:30', '123456');
INSERT INTO `health_knowledge_form` VALUES (2, '2', 1, '-1', '李四', '1900-01-20 11:04:16', '123456');
INSERT INTO `health_knowledge_form` VALUES (3, '3', 1, '0', '李四', '1900-01-20 19:00:37', '789945643123');
INSERT INTO `health_knowledge_form` VALUES (4, '4', 1, '0', '21', '1900-01-20 19:27:55', '12345638345');
INSERT INTO `health_knowledge_form` VALUES (5, '12312', 1, '0', NULL, NULL, '123123');
INSERT INTO `health_knowledge_form` VALUES (6, '123123', 1, '0', NULL, NULL, '123123123');
INSERT INTO `health_knowledge_form` VALUES (7, '45321', 1, '0', NULL, NULL, '312345312');
INSERT INTO `health_knowledge_form` VALUES (8, '45321', 1, '0', NULL, NULL, '143512');
INSERT INTO `health_knowledge_form` VALUES (9, '12345312', 1, '0', NULL, NULL, '123541233');
INSERT INTO `health_knowledge_form` VALUES (10, '45321', 1, '0', NULL, NULL, '45312');
INSERT INTO `health_knowledge_form` VALUES (11, '45312', 1, '0', NULL, NULL, '543125312');
INSERT INTO `health_knowledge_form` VALUES (12, '45312', 1, '0', NULL, NULL, '4531234532<img src=\"http://localhost:8080/layui/images/face/15.gif\" alt=\"[生病]\">3554<img src=\"http://localhost:8080/layui/images/face/21.gif\" alt=\"[衰]\">43123<a target=\"_blank\" href=\"http://www.baidu.com\">http://www.baidu.com</a>');

-- ----------------------------
-- Table structure for hospital_form
-- ----------------------------
DROP TABLE IF EXISTS `hospital_form`;
CREATE TABLE `hospital_form`  (
  `hospital_id` bigint(20) NOT NULL,
  `hospital_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `corporate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`hospital_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospital_form
-- ----------------------------
INSERT INTO `hospital_form` VALUES (1, '桂林人民医院', '桂林市', '政府', '0771-885965');

-- ----------------------------
-- Table structure for hospitalization_form
-- ----------------------------
DROP TABLE IF EXISTS `hospitalization_form`;
CREATE TABLE `hospitalization_form`  (
  `Hospitalization_id` bigint(20) NOT NULL,
  `case_id` bigint(20) NULL DEFAULT NULL,
  `Hospitalization_number` bigint(20) NULL DEFAULT NULL,
  `disease_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `physician_number` bigint(20) NULL DEFAULT NULL,
  `chief_physician` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admission_time` datetime(0) NULL DEFAULT NULL,
  `discharge_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`Hospitalization_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospitalization_form
-- ----------------------------
INSERT INTO `hospitalization_form` VALUES (1, 4, 4521234578, '肠道手术', NULL, '张三', '1900-01-20 23:01:43', '1900-01-20 23:01:56');

-- ----------------------------
-- Table structure for inspection_form
-- ----------------------------
DROP TABLE IF EXISTS `inspection_form`;
CREATE TABLE `inspection_form`  (
  `Inspection_id` bigint(20) NOT NULL,
  `case_id` bigint(20) NULL DEFAULT NULL,
  `inspection_item` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `inspection_time` datetime(0) NULL DEFAULT NULL,
  ` inspection_conclusion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Inspection_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inspection_form
-- ----------------------------
INSERT INTO `inspection_form` VALUES (1, 1, '1', '1900-01-20 23:55:31', '1');
INSERT INTO `inspection_form` VALUES (2, 2, '1', '1900-01-20 16:42:46', '1');
INSERT INTO `inspection_form` VALUES (3, 3, '1', '1900-01-20 16:43:11', '1');
INSERT INTO `inspection_form` VALUES (4, 4, '1', '1900-01-20 23:02:20', '1');
INSERT INTO `inspection_form` VALUES (5, 5, '1', '1900-01-20 23:16:32', '123');

-- ----------------------------
-- Table structure for measurement_form
-- ----------------------------
DROP TABLE IF EXISTS `measurement_form`;
CREATE TABLE `measurement_form`  (
  `Measurement_id` bigint(20) NOT NULL,
  `measurement_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Measurement_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of measurement_form
-- ----------------------------
INSERT INTO `measurement_form` VALUES (1, 'blood_pressure', 'mmHg');
INSERT INTO `measurement_form` VALUES (2, 'blood_sugar', 'mmol/L');
INSERT INTO `measurement_form` VALUES (3, 'heart_rate', '次/分');
INSERT INTO `measurement_form` VALUES (4, 'body_temperature', '℃');
INSERT INTO `measurement_form` VALUES (5, 'weight', 'kg');

-- ----------------------------
-- Table structure for medication_form
-- ----------------------------
DROP TABLE IF EXISTS `medication_form`;
CREATE TABLE `medication_form`  (
  `Medication_id` bigint(20) NOT NULL,
  `case_id` bigint(20) NULL DEFAULT NULL,
  ` drug_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `medication_time` datetime(0) NULL DEFAULT NULL,
  `precautions` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`Medication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medication_form
-- ----------------------------
INSERT INTO `medication_form` VALUES (1, 4, '123', '1900-01-20 23:02:36', '121', '1900-01-20 23:02:43');
INSERT INTO `medication_form` VALUES (2, 5, '123', '1900-01-20 23:17:05', '123', '1900-01-20 23:17:08');

-- ----------------------------
-- Table structure for menu_form
-- ----------------------------
DROP TABLE IF EXISTS `menu_form`;
CREATE TABLE `menu_form`  (
  `menu_id` bigint(20) NOT NULL,
  `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `rank` int(11) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_form
-- ----------------------------
INSERT INTO `menu_form` VALUES (1, '服务', -1, 1, 'javascript:;', 'menu');
INSERT INTO `menu_form` VALUES (2, '通知公告', 1, 2, '/doctor/notice', 'menu');
INSERT INTO `menu_form` VALUES (3, '健康知识', 1, 2, '/doctor/health_knowledge', 'menu');
INSERT INTO `menu_form` VALUES (4, '随访管理', 1, 2, '/doctor/follow_up', 'menu');
INSERT INTO `menu_form` VALUES (5, '档案', -1, 1, 'javascript:;', 'menu');
INSERT INTO `menu_form` VALUES (6, '病史', 5, 2, '/doctor/medical_history', 'menu');
INSERT INTO `menu_form` VALUES (7, '病例', 5, 2, '/doctor/case', 'menu');
INSERT INTO `menu_form` VALUES (8, '用药记录', 5, 2, '/doctor/medical_record', 'button');
INSERT INTO `menu_form` VALUES (9, '自检报告', 5, 2, '/doctor/self_inspection', 'menu');
INSERT INTO `menu_form` VALUES (10, '预警信息', -1, 1, 'javascript:;', 'menu');
INSERT INTO `menu_form` VALUES (11, '预警状况', 10, 2, '/warning/warning_info', 'menu');
INSERT INTO `menu_form` VALUES (12, '历史信息', 10, 2, '/warning/history_info', 'menu');
INSERT INTO `menu_form` VALUES (14, '我的资料', -1, 1, '/self_center/my_info', 'button');
INSERT INTO `menu_form` VALUES (15, '我的团队', -1, 1, '/self_center/my_team', 'button');
INSERT INTO `menu_form` VALUES (16, '安全设置', -1, 1, '/changePassword', 'button');
INSERT INTO `menu_form` VALUES (17, '通知管理', -1, 1, 'javascript:;', 'menu');
INSERT INTO `menu_form` VALUES (18, '通知发布', 17, 2, '/manager/inform', 'menu');
INSERT INTO `menu_form` VALUES (19, '推送审核', 17, 2, '/manager/audit', 'menu');
INSERT INTO `menu_form` VALUES (20, '历史通知', 17, 2, '/manager/inform_history', 'button');
INSERT INTO `menu_form` VALUES (21, '信息', -1, 1, 'javascript:;', 'menu');
INSERT INTO `menu_form` VALUES (22, '用户信息', 21, 2, '/inform/user_family_info', 'menu');
INSERT INTO `menu_form` VALUES (23, '小组信息', 21, 2, '/inform/doctor_group_info', 'menu');
INSERT INTO `menu_form` VALUES (24, '合约管理', -1, 1, 'javascript:;', 'menu');
INSERT INTO `menu_form` VALUES (25, '签约', 24, 2, '/info_manager/user_manager', 'menu');
INSERT INTO `menu_form` VALUES (26, '解约', 24, 2, '/info_manager/doctor_manager', 'menu');
INSERT INTO `menu_form` VALUES (27, '监督管理', -1, 1, 'javascript:;', 'menu');
INSERT INTO `menu_form` VALUES (28, '签约情况', 27, 2, '/supervision/sign', 'menu');
INSERT INTO `menu_form` VALUES (29, '医院信息', 27, 2, '/supervision/hospital', 'menu');
INSERT INTO `menu_form` VALUES (30, '居民反馈', 27, 2, '/supervision/estimate', 'menu');
INSERT INTO `menu_form` VALUES (31, '服务信息', 21, 2, '/inform/service_info', 'menu');
INSERT INTO `menu_form` VALUES (32, '阈值设置', 10, 2, '/warning/set_threshold', 'menu');

-- ----------------------------
-- Table structure for menu_role_form
-- ----------------------------
DROP TABLE IF EXISTS `menu_role_form`;
CREATE TABLE `menu_role_form`  (
  `menu_role_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NULL DEFAULT NULL,
  `menu_id` bigint(20) NULL DEFAULT NULL,
  `jurisdiction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`menu_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_role_form
-- ----------------------------
INSERT INTO `menu_role_form` VALUES (1, 1, 1, '000100');
INSERT INTO `menu_role_form` VALUES (2, 1, 2, '000100');
INSERT INTO `menu_role_form` VALUES (3, 1, 3, '111100');
INSERT INTO `menu_role_form` VALUES (4, 1, 4, '001100');
INSERT INTO `menu_role_form` VALUES (5, 1, 5, '000100');
INSERT INTO `menu_role_form` VALUES (6, 1, 6, '000100');
INSERT INTO `menu_role_form` VALUES (7, 1, 7, '000100');
INSERT INTO `menu_role_form` VALUES (8, 1, 8, '000100');
INSERT INTO `menu_role_form` VALUES (9, 1, 9, '000100');
INSERT INTO `menu_role_form` VALUES (10, 1, 10, '000100');
INSERT INTO `menu_role_form` VALUES (11, 1, 11, '000100');
INSERT INTO `menu_role_form` VALUES (12, 1, 12, '000100');
INSERT INTO `menu_role_form` VALUES (13, 1, 14, '111100');
INSERT INTO `menu_role_form` VALUES (14, 1, 15, '000100');
INSERT INTO `menu_role_form` VALUES (15, 1, 16, '001100');
INSERT INTO `menu_role_form` VALUES (17, 2, 16, '001100');
INSERT INTO `menu_role_form` VALUES (18, 2, 17, '000100');
INSERT INTO `menu_role_form` VALUES (19, 2, 18, '111100');
INSERT INTO `menu_role_form` VALUES (20, 2, 19, '011100');
INSERT INTO `menu_role_form` VALUES (21, 2, 20, '000100');
INSERT INTO `menu_role_form` VALUES (22, 2, 21, '111100');
INSERT INTO `menu_role_form` VALUES (23, 2, 22, '111111');
INSERT INTO `menu_role_form` VALUES (24, 2, 23, '111111');
INSERT INTO `menu_role_form` VALUES (25, 2, 24, '000100');
INSERT INTO `menu_role_form` VALUES (26, 2, 25, '111100');
INSERT INTO `menu_role_form` VALUES (27, 2, 26, '111100');
INSERT INTO `menu_role_form` VALUES (28, 3, 18, '111100');
INSERT INTO `menu_role_form` VALUES (29, 3, 20, '111100');
INSERT INTO `menu_role_form` VALUES (30, 3, 28, '000100');
INSERT INTO `menu_role_form` VALUES (32, 3, 30, '000100');
INSERT INTO `menu_role_form` VALUES (33, 3, 17, '000100');
INSERT INTO `menu_role_form` VALUES (34, 3, 27, '000100');
INSERT INTO `menu_role_form` VALUES (35, 2, 27, '000100');
INSERT INTO `menu_role_form` VALUES (36, 2, 28, '000100');
INSERT INTO `menu_role_form` VALUES (37, 2, 30, '000100');
INSERT INTO `menu_role_form` VALUES (38, 2, 31, '000100');
INSERT INTO `menu_role_form` VALUES (39, 1, 18, '000100');
INSERT INTO `menu_role_form` VALUES (40, 1, 19, '000100');
INSERT INTO `menu_role_form` VALUES (41, 1, 22, '000100');
INSERT INTO `menu_role_form` VALUES (42, 1, 32, '111100');

-- ----------------------------
-- Table structure for notice_form
-- ----------------------------
DROP TABLE IF EXISTS `notice_form`;
CREATE TABLE `notice_form`  (
  `Notice_id` bigint(20) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hospital_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`Notice_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice_form
-- ----------------------------
INSERT INTO `notice_form` VALUES (4, '111', '111', '1900-01-20 16:41:49', '111', NULL);
INSERT INTO `notice_form` VALUES (5, '111', '111', '1900-01-20 16:41:49', '111', NULL);
INSERT INTO `notice_form` VALUES (6, '111', '111', '1900-01-20 16:41:49', '111', NULL);
INSERT INTO `notice_form` VALUES (7, '111', '111', '1900-01-20 16:41:49', '111', NULL);
INSERT INTO `notice_form` VALUES (8, '111', '111', '1900-01-20 16:41:49', '111', NULL);
INSERT INTO `notice_form` VALUES (9, '111', '111', '1900-01-20 16:41:49', '111', NULL);
INSERT INTO `notice_form` VALUES (10, '111', '111', '1900-01-20 16:41:49', '111', NULL);
INSERT INTO `notice_form` VALUES (13, '456', '<p>&nbsp; &nbsp; &nbsp; &nbsp; 对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。</p><p>&nbsp; &nbsp; &nbsp; &nbsp;对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。对方是否是的是的发送到。</p>', '1900-01-20 00:31:43', '李四', 1);
INSERT INTO `notice_form` VALUES (14, 'test', '<p>&nbsp; &nbsp; &nbsp; &nbsp; 水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的。</p><p>&nbsp; &nbsp; &nbsp; &nbsp; 水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的，水电费水电费是的。</p>', '1900-01-20 23:18:03', '李四', 1);
INSERT INTO `notice_form` VALUES (15, '789', '<p style=\"text-align: center;\">213<b>23</b><i style=\"font-weight: bold;\">213</i><u><i style=\"font-weight: bold;\">123</i>123</u><strike>123</strike></p><p style=\"text-align: center;\"><a target=\"_self\" href=\"https://www.baidu.com\">百度</a></p><p style=\"text-align: center;\"><img src=\"http://localhost:8080/layui/images/face/6.gif\" alt=\"[吃惊]\"><br></p>', '1900-01-20 10:44:03', '李四', 1);
INSERT INTO `notice_form` VALUES (16, '123', '<p style=\"text-align: center;\">12321312312321321321111111111111111133333333333333333333</p>', '1900-01-20 00:09:25', '李四', 1);
INSERT INTO `notice_form` VALUES (17, '525', '<p>524</p><p>25</p>', '1900-01-20 21:00:34', '李四', 1);
INSERT INTO `notice_form` VALUES (18, '524', '42542', '1900-01-20 21:00:50', '李四', 1);
INSERT INTO `notice_form` VALUES (20, '2', '<p><br></p><p>25</p><p>2</p><p>2</p><p>2</p>', '1900-01-20 00:00:00', '李四', 1);
INSERT INTO `notice_form` VALUES (21, '2', '<p><br></p><p>24</p><p>2</p><p>2</p><p><br></p>', '1900-01-20 00:00:00', '李四', 1);
INSERT INTO `notice_form` VALUES (22, '123', '12312312313', '1900-01-20 17:55:54', '张三', 1);
INSERT INTO `notice_form` VALUES (23, '43521', '45312', '1900-01-20 20:06:52', '李四', 1);
INSERT INTO `notice_form` VALUES (24, '453124', '5312345132', '1900-01-20 20:07:00', '李四', 1);
INSERT INTO `notice_form` VALUES (25, '1231', '153445312', '1900-01-20 20:07:14', '李四', 1);
INSERT INTO `notice_form` VALUES (26, '54', '424', '2020-01-24 16:15:18', '李四', 1);

-- ----------------------------
-- Table structure for obsterical_history_form
-- ----------------------------
DROP TABLE IF EXISTS `obsterical_history_form`;
CREATE TABLE `obsterical_history_form`  (
  `obsterical_id` bigint(20) NOT NULL,
  `card_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `marriage` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birth` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`obsterical_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of obsterical_history_form
-- ----------------------------
INSERT INTO `obsterical_history_form` VALUES (1, '452123197503311254', '123', '123');

-- ----------------------------
-- Table structure for operation_history_form
-- ----------------------------
DROP TABLE IF EXISTS `operation_history_form`;
CREATE TABLE `operation_history_form`  (
  `operation_id` bigint(20) NOT NULL,
  `card_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `operation_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`operation_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operation_history_form
-- ----------------------------
INSERT INTO `operation_history_form` VALUES (1, '452123197503311254', '123', '1900-01-20 21:43:03', '123');

-- ----------------------------
-- Table structure for past_history_form
-- ----------------------------
DROP TABLE IF EXISTS `past_history_form`;
CREATE TABLE `past_history_form`  (
  `past_id` bigint(20) NOT NULL,
  `card_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `describe` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`past_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of past_history_form
-- ----------------------------
INSERT INTO `past_history_form` VALUES (1, '452123197503311254', '1234');

-- ----------------------------
-- Table structure for purchase_form
-- ----------------------------
DROP TABLE IF EXISTS `purchase_form`;
CREATE TABLE `purchase_form`  (
  `Purchase_id` bigint(20) NOT NULL,
  `purchase_family_id` bigint(20) NULL DEFAULT NULL,
  `purchase_time` datetime(0) NULL DEFAULT NULL,
  `device_id` bigint(20) NULL DEFAULT NULL,
  `handle_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`Purchase_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_form
-- ----------------------------
DROP TABLE IF EXISTS `role_form`;
CREATE TABLE `role_form`  (
  `role_id` bigint(20) NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role_describe` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_form
-- ----------------------------
INSERT INTO `role_form` VALUES (1, 'ROLE_doctor', '医生');
INSERT INTO `role_form` VALUES (2, 'ROLE_admin', '管理员');
INSERT INTO `role_form` VALUES (3, 'ROLE_government', '政府监管人员');

-- ----------------------------
-- Table structure for self_check_form
-- ----------------------------
DROP TABLE IF EXISTS `self_check_form`;
CREATE TABLE `self_check_form`  (
  `Self_check_id` bigint(20) NOT NULL,
  `card_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `measurement_id` bigint(20) NULL DEFAULT NULL,
  `measurement_time` datetime(0) NULL DEFAULT NULL,
  `measurement_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `device_id` bigint(20) NULL DEFAULT NULL,
  `device_source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `usage_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Self_check_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of self_check_form
-- ----------------------------
INSERT INTO `self_check_form` VALUES (1, '452123197503311254', 1, '1900-01-20 22:58:39', '178-77', NULL, NULL, NULL);
INSERT INTO `self_check_form` VALUES (2, '452123197503311254', 2, '1900-01-20 22:59:07', '7.8', NULL, NULL, NULL);
INSERT INTO `self_check_form` VALUES (3, '452123197503311254', 3, '1900-01-20 23:03:12', '70', NULL, NULL, NULL);
INSERT INTO `self_check_form` VALUES (4, '452123197503311254', 4, '1900-01-20 23:03:48', '37.5', NULL, NULL, NULL);
INSERT INTO `self_check_form` VALUES (5, '452123197503311254', 5, '1900-01-20 23:04:03', '62', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for service_record_form
-- ----------------------------
DROP TABLE IF EXISTS `service_record_form`;
CREATE TABLE `service_record_form`  (
  `Service_id` bigint(20) NOT NULL,
  `service_time` datetime(0) NULL DEFAULT NULL,
  `doctor_group_id` bigint(20) NULL DEFAULT NULL,
  `family_id` bigint(20) NULL DEFAULT NULL,
  `family_member_id` bigint(20) NULL DEFAULT NULL,
  `service_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `service_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `service_evaluation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hospital_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`Service_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_record_form
-- ----------------------------
INSERT INTO `service_record_form` VALUES (1, '1900-01-20 01:07:56', 1, 1, 1, '123', '123', '123', 1);

-- ----------------------------
-- Table structure for surgery_form
-- ----------------------------
DROP TABLE IF EXISTS `surgery_form`;
CREATE TABLE `surgery_form`  (
  `Surgery_id` bigint(20) NOT NULL,
  `case_id` bigint(20) NULL DEFAULT NULL,
  `surgical_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `operative_time` datetime(0) NULL DEFAULT NULL,
  `surgical_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `surgeon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Surgery_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of surgery_form
-- ----------------------------
INSERT INTO `surgery_form` VALUES (1, 4, '肠道手术', '1900-01-20 23:03:37', '123', '1231');

-- ----------------------------
-- Table structure for threshold_form
-- ----------------------------
DROP TABLE IF EXISTS `threshold_form`;
CREATE TABLE `threshold_form`  (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `preset_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `measurement_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Measurement_id` bigint(20) NULL DEFAULT NULL,
  `cardId` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of threshold_form
-- ----------------------------
INSERT INTO `threshold_form` VALUES (0, '0', '57', 'blood_pressure', 1, '452123197503311254');
INSERT INTO `threshold_form` VALUES (1, '1', '178', 'blood_pressure', 1, '452123197503311254');
INSERT INTO `threshold_form` VALUES (2, '1', '78', 'blood_sugar', 2, '452123197503311254');
INSERT INTO `threshold_form` VALUES (3, '1', '78', 'heart_rate', 3, '452123197503311254');
INSERT INTO `threshold_form` VALUES (4, '1', '37.5', 'body_temperature', 4, '452123197503311254');
INSERT INTO `threshold_form` VALUES (5, '1', '80', 'weight', 5, '452123197503311254');
INSERT INTO `threshold_form` VALUES (6, '0', '35', 'blood_sugar', 2, '452123197503311254');

-- ----------------------------
-- Table structure for unit_form
-- ----------------------------
DROP TABLE IF EXISTS `unit_form`;
CREATE TABLE `unit_form`  (
  `unit_id` bigint(20) NOT NULL,
  `unit_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `corporate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`unit_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_form
-- ----------------------------
DROP TABLE IF EXISTS `user_form`;
CREATE TABLE `user_form`  (
  `uesr_id` bigint(20) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hospital_id` bigint(20) NULL DEFAULT NULL,
  `doctor_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`uesr_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_form
-- ----------------------------
INSERT INTO `user_form` VALUES (1, '张三', '$2a$10$f0DEGrkIpYyzcFrf/fTMSOAKl1Y/XHpKaijWdfiWnOOzGTEs8diLi', 1, 1);
INSERT INTO `user_form` VALUES (2, '李四', '$2a$10$p2tNkuIm4R9trFbWVQXIKOyI32JmWIfuWfKs9JnzqwMidQrm/6Upy', 1, NULL);
INSERT INTO `user_form` VALUES (3, '王五', '$2a$10$f0DEGrkIpYyzcFrf/fTMSOAKl1Y/XHpKaijWdfiWnOOzGTEs8diLi', 1, NULL);
INSERT INTO `user_form` VALUES (4, '061234', '$2a$10$gDaYeQt96JykryY0duEBruQhAjI0aMZEBWlUkFkjDNDwn6uThIUhm', 1, 1);
INSERT INTO `user_form` VALUES (5, '231572', '$2a$10$DwUPw03bRR8IFBpH/SBmQe1kM0tUm93PrQ9RPEPBDgzpzUcwGIGUW', 1, 2);

-- ----------------------------
-- Table structure for user_role_form
-- ----------------------------
DROP TABLE IF EXISTS `user_role_form`;
CREATE TABLE `user_role_form`  (
  `user_role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `role_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role_form
-- ----------------------------
INSERT INTO `user_role_form` VALUES (1, 1, 1);
INSERT INTO `user_role_form` VALUES (2, 2, 2);
INSERT INTO `user_role_form` VALUES (3, 3, 3);
INSERT INTO `user_role_form` VALUES (4, 4, 1);
INSERT INTO `user_role_form` VALUES (5, 5, 1);

-- ----------------------------
-- Table structure for warning_form
-- ----------------------------
DROP TABLE IF EXISTS `warning_form`;
CREATE TABLE `warning_form`  (
  `warning_id` bigint(20) NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`warning_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for warning_history_form
-- ----------------------------
DROP TABLE IF EXISTS `warning_history_form`;
CREATE TABLE `warning_history_form`  (
  `warning_history_id` bigint(20) NULL DEFAULT NULL,
  `detector` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `card_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warning_history_form
-- ----------------------------
INSERT INTO `warning_history_form` VALUES (1, '123', '452123197503311254', '123', '1900-01-20 21:03:14');
INSERT INTO `warning_history_form` VALUES (2, '123', '452123197503311254', '123', '1900-01-20 21:31:29');
INSERT INTO `warning_history_form` VALUES (3, '1234', '452123197503311254', '1234', '2020-01-26 22:40:45');

SET FOREIGN_KEY_CHECKS = 1;
