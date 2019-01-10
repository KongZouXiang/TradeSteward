/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.13 : Database - trades_teward
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`trades_teward` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `trades_teward`;

/*Table structure for table `account_transfer` */

DROP TABLE IF EXISTS `account_transfer`;

CREATE TABLE `account_transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `at_out_account` varchar(50) DEFAULT NULL COMMENT '转出账户',
  `at_out_time` varchar(50) DEFAULT NULL COMMENT '转出日期',
  `at_into_account` varchar(50) DEFAULT NULL COMMENT '转入账户',
  `at_into_time` varchar(50) DEFAULT NULL COMMENT '到账日期',
  `at_money` double DEFAULT NULL COMMENT '金额',
  `at_charge` double DEFAULT NULL COMMENT '手续费',
  `at_charge_person` varchar(50) DEFAULT NULL COMMENT '手续费支付方',
  `at_person` varchar(50) DEFAULT NULL COMMENT '备注',
  `at_remark` varchar(50) DEFAULT NULL COMMENT '经手人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='账户转账表(ymy)';

/*Data for the table `account_transfer` */

insert  into `account_transfer`(`id`,`at_out_account`,`at_out_time`,`at_into_account`,`at_into_time`,`at_money`,`at_charge`,`at_charge_person`,`at_person`,`at_remark`) values 
(1,'建设银行','2019-01-05','现金','2019-01-05',5400,2.5,'转出账户支付','财务',NULL),
(2,'建设银行','2019-01-05','现金','2019-01-05',689090,7,'转出账户支付','仓管或采购',NULL),
(3,'现金','2019-01-05','建设银行','2019-01-05',3264,1,'转出账户支付','老板',NULL),
(4,'现金','2019-01-05','建设银行','2019-01-05',2353,3,'转出账户支付','老板',NULL);

/*Table structure for table `chara_manger` */

DROP TABLE IF EXISTS `chara_manger`;

CREATE TABLE `chara_manger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ch_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `ch_detail` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色管理';

/*Data for the table `chara_manger` */

/*Table structure for table `commclass` */

DROP TABLE IF EXISTS `commclass`;

CREATE TABLE `commclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cc_default` varchar(25) DEFAULT NULL COMMENT '商品分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品分类';

/*Data for the table `commclass` */

insert  into `commclass`(`id`,`cc_default`) values 
(1,'默认分类'),
(2,'酒'),
(3,'食品'),
(4,'服装');

/*Table structure for table `commodi_tytemplate` */

DROP TABLE IF EXISTS `commodi_tytemplate`;

CREATE TABLE `commodi_tytemplate` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ct_template_number` varchar(50) DEFAULT NULL COMMENT '模板编号',
  `ct_tytemplate_name` varchar(25) DEFAULT NULL COMMENT '模板名称',
  `ct_templategoods` varchar(255) DEFAULT NULL COMMENT '模板商品',
  `ct_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='商品模板';

/*Data for the table `commodi_tytemplate` */

insert  into `commodi_tytemplate`(`id`,`ct_template_number`,`ct_tytemplate_name`,`ct_templategoods`,`ct_remarks`) values 
(1,'111111','聚划算','很多',NULL),
(2,'222222','超实惠','各种',NULL),
(3,'333333','很便宜','等等',NULL),
(4,'444444','哈哈','水果',NULL),
(5,'555555','哼哼','蔬菜',NULL),
(6,'666666','呜呜','礼品',NULL);

/*Table structure for table `commodity_list` */

DROP TABLE IF EXISTS `commodity_list`;

