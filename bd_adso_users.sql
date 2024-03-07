-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 26-02-2024 a las 12:31:35
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_adso_users`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `born_date` date NOT NULL,
  `color` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `avatar` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `full_name`, `born_date`, `color`, `email`, `phone`, `avatar`) VALUES
(42, 'Gustavo Adolfo', '2008-01-01', '#b73434', 'gaby124@misena.edu.co', '8382057', NULL),
(43, 'Gustavo Rodriguez', '1991-01-01', '#e60000', 'garodriguez335@misena.edu.co', '3116469800', NULL),
(44, 'adad', '2024-02-01', '#ca5858', 'af@asd.co', '123123123', NULL),
(45, 'asdasd', '2024-02-16', '#d82222', 'ad@cc.co', '123123123', NULL),
(46, 'asdasdad', '2000-01-01', '#bb1b1b', 'asdasd@sdasd.com', '123123123', NULL),
(47, 'CCCC', '2222-01-01', '#d10000', 'gfassad@aasdasd.com', '123123123', NULL),
(48, 'dsasdasd', '2000-01-01', '#000000', 'aadasd@asdasd.com', '123234234', NULL),
(49, 'test', '1991-01-01', '#1bc045', 'xxx@asdasd.com', '12312313', '1176.7440237761584-e9572a70726980ed5445c02e1058760b.jpg'),
(52, 'test test', '1991-01-01', '#ffd780', 'ttt@asd.com', '123123123', '2335.7601201979974-123.webp');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
