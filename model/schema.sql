CREATE SCHEMA `market_tracker` ;

CREATE TABLE `market_tracker`.`roles` (
  `skill` VARCHAR(45) NOT NULL,
  `rank` INT NULL,
  `rank_change` INT NULL,
  `median_salary` DECIMAL NULL,
  `median_change` DECIMAL NULL,
  `historical_ads` INT NULL,
  `percent_it_jobs` DECIMAL NULL,
  `live_vacancies` INT NULL,
  PRIMARY KEY (`id`, `skill`));