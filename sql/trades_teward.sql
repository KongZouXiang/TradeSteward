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
  `at_remark` varchar(50) DEFAULT '0' COMMENT '经手人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='账户转账表(ymy)';

/*Data for the table `account_transfer` */

insert  into `account_transfer`(`id`,`at_out_account`,`at_out_time`,`at_into_account`,`at_into_time`,`at_money`,`at_charge`,`at_charge_person`,`at_person`,at_remark) values
(1,'建设银行','2019-01-05','现金','2019-01-05',5400,2.5,'转出账户支付','财务','1111'),
(2,'建设银行','2019-01-05','现金','2019-01-05',689090,5,'转出账户支付','仓管或采购','2222'),
(3,'现金','2019-01-05','建设银行','2019-01-05',3264.23,1,'转出账户支付','老板','3333'),
(4,'现金','2019-01-05','建设银行','2019-01-05',2353,3,'转出账户支付','老板','4444'),
(5,'建设银行','2019-01-16','现金','2019-01-16',1234.04,1,'转出账户支付','老板','5555'),
(6,'现金','2019-01-16','建设银行','2019-01-16',222,0.5,'转入账户支付','老板','6666'),
(14,'建设银行','2019-01-18','建设银行','2019-01-19',213,0.3,'转出账户支付','老板','1414'),
(15,'现金','2019-01-19','建设银行','2019-01-19',2354,1,'转入账户支付','老板','1515'),
(17,'建设银行','2019-01-11','建设银行','2019-01-18',123,0.1,'转入账户支付','老板','1717'),
(18,'建设银行','2019-01-10','建设银行','2019-01-24',23,1,'转入账户支付','老板','1818');

/*Table structure for table `chara_manger` */

DROP TABLE IF EXISTS `chara_manger`;

CREATE TABLE `chara_manger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ch_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `ch_detail` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='角色管理';

/*Data for the table `chara_manger` */

insert  into `chara_manger`(`id`,`ch_name`,`ch_detail`) values 
(1,'管理组','	销售组成员能进行销售、销售退货、借出及库存查询操作。'),
(2,'财务组','仓管组成员能进行进货、进货退货、借入借出、盘点、组装拆卸、库存调拨及查询操作。同时能查看与上述业务相关的报表。'),
(3,'仓管组','财务组成员能进行慧管账下的所有操作且可以查看经营状况下的所有报表。'),
(4,'销售组','查看组成员能查看系统内所有功能但不能进行任何操作。'),
(24,'天启组','天之子');

/*Table structure for table `commclass` */

DROP TABLE IF EXISTS `commclass`;

CREATE TABLE `commclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cc_default` varchar(25) DEFAULT NULL COMMENT '商品分类',
  `cc_jibie` int(25) DEFAULT NULL COMMENT '分类级别',
  `cc_fuji` int(25) DEFAULT NULL COMMENT '所属父级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品分类';

/*Data for the table `commclass` */

insert  into `commclass`(`id`,`cc_default`,`cc_jibie`,`cc_fuji`) values 
(1,'默认分类',1,0),
(2,'酒',1,0),
(3,'食品',1,0),
(4,'服装',1,0),
(5,'白酒',2,2),
(6,'红酒',2,2),
(7,'啤酒',2,2),
(8,'水果',2,3),
(9,'蔬菜',2,3),
(10,'肉',2,3),
(11,'上衣',2,4),
(12,'裤子',2,4),
(13,'大葱',0,3),
(14,'苹果',0,8);

/*Table structure for table `commodi_tytemplate` */

DROP TABLE IF EXISTS `commodi_tytemplate`;

CREATE TABLE `commodi_tytemplate` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ct_template_number` varchar(50) DEFAULT NULL COMMENT '模板编号',
  `ct_tytemplate_name` varchar(25) DEFAULT NULL COMMENT '模板名称',
  `ct_templategoods` varchar(255) DEFAULT NULL COMMENT '模板商品',
  `ct_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='商品模板';

/*Data for the table `commodi_tytemplate` */

insert  into `commodi_tytemplate`(`id`,`ct_template_number`,`ct_tytemplate_name`,`ct_templategoods`,`ct_remarks`) values 
(2,'222222','超实惠','各种',NULL),
(3,'333333','很便宜','等等',NULL),
(4,'444444','哈哈','水果',NULL),
(5,'555555','哼哼','蔬菜',NULL),
(6,'666666','呜呜','礼品',NULL),
(9,'123456','添加上去','水果','不错哦'),
(10,'123456','添加上去','食品酒水面试','不错哦'),
(11,'156454','不错','肉','真香'),
(12,'246565','利好','鸡蛋咖啡','质量好'),
(13,'427581','i呼','酸乳','好喝'),
(14,'254544','阿萨德供热','披萨','香'),
(15,'547848','丰功硕德饭','面条大米','优质');

/*Table structure for table `commodity_list` */

DROP TABLE IF EXISTS `commodity_list`;

CREATE TABLE `commodity_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cl_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `cl_unit` varchar(8) DEFAULT NULL COMMENT '基本单位',
  `cl_scan` varchar(25) DEFAULT NULL COMMENT '条形码',
  `cl_spec` varchar(25) DEFAULT NULL COMMENT '规格',
  `cl_pur_price` varchar(25) DEFAULT NULL COMMENT '进货价格',
  `cl_who_price` varchar(25) DEFAULT NULL COMMENT '批发价',
  `cl_tag_prise` varchar(25) DEFAULT NULL COMMENT '零售价',
  `cc_id` int(8) DEFAULT NULL COMMENT '商品分类（外键）',
  `wm_id` int(8) DEFAULT NULL COMMENT '仓库（外键）',
  `cl_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品编号',
  `pr_id` int(255) DEFAULT NULL COMMENT '属性表的id',
  `cl_minstock` int(100) DEFAULT NULL COMMENT '最低库存量',
  `cl_maxstock` int(100) DEFAULT NULL COMMENT '最高库存量',
  `cl_minlingprice` varchar(255) DEFAULT NULL COMMENT '最低零售价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品列表';

/*Data for the table `commodity_list` */

insert  into `commodity_list`(`id`,`cl_name`,`cl_unit`,`cl_scan`,`cl_spec`,`cl_pur_price`,`cl_who_price`,`cl_tag_prise`,`cc_id`,`wm_id`,`cl_number`,`pr_id`,`cl_minstock`,`cl_maxstock`,`cl_minlingprice`) values 
(4,'脉动','瓶','12342434','1箱/18瓶','14','325','124',1,24,'124123',3,2,6,'1234'),
(5,'饮料11','只','安抚','19','14','124','124',1,25,'1编辑',3,2,6,'124'),
(35,'1241','无','1243','124','124','124','124',1,25,'124',3,124,124,'124'),
(50,'衣服','件','123424','红色短款','13','132','213',1,25,'1243',2,132,133,'214'),
(51,'零食','包','123','12','12','12','12',1,24,'21',2,12,12,'12'),
(52,'特殊','无','1243124','红色长款','124','214','123',1,25,'123',2,12,124,'2143');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='客户管理';

/*Data for the table `customer` */

insert  into `customer`(`id`,`cus_number`,`cus_compname`,`cus_money`,`cus_tele`,`cus_name`,`cus_flag`,`cus_connname`,`cus_address`,`cus_email`,`cus_qq`,`cus_remarks`) values 
(6,'KH20190105000','云和数据',1031645674,'15745676654','刘女士',1,'阿达','啊发发发违法司法按时按时','1566@qq.com',48946,'木得'),
(9,'KH20170725004','零售客户',156456,'13234562234','李先生',1,'阿萨德','阿斯达','1566@qq.com',156546,'奥术大师多大'),
(10,'KH20190105003','智慧商贸',0,'13234562234','朱女士',1,'是的第三','阿斯达','155269@qq.com',156489,'按时发大水发'),
(11,'KH20190105001','盈云公司',123,'15745676654','胡女士',1,'勾三搭四','根深蒂固','155269@qq.com',156748,'是否更好的'),
(12,'KH20190105002','青云湖',100000000,'13234562234','张先生',1,'基总','天空之城二楼','155269@qq.com',0,'牛皮');

/*Table structure for table `customer_level` */

DROP TABLE IF EXISTS `customer_level`;

CREATE TABLE `customer_level` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `cl_level` varchar(25) DEFAULT NULL COMMENT '客户级别',
  `cl_corresponding_grade` varchar(25) DEFAULT NULL COMMENT '对应等级价',
  `cl_discount` int(255) DEFAULT '100' COMMENT '折扣',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='客户等级价';

/*Data for the table `customer_level` */

insert  into `customer_level`(`id`,`cl_level`,`cl_corresponding_grade`,`cl_discount`) values 
(1,'普通用户','零售价',100),
(2,'一级客户','等级价一',98),
(3,'二级客户','等级价二',95),
(4,'三级用户','等级价三',92);

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
  `ch_id` int(8) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='员工管理';

/*Data for the table `employ` */

insert  into `employ`(`id`,`em_username`,`em_password`,`em_realname`,`em_role`,`em_sex`,`em_phone`,`em_email`,`em_status`,`em_repo`,`em_shiro`,`em_sel_invoice`,`em_del_invoice`,`em_sel_user`,`em_address`,`ch_id`) values 
(1,'1','1','张三','管理员','男','18595468090','270066981@qq.com','正常',NULL,NULL,NULL,NULL,NULL,NULL,1),
(52,'liuyanqi','123456','刘延琦','管理员','男','18236256555','54612344521@qq.com','正常',NULL,NULL,NULL,NULL,NULL,NULL,1),
(53,'lihengkui','123456','李恒逵','管理员','男','15737738972','45123685412@qq.com','正常',NULL,NULL,NULL,NULL,NULL,NULL,1),
(68,'yangmingyue','123456','杨明月','管理员','女','15548020356','3652345128@qq.com','正常',NULL,NULL,NULL,NULL,NULL,'江苏省南京市',1);

/*Table structure for table `finance_classify` */

DROP TABLE IF EXISTS `finance_classify`;

CREATE TABLE `finance_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fc_type` varchar(50) DEFAULT NULL COMMENT '账目类型',
  `fc_sort` varchar(50) DEFAULT NULL COMMENT '收支类别',
  `fc_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COMMENT='收支分类管理表(ymy)';

