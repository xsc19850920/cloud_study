DROP TABLE IF EXISTS `simple_user`;
CREATE TABLE `simple_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `balance` decimal(19,2) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;