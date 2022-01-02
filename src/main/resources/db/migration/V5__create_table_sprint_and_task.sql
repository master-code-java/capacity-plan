CREATE TABLE `capacity`.`sprint_and_task` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `sprint_uuid` VARCHAR(45) NOT NULL,
  `task_uuid` VARCHAR(45) NOT NULL,
  `created_at` DATE,
  `updated_at` DATE);