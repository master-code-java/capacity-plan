CREATE TABLE `capacity`.`sprint` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `uuid` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `start_date` DATE,
  `end_date` DATE,
  `created_at` DATE,
  `updated_at` DATE);