/*Data for the table `finance_classify` */

insert  into `finance_classify`(`id`,`fc_type`,`fc_sort`,`fc_remark`) values 
(1,'其他支出','支出','其他支出'),
(2,'燃气费\r\n','支出','燃气费\r\n'),
(3,'员工工资','支出','员工工资'),
(4,'其他收入','收入','其他收入'),
(5,'通讯费','支出','通讯费'),
(6,'电费','支出','电费'),
(7,'水费','支出','水费'),
(8,'修理费','支出','修理费'),
(30,'邮费','支出','邮费'),
(69,'投资商的投资','收入','投资商的投资');

/*Table structure for table `finance_order` */

DROP TABLE IF EXISTS `finance_order`;

CREATE TABLE `finance_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fo_num_list` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `fo_time` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `fo_money` double DEFAULT NULL COMMENT '金额',
  `fo_account` varchar(50) DEFAULT NULL COMMENT '收入账户',
  `fo_person` varchar(50) DEFAULT NULL COMMENT '经手人',
  `fo_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `fo_image` varchar(50) DEFAULT NULL COMMENT '图片附件',
  `fo_flag` varchar(50) DEFAULT NULL COMMENT '0代表日常支出1代表日常收入',
  `fc_id` int(11) DEFAULT NULL COMMENT '账目类型id',
  PRIMARY KEY (`id`),
  KEY `FK_order_classify` (`fc_id`),
  CONSTRAINT `FK_order_classify` FOREIGN KEY (`fc_id`) REFERENCES `finance_classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='收支订单管理表(ymy)';

/*Data for the table `finance_order` */

