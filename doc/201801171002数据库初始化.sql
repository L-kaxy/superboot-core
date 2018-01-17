/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.10-log : Database - superboot
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`superboot` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `superboot`;

/*Table structure for table `t_systemconfig` */

DROP TABLE IF EXISTS `t_systemconfig`;

CREATE TABLE `t_systemconfig` (
  `systemconfigid` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '系统配置编号',
  `configname` varchar(32) NOT NULL COMMENT '配置项',
  `configvalue` varchar(215) DEFAULT NULL COMMENT '配置值',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creatorid` bigint(16) NOT NULL DEFAULT '0' COMMENT '创建人',
  `editetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `editorid` bigint(16) DEFAULT NULL COMMENT '修改人',
  `isdelete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `islockup` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否冻结',
  `version` bigint(32) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`systemconfigid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_systemconfig` */

insert  into `t_systemconfig`(`systemconfigid`,`configname`,`configvalue`,`createtime`,`creatorid`,`editetime`,`editorid`,`isdelete`,`islockup`,`version`) values (1,'realm','com.wteamfly.superW.security.realm.ActionRealm','2017-11-15 09:49:32',1,'2017-11-15 09:49:32',NULL,0,0,0),(2,'realm','com.wteamfly.superW.security.realm.LoggingRealm','2017-11-15 09:49:32',1,'2017-11-15 09:49:32',NULL,0,0,0);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `userid` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creatorid` bigint(16) NOT NULL DEFAULT '0' COMMENT '创建人',
  `editetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `editorid` bigint(16) DEFAULT NULL COMMENT '修改人',
  `isdelete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `islockup` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否冻结',
  `version` bigint(32) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`userid`,`username`,`createtime`,`creatorid`,`editetime`,`editorid`,`isdelete`,`islockup`,`version`) values (1,'Sysadmin','2017-11-15 09:49:31',1,'2017-11-15 09:49:31',NULL,0,0,0),(2,'test','2017-11-27 16:04:44',1,'2017-11-27 16:04:45',NULL,0,0,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
