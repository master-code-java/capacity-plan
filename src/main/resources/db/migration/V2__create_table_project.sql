CREATE TABLE `capacity`.`project` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `uuid` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `created_at` DATE,
  `updated_at` DATE);