insert  into `finance_order`(`id`,`fo_num_list`,`fo_time`,`fo_money`,`fo_account`,`fo_person`,`fo_remark`,`fo_image`,`fo_flag`,`fc_id`) values 
(1,'SZ20190104003','2019-01-04',33,'现金','老板','收入',' ','收入',4),
(2,'SZ20190104002','2019-01-04',1245,'建设银行','老板','收入','','收入',4),
(3,'SZ20190104001','2019-01-04',500,'现金','老板','收入','','收入',4),
(4,'SZ20190104000','2019-01-04',132,'现金','老板','收入','','收入',4),
(5,'SZ20190104004','2019-01-04',110,'现金','老板','支出','','支出',6),
(6,'SZ20190104005','2019-01-04',65,'现金','老板','支出','','支出',7),
(7,'SZ20190104006','2019-01-04',600,'建设银行','老板','支出','','支出',5),
(10,'SZ201901160010','2019-01-16',25346,'现金','老板','sdfgf','','支出',3),
(11,'SZ201901160011','2019-01-16',658,'现金','财务','hghgdgh','','支出',2),
(14,'SZ201901170014','2019-01-17',423,'现金','销售','通讯费','','支出',3),
(20,'SZ201901170020','2019-01-17',4353,'现金','老板','支出','','支出',1),
(21,'SZ201901180021','2019-01-18',56,'建设银行','老板','电费啊','','支出',2),
(26,'SZ201901180026','2019-01-18',34664,'现金','老板','支出','','支出',1),
(27,'SZ201901180027','2019-01-18',345,'现金','老板','收入','','收入',4),
(28,'SZ201901180028','2019-01-18',222,'现金','老板','试一次','','收入',4),
(36,'SZ201901220036','2019-01-22',20,'现金','老板','','','收入',4),
(37,'SZ201901220037','2019-01-22',643,'现金','老板','','','收入',4),
(38,'SZ201901220038','2019-01-22',43,'现金','老板','','','收入',4),
(39,'SZ201901220039','2019-01-22',4325,'现金','老板','','','支出',1);

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
(1,'KH20170725004','零售客户','李先生','13234562234',0,0,335,10,0,-345),
(2,'KH20190105000','云和数据','刘女士','15745676654',0,0,1030,20,0,-1050),
(3,'KH20190105001','盈云公司','胡女士','15745676654',0,0,234,11,0,-245),
(4,'KH20190105002','青云湖','张先生','13234562234',5400,0,200,300,0,4900),
(5,'KH20190105003','智慧商贸','朱女士','13234562234',10400,0,719,81,0,9600);

/*Table structure for table `fund_client_debt_detail` */

DROP TABLE IF EXISTS `fund_client_debt_detail`;

CREATE TABLE `fund_client_debt_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fcdd_date` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `fcdd_fcd_name` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `fcdd_num_list` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `fcdd_person` varchar(50) DEFAULT NULL COMMENT '经手人',
  `fcdd_type` varchar(50) DEFAULT NULL COMMENT '业务类型',
  `fcdd_begin_debt` double DEFAULT '0' COMMENT '原单欠款',
  `fcdd_back_debt` double DEFAULT '0' COMMENT '收款',
  `fcdd_discount` double DEFAULT '0' COMMENT '优惠',
  `fcdd_account` varchar(50) DEFAULT NULL COMMENT '结算账户',
  `fcdd_receivable` double DEFAULT '0' COMMENT '应收欠款',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='欠款详细表';

/*Data for the table `fund_client_debt_detail` */

insert  into `fund_client_debt_detail`(`id`,`fcdd_date`,`fcdd_fcd_name`,`fcdd_num_list`,`fcdd_person`,`fcdd_type`,`fcdd_begin_debt`,`fcdd_back_debt`,`fcdd_discount`,`fcdd_account`,`fcdd_receivable`) values 
(1,'2019-01-22','南瞻部洲','SKD20190122005','老板','收回欠款',0,40,0,'现金',-40),
(2,'2019-01-22','智慧商贸','SKD20190122004','老板','收回欠款',0,20,0,'现金',-20),
(3,'2019-01-22','云和数据','SKD20190122003','老板','收回欠款',0,10,0,'现金',-10),
(4,'2019-01-22','盈云公司','SKD20190122002','老板','收回欠款',0,123,0,'现金',-123),
(5,'2019-01-22','零售客户','SKD20190122001','老板','收回欠款',0,235,0,'现金',-235),
(6,'2019-01-22','青云湖','SKD20190122006','老板','期初欠款',5400,0,0,'现金',5400),
(7,'2019-01-22','智慧商贸','SKD20190122007','老板','期初欠款',10000,0,0,'现金',10000),
(8,'2019-01-22','智慧商贸','SKD20190122008','老板','销售商品',400,0,0,'现金',400),
(9,'2019-01-22','青云湖','SKD20190122009','老板','收回欠款',0,100,300,'现金',-400),
(10,'2019-01-22','智慧商贸','SKD201901220010','老板','收回欠款',0,300,80,'现金',-380),
(11,'2019-01-22','智慧商贸','SKD201901220011','老板','收回欠款',0,99,1,'现金',-100),
(18,'2019-01-22','智慧商贸','SKD201901220012','老板','收回欠款',0,100,0,'现金',-100),
(19,'2019-01-22','零售客户','SKD201901220019','老板','收回欠款',0,100,10,'现金',-110),
(20,'2019-01-22','云和数据','SKD201901220020','老板','收回欠款',0,1020,20,'现金',-1040),
(21,'2019-01-22','盈云公司','SKD201901220021','老板','收回欠款',0,111,11,'现金',-122),
(22,'2019-01-22','青云湖','SKD201901220022','老板','收回欠款',0,100,0,'现金',-100),
(23,'2019-01-23','智慧商贸','SKD201901230023','老板','收回欠款',0,200,0,'现金',-200),
(25,'2019-01-23','恰恰','FKD201901230025','老板','进货商品',0,200,10,'现金',-210),
(26,'2019-01-23','恰恰','FKD201901230026','老板','进货付款',180000,0,0,'现金',180000),
(27,'2019-01-23','慧慧便利店','FKD201901230027','老板','进货商品',0,100,0,'现金',-100),
(28,'2019-01-23','三只松鼠','FKD201901230028','老板','进货商品',0,3454,0,'现金',-3454),
(29,'2019-01-23','慧慧便利店','FKD201901230029','老板','进货商品',0,23,0,'现金',-23),
(30,'2019-01-23','恰恰','FKD201901230030','老板','进货商品',0,10,0,'现金',-10);

