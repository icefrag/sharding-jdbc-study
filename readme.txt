#init mysql
CREATE TABLE `t_order0` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;