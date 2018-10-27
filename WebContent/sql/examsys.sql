-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 2018-08-07 14:01:20
-- 服务器版本： 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `examsys`
--

-- --------------------------------------------------------

--
-- 表的结构 `answer`
--

drop database if exists ExamSys;
create database ExamSys character set utf8;
use ExamSys;

DROP TABLE IF EXISTS `answer`;
CREATE TABLE IF NOT EXISTS `answer` (
  `user_id` int(11) NOT NULL,
  `Exam_id` int(11) NOT NULL,
  `Ans_id` int(11) NOT NULL,
  `ans_begin` datetime NOT NULL,
  `ans_end` datetime NOT NULL,
  `error_sum` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`Exam_id`,`Ans_id`),
  KEY `Exam_id` (`Exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `answer`
--

INSERT INTO `answer` (`user_id`, `Exam_id`, `Ans_id`, `ans_begin`, `ans_end`, `error_sum`) VALUES
(2016834101, 1, 1, '2018-02-01 10:00:00', '2018-02-01 10:02:00', 0),
(2016834101, 1, 2, '2018-02-01 10:03:00', '2018-02-01 10:05:00', 1),
(2016834101, 1, 3, '2018-02-01 10:05:00', '2018-02-01 10:10:00', 0);

-- --------------------------------------------------------

--
-- 表的结构 `class`
--

DROP TABLE IF EXISTS `class`;
CREATE TABLE IF NOT EXISTS `class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `class`
--

INSERT INTO `class` (`class_id`, `class_name`) VALUES
(1, '16生本1'),
(2, '16生本2'),
(3, '16烹饪1'),
(4, '16园艺'),
(5, '16烹饪2');

-- --------------------------------------------------------

--
-- 表的结构 `examination`
--

DROP TABLE IF EXISTS `examination`;
CREATE TABLE IF NOT EXISTS `examination` (
  `Exam_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `Exam_name` varchar(20) NOT NULL,
  `Exam_begin` datetime DEFAULT NULL,
  `Exam_end` datetime DEFAULT NULL,
  PRIMARY KEY (`Exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `examination`
--

INSERT INTO `examination` (`Exam_id`, `user_id`, `Exam_name`, `Exam_begin`, `Exam_end`) VALUES
(1, 101, '烹饪2017-2018期中考试', '2018-01-01 00:00:00', '2018-03-05 00:00:00'),
(2, 101, '园艺2017-2018期末考试', '2018-06-01 00:00:00', '2018-07-08 00:00:00'),
(3, 102, '生物2018-2019期中考试', '2018-09-10 00:00:00', '2019-01-01 00:00:00'),
(4, 101, '烹饪2018-2019期末考试', '2018-03-10 00:00:00', '2019-05-15 00:00:00'),
(5, 102, '生物2018-2019期末考试', '2018-03-10 00:00:00', '2019-05-10 00:00:00');

-- --------------------------------------------------------

--
-- 表的结构 `mission`
--

DROP TABLE IF EXISTS `mission`;
CREATE TABLE IF NOT EXISTS `mission` (
  `user_id` int(11) NOT NULL,
  `Exam_id` int(11) NOT NULL,
  `finish_flag` varchar(20) DEFAULT '未完成',
  PRIMARY KEY (`user_id`,`Exam_id`),
  KEY `Exam_id` (`Exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `mission`
--

INSERT INTO `mission` (`user_id`, `Exam_id`, `finish_flag`) VALUES
(2016834101, 1, '完成'),
(2016834101, 2, '未完成');

-- --------------------------------------------------------

--
-- 表的结构 `question_bank`
--

DROP TABLE IF EXISTS `question_bank`;
CREATE TABLE IF NOT EXISTS `question_bank` (
  `Que_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `Que_chapter` int(11) DEFAULT NULL,
  `Que_type` varchar(20) NOT NULL DEFAULT '单选',
  `Que_content` varchar(500) NOT NULL,
  `Que_answer` varchar(200) NOT NULL,
  `Que_url` varchar(200) NOT NULL,
  PRIMARY KEY (`Que_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `question_bank`
--

INSERT INTO `question_bank` (`Que_id`, `user_id`, `Que_chapter`, `Que_type`, `Que_content`, `Que_answer`, `Que_url`) VALUES
(1, 101, 1, '单选', 'adafcsdavef', 'A', 'C:'),
(2, 101, 1, '单选', 'vgdfbrgnthn', 'B', 'C:'),
(3, 101, 2, '多选', 'xzfvfdbgdb', 'AB', 'C:'),
(4, 102, 2, '多选', 'fcwdvcefav', 'BCD', 'C:'),
(5, 102, 3, '单选', 'sadfcdverg', 'D', 'C:');

-- --------------------------------------------------------

--
-- 表的结构 `que_exam`
--

DROP TABLE IF EXISTS `que_exam`;
CREATE TABLE IF NOT EXISTS `que_exam` (
  `Que_id` int(11) NOT NULL,
  `Exam_id` int(11) NOT NULL,
  PRIMARY KEY (`Que_id`,`Exam_id`),
  KEY `Exam_id` (`Exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `que_exam`
--

INSERT INTO `que_exam` (`Que_id`, `Exam_id`) VALUES
(1, 1),
(3, 1),
(4, 1),
(3, 2),
(5, 2),
(2, 3),
(4, 3),
(5, 3);

-- --------------------------------------------------------

--
-- 表的结构 `record`
--

DROP TABLE IF EXISTS `record`;
CREATE TABLE IF NOT EXISTS `record` (
  `user_id` int(11) NOT NULL,
  `Exam_id` int(11) NOT NULL,
  `Que_id` int(11) NOT NULL,
  `Error_flag` int(11) NOT NULL DEFAULT '0',
  `time` datetime NOT NULL,
  PRIMARY KEY (`user_id`,`Exam_id`,`Que_id`),
  KEY `Exam_id` (`Exam_id`),
  KEY `Que_id` (`Que_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `record`
--

INSERT INTO `record` (`user_id`, `Exam_id`, `Que_id`, `Error_flag`, `time`) VALUES
(2016834101, 1, 1, 0, '2018-02-02 10:25:00'),
(2016834101, 1, 3, 0, '2018-02-02 10:25:00'),
(2016834101, 1, 4, 0, '2018-02-02 10:25:00');

-- --------------------------------------------------------

--
-- 表的结构 `stu_class`
--

DROP TABLE IF EXISTS `stu_class`;
CREATE TABLE IF NOT EXISTS `stu_class` (
  `user_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`class_id`),
  KEY `class_id` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `stu_class`
--

INSERT INTO `stu_class` (`user_id`, `class_id`) VALUES
(2016834101, 1),
(2016834102, 1);

-- --------------------------------------------------------

--
-- 表的结构 `tea_class`
--

DROP TABLE IF EXISTS `tea_class`;
CREATE TABLE IF NOT EXISTS `tea_class` (
  `user_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`class_id`),
  KEY `class_id` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tea_class`
--

INSERT INTO `tea_class` (`user_id`, `class_id`) VALUES
(101, 1),
(102, 1),
(101, 2),
(102, 3),
(101, 4);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL,
  `user_pwd` varchar(20) NOT NULL,
  `user_name` varchar(10) NOT NULL,
  `supervalue` int(11) NOT NULL,
  `blocked_flag` int(11) NOT NULL,
  `blocked_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`user_id`, `user_pwd`, `user_name`, `supervalue`, `blocked_flag`, `blocked_time`) VALUES
(101, '123456', '教师A', 2, 0, NULL),
(102, '123456', '教师B', 2, 0, NULL),
(100000, '123456', '管理员A', 3, 0, NULL),
(2016834101, '123456', '张三', 1, 0, NULL),
(2016834102, '123456', '李四', 1, 0, NULL);

--
-- 限制导出的表
--

--
-- 限制表 `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `answer_ibfk_2` FOREIGN KEY (`Exam_id`) REFERENCES `examination` (`Exam_id`);

--
-- 限制表 `mission`
--
ALTER TABLE `mission`
  ADD CONSTRAINT `mission_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `mission_ibfk_2` FOREIGN KEY (`Exam_id`) REFERENCES `examination` (`Exam_id`);

--
-- 限制表 `que_exam`
--
ALTER TABLE `que_exam`
  ADD CONSTRAINT `que_exam_ibfk_1` FOREIGN KEY (`Que_id`) REFERENCES `question_bank` (`Que_id`),
  ADD CONSTRAINT `que_exam_ibfk_2` FOREIGN KEY (`Exam_id`) REFERENCES `examination` (`Exam_id`);

--
-- 限制表 `record`
--
ALTER TABLE `record`
  ADD CONSTRAINT `record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `record_ibfk_2` FOREIGN KEY (`Exam_id`) REFERENCES `examination` (`Exam_id`),
  ADD CONSTRAINT `record_ibfk_3` FOREIGN KEY (`Que_id`) REFERENCES `question_bank` (`Que_id`);

--
-- 限制表 `stu_class`
--
ALTER TABLE `stu_class`
  ADD CONSTRAINT `stu_class_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `stu_class_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);

--
-- 限制表 `tea_class`
--
ALTER TABLE `tea_class`
  ADD CONSTRAINT `tea_class_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `tea_class_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
