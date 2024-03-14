-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 14, 2024 at 02:43 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd_adso_users`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `user_id` int(11) NOT NULL,
  `fee_id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `value` int(11) NOT NULL,
  `parking_service_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `fee`
--

CREATE TABLE `fee` (
  `id` int(11) NOT NULL,
  `value` int(11) NOT NULL,
  `type` enum('HORA','DIA','SEMANA','MES') NOT NULL,
  `date` date NOT NULL,
  `reference_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fee`
--

INSERT INTO `fee` (`id`, `value`, `type`, `date`, `reference_type`) VALUES
(1, 1000, 'HORA', '2024-03-13', 1),
(2, 20000, 'DIA', '2024-03-13', 1),
(3, 50000, 'SEMANA', '2024-03-13', 1),
(4, 100000, 'MES', '2024-03-13', 1),
(5, 1500, 'HORA', '2024-03-13', 2),
(6, 30000, 'DIA', '2024-03-13', 2),
(7, 60000, 'SEMANA', '2024-03-13', 2),
(8, 120000, 'MES', '2024-03-13', 2),
(9, 5000, 'HORA', '2024-03-13', 3),
(10, 80000, 'DIA', '2024-03-13', 3),
(11, 180000, 'SEMANA', '2024-03-13', 3),
(12, 300000, 'MES', '2024-03-13', 3);

-- --------------------------------------------------------

--
-- Table structure for table `parking_service`
--

CREATE TABLE `parking_service` (
  `id` int(11) NOT NULL,
  `income_date` datetime NOT NULL,
  `exit_date` datetime DEFAULT NULL,
  `vehicle_id` int(11) NOT NULL,
  `zone_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `income_user_id` int(11) NOT NULL,
  `exit_user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `reference_type`
--

CREATE TABLE `reference_type` (
  `id` int(11) NOT NULL,
  `title` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reference_type`
--

INSERT INTO `reference_type` (`id`, `title`) VALUES
(2, 'AUTOMOVIL'),
(3, 'CARRO PESADO'),
(1, 'MOTO');

-- --------------------------------------------------------

--
-- Table structure for table `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `title` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rol`
--

INSERT INTO `rol` (`id`, `title`) VALUES
(1, 'ADMIN'),
(2, 'AUX'),
(3, 'CLIENT');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `full_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `born_date` date NOT NULL,
  `color` varchar(10) COLLATE utf8_bin NOT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  `phone` varchar(15) COLLATE utf8_bin NOT NULL,
  `avatar` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `rol_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `full_name`, `born_date`, `color`, `email`, `phone`, `avatar`, `password`, `rol_id`) VALUES
(1, 'Albany', '2024-02-26', '#999', 'admin@sena.edu.co', '12312312313', '1-juan123-avatar.png', '', 3),
(2, 'Gustavo Adolfo', '2000-01-01', '#c22e2e', 'garodriguez335@misena.edu.co', '8382057', '9069.021498058155-x2.jpg', '', 2),
(3, 'Gaby', '1990-01-01', '#1630b1', 'julianurrutia554@gmail.com', '45645456456', '3306.702573977841-x1.png', '', 1);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL,
  `color` varchar(10) NOT NULL,
  `plate` varchar(10) NOT NULL,
  `brand` varchar(20) NOT NULL,
  `description` text NOT NULL,
  `reference_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `zone`
--

CREATE TABLE `zone` (
  `id` int(11) NOT NULL,
  `title` varchar(15) NOT NULL,
  `status` enum('ACTIVO','INACTIVO') NOT NULL,
  `reference_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `zone`
--

INSERT INTO `zone` (`id`, `title`, `status`, `reference_type_id`) VALUES
(1, 'A1', 'ACTIVO', 2),
(2, 'A2', 'ACTIVO', 2),
(3, 'A3', 'ACTIVO', 2),
(4, 'A4', 'ACTIVO', 2),
(5, 'A5', 'ACTIVO', 2),
(6, 'A6', 'ACTIVO', 2),
(7, 'A7', 'ACTIVO', 2),
(8, 'A8', 'ACTIVO', 2),
(9, 'A9', 'ACTIVO', 2),
(10, 'A10', 'ACTIVO', 2),
(17, 'C1', 'ACTIVO', 3),
(18, 'C2', 'ACTIVO', 3),
(19, 'C3', 'ACTIVO', 3),
(20, 'C4', 'ACTIVO', 3),
(21, 'C5', 'ACTIVO', 3),
(22, 'M1', 'ACTIVO', 1),
(23, 'M2', 'ACTIVO', 1),
(24, 'M3', 'ACTIVO', 1),
(25, 'M4', 'ACTIVO', 1),
(26, 'M5', 'ACTIVO', 1),
(27, 'M6', 'ACTIVO', 1),
(28, 'M7', 'ACTIVO', 1),
(29, 'M8', 'ACTIVO', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD KEY `user_id` (`user_id`),
  ADD KEY `fee_id` (`fee_id`),
  ADD KEY `parking_service_id` (`parking_service_id`);

--
-- Indexes for table `fee`
--
ALTER TABLE `fee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `reference_type` (`reference_type`);

--
-- Indexes for table `parking_service`
--
ALTER TABLE `parking_service`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vehicle_id` (`vehicle_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `income_user_id` (`income_user_id`),
  ADD KEY `exit_user_id` (`exit_user_id`),
  ADD KEY `zone_id` (`zone_id`);

--
-- Indexes for table `reference_type`
--
ALTER TABLE `reference_type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `title` (`title`);

--
-- Indexes for table `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `title` (`title`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `rol_id` (`rol_id`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `brand` (`brand`),
  ADD KEY `type_id` (`reference_type_id`);

--
-- Indexes for table `zone`
--
ALTER TABLE `zone`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `title` (`title`),
  ADD KEY `reference_type_id` (`reference_type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fee`
--
ALTER TABLE `fee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `parking_service`
--
ALTER TABLE `parking_service`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reference_type`
--
ALTER TABLE `reference_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `zone`
--
ALTER TABLE `zone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `fk_bill_fee` FOREIGN KEY (`fee_id`) REFERENCES `fee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_bill_parking_service` FOREIGN KEY (`parking_service_id`) REFERENCES `parking_service` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_bill_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `fee`
--
ALTER TABLE `fee`
  ADD CONSTRAINT `fk_fee_reference_type` FOREIGN KEY (`reference_type`) REFERENCES `reference_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `parking_service`
--
ALTER TABLE `parking_service`
  ADD CONSTRAINT `fk_parking_service_customer` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_parking_service_exit_user` FOREIGN KEY (`exit_user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_parking_service_income_user` FOREIGN KEY (`income_user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_parking_service_vehicle` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_parking_service_zone` FOREIGN KEY (`zone_id`) REFERENCES `zone` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_rol` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD CONSTRAINT `fk_vehicle_reference_type` FOREIGN KEY (`reference_type_id`) REFERENCES `reference_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `zone`
--
ALTER TABLE `zone`
  ADD CONSTRAINT `fk_zone_reference_type` FOREIGN KEY (`reference_type_id`) REFERENCES `reference_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
