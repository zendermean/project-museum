
-- Дамп структуры базы данных museum5
CREATE DATABASE IF NOT EXISTS `museum5` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `museum5`;

-- Дамп структуры для таблица museum5.authors
CREATE TABLE IF NOT EXISTS `authors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `surname` varchar(50) NOT NULL DEFAULT '0',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Экспортируемые данные не выделены.

-- Дамп структуры для таблица museum5.author_exhibit
CREATE TABLE IF NOT EXISTS `author_exhibit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `exhibit_id` bigint NOT NULL,
  `author_id` bigint NOT NULL,
  KEY `id` (`id`),
  KEY `exhibit` (`exhibit_id`),
  KEY `author` (`author_id`),
  CONSTRAINT `author` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`),
  CONSTRAINT `exhibit` FOREIGN KEY (`exhibit_id`) REFERENCES `exhibits` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Экспортируемые данные не выделены.

-- Дамп структуры для таблица museum5.excursions
CREATE TABLE IF NOT EXISTS `excursions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `time_start` datetime NOT NULL,
  `time_end` datetime NOT NULL,
  `worker_id` bigint NOT NULL,
  KEY `id` (`id`),
  KEY `worker` (`worker_id`),
  CONSTRAINT `worker` FOREIGN KEY (`worker_id`) REFERENCES `workers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Экспортируемые данные не выделены.

-- Дамп структуры для таблица museum5.excursion_room
CREATE TABLE IF NOT EXISTS `excursion_room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `excursion_id` bigint NOT NULL DEFAULT '0',
  `room_id` bigint NOT NULL DEFAULT '0',
  KEY `id` (`id`),
  KEY `excursion` (`excursion_id`),
  KEY `room1` (`room_id`),
  CONSTRAINT `excursion` FOREIGN KEY (`excursion_id`) REFERENCES `excursions` (`id`),
  CONSTRAINT `room1` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Экспортируемые данные не выделены.

-- Дамп структуры для таблица museum5.exhibits
CREATE TABLE IF NOT EXISTS `exhibits` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `room_id` bigint NOT NULL DEFAULT '0',
  `technique_id` bigint NOT NULL DEFAULT '0',
  KEY `id` (`id`),
  KEY `room` (`room_id`),
  KEY `technique` (`technique_id`),
  CONSTRAINT `room` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `technique` FOREIGN KEY (`technique_id`) REFERENCES `techniques` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Экспортируемые данные не выделены.

-- Дамп структуры для таблица museum5.materials
CREATE TABLE IF NOT EXISTS `materials` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Экспортируемые данные не выделены.

-- Дамп структуры для таблица museum5.material_exhibit
CREATE TABLE IF NOT EXISTS `material_exhibit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `exhibit_id` bigint NOT NULL,
  `material_id` bigint NOT NULL,
  KEY `id` (`id`),
  KEY `FKssagifbgd6wc6thy8cimvkwyd` (`material_id`),
  KEY `FKo5tudpxecc0e6wain6h9os87r` (`exhibit_id`),
  CONSTRAINT `FKo5tudpxecc0e6wain6h9os87r` FOREIGN KEY (`exhibit_id`) REFERENCES `exhibits` (`id`),
  CONSTRAINT `FKssagifbgd6wc6thy8cimvkwyd` FOREIGN KEY (`material_id`) REFERENCES `materials` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Экспортируемые данные не выделены.

-- Дамп структуры для таблица museum5.rooms
CREATE TABLE IF NOT EXISTS `rooms` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `number` int NOT NULL DEFAULT '0',
  `floor` int NOT NULL DEFAULT '0',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Экспортируемые данные не выделены.

-- Дамп структуры для таблица museum5.techniques
CREATE TABLE IF NOT EXISTS `techniques` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '0',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Экспортируемые данные не выделены.

-- Дамп структуры для таблица museum5.workers
CREATE TABLE IF NOT EXISTS `workers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `position` varchar(10) NOT NULL DEFAULT 'GUARDIAN',
  `name` varchar(50) NOT NULL DEFAULT '0',
  `surname` varchar(50) NOT NULL DEFAULT '0',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
