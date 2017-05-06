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

Date: 2017-05-06 16:47:14
*/


-- ----------------------------
-- Table structure for GP_CATALOGUE_THREE
-- ----------------------------
DROP TABLE "SYSTEM"."GP_CATALOGUE_THREE";
CREATE TABLE "SYSTEM"."GP_CATALOGUE_THREE" (
"THREE_ID" VARCHAR2(64 BYTE) NOT NULL ,
"C_E_ID" VARCHAR2(64 BYTE) NOT NULL ,
"THREE_NAME" VARCHAR2(64 BYTE) NULL ,
"PICTURE_URL" VARCHAR2(500 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "SYSTEM"."GP_CATALOGUE_THREE"."C_E_ID" IS '二级目录分类ID';
COMMENT ON COLUMN "SYSTEM"."GP_CATALOGUE_THREE"."THREE_NAME" IS '三级目录名称';
COMMENT ON COLUMN "SYSTEM"."GP_CATALOGUE_THREE"."PICTURE_URL" IS '图片url';

-- ----------------------------
-- Records of GP_CATALOGUE_THREE
-- ----------------------------
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('21', '24', '夏被', '56fa14c5N10d218a1.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('15', '23', '凉席', '58c02e99N96363460.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('16', '23', '保暖防护', '582f102eN8a45283d.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('17', '23', '收纳用品', '57a1a428Ndf7f0666.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('18', '23', '台灯', '57c3ccd3N97e5da92.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('19', '23', '灯具照明', '56d026a2Nb0f2f44f.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('20', '23', '蚊帐', '567b94d3Nd02e579b.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('27', '23', '夏被', '56fa14c5N10d218a1.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('22', '24', '套件', '57889809N94fcfc23.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('23', '24', '毛巾', '58074408N006f817d.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('24', '24', '被子', '56fa14c5N10d218a1.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('25', '24', '枕头', '57b25e12N53d00dcd.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('1', '1', '超级单品日', '5836668eN8b2a9cc4.png');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('2', '1', '热门图书', '5836668eN8b2a9cc4.png');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('3', '1', '京东服饰 焕新潮', '5836668eN8b2a9cc4.png');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('4', '2', '手机', '5836668eN8b2a9cc4.png');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('5', '2', '笔记本', '57a99b78N465d9fd0.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('6', '2', '空调', '58845535N5ba1afef.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('7', '2', '收纳用品', '57a1a428Ndf7f0666.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('8', '2', '炒锅', '5672b6b5Nc7781ae3.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('9', '2', '床品套件', 't015efbf2342a37fdd1.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('10', '2', '啤酒', 'AAFL_wIOJRcAAwrs426.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('11', '2', '中小学教辅', '569dcd4bN310ff891.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('12', '2', '火车票', '201309111433170176.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('13', '23', '节庆饰品', '58ddc978Ne6aeb745.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('26', '24', '凉席', '58c02e99N96363460.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('28', '25', '浴室用品', '58ba1a05Ndfc6efa5.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('29', '25', '缝纫/针织用品', '58d61a3aNe9942484.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('30', '25', '洗晒/熨烫', '5527caf1Nf6c07dc4.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('31', '25', '净化除味', '5703a564N286ba7f9.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('32', '25', '雨伞雨具', 'EzcQAa5CgAAcLw981.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('33', '26', '桌布/罩件', '53ba14f2N673f813b.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('34', '26', '地毯地垫', '5873bb87Ncfd6c589.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('35', '26', '沙发垫套/椅套', '570f5c4eNec5e64cc.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('36', '26', '相框/照片墙', '4AAAFIwEzG88AALrz188.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('37', '26', '装饰字画', '581411e1Nfb4ff1be.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('38', '26', '装饰摆件', '58ae3f42N77e95b0d.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('40', '27', '装饰灯', '58dce0c0N49f4aa99.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('41', '27', '落地灯', '5864731eN7b5b841f.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('42', '27', '应急灯/手电', '578dd147Nc62eab3b.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('44', '27', 'LED灯', '58104deeNe21ec7ac.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('43', '27', '台灯', '57bf9b80N407d9dca.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('14', '23', '套件', '57889809N94fcfc23.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('39', '27', '节能灯', '568c8329Nd838346a.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('45', '3', '当季新品', 't0157e44ab78a614e64.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('46', '3', '短袖T恤', '58a3b79eN4673ded8.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('47', '3', '长袖衬衫', '58a80b82N1af3dbd5.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('48', '3', '雪纺衫', '57b51b75Nf3aa0ec7.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('49', '3', '针织开衫', '56e025a9Nd79d42bd.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('50', '3', '宽松卫衣', '58ad93c9N2a83db69.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('51', '4', '连衣裙', '58a5a935N928f4736.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('52', '4', '背带裙', '57ac31c9Nc8dd00ed.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('53', '4', '性感连衣裙', '58da8d67N2e9a9b8b.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('54', '4', '蕾丝连衣裙', '58a69573N295708e2.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('55', '4', '棉麻连衣裙', '57cab25fN6c60dd09.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('56', '5', '衬衫', '58b2854eNde3eaa63.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('57', '5', 'T恤', '58c75d61N0a9946a2.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('58', '5', '针织衫', '58b6c141N7158b107.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('59', '5', '短外套', '57b42bffNf3de3811.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('60', '5', '卫衣', '585d3feeN5387187b.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('61', '6', '牛仔裤', '58525ae2Nfb105389.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('62', '6', '休闲裤', '58c54c95Nc61bd6a0.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('63', '6', '九分裤', '586f60edNb4a6e17b.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('64', '6', '运动裤', '57e291aeN53019da7.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('65', '6', '喇叭裤', '581fe59cNe10dcebd.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('66', '7', '大码女装', '58579eafN9a319655.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('67', '7', '妈妈装', '589954cfNe8956d31.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('68', '7', '婚纱', '5704ddc6Na9feec48.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('69', '7', '旗袍/唐装', '58a47d3dNe202d669.jpg');
INSERT INTO "SYSTEM"."GP_CATALOGUE_THREE" VALUES ('70', '7', '礼服', '57ce4079N12bf6222.jpg');

-- ----------------------------
-- Indexes structure for table GP_CATALOGUE_THREE
-- ----------------------------

-- ----------------------------
-- Checks structure for table GP_CATALOGUE_THREE
-- ----------------------------
ALTER TABLE "SYSTEM"."GP_CATALOGUE_THREE" ADD CHECK ("THREE_ID" IS NOT NULL);
ALTER TABLE "SYSTEM"."GP_CATALOGUE_THREE" ADD CHECK ("C_E_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table GP_CATALOGUE_THREE
-- ----------------------------
ALTER TABLE "SYSTEM"."GP_CATALOGUE_THREE" ADD PRIMARY KEY ("THREE_ID");