CREATE TABLE `commodity_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cl_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `us_id` int(8) DEFAULT NULL COMMENT '基本单位(外键)',
  `cl_scan` varchar(25) DEFAULT NULL COMMENT '条形码',
  `cl_spec` varchar(25) DEFAULT NULL COMMENT '规格',
  `cl_pur_price` varchar(25) DEFAULT NULL COMMENT '进货价格',
  `cl_who_price` varchar(25) DEFAULT NULL COMMENT '批发价',
  `cl_tag_prise` varchar(25) DEFAULT NULL COMMENT '零售价',
  `cc_id` int(8) DEFAULT NULL COMMENT '商品分类（外键）',
  `wm_id` int(8) DEFAULT NULL COMMENT '仓库（外键）',
  `cl_number` varchar(100) DEFAULT NULL COMMENT '编号',
  `pr_id` int(255) DEFAULT NULL COMMENT '属性表的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品列表';

/*Data for the table `commodity_list` */

insert  into `commodity_list`(`id`,`cl_name`,`us_id`,`cl_scan`,`cl_spec`,`cl_pur_price`,`cl_who_price`,`cl_tag_prise`,`cc_id`,`wm_id`,`cl_number`,`pr_id`) values 
(1,'食品',NULL,'条形',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,'酒水',NULL,'因',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(3,'面试',NULL,'啊顺丰到付',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(4,'阿萨德',NULL,'暗室逢灯',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(5,'饮料',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(6,'饮料',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cus_number` varchar(50) NOT NULL COMMENT '编号',
  `cus_compname` varchar(50) NOT NULL COMMENT '公司名',
  `cus_money` double DEFAULT NULL COMMENT '应收欠款（元）',
  `cus_tele` varchar(50) NOT NULL COMMENT '联系方式',
  `cus_name` varchar(25) NOT NULL COMMENT '联系人',
  `cus_flag` int(9) DEFAULT '1' COMMENT '状态',
  `cus_connname` varchar(25) DEFAULT NULL COMMENT '关联人员',
  `cus_address` varchar(255) NOT NULL COMMENT '地址',
  `cus_email` varchar(25) DEFAULT NULL COMMENT '邮箱',
  `cus_qq` int(10) DEFAULT NULL COMMENT 'qq',
  `cus_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='客户管理';

/*Data for the table `customer` */

insert  into `customer`(`id`,`cus_number`,`cus_compname`,`cus_money`,`cus_tele`,`cus_name`,`cus_flag`,`cus_connname`,`cus_address`,`cus_email`,`cus_qq`,`cus_remarks`) values 
(1,'18595468090','南瞻公司',NULL,'18595468090','李wu',1,NULL,'河南周口',NULL,NULL,NULL),
(2,'KH20190103000','盈云公司',NULL,'18595468090','张三',1,NULL,'河南郑州',NULL,NULL,NULL);

/*Table structure for table `customer_level` */

DROP TABLE IF EXISTS `customer_level`;

CREATE TABLE `customer_level` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `cl_level` varchar(25) DEFAULT NULL COMMENT '客户级别',
  `cl_corresponding_grade` varchar(25) DEFAULT NULL COMMENT '对应等级价',
  `cl_discount` int(255) DEFAULT '100' COMMENT '折扣',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户等级价';

/*Data for the table `customer_level` */

/*Table structure for table `employ` */

DROP TABLE IF EXISTS `employ`;

CREATE TABLE `employ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `em_username` varchar(25) DEFAULT NULL COMMENT '员工名',
  `em_password` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工密码',
  `em_realname` varchar(25) DEFAULT NULL COMMENT '真实姓名',
  `em_role` varchar(25) DEFAULT NULL COMMENT '角色',
  `em_sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `em_phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `em_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `em_status` varchar(255) DEFAULT NULL COMMENT '状态',
  `em_repo` varchar(255) DEFAULT NULL COMMENT '关联仓库',
  `em_shiro` varchar(255) DEFAULT NULL COMMENT '价格权限',
  `em_sel_invoice` varchar(255) DEFAULT NULL COMMENT '查看他人单据',
  `em_del_invoice` varchar(255) DEFAULT NULL COMMENT '作废他人单据',
  `em_sel_user` varchar(255) DEFAULT NULL COMMENT '查看他人客户',
  `em_address` varchar(255) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='员工管理';

/*Data for the table `employ` */

insert  into `employ`(`id`,`em_username`,`em_password`,`em_realname`,`em_role`,`em_sex`,`em_phone`,`em_email`,`em_status`,`em_repo`,`em_shiro`,`em_sel_invoice`,`em_del_invoice`,`em_sel_user`,`em_address`) values 
(1,'张三','','张伞','营业员','男','131035465123','836738564@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,'张三','','张伞',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(3,'1','1','张三','营业员','男','131035465123','836738564@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `finance_classify` */

DROP TABLE IF EXISTS `finance_classify`;

CREATE TABLE `finance_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fc_type` varchar(50) DEFAULT NULL COMMENT '账目类型',
  `fc_sort` varchar(50) DEFAULT NULL COMMENT '收支类别',
  `fc_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='收支分类管理表(ymy)';

/*Data for the table `finance_classify` */

insert  into `finance_classify`(`id`,`fc_type`,`fc_sort`,`fc_remark`) values 
(1,'其他支出','支出',''),
(2,'燃气费\r\n','支出',NULL),
(3,'员工工资','支出',NULL),
(4,'其他收入','收入',NULL),
(5,'通讯费','支出',NULL),
(6,'电费','支出',NULL),
(7,'水费','支出',NULL),
(8,'修理费','支出',NULL),
(9,'123','23513','12');

/*Table structure for table `finance_order` */

DROP TABLE IF EXISTS `finance_order`;

