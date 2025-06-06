-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2025 a las 04:30:46
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
-- Base de datos: `sistema-entrada`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `saladecine`
--

CREATE TABLE `saladecine` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `edad` int(11) NOT NULL,
  `tipo_entrada` varchar(50) NOT NULL,
  `asientos` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `saladecine`
--

INSERT INTO `saladecine` (`id`, `nombre`, `edad`, `tipo_entrada`, `asientos`) VALUES
(1, 'f', 67, 'Entrada General', ''),
(2, 'carlos', 21, 'Entrada para Estudiantes', ''),
(3, 'Jose', 23, 'Entrada General', 'B3,'),
(4, 'Maria', 16, 'Entrada para Estudiantes', 'B10,'),
(5, 'Pedro', 32, 'Entrada VIP', 'E7,'),
(6, 'Karen', 22, 'Entrada para Estudiantes', 'C9'),
(7, 'Flabia', 46, 'Entrada VIP', 'E3'),
(8, 'Kevin', 26, 'Entrada para Estudiantes', 'A10');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `saladecine`
--
ALTER TABLE `saladecine`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `saladecine`
--
ALTER TABLE `saladecine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