/*Table structure for table `fund_provider_debt` */

DROP TABLE IF EXISTS `fund_provider_debt`;

CREATE TABLE `fund_provider_debt` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fpd_num_list` varchar(50) DEFAULT NULL COMMENT '供应商编号',
  `fpd_name` varchar(50) DEFAULT NULL COMMENT '供应商名称',
  `fpd_linkman` varchar(50) DEFAULT NULL COMMENT '联系人',
  `fpd_telephone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `fpd_begin_debt` double DEFAULT NULL COMMENT '期初欠款',
  `fpd_add_debt` double DEFAULT NULL COMMENT '增加应付欠款',
  `fpd_pay_debt` double DEFAULT '0' COMMENT '支付欠款',
  `fpd_discount` double DEFAULT NULL COMMENT '优惠欠款',
  `fpd_offset_deb` double DEFAULT NULL COMMENT '核销欠款',
  `fpd_receivable` double DEFAULT NULL COMMENT '应付欠款',
  `fpd_person` varchar(50) DEFAULT NULL COMMENT '经手人',
  `fpd_time` varchar(50) DEFAULT NULL COMMENT '付款时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='供应商应付欠款表(ymy)';

/*Data for the table `fund_provider_debt` */

insert  into `fund_provider_debt`(`id`,`fpd_num_list`,`fpd_name`,`fpd_linkman`,`fpd_telephone`,`fpd_begin_debt`,`fpd_add_debt`,`fpd_pay_debt`,`fpd_discount`,`fpd_offset_deb`,`fpd_receivable`,`fpd_person`,`fpd_time`) values 
(1,'	\r\nGYS20170724006','慧慧便利店','李老板','15738358823',0,234,NULL,0,0,-123,'老板','2019.01.15'),
(2,'GYS20170724003','恰恰','王老板','13133602876',180000,435,NULL,10,0,179780,'财务','2019.01.15'),
(3,'GYS20170724007','三只松鼠','胡女士','18338261765',0,4656,NULL,0,0,-3454,'老板','2019.01.15');

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
  `mp_remarks` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='商品套餐';

/*Data for the table `merchandise_package` */

insert  into `merchandise_package`(`id`,`mp_package_number`,`mp_package_name`,`mp_package_commodity`,`mp_remarks`) values 
(1,'000000','套餐1','苹果栗子',NULL),
(2,'111111','套餐2','衣服帽子',NULL),
(3,'222222','套餐3','鱼肉',NULL),
(4,'333333','套餐4','电脑',NULL),
(5,'444444','套餐5','手机',NULL),
(6,'555555','套餐6','行李箱',NULL),
(7,'666666','套餐7','土豆',NULL),
(8,'777777','套餐8','肌肉',NULL),
(9,'888888','套餐9','书包',NULL),
(10,'999999','套餐10','日记本',NULL),
(11,'121212','套餐11','电饭煲',NULL),
(12,'131313','套餐12','牛奶',NULL),
(13,'141414','套餐13','面包',NULL),
(14,'151515','套餐14','饮料',NULL);

/*Table structure for table `num_rule` */

DROP TABLE IF EXISTS `num_rule`;

CREATE TABLE `num_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号类型',
  `num_web` varchar(255) DEFAULT NULL COMMENT '网页版编号规则',
  `num_prefix` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '前缀',
  `num_digit` int(12) NOT NULL COMMENT '编号位数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='单号规则';

/*Data for the table `num_rule` */

insert  into `num_rule`(`id`,`num_type`,`num_web`,`num_prefix`,`num_digit`) values 
(1,'收款单编号','SKD{YYYY}{MM}{DD}{##}','SKD',0),
(2,'盘点单编号','PD{YYYY}{MM}{DD}{##}','PD',0),
(3,'销售订单编号','XDD{YYYY}{MM}{DD}{##}\r\n','XDD',0),
(4,'出库单编号','CKD{YYYY}{MM}{DD}{##}','CKD',0),
(5,'进货单编号','JHD{YYYY}{MM}{DD}{##}','JHD',0),
(6,'入库单编号','RKD{YYYY}{MM}{DD}{##}','RKD',0),
(7,'销售单编号','XSD{YYYY}{MM}{DD}{##}','XSD',0),
(8,'商品编号','SP{YYYY}{MM}{DD}{##}','SP',0);

/*Table structure for table `order_connect_comm` */

DROP TABLE IF EXISTS `order_connect_comm`;

CREATE TABLE `order_connect_comm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` int(11) DEFAULT NULL COMMENT '销售订单历史订单号',
  `sell_order_num` int(11) DEFAULT NULL COMMENT '销售历史订单号',
  `cl_id` int(11) DEFAULT NULL COMMENT '关联商品id',
  `order_count` int(11) DEFAULT NULL COMMENT '该商品的数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='单号与商品的关联表';

/*Data for the table `order_connect_comm` */

insert  into `order_connect_comm`(`id`,`order_num`,`sell_order_num`,`cl_id`,`order_count`) values 
(1,1,NULL,5,4),
(2,1,NULL,35,4),
(3,1,NULL,4,4),
(4,NULL,1,5,3),
(5,NULL,1,48,7);

/*Table structure for table `package_commodity` */

DROP TABLE IF EXISTS `package_commodity`;

CREATE TABLE `package_commodity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `mp_id` int(15) DEFAULT NULL COMMENT '商品套餐ID',
  `cl_id` int(15) DEFAULT NULL COMMENT '商品列表ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品套餐和商品关联表';

/*Data for the table `package_commodity` */

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ch_id` int(8) DEFAULT NULL COMMENT '角色ID',
  `pe_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色的权限表';

/*Data for the table `permission` */

insert  into `permission`(`id`,`ch_id`,`pe_name`) values 
(1,1,'activitymanagement'),
(2,1,'basicdata'),
(3,1,'billmanagement'),
(4,1,'cargomanagement'),
(5,1,'customermanagement'),
(6,1,'reportanalysis'),
(7,1,'systemsetup'),
(8,23,'activitymanagement');

/*Table structure for table `property` */

DROP TABLE IF EXISTS `property`;

