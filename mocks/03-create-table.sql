-- -----------------------------------------------------
-- Table `demo-shop-1`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `demo-shop-1`.`categories` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(500) NOT NULL,
  `description` TEXT(2000) NULL DEFAULT NULL,
  `is_active` BIT DEFAULT 0,
  `date_created` DATETIME(6) NOT NULL,
  `last_updated` DATETIME(6) DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;