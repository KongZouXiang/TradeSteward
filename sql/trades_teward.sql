/*
 Navicat MySQL Data Transfer

 Source Server         : liunx
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 47.106.37.123:3306
 Source Schema         : trades_teward

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 05/01/2019 00:06:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account_transfer
-- ----------------------------
DROP TABLE IF EXISTS `account_transfer`;
CREATE TABLE `account_transfer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `at_out_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '转出账户',
  `at_out_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '转出日期',
  `at_into_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '转入账户',
  `at_into_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '到账日期',
  `at_money` double NULL DEFAULT NULL COMMENT '金额',
  `at_charge` double NULL DEFAULT NULL COMMENT '手续费',
  `at_charge_person` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手续费支付方',
  `at_person` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `at_remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经手人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '账户转账表(ymy)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chara_manger
-- ----------------------------
DROP TABLE IF EXISTS `chara_manger`;
CREATE TABLE `chara_manger`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ch_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `ch_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for commclass
-- ----------------------------
DROP TABLE IF EXISTS `commclass`;
CREATE TABLE `commclass`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cc_default` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品分类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commclass
-- ----------------------------
INSERT INTO `commclass` VALUES (1, '默认分类');
INSERT INTO `commclass` VALUES (2, '酒');
INSERT INTO `commclass` VALUES (3, '食品');
INSERT INTO `commclass` VALUES (4, '服装');

-- ----------------------------
-- Table structure for commodi_tytemplate
-- ----------------------------
DROP TABLE IF EXISTS `commodi_tytemplate`;
CREATE TABLE `commodi_tytemplate`  (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ct_template_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板编号',
  `ct_tytemplate_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板名称',
  `ct_templategoods` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板商品',
  `ct_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品模板' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodi_tytemplate
-- ----------------------------
INSERT INTO `commodi_tytemplate` VALUES (1, '111111', '聚划算', '很多', NULL);
INSERT INTO `commodi_tytemplate` VALUES (2, '222222', '超实惠', '各种', NULL);
INSERT INTO `commodi_tytemplate` VALUES (3, '333333', '很便宜', '等等', NULL);
INSERT INTO `commodi_tytemplate` VALUES (4, '444444', '哈哈', '水果', NULL);
INSERT INTO `commodi_tytemplate` VALUES (5, '555555', '哼哼', '蔬菜', NULL);
INSERT INTO `commodi_tytemplate` VALUES (6, '666666', '呜呜', '礼品', NULL);
INSERT INTO `commodi_tytemplate` VALUES (7, '111111', '聚划算', '', NULL);

-- ----------------------------
-- Table structure for commodity_list
-- ----------------------------
DROP TABLE IF EXISTS `commodity_list`;
CREATE TABLE `commodity_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cl_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `us_id` int(8) NULL DEFAULT NULL COMMENT '基本单位(外键)',
  `cl_scan` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '条形码',
  `cl_spec` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `cl_pur_price` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进货价格',
  `cl_who_price` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批发价',
  `cl_tag_prise` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零售价',
  `cc_id` int(8) NULL DEFAULT NULL COMMENT '商品分类（外键）',
  `wm_id` int(8) NULL DEFAULT NULL COMMENT '仓库（外键）',
  `cl_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity_list
-- ----------------------------
INSERT INTO `commodity_list` VALUES (1, '食品', NULL, '条形', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `commodity_list` VALUES (2, '酒水', NULL, '因', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `commodity_list` VALUES (3, '面试', NULL, '啊顺丰到付', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `commodity_list` VALUES (4, '阿萨德', NULL, '暗室逢灯', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `commodity_list` VALUES (5, '饮料', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `commodity_list` VALUES (6, '饮料', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cus_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `cus_compname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司名',
  `cus_money` double NULL DEFAULT NULL COMMENT '应收欠款（元）',
  `cus_tele` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `cus_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系人',
  `cus_flag` int(9) NULL DEFAULT 1 COMMENT '状态',
  `cus_connname` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联人员',
  `cus_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `cus_email` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `cus_qq` int(10) NULL DEFAULT NULL COMMENT 'qq',
  `cus_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '18595468090', '南瞻公司', NULL, '18595468090', '李wu', 1, NULL, '河南周口', NULL, NULL, NULL);
INSERT INTO `customer` VALUES (2, 'KH20190103000', '盈云公司', NULL, '18595468090', '张三', 1, NULL, '河南郑州', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for customer_level
-- ----------------------------
DROP TABLE IF EXISTS `customer_level`;
CREATE TABLE `customer_level`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `cl_level` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户级别',
  `cl_corresponding_grade` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应等级价',
  `cl_discount` int(255) NULL DEFAULT 100 COMMENT '折扣',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户等级价' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employ
-- ----------------------------
DROP TABLE IF EXISTS `employ`;
CREATE TABLE `employ`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `em_username` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工名',
  `em_realname` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `em_role` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `em_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `em_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `em_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `em_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `em_repo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联仓库',
  `em_shiro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '价格权限',
  `em_sel_invoice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查看他人单据',
  `em_del_invoice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作废他人单据',
  `em_sel_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查看他人客户',
  `em_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employ
-- ----------------------------
INSERT INTO `employ` VALUES (1, '张三', '张伞', '营业员', '男', '131035465123', '836738564@qq.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `employ` VALUES (2, '张三', '张伞', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for finance_classify
-- ----------------------------
DROP TABLE IF EXISTS `finance_classify`;
CREATE TABLE `finance_classify`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fc_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账目类型',
  `fc_sort` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收支类别',
  `fc_remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收支分类管理表(ymy)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of finance_classify
-- ----------------------------
INSERT INTO `finance_classify` VALUES (1, '其他支出', '支出', '');
INSERT INTO `finance_classify` VALUES (2, '燃气费\r\n', '支出', NULL);
INSERT INTO `finance_classify` VALUES (3, '员工工资', '支出', NULL);
INSERT INTO `finance_classify` VALUES (4, '其他收入', '收入', NULL);
INSERT INTO `finance_classify` VALUES (5, '通讯费', '支出', NULL);
INSERT INTO `finance_classify` VALUES (6, '电费', '支出', NULL);
INSERT INTO `finance_classify` VALUES (7, '水费', '支出', NULL);
INSERT INTO `finance_classify` VALUES (8, '修理费', '支出', NULL);
INSERT INTO `finance_classify` VALUES (9, '123', '23513', '12');

-- ----------------------------
-- Table structure for finance_order
-- ----------------------------
DROP TABLE IF EXISTS `finance_order`;
CREATE TABLE `finance_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fo_num_list` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单据编号',
  `fo_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务日期',
  `fo_fc_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账目类型',
  `fo_money` double NULL DEFAULT NULL COMMENT '金额',
  `fo_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收入账户',
  `fo_person` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经手人',
  `fo_remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `fo_image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片附件',
  `fo_flag` int(2) NOT NULL COMMENT '0代表日常支出1代表日常收入',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收支订单管理表(ymy)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of finance_order
-- ----------------------------
INSERT INTO `finance_order` VALUES (1, 'SZ20190104003', '2019-01-04', '其他收入', 33, '现金', '老板', NULL, NULL, 1);
INSERT INTO `finance_order` VALUES (2, 'SZ20190104002', '2019-01-04', '其他收入', 1245, '建设银行', '老板', NULL, NULL, 1);
INSERT INTO `finance_order` VALUES (3, 'SZ20190104001', '2019-01-04', '其他收入', 500, '现金', '老板', NULL, NULL, 1);
INSERT INTO `finance_order` VALUES (4, 'SZ20190104000', '2019-01-04', '其他收入', 132, '现金', '老板', NULL, NULL, 1);
INSERT INTO `finance_order` VALUES (5, 'SZ20190104004', '2019-01-04', '电费', 110, '现金', '老板', NULL, NULL, 0);
INSERT INTO `finance_order` VALUES (6, 'SZ20190104005', '2019-01-04', '水费', 65, '现金', '老板', NULL, NULL, 0);
INSERT INTO `finance_order` VALUES (7, 'SZ20190104006', '2019-01-04', '通讯费', 600, '建设银行', '老板', NULL, NULL, 0);
INSERT INTO `finance_order` VALUES (8, 'SZ20190104007', '2019-01-04', '燃气费', 150, '现金', '老板', NULL, NULL, 0);

-- ----------------------------
-- Table structure for fund_client_debt
-- ----------------------------
DROP TABLE IF EXISTS `fund_client_debt`;
CREATE TABLE `fund_client_debt`  (
  `fcd_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fcd_num_list` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户编号',
  `fcd_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户名称',
  `fcd_linkman` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `fcd_telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `fcd_begin_debt` double NULL DEFAULT NULL COMMENT '期初欠款',
  `fcd_add_debt` double NULL DEFAULT NULL COMMENT '增加应收欠款',
  `fcd_back_debt` double NULL DEFAULT NULL COMMENT '收回欠款',
  `fcd_discount` double NULL DEFAULT NULL COMMENT '优惠',
  `fcd_offset_deb` double NULL DEFAULT NULL COMMENT '核销欠款',
  `fcd_receivable` double NULL DEFAULT NULL COMMENT '应收欠款',
  PRIMARY KEY (`fcd_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户应收欠款表(ymy)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fund_provider_debt
-- ----------------------------
DROP TABLE IF EXISTS `fund_provider_debt`;
CREATE TABLE `fund_provider_debt`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fpd_num_list` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商编号',
  `fpd_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商名称',
  `fpd_linkman` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系人',
  `fpd_begin_debt` double NOT NULL COMMENT '期初欠款',
  `fpd_add_debt` double NOT NULL COMMENT '增加应付欠款',
  `fpd_pay_debt` double NOT NULL COMMENT '支付欠款',
  `fpd_discount` double NOT NULL COMMENT '优惠欠款',
  `fpd_offset_deb` double NOT NULL COMMENT '核销欠款',
  `fpd_receivable` double NOT NULL COMMENT '应付欠款',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商应付欠款表(ymy)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for guider
-- ----------------------------
DROP TABLE IF EXISTS `guider`;
CREATE TABLE `guider`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gu_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `gu_status` int(11) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '导购员管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for num_rule
-- ----------------------------
DROP TABLE IF EXISTS `num_rule`;
CREATE TABLE `num_rule`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号类型',
  `num_web` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网页版编号规则',
  `num_before` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前缀',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '单号规则' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of num_rule
-- ----------------------------
INSERT INTO `num_rule` VALUES (1, '收款单编号', 'SKD{YYYY}{MM}{DD}{##}', 'SKD');
INSERT INTO `num_rule` VALUES (2, '盘点单编号', 'PD{YYYY}{MM}{DD}{##}', 'PD');
INSERT INTO `num_rule` VALUES (3, '销售订单编号', 'XDD{YYYY}{MM}{DD}{##}\r\n', 'XDD');
INSERT INTO `num_rule` VALUES (4, '出库单编号', 'CKD{YYYY}{MM}{DD}{##}', 'CKD');
INSERT INTO `num_rule` VALUES (5, '进货单编号', 'JHD{YYYY}{MM}{DD}{##}', 'JHD');
INSERT INTO `num_rule` VALUES (6, '入库单编号', 'RKD{YYYY}{MM}{DD}{##}', 'RKD');
INSERT INTO `num_rule` VALUES (7, '销售单编号', 'XSD{YYYY}{MM}{DD}{##}', 'XSD');
INSERT INTO `num_rule` VALUES (8, '商品编号', 'SP{YYYY}{MM}{DD}{##}', 'SP');

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property`  (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pr_brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌',
  `pr_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产地',
  `pr_zidingyi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自定义属性',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '属性设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for purchase_history
-- ----------------------------
DROP TABLE IF EXISTS `purchase_history`;
CREATE TABLE `purchase_history`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `ph_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务日期',
  `ph_number` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单据编号',
  `sup_id` int(8) NULL DEFAULT NULL COMMENT '供应商（外键）',
  `wa_id` int(8) NULL DEFAULT NULL COMMENT '仓库id(外键)',
  `ph_quantity` int(8) NULL DEFAULT NULL COMMENT '进货数量',
  `ph_warehouse` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入库仓库',
  `ph_bill` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纸质单据',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '进货历史' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for purchase_order
-- ----------------------------
DROP TABLE IF EXISTS `purchase_order`;
CREATE TABLE `purchase_order`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `po_date` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务日期',
  `po_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单据编号',
  `po_state` int(8) NULL DEFAULT NULL COMMENT '处理状态',
  `po_auditor` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核人',
  `po_sup_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `po_cl_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `po_quantity_of_purchase` int(8) NULL DEFAULT NULL COMMENT '进货数量',
  `po_ying_money` double(10, 2) NULL DEFAULT NULL COMMENT '应付金额',
  `po_bill` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纸质单据',
  `po_experienced_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经手人',
  `po_single_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '制单人',
  `po_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `po_date_order` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '制单日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '进货订单历史' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of purchase_order
-- ----------------------------
INSERT INTO `purchase_order` VALUES (1, '2019-01-03', 'JDD20190103000', 1, NULL, '默认供应商', '大白兔奶糖', 1, 5.90, '1.jpg', '老板', '老板', '这是一个未审核的订单', '2019-01-03');
INSERT INTO `purchase_order` VALUES (2, '2019-01-03', 'JDD20190103001', 1, '', '默认供应商', '小白兔', 1, NULL, '2.jpg', '老板', '老板', '测试', NULL);
INSERT INTO `purchase_order` VALUES (3, '2019-01-04', '46454564654564', 1, '老板1', '供应商1', '超级多', 10, 49.99, '1.jpg', '老板1', '老板1', '这是一个备注', '2019-04-01');
INSERT INTO `purchase_order` VALUES (4, '2019-01-04', '46454564654564', 1, '老板1', '供应商1', '超级多', 10, 49.99, '1.jpg', '老板1', '老板1', '这是一个备注', '2019-04-01');
INSERT INTO `purchase_order` VALUES (5, '2019-01-04', '4156544654', 1, '老板', '老板', '大白兔', 5, 4.99, '1.jpg', '老板', '老板', '111', '2019-01-04');

-- ----------------------------
-- Table structure for purchase_return_history
-- ----------------------------
DROP TABLE IF EXISTS `purchase_return_history`;
CREATE TABLE `purchase_return_history`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prh_date` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务日期',
  `prh_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单据编号',
  `wa_id` int(8) NULL DEFAULT NULL COMMENT '仓库id(外键)',
  `sup_id` int(8) NULL DEFAULT NULL COMMENT '供应商id(外键)',
  `prh_warehouse` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出库仓库',
  `prh_bill` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纸质单据',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '进货退货历史' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for running_accounts
-- ----------------------------
DROP TABLE IF EXISTS `running_accounts`;
CREATE TABLE `running_accounts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ra_num_list` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务日期',
  `ra_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单据编号',
  `ra_company_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '往来单位名称',
  `ra_project_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收支项目名称',
  `ra_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结算账户',
  `ra_person` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经手人',
  `ra_income` double NULL DEFAULT NULL COMMENT '收入',
  `ra_outcome` double NULL DEFAULT NULL COMMENT '支出',
  `ra_current_balance` double NULL DEFAULT NULL COMMENT '当前余额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资金流水表(ymy)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sales_history
-- ----------------------------
DROP TABLE IF EXISTS `sales_history`;
CREATE TABLE `sales_history`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `cus_id` int(8) NULL DEFAULT NULL COMMENT '用户id(外键)',
  `sh_date` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务日期',
  `sh_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单据编号',
  `wa_id` int(8) NULL DEFAULT NULL COMMENT '仓库id（外键）',
  `sh_gross` double(10, 2) NULL DEFAULT NULL COMMENT '销售毛利',
  `sh_total_amount` double(10, 2) NULL DEFAULT NULL COMMENT '总计金额',
  `sh_earnest_money` double(10, 2) NULL DEFAULT NULL COMMENT '定金',
  `sh_amount_received` double(10, 2) NULL DEFAULT NULL COMMENT '实收金额',
  `sh_warehouse` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出库仓库',
  `sh_bill` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纸质单据',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '销售历史' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sales_order_history
-- ----------------------------
DROP TABLE IF EXISTS `sales_order_history`;
CREATE TABLE `sales_order_history`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `so_number` int(8) NULL DEFAULT NULL COMMENT '商品数量',
  `so_company` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `so_discount` int(8) NULL DEFAULT NULL COMMENT '折扣',
  `so_z_unit_price` double(10, 2) NULL DEFAULT NULL COMMENT '折后单价',
  `so_total_price` double(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `so_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `so_earnest_money` double(10, 2) NULL DEFAULT NULL COMMENT '定金',
  `so_payment_method` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '付款方式',
  `so_bill` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '单据',
  `so_type` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售类型',
  `cus_id` int(8) NULL DEFAULT NULL COMMENT '用户id（外键）',
  `so_state` int(8) NULL DEFAULT NULL COMMENT '处理状态',
  `so_auditor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核人',
  `cl_id` int(11) NULL DEFAULT NULL COMMENT '商品id（外键）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '销售订单历史' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sales_return_history
-- ----------------------------
DROP TABLE IF EXISTS `sales_return_history`;
CREATE TABLE `sales_return_history`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `srh_date` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务处理日期',
  `srh_number` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单据编号',
  `cus_id` int(8) NULL DEFAULT NULL COMMENT '客户id(外键)',
  `wa_id` int(8) NULL DEFAULT NULL COMMENT '仓库id(外键)',
  `srh_Warehouse` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入库仓库',
  `srh_state` int(8) NULL DEFAULT NULL COMMENT '入库状态',
  `srh_bill` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纸质单据',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '销售退货历史' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for settlement_account
-- ----------------------------
DROP TABLE IF EXISTS `settlement_account`;
CREATE TABLE `settlement_account`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `sa_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户名称',
  `sa_bank` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户银行',
  `sa_balance` double(10, 2) NULL DEFAULT NULL COMMENT '账户余额',
  `sa_state` int(8) NULL DEFAULT NULL COMMENT '状态（是否启用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '结算帐户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '注释',
  `sup_compname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司名',
  `sup_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商编号',
  `sup_money` double NULL DEFAULT NULL COMMENT '应付欠款(元)',
  `sup_tele` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `sup_flag` int(9) NOT NULL COMMENT '状态',
  `sup_linkman` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `sup_conn` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联客户',
  `sup_email` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `sup_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, '晨光文具', 'GYS20170725009', 0, '135478290000', 1, '蔡老板', NULL, NULL, '没得备注');

-- ----------------------------
-- Table structure for template_commodity
-- ----------------------------
DROP TABLE IF EXISTS `template_commodity`;
CREATE TABLE `template_commodity`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `ct_id` int(9) NULL DEFAULT NULL COMMENT '商品模板ID',
  `cl_id` int(11) NULL DEFAULT NULL COMMENT '商品列表ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品模板和商品关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for unit_settings
-- ----------------------------
DROP TABLE IF EXISTS `unit_settings`;
CREATE TABLE `unit_settings`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '单位设置',
  `us_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位名称',
  `us_dfraction` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否小数',
  `us_state` int(8) NULL DEFAULT NULL COMMENT '状态（是否启用）',
  `us_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '单位设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wa_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品编号',
  `wa_sp_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `wa_sp_specifications` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `wa_sp_company` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `wa_sp_lnventory` int(8) NULL DEFAULT NULL COMMENT '可用库存量',
  `wa_sp_current_inventory` int(8) NULL DEFAULT NULL COMMENT '当前存货',
  `wa_sp_forout` int(8) NULL DEFAULT NULL COMMENT '待出库量',
  `wa_sp_forenter` int(8) NULL DEFAULT NULL COMMENT '待入库量',
  `wa_cost` double(10, 2) NULL DEFAULT NULL COMMENT '成本价',
  `wa_total_sum` double(10, 2) NULL DEFAULT NULL COMMENT '总金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库存查询' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (1, '001', '衣服', '大', '1件', 200, 100, 20, 10, 99.80, 99.80);
INSERT INTO `warehouse` VALUES (3, '002', '鞋子', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for warehouse_management
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_management`;
CREATE TABLE `warehouse_management`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `wm_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `wm_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库名称',
  `wm_person` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `wm_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `wm_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库地址',
  `wm_postcode` int(8) UNSIGNED NULL DEFAULT NULL COMMENT '邮编',
  `wm_state` int(8) NULL DEFAULT NULL COMMENT '状态',
  `wm_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse_management
-- ----------------------------
INSERT INTO `warehouse_management` VALUES (1, '01', '郑州仓', '李恒奎', '132132', '云和数据', 451450, 1, NULL);
INSERT INTO `warehouse_management` VALUES (2, '02', '大仓', '唐凯宽', '17147', '官渡', 450450, 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
