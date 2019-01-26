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
  `at_out_account` varchar(50) DEFAULT '0' COMMENT '转出账户',
  `at_out_time` varchar(50) DEFAULT '0' COMMENT '转出日期',
  `at_into_account` varchar(50) DEFAULT '0' COMMENT '转入账户',
  `at_into_time` varchar(50) DEFAULT '0' COMMENT '到账日期',
  `at_money` double DEFAULT '0' COMMENT '金额',
  `at_charge` double DEFAULT '0' COMMENT '手续费',
  `at_charge_person` varchar(50) DEFAULT '0' COMMENT '手续费支付方',
  `at_person` varchar(50) DEFAULT '0' COMMENT '经手人',
  `at_remark` varchar(50) DEFAULT '0' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='账户转账表(ymy)';

/*Data for the table `account_transfer` */

insert  into `account_transfer`(`id`,`at_out_account`,`at_out_time`,`at_into_account`,`at_into_time`,`at_money`,`at_charge`,`at_charge_person`,`at_person`,`at_remark`) values 
(25,'现金','2019-01-24','建设银行','2019-01-24',120,1,'转入账户支付','老板','0'),
(29,'建设银行','2019-01-23','建设银行','2019-01-24',200,3,'转入账户支付','老板','0');

/*Table structure for table `chara_manger` */

DROP TABLE IF EXISTS `chara_manger`;

CREATE TABLE `chara_manger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ch_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `ch_detail` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='角色管理';

/*Data for the table `chara_manger` */

insert  into `chara_manger`(`id`,`ch_name`,`ch_detail`) values 
(1,'管理组','唯我独尊'),
(2,'财务组','财务组成员能进行，管账，财务相关的所有业务'),
(3,'仓管组','仓管组成员能进行进货、进货退货、借入借出、盘点、组装拆卸、库存调拨及查询操作。同时能查看与上述业务相关的报表。'),
(4,'销售组','销售组成员能进行销售、销售退货、借出及库存查询操作。'),
(24,'天启组','天之子'),
(25,'宽宽组','阿宽'),
(26,'葵葵组','葵葵');

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
  `id` int(25) NOT NULL AUTO_INCREMENT COMMENT '模板id',
  `ct_template_number` varchar(50) DEFAULT NULL COMMENT '模板编号',
  `ct_tytemplate_name` varchar(25) DEFAULT NULL COMMENT '模板名称',
  `ct_templategoods` varchar(255) DEFAULT NULL COMMENT '模板商品',
  `ct_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='商品模板';

/*Data for the table `commodi_tytemplate` */

