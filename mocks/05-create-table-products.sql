-- -----------------------------------------------------
-- Table `demo-shop-1`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `demo-shop-1`.`products` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `sku` VARCHAR(255) NOT NULL,
  `name` VARCHAR(500) NOT NULL,
  `category_id` BIGINT(20) NOT NULL,
  `description` TEXT(2000) DEFAULT NULL,
  `image_url` VARCHAR(255) DEFAULT NULL,
  `unit_price` DECIMAL(13,2) NOT NULL,
  `is_active` BIT DEFAULT 0,
  `units_in_stock` INT(11) NOT NULL,
  `date_created` DATETIME(6) NOT NULL,
  `last_updated` DATETIME(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category` (`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;