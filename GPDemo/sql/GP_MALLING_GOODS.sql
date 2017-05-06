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

Date: 2017-05-06 16:47:24
*/


-- ----------------------------
-- Table structure for GP_MALLING_GOODS
-- ----------------------------
DROP TABLE "SYSTEM"."GP_MALLING_GOODS";
CREATE TABLE "SYSTEM"."GP_MALLING_GOODS" (
"ID" VARCHAR2(64 BYTE) NOT NULL ,
"GOODS_NUMBER" VARCHAR2(64 BYTE) NULL ,
"GOODS_NAME" VARCHAR2(2000 BYTE) NULL ,
"PRICE" NUMBER(10,2) NULL ,
"REMARK" VARCHAR2(500 BYTE) NULL ,
"DESCRIPTION" VARCHAR2(2000 BYTE) NULL ,
"IMAGE_URL" VARCHAR2(2000 BYTE) NULL ,
"TYPE" VARCHAR2(64 BYTE) NULL ,
"SALES" NUMBER(10) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_GOODS"."ID" IS 'ID';
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_GOODS"."GOODS_NUMBER" IS '商品号';
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_GOODS"."GOODS_NAME" IS '商品名称';
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_GOODS"."PRICE" IS '价格';
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_GOODS"."REMARK" IS '标记';
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_GOODS"."DESCRIPTION" IS '描述';
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_GOODS"."IMAGE_URL" IS '图片地址';
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_GOODS"."TYPE" IS '分类';
COMMENT ON COLUMN "SYSTEM"."GP_MALLING_GOODS"."SALES" IS '销量';

-- ----------------------------
-- Records of GP_MALLING_GOODS
-- ----------------------------
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('12', '26241700', '西门子全自动洗衣机滚筒', '3500', null, '西门子全自动洗衣机滚筒', '58c114d9N826f1b5f.jpg', '1', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('1', 'ssfwe', '裙装1', '100', null, '这是裙装1', 'a.jpg', '3', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('2', 'adsf', '裙装2', '100', null, '这是裙装2', 'b.jpg', '3', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('3', 'grgw', '裙装3', '100', null, '这是裙装3', 'c.jpg', '3', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('4', 'eh132', '裙装4', '100', null, '这是裙装4', 'd.jpg', '3', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('5', 'sder45', '裙装5', '100', null, '这是裙装5', 'e.jpg', '3', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('6', 'ghng6', '裙装6', '100', null, '这是裙装6', 'f.jpg', '3', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('7', '347gg', '上装1', '100', null, '这是上装1', 'l.jpg', '3', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('8', '233k', '上装2', '100', null, '这是上装2', 'm.jpg', '3', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('9', '42890', '上装3', '100', null, '这是上装3', 'n.jpg', '3', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('10', '45gh', '上装4', '100', null, '这是上装4', 'o.jpg', '3', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('13', '71871854', '小米5s plus', '2200', null, '小米5s plus', '584f4b6aN004be426.jpg', '1', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('14', '14037991', '清风原木纯品', '100', null, '清风原木纯品', '58b6549eN7256d4f4.jpg', '1', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('15', '31918306', '欧普照明', '300', null, '欧普照明', '57ce833aNfdf7486e.jpg', '1', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('16', '66800378', '浮生六记', '22', null, '浮生六记', '575e45bfNd1fd1f28.jpg', '2', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('17', '55864933', '自在独行:贾平凹的独行世界', '26', null, '自在独行:贾平凹的独行世界', '573d821aN9de83d79.jpg', '2', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('18', '70361295', '做一个刚刚好的女子', '25', null, '做一个刚刚好的女子', '574f9e37N515875b0.jpg', '2', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('19', '56046630', '皮囊', '22', null, '皮囊', '546d9a25N07687a60.jpg', '2', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('20', '82629988', '世界那么大,我想去看看', '20', null, '世界那么大,我想去看看', '57c52193Nfc2809c8.jpg', '2', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('21', '03713637', '小米 红米 4A', '599', null, '小米 红米 4A', '589d7d95N088093ae.jpg', '4', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('11', '03980960', '布鲁雅尔空气净化器', '3000', null, '这是空气净化器', '5807305cN2c2e5e33.jpg', '1', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('22', '77434496', '荣耀 畅玩 5C', '1099', null, '荣耀 畅玩 5C', '5844f3a1N233450bb.jpg', '4', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('23', '85375886', '华为 畅享5S', '999', null, '华为 畅享5S', '56809e0cN2dbd7bca.jpg', '4', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('24', '65025330', '小米 红米 4X', '699', null, '小米 红米 4X', '58c6393dNb4dc74a3.jpg', '4', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('25', '253aad70-2693-44df-bd3b-052dccb32987', '诺基亚6', '1699', null, '诺基亚6', '58dcbfa5N5c41cbfd.jpg', '4', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('26', 'cc4073bc-3d6e-495a-a6c0-2d0443f790e8', 'Apple MacBook Air 13.3英寸笔记本电脑', '6988', null, 'Apple MacBook Air 13.3英寸笔记本电脑', '57b12a31N8f4f75a3.jpg', '5', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('27', 'f0cae329-6b64-4a26-bd23-9a0db098738a', '小米(MI)Air 13.3英寸全金属超轻薄笔记本电脑', '4899', null, '小米(MI)Air 13.3英寸全金属超轻薄笔记本电脑', '57e3b072N661cd00d.jpg', '5', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('28', '224a51d2-b089-4198-abcc-e3dc7d57586f', '戴尔DELL灵越燃7000 R1605S 14.0英寸轻薄窄边框笔记本电脑', '5199', null, '戴尔DELL灵越燃7000 R1605S 14.0英寸轻薄窄边框笔记本电脑', '58cfc3a9N7f08db3f.jpg', '5', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('29', '80858fc9-75d5-47cc-b9c2-f4f678221592', '联想(Lenovo)小新Air Pro13.3英寸14.8mm超轻薄笔记本电脑', '5399', null, '联想(Lenovo)小新Air Pro13.3英寸14.8mm超轻薄笔记本电脑', '58cfb3efNdbf60df7.jpg', '5', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('30', '98b70337-e69f-4aff-b1f7-8c82d15179dd', 'ThinkPad X270（00CD）12.5英寸轻薄笔记本电脑', '7999', null, 'ThinkPad X270（00CD）12.5英寸轻薄笔记本电脑', '58db548cNbfb15915.jpg', '5', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('31', 'e43f9489-e635-459d-90d8-173be7152959', '格力（GREE）正1.5匹 变频 品圆 冷暖 壁挂式空调 KFR-35GW/(35592)FNhDa-A3', '3399', null, '格力（GREE）正1.5匹 变频 品圆 冷暖 壁挂式空调 KFR-35GW/(35592)FNhDa-A3', '58ccfffcNd70c9a03.jpg', '6', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('32', '6b06ba8e-79ba-4ce1-bf1c-463dd94f3a84', '奥克斯（AUX）正1.5匹 冷暖 定速 空调挂机(KFR-35GW/HFJ+3)', '1899', null, '奥克斯（AUX）正1.5匹 冷暖 定速 空调挂机(KFR-35GW/HFJ+3)', '58d08872N4b68f79f.jpg', '6', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('33', 'bb2a9e04-1970-4e55-9acb-62acc3bdd053', '美的（Midea）1.5匹 京东英雄 壁挂式冷暖变频空调KFR-35GW/WPAA3', '2899', null, '美的（Midea）1.5匹 京东英雄 壁挂式冷暖变频空调KFR-35GW/WPAA3', '58cb9e8fNef8d2176.jpg', '6', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('34', 'e0df07ec-ef02-49e6-82cc-4ed8efc96b04', '格力（GREE）大1匹 变频冷暖 智享 微联智能 壁挂式空调 KFR-26GW/(26559)FNAd-A3（WIFI）', '3299', null, '格力（GREE）大1匹 变频冷暖 智享 微联智能 壁挂式空调 KFR-26GW/(26559)FNAd-A3（WIFI）', '58cf7cfbNb5fcfbb8.jpg', '6', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('35', '9542413c-29ad-46da-bd24-72132a8fbd4', '格力（GREE）2匹 定频 i酷 冷暖圆柱柜机空调 KFR-50LW/(50551)NhAa-3', '6299', null, '格力（GREE）2匹 定频 i酷 冷暖圆柱柜机空调 KFR-50LW/(50551)NhAa-3', '58cd0501Nd3c2f983.jpg', '6', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('36', '9a64fd47-4e9f-4ec6-ac26-d84d82753594', '内衣收纳盒收纳箱塑料内裤袜子整理盒有盖储物箱可水洗收纳用品三件套 A款印花紫色三件套+3盖', '35', null, '内衣收纳盒收纳箱塑料内裤袜子整理盒有盖储物箱可水洗收纳用品三件套 A款印花紫色三件套+3盖', '58c5fba6N6a4305c7.jpg', '7', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('37', '66799835-d757-481e-ac3f-53f657d8b415', '傲家 塑料抽屉式收纳柜整理柜储物柜内衣儿童宝宝衣柜衣物收纳箱盒 特大号透明', '45', null, '傲家 塑料抽屉式收纳柜整理柜储物柜内衣儿童宝宝衣柜衣物收纳箱盒 特大号透明', '5821444bN5288f951.png', '7', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('38', '1874ff90-320b-4c74-af98-79fde725c629', '奕辰 收纳箱防水牛津布钢架储物盒66L大号衣服整理箱 蓝色太阳花', '29', null, '奕辰 收纳箱防水牛津布钢架储物盒66L大号衣服整理箱 蓝色太阳花', '56d3b4a3N41677e65.jpg', '7', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('39', 'd2482807-e5eb-494d-b46f-2c91cb6456bc', '百露冰箱保鲜盒收纳盒 食品储物盒杂粮收纳箱厨房收纳筐 收纳用品 超值2个装', '29.90', null, '百露冰箱保鲜盒收纳盒 食品储物盒杂粮收纳箱厨房收纳筐 收纳用品 超值2个装', '57bd62e0Nf3ce55bb.jpg', '7', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('40', '7ab966ea-47f4-4bf3-87c4-c22f3279a0cb', '华美仕HMESI 皮革多功能桌面收纳盒 文具笔筒杂物储物整理格 商务办公桌面收纳用品 黑色牛皮纹【单抽多功能收纳盒】', '59', null, '华美仕HMESI 皮革多功能桌面收纳盒 文具笔筒杂物储物整理格 商务办公桌面收纳用品 黑色牛皮纹【单抽多功能收纳盒】', '5859eca5N2bf51752.jpg', '7', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('41', 'b1c70ad8-5afe-4f4b-8af8-3d1c51d1f9e9', '九阳（Joyoung）30cm炒锅不粘锅少油烟燃气煤气电磁炉通用锅具赠木铲CLB3031D', '99', null, '九阳（Joyoung）30cm炒锅不粘锅少油烟燃气煤气电磁炉通用锅具赠木铲CLB3031D', '58621d43Ndaad1379.jpg', '8', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('43', '79bc3218-ce99-4e02-b3a3-c734661d31b9', '九阳（Joyoung）30cm炒锅不粘锅少油烟燃气煤气电磁炉通用锅具赠木铲CLB3031D', '99', null, '九阳（Joyoung）30cm炒锅不粘锅少油烟燃气煤气电磁炉通用锅具赠木铲CLB3031D', '58621d43Ndaad1379.jpg', '8', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('44', '8ed0fa5b-8fa2-463c-b884-e6949159148e', '九阳（Joyoung）30cm炒锅不粘锅少油烟燃气煤气电磁炉通用锅具赠木铲CLB3031D', '99', null, '九阳（Joyoung）30cm炒锅不粘锅少油烟燃气煤气电磁炉通用锅具赠木铲CLB3031D', '58621d43Ndaad1379.jpg', '8', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('46', 'b489e68c-ccde-41f2-a92f-bd82192388f', null, null, null, null, null, '9', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('47', '46cc92d7-06db-414e-b01c-f7494102e38e', null, null, null, null, null, '9', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('48', '917d3db5-c0e0-4291-adc3-29c431f5c3c3', null, null, null, null, null, '9', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('49', '027359f1-49cb-4919-a1bc-8a366dee58c3', null, null, null, null, null, '9', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('50', '48b9b6d2-b7c5-4d28-8143-fa20f469be67', null, null, null, null, null, '9', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('51', '772f8c63-b05b-40bb-9068-c56c0a34779c', null, null, null, null, null, '10', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('52', '0ca82113-d5fe-4fad-b9b2-556117c65e49', null, null, null, null, null, '10', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('53', '8b9b47d5-bd56-41f1-93cc-5a564ae5a2ce', null, null, null, null, null, '10', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('54', '91b8a609-3084-4c85-8999-04ec76d0efbe', null, null, null, null, null, '10', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('55', 'd214531c-426f-491e-96ed-732c1bac6415', null, null, null, null, null, '10', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('56', '6ef96cf9-a2c7-4b79-8ff1-84d8a7591529', null, null, null, null, null, '11', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('57', '14e8e4cb-39b5-4b1c-9d08-59789c319ce', null, null, null, null, null, '11', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('58', '34423a0c-3d34-4e70-91d9-0f2484d106f4', null, null, null, null, null, '11', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('59', '84febeed-a73c-4f52-b3a3-78df3f4f706', null, null, null, null, null, '11', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('60', '319a0109-9b7a-4c6c-ae8a-0fe6eaa2cf60', null, null, null, null, null, '11', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('61', '319a0109-9b7a-4c6c-ae8a-0fe6eaa2cf60', null, null, null, null, null, '12', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('62', '19b12d18-7671-479d-ba45-c9c71dd414f9', null, null, null, null, null, '12', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('63', '5bab389c-aa21-452b-9757-77617ad8b74f', null, null, null, null, null, '12', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('64', '44d67889-aca5-4495-abba-77dc521958c4', null, null, null, null, null, '12', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('65', '5a6d01e0-8e2a-4afa-b9ef-e48c1f996e3e', null, null, null, null, null, '12', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('66', '69cc2161-6a8b-4f41-8f05-0e137b0a4572', null, null, null, null, null, '13', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('67', '1d4b521f-8600-4f3d-bd47-0b06dc80cd47', null, null, null, null, null, '13', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('68', 'd9271692-25e3-4dff-8877-07aa085dc025', null, null, null, null, null, '13', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('69', '5d496ea6-75d5-41d0-9aca-73ad1d0886b6', null, null, null, null, null, '13', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('70', '8f7a5ffd-9499-4b74-80c5-d74db77f4de8', null, null, null, null, null, '13', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('71', '18b95917-a6ad-4aa9-851a-537d0242ebbc', null, null, null, null, null, '14', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('42', 'f7b8fd55-ddc2-4543-98f4-14a22b534582', '九阳（Joyoung）30cm炒锅不粘锅少油烟燃气煤气电磁炉通用锅具赠木铲CLB3031D', '99', null, '九阳（Joyoung）30cm炒锅不粘锅少油烟燃气煤气电磁炉通用锅具赠木铲CLB3031D', '58621d43Ndaad1379.jpg', '8', '0');
INSERT INTO "SYSTEM"."GP_MALLING_GOODS" VALUES ('45', 'edfe6e3f-b491-42b1-a09f-acf8dd6ae0c4', '九阳（Joyoung）30cm炒锅不粘锅少油烟燃气煤气电磁炉通用锅具赠木铲CLB3031D', '99', null, '九阳（Joyoung）30cm炒锅不粘锅少油烟燃气煤气电磁炉通用锅具赠木铲CLB3031D', '58621d43Ndaad1379.jpg', '8', '0');

-- ----------------------------
-- Indexes structure for table GP_MALLING_GOODS
-- ----------------------------

-- ----------------------------
-- Checks structure for table GP_MALLING_GOODS
-- ----------------------------
ALTER TABLE "SYSTEM"."GP_MALLING_GOODS" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table GP_MALLING_GOODS
-- ----------------------------
ALTER TABLE "SYSTEM"."GP_MALLING_GOODS" ADD PRIMARY KEY ("ID");
