-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 03, 2025 at 03:21 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tarea2`
--

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `nombre`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(64) NOT NULL,
  `email` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `email`, `password`) VALUES
(1, 'sebas', 'sebas@sebas.com', '$2a$10$TRfp.xTz/R3EBhQYH6jzeO73N7JcajCs0nee7uoszvudkSaL9Bnxi'),
(2, 'ale', 'ale@gmail.com', '$2a$10$vnY21B1mYFzHkrQqn8mVp.HonsjKvoDd5NSw.hEIm3BAcL/8eYcbK'),
(3, 'erick', 'erick@gmail.com', '$2a$10$FgCDoRbGlhPLLvPV4oYgX.hZlqVPJjdX74XfvRkMHOiKdFEi5bTp2'),
(10, 'kevin', 'kevin@gmail.com', '$2a$10$tccohou5USOHWrxUykWOgO3kxA4CWimY5Ejo7clEz5qsCSyQY1uby'),
(11, 'jesus', 'jesus@gmail.com', '$2a$10$DVDcGR.Ta7t4hgV/eeP6SOzJQWCs.WSXVk3TeQXRij25KPu01Wavm'),
(12, 'gael', 'gael@gmail.com', '$2a$10$Dy7ZvhOfD6RcD6SyM8LiUum.SyN9NCmHBProX7dOrjD2WPYmC3G2i'),
(13, 'rosie', 'rosie@gmail.com', '$2a$10$7l38T/a3tZuFg98Q52YsFukjRsZwGrtHULevHGAVUxTNnJzsu14Hq'),
(14, 'ania', 'ania@gmail.com', '$2a$10$hCzqYn8GRfO6qp6pP.S4wOOOJQbRGpqNmpkv978Q7d6yB6hR2lbOS'),
(16, 'Karen', 'karen@gmail.com', '$2a$10$hex6DAyVuYGmoT8UYquIyOnHA2O2TJ.vd8SWFgCoxeX5zNqCVDZ1m'),
(17, 'PostMan', 'Postman@gmail.com', '$2a$10$5SB976CfPu3OHAIJyKpxVu26rOwHsO92H0yuuZMA/WgMXQVZJ4mqK');

-- --------------------------------------------------------

--
-- Table structure for table `usuario_roles`
--

CREATE TABLE `usuario_roles` (
  `usuario_id` bigint(20) NOT NULL,
  `rol_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `usuario_roles`
--

INSERT INTO `usuario_roles` (`usuario_id`, `rol_id`) VALUES
(1, 1),
(2, 2),
(3, 2),
(10, 2),
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(16, 2),
(17, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `usuario_roles`
--
ALTER TABLE `usuario_roles`
  ADD PRIMARY KEY (`usuario_id`,`rol_id`),
  ADD KEY `rol_id` (`rol_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `usuario_roles`
--
ALTER TABLE `usuario_roles`
  ADD CONSTRAINT `usuario_roles_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `usuario_roles_ibfk_2` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
