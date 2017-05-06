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

Date: 2017-05-06 16:47:28
*/


-- ----------------------------
-- Table structure for GP_MALLING_USER
-- ----------------------------
DROP TABLE "SYSTEM"."GP_MALLING_USER";
CREATE TABLE "SYSTEM"."GP_MALLING_USER" (
"ID" VARCHAR2(64 BYTE) NOT NULL ,
"USER_NAME" VARCHAR2(64 BYTE) NULL ,
"PASSWORD" VARCHAR2(64 BYTE) NULL ,
"CREATE_TIME" DATE NULL ,
"TOKEN" VARCHAR2(64 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_USER"."ID" IS '用户ID';
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_USER"."USER_NAME" IS '用户名';
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_USER"."PASSWORD" IS '用户密码';
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_USER"."CREATE_TIME" IS '注册时间';
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_USER"."TOKEN" IS 'token
';

-- ----------------------------
-- Records of GP_MALLING_USER
-- ----------------------------
INSERT INTO "SYSTEM"."GP_MALLING_USER" VALUES ('9b28e5d7ebbc4650a607445eb0af99a9', 'admin', 'admin', null, 'a7a2d4224a8e42b7880e65f2b3adcf50');
INSERT INTO "SYSTEM"."GP_MALLING_USER" VALUES ('281f3a70836d4f918011936e174e6359', 'fudakui', 'admin', TO_DATE('2017-04-10 22:56:42', 'YYYY-MM-DD HH24:MI:SS'), 'c73da8f1c63f49a689da6d5d4d37d4f7');
INSERT INTO "SYSTEM"."GP_MALLING_USER" VALUES ('211e93feb5224166b5c13d87a5497f01', 'fud', 'admin', TO_DATE('2017-04-14 09:57:41', 'YYYY-MM-DD HH24:MI:SS'), 'd3785a589fbf416ba1209faccebc8065');

-- ----------------------------
-- Indexes structure for table GP_MALLING_USER
-- ----------------------------

-- ----------------------------
-- Checks structure for table GP_MALLING_USER
-- ----------------------------
ALTER TABLE "SYSTEM"."GP_MALLING_USER" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table GP_MALLING_USER
-- ----------------------------
ALTER TABLE "SYSTEM"."GP_MALLING_USER" ADD PRIMARY KEY ("ID");