insert  into `commodi_tytemplate`(`id`,`ct_template_number`,`ct_tytemplate_name`,`ct_templategoods`,`ct_remarks`) values 
(1,'11111','第一','脉动,饮料11,',NULL),
(2,'22222','第二','脉动,饮料11,1241,',NULL),
(3,'33333','第三','脉动,饮料11,',NULL),
(5,'444444','第四','脉动,饮料11,1241,',NULL),
(6,'6644','伫','脉动,饮料11,',NULL),
(7,'578465478','u热议','脉动,饮料11,',NULL),
(8,'879879879','发的是通过','脉动,饮料11,1241,衣服,零食,特殊,',NULL),
(9,'5486465','大送飞吻','脉动,饮料11,1241,',NULL),
(10,'5486465','大送飞吻','脉动,饮料11,1241,',NULL),
(11,'5486465','大送飞吻','脉动,饮料11,1241,',NULL),
(12,'2342352','谁打他阿瓦色鬼','脉动,',NULL),
(13,'452不65','的撒发生大概','饮料11,1241,',NULL),
(14,'5471548','hrtetyui','脉动,饮料11,',NULL),
(15,'456123','haha','脉动,饮料11,羽绒衣服,',NULL),
(16,'4656123','哇偶','脉动,饮料11,羽绒衣服,',NULL),
(17,'159842','真好','脉动,饮料11,',NULL),
(18,'5415615','u塘沽头发','脉动,饮料11,',NULL),
(19,'454','很充分的','饮料11,羽绒衣服,',NULL),
(20,'564655645','哈飞开始了','脉动,饮料11,',NULL),
(22,'4646','如果饭','脉动,饮料11,',NULL),
(23,'541489','IOS大匿','脉动,饮料11,羽绒衣服,',NULL),
(24,'546','羽绒度','脉动,饮料11,羽绒衣服,',NULL),
(26,'45468548','虽然他也会','脉动,饮料11,',NULL),
(27,'354 ','规范化','脉动,饮料11,',NULL),
(28,'2456845','购房人的一点','脉动,饮料11,',NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品列表';

/*Data for the table `commodity_list` */

insert  into `commodity_list`(`id`,`cl_name`,`cl_unit`,`cl_scan`,`cl_spec`,`cl_pur_price`,`cl_who_price`,`cl_tag_prise`,`cc_id`,`wm_id`,`cl_number`,`pr_id`,`cl_minstock`,`cl_maxstock`,`cl_minlingprice`) values 
(4,'脉动','瓶','12342434','1箱/18瓶','14','325','124',9,26,'124123',3,2,6,'1234'),
(5,'饮料11','只','安抚','19','14','124','124',1,25,'1编辑',3,2,6,'124'),
(35,'羽绒衣服','无','1243','124','124','124','124',5,27,'124',3,124,124,'124'),
(50,'衣服','件','123424','红色短款','13','132','213',1,25,'1243',2,132,133,'214'),
(52,'特殊','无','1243124','红色长款','124','214','123',1,25,'123',2,12,124,'2143'),
(71,'124','包','12432','14231','456','436','124',2,24,'124',4,235,235,'124'),
(73,'辣条','个','124325','小包','15423','1455','1242',5,27,'125234wrew',4,123,450,'2435'),
(74,'面条','公斤','1243254','一箱','214','214','124',3,29,'qwerwqr12423',4,214,345,'24'),
(75,'零食','包','12423432','一包','7','9','12',3,25,'QWERWR12423',4,1243,2000,'10'),
(76,'饮料','箱','2354356','大箱','100','110','120',3,24,'wqrewt12432',4,120,1000,'115'),
(77,'百事可乐','杯','11234545','一杯','34','23','56',3,24,'asdfsaf124324',4,124,465,'23');

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
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='员工管理';

/*Data for the table `employ` */

insert  into `employ`(`id`,`em_username`,`em_password`,`em_realname`,`em_role`,`em_sex`,`em_phone`,`em_email`,`em_status`,`em_repo`,`em_shiro`,`em_sel_invoice`,`em_del_invoice`,`em_sel_user`,`em_address`,`ch_id`) values 
(1,'1','1','老板','管理员','男','18595468090','270066981@qq.com','正常','默认仓库','零售价，最低价','允许','允许','不允许','',1),
(52,'liuyanqi','123456','刘延琦','财务员','男','18236256555','54612344521@qq.com','正常','默认仓库','零售价，进货价，最低价，批发价，成本价','允许','允许','不允许','',2),
(53,'lihengkui','123456','李恒逵','管理员','男','15737738972','45123685412@qq.com','正常','默认仓库','零售价，最低价','允许','允许','不允许','',1),
(68,'yangmingyue','123456','杨明月','财务员','女','15548020356','3652345128@qq.com','正常','默认仓库','零售价，进货价，最低价，批发价，成本价','允许','允许','不允许','',2),
(69,'kuankuan','123456','阿宽','管理员','男','13103877752','5445623584@qq.com','正常','默认仓库','零售价，最低价','允许','允许','不允许','广东省东莞市东莞市',1),
(70,'kuikui','123456','奎奎','销售员','男','13103877752','5628654128@qq.com','正常','默认仓库','零售价，成本价','允许','不允许','不允许','重庆市重庆市辖县城口县',4);

/*Table structure for table `finance_classify` */

DROP TABLE IF EXISTS `finance_classify`;

CREATE TABLE `finance_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fc_type` varchar(50) DEFAULT NULL COMMENT '账目类型',
  `fc_sort` varchar(50) DEFAULT NULL COMMENT '收支类别',
  `fc_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='收支分类管理表(ymy)';

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
(69,'投资商的投资','收入','投资商的投资'),
(74,'话费','支出','');

/*Table structure for table `finance_order` */

DROP TABLE IF EXISTS `finance_order`;

CREATE TABLE `finance_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fo_num_list` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `fo_time` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `fo_money` double DEFAULT '0' COMMENT '金额',
  `fo_account` varchar(50) DEFAULT NULL COMMENT '收入账户',
  `fo_person` varchar(50) DEFAULT NULL COMMENT '经手人',
  `fo_remark` varchar(50) DEFAULT '0' COMMENT '备注',
  `fo_image` varchar(50) DEFAULT '0' COMMENT '图片附件',
  `fo_flag` varchar(50) DEFAULT NULL COMMENT '0代表日常支出1代表日常收入',
  `fc_id` int(11) DEFAULT NULL COMMENT '账目类型id',
  PRIMARY KEY (`id`),
  KEY `FK_order_classify` (`fc_id`),
  CONSTRAINT `FK_order_classify` FOREIGN KEY (`fc_id`) REFERENCES `finance_classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='收支订单管理表(ymy)';

/*Data for the table `finance_order` */

insert  into `finance_order`(`id`,`fo_num_list`,`fo_time`,`fo_money`,`fo_account`,`fo_person`,`fo_remark`,`fo_image`,`fo_flag`,`fc_id`) values 
(43,'SZ201901240043','2019-01-24',100,'现金','老板','满揍','','日常收入',4),
(44,'SZ201901240044','2019-01-24',100,'现金','老板','天啊','','日常收入',4),
(45,'SZ201901240045','2019-01-24',340,'现金','老板','你说说','','日常支出',1),
(46,'SZ201901240046','2019-01-24',230,'现金','老板','ok','','日常支出',1),
(47,'SZ201901240047','2019-01-24',3000,'现金','老板','真香','','日常收入',4),
(48,'SZ201901240048','2019-01-24',1200,'现金','老板','上海','','日常支出',1),
(49,'SZ201901250049','2019-01-25',20,'现金','老板','询问','','日常收入',4),
(52,'SZ201901250052','2019-01-25',11.1,'现金','老板','完美','','日常收入',4),
(53,'SZ201901250053','2019-01-25',10.1,'现金','财务','完美','','日常支出',1);

/*Table structure for table `fund_client_debt` */

DROP TABLE IF EXISTS `fund_client_debt`;

CREATE TABLE `fund_client_debt` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fcd_num_list` varchar(50) DEFAULT NULL COMMENT '客户编号',
  `fcd_name` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `fcd_linkman` varchar(50) DEFAULT NULL COMMENT '联系人',
  `fcd_telephone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `fcd_begin_debt` double DEFAULT '0' COMMENT '期初欠款',
  `fcd_add_debt` double DEFAULT '0' COMMENT '增加应收欠款',
  `fcd_back_debt` double DEFAULT '0' COMMENT '收回欠款',
  `fcd_discount` double DEFAULT '0' COMMENT '优惠',
  `fcd_offset_deb` double DEFAULT '0' COMMENT '核销欠款',
  `fcd_receivable` double DEFAULT '0' COMMENT '应收欠款',
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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='欠款详细表';

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
(30,'2019-01-23','恰恰','FKD201901230030','老板','进货商品',0,10,0,'现金',-10),
(31,'2019-01-24','恰恰','FKD201901240031','老板','进货商品',0,7800,100,'现金',-7900),
(32,'2019-01-24','慧慧便利店','FKD201901240032','老板','进货付款',23000,0,0,'现金',23000),
(33,'2019-01-24','三只松鼠','FKD201901240033','老板','进货付款',9800,0,0,'现金',9800),
(34,'2019-01-24','三只松鼠','FKD201901240034','老板','进货商品',0,100,10,'现金',-110),
(35,'2019-01-24','慧慧便利店','FKD201901240035','老板','进货商品',0,999,1,'现金',-1000),
(36,'2019-01-24','恰恰','FKD201901240036','老板','进货商品',0,340,0,'现金',-340),
(37,'2019-01-25','','FKD201901250037','老板','进货商品',0,20,10,'现金',-30);

/*Table structure for table `fund_provider_debt` */

DROP TABLE IF EXISTS `fund_provider_debt`;

CREATE TABLE `fund_provider_debt` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fpd_num_list` varchar(50) DEFAULT '0' COMMENT '供应商编号',
  `fpd_name` varchar(50) DEFAULT '0' COMMENT '供应商名称',
  `fpd_linkman` varchar(50) DEFAULT '0' COMMENT '联系人',
  `fpd_telephone` varchar(50) DEFAULT '0' COMMENT '联系电话',
  `fpd_begin_debt` double DEFAULT '0' COMMENT '期初欠款',
  `fpd_add_debt` double DEFAULT '0' COMMENT '增加应付欠款',
  `fpd_pay_debt` double DEFAULT '0' COMMENT '支付欠款',
  `fpd_discount` double DEFAULT '0' COMMENT '优惠欠款',
  `fpd_offset_deb` double DEFAULT '0' COMMENT '核销欠款',
  `fpd_receivable` double DEFAULT '0' COMMENT '应付欠款',
  `fpd_person` varchar(50) DEFAULT '0' COMMENT '经手人',
  `fpd_time` varchar(50) DEFAULT '0' COMMENT '付款时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='供应商应付欠款表(ymy)';

/*Data for the table `fund_provider_debt` */

insert  into `fund_provider_debt`(`id`,`fpd_num_list`,`fpd_name`,`fpd_linkman`,`fpd_telephone`,`fpd_begin_debt`,`fpd_add_debt`,`fpd_pay_debt`,`fpd_discount`,`fpd_offset_deb`,`fpd_receivable`,`fpd_person`,`fpd_time`) values 
(1,'	\r\nGYS20170724006','慧慧便利店','李老板','15738358823',23000,234,1122,1,0,21877,'老板','2019.01.15'),
(2,'GYS20170724003','恰恰','王老板','13133602876',180000,435,8350,110,0,171540,'财务','2019.01.15'),
(3,'GYS20170724007','三只松鼠','胡女士','18338261765',9800,4656,3554,10,0,6236,'老板','2019.01.15');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='单号与商品的关联表';

/*Data for the table `order_connect_comm` */

insert  into `order_connect_comm`(`id`,`order_num`,`sell_order_num`,`cl_id`,`order_count`) values 
(1,1,12,51,4),
(2,1,12,50,4),
(3,1,12,4,8),
(4,NULL,1,5,3),
(5,NULL,1,48,7),
(6,22,0,5,45),
(7,23,0,5,5),
(8,23,0,50,6);

/*Table structure for table `package_commodity` */

DROP TABLE IF EXISTS `package_commodity`;

CREATE TABLE `package_commodity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pc_name` varchar(25) DEFAULT NULL COMMENT '商品套餐ID',
  `pc_number` varchar(15) DEFAULT NULL COMMENT '商品列表ID',
  `pc_property` varchar(25) DEFAULT NULL,
  `pc_sum` int(8) DEFAULT NULL,
  `pc_company` varchar(25) DEFAULT NULL,
  `pc_id` int(8) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='属性值';

/*Data for the table `propertyval` */

insert  into `propertyval`(`id`,`property_value`,`pnid`) values 
(1,'青岛',1),
(2,'海尔',1),
(3,'中国',2),
(4,'日本',2),
(5,'格力',1);

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
  KEY `ck_co_pc` (`com_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

/*Data for the table `pur_comm` */

insert  into `pur_comm`(`id`,`pu_id`,`com_id`,`puh_id`,`prh_id`,`pc_geshu`,`warhoure_id`) values 
(1,3,4,6,NULL,5,NULL),
(2,3,5,6,NULL,3,NULL),
(3,3,35,6,NULL,2,NULL),
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
(26,38,51,NULL,NULL,2,NULL),
(27,40,50,NULL,NULL,10,NULL),
(28,40,5,NULL,NULL,10,NULL),
(29,40,51,NULL,NULL,10,NULL),
(30,NULL,4,10,NULL,10,NULL),
(31,NULL,51,11,NULL,10,NULL),
(32,NULL,50,12,NULL,5,NULL),
(33,NULL,51,13,NULL,10,NULL),
(34,NULL,50,14,NULL,10,7),
(35,NULL,51,NULL,7,10,NULL),
(36,42,4,NULL,NULL,50,NULL),
(37,42,4,NULL,NULL,10,NULL),
(38,42,50,NULL,NULL,50,NULL),
(39,42,50,NULL,NULL,10,NULL),
(40,NULL,4,15,NULL,10,NULL),
(41,NULL,4,15,NULL,1,NULL),
(42,NULL,50,15,NULL,10,NULL),
(43,NULL,50,15,NULL,1,NULL),
(44,NULL,51,16,NULL,10,NULL),
(45,NULL,50,16,NULL,10,NULL),
(46,43,4,NULL,NULL,10,NULL),
(47,44,4,NULL,NULL,10,NULL),
(48,44,35,NULL,NULL,5,NULL),
(49,46,35,NULL,NULL,10,NULL),
(50,46,51,NULL,NULL,5,NULL),
(51,48,35,21,NULL,10,5),
(52,48,52,21,NULL,3,5),
(53,49,5,20,NULL,10,6),
(54,49,35,20,NULL,1,6),
(55,NULL,4,17,NULL,10,NULL),
(56,NULL,4,22,NULL,100,8),
(57,NULL,75,22,NULL,50,8),
(58,51,50,23,NULL,10,NULL),
(59,51,52,23,NULL,10,NULL);

/*Table structure for table `purchase_history` */

DROP TABLE IF EXISTS `purchase_history`;

CREATE TABLE `purchase_history` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `ph_date` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `ph_number` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `ph_supname` varchar(51) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '供应商名称',
  `ph_clname` varchar(255) DEFAULT NULL COMMENT '进货商品',
  `ph_quantity` int(8) DEFAULT NULL COMMENT '进货数量',
  `ph_amount_payable` double(10,2) DEFAULT NULL COMMENT '应付金额',
  `ph_amount_paid` double(10,2) DEFAULT NULL COMMENT '已付金额',
  `ph_warehouse` varchar(50) DEFAULT NULL COMMENT '入库仓库',
  `ph_bill` varchar(50) DEFAULT NULL COMMENT '纸质单据',
  `ph_jindate` varchar(50) DEFAULT NULL COMMENT '制单日期',
  `ph_maney_hu` varchar(50) DEFAULT NULL COMMENT '结算账户',
  `ph_experienced_person` varchar(50) DEFAULT NULL COMMENT '经手人',
  `ph_single_person` varchar(50) DEFAULT NULL COMMENT '制单人',
  `ph_other_expenses` double(10,2) DEFAULT NULL COMMENT '其他费用',
  `ph_warehousing_status` varchar(50) DEFAULT NULL COMMENT '入库状态',
  `ph_remarks` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='进货历史';

/*Data for the table `purchase_history` */

insert  into `purchase_history`(`id`,`ph_date`,`ph_number`,`ph_supname`,`ph_clname`,`ph_quantity`,`ph_amount_payable`,`ph_amount_paid`,`ph_warehouse`,`ph_bill`,`ph_jindate`,`ph_maney_hu`,`ph_experienced_person`,`ph_single_person`,`ph_other_expenses`,`ph_warehousing_status`,`ph_remarks`) values 
(5,'2019-01-04','YJDD201901151530','供应商1','超级多',10,49.99,49.99,'默认仓库','1.jpg','2019-01-15 17:04:21','现金','老板1','老板',1.00,'未入库','这是一个备注'),
(10,'2019-01-24 11:22:51','ADD20190124112243','慧慧便利店','脉动',10,141.00,141.00,'郑州仓','无','2019-01-24 11:22:51','现金','老板','老板',1.00,'未入库','无备注'),
(11,'2019-01-24 11:55:14','ADD20190124115504','三只松鼠','零食',10,130.00,130.00,'郑州仓','无','2019-01-24 11:55:14','现金','老板','老板',10.00,'未入库','备注'),
(12,'2019-01-24 11:56:36','ADD20190124115626','慧慧便利店','衣服',5,67.00,67.00,'郑州仓','无','2019-01-24 11:56:36','现金','老板','老板',2.00,'未入库','备注'),
(13,'2019-01-24 12:06:30','ADD20190124120625','慧慧便利店','零食',10,122.00,122.00,'郑州仓','无','2019-01-24 12:06:30','现金','老板','老板',2.00,'未入库','备注'),
(14,'2019-01-24 12:09:17','ADD20190124120912','慧慧便利店','衣服',10,132.00,132.00,'郑州仓','无','2019-01-24 12:09:17','现金','老板','老板',2.00,'等待入库','备注'),
(15,'2019-01-24 16:04:23','ADD20190124160413','三只松鼠','脉动,衣服',11,299.00,299.00,'郑州仓','无','2019-01-24 16:04:23','现金','老板','老板',2.00,'未入库','5424'),
(16,'2019-01-24 16:23:39','ADD20190124162333','恰恰','零食,衣服',20,255.00,255.00,'郑州仓','无','2019-01-24 16:23:39','现金','老板','老板',5.00,'未入库','备注'),
(17,'2019-01-25 10:05:22','ADD20190125100514','恰恰','脉动',10,142.00,142.00,'郑州仓','无','2019-01-25 10:05:22','现金','老板','老板',2.00,'未入库','1'),
(20,'2019-01-25 10:03:33','ADD20190125100329','三只松鼠','饮料11,羽绒衣服',11,264.00,264.00,'默认仓库','无','2019-01-25 11:13:56','现金','老板','老板',0.00,'等待入库','1'),
(21,'2019-01-25 10:02:28','ADD20190125100219','恰恰','羽绒衣服,特殊',13,1612.00,1612.00,'默认仓库','无','2019-01-25 11:16:49','现金','老板','老板',0.00,'等待入库','1'),
(22,'2019-01-25 17:39:38','ADD20190125173934','恰恰','脉动,零食',150,1750.00,1750.00,'郑州仓','无','2019-01-25 17:39:38','现金','老板','老板',0.00,'等待入库','无'),
(23,'2019-01-25 17:48:14','ADD20190125174809','三只松鼠','衣服,特殊',20,1370.00,1370.00,'默认仓库','无','2019-01-25 19:02:55','现金','老板','老板',0.00,'未入库','wu');

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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='进货订单历史';

/*Data for the table `purchase_order` */

insert  into `purchase_order`(`id`,`po_date`,`po_number`,`po_state`,`po_auditor`,`po_sup_name`,`po_cl_name`,`po_quantity_of_purchase`,`po_ying_money`,`po_bill`,`po_experienced_person`,`po_single_person`,`po_remarks`,`po_date_order`) values 
(3,'2019-01-04','JDD201901151524','未审核','老板1','供应商1','脉动',10,49.99,'1.jpg','老板1','老板1','这是一个备注','2019-04-01'),
(36,'2019-01-23 17:26:35','ADD20190123172618','未审核','老板','慧慧便利店','脉动,1241',10,1380.00,NULL,'老板','老板','默认无备注','2019-01-23 17:26:35'),
(37,'2019-01-23 19:44:32','ADD20190123194420','未审核','老板','慧慧便利店','脉动,衣服,零食,特殊',1,163.00,'无','老板','老板','这是个备注','2019-01-23 19:44:32'),
(38,'2019-01-23 20:01:30','ADD20190123200125','未审核','老板','慧慧便利店','脉动,衣服,零食',2,78.00,'无','老板','老板','这是个备注','2019-01-23 20:01:30'),
(40,'2019-01-24 08:57:11','ADD20190124085706','未审核','老板','慧慧便利店','衣服,饮料11,零食',10,390.00,'无','老板','老板','这是个备注','2019-01-24 08:57:11'),
(42,'2019-01-24 15:56:48','ADD20190124155639','未审核','老板','恰恰','脉动,衣服',60,1620.00,'无','老板','老板','备注','2019-01-24 15:56:48'),
(43,'2019-01-24 16:33:18','ADD20190124163315','未审核','老板','三只松鼠','脉动',10,140.00,'无','老板','老板','备注','2019-01-24 16:33:18'),
(44,'2019-01-25 09:48:38','ADD20190125094831','未审核','老板','三只松鼠','脉动,羽绒衣服',15,760.00,'无','老板','老板','aaa','2019-01-25 09:48:38'),
(46,'2019-01-25 09:50:49','ADD20190125095046','未审核','老板','恰恰','羽绒衣服,零食',15,1300.00,'无','老板','老板','备注','2019-01-25 09:50:49'),
(48,'2019-01-25 10:02:28','ADD20190125100219','已审核','老板','恰恰','羽绒衣服,特殊',13,1612.00,'无','老板','老板','无','2019-01-25 10:02:28'),
(49,'2019-01-25 10:03:33','ADD20190125100329','已审核','老板','三只松鼠','饮料11,羽绒衣服',11,264.00,'无','老板','老板','无','2019-01-25 10:03:33'),
(51,'2019-01-25 17:48:14','ADD20190125174809','已审核','老板','三只松鼠','衣服,特殊',20,1370.00,'无','老板','老板','wu','2019-01-25 17:48:14');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='进货退货历史';

/*Data for the table `purchase_return_history` */

insert  into `purchase_return_history`(`id`,`prh_date`,`prh_number`,`prh_supname`,`prh_returnsup`,`prh_total_amount`,`prh_refund_amount`,`prh_outgoing_warehouse`,`prh_bill`,`prh_jindate`,`prh_maney_hu`,`prh_experienced_person`,`prh_single_person`,`prh_other_expenses`,`prh_outgoing_state`,`prh_remarks`) values 
(7,'2019-01-24 15:27:00','TDD20190124152652','恰恰','零食',125.00,125.00,'郑州仓','无','2019-01-24 15:27:00','现金','老板','老板',5.00,'待出库','备注');

/*Table structure for table `running_accounts` */

DROP TABLE IF EXISTS `running_accounts`;

CREATE TABLE `running_accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ra_num_list` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `ra_time` varchar(50) DEFAULT NULL COMMENT '业务日期',
  `ra_company_name` varchar(50) DEFAULT NULL COMMENT '往来单位名称',
  `ra_project_name` varchar(50) DEFAULT NULL COMMENT '收支项目名称',
  `ra_account` varchar(50) DEFAULT NULL COMMENT '结算账户',
  `ra_person` varchar(50) DEFAULT NULL COMMENT '经手人',
  `ra_income` double DEFAULT '0' COMMENT '收入',
  `ra_outcome` double DEFAULT '0' COMMENT '支出',
  `ra_current_balance` double DEFAULT '0' COMMENT '当前余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='资金流水表(ymy)';

/*Data for the table `running_accounts` */

insert  into `running_accounts`(`id`,`ra_num_list`,`ra_time`,`ra_company_name`,`ra_project_name`,`ra_account`,`ra_person`,`ra_income`,`ra_outcome`,`ra_current_balance`) values 
(1,'XSD20170725004','2017-07-27','盈云公司','销售收入','现金','财务',708,0,-3595.5),
(8,'ADD20190124115504','2019-01-24 11:55:47','三只松鼠','进货支出','现金','老板',0,130,9999890),
(9,'ADD20190124115626','2019-01-24 11:56:53','慧慧便利店','进货支出','现金','老板',0,67,9999937),
(10,'ADD20190124120625','2019-01-24 12:06:50','慧慧便利店','进货支出','现金','老板',0,122,9999815),
(11,'ADD20190124120912','2019-01-24 12:09:49','慧慧便利店','进货支出','现金','老板',0,132,9999683),
(12,'TDD20190124152652','2019-01-24 15:27:35','恰恰','退货支出','现金','老板',125,0,9999808),
(13,'ADD20190124160413','2019-01-24 16:04:50','三只松鼠','进货支出','现金','老板',0,299,9999509),
(14,'ADD20190124162333','2019-01-24 16:24:17','恰恰','进货支出','现金','老板',0,255,9999254),
(15,'ZZ201901240014','2019-01-24 17:54:17','账户转账','转账支出','现金','老板',0,121,9999133),
(16,'ZZ201901240015','2019-01-24 18:03:42','账户转账','转账支出','建设银行','老板',0,203,9998930),
(20,'SZ201901240016','2019-01-24 18:39:19','日常收入','日常收入','现金','老板',3000,0,9995930),
(21,'SZ201901240020','2019-01-24 18:40:57','日常支出','日常支出','现金','老板',0,1200,9994730),
(22,'SZ201901250021','2019-01-25 09:47:29','日常收入','日常收入','现金','老板',20,0,9994710),
(23,'ADD20190125100514','2019-01-25 10:05:45','恰恰','进货支出','现金','老板',0,142,9994568),
(24,'ADD20190125100514','2019-01-25 10:06:48','恰恰','进货支出','现金','老板',0,142,9994426),
(25,'SZ201901250024','2019-01-25 17:23:56','日常收入','日常收入','现金','老板',11.1,0,9994414.9),
(26,'SZ201901250025','2019-01-25 17:24:38','日常支出','日常支出','现金','财务',0,10.1,9994404.8),
(27,'SZ201901250026','2019-01-25 17:24:47','日常支出','日常支出','现金','老板',0,1,9994403.8),
(28,'SZ201901250027','2019-01-25 17:25:03','日常收入','日常收入','现金','老板',1,0,9994402.8),
(29,'ADD20190125173934','2019-01-25 17:39:56','恰恰','进货支出','现金','老板',0,1750,9992652.8);

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='销售历史';

/*Data for the table `sales_history` */

insert  into `sales_history`(`id`,`sh_date`,`sh_number`,`sh_connect`,`sh_client`,`sh_sell_goods`,`sh_sell_count`,`sh_discount`,`sh_mins`,`sh_profit`,`sh_money`,`sh_true_money`,`sh_house`,`sh_bills`,`sh_create_date`,`sh_give_date`,`sh_other`,`sh_end_comm`,`sh_hander`,`sh_maker`,`sh_type`,`sh_status`,`sh_remark`) values 
(1,'2019-1-9','aaa',NULL,'杨1',NULL,0.00,0.00,0.00,0.00,0.00,'0','0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,NULL,'abc',NULL,'yang1',NULL,0.00,0.00,0.00,0.00,0.00,'0','本地仓库','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(4,'2019-1-9','aaa',NULL,'杨1',NULL,0.00,0.00,0.00,0.00,0.00,'0','0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(5,'2019-1-9','aaa',NULL,'杨1',NULL,0.00,0.00,0.00,0.00,0.00,'0','0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(10,'2017-07-25','XDD2019012516051','XDD20170725001','智慧商贸',NULL,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'老板',NULL,NULL,'未审核',NULL),
(11,'2017-07-25','XDD2019012516061','XDD20170725001','智慧商贸',NULL,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'老板',NULL,NULL,'未审核',NULL),
(12,'2017-07-25','XDD2019012516081','XDD20170725001','智慧商贸',NULL,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'老板',NULL,NULL,'未审核',NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='销售订单历史';

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
(15,'2017-07-25','XDD20170725015','未审核','老板','智慧商贸','红米note3、诺基亚800',2,0.00,11394.00,500.00,NULL,'2017-07-25',6,'2017-7-26','老板','老板',NULL),
(16,'2019-01-24 16:21:59','XSD2019012418291',NULL,'老板','10',',饮料11,衣服',6,NULL,776.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(17,'2019-01-24 16:39:46','XSD2019012418381',NULL,'老板','10',',衣服,零食',16,NULL,792.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(18,'2019-01-24 16:21:59','XSD2019012418391',NULL,'老板','12',',1241,零食',9,NULL,668.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='结算帐户';

/*Data for the table `settlement_account` */

insert  into `settlement_account`(`id`,`sa_name`,`sa_bank`,`sa_balance`,`sa_state`,`sa_banknumber`,`sa_beginbalance`) values 
(4,'发送到1223','郑州银行',12.00,'正常','5465476','7657'),
(9,'宋江','中原银行',45.00,'正常','123456789012345678','345'),
(10,'吴用','中国人民银行',1242143.00,'禁用','1243243254435465657','123'),
(12,'公孙胜','中国人民银行',2345.00,'禁用','124324325454565465','123'),
(13,'关胜','中国人民银行',324.00,'正常','124235125423554123','123'),
(14,'林冲','中国政策性银行',5678.00,'正常','1242354436548672467','4567'),
(15,'秦明','中国国家开发银行',347.00,'正常','2134324545677889057','345'),
(16,'呼延灼','中国农业银行',456.00,'正常','1242354365767893567','234'),
(17,'花荣','中国进口银行',4356.00,'禁用','1253465476587943534','2324'),
(18,'武松','中国工商银行',12340.00,'正常','4325436547676897945','8923'),
(19,'刘唐','中国建设银行',6901.00,'正常','23534657659879567345','4589'),
(20,'邓飞','中国民生银行',9083.00,'正常','4365467576587892432','7801'),
(21,'解包','华夏银行',10892.00,'正常','125432564765768793456','8901'),
(22,'朱武','中国建设银行',2309.00,'正常','1254325465876890345','1201');

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

/*Table structure for table `system_log` */

DROP TABLE IF EXISTS `system_log`;

CREATE TABLE `system_log` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(25) DEFAULT NULL COMMENT '账号',
  `username` varchar(25) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(25) DEFAULT NULL COMMENT '操作',
  `ip` varchar(25) DEFAULT NULL COMMENT 'IP地址',
  `create_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=526 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

/*Data for the table `system_log` */

insert  into `system_log`(`id`,`account`,`username`,`operation`,`ip`,`create_date`) values 
(492,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-25 18:02:01'),
(493,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-25 18:02:02'),
(494,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-25 18:15:55'),
(495,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 18:15:56'),
(496,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 18:19:31'),
(497,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 18:19:31'),
(498,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 18:39:06'),
(499,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 18:39:07'),
(500,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 18:39:09'),
(501,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 18:39:09'),
(502,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-25 18:39:11'),
(503,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 18:39:11'),
(504,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:02:40'),
(505,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:02:41'),
(506,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:02:42'),
(507,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:02:43'),
(508,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:02:45'),
(509,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:02:45'),
(510,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:02:54'),
(511,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:02:55'),
(512,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:03:12'),
(513,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:03:12'),
(514,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:03:37'),
(515,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:03:38'),
(516,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:03:42'),
(517,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:03:42'),
(518,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:03:42'),
(519,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:03:55'),
(520,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:03:55'),
(521,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:03:58'),
(522,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-25 19:08:39'),
(523,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:08:39'),
(524,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-25 19:14:00'),
(525,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-25 19:14:01');

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
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

/*Data for the table `template_details` */

insert  into `template_details`(`id`,`td_name`,`td_number`,`td_property`,`td_sum`,`td_company`,`ct_id`) values 
(19,'脉动','124123',NULL,NULL,NULL,NULL),
(20,'饮料11','1编辑',NULL,NULL,NULL,NULL),
(21,'1241','124',NULL,NULL,NULL,NULL),
(22,'脉动','124123',NULL,NULL,NULL,1),
(23,'饮料11','1编辑',NULL,NULL,NULL,1),
(24,'1241','124',NULL,NULL,NULL,1),
(25,'衣服','1243',NULL,NULL,NULL,1),
(26,'衣服','1243',NULL,NULL,NULL,1),
(27,'零食','21',NULL,NULL,NULL,1),
(28,'衣服','1243',NULL,NULL,NULL,1),
(29,'零食','21',NULL,NULL,NULL,1),
(30,'饮料11','1编辑',NULL,NULL,NULL,1),
(31,'1241','124',NULL,NULL,NULL,1),
(32,'衣服','1243',NULL,NULL,NULL,1),
(33,'饮料11','1编辑',NULL,NULL,NULL,1),
(34,'1241','124',NULL,NULL,NULL,1),
(35,'衣服','1243',NULL,NULL,NULL,1),
(36,'脉动','124123',NULL,NULL,NULL,1),
(37,'饮料11','1编辑',NULL,NULL,NULL,1),
(38,'脉动','124123',NULL,NULL,NULL,1),
(39,'饮料11','1编辑',NULL,NULL,NULL,1),
(40,'脉动','124123',NULL,NULL,NULL,1),
(41,'饮料11','1编辑',NULL,NULL,NULL,1),
(42,'1241','124',NULL,NULL,NULL,1),
(43,'脉动','124123',NULL,NULL,NULL,1),
(44,'饮料11','1编辑',NULL,NULL,NULL,1),
(45,'脉动','124123',NULL,NULL,NULL,1),
(46,'饮料11','1编辑',NULL,NULL,NULL,1),
(47,'1241','124',NULL,NULL,NULL,1),
(48,'脉动','124123',NULL,NULL,NULL,1),
(49,'饮料11','1编辑',NULL,NULL,NULL,1),
(50,'脉动','124123',NULL,NULL,NULL,1),
(51,'饮料11','1编辑',NULL,NULL,NULL,1),
(52,'脉动','124123',NULL,NULL,NULL,1),
(53,'饮料11','1编辑',NULL,NULL,NULL,1),
(54,'1241','124',NULL,NULL,NULL,1),
(55,'衣服','1243',NULL,NULL,NULL,1),
(56,'零食','21',NULL,NULL,NULL,1),
(57,'特殊','123',NULL,NULL,NULL,1),
(58,'脉动','124123',NULL,NULL,NULL,1),
(59,'饮料11','1编辑',NULL,NULL,NULL,1),
(60,'1241','124',NULL,NULL,NULL,1),
(61,'饮料11','1编辑',NULL,NULL,NULL,1),
(62,'1241','124',NULL,NULL,NULL,1),
(63,'脉动','124123',NULL,NULL,NULL,1),
(64,'饮料11','1编辑',NULL,NULL,NULL,1),
(65,'脉动','124123',NULL,NULL,NULL,1),
(66,'饮料11','1编辑',NULL,NULL,NULL,1),
(67,'羽绒衣服','124',NULL,NULL,NULL,1),
(68,'脉动','124123',NULL,NULL,NULL,1),
(69,'饮料11','1编辑',NULL,NULL,NULL,1),
(70,'羽绒衣服','124',NULL,NULL,NULL,1),
(71,'脉动','124123',NULL,NULL,NULL,1),
(72,'饮料11','1编辑',NULL,NULL,NULL,1),
(73,'脉动','124123',NULL,NULL,NULL,1),
(74,'饮料11','1编辑',NULL,NULL,NULL,1),
(75,'饮料11','1编辑',NULL,NULL,NULL,1),
(76,'羽绒衣服','124',NULL,NULL,NULL,1),
(77,'脉动','124123',NULL,NULL,NULL,1),
(78,'饮料11','1编辑',NULL,NULL,NULL,1),
(79,'羽绒衣服','124',NULL,NULL,NULL,1),
(80,'衣服','1243',NULL,NULL,NULL,1),
(81,'脉动','124123',NULL,NULL,NULL,1),
(82,'饮料11','1编辑',NULL,NULL,NULL,1),
(83,'脉动','124123',NULL,NULL,NULL,2),
(84,'饮料11','1编辑',NULL,NULL,NULL,2),
(85,'羽绒衣服','124',NULL,NULL,NULL,2),
(86,'脉动','124123',NULL,NULL,NULL,2),
(87,'饮料11','1编辑',NULL,NULL,NULL,2),
(88,'羽绒衣服','124',NULL,NULL,NULL,2),
(89,'脉动','124123',NULL,NULL,NULL,2),
(90,'饮料11','1编辑',NULL,NULL,NULL,2),
(91,'羽绒衣服','124',NULL,NULL,NULL,2),
(92,'脉动','124123',NULL,NULL,NULL,2),
(93,'饮料11','1编辑',NULL,NULL,NULL,2),
(94,'脉动','124123',NULL,NULL,NULL,2),
(95,'饮料11','1编辑',NULL,NULL,NULL,2),
(96,'脉动','124123',NULL,NULL,NULL,2),
(97,'饮料11','1编辑',NULL,NULL,NULL,2);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='等待出库';

/*Data for the table `wait_out_warehouse` */

insert  into `wait_out_warehouse`(`id`,`wo_date`,`wo_number`,`wo_type`,`wo_company`,`wo_house`,`wo_goods`,`wo_count`,`wo_create_date`,`wo_hander`,`wo_maker`,`wo_status`) values 
(1,NULL,'001',NULL,'yy',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,NULL,'002',NULL,'xx',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(3,NULL,'003',NULL,'zz',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(4,NULL,'aaa',NULL,'杨1',NULL,NULL,NULL,'2019-1-9','',NULL,'');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='库存查询';

/*Data for the table `warehouse` */

insert  into `warehouse`(`id`,`wa_number`,`wa_sp_name`,`wa_sp_specifications`,`wa_sp_company`,`wa_sp_lnventory`,`wa_sp_current_inventory`,`wa_sp_forout`,`wa_sp_forenter`,`wa_cost`,`wa_total_sum`) values 
(1,'001','124','大','1件',200,100,20,20,436.00,43600.00),
(3,'002','鞋子','大','1双',200,100,20,20,100.00,100.00),
(4,'004','脉动',NULL,NULL,0,100,NULL,NULL,325.00,32500.00),
(5,'005','饮料11',NULL,NULL,0,10,NULL,NULL,124.00,1240.00),
(6,'006','羽绒衣服',NULL,NULL,0,10,NULL,NULL,124.00,1240.00),
(7,'007','零食',NULL,NULL,0,50,NULL,NULL,12.00,450.00),
(8,'008','特殊',NULL,NULL,0,3,NULL,NULL,214.00,642.00),
(9,'009','衣服',NULL,NULL,0,10,NULL,NULL,132.00,1320.00);

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `warehouse_receipt` */

insert  into `warehouse_receipt`(`id`,`wre_date`,`wre_number`,`wre_type`,`wre_current_unit`,`wre_warehost_name`,`wre_storage`,`wre_scheduled_receipt`,`wre_date_order`,`wre_single_person`,`wre_experienced_person`,`wre_state`) values 
(1,'2019-01-15','YJDD201901151530','进货','360超市','默认仓库','大白兔奶糖',100,'2019-01-15','老板','老板','未入库'),
(2,'2019-01-17','YJDD201901171617','进货','360超市','默认仓库','大白兔',100,'2019-01-15','老板','老板','全部入库'),
(5,'2019-01-25 10:02:28','ADD20190125100219','进货','恰恰','默认仓库','羽绒衣服,特殊',13,'2019-01-25 14:01:30','老板','老板','全部入库'),
(6,'2019-01-25 10:03:33','ADD20190125100329','进货','三只松鼠','默认仓库','饮料11,羽绒衣服',11,'2019-01-25 14:06:36','老板','老板','全部入库'),
(7,'2019-01-24 12:09:17','ADD20190124120912','进货','慧慧便利店','郑州仓','衣服',10,'2019-01-25 17:44:01','老板','老板','全部入库'),
(8,'2019-01-25 17:39:38','ADD20190125173934','进货','恰恰','郑州仓','脉动,零食',150,'2019-01-25 19:03:37','老板','老板','全部入库');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
