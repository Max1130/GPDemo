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

Date: 2017-05-06 16:47:32
*/


-- ----------------------------
-- Table structure for GP_SHOPPING_CART
-- ----------------------------
DROP TABLE "SYSTEM"."GP_SHOPPING_CART";
CREATE TABLE "SYSTEM"."GP_SHOPPING_CART" (
"ID" VARCHAR2(64 BYTE) NULL ,
"GOOD_ID" VARCHAR2(64 BYTE) NULL ,
"COUNT" NUMBER(4) NULL ,
"USER_ID" VARCHAR2(64 BYTE) NULL ,
"CREATE_TIME" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "SYSTEM"."GP_SHOPPING_CART"."GOOD_ID" IS '加入购物车商品ID';
COMMENT ON COLUMN "SYSTEM"."GP_SHOPPING_CART"."COUNT" IS '商品数量';
COMMENT ON COLUMN "SYSTEM"."GP_SHOPPING_CART"."USER_ID" IS '添加人ID';
COMMENT ON COLUMN "SYSTEM"."GP_SHOPPING_CART"."CREATE_TIME" IS '加入购物车时间';

-- ----------------------------
-- Records of GP_SHOPPING_CART
-- ----------------------------
INSERT INTO "SYSTEM"."GP_SHOPPING_CART" VALUES ('1', '12', '1', '9b28e5d7ebbc4650a607445eb0af99a9', null);
INSERT INTO "SYSTEM"."GP_SHOPPING_CART" VALUES ('2', '1', '1', '9b28e5d7ebbc4650a607445eb0af99a9', null);
INSERT INTO "SYSTEM"."GP_SHOPPING_CART" VALUES ('3', '5', '1', '9b28e5d7ebbc4650a607445eb0af99a9', null);
