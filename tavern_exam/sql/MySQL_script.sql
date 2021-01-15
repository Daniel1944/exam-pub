CREATE DATABASE `tavern`;
CREATE TABLE `drink_menu` (
                              `drink_id` int NOT NULL,
                              `product_name` varchar(45) NOT NULL,
                              `price` float NOT NULL,
                              `is_for_adult` tinyint NOT NULL,
                              PRIMARY KEY (`drink_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `order` (
                         `id` int NOT NULL,
                         `amount` int NOT NULL,
                         `user_id` int NOT NULL,
                         `drink_id` int NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `user` (
                        `user_id` int NOT NULL,
                        `name` varchar(45) NOT NULL,
                        `is_adult` tinyint NOT NULL,
                        `is_active` tinyint NOT NULL,
                        `money` float NOT NULL,
                        `admin_token` tinyint NOT NULL,
                        PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
