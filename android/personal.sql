-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-05-2024 a las 23:11:01
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `android`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE `personal` (
  `cedula` varchar(13) NOT NULL,
  `nombre1` varchar(15) NOT NULL,
  `nombre2` varchar(15) DEFAULT NULL,
  `apellido1` varchar(15) NOT NULL,
  `apellido2` varchar(15) DEFAULT NULL,
  `direccion` varchar(150) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`cedula`, `nombre1`, `nombre2`, `apellido1`, `apellido2`, `direccion`, `telefono`, `email`) VALUES
('2-753-1259', 'ARCIA', '', ' RAUL', '', '', '6267-0000', 'raul.arcia@utp.ac.pa'),
('20-39-5362', 'AHIR', '', ' CHIRAG', '', '', '6660-0000', 'chirag.ahir@utp.ac.pa'),
('20-53-7002', 'CABRERA', '', ' ROSARIO', '', '', '6236-0000', 'rosario.cabrera@utp.ac.pa'),
('20-70-7429', 'PEREZ', '', ' MARIA', '', '', '6928-0000', 'maria.perez7@utp.ac.pa'),
('8-1000-1359', 'DE HOYOS', '', ' ANA', '', '', '6452-0000', 'ana.dehoyos@utp.ac.pa'),
('8-1000-989', 'DUQUE', '', ' MARIO', '', '', '6278-0000', 'mario.duque@utp.ac.pa'),
('8-1001-1617', 'WILLIAMS', '', ' LUIS', '', '', '6267-0000', 'luis.williams@utp.ac.pa'),
('8-1002-361', 'QUIROS', '', ' DANIELA', '', '', '6887-0000', 'daniela.quiros1@utp.ac.pa'),
('8-1004-1100', 'DE GRACIA', '', ' NOBEL', '', '', '6586-0000', 'nobel.degracia@utp.ac.pa'),
('8-1004-1431', 'ESTRADA', '', ' JOSUE', '', '', '3452-0000', 'josue.estrada@utp.ac.pa'),
('8-1004-624', 'CLAROS', '', ' JESUS', '', '', '6206-0000', 'jesus.claros@utp.ac.pa'),
('8-1007-1459', 'GIL', '', ' BENJAMIN', '', '', '6770-0000', 'benjamin.gil@utp.ac.pa'),
('8-1007-1741', 'DE GRACIA', '', ' EMILIANO', '', '', '6910-0000', 'emiliano.degracia@utp.ac.pa'),
('8-1009-525', 'RODRIGUEZ', '', ' BRAYAN', '', '', '6588-0000', 'brayan.rodriguez2@utp.ac.pa'),
('8-1014-83', 'MINA', '', ' EDWIN', '', '', '6549-0000', 'edwin.mina@utp.ac.pa'),
('8-931-444', 'SANCHEZ', '', ' ABILIO', '', '', '6558-0000', 'abilio.sanchez1@utp.ac.pa'),
('8-953-299', 'MENA', '', ' LOHANYS', '', '', '6374-0000', 'lohanys.mena@utp.ac.pa'),
('8-954-566', 'MEDINA', '', ' JOHNY', '', '', '6559-0000', 'johny.medina@utp.ac.pa'),
('8-968-2496', 'MARCHENA', '', ' ADRIAN', '', '', '6623-0000', 'adrian.marchena@utp.ac.pa'),
('8-974-1714', 'SINGH', '', ' RAM', '', '', '6781-0000', 'ram.singh@utp.ac.pa'),
('8-976-275', 'ALVARADO', '', ' CARLOS', '', '', '6449-0000', 'carlos.alvarado3@utp.ac.pa'),
('8-986-1766', 'RODRIGUEZ ', '', ' JOSUE', '', '', '6596-0000', 'josue.rodriguez13@utp.ac.pa'),
('8-987-442', 'RANGEL', '', ' ALBERTO', '', '', '6735-0000', 'alberto.rangel@utp.ac.pa'),
('8-990-1308', 'ORTIZ', '', '', '', '', '6577-0000', 'jose.ortiz12@utp.ac.pa'),
('8-991-764', 'ALONSO', '', ' PILAR', '', '', '6402-0000', 'pilar.alonso@utp.ac.pa'),
('8-993-1550', 'RIVERA', '', ' ANGEL', '', '', '6277-0000', 'angel.rivera@utp.ac.pa'),
('8-994-665', 'OVALLES', '', ' IVAN', '', '', '6407-0000', 'ivan.ovalles@utp.ac.pa'),
('8-996-623', 'ROJAS', '', ' JAIME', '', '', '6013-0000', 'jaime.rojas@utp.ac.pa'),
('8-999-1302', 'CORONADO', '', ' ROY', '', '', '6755-0000', 'roy.coronado@utp.ac.pa'),
('8-999-153', 'VASQUEZ', '', ' NOEMI', '', '', '6250-0000', 'noemi.vasquez@utp.ac.pa'),
('E-8-197254', 'MICEWICZ', '', ' GENE', '', '', '6217-0000', 'gene.micewicz@utp.ac.pa');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `personal`
--
ALTER TABLE `personal`
  ADD UNIQUE KEY `cedula` (`cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