CREATE TABLE `property` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pr_attributevalue` varchar(255) DEFAULT NULL COMMENT '品牌',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='属性设置';

/*Data for the table `property` */

insert  into `property`(`id`,`pr_attributevalue`) values 
(1,'品牌'),
(2,'产地'),
(3,'自定义属性'),
(4,'自定义属性'),
(5,'自定义属性');

/*Table structure for table `propertyval` */

DROP TABLE IF EXISTS `propertyval`;

CREATE TABLE `propertyval` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `property_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '属性值',
  `pnid` int(255) DEFAULT NULL COMMENT '属性名id',
  PRIMARY KEY (`id`),
  KEY `propertyziyong` (`pnid`),
  CONSTRAINT `propertyziyong` FOREIGN KEY (`pnid`) REFERENCES `property` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='属性值';

/*Data for the table `propertyval` */

insert  into `propertyval`(`id`,`property_value`,`pnid`) values 
(1,'青岛',1),
(2,'海尔',1),
(3,'中国',2),
(4,'日本',2);

/*Table structure for table `pur_comm` */

DROP TABLE IF EXISTS `pur_comm`;

CREATE TABLE `pur_comm` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pu_id` int(8) DEFAULT NULL COMMENT '销售单id',
  `com_id` int(8) DEFAULT NULL COMMENT '商品id',
  `puh_id` int(8) DEFAULT NULL COMMENT '进货历史id',
  `prh_id` int(8) DEFAULT NULL COMMENT '进货退货历史id',
  `pc_geshu` int(8) DEFAULT NULL COMMENT '数量',
  `warhoure_id` int(11) DEFAULT NULL COMMENT '入库单id',
  PRIMARY KEY (`id`),
  KEY `ck_pur_pc` (`pu_id`),
  KEY `ck_co_pc` (`com_id`),
  CONSTRAINT `ck_co_pc` FOREIGN KEY (`com_id`) REFERENCES `commodity_list` (`id`),
  CONSTRAINT `ck_pur_pc` FOREIGN KEY (`pu_id`) REFERENCES `purchase_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `pur_comm` */

insert  into `pur_comm`(`id`,`pu_id`,`com_id`,`puh_id`,`prh_id`,`pc_geshu`,`warhoure_id`) values 
(1,3,4,5,NULL,5,NULL),
(2,3,5,5,NULL,3,NULL),
(3,3,35,5,NULL,2,NULL),
(4,NULL,50,5,NULL,3,NULL),
(5,NULL,51,5,NULL,3,NULL),
(6,NULL,52,5,NULL,5,NULL),
(7,NULL,4,NULL,4,4,NULL),
(8,NULL,35,NULL,4,21,NULL),
(9,NULL,5,NULL,4,1,NULL),
(10,NULL,51,NULL,4,2,NULL),
(11,NULL,4,NULL,NULL,2,1),
(12,NULL,50,NULL,NULL,1,1),
(13,NULL,52,NULL,NULL,5,1),
(14,NULL,4,NULL,NULL,2,2),
(15,NULL,5,NULL,NULL,2,2),
(16,NULL,52,NULL,NULL,2,2),
(17,36,4,NULL,NULL,10,NULL),
(18,36,35,NULL,NULL,10,NULL),
(20,37,4,NULL,NULL,1,NULL),
(21,37,50,NULL,NULL,1,NULL),
(22,37,51,NULL,NULL,1,NULL),
(23,37,52,NULL,NULL,1,NULL),
(24,38,4,NULL,NULL,2,NULL),
(25,38,50,NULL,NULL,2,NULL),
(26,38,51,NULL,NULL,2,NULL);

/*Table structure for table `purchase_history` */

DROP TABLE IF EXISTS `purchase_history`;

CREATE TABLE `purchase_history` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `ph_date` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `ph_number` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `ph_supname` varchar(51) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '供应商名称',
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='进货历史';

/*Data for the table `purchase_history` */

insert  into `purchase_history`(`id`,`ph_date`,`ph_number`,`ph_supname`,`ph_clname`,`ph_quantity`,`ph_amount_payable`,`ph_amount_paid`,`ph_warehouse`,`ph_bill`,`ph_jindate`,`ph_maney_hu`,`ph_experienced_person`,`ph_single_person`,`ph_other_expenses`,`ph_warehousing_status`,`ph_remarks`) values 
(5,'2019-01-04','YJDD201901151530','供应商1','超级多',10,49.99,49.99,'默认仓库','1.jpg','2019-01-15 17:04:21','现金','老板1','老板','1','未入库','这是一个备注');

/*Table structure for table `purchase_order` */

DROP TABLE IF EXISTS `purchase_order`;

CREATE TABLE `purchase_order` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `po_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务日期',
  `po_number` varchar(255) DEFAULT NULL COMMENT '单据编号',
  `po_state` varchar(50) DEFAULT NULL COMMENT '处理状态',
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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='进货订单历史';

/*Data for the table `purchase_order` */

insert  into `purchase_order`(`id`,`po_date`,`po_number`,`po_state`,`po_auditor`,`po_sup_name`,`po_cl_name`,`po_quantity_of_purchase`,`po_ying_money`,`po_bill`,`po_experienced_person`,`po_single_person`,`po_remarks`,`po_date_order`) values 
(3,'2019-01-04','JDD201901151524','未审核','老板1','供应商1','脉动',10,49.99,'1.jpg','老板1','老板1','这是一个备注','2019-04-01'),
(36,'2019-01-23 17:26:35','ADD20190123172618','未审核','老板','慧慧便利店','脉动,1241',10,1380.00,NULL,'老板','老板','默认无备注','2019-01-23 17:26:35'),
(37,'2019-01-23 19:44:32','ADD20190123194420','未审核','老板','慧慧便利店','脉动,衣服,零食,特殊',1,163.00,'无','老板','老板','这是个备注','2019-01-23 19:44:32'),
(38,'2019-01-23 20:01:30','ADD20190123200125','未审核','老板','慧慧便利店','脉动,衣服,零食',2,78.00,'无','老板','老板','这是个备注','2019-01-23 20:01:30');

/*Table structure for table `purchase_report_com` */

DROP TABLE IF EXISTS `purchase_report_com`;

CREATE TABLE `purchase_report_com` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pr_com_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '商品编号',
  `pr_com_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '商品名称',
  `pr_com_spec` varchar(25) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '规格',
  `pr_com_unit` varchar(25) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '单位',
  `pr_quantity` int(100) DEFAULT NULL COMMENT '进货量',
  `pr_amount` int(100) DEFAULT NULL COMMENT '进货额',
  `pr_docu_quantity` int(100) DEFAULT NULL COMMENT '进货开单量',
  `pr_docu_amount` int(100) DEFAULT NULL COMMENT '进货开单金额',
  `pr_return_quantity` int(100) DEFAULT NULL COMMENT '退货量',
  `pr_return_amount` int(100) DEFAULT NULL COMMENT '退货额',
  `pr_war_num` varchar(255) DEFAULT NULL COMMENT '仓库编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `purchase_report_com` */