CREATE TABLE `finance_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fo_num_list` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `fo_time` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `fo_fc_type` varchar(50) DEFAULT NULL COMMENT '账目类型',
  `fo_money` double DEFAULT NULL COMMENT '金额',
  `fo_account` varchar(50) DEFAULT NULL COMMENT '收入账户',
  `fo_person` varchar(50) DEFAULT NULL COMMENT '经手人',
  `fo_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `fo_image` varchar(50) DEFAULT NULL COMMENT '图片附件',
  `fo_flag` int(2) NOT NULL COMMENT '0代表日常支出1代表日常收入',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='收支订单管理表(ymy)';

/*Data for the table `finance_order` */

insert  into `finance_order`(`id`,`fo_num_list`,`fo_time`,`fo_fc_type`,`fo_money`,`fo_account`,`fo_person`,`fo_remark`,`fo_image`,`fo_flag`) values 
(1,'SZ20190104003','2019-01-04','其他收入',33,'现金','老板',NULL,NULL,1),
(2,'SZ20190104002','2019-01-04','其他收入',1245,'建设银行','老板',NULL,NULL,1),
(3,'SZ20190104001','2019-01-04','其他收入',500,'现金','老板',NULL,NULL,1),
(4,'SZ20190104000','2019-01-04','其他收入',132,'现金','老板',NULL,NULL,1),
(5,'SZ20190104004','2019-01-04','电费',110,'现金','老板',NULL,NULL,0),
(6,'SZ20190104005','2019-01-04','水费',65,'现金','老板',NULL,NULL,0),
(7,'SZ20190104006','2019-01-04','通讯费',600,'建设银行','老板',NULL,NULL,0),
(8,'SZ20190104007','2019-01-04','燃气费',150,'现金','老板',NULL,NULL,0);

/*Table structure for table `fund_client_debt` */

DROP TABLE IF EXISTS `fund_client_debt`;

CREATE TABLE `fund_client_debt` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fcd_num_list` varchar(50) DEFAULT NULL COMMENT '客户编号',
  `fcd_name` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `fcd_linkman` varchar(50) DEFAULT NULL COMMENT '联系人',
  `fcd_telephone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `fcd_begin_debt` double DEFAULT NULL COMMENT '期初欠款',
  `fcd_add_debt` double DEFAULT NULL COMMENT '增加应收欠款',
  `fcd_back_debt` double DEFAULT NULL COMMENT '收回欠款',
  `fcd_discount` double DEFAULT NULL COMMENT '优惠',
  `fcd_offset_deb` double DEFAULT NULL COMMENT '核销欠款',
  `fcd_receivable` double DEFAULT NULL COMMENT '应收欠款',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='客户应收欠款表(ymy)';

/*Data for the table `fund_client_debt` */

insert  into `fund_client_debt`(`id`,`fcd_num_list`,`fcd_name`,`fcd_linkman`,`fcd_telephone`,`fcd_begin_debt`,`fcd_add_debt`,`fcd_back_debt`,`fcd_discount`,`fcd_offset_deb`,`fcd_receivable`) values 
(1,'KH20170725004','智慧商贸','李先生','13234562234',500,144.6,0,0,0,644.6),
(2,'KH20190105000','云和数据','刘女士','15745676654',500,144.6,0,0,0,644.6),
(3,'KH20190105001','云和数据','胡女士','15745676654',500,144.6,0,0,0,644.6),
(4,'KH20190105002','智慧商贸','张先生','13234562234',500,144.6,0,0,0,644.6),
(5,'KH20190105003','智慧商贸','朱女士','13234562234',500,144.6,0,0,0,644.6);

/*Table structure for table `fund_provider_debt` */

DROP TABLE IF EXISTS `fund_provider_debt`;

CREATE TABLE `fund_provider_debt` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fpd_num_list` varchar(50) NOT NULL COMMENT '供应商编号',
  `fpd_name` varchar(50) NOT NULL COMMENT '供应商名称',
  `fpd_linkman` varchar(50) NOT NULL COMMENT '联系人',
  `fpd_begin_debt` double NOT NULL COMMENT '期初欠款',
  `fpd_add_debt` double NOT NULL COMMENT '增加应付欠款',
  `fpd_pay_debt` double NOT NULL COMMENT '支付欠款',
  `fpd_discount` double NOT NULL COMMENT '优惠欠款',
  `fpd_offset_deb` double NOT NULL COMMENT '核销欠款',
  `fpd_receivable` double NOT NULL COMMENT '应付欠款',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商应付欠款表(ymy)';

/*Data for the table `fund_provider_debt` */

/*Table structure for table `guider` */

DROP TABLE IF EXISTS `guider`;

CREATE TABLE `guider` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gu_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `gu_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `gu_status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='导购员管理';

/*Data for the table `guider` */

/*Table structure for table `merchandise_package` */

DROP TABLE IF EXISTS `merchandise_package`;

