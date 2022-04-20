CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar NOT NULL,
  `age` int NOT NULL,
  `gender` varchar NOT NULL,
  `address` varchar NOT NULL,
  `phoneno` varchar NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar NOT NULL,
  `password` varchar NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `users`(username, password) VALUES('user', 'pass');