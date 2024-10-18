/*
 Navicat Premium Dump SQL

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : new

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 17/10/2024 19:27:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `AdminAccount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `AdminPassword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('张三', '123456');
INSERT INTO `admin` VALUES ('王五', '123456');

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `Id` int NOT NULL AUTO_INCREMENT COMMENT '回答的唯一Id',
  `AnswerName` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ProblemId` int NULL DEFAULT NULL,
  `UserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '回答者账号名称',
  `Status` int NULL DEFAULT NULL COMMENT '1正常0封禁',
  `Time` datetime NULL DEFAULT NULL,
  `Gradle` int NULL DEFAULT NULL COMMENT '10分满分',
  `FatherAnswerId` int NULL DEFAULT NULL COMMENT '子回答，回答的回答',
  `FatherUserName` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父回答的用户名',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES (1, '因为java就是nb', 1, '李四', 0, '2024-09-25 22:32:00', 9, 0, NULL);
INSERT INTO `answer` VALUES (6, '克利夫兰骑士队', 6, '李四', 1, '2024-09-25 22:32:00', 9, 0, NULL);
INSERT INTO `answer` VALUES (7, '16全力詹', 6, '李四', 1, '2024-09-25 22:32:00', 9, 0, NULL);
INSERT INTO `answer` VALUES (8, '那必须是勇士队', 6, '李八', 0, '2024-09-25 22:32:00', 0, 0, NULL);
INSERT INTO `answer` VALUES (12, '骑士', 6, '李四', 1, '2024-09-27 00:03:06', 0, 0, NULL);
INSERT INTO `answer` VALUES (13, '2016年 勇士队73胜总亚军', 6, '李四', 1, '2024-09-27 00:05:28', 0, 0, NULL);
INSERT INTO `answer` VALUES (14, '不是的，各种语言各有优劣', 7, '李四', 1, '2024-09-27 00:09:23', 0, 0, NULL);
INSERT INTO `answer` VALUES (15, 'Python才是', 7, '李四', 1, '2024-09-27 00:34:45', 0, 0, NULL);
INSERT INTO `answer` VALUES (16, '骑士队', 5, '李四', 1, '2024-09-27 00:35:41', 0, 0, NULL);
INSERT INTO `answer` VALUES (17, '克利夫兰骑士队', 5, '李四', 1, '2024-09-27 00:42:05', 0, 0, NULL);
INSERT INTO `answer` VALUES (18, '不能', 3, '李四', 1, '2024-09-27 00:43:27', 2, 0, NULL);
INSERT INTO `answer` VALUES (19, 'c生万物', 7, '李四', 1, '2024-09-27 00:44:24', 0, 0, NULL);
INSERT INTO `answer` VALUES (20, '相比于C++要简单很多', 10, '李四', 1, '2024-09-27 15:57:05', 10, 0, NULL);
INSERT INTO `answer` VALUES (21, '会的人很多', 10, '李四', 1, '2024-09-27 15:57:22', 7, 0, NULL);
INSERT INTO `answer` VALUES (22, '黑马程序员', 13, '李四', 1, '2024-09-27 19:49:36', 0, 0, NULL);
INSERT INTO `answer` VALUES (23, '好好学习', 14, '李四', 1, '2024-09-27 20:01:59', 10, 0, NULL);
INSERT INTO `answer` VALUES (24, '无他，唯手熟尔', 15, '李四', 1, '2024-09-27 20:04:41', 10, 0, NULL);
INSERT INTO `answer` VALUES (25, '普遍现象，大环境不行', 16, '李四', 1, '2024-09-27 20:06:35', 6, 0, NULL);
INSERT INTO `answer` VALUES (26, '那肯定不难', 10, '李七', 1, '2024-09-27 22:32:56', 0, 0, NULL);
INSERT INTO `answer` VALUES (27, 'kskd', 17, '李七', 1, '2024-09-27 22:34:15', 0, 0, NULL);
INSERT INTO `answer` VALUES (28, '伟大的发明', 2, '李四', 1, '2024-09-28 10:21:40', 8, 0, NULL);
INSERT INTO `answer` VALUES (29, '我也想知道', 1, '迪丽热巴', 0, '2024-09-28 15:05:59', 0, 0, NULL);
INSERT INTO `answer` VALUES (30, '我不觉得牛逼', 1, '迪丽热巴', 1, '2024-09-28 15:06:05', 0, 0, NULL);
INSERT INTO `answer` VALUES (31, 'NBA是什么垃圾', 5, '迪丽热巴', 1, '2024-09-28 15:06:15', 0, 0, NULL);
INSERT INTO `answer` VALUES (32, '读研就老实了', 14, '迪丽热巴', 1, '2024-09-28 15:06:28', 0, 0, NULL);
INSERT INTO `answer` VALUES (33, '上大学上的', 16, '迪丽热巴', 1, '2024-09-28 15:06:39', 0, 0, NULL);
INSERT INTO `answer` VALUES (34, '因为做后端太强了', 1, '彭于晏', 1, '2024-09-28 15:07:01', 0, 0, NULL);
INSERT INTO `answer` VALUES (35, '最讨厌的骑士队', 5, '彭于晏', 1, '2024-09-28 15:07:12', 0, 0, NULL);
INSERT INTO `answer` VALUES (36, '看NBA的都是什么肥宅', 6, '彭于晏', 1, '2024-09-28 15:07:31', 0, 0, NULL);
INSERT INTO `answer` VALUES (37, '建议追求保研', 14, '彭于晏', 1, '2024-09-28 15:07:49', 0, 0, NULL);
INSERT INTO `answer` VALUES (38, '花多', 20, '李四', 1, '2024-10-13 17:55:42', 10, 0, NULL);
INSERT INTO `answer` VALUES (39, '德育月率不了吕布拉低', 21, '李四', 1, '2024-10-15 19:30:56', 5, 0, NULL);
INSERT INTO `answer` VALUES (40, '123456789', 21, '李四', 1, '2024-10-15 19:31:08', 0, 0, NULL);
INSERT INTO `answer` VALUES (41, '123456', 21, '彭于晏', 1, '2024-10-15 19:31:44', 8, 0, NULL);
INSERT INTO `answer` VALUES (42, '2345', 21, '彭于晏', 1, '2024-10-15 19:31:52', 10, 0, NULL);
INSERT INTO `answer` VALUES (43, '回答彭于晏', 22, '彭于晏', 1, '2024-10-15 19:39:42', 0, 0, NULL);
INSERT INTO `answer` VALUES (44, '你长的好看你说的算', 1, '李四', 1, '2024-10-15 20:05:33', 0, 30, NULL);
INSERT INTO `answer` VALUES (45, '英雄所见略同', 1, '李四', 1, '2024-10-15 20:06:35', 0, 30, NULL);
INSERT INTO `answer` VALUES (46, '和go比呢', 1, '李四', 1, '2024-10-15 20:06:45', 0, 34, NULL);
INSERT INTO `answer` VALUES (47, '为什么排名干不过Python', 1, '李四', 1, '2024-10-15 20:12:55', 0, 34, NULL);
INSERT INTO `answer` VALUES (48, '我觉得牛逼', 1, '李四', 1, '2024-10-15 20:16:19', 0, 30, NULL);
INSERT INTO `answer` VALUES (49, '8点19', 1, '李四', 1, '2024-10-15 20:19:21', 0, 30, NULL);
INSERT INTO `answer` VALUES (50, '问你是谁发明的', 2, '李四', 1, '2024-10-15 20:51:05', 0, 28, NULL);
INSERT INTO `answer` VALUES (51, '12345', 22, '李四', 1, '2024-10-15 20:52:06', 0, 0, NULL);
INSERT INTO `answer` VALUES (52, '2', 19, '李四', 1, '2024-10-15 20:57:32', 9, 0, NULL);
INSERT INTO `answer` VALUES (53, '12345', 23, '彭于晏', 1, '2024-10-15 21:37:23', 9, 0, NULL);
INSERT INTO `answer` VALUES (54, '98765', 23, '李四', 1, '2024-10-15 21:37:54', 0, 53, NULL);

-- ----------------------------
-- Table structure for jubaohuida
-- ----------------------------
DROP TABLE IF EXISTS `jubaohuida`;
CREATE TABLE `jubaohuida`  (
  `Reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `JuBaoUserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `FaBuUserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `AnswerId` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jubaohuida
-- ----------------------------
INSERT INTO `jubaohuida` VALUES ('回答太敷衍了事', '李七', '李四', 1);
INSERT INTO `jubaohuida` VALUES ('纯粹瞎说', '李四', '李七', 8);
INSERT INTO `jubaohuida` VALUES ('勇士队太脏了', '李四', '李八', 8);
INSERT INTO `jubaohuida` VALUES ('挑起球迷战争', '李四', '李八', 8);
INSERT INTO `jubaohuida` VALUES ('颠倒是非', '李四', '李八', 8);
INSERT INTO `jubaohuida` VALUES ('答非所问', '李四', '迪丽热巴', 29);
INSERT INTO `jubaohuida` VALUES ('恶意攻击', '李四', '迪丽热巴', 30);
INSERT INTO `jubaohuida` VALUES ('片面的回答', '李四', '彭于晏', 34);
INSERT INTO `jubaohuida` VALUES ('无差别攻击', '李四', '迪丽热巴', 31);
INSERT INTO `jubaohuida` VALUES ('带有恶意的个人情绪色彩', '李四', '彭于晏', 35);

-- ----------------------------
-- Table structure for jubaoproblem
-- ----------------------------
DROP TABLE IF EXISTS `jubaoproblem`;
CREATE TABLE `jubaoproblem`  (
  `ProblemId` int NULL DEFAULT NULL,
  `Reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `JuBaoUserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `FaBuUserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jubaoproblem
-- ----------------------------
INSERT INTO `jubaoproblem` VALUES (1, '涉及不当言论，挑起战争', '李四', '李七');
INSERT INTO `jubaoproblem` VALUES (7, 'JAVA明显不是，博主纯纯博眼球', '李四', '李八');
INSERT INTO `jubaoproblem` VALUES (7, '博主是傻逼', '李四', '李八');
INSERT INTO `jubaoproblem` VALUES (7, '博主为了博眼球挑起程序员之间的口水战', '李四', '李八');
INSERT INTO `jubaoproblem` VALUES (7, '题主是傻逼', '李四', '李八');
INSERT INTO `jubaoproblem` VALUES (4, '给网红引流', '李四', '李七');
INSERT INTO `jubaoproblem` VALUES (5, '挑起球迷战争', '李四', '李七');
INSERT INTO `jubaoproblem` VALUES (6, '装傻暗讽勇士队球迷', '李四', '李七');
INSERT INTO `jubaoproblem` VALUES (7, '给JAVA招黑', '李四', '李八');
INSERT INTO `jubaoproblem` VALUES (7, '无稽之谈', '李四', '李八');

-- ----------------------------
-- Table structure for mingxi
-- ----------------------------
DROP TABLE IF EXISTS `mingxi`;
CREATE TABLE `mingxi`  (
  `MoneyReason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Time` datetime NULL DEFAULT NULL,
  `Money` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `UserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mingxi
-- ----------------------------
INSERT INTO `mingxi` VALUES ('充值', '2024-09-27 17:25:25', '890', '李四');
INSERT INTO `mingxi` VALUES ('提现', '2024-09-27 17:51:08', '1000', '李四');
INSERT INTO `mingxi` VALUES ('提现', '2024-09-27 17:52:10', '0', '李四');
INSERT INTO `mingxi` VALUES ('提现', '2024-09-27 17:52:46', '0', '李四');
INSERT INTO `mingxi` VALUES ('提现', '2024-09-27 17:53:10', '0', '李四');
INSERT INTO `mingxi` VALUES ('充值', '2024-09-27 17:54:43', '100', '李四');
INSERT INTO `mingxi` VALUES ('提现', '2024-09-27 17:54:56', '100', '李四');
INSERT INTO `mingxi` VALUES ('充值', '2024-09-27 17:57:29', '99', '李四');
INSERT INTO `mingxi` VALUES ('提现', '2024-09-27 17:58:33', '11', '李四');
INSERT INTO `mingxi` VALUES ('提现', '2024-09-27 17:59:41', '77', '李四');
INSERT INTO `mingxi` VALUES ('充值', '2024-09-27 19:45:00', '300', '李四');
INSERT INTO `mingxi` VALUES ('回答大学怎么不挂科问题获得悬赏', '2024-09-27 20:04:59', '100', '李四');
INSERT INTO `mingxi` VALUES ('结算大学怎么不挂科问题扣除', '2024-09-27 20:04:59', '100', '李四');
INSERT INTO `mingxi` VALUES ('回答怎么快速提升编程水平问题获得悬赏', '2024-09-27 20:05:01', '233', '李四');
INSERT INTO `mingxi` VALUES ('结算怎么快速提升编程水平问题扣除', '2024-09-27 20:05:01', '233', '李四');
INSERT INTO `mingxi` VALUES ('回答怎么快速提升编程水平问题获得悬赏', '2024-09-27 20:05:04', '233', '李四');
INSERT INTO `mingxi` VALUES ('结算怎么快速提升编程水平问题扣除', '2024-09-27 20:05:04', '233', '李四');
INSERT INTO `mingxi` VALUES ('回答怎么看待大学生找不到工作问题获得悬赏', '2024-09-27 22:35:45', '500', '李四');
INSERT INTO `mingxi` VALUES ('结算怎么看待大学生找不到工作问题扣除', '2024-09-27 22:35:45', '500', '李四');
INSERT INTO `mingxi` VALUES ('提现', '2024-09-27 22:36:15', '100', '李四');
INSERT INTO `mingxi` VALUES ('充值', '2024-09-27 22:36:20', '100', '李四');
INSERT INTO `mingxi` VALUES ('回答是谁发现了万有引力问题获得悬赏', '2024-09-28 10:24:40', '1', '李四');
INSERT INTO `mingxi` VALUES ('结算是谁发现了万有引力问题扣除', '2024-09-28 10:24:40', '1', '李四');
INSERT INTO `mingxi` VALUES ('回答10-15 19:29问题获得悬赏', '2024-10-15 20:53:19', '99999', '彭于晏');
INSERT INTO `mingxi` VALUES ('结算10-15 19:29问题扣除', '2024-10-15 20:53:19', '99999', '李四');
INSERT INTO `mingxi` VALUES ('回答10-15 19:29问题获得悬赏', '2024-10-15 20:53:30', '99999', '彭于晏');
INSERT INTO `mingxi` VALUES ('结算10-15 19:29问题扣除', '2024-10-15 20:53:30', '99999', '李四');
INSERT INTO `mingxi` VALUES ('回答10-15 19:29问题获得悬赏', '2024-10-15 20:53:34', '99999', '彭于晏');
INSERT INTO `mingxi` VALUES ('结算10-15 19:29问题扣除', '2024-10-15 20:53:34', '99999', '李四');
INSERT INTO `mingxi` VALUES ('回答为什么桂花这么香问题获得悬赏', '2024-10-15 20:56:31', '2', '李四');
INSERT INTO `mingxi` VALUES ('结算为什么桂花这么香问题扣除', '2024-10-15 20:56:31', '2', '李四');
INSERT INTO `mingxi` VALUES ('回答1问题获得悬赏', '2024-10-15 20:57:46', '1', '李四');
INSERT INTO `mingxi` VALUES ('结算1问题扣除', '2024-10-15 20:57:46', '1', '李四');
INSERT INTO `mingxi` VALUES ('回答4问题获得悬赏', '2024-10-15 21:38:14', '444', '彭于晏');
INSERT INTO `mingxi` VALUES ('结算4问题扣除', '2024-10-15 21:38:14', '444', '李四');
INSERT INTO `mingxi` VALUES ('回答4问题获得悬赏', '2024-10-15 21:39:22', '444', '彭于晏');
INSERT INTO `mingxi` VALUES ('结算4问题扣除', '2024-10-15 21:39:22', '444', '李四');
INSERT INTO `mingxi` VALUES ('回答4问题获得悬赏', '2024-10-15 21:43:49', '444', '彭于晏');
INSERT INTO `mingxi` VALUES ('结算4问题扣除', '2024-10-15 21:43:49', '444', '李四');
INSERT INTO `mingxi` VALUES ('回答4问题获得悬赏', '2024-10-15 21:45:28', '444', '彭于晏');
INSERT INTO `mingxi` VALUES ('结算4问题扣除', '2024-10-15 21:45:28', '444', '李四');
INSERT INTO `mingxi` VALUES ('回答4问题获得悬赏', '2024-10-15 21:48:42', '444', '彭于晏');
INSERT INTO `mingxi` VALUES ('结算4问题扣除', '2024-10-15 21:48:42', '444', '李四');
INSERT INTO `mingxi` VALUES ('回答4问题获得悬赏', '2024-10-15 21:50:05', '444', '彭于晏');
INSERT INTO `mingxi` VALUES ('结算4问题扣除', '2024-10-15 21:50:05', '444', '李四');

-- ----------------------------
-- Table structure for money
-- ----------------------------
DROP TABLE IF EXISTS `money`;
CREATE TABLE `money`  (
  `Money` int UNSIGNED NULL DEFAULT NULL,
  `UserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of money
-- ----------------------------
INSERT INTO `money` VALUES (263, '李四');
INSERT INTO `money` VALUES (90, '李七');
INSERT INTO `money` VALUES (200, '张三');
INSERT INTO `money` VALUES (50, '李八');
INSERT INTO `money` VALUES (0, '迪丽热巴');
INSERT INTO `money` VALUES (0, '随便');
INSERT INTO `money` VALUES (544, '彭于晏');

-- ----------------------------
-- Table structure for proplem
-- ----------------------------
DROP TABLE IF EXISTS `proplem`;
CREATE TABLE `proplem`  (
  `ProblemName` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所用到的标签的唯一id',
  `Money` int NULL DEFAULT NULL COMMENT '0是不悬赏，其余的数字是悬赏的价格',
  `Id` int NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `UserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发起人',
  `Status` int NULL DEFAULT NULL COMMENT '0是该问题被禁用下架1是正常2是该问题结束悬赏',
  `Time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of proplem
-- ----------------------------
INSERT INTO `proplem` VALUES ('Java语言为什么这么nb', 'it技术', 0, 1, '李四', 1, '2024-09-25 22:32:00');
INSERT INTO `proplem` VALUES ('是谁发现了万有引力', '物理科学', 1, 2, '李四', 2, '2024-09-25 22:32:00');
INSERT INTO `proplem` VALUES ('余胜君真能算java之父吗', 'it技术', 0, 3, '李四', 1, '2024-09-25 22:32:00');
INSERT INTO `proplem` VALUES ('余胜君是谁', 'it技术', 0, 4, '李七', 0, '2024-09-25 22:32:00');
INSERT INTO `proplem` VALUES ('2016年NBA总冠军是哪支队伍', '篮球', 0, 5, '李七', 1, '2024-09-25 22:32:00');
INSERT INTO `proplem` VALUES ('历史上第一支1：3逆转NBA总决赛取得胜利的队伍是那支', '篮球', 5, 6, '李七', 1, '2024-09-25 22:32:00');
INSERT INTO `proplem` VALUES ('java语言是世界第一语言吗', 'it技术', 0, 7, '李八', 0, '2024-09-25 22:32:00');
INSERT INTO `proplem` VALUES ('java那不难', 'it技术', 5, 10, '李四', 2, '2024-09-26 23:42:38');
INSERT INTO `proplem` VALUES ('大学怎么不挂科', '大学生活', 100, 14, '李四', 2, '2024-09-27 19:42:23');
INSERT INTO `proplem` VALUES ('怎么快速提升编程水平', '编程', 233, 15, '李四', 2, '2024-09-27 20:02:54');
INSERT INTO `proplem` VALUES ('怎么看待大学生找不到工作', '社会现象', 500, 16, '李四', 2, '2024-09-27 20:06:02');
INSERT INTO `proplem` VALUES ('java的开创者是谁', 'it技术', 0, 17, '李四', 1, '2024-09-27 22:33:47');
INSERT INTO `proplem` VALUES ('为什么王者荣耀能火这么久', '王者荣耀', 0, 18, '李四', 1, '2024-09-27 23:14:15');
INSERT INTO `proplem` VALUES ('1', '和平精英', 1, 19, '李四', 2, '2024-10-06 21:16:12');
INSERT INTO `proplem` VALUES ('为什么桂花这么香', '花卉', 2, 20, '李四', 2, '2024-10-13 17:52:24');
INSERT INTO `proplem` VALUES ('10-15 19:29', 'java语言', 99999, 21, '李四', 2, '2024-10-15 19:29:21');
INSERT INTO `proplem` VALUES ('19:37发布', 'java语言', 666, 22, '彭于晏', 1, '2024-10-15 19:37:56');
INSERT INTO `proplem` VALUES ('4', 'java语言', 444, 23, '李四', 2, '2024-10-15 21:20:54');
INSERT INTO `proplem` VALUES ('5', 'java语言', 555, 24, '李四', 1, '2024-10-15 21:21:03');
INSERT INTO `proplem` VALUES ('6', 'java语言', 0, 25, '李四', 1, '2024-10-15 21:21:11');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `TagName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `Count` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '总使用量',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('人工智能', 3, 0000000124);
INSERT INTO `tag` VALUES ('java语言', 5, 0000000268);
INSERT INTO `tag` VALUES ('深度学习', 7, 0000000129);
INSERT INTO `tag` VALUES ('和平精英', 8, 0000000129);
INSERT INTO `tag` VALUES ('王者荣耀', 9, 0000000245);
INSERT INTO `tag` VALUES ('大学生活', 10, 0000000128);
INSERT INTO `tag` VALUES ('汽车', 11, 0000000125);
INSERT INTO `tag` VALUES ('花卉', 12, 0000001127);
INSERT INTO `tag` VALUES ('工作', 13, 0000000223);
INSERT INTO `tag` VALUES ('星座', 14, 0000000128);
INSERT INTO `tag` VALUES ('明星', 15, 0000000219);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `UserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `UserAccount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `UserPassword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `UserSex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `UserPhoneNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '1正常0封禁',
  `Status` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('李四', '123456', '123456', '女', '1234567891', 1);
INSERT INTO `user` VALUES ('李七', '1234567', '1234567', '女', '333333333', 1);
INSERT INTO `user` VALUES ('李八', '12345678', '123456', '男', '777777777', 1);
INSERT INTO `user` VALUES ('彭于晏', '9851', '123456', '男', '15072139999', 1);
INSERT INTO `user` VALUES ('迪丽热巴', '9852', '123456', '女', '15072135555', 1);
INSERT INTO `user` VALUES ('随便', '123', '123456', '男', '150', 1);

SET FOREIGN_KEY_CHECKS = 1;