CREATE TABLE `merchandise_package` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '套餐序号',
  `mp_package_number` varchar(25) DEFAULT NULL COMMENT '套餐编号',
  `mp_package_name` varchar(25) DEFAULT NULL COMMENT '套餐名称',
  `mp_package_commodity` varchar(225) DEFAULT NULL COMMENT '套餐商品',
  `remarks` varchar(225) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品套餐';

/*Data for the table `merchandise_package` */

/*Table structure for table `num_rule` */

DROP TABLE IF EXISTS `num_rule`;

CREATE TABLE `num_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_type` varchar(255) DEFAULT NULL COMMENT '编号类型',
  `num_web` varchar(255) DEFAULT NULL COMMENT '网页版编号规则',
  `num_before` varchar(255) DEFAULT NULL COMMENT '前缀',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='单号规则';

/*Data for the table `num_rule` */

insert  into `num_rule`(`id`,`num_type`,`num_web`,`num_before`) values 
(1,'收款单编号','SKD{YYYY}{MM}{DD}{##}','SKD'),
(2,'盘点单编号','PD{YYYY}{MM}{DD}{##}','PD'),
(3,'销售订单编号','XDD{YYYY}{MM}{DD}{##}\r\n','XDD'),
(4,'出库单编号','CKD{YYYY}{MM}{DD}{##}','CKD'),
(5,'进货单编号','JHD{YYYY}{MM}{DD}{##}','JHD'),
(6,'入库单编号','RKD{YYYY}{MM}{DD}{##}','RKD'),
(7,'销售单编号','XSD{YYYY}{MM}{DD}{##}','XSD'),
(8,'商品编号','SP{YYYY}{MM}{DD}{##}','SP');

/*Table structure for table `package_commodity` */

DROP TABLE IF EXISTS `package_commodity`;

CREATE TABLE `package_commodity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `mp_id` int(15) DEFAULT NULL COMMENT '商品套餐ID',
  `cl_id` int(15) DEFAULT NULL COMMENT '商品列表ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品套餐和商品关联表';

/*Data for the table `package_commodity` */

/*Table structure for table `property` */

DROP TABLE IF EXISTS `property`;

CREATE TABLE `property` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pr_attributevalue` varchar(255) DEFAULT NULL COMMENT '品牌',
  `pr_attributename` varchar(255) DEFAULT NULL COMMENT '产地',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='属性设置';

/*Data for the table `property` */

insert  into `property`(`id`,`pr_attributevalue`,`pr_attributename`) values 
(1,'品牌','产地');

/*Table structure for table `purchase_history` */

DROP TABLE IF EXISTS `purchase_history`;

CREATE TABLE `purchase_history` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `ph_date` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `ph_number` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `ph_supname` varchar(50) DEFAULT NULL COMMENT '供应商名称',
  `ph_clname` varchar(8) DEFAULT NULL COMMENT '进货商品',
  `ph_quantity` int(8) DEFAULT NULL COMMENT '进货数量',
  `ph_amount_payable` double(10,2) DEFAULT NULL COMMENT '应付金额',
  `ph_amount_paid` double(10,2) DEFAULT NULL COMMENT '已付金额',
  `ph_warehouse` varchar(50) DEFAULT NULL COMMENT '入库仓库',
  `ph_bill` varchar(50) DEFAULT NULL COMMENT '纸质单据',
  `ph_jindate` varchar(50) DEFAULT NULL COMMENT '制单日期',
  `ph_maney_hu` varchar(50) DEFAULT NULL COMMENT '结算账户',
  `ph_experienced_person` varchar(50) DEFAULT NULL COMMENT '经手人',
  `ph_single_person` varchar(50) DEFAULT NULL COMMENT '制单人',
  `ph_other_expenses` varchar(50) DEFAULT NULL COMMENT '其他费用',
  `ph_warehousing_status` varchar(50) DEFAULT NULL COMMENT '入库状态',
  `ph_remarks` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='进货历史';

/*Data for the table `purchase_history` */

