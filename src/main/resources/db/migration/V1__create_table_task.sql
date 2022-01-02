CREATE TABLE `capacity`.`task` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `uuid` VARCHAR(45) NOT NULL,
  `identifier` VARCHAR(45) NOT NULL,
  `summary` VARCHAR(45) NOT NULL,
  `estimation` VARCHAR(45) NULL,
  `assigne_uuid` VARCHAR(45) NOT NULL,
  `project_uuid` VARCHAR(45) NULL,
  `created_at` DATE,
  `updated_at` DATE);