/*Table structure for table `purchase_report_docu` */

DROP TABLE IF EXISTS `purchase_report_docu`;

CREATE TABLE `purchase_report_docu` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `pr_docu_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '日期',
  `pr_docu_quantity` int(8) DEFAULT NULL COMMENT '进货笔数',
  `pr_docu_amount` double(10,2) DEFAULT NULL COMMENT '进货额',
  `pr_docu_war` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '仓库编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

/*Data for the table `purchase_report_docu` */

/*Table structure for table `purchase_report_supp` */

DROP TABLE IF EXISTS `purchase_report_supp`;

CREATE TABLE `purchase_report_supp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pr_supp_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '供应商编号',
  `pr_supp_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '供应商名称',
  `pr_supp_quantity` int(8) DEFAULT NULL COMMENT '进货笔数',
  `pr_supp_amount` double(10,2) DEFAULT NULL COMMENT '进货额',
  `pr_supp_war` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '仓库编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

/*Data for the table `purchase_report_supp` */

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
  `prh_other_expenses` double(10,2) DEFAULT NULL COMMENT '其他费用',
  `prh_outgoing_state` varchar(50) DEFAULT NULL COMMENT '出库状态',
  `prh_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='进货退货历史';

/*Data for the table `purchase_return_history` */

insert  into `purchase_return_history`(`id`,`prh_date`,`prh_number`,`prh_pur_order`,`prh_supname`,`prh_returnsup`,`prh_total_amount`,`prh_refund_amount`,`prh_outgoing_warehouse`,`prh_bill`,`prh_jindate`,`prh_maney_hu`,`prh_experienced_person`,`prh_single_person`,`prh_other_expenses`,`prh_outgoing_state`,`prh_remarks`) values 
(4,'213123','123123',NULL,'123123213',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

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
  `ra_income` double DEFAULT '0' COMMENT '收入',
  `ra_outcome` double DEFAULT '0' COMMENT '支出',
  `ra_current_balance` double DEFAULT NULL COMMENT '当前余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='资金流水表(ymy)';

/*Data for the table `running_accounts` */

insert  into `running_accounts`(`id`,`ra_num_list`,`ra_time`,`ra_company_name`,`ra_project_name`,`ra_account`,`ra_person`,`ra_income`,`ra_outcome`,`ra_current_balance`) values 
(1,'XSD20170725004','2017-07-27','盈云公司','销售收入','现金','财务',708,0,-3595.5),
(2,'XSD20170725009','2017-07-25','邓娟娟','销售收入','现金','老板',766,0,-4303.5),
(3,'XSD20170725003','2017-07-25','刘琳衡山','销售收入','现金','老板',478,0,-5069.5),
(4,'XSD20170725001','2017-07-25','张云雷','销售收入','现金','老板',328,0,-5547.5),
(5,'XSD20170725000','2017-07-25','方鑫','销售收入','现金','销售',315,0,-5875.5),
(6,'XSD20170725002','2017-07-24','智慧商贸','销售收入','现金','老板',385,0,-6190.5),
(7,'JHD20170725004','2017-07-21','广发商行','进货支出','现金','老板',0,5403.5,-6575.5);

/*Table structure for table `sale_report_client` */

DROP TABLE IF EXISTS `sale_report_client`;

CREATE TABLE `sale_report_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sr_client_number` varchar(255) DEFAULT NULL,
  `sr_client_name` varchar(255) DEFAULT NULL,
  `sr_quantity` int(11) DEFAULT NULL,
  `sr_amount` double(10,2) DEFAULT NULL,
  `sr_profit` double(10,2) DEFAULT NULL,
  `sr_discount` double(10,2) DEFAULT NULL,
  `sr_client_war` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sale_report_client` */

/*Table structure for table `sale_report_com` */

DROP TABLE IF EXISTS `sale_report_com`;

CREATE TABLE `sale_report_com` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sr_com_number` varchar(255) DEFAULT NULL,
  `sr_com_name` varchar(255) DEFAULT NULL,
  `sr_com_spec` varchar(25) DEFAULT NULL,
  `sr_com_unit` varchar(25) DEFAULT NULL,
  `sr_docu_quantity` int(8) DEFAULT NULL,
  `sr_docu_amount` double(10,2) DEFAULT NULL,
  `sr_avg_price` double(10,2) DEFAULT NULL,
  `sr_com_war` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sale_report_com` */

/*Table structure for table `sale_report_docu` */

DROP TABLE IF EXISTS `sale_report_docu`;

CREATE TABLE `sale_report_docu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sr_data` varchar(50) DEFAULT NULL,
  `sr_do_number` int(11) DEFAULT NULL,
  `sr_do_amount` double(10,2) DEFAULT NULL,
  `sr_do_profit` double(10,2) DEFAULT NULL,
  `sr_do_quantity` double(10,2) DEFAULT NULL,
  `sr_do_war` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sale_report_docu` */

/*Table structure for table `sales_history` */

DROP TABLE IF EXISTS `sales_history`;

CREATE TABLE `sales_history` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `sh_date` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `sh_number` varchar(50) DEFAULT NULL COMMENT '单据编号',
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='销售历史';

/*Data for the table `sales_history` */

insert  into `sales_history`(`id`,`sh_date`,`sh_number`,`sh_connect`,`sh_client`,`sh_sell_goods`,`sh_sell_count`,`sh_discount`,`sh_mins`,`sh_profit`,`sh_money`,`sh_true_money`,`sh_house`,`sh_bills`,`sh_create_date`,`sh_give_date`,`sh_other`,`sh_end_comm`,`sh_hander`,`sh_maker`,`sh_type`,`sh_status`,`sh_remark`) values 
(1,'2019-1-9','aaa',NULL,'杨1',NULL,0.00,0.00,0.00,0.00,0.00,'0','0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,NULL,'abc',NULL,'yang1',NULL,0.00,0.00,0.00,0.00,0.00,'0','本地仓库','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(4,'2019-1-9','aaa',NULL,'杨1',NULL,0.00,0.00,0.00,0.00,0.00,'0','0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(5,'2019-1-9','aaa',NULL,'杨1',NULL,0.00,0.00,0.00,0.00,0.00,'0','0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(6,'2019-1-9','aaa',NULL,'杨1',NULL,0.00,0.00,0.00,0.00,0.00,'0','0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

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
  `so_discount` double(10,2) DEFAULT NULL COMMENT '折扣金额',
  `so_money` double(10,2) DEFAULT NULL COMMENT '总计金额',
  `so_earnest` double(7,2) DEFAULT NULL COMMENT '定金',
  `so_bills` varchar(50) DEFAULT NULL COMMENT '纸质单据',
  `so_bill_date` varchar(50) DEFAULT NULL COMMENT '制单日期',
  `so_sell_count` int(11) DEFAULT NULL COMMENT '未转销售数量',
  `so_devlier_date` varchar(50) DEFAULT NULL COMMENT '送货日期',
  `so_hander` varchar(50) DEFAULT NULL COMMENT '经手人',
  `so_maker` varchar(50) DEFAULT NULL COMMENT '制单人',
  `so_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='销售订单历史';

/*Data for the table `sales_order_history` */

insert  into `sales_order_history`(`id`,`so_date`,`so_order_num`,`so_status`,`so_auditor`,`so_client`,`so_order_comm`,`so_order_count`,`so_discount`,`so_money`,`so_earnest`,`so_bills`,`so_bill_date`,`so_sell_count`,`so_devlier_date`,`so_hander`,`so_maker`,`so_remark`) values 
(1,'2017-07-25','XDD20170725001','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(2,'2017-07-25','XDD20170725002','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(3,'2017-07-25','XDD20170725003','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(5,'2017-07-25','XDD20170725005','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(6,'2017-07-25','XDD20170725006','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(7,'2017-07-25','XDD20170725007','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(9,'2017-07-25','XDD20170725009','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(10,'2017-07-25','XDD20170725010','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(11,'2017-07-25','XDD20170725011','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(12,'2017-07-25','XDD20170725012','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(13,'2017-07-25','XDD20170725013','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(14,'2017-07-25','XDD20170725014','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(15,'2017-07-25','XDD20170725015','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL);

/*Table structure for table `sales_return_history` */

DROP TABLE IF EXISTS `sales_return_history`;

CREATE TABLE `sales_return_history` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `srh_date` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `srh_number` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `srh_con_number` varchar(50) DEFAULT NULL COMMENT '关联销售单号',
  `srh_client` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `srh_goods` varchar(50) DEFAULT NULL COMMENT '退货商品',
  `srh_money` double(10,2) DEFAULT '0.00' COMMENT '总计金额',
  `srh_ret_money` double(10,2) DEFAULT '0.00' COMMENT '实退金额',
  `srh_house` varchar(50) DEFAULT NULL COMMENT '入库仓库',
  `srh_status` varchar(50) DEFAULT NULL COMMENT '入库状态',
  `srh_bills` varchar(50) DEFAULT NULL COMMENT '纸质单据',
  `srh_create_date` varchar(50) DEFAULT NULL COMMENT '制单日期',
  `srh_other` varchar(50) DEFAULT NULL COMMENT '其他费用',
  `srh_end_comm` varchar(50) DEFAULT NULL COMMENT '结算账户',
  `srh_hander` varchar(50) DEFAULT NULL COMMENT '经手人',
  `srh_maker` varchar(50) DEFAULT NULL COMMENT '制单人',
  `srh_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='销售退货历史';

/*Data for the table `sales_return_history` */

insert  into `sales_return_history`(`id`,`srh_date`,`srh_number`,`srh_con_number`,`srh_client`,`srh_goods`,`srh_money`,`srh_ret_money`,`srh_house`,`srh_status`,`srh_bills`,`srh_create_date`,`srh_other`,`srh_end_comm`,`srh_hander`,`srh_maker`,`srh_remark`) values 
(1,'2019-1-23 10:20:59','55',NULL,'云和','吃的',200.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,'2019-1-23 10:20:59','54',NULL,'云和','吃的',200.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(3,'2019-1-23 10:20:59','527',NULL,'云和','吃的',200.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(4,'2019-1-23 10:20:59','785',NULL,'云和','吃的',200.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(5,'2019-1-23 10:20:59','768',NULL,'云和','吃的',200.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(6,'2019-1-23 10:20:59','4567',NULL,'云和','吃的',200.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(7,'2019-1-23 10:20:59','786/8',NULL,'云和','吃的',200.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(8,'2019-1-23 10:20:59','7868765',NULL,'云和','吃的',200.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(9,'2019-1-23 10:20:59','7866',NULL,'云和','吃的',200.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `settlement_account` */

DROP TABLE IF EXISTS `settlement_account`;

CREATE TABLE `settlement_account` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `sa_name` varchar(25) DEFAULT NULL COMMENT '账户名称',
  `sa_bank` varchar(25) DEFAULT NULL COMMENT '开户银行',
  `sa_balance` double(10,2) DEFAULT NULL COMMENT '账户余额',
  `sa_state` varchar(8) DEFAULT NULL COMMENT '状态（是否启用）',
  `sa_banknumber` varchar(255) DEFAULT NULL COMMENT '银行账号',
  `sa_beginbalance` varchar(255) DEFAULT NULL COMMENT '期初余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='结算帐户';

/*Data for the table `settlement_account` */

insert  into `settlement_account`(`id`,`sa_name`,`sa_bank`,`sa_balance`,`sa_state`,`sa_banknumber`,`sa_beginbalance`) values 
(4,'发送到1223','郑州银行',12.00,'正常','5465476','7657'),
(9,'宋江','中原银行',45.00,'正常','123456789012345678','345'),
(10,'吴用','中国人民银行',1242143.00,'禁用','1243243254435465657','123'),
(12,'公孙胜','中国人民银行',2345.00,'禁用','124324325454565465','123');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='供应商管理';

/*Data for the table `supplier` */

insert  into `supplier`(`id`,`sup_compname`,`sup_number`,`sup_money`,`sup_tele`,`sup_flag`,`sup_linkman`,`sup_conn`,`sup_email`,`sup_remarks`) values 
(4,'三只松鼠','GYS20170724007',8000,'18338261765',1,'胡女士',NULL,NULL,NULL),
(5,'恰恰','GYS20170724003',9900,'13133602876',1,'王老板',NULL,NULL,NULL),
(6,'慧慧便利店','GYS20170724006',55000,'15738358823',1,'李老板',NULL,NULL,NULL);

/*Table structure for table `template_commodity` */

DROP TABLE IF EXISTS `template_commodity`;

CREATE TABLE `template_commodity` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `ct_id` int(9) DEFAULT NULL COMMENT '商品模板ID',
  `cl_id` int(11) DEFAULT NULL COMMENT '商品列表ID',
  `tc_number` int(8) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='商品模板和商品关联表';

/*Data for the table `template_commodity` */

insert  into `template_commodity`(`id`,`ct_id`,`cl_id`,`tc_number`) values 
(1,2,123,NULL),
(2,9,1,NULL),
(3,9,2,NULL),
(4,9,3,NULL),
(5,10,1,NULL),
(6,10,2,NULL),
(7,10,3,NULL);

/*Table structure for table `template_details` */

DROP TABLE IF EXISTS `template_details`;

CREATE TABLE `template_details` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `td_name` varchar(25) DEFAULT NULL COMMENT '商品名称',
  `td_number` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `td_property` varchar(25) DEFAULT NULL COMMENT '商品属性',
  `td_sum` int(8) DEFAULT NULL COMMENT '数量',
  `td_company` varchar(25) DEFAULT NULL COMMENT '单位',
  `ct_id` int(8) DEFAULT NULL COMMENT '商品模板id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `template_details` */

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='等待出库';

/*Data for the table `wait_out_warehouse` */

insert  into `wait_out_warehouse`(`id`,`wo_date`,`wo_number`,`wo_type`,`wo_company`,`wo_house`,`wo_goods`,`wo_count`,`wo_create_date`,`wo_hander`,`wo_maker`,`wo_status`) values 
(1,NULL,'001',NULL,'yy',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,NULL,'002',NULL,'xx',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(3,NULL,'003',NULL,'zz',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

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
(1,'001','衣服','大','1件',200,100,20,20,99.80,99.80),
(3,'002','鞋子','大','1双',200,100,20,20,100.00,100.00);

/*Table structure for table `warehouse_management` */

DROP TABLE IF EXISTS `warehouse_management`;

CREATE TABLE `warehouse_management` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `wm_number` varchar(255) DEFAULT NULL COMMENT '编号',
  `wm_name` varchar(25) DEFAULT NULL COMMENT '仓库名称',
  `wm_person` varchar(25) DEFAULT NULL COMMENT '联系人',
  `wm_tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `wm_address` varchar(255) DEFAULT NULL COMMENT '仓库地址',
  `wm_postcode` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `wm_state` int(8) DEFAULT NULL COMMENT '状态',
  `wm_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='仓库管理';

/*Data for the table `warehouse_management` */

insert  into `warehouse_management`(`id`,`wm_number`,`wm_name`,`wm_person`,`wm_tel`,`wm_address`,`wm_postcode`,`wm_state`,`wm_remark`) values 
(1,'006','默认仓库','宋江','123144','郑州','12423145',0,'12434'),
(24,'001','郑州仓','张三','1321321','zhengzhou','451450',1,''),
(25,'002','开封仓','李四','1321322','开封','451451',0,''),
(26,'003','洛阳','王五','1321323','洛阳','145453',1,''),
(27,'004','南阳','刘四','13213214','nanyang','451454',1,'wu'),
(28,'005','安阳','王五','13213215','anyang','2145@qq.com',1,'安阳'),
(29,'005','新郑仓','李新政','1321321','新郑枣庄','245425@qq.com',1,'新郑大仓');

/*Table structure for table `warehouse_receipt` */

DROP TABLE IF EXISTS `warehouse_receipt`;

CREATE TABLE `warehouse_receipt` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `wre_date` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `wre_number` varchar(255) DEFAULT NULL COMMENT '单据编号',
  `wre_type` varchar(50) DEFAULT NULL COMMENT '类型',
  `wre_current_unit` varchar(50) DEFAULT NULL COMMENT '往来单位名称',
  `wre_warehost_name` varchar(50) DEFAULT NULL COMMENT '入库仓库',
  `wre_storage` varchar(255) DEFAULT NULL COMMENT '入库商品',
  `wre_scheduled_receipt` int(8) DEFAULT NULL COMMENT '入库量',
  `wre_date_order` varchar(50) DEFAULT NULL COMMENT '制单日期',
  `wre_single_person` varchar(50) DEFAULT NULL COMMENT '制单人',
  `wre_experienced_person` varchar(50) DEFAULT NULL COMMENT '经手人',
  `wre_state` varchar(50) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `warehouse_receipt` */

insert  into `warehouse_receipt`(`id`,`wre_date`,`wre_number`,`wre_type`,`wre_current_unit`,`wre_warehost_name`,`wre_storage`,`wre_scheduled_receipt`,`wre_date_order`,`wre_single_person`,`wre_experienced_person`,`wre_state`) values 
(1,'2019-01-15','YJDD201901151530','进货','360超市','默认仓库','大白兔奶糖',100,'2019-01-15','老板','老板','未入库'),
(2,'2019-01-17','YJDD201901171617','进货','360超市','默认仓库','大白兔',100,'2019-01-15','老板','老板','全部入库');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
