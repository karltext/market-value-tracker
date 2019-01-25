CREATE SCHEMA `market_tracker` ;

CREATE TABLE `market_tracker`.`roles` (
  `id` INT NOT NULL,
  `skill` VARCHAR(45) NOT NULL,
  `rank` INT NULL,
  `rank_change` INT NULL,
  `median_salary` DOUBLE NULL,
  `median_change` DOUBLE NULL,
  `historical_ads` INT NULL,
  `ad_percentage` DOUBLE NULL,
  `live_vacancies` INT NULL,
  `updated` DATE NULL,
  PRIMARY KEY (`id`, `skill`));
  