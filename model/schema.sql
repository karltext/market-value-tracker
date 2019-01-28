
CREATE SCHEMA `market_tracker`;

CREATE TABLE `market_tracker`.`roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `skill` varchar(100) NOT NULL,
  `rank` int(11) NOT NULL,
  `rank_change` int(11) NOT NULL,
  `median_salary` decimal(10,4) NOT NULL,
  `median_change` decimal(10,4) NOT NULL,
  `historical_ads` int(11) NOT NULL,
  `ad_percentage` decimal(10,4) NOT NULL,
  `live_vacancies` int(11) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`skill`)
);

  
  