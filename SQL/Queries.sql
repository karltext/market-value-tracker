CREATE SCHEMA `market_tracker` ;

CREATE TABLE `market_tracker`.`roles` (
  `skill` VARCHAR(45) NOT NULL,
  `rank` INT NULL,
  `rank_change` INT NULL,
  `median_salary` DOUBLE NULL,
  `median_change` DOUBLE NULL,
  `historical_ads` INT NULL,
  `percent_it_jobs` DOUBLE NULL,
  `live_vacancies` INT NULL,
  PRIMARY KEY (`skill`));