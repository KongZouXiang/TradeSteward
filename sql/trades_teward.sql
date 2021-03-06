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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品分类';

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
(14,'苹果',0,8),
(15,'鸡肉',0,10),
(17,'橘子',0,8),
(18,'榴莲',0,8),
(19,'榴莲',0,8),
(20,'香蕉',0,8),
(25,'榴莲',0,8);

/*Table structure for table `commodi_tytemplate` */

DROP TABLE IF EXISTS `commodi_tytemplate`;

CREATE TABLE `commodi_tytemplate` (
  `id` int(25) NOT NULL AUTO_INCREMENT COMMENT '模板id',
  `ct_template_number` varchar(50) DEFAULT NULL COMMENT '模板编号',
  `ct_tytemplate_name` varchar(25) DEFAULT NULL COMMENT '模板名称',
  `ct_templategoods` varchar(255) DEFAULT NULL COMMENT '模板商品',
  `ct_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='商品模板';

/*Data for the table `commodi_tytemplate` */

insert  into `commodi_tytemplate`(`id`,`ct_template_number`,`ct_tytemplate_name`,`ct_templategoods`,`ct_remarks`) values 
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
(28,'2456845','购房人的一点','脉动,饮料11,',NULL),
(29,'213423','sdfa','脉动,饮料11,',NULL);

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
(4,'脉动','瓶','1234243412423','1箱/18瓶','14','325','124',9,26,'1241232145452',3,2,6,'1234'),
(5,'饮料','只','1242343543657','19','14','124','124',1,25,'112543254456',3,2,6,'124'),
(35,'羽绒衣服','无','1242365465778','124','124','124','124',5,27,'124',3,124,124,'124'),
(50,'衣服','件','1254354657688','红色短款','13','132','213',1,25,'1243',2,132,133,'214'),
(52,'特殊','无','1243564657688','红色长款','124','214','123',1,25,'123',2,12,124,'2143'),
(71,'塑料','包','1243212432456','14231','456','436','124',2,24,'124',4,235,235,'124'),
(73,'辣条','个','1254365876989','小包','15423','1455','1242',5,27,'125234wrew',4,123,450,'2435'),
(74,'面条','公斤','7989805547677','一箱','214','214','124',3,29,'qwerwqr12423',4,214,345,'24'),
(75,'零食','包','2354376587689','一包','7','9','12',3,25,'QWERWR12423',4,1243,2000,'10'),
(76,'饮料','箱','2135436546758','大箱','100','110','120',3,24,'wqrewt12432',4,120,1000,'115'),
(77,'百事可乐','杯','2353476578689','一杯','34','23','56',3,24,'asdfsaf124324',4,124,465,'23');

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='客户管理';

/*Data for the table `customer` */

insert  into `customer`(`id`,`cus_number`,`cus_compname`,`cus_money`,`cus_tele`,`cus_name`,`cus_flag`,`cus_connname`,`cus_address`,`cus_email`,`cus_qq`,`cus_remarks`) values 
(6,'KH20190105000','云和数据',1000,'15745676654','刘女士',1,'阿达','啊发发发违法司法按时按时','1566@qq.com',48946,'木得'),
(9,'KH20170725004','零售客户',35780,'13234562234','李先生',1,'阿萨德','阿斯达','1566@qq.com',156546,'奥术大师多大'),
(10,'KH20190105003','智慧商贸',184.6,'13234562234','朱女士',1,'是的第三','阿斯达','155269@qq.com',156489,'按时发大水发'),
(11,'KH20190105001','盈云公司',123,'15745676654','胡女士',1,'勾三搭四','根深蒂固','155269@qq.com',156748,'是否更好的'),
(12,'KH20190105002','青云湖',1800,'13234562234','张先生',1,'基总','天空之城二楼','155269@qq.com',0,'牛皮');

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
(70,'kuikui','123456','奎奎','管理员','男','13103877752','5628654128@qq.com','正常','默认仓库','零售价，最低价','允许','允许','不允许','重庆市重庆市辖县城口县',1);

/*Table structure for table `finance_classify` */

DROP TABLE IF EXISTS `finance_classify`;

CREATE TABLE `finance_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fc_type` varchar(50) DEFAULT NULL COMMENT '账目类型',
  `fc_sort` varchar(50) DEFAULT NULL COMMENT '收支类别',
  `fc_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COMMENT='收支分类管理表(ymy)';

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
(74,'话费','收入','话费也要钱啊'),
(77,'水电费','支出','增加话费收支'),
(78,'撒反对','支出','长撒');

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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='欠款详细表';

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
(26,'2019-01-23','恰恰','FKD201901230026','老板','进货付款',9900,0,0,'现金',9900),
(27,'2019-01-23','慧慧便利店','FKD201901230027','老板','进货商品',0,100,0,'现金',-100),
(28,'2019-01-23','三只松鼠','FKD201901230028','老板','进货商品',0,3454,0,'现金',-3454),
(29,'2019-01-23','慧慧便利店','FKD201901230029','老板','进货商品',0,23,0,'现金',-23),
(30,'2019-01-23','恰恰','FKD201901230030','老板','进货商品',0,10,0,'现金',-10),
(31,'2019-01-24','恰恰','FKD201901240031','老板','进货商品',0,7800,100,'现金',-7900),
(32,'2019-01-24','慧慧便利店','FKD201901240032','老板','进货付款',55000,0,0,'现金',55000),
(33,'2019-01-24','三只松鼠','FKD201901240033','老板','进货付款',8000,0,0,'现金',8000),
(34,'2019-01-24','三只松鼠','FKD201901240034','老板','进货商品',0,100,10,'现金',-110),
(35,'2019-01-24','慧慧便利店','FKD201901240035','老板','进货商品',0,999,1,'现金',-1000),
(36,'2019-01-24','恰恰','FKD201901240036','老板','进货商品',0,340,0,'现金',-340),
(37,'2019-01-25','','FKD201901250037','老板','进货商品',0,20,10,'现金',-30),
(38,'2019-01-02','云和数据','SKD20190102003','老板','期初欠款',1000,0,0,'现金',1000),
(39,'2019-01-26','零售客户','SKD20190126001','老板','期初欠款',35780,0,0,'现金',35780),
(40,'2019-01-26','盈云公司','SKD201901260040','老板','期初欠款',123,0,0,'现金',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='商品套餐';

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
(14,'151515','套餐14','饮料',NULL),
(15,'235246','stgyr','脉动,饮料11,',NULL),
(16,'1457152','新增','脉动,饮料11,羽绒衣服,',NULL),
(17,'2451','yrft6j','脉动,饮料11,',NULL),
(19,'254','nmkuil','脉动,饮料,',NULL);

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
  `return_num` int(11) DEFAULT NULL,
  `cl_id` int(11) DEFAULT NULL COMMENT '关联商品id',
  `order_count` int(11) DEFAULT NULL COMMENT '该商品的数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='单号与商品的关联表';

/*Data for the table `order_connect_comm` */

insert  into `order_connect_comm`(`id`,`order_num`,`sell_order_num`,`return_num`,`cl_id`,`order_count`) values 
(1,1,13,1,51,4),
(2,1,13,1,50,4),
(3,1,13,1,4,8),
(4,NULL,1,NULL,5,3),
(5,NULL,1,NULL,48,7),
(6,22,0,NULL,5,45),
(7,23,0,NULL,5,5),
(8,23,0,NULL,50,6),
(9,25,0,NULL,4,4),
(10,25,0,NULL,35,8),
(11,28,0,0,50,1),
(12,28,0,0,5,2),
(13,29,0,0,4,25),
(14,30,0,0,4,2);

/*Table structure for table `package_commodity` */

DROP TABLE IF EXISTS `package_commodity`;

CREATE TABLE `package_commodity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pc_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `pc_number` varchar(15) DEFAULT NULL COMMENT '商品列表ID',
  `pc_property` varchar(25) DEFAULT NULL,
  `pc_sum` int(8) DEFAULT NULL,
  `pc_company` varchar(25) DEFAULT NULL,
  `pc_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='商品套餐和商品关联表';

/*Data for the table `package_commodity` */

insert  into `package_commodity`(`id`,`pc_name`,`pc_number`,`pc_property`,`pc_sum`,`pc_company`,`pc_id`) values 
(2,'脉动','124123',NULL,NULL,NULL,2),
(3,'饮料11','1编辑',NULL,NULL,NULL,2),
(4,'羽绒衣服','124',NULL,NULL,NULL,2),
(5,'脉动','124123',NULL,NULL,NULL,2),
(6,'饮料11','1编辑',NULL,NULL,NULL,2),
(7,'脉动','124123',NULL,NULL,NULL,2),
(8,'饮料11','1编辑',NULL,NULL,NULL,2),
(9,'脉动','1241232145452',NULL,NULL,NULL,2),
(10,'饮料','112543254456',NULL,NULL,NULL,2);

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='销售历史';

/*Data for the table `sales_history` */

insert  into `sales_history`(`id`,`sh_date`,`sh_number`,`sh_connect`,`sh_client`,`sh_sell_goods`,`sh_sell_count`,`sh_discount`,`sh_mins`,`sh_profit`,`sh_money`,`sh_true_money`,`sh_house`,`sh_bills`,`sh_create_date`,`sh_give_date`,`sh_other`,`sh_end_comm`,`sh_hander`,`sh_maker`,`sh_type`,`sh_status`,`sh_remark`) values 
(1,'2019-1-9','55',NULL,'杨1',NULL,0.00,0.00,0.00,0.00,0.00,'0','0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,NULL,'abc',NULL,'yang1',NULL,0.00,0.00,0.00,0.00,0.00,'0','本地仓库','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(4,'2019-1-9','aaa',NULL,'杨1',NULL,0.00,0.00,0.00,0.00,0.00,'0','0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(5,'2019-1-9','aaa',NULL,'杨1',NULL,0.00,0.00,0.00,0.00,0.00,'0','0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(10,'2017-07-25','XDD2019012516051','XDD20170725001','智慧商贸',NULL,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'老板',NULL,NULL,'未审核',NULL),
(11,'2017-07-25','XDD2019012516061','XDD20170725001','智慧商贸',NULL,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'老板',NULL,NULL,'未审核',NULL),
(12,'2017-07-25','XDD2019012516081','XDD20170725001','智慧商贸',NULL,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'老板',NULL,NULL,'未审核',NULL),
(13,'2017-07-25','XDD2019012610044','XDD20170725001','智慧商贸',NULL,0.00,0.00,0.00,0.00,11394.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'老板',NULL,NULL,'未审核',NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='销售订单历史';

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
(18,'2019-01-24 16:21:59','XSD2019012418391',NULL,'老板','12',',1241,零食',9,NULL,668.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(25,'2019-01-24 16:21:59','XSD2019012610033',NULL,'老板','6',',脉动,羽绒衣服',12,NULL,2292.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(26,'','XSD2019012615424',NULL,'老板','6',',羽绒衣服',1,NULL,124.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(27,'2019-01-24 18:59:01','XSD2019012615461',NULL,'老板','10',',羽绒衣服,衣服',9,NULL,1148.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(28,'2019-01-24 18:59:01','XSD2019012615501',NULL,'老板','10',',衣服,饮料',3,NULL,380.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(29,'2019-01-03 15:56:30','XSD2019012615561',NULL,'老板','6',',脉动',25,NULL,8125.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(30,'2019-01-16 17:11:28','XSD2019012617111',NULL,'老板','6',',脉动',2,NULL,650.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

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
  `sup_flag` int(9) NOT NULL DEFAULT '1' COMMENT '状态',
  `sup_linkman` varchar(25) DEFAULT NULL COMMENT '联系人',
  `sup_conn` varchar(25) DEFAULT NULL COMMENT '关联客户',
  `sup_email` varchar(25) DEFAULT NULL COMMENT '邮箱',
  `sup_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='供应商管理';

/*Data for the table `supplier` */

insert  into `supplier`(`id`,`sup_compname`,`sup_number`,`sup_money`,`sup_tele`,`sup_flag`,`sup_linkman`,`sup_conn`,`sup_email`,`sup_remarks`) values 
(4,'三只松鼠','GYS20170724007',8000,'18338261765',1,'胡女士','胡','1298797619@qq.com','中啊'),
(5,'恰恰','GYS20170724003',9900,'13133602876',1,'王老板','王','433458@qq.com','好了'),
(6,'慧慧便利店','GYS20170724006',55000,'15738358823',1,'李老板','李','705734@outlook.com','agustin');

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
) ENGINE=InnoDB AUTO_INCREMENT=989 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

/*Data for the table `system_log` */

insert  into `system_log`(`id`,`account`,`username`,`operation`,`ip`,`create_date`) values 
(1,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:13'),
(2,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:14'),
(3,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:15'),
(4,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:15'),
(5,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:20'),
(6,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:20'),
(7,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:32'),
(8,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:33'),
(9,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:52'),
(10,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:35'),
(11,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:53'),
(12,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:57'),
(13,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:45:57'),
(14,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:02'),
(15,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:02'),
(16,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:06'),
(17,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:07'),
(18,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:16'),
(19,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:06'),
(20,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:07'),
(21,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:33'),
(22,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:33'),
(23,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:33'),
(24,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:35'),
(25,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:36'),
(26,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:46:36'),
(27,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:47:28'),
(28,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:47:28'),
(29,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:47:30'),
(30,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:47:52'),
(31,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:47:52'),
(32,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:48:12'),
(33,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:48:12'),
(34,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:48:32'),
(35,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:48:33'),
(36,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:48:35'),
(37,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:48:36'),
(38,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:48:44'),
(39,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:48:45'),
(40,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:48:53'),
(41,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:50:00'),
(42,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:50:00'),
(43,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:50:02'),
(44,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:50:03'),
(45,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:50:13'),
(46,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:50:13'),
(47,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:50:14'),
(48,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:51:18'),
(49,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:51:18'),
(50,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:51:21'),
(51,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:51:21'),
(52,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:53:10'),
(53,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:53:10'),
(54,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:53:34'),
(55,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:53:35'),
(56,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:53:45'),
(57,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:53:46'),
(58,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:53:55'),
(59,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:53:55'),
(60,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:54:21'),
(61,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 14:54:25'),
(62,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:22'),
(63,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:23'),
(64,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 14:55:26'),
(65,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:26'),
(66,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:33'),
(67,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:30'),
(68,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:32'),
(69,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:41'),
(70,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:37'),
(71,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:38'),
(72,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 14:55:39'),
(73,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:40'),
(74,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:47'),
(75,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:51'),
(76,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 14:55:40'),
(77,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 14:55:55'),
(78,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:55:55'),
(79,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:01'),
(80,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:02'),
(81,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:05'),
(82,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:06'),
(83,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:06'),
(84,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:07'),
(85,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:08'),
(86,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:11'),
(87,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:11'),
(88,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:12'),
(89,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:14'),
(90,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:19'),
(91,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:22'),
(92,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:25'),
(93,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:36'),
(94,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:39'),
(95,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:45'),
(96,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:48'),
(97,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:58'),
(98,'kuankuan','阿宽',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:51'),
(99,'kuankuan','阿宽',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:56:54'),
(100,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:57:02'),
(101,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:57:02'),
(102,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:57:03'),
(103,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:57:04'),
(104,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:57:06'),
(105,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:57:11'),
(106,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:57:11'),
(107,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:57:16'),
(108,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 14:57:19'),
(109,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:57:31'),
(110,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:57:31'),
(111,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:58:13'),
(112,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:58:14'),
(113,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:58:15'),
(114,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:58:15'),
(115,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:58:16'),
(116,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:58:16'),
(117,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:58:10'),
(118,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:58:32'),
(119,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:58:32'),
(120,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:58:33'),
(121,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:58:25'),
(122,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 14:58:25'),
(123,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 14:59:07'),
(124,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:17'),
(125,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:17'),
(126,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:21'),
(127,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:28'),
(128,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:28'),
(129,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:30'),
(130,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:30'),
(131,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:32'),
(132,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:32'),
(133,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:36'),
(134,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:39'),
(135,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:45'),
(136,'kuankuan','阿宽',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:44'),
(137,'kuankuan','阿宽',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:48'),
(138,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:53'),
(139,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:58'),
(140,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:55'),
(141,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:56'),
(142,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:01:57'),
(143,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:02:28'),
(144,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:02:28'),
(145,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:02:12'),
(146,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:02:14'),
(147,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:02:21'),
(148,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:02:42'),
(149,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:01'),
(150,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:02:42'),
(151,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:02'),
(152,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:03'),
(153,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:03'),
(154,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:05'),
(155,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:02:48'),
(156,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:09'),
(157,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:09'),
(158,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:12'),
(159,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 15:03:20'),
(160,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:49'),
(161,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:51'),
(162,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:38'),
(163,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:56'),
(164,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:39'),
(165,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:55'),
(166,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:56'),
(167,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:03:59'),
(168,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 15:04:07'),
(169,'kuankuan','阿宽',NULL,'127.0.0.1','2019-01-26 15:04:47'),
(170,'kuankuan','阿宽',NULL,'127.0.0.1','2019-01-26 15:04:48'),
(171,'kuankuan','阿宽',NULL,'127.0.0.1','2019-01-26 15:04:53'),
(172,'kuikui','奎奎',NULL,'127.0.0.1','2019-01-26 15:05:47'),
(173,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:05:35'),
(174,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:05:35'),
(175,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:05:38'),
(176,'kuikui','奎奎',NULL,'127.0.0.1','2019-01-26 15:05:51'),
(177,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:05:41'),
(178,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:03'),
(179,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:03'),
(180,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:06'),
(181,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:10'),
(182,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:14'),
(183,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:17'),
(184,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:23'),
(185,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:27'),
(186,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:27'),
(187,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:37'),
(188,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:32'),
(189,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:55'),
(190,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:07:55'),
(191,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 15:08:01'),
(192,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:08:01'),
(193,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:08:16'),
(194,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:08:25'),
(195,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:08:24'),
(196,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:08:24'),
(197,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:08:28'),
(198,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 15:08:32'),
(199,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:08:50'),
(200,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:08:50'),
(201,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:08:57'),
(202,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:08:57'),
(203,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:08:59'),
(204,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:09:28'),
(205,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:09:28'),
(206,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:09:28'),
(207,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:09:31'),
(208,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:09:35'),
(209,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:09:35'),
(210,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:09:35'),
(211,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:09:40'),
(212,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:09:44'),
(213,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:09:44'),
(214,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:09:44'),
(215,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:09:58'),
(216,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:10:05'),
(217,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:10:05'),
(218,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:10:05'),
(219,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:10:17'),
(220,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:10:32'),
(221,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:10:32'),
(222,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:12:09'),
(223,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:12:09'),
(224,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:12:18'),
(225,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:13:18'),
(226,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:13:18'),
(227,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:13:07'),
(228,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:13:07'),
(229,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:13:29'),
(230,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:13:39'),
(231,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 15:14:14'),
(232,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:14:27'),
(233,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:14:27'),
(234,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:14:21'),
(235,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:14:21'),
(236,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:14:37'),
(237,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:14:23'),
(238,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:14:25'),
(239,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:14:42'),
(240,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:14:49'),
(241,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:14:52'),
(242,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:14:53'),
(243,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:14:55'),
(244,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:15:34'),
(245,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:15:34'),
(246,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:15:47'),
(247,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:15:47'),
(248,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:16:09'),
(249,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:16:10'),
(250,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:16:11'),
(251,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 15:16:36'),
(252,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 15:18:05'),
(253,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:18:06'),
(254,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:18:09'),
(255,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:18:09'),
(256,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:18:10'),
(257,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:18:17'),
(258,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:18:10'),
(259,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:18:17'),
(260,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:18:19'),
(261,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:18:15'),
(262,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:18:23'),
(263,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:18:26'),
(264,'kuankuan','阿宽',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:18:30'),
(265,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:19:33'),
(266,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:19:33'),
(267,'1','老板','进入日常收支页面','0:0:0:0:0:0:0:1','2019-01-26 15:19:21'),
(268,'1','老板','查看日常收支','0:0:0:0:0:0:0:1','2019-01-26 15:19:21'),
(269,'1','老板','查看日常收支','0:0:0:0:0:0:0:1','2019-01-26 15:19:21'),
(270,'1','老板','进入收支分类管理页面','0:0:0:0:0:0:0:1','2019-01-26 15:19:22'),
(271,'1','老板','查看收支分类','0:0:0:0:0:0:0:1','2019-01-26 15:19:22'),
(272,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:19:36'),
(273,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:19:40'),
(274,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:19:44'),
(275,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:19:47'),
(276,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:19:52'),
(277,'lihengkui','李恒逵',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:19:55'),
(278,'lihengkui','李恒逵',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:20:00'),
(279,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:20:17'),
(280,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:20:18'),
(281,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:20:19'),
(282,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:20:22'),
(283,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:20:24'),
(284,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:20:32'),
(285,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:20:32'),
(286,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:20:28'),
(287,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:20:38'),
(288,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:20:47'),
(289,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 15:21:22'),
(290,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:03'),
(291,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:03'),
(292,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:06'),
(293,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:06'),
(294,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:09'),
(295,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:10'),
(296,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:17'),
(297,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:22'),
(298,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:23'),
(299,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:23'),
(300,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:23'),
(301,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:28'),
(302,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:29'),
(303,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:33'),
(304,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:33'),
(305,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:22:37'),
(306,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:24'),
(307,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:25'),
(308,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:27'),
(309,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:28'),
(310,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:28'),
(311,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:47'),
(312,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:47'),
(313,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:50'),
(314,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:53'),
(315,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:54'),
(316,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:55'),
(317,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:58'),
(318,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:24:59'),
(319,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:25:01'),
(320,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:25:07'),
(321,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:25:08'),
(322,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:25:09'),
(323,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:25:10'),
(324,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:25:48'),
(325,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:25:48'),
(326,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:25:50'),
(327,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:25:50'),
(328,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:25:50'),
(329,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:26:42'),
(330,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:26:42'),
(331,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:26:44'),
(332,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:26:44'),
(333,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:26:44'),
(334,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:28:55'),
(335,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:28:55'),
(336,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:28:56'),
(337,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:28:56'),
(338,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:28:57'),
(339,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:30:24'),
(340,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:30:24'),
(341,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:30:26'),
(342,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:30:45'),
(343,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:30:45'),
(344,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:31:07'),
(345,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:31:07'),
(346,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:31:08'),
(347,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:31:09'),
(348,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:30:57'),
(349,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:31:42'),
(350,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:31:42'),
(351,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:32:08'),
(352,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:32:08'),
(353,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:32:11'),
(354,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:32:11'),
(355,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:32:53'),
(356,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:32:53'),
(357,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:32:40'),
(358,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:32:40'),
(359,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:32:58'),
(360,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:33:13'),
(361,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:34:22'),
(362,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:34:22'),
(363,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:34:22'),
(364,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:34:26'),
(365,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:34:26'),
(366,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:34:28'),
(367,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:34:28'),
(368,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:35:15'),
(369,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:35:16'),
(370,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:35:17'),
(371,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:35:18'),
(372,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:35:22'),
(373,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:35:26'),
(374,'1','老板',NULL,'127.0.0.1','2019-01-26 15:36:59'),
(375,'1','老板',NULL,'127.0.0.1','2019-01-26 15:37:00'),
(376,'1','老板',NULL,'127.0.0.1','2019-01-26 15:37:05'),
(377,'1','老板',NULL,'127.0.0.1','2019-01-26 15:37:05'),
(378,'1','老板',NULL,'127.0.0.1','2019-01-26 15:37:09'),
(379,'1','老板',NULL,'127.0.0.1','2019-01-26 15:37:12'),
(380,'1','老板',NULL,'127.0.0.1','2019-01-26 15:37:12'),
(381,'1','老板',NULL,'127.0.0.1','2019-01-26 15:37:43'),
(382,'1','老板',NULL,'127.0.0.1','2019-01-26 15:37:43'),
(383,'1','老板',NULL,'127.0.0.1','2019-01-26 15:37:49'),
(384,'1','老板',NULL,'127.0.0.1','2019-01-26 15:37:49'),
(385,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:39:05'),
(386,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:39:05'),
(387,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:39:06'),
(388,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:39:06'),
(389,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:39:07'),
(390,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:39:07'),
(391,'1','老板','进入收支分类管理页面','0:0:0:0:0:0:0:1','2019-01-26 15:39:12'),
(392,'1','老板','查看资金流水','0:0:0:0:0:0:0:1','2019-01-26 15:39:13'),
(393,'1','老板','进入收支分类管理页面','0:0:0:0:0:0:0:1','2019-01-26 15:39:15'),
(394,'1','老板','查看资金流水','0:0:0:0:0:0:0:1','2019-01-26 15:39:16'),
(395,'1','老板','查看资金流水','0:0:0:0:0:0:0:1','2019-01-26 15:39:18'),
(396,'1','老板','查看资金流水','0:0:0:0:0:0:0:1','2019-01-26 15:39:19'),
(397,'1','老板','查看资金流水','0:0:0:0:0:0:0:1','2019-01-26 15:39:20'),
(398,'1','老板','查看资金流水','0:0:0:0:0:0:0:1','2019-01-26 15:39:20'),
(399,'1','老板','查看资金流水','0:0:0:0:0:0:0:1','2019-01-26 15:39:25'),
(400,'1','老板','查看资金流水','0:0:0:0:0:0:0:1','2019-01-26 15:39:26'),
(401,'1','老板','查看资金流水','0:0:0:0:0:0:0:1','2019-01-26 15:39:27'),
(402,'1','老板','进入客户应收欠款页面','0:0:0:0:0:0:0:1','2019-01-26 15:39:32'),
(403,'1','老板','进入客户应收欠款页面','0:0:0:0:0:0:0:1','2019-01-26 15:39:32'),
(404,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:39:45'),
(405,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:39:46'),
(406,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:40:08'),
(407,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:40:23'),
(408,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:40:37'),
(409,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:40:37'),
(410,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:40:38'),
(411,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:40:38'),
(412,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:40:39'),
(413,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:40:39'),
(414,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:40:42'),
(415,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:40:42'),
(416,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:40:48'),
(417,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:40:49'),
(418,'1','老板','进入供应商应付欠款页面','0:0:0:0:0:0:0:1','2019-01-26 15:41:12'),
(419,'1','老板','查看供应商应付欠款信息','0:0:0:0:0:0:0:1','2019-01-26 15:41:12'),
(420,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:41:34'),
(421,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:41:34'),
(422,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:41:36'),
(423,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:41:36'),
(424,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:41:38'),
(425,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:41:38'),
(426,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:01'),
(427,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:01'),
(428,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:03'),
(429,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:03'),
(430,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:03'),
(431,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:14'),
(432,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:16'),
(433,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:16'),
(434,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:18'),
(435,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:18'),
(436,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:18'),
(437,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:27'),
(438,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:39'),
(439,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:54'),
(440,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:42:55'),
(441,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:43:08'),
(442,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:43:08'),
(443,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:43:08'),
(444,'1','老板','进入供应商应付欠款页面','0:0:0:0:0:0:0:1','2019-01-26 15:43:01'),
(445,'1','老板','查看供应商应付欠款信息','0:0:0:0:0:0:0:1','2019-01-26 15:43:01'),
(446,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:43:10'),
(447,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:43:11'),
(448,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:44:49'),
(449,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:44:50'),
(450,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:44:56'),
(451,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:45:02'),
(452,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:45:03'),
(453,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:45:03'),
(454,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:45:15'),
(455,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:45:15'),
(456,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:45:15'),
(457,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:46:11'),
(458,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:46:14'),
(459,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:46:22'),
(460,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:46:23'),
(461,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:46:24'),
(462,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:46:24'),
(463,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:46:24'),
(464,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:46:30'),
(465,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:46:36'),
(466,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:46:39'),
(467,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:48:26'),
(468,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:48:42'),
(469,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:49:10'),
(470,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:49:10'),
(471,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:23'),
(472,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:23'),
(473,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:24'),
(474,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:24'),
(475,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:24'),
(476,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:30'),
(477,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:36'),
(478,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:40'),
(479,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:41'),
(480,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:31'),
(481,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:31'),
(482,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:32'),
(483,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:32'),
(484,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:32'),
(485,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:32'),
(486,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:33'),
(487,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:33'),
(488,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:34'),
(489,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:34'),
(490,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:36'),
(491,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:36'),
(492,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:36'),
(493,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:37'),
(494,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:37'),
(495,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:50:37'),
(496,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:51:32'),
(497,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:51:38'),
(498,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:51:39'),
(499,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:51:40'),
(500,'1','老板','进入客户应收欠款页面','0:0:0:0:0:0:0:1','2019-01-26 15:51:29'),
(501,'1','老板','进入客户应收欠款页面','0:0:0:0:0:0:0:1','2019-01-26 15:51:29'),
(502,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:03'),
(503,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:03'),
(504,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:04'),
(505,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:04'),
(506,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:04'),
(507,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:04'),
(508,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:04'),
(509,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:06'),
(510,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:06'),
(511,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:06'),
(512,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:10'),
(513,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:10'),
(514,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:14'),
(515,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:14'),
(516,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:17'),
(517,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:17'),
(518,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:20'),
(519,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:21'),
(520,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:23'),
(521,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:23'),
(522,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:25'),
(523,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:25'),
(524,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:35'),
(525,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:40'),
(526,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:40'),
(527,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:54:40'),
(528,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:01'),
(529,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:01'),
(530,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:08'),
(531,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:08'),
(532,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:14'),
(533,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:14'),
(534,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:15'),
(535,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:15'),
(536,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:16'),
(537,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:16'),
(538,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:17'),
(539,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:17'),
(540,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:18'),
(541,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:18'),
(542,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:19'),
(543,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:19'),
(544,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:20'),
(545,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:20'),
(546,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:21'),
(547,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:21'),
(548,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:21'),
(549,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:22'),
(550,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:22'),
(551,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:22'),
(552,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:22'),
(553,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:55:23'),
(554,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:56:17'),
(555,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:56:17'),
(556,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:56:18'),
(557,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:56:18'),
(558,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:56:18'),
(559,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:56:45'),
(560,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:57:06'),
(561,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:57:07'),
(562,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:57:09'),
(563,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:57:09'),
(564,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:57:09'),
(565,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:08'),
(566,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:08'),
(567,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:11'),
(568,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:11'),
(569,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:14'),
(570,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:14'),
(571,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:15'),
(572,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:16'),
(573,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:17'),
(574,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:18'),
(575,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:18'),
(576,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:19'),
(577,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:19'),
(578,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:21'),
(579,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:22'),
(580,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:22'),
(581,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:23'),
(582,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:58:23'),
(583,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:21'),
(584,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:21'),
(585,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:21'),
(586,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:24'),
(587,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:26'),
(588,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:35'),
(589,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:34'),
(590,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:38'),
(591,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:36'),
(592,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:36'),
(593,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:49'),
(594,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:51'),
(595,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:51'),
(596,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:51'),
(597,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:52'),
(598,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 15:59:52'),
(599,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:01:49'),
(600,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:01:50'),
(601,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:01:57'),
(602,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:01:58'),
(603,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:01:59'),
(604,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:02:00'),
(605,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:02:14'),
(606,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:02:14'),
(607,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:02:28'),
(608,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:03:09'),
(609,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:03:05'),
(610,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:03:06'),
(611,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:03:06'),
(612,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:03:07'),
(613,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:03:07'),
(614,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:04:33'),
(615,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:04:33'),
(616,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:04:34'),
(617,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:04:34'),
(618,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:04:34'),
(619,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:04:45'),
(620,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:04:45'),
(621,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:05:07'),
(622,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:05:07'),
(623,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:05:30'),
(624,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:05:31'),
(625,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:05:33'),
(626,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:05:34'),
(627,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:06:49'),
(628,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:06:49'),
(629,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:06:53'),
(630,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:07:51'),
(631,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:07:52'),
(632,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:25'),
(633,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:25'),
(634,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:28'),
(635,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:31'),
(636,'kuikui','奎奎',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:33'),
(637,'lihengkui','李恒逵',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:38'),
(638,'lihengkui','李恒逵',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:41'),
(639,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:43'),
(640,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:49'),
(641,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:50'),
(642,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:50'),
(643,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:51'),
(644,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:08:51'),
(645,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:09:02'),
(646,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:09:02'),
(647,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:09:04'),
(648,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:09:04'),
(649,'yangmingyue','杨明月',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:09:04'),
(650,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:10:19'),
(651,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:10:19'),
(652,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:10:20'),
(653,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:10:20'),
(654,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:10:20'),
(655,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:11:41'),
(656,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:11:41'),
(657,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:11:42'),
(658,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:11:42'),
(660,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:11:37'),
(661,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:11:37'),
(662,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:11:46'),
(665,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:14:32'),
(666,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:14:33'),
(667,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:14:39'),
(668,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:15:11'),
(669,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:15:11'),
(670,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:15:18'),
(671,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:15:19'),
(672,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:15:20'),
(673,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:15:21'),
(674,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:16:07'),
(675,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:16:07'),
(676,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:16:09'),
(677,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:15:50'),
(678,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:16:10'),
(679,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:15:55'),
(680,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:15:55'),
(681,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:15:58'),
(682,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:17:21'),
(683,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:17:22'),
(684,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:17:34'),
(685,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:17:35'),
(686,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:17:35'),
(687,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:17:36'),
(689,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:18:24'),
(690,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:18:24'),
(691,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:18:34'),
(692,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:18:34'),
(693,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:19:07'),
(694,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:19:08'),
(695,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:19:12'),
(697,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:19:15'),
(698,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:19:15'),
(699,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:20:37'),
(700,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:20:37'),
(701,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:20:46'),
(702,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:20:46'),
(703,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:20:30'),
(705,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:20:34'),
(706,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:20:35'),
(707,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:20:36'),
(708,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:20:37'),
(709,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:20:38'),
(710,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:21:23'),
(711,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:21:25'),
(712,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:21:07'),
(713,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:21:08'),
(715,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:21:12'),
(716,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:21:17'),
(717,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:21:36'),
(718,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:21:36'),
(719,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:21:37'),
(720,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:21:37'),
(721,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:21:37'),
(722,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:22:23'),
(723,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:22:24'),
(724,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:22:26'),
(725,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:22:19'),
(727,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:22:24'),
(728,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:23:13'),
(730,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:23:16'),
(731,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:24:15'),
(732,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:24:16'),
(733,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:24:17'),
(734,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:24:17'),
(735,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:24:17'),
(736,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:24:12'),
(738,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:24:15'),
(739,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:24:27'),
(740,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:25:34'),
(741,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:25:34'),
(742,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:25:35'),
(743,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:25:36'),
(744,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:25:36'),
(745,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:25:56'),
(746,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:25:56'),
(747,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:25:57'),
(748,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:25:57'),
(749,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:25:57'),
(750,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:26:07'),
(751,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:26:07'),
(752,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:26:42'),
(753,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:26:43'),
(754,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:26:43'),
(755,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:27:17'),
(757,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:27:20'),
(758,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:27:47'),
(759,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:27:30'),
(760,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:27:47'),
(761,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:27:50'),
(762,'1','老板','查询商品的信息','0:0:0:0:0:0:0:1','2019-01-26 16:27:51'),
(763,'1','老板','查询商品的信息','0:0:0:0:0:0:0:1','2019-01-26 16:27:51'),
(764,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:27:53'),
(765,'1','老板','属性设置列表','0:0:0:0:0:0:0:1','2019-01-26 16:27:53'),
(766,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:27:54'),
(767,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:27:54'),
(768,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:27:56'),
(769,'1','老板','分页查询仓库','0:0:0:0:0:0:0:1','2019-01-26 16:27:56'),
(770,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:28:02'),
(771,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:28:03'),
(772,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:28:04'),
(773,'1','老板','属性设置列表','0:0:0:0:0:0:0:1','2019-01-26 16:28:04'),
(774,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:28:05'),
(775,'1','老板','查询商品的信息','0:0:0:0:0:0:0:1','2019-01-26 16:28:05'),
(776,'1','老板','查询商品的信息','0:0:0:0:0:0:0:1','2019-01-26 16:28:05'),
(777,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:28:07'),
(778,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:28:07'),
(779,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:28:19'),
(780,'1','老板','分页查询仓库','0:0:0:0:0:0:0:1','2019-01-26 16:28:19'),
(781,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:28:21'),
(782,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:28:21'),
(783,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:28:21'),
(784,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:28:22'),
(785,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:28:22'),
(786,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:28:16'),
(788,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:28:20'),
(789,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:28:24'),
(790,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:40:50'),
(791,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:40:50'),
(792,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:42:15'),
(793,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:42:15'),
(794,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:42:21'),
(795,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:42:21'),
(796,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:42:33'),
(797,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:42:33'),
(798,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:42:38'),
(799,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:42:38'),
(800,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:43:41'),
(801,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:43:41'),
(802,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:45:34'),
(803,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:45:34'),
(804,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:45:40'),
(805,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:49:02'),
(806,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:49:02'),
(807,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:49:59'),
(808,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:49:59'),
(809,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:50:00'),
(810,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:50:00'),
(811,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:50:00'),
(812,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:50:03'),
(813,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:50:05'),
(814,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:50:05'),
(815,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:50:11'),
(816,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:51:06'),
(817,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:51:06'),
(818,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:51:07'),
(819,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:51:08'),
(820,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:51:08'),
(821,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:51:10'),
(822,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:52:30'),
(823,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:52:31'),
(824,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:52:12'),
(825,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:52:13'),
(826,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:52:35'),
(827,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:52:29'),
(828,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:52:29'),
(829,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:52:30'),
(830,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:52:31'),
(831,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:52:31'),
(832,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:52:33'),
(833,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:53:34'),
(834,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:53:34'),
(835,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:53:37'),
(836,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:53:38'),
(837,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:53:38'),
(838,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:53:40'),
(839,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:53:48'),
(840,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:53:49'),
(841,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:53:50'),
(842,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:53:50'),
(843,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:53:50'),
(844,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:54:22'),
(845,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:54:22'),
(846,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:54:40'),
(847,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:54:40'),
(848,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:54:40'),
(849,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:54:42'),
(850,'1','老板','进入系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:55:15'),
(851,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:55:15'),
(852,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:56:36'),
(853,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:56:39'),
(854,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:56:42'),
(855,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:57:19'),
(856,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:59:32'),
(857,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 16:59:33'),
(866,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:00:10'),
(867,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:00:10'),
(868,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:56'),
(869,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:56'),
(870,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:56'),
(871,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:56'),
(872,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:56'),
(873,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:56'),
(874,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:57'),
(875,'1','老板','删除了一条日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:57'),
(876,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:57'),
(877,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:57'),
(878,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:58'),
(879,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:58'),
(880,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:58'),
(881,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:58'),
(882,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:58'),
(883,'1','老板','查看系统日志','0:0:0:0:0:0:0:1','2019-01-26 16:59:58'),
(884,'1','老板','进入客户应收欠款页面','0:0:0:0:0:0:0:1','2019-01-26 17:08:42'),
(885,'1','老板','进入客户应收欠款页面','0:0:0:0:0:0:0:1','2019-01-26 17:08:42'),
(886,'1','老板','进入客户应收欠款增加页面','0:0:0:0:0:0:0:1','2019-01-26 17:08:58'),
(887,'1','老板','进入客户应收欠款页面','0:0:0:0:0:0:0:1','2019-01-26 17:09:03'),
(888,'1','老板','进入客户应收欠款页面','0:0:0:0:0:0:0:1','2019-01-26 17:09:03'),
(889,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:09:55'),
(890,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:09:56'),
(891,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:09:57'),
(892,'1','老板','进入日常收支页面','0:0:0:0:0:0:0:1','2019-01-26 17:09:50'),
(893,'1','老板','查看日常收支','0:0:0:0:0:0:0:1','2019-01-26 17:09:51'),
(894,'1','老板','查看日常收支','0:0:0:0:0:0:0:1','2019-01-26 17:09:51'),
(895,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:23'),
(896,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:23'),
(897,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:23'),
(898,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:24'),
(899,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:25'),
(900,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:25'),
(901,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:25'),
(902,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:32'),
(903,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:39'),
(904,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:39'),
(905,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:41'),
(906,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:41'),
(907,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:41'),
(908,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:47'),
(909,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:55'),
(910,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:11:56'),
(911,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:12:03'),
(912,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:12:03'),
(913,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:12:04'),
(914,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:12:05'),
(915,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:12:05'),
(916,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:12:06'),
(917,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:12:07'),
(918,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:12:07'),
(919,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:12:09'),
(920,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:12:09'),
(921,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:12:09'),
(922,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:13:05'),
(923,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:13:06'),
(924,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:13:07'),
(925,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:13:07'),
(926,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:13:07'),
(927,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:13:39'),
(928,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:13:39'),
(929,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:13:57'),
(930,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:13:57'),
(931,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:13:58'),
(932,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:13:58'),
(933,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:13:58'),
(934,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:14:23'),
(935,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:14:23'),
(936,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:15:46'),
(937,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:15:46'),
(938,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:15:47'),
(939,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:15:47'),
(940,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:15:47'),
(941,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:15:50'),
(942,'1','老板',NULL,'127.0.0.1','2019-01-26 17:16:34'),
(943,'1','老板',NULL,'127.0.0.1','2019-01-26 17:16:35'),
(944,'1','老板',NULL,'127.0.0.1','2019-01-26 17:16:35'),
(945,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:16:36'),
(946,'1','老板',NULL,'127.0.0.1','2019-01-26 17:16:36'),
(947,'1','老板',NULL,'127.0.0.1','2019-01-26 17:16:40'),
(948,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:17:51'),
(949,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:17:52'),
(950,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:17:53'),
(951,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:17:53'),
(952,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:17:53'),
(953,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:18:43'),
(954,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:19:14'),
(955,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:19:14'),
(956,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:19:15'),
(957,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:19:16'),
(958,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:19:16'),
(959,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:19:25'),
(960,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:21:34'),
(961,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:21:34'),
(962,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:21:35'),
(963,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:21:35'),
(964,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:21:35'),
(965,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:22:11'),
(966,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:22:25'),
(967,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:22:25'),
(968,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:22:26'),
(969,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:22:26'),
(970,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:22:26'),
(971,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:28:39'),
(972,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:28:40'),
(973,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:28:40'),
(974,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:28:41'),
(975,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:28:41'),
(976,'1','老板','进入日常收支页面','0:0:0:0:0:0:0:1','2019-01-26 17:28:57'),
(977,'1','老板','查看日常收支','0:0:0:0:0:0:0:1','2019-01-26 17:28:57'),
(978,'1','老板','查看日常收支','0:0:0:0:0:0:0:1','2019-01-26 17:28:57'),
(979,'1','老板','进入客户应收欠款页面','0:0:0:0:0:0:0:1','2019-01-26 17:29:04'),
(980,'1','老板','进入客户应收欠款页面','0:0:0:0:0:0:0:1','2019-01-26 17:29:05'),
(981,'1','老板','进入客户应收欠款页面','0:0:0:0:0:0:0:1','2019-01-26 17:29:15'),
(982,'1','老板','进入客户应收欠款页面','0:0:0:0:0:0:0:1','2019-01-26 17:29:16'),
(983,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:56:01'),
(984,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:56:01'),
(985,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:56:02'),
(986,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:56:02'),
(987,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:56:02'),
(988,'1','老板',NULL,'0:0:0:0:0:0:0:1','2019-01-26 17:56:04');

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
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

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
(97,'饮料11','1编辑',NULL,NULL,NULL,2),
(98,'脉动','124123',NULL,NULL,NULL,2),
(99,'饮料11','1编辑',NULL,NULL,NULL,2);

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
(1,NULL,'55',NULL,'yy',NULL,NULL,NULL,NULL,NULL,NULL,'已出库'),
(2,NULL,'002',NULL,'xx',NULL,NULL,NULL,NULL,NULL,NULL,'待出库'),
(3,NULL,'003',NULL,'zz',NULL,NULL,NULL,NULL,NULL,NULL,'待出库'),
(4,NULL,'aaa',NULL,'杨1',NULL,NULL,NULL,'2019-1-9','',NULL,'待出库');

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
(1,'001','124','大','件',200,100,20,20,436.00,43600.00),
(3,'002','鞋子','大','双',200,100,0,0,100.00,100.00),
(4,'004','脉动','大','瓶',0,100,0,0,325.00,32500.00),
(5,'005','饮料11','大','瓶',0,10,0,0,124.00,1240.00),
(6,'006','羽绒衣服','大','件',0,10,0,0,124.00,1240.00),
(7,'007','零食','大','包',0,50,0,0,12.00,450.00),
(8,'008','特殊','大','特殊',0,3,0,0,214.00,642.00),
(9,'009','衣服','大','件',0,10,0,0,132.00,1320.00);

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
(1,'006','默认仓库','宋江','123144','郑州','12423145',1,'12434'),
(24,'001','郑州仓','张三','1321321','zhengzhou','451450',0,''),
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
