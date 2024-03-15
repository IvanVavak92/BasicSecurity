CREATE database kufrikbank;

use kufrikbank;

CREATE TABLE `users` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `username` VARCHAR(45) NOT NULL,
                         `password` VARCHAR(45) NOT NULL,
                         `enabled` INT NOT NULL,
                         PRIMARY KEY (`id`)
);

CREATE TABLE `authorities` (
                               `id` INT NOT NULL AUTO_INCREMENT,
                               `username` VARCHAR(45) NOT NULL,
                               `authority` VARCHAR(45) NOT NULL,
                               PRIMARY KEY (`id`)
);

INSERT IGNORE INTO `users` VALUES (NULL, 'happy', '12345', '1');
INSERT IGNORE INTO `authorities` VALUES  (NULL, 'happy', 'write');

CREATE TABLE `customer` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `email` varchar(45) NOT NULL,
                            `pwd` text NOT NULL,
                            `role` varchar(45) NOT NULL,
                            PRIMARY KEY(`id`)
);

insert into `customer` (`email`, `pwd`, `role` )
values('ivan@example.com','$2a$10$.reoFx5KWp3JEuK0GRwoZulE23vExgYIX4HHppH8khOH.IjEWZhNi', 'admin');