insert  into `purchase_history`(`id`,`ph_date`,`ph_number`,`ph_supname`,`ph_clname`,`ph_quantity`,`ph_amount_payable`,`ph_amount_paid`,`ph_warehouse`,`ph_bill`,`ph_jindate`,`ph_maney_hu`,`ph_experienced_person`,`ph_single_person`,`ph_other_expenses`,`ph_warehousing_status`,`ph_remarks`) values 
(1,NULL,'123456789',NULL,NULL,NULL,0.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `purchase_order` */

DROP TABLE IF EXISTS `purchase_order`;

CREATE TABLE `purchase_order` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `po_date` varchar(25) DEFAULT NULL COMMENT '业务日期',
  `po_number` varchar(255) DEFAULT NULL COMMENT '单据编号',
  `po_state` int(8) DEFAULT NULL COMMENT '处理状态',
  `po_auditor` varchar(25) DEFAULT NULL COMMENT '审核人',
  `po_sup_name` varchar(255) DEFAULT NULL COMMENT '供应商名称',
  `po_cl_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `po_quantity_of_purchase` int(8) DEFAULT NULL COMMENT '进货数量',
  `po_ying_money` double(10,2) DEFAULT NULL COMMENT '应付金额',
  `po_bill` varchar(25) DEFAULT NULL COMMENT '纸质单据',
  `po_experienced_person` varchar(255) DEFAULT NULL COMMENT '经手人',
  `po_single_person` varchar(255) DEFAULT NULL COMMENT '制单人',
  `po_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `po_date_order` varchar(50) DEFAULT NULL COMMENT '制单日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='进货订单历史';

/*Data for the table `purchase_order` */

insert  into `purchase_order`(`id`,`po_date`,`po_number`,`po_state`,`po_auditor`,`po_sup_name`,`po_cl_name`,`po_quantity_of_purchase`,`po_ying_money`,`po_bill`,`po_experienced_person`,`po_single_person`,`po_remarks`,`po_date_order`) values 
(1,'2019-01-03','JDD20190103000',1,NULL,'默认供应商','大白兔奶糖',1,5.90,'1.jpg','老板','老板','这是一个未审核的订单','2019-01-03'),
(2,'2019-01-03','JDD20190103001',1,'','默认供应商','小白兔',1,NULL,'2.jpg','老板','老板','测试',NULL),
(3,'2019-01-04','46454564654564',1,'老板1','供应商1','超级多',10,49.99,'1.jpg','老板1','老板1','这是一个备注','2019-04-01'),
(4,'2019-01-04','46454564654564',1,'老板1','供应商1','超级多',10,49.99,'1.jpg','老板1','老板1','这是一个备注','2019-04-01'),
(5,'20191111','5564114654651',1,'','默认','大白兔奶糖',10,4.19,'5.jpg','老板','老板','这是个？','2019-01-04'),
(6,'2019-01-08','dfsd15155156',0,'老板1','供应商1','大白兔，小白兔',5,43.99,'1.jpg','老板','老板','这是个备注','2019-01-08'),
(7,'2019-01-08','dfsd1111111111',0,'老板1','供应商1','大白兔，小白兔',5,43.99,'1.jpg','老板','老板','这是个备注','2019-01-08'),
(8,NULL,'5441545451',NULL,NULL,NULL,NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `purchase_return_history` */

DROP TABLE IF EXISTS `purchase_return_history`;

CREATE TABLE `purchase_return_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prh_date` varchar(25) DEFAULT NULL COMMENT '业务日期',
  `prh_number` varchar(255) DEFAULT NULL COMMENT '单据编号',
  `prh_pur_order` varchar(255) DEFAULT NULL COMMENT '关联进货单号',
  `prh_supname` varchar(50) DEFAULT NULL COMMENT '供应商名称',
  `prh_returnsup` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '退货商品',
  `prh_total_amount` double(10,2) DEFAULT NULL COMMENT '总计金额',
  `prh_refund_amount` double(10,2) DEFAULT NULL COMMENT '实退金额',
  `prh_outgoing_warehouse` varchar(255) DEFAULT NULL COMMENT '出库仓库',
  `prh_bill` varchar(25) DEFAULT NULL COMMENT '纸质单据',
  `prh_jindate` varchar(50) DEFAULT NULL COMMENT '制单日期',
  `prh_maney_hu` varchar(50) DEFAULT NULL COMMENT '结算账户',
  `prh_experienced_person` varchar(50) DEFAULT NULL COMMENT '经手人',
  `prh_single_person` varchar(50) DEFAULT NULL COMMENT '制单人',
  `ph_other_expenses` double(10,2) DEFAULT NULL COMMENT '其他费用',
  `prh_outgoing_state` varchar(50) DEFAULT NULL COMMENT '出库状态',
  `prh_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='进货退货历史';

/*Data for the table `purchase_return_history` */

/*Table structure for table `running_accounts` */

DROP TABLE IF EXISTS `running_accounts`;

CREATE TABLE `running_accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ra_num_list` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `ra_time` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `ra_company_name` varchar(50) DEFAULT NULL COMMENT '往来单位名称',
  `ra_project_name` varchar(50) DEFAULT NULL COMMENT '收支项目名称',
  `ra_account` varchar(50) DEFAULT NULL COMMENT '结算账户',
  `ra_person` varchar(50) DEFAULT NULL COMMENT '经手人',
  `ra_income` double DEFAULT NULL COMMENT '收入',
  `ra_outcome` double DEFAULT NULL COMMENT '支出',
  `ra_current_balance` double DEFAULT NULL COMMENT '当前余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金流水表(ymy)';

/*Data for the table `running_accounts` */

/*Table structure for table `sales_history` */

DROP TABLE IF EXISTS `sales_history`;

CREATE TABLE `sales_history` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `sh_date` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `sh_number` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `sh_connect` varchar(50) DEFAULT NULL COMMENT '关联订单号',
  `sh_client` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `sh_sell_goods` varchar(50) DEFAULT NULL COMMENT '销售商品',
  `sh_sell_count` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '销售数量',
  `sh_discount` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '折扣金额',
  `sh_mins` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '扣除定金',
  `sh_profit` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '销售毛利',
  `sh_money` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '总计金额',
  `sh_true_money` varchar(50) DEFAULT NULL COMMENT '实收金额',
  `sh_house` varchar(50) DEFAULT NULL COMMENT '出库仓库',
  `sh_bills` varchar(50) DEFAULT NULL COMMENT '纸质单据',
  `sh_create_date` varchar(50) DEFAULT NULL COMMENT '制单日期',
  `sh_give_date` varchar(50) DEFAULT NULL COMMENT '送货日期',
  `sh_other` varchar(50) DEFAULT NULL COMMENT '其他费用',
  `sh_end_comm` varchar(50) DEFAULT NULL COMMENT '结算账户',
  `sh_hander` varchar(50) DEFAULT NULL COMMENT '经手人',
  `sh_maker` varchar(50) DEFAULT NULL COMMENT '制单人',
  `sh_type` varchar(50) DEFAULT NULL COMMENT '销售类型',
  `sh_status` varchar(50) DEFAULT NULL COMMENT '出库状态',
  `sh_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='销售历史';

/*Data for the table `sales_history` */

insert  into `sales_history`(`id`,`sh_date`,`sh_number`,`sh_connect`,`sh_client`,`sh_sell_goods`,`sh_sell_count`,`sh_discount`,`sh_mins`,`sh_profit`,`sh_money`,`sh_true_money`,`sh_house`,`sh_bills`,`sh_create_date`,`sh_give_date`,`sh_other`,`sh_end_comm`,`sh_hander`,`sh_maker`,`sh_type`,`sh_status`,`sh_remark`) values 
(1,'2019-1-9','aaa',NULL,'杨1',NULL,0.00,0.00,0.00,0.00,0.00,'0','0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,NULL,'abc',NULL,'yang1',NULL,0.00,0.00,0.00,0.00,0.00,'0','本地仓库','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `sales_order_history` */

DROP TABLE IF EXISTS `sales_order_history`;

CREATE TABLE `sales_order_history` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `so_date` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `so_order_num` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `so_status` varchar(50) DEFAULT NULL COMMENT '处理状态',
  `so_auditor` varchar(50) DEFAULT NULL COMMENT '审核人',
  `so_client` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `so_order_comm` varchar(50) DEFAULT NULL COMMENT '销售订单商品',
  `so_order_count` int(11) DEFAULT NULL COMMENT '销售订单数量',
  `so_discount` double(5,2) DEFAULT NULL COMMENT '折扣金额',
  `so_money` double(5,2) DEFAULT NULL COMMENT '总计金额',
  `so_earnest` double(7,2) DEFAULT NULL COMMENT '定金',
  `so_bills` varchar(50) DEFAULT NULL COMMENT '纸质单据',
  `so_bill_date` varchar(50) DEFAULT NULL COMMENT '制单日期',
  `so_sell_count` int(11) DEFAULT NULL COMMENT '未转销售数量',
  `so_devlier_date` varchar(50) DEFAULT NULL COMMENT '送货日期',
  `so_hander` varchar(50) DEFAULT NULL COMMENT '经手人',
  `so_maker` varchar(50) DEFAULT NULL COMMENT '制单人',
  `so_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售订单历史';

/*Data for the table `sales_order_history` */

/*Table structure for table `sales_return_history` */

DROP TABLE IF EXISTS `sales_return_history`;

CREATE TABLE `sales_return_history` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `srh_date` varchar(25) DEFAULT NULL COMMENT '业务处理日期',
  `srh_number` varchar(25) DEFAULT NULL COMMENT '单据编号',
  `cus_id` int(8) DEFAULT NULL COMMENT '客户id(外键)',
  `wa_id` int(8) DEFAULT NULL COMMENT '仓库id(外键)',
  `srh_Warehouse` varchar(25) DEFAULT NULL COMMENT '入库仓库',
  `srh_state` int(8) DEFAULT NULL COMMENT '入库状态',
  `srh_bill` varchar(8) DEFAULT NULL COMMENT '纸质单据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售退货历史';

/*Data for the table `sales_return_history` */

/*Table structure for table `settlement_account` */

DROP TABLE IF EXISTS `settlement_account`;

CREATE TABLE `settlement_account` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `sa_name` varchar(25) DEFAULT NULL COMMENT '账户名称',
  `sa_bank` varchar(25) DEFAULT NULL COMMENT '开户银行',
  `sa_balance` double(10,2) DEFAULT NULL COMMENT '账户余额',
  `sa_state` int(8) DEFAULT NULL COMMENT '状态（是否启用）',
  `sa_banknumber` varchar(255) DEFAULT NULL COMMENT '银行账号',
  `sa_beginbalance` varchar(255) DEFAULT NULL COMMENT '期初余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='结算帐户';

/*Data for the table `settlement_account` */

insert  into `settlement_account`(`id`,`sa_name`,`sa_bank`,`sa_balance`,`sa_state`,`sa_banknumber`,`sa_beginbalance`) values 
(1,'李恒逵','广发银行',12.00,1,'212','1321'),
(2,'发的说法','发的',12.00,1,'12432','1321'),
(3,'浮点数','郑州银行',34.00,0,'13213','4234'),
(4,'发送到','郑州银行',12.00,1,'5465476','7657');

/*Table structure for table `succ_out_warehouse` */

DROP TABLE IF EXISTS `succ_out_warehouse`;

CREATE TABLE `succ_out_warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `so_date` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `so_number` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `so_conn_num` varchar(50) DEFAULT NULL COMMENT '关联业务单号',
  `so_company` varchar(50) DEFAULT NULL COMMENT '往来单位名称',
  `so_house` varchar(50) DEFAULT NULL COMMENT '出库仓库',
  `so_goods` varchar(50) DEFAULT NULL COMMENT '出库商品',
  `so_count` int(11) NOT NULL DEFAULT '0' COMMENT '出库量',
  `so_money` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '运费',
  `so_create_date` varchar(50) DEFAULT NULL COMMENT '制单日期',
  `so_opera` varchar(50) DEFAULT NULL COMMENT '关联业务',
  `so_log_com` varchar(50) DEFAULT NULL COMMENT '物流公司',
  `so_log_num` varchar(50) DEFAULT NULL COMMENT '物流单号',
  `so_hander` varchar(50) DEFAULT NULL COMMENT '经手人',
  `so_maker` varchar(50) DEFAULT NULL COMMENT '制单人',
  `so_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出库单';

/*Data for the table `succ_out_warehouse` */

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '注释',
  `sup_compname` varchar(50) NOT NULL COMMENT '公司名',
  `sup_number` varchar(50) NOT NULL COMMENT '供应商编号',
  `sup_money` double DEFAULT NULL COMMENT '应付欠款(元)',
  `sup_tele` varchar(25) NOT NULL COMMENT '电话',
  `sup_flag` int(9) NOT NULL COMMENT '状态',
  `sup_linkman` varchar(25) DEFAULT NULL COMMENT '联系人',
  `sup_conn` varchar(25) DEFAULT NULL COMMENT '关联客户',
  `sup_email` varchar(25) DEFAULT NULL COMMENT '邮箱',
  `sup_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='供应商管理';

/*Data for the table `supplier` */

insert  into `supplier`(`id`,`sup_compname`,`sup_number`,`sup_money`,`sup_tele`,`sup_flag`,`sup_linkman`,`sup_conn`,`sup_email`,`sup_remarks`) values 
(1,'晨光文具','GYS20170725009',0,'135478290000',1,'蔡老板',NULL,NULL,'没得备注');

/*Table structure for table `template_commodity` */

DROP TABLE IF EXISTS `template_commodity`;

CREATE TABLE `template_commodity` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `ct_id` int(9) DEFAULT NULL COMMENT '商品模板ID',
  `cl_id` int(11) DEFAULT NULL COMMENT '商品列表ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品模板和商品关联表';

/*Data for the table `template_commodity` */

insert  into `template_commodity`(`id`,`ct_id`,`cl_id`) values 
(1,2,123);

/*Table structure for table `unit_settings` */

DROP TABLE IF EXISTS `unit_settings`;

CREATE TABLE `unit_settings` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '单位设置',
  `us_name` varchar(25) DEFAULT NULL COMMENT '单位名称',
  `us_dfraction` varchar(25) DEFAULT NULL COMMENT '是否小数',
  `us_state` int(8) DEFAULT NULL COMMENT '状态（是否启用）',
  `us_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单位设置';

/*Data for the table `unit_settings` */

/*Table structure for table `wait_out_warehouse` */

DROP TABLE IF EXISTS `wait_out_warehouse`;

CREATE TABLE `wait_out_warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wo_date` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `wo_number` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `wo_type` varchar(50) DEFAULT NULL COMMENT '类型',
  `wo_company` varchar(50) DEFAULT NULL COMMENT '往来单位名称',
  `wo_house` varchar(50) DEFAULT NULL COMMENT '出库仓库',
  `wo_goods` varchar(50) DEFAULT NULL COMMENT '出库商品',
  `wo_count` int(11) DEFAULT NULL COMMENT '待出库量',
  `wo_create_date` varchar(50) DEFAULT NULL COMMENT '制单日期',
  `wo_hander` varchar(50) DEFAULT NULL COMMENT '经手人',
  `wo_maker` varchar(50) DEFAULT NULL COMMENT '制单人',
  `wo_status` varchar(50) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='等待出库';

/*Data for the table `wait_out_warehouse` */

/*Table structure for table `warehouse` */

DROP TABLE IF EXISTS `warehouse`;

CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wa_number` varchar(255) DEFAULT NULL COMMENT '商品编号',
  `wa_sp_name` varchar(25) DEFAULT NULL COMMENT '商品名称',
  `wa_sp_specifications` varchar(25) DEFAULT NULL COMMENT '规格',
  `wa_sp_company` varchar(25) DEFAULT NULL COMMENT '单位',
  `wa_sp_lnventory` int(8) DEFAULT NULL COMMENT '可用库存量',
  `wa_sp_current_inventory` int(8) DEFAULT NULL COMMENT '当前存货',
  `wa_sp_forout` int(8) DEFAULT NULL COMMENT '待出库量',
  `wa_sp_forenter` int(8) DEFAULT NULL COMMENT '待入库量',
  `wa_cost` double(10,2) DEFAULT NULL COMMENT '成本价',
  `wa_total_sum` double(10,2) DEFAULT NULL COMMENT '总金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='库存查询';

/*Data for the table `warehouse` */

insert  into `warehouse`(`id`,`wa_number`,`wa_sp_name`,`wa_sp_specifications`,`wa_sp_company`,`wa_sp_lnventory`,`wa_sp_current_inventory`,`wa_sp_forout`,`wa_sp_forenter`,`wa_cost`,`wa_total_sum`) values 
(1,'001','衣服','大','1件',200,100,20,10,99.80,99.80),
(3,'002','鞋子','大','1双',200,100,20,10,100.00,100.00);

/*Table structure for table `warehouse_management` */

DROP TABLE IF EXISTS `warehouse_management`;

CREATE TABLE `warehouse_management` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `wm_number` varchar(255) DEFAULT NULL COMMENT '编号',
  `wm_name` varchar(25) DEFAULT NULL COMMENT '仓库名称',
  `wm_person` varchar(25) DEFAULT NULL COMMENT '联系人',
  `wm_tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `wm_address` varchar(255) DEFAULT NULL COMMENT '仓库地址',
  `wm_postcode` int(8) unsigned DEFAULT NULL COMMENT '邮编',
  `wm_state` int(8) DEFAULT NULL COMMENT '状态',
  `wm_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='仓库管理';

/*Data for the table `warehouse_management` */

insert  into `warehouse_management`(`id`,`wm_number`,`wm_name`,`wm_person`,`wm_tel`,`wm_address`,`wm_postcode`,`wm_state`,`wm_remark`) values 
(1,'01','郑州仓','李恒奎','132132','云和数据',451450,1,NULL),
(2,'02','大仓','唐凯宽','17147','官渡',450450,0,NULL);

/*Table structure for table `warehouse_receipt` */

DROP TABLE IF EXISTS `warehouse_receipt`;

CREATE TABLE `warehouse_receipt` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `warehouse_receipt` */

/*Table structure for table `warehouse_undetermined` */

DROP TABLE IF EXISTS `warehouse_undetermined`;

CREATE TABLE `warehouse_undetermined` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `wu_date` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `wu_number` varchar(255) DEFAULT NULL COMMENT '单据编号',
  `wu_type` varchar(255) DEFAULT NULL COMMENT '类型',
  `wu_current_unit` varchar(50) DEFAULT NULL COMMENT '往来单位',
  `wu_warehouse` varchar(50) DEFAULT NULL COMMENT '入库仓库',
  `wu_goods_in_storage` varchar(255) DEFAULT NULL COMMENT '入库商品',
  `wu_quantity_required` int(8) DEFAULT NULL COMMENT '待入库量',
  `wu_jindate` varchar(50) DEFAULT NULL COMMENT '制单日期',
  `wu_single_person` varchar(50) DEFAULT NULL COMMENT '制单人',
  `wu_experienced_person` varchar(50) DEFAULT NULL COMMENT '经手人',
  `wu_warehousing_status` varchar(50) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `warehouse_undetermined` */

insert  into `warehouse_undetermined`(`id`,`wu_date`,`wu_number`,`wu_type`,`wu_current_unit`,`wu_warehouse`,`wu_goods_in_storage`,`wu_quantity_required`,`wu_jindate`,`wu_single_person`,`wu_experienced_person`,`wu_warehousing_status`) values 
(1,'2019-01-09','ADD201901091','进货','小史文具','默认仓库','百日红',1,'2019-01-09','老板','老板','待入库');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
