create database melt2;

CREATE TABLE `employees` (
  `employeeId` int NOT NULL,
  `employeeName` varchar(30) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `dept` double DEFAULT NULL,
  `phoneNumber` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  KEY `userId` (`userId`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `itemlist` (
  `menuId` int NOT NULL AUTO_INCREMENT,
  `menuTitle` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `items` (
  `itemId` int NOT NULL AUTO_INCREMENT,
  `itemTitle` varchar(40) DEFAULT NULL,
  `itemPrice` double DEFAULT NULL,
  `menuId` int DEFAULT NULL,
  PRIMARY KEY (`itemId`),
  KEY `menuId` (`menuId`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`menuId`) REFERENCES `itemlist` (`menuId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `login` (
  `loginId` int NOT NULL,
  `loginDate` date DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`loginId`),
  KEY `userId` (`userId`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders` (
  `orderId` int NOT NULL AUTO_INCREMENT,
  `orderType` varchar(25) DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `paymentMethod` varchar(25) DEFAULT NULL,
  `address` varchar(35) DEFAULT NULL,
  `phoneNumber` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `userId` (`userId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders_items` (
  `orderId` int NOT NULL,
  `itemId` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `itemPrice` double DEFAULT NULL,
  PRIMARY KEY (`orderId`,`itemId`),
  KEY `itemId` (`itemId`),
  CONSTRAINT `orders_items_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orders_items_ibfk_2` FOREIGN KEY (`itemId`) REFERENCES `items` (`itemId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `roles` (
  `roleId` int NOT NULL,
  `roleTitle` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `userId` int NOT NULL,
  `userName` varchar(25) DEFAULT NULL,
  `userPassword` varchar(25) DEFAULT NULL,
  `userRoleId` int DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `userRoleId` (`userRoleId`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`userRoleId`) REFERENCES `roles` (`roleId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;