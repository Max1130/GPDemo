/*
Navicat Oracle Data Transfer
Oracle Client Version : 12.1.0.2.0

Source Server         : fdk
Source Server Version : 100200
Source Host           : localhost:1521
Source Schema         : SYSTEM

Target Server Type    : ORACLE
Target Server Version : 100200
File Encoding         : 65001

Date: 2017-05-06 16:47:07
*/


-- ----------------------------
-- Table structure for GP_CATALOGUE_EXTEND
-- ----------------------------
DROP TABLE "SYSTEM"."GP_CATALOGUE_EXTEND";
CREATE TABLE "SYSTEM"."GP_CATALOGUE_EXTEND" (
"C_E_ID" VARCHAR2(64 BYTE) NOT NULL ,
"C_ID" VARCHAR2(64 BYTE) NOT NULL ,
"C_E_NAME" VARCHAR2(64 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "SYSTEM"."GP_CATALOGUE_EXTEND"."C_E_ID" IS 'ID';
COMMENT ON COLUMN "SYSTEM"."GP_CATALOGUE_EXTEND"."C_ID" IS '一级目录表中ID';
COMMENT ON COLUMN "SYSTEM"."GP_CATALOGUE_EXTEND"."C_E_NAME" IS '二级分类名称';

-- ----------------------------
-- Records of GP_CATALOGUE_EXTEND
-- ----------------------------
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('24', '10', '家纺');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('25', '10', '生活日用');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('1', '1', '专场推荐');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('2', '1', '热门分类');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('3', '2', '热卖品类');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('4', '2', '裙装');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('5', '2', '上装');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('6', '2', '下装');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('7', '2', '特色类目');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('8', '2', '商场大牌');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('9', '3', '热卖选购');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('10', '3', 'T恤');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('11', '3', '牛仔裤');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('12', '3', '男士内搭');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('13', '3', '男士外套');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('14', '3', '男士裤装');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('15', '3', '特色男装');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('16', '3', '热卖品牌');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('17', '4', '面部护肤');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('18', '4', '身体护理');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('19', '4', '口腔护理');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('20', '4', '香水彩妆');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('21', '4', '洗发护发');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('22', '4', '清洁用品');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('26', '10', '家装软饰');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('27', '10', '灯具');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('28', '5', '电视');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('29', '5', '空调');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('30', '5', '洗衣机');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('31', '5', '冰箱');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('32', '5', '厨卫大电');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('33', '5', '厨房小电');
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('34', '6', null);
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('35', '6', null);
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('36', '6', null);
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('37', '6', null);
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('38', '6', null);
INSERT INTO "SYSTEM"."GP_CATALOGUE_EXTEND" VALUES ('23', '10', '热卖推荐');

-- ----------------------------
-- Indexes structure for table GP_CATALOGUE_EXTEND
-- ----------------------------

-- ----------------------------
-- Checks structure for table GP_CATALOGUE_EXTEND
-- ----------------------------
ALTER TABLE "SYSTEM"."GP_CATALOGUE_EXTEND" ADD CHECK ("C_E_ID" IS NOT NULL);
ALTER TABLE "SYSTEM"."GP_CATALOGUE_EXTEND" ADD CHECK ("C_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table GP_CATALOGUE_EXTEND
-- ----------------------------
ALTER TABLE "SYSTEM"."GP_CATALOGUE_EXTEND" ADD PRIMARY KEY ("C_E_ID");