-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 09-05-2021 a las 14:46:37
-- Versión del servidor: 5.6.41-84.1
-- Versión de PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `raksodev_automundopruebas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autos`
--

CREATE TABLE `autos` (
  `autos_id` int(1) DEFAULT NULL,
  `telefonoCliente` varchar(15) NOT NULL,
  `modelo` varchar(90) NOT NULL,
  `año` varchar(90) NOT NULL,
  `color` varchar(90) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `autos`
--

INSERT INTO `autos` (`autos_id`, `telefonoCliente`, `modelo`, `año`, `color`) VALUES
(NULL, '6692730661', 'Jetta', '2014', 'Gris'),
(NULL, '6692730661', 'Civic', '2013', 'Gris'),
(NULL, '6691005500', 'Jetta R Line', '2020', 'Gris'),
(NULL, '6619005500', 'Tsuru', '2002', 'negro'),
(NULL, '6691005500', 'Tsuru', 'Negro', 'negro'),
(NULL, 'a1232321312', 'a', 'a', 'a'),
(NULL, '6692730661', 'Sentra', '2010', 'Negro'),
(NULL, '01111', 'Jetta R Line', '2019', 'Rojo'),
(NULL, '6692446934', 'JETTA', '1997', 'DORADO'),
(NULL, '6692730661', 'Civic', '2013', 'Gris');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombreCliente` varchar(50) DEFAULT NULL,
  `telefonoCliente` varchar(15) NOT NULL,
  `marca` varchar(40) DEFAULT NULL,
  `modelo` varchar(40) DEFAULT NULL,
  `año` varchar(40) DEFAULT NULL,
  `color` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notaremision`
--

CREATE TABLE `notaremision` (
  `folio` int(11) NOT NULL,
  `nombreCliente` varchar(50) NOT NULL,
  `telefonoCliente` varchar(40) NOT NULL,
  `rFecha` varchar(50) NOT NULL,
  `rMarca` varchar(50) NOT NULL,
  `rModelo` varchar(100) NOT NULL,
  `rColor` varchar(50) NOT NULL,
  `rCantidad` int(11) NOT NULL,
  `rCantidad2` int(11) NOT NULL,
  `rCantidad3` int(11) NOT NULL,
  `rCantidad4` int(11) NOT NULL,
  `rCantidad5` int(11) NOT NULL,
  `rCantidad6` int(11) NOT NULL,
  `rCantidad7` int(11) NOT NULL,
  `rCantidad8` int(11) NOT NULL,
  `rCantidad9` int(11) NOT NULL,
  `rCantidad10` int(11) NOT NULL,
  `rCantidad11` int(11) NOT NULL,
  `rCantidad12` int(11) NOT NULL,
  `rCantidad13` int(11) NOT NULL,
  `rCantidad14` int(11) NOT NULL,
  `rCantidad15` int(11) NOT NULL,
  `rCantidad16` int(11) NOT NULL,
  `rCantidad17` int(11) NOT NULL,
  `rCantidad18` int(11) NOT NULL,
  `rCantidad19` int(11) NOT NULL,
  `rCantidad20` int(11) NOT NULL,
  `rDescripcion` varchar(200) NOT NULL,
  `rDescripcion2` varchar(200) NOT NULL,
  `rDescripcion3` varchar(200) NOT NULL,
  `rDescripcion4` varchar(200) NOT NULL,
  `rDescripcion5` varchar(200) NOT NULL,
  `rDescripcion6` varchar(200) NOT NULL,
  `rDescripcion7` varchar(200) NOT NULL,
  `rDescripcion8` varchar(200) NOT NULL,
  `rDescripcion9` varchar(200) NOT NULL,
  `rDescripcion10` varchar(200) NOT NULL,
  `rDescripcion11` varchar(200) NOT NULL,
  `rDescripcion12` varchar(200) NOT NULL,
  `rDescripcion13` varchar(200) NOT NULL,
  `rDescripcion14` varchar(200) NOT NULL,
  `rDescripcion15` varchar(200) NOT NULL,
  `rDescripcion16` varchar(200) NOT NULL,
  `rDescripcion17` varchar(200) NOT NULL,
  `rDescripcion18` varchar(200) NOT NULL,
  `rDescripcion19` varchar(200) NOT NULL,
  `rDescripcion20` varchar(200) NOT NULL,
  `rPrecio` float NOT NULL,
  `rPrecio2` float NOT NULL,
  `rPrecio3` float NOT NULL,
  `rPrecio4` float NOT NULL,
  `rPrecio5` float NOT NULL,
  `rPrecio6` float NOT NULL,
  `rPrecio7` float NOT NULL,
  `rPrecio8` float NOT NULL,
  `rPrecio9` float NOT NULL,
  `rPrecio10` float NOT NULL,
  `rPrecio11` float NOT NULL,
  `rPrecio12` float NOT NULL,
  `rPrecio13` float NOT NULL,
  `rPrecio14` float NOT NULL,
  `rPrecio15` float NOT NULL,
  `rPrecio16` float NOT NULL,
  `rPrecio17` float NOT NULL,
  `rPrecio18` float NOT NULL,
  `rPrecio19` float NOT NULL,
  `rPrecio20` float NOT NULL,
  `rSubtotal` float NOT NULL,
  `rIva` float NOT NULL,
  `rTotal` float NOT NULL,
  `rGarantia` varchar(20) NOT NULL,
  `rObservaciones` varchar(350) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_cliente`
--

CREATE TABLE `t_cliente` (
  `id_telefonoCliente` varchar(15) NOT NULL,
  `t_folio` int(11) NOT NULL,
  `t_descripcion` varchar(200) NOT NULL,
  `t_modelo` varchar(100) NOT NULL,
  `t_total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(80) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD KEY `nombreCliente` (`nombreCliente`),
  ADD KEY `telefonoCliente` (`telefonoCliente`);

--
-- Indices de la tabla `notaremision`
--
ALTER TABLE `notaremision`
  ADD PRIMARY KEY (`folio`),
  ADD KEY `nombreCliente` (`nombreCliente`),
  ADD KEY `telefonoCliente` (`telefonoCliente`);

--
-- Indices de la tabla `t_cliente`
--
ALTER TABLE `t_cliente`
  ADD PRIMARY KEY (`t_folio`),
  ADD KEY `id_telefonoCliente` (`id_telefonoCliente`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT de la tabla `notaremision`
--
ALTER TABLE `notaremision`
  MODIFY `folio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=162;

--
-- AUTO_INCREMENT de la tabla `t_cliente`
--
ALTER TABLE `t_cliente`
  MODIFY `t_folio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=144;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `t_cliente`
--
ALTER TABLE `t_cliente`
  ADD CONSTRAINT `t_cliente_ibfk_1` FOREIGN KEY (`id_telefonoCliente`) REFERENCES `notaremision` (`telefonoCliente`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
