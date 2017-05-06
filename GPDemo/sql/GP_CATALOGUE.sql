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

Date: 2017-05-06 16:46:59
*/


-- ----------------------------
-- Table structure for GP_CATALOGUE
-- ----------------------------
DROP TABLE "SYSTEM"."GP_CATALOGUE";
CREATE TABLE "SYSTEM"."GP_CATALOGUE" (
"C_ID" VARCHAR2(64 BYTE) NOT NULL ,
"C_NAME" VARCHAR2(30 BYTE) NULL ,
"STATE" VARCHAR2(64 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "SYSTEM"."GP_CATALOGUE"."C_ID" IS 'ID';
COMMENT ON COLUMN "SYSTEM"."GP_CATALOGUE"."C_NAME" IS '类别名';

-- ----------------------------
-- Records of GP_CATALOGUE
-- ----------------------------
INSERT INTO "SYSTEM"."GP_CATALOGUE" VALUES ('1', '推荐分类', '1');
INSERT INTO "SYSTEM"."GP_CATALOGUE" VALUES ('2', '潮流女装', '2');
INSERT INTO "SYSTEM"."GP_CATALOGUE" VALUES ('3', '品牌男装', '3');
INSERT INTO "SYSTEM"."GP_CATALOGUE" VALUES ('4', '个护化品', '4');
INSERT INTO "SYSTEM"."GP_CATALOGUE" VALUES ('5', '家用电器', '5');
INSERT INTO "SYSTEM"."GP_CATALOGUE" VALUES ('6', '电脑办公', '6');
INSERT INTO "SYSTEM"."GP_CATALOGUE" VALUES ('7', '手机数码', '7');
INSERT INTO "SYSTEM"."GP_CATALOGUE" VALUES ('8', '母婴童品', '8');
INSERT INTO "SYSTEM"."GP_CATALOGUE" VALUES ('9', '图书音像', '9');
INSERT INTO "SYSTEM"."GP_CATALOGUE" VALUES ('10', '家居家纺', '10');
INSERT INTO "SYSTEM"."GP_CATALOGUE" VALUES ('11', '厨房用品', '11');
INSERT INTO "SYSTEM"."GP_CATALOGUE" VALUES ('12', '家居建材', '12');

-- ----------------------------
-- Indexes structure for table GP_CATALOGUE
-- ----------------------------

-- ----------------------------
-- Checks structure for table GP_CATALOGUE
-- ----------------------------
ALTER TABLE "SYSTEM"."GP_CATALOGUE" ADD CHECK ("C_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table GP_CATALOGUE
-- ----------------------------
ALTER TABLE "SYSTEM"."GP_CATALOGUE" ADD PRIMARY KEY ("C_ID");
