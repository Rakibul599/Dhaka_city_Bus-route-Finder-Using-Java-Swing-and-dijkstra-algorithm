-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2023 at 05:15 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dhakacitybus`
--

-- --------------------------------------------------------

--
-- Table structure for table `routedb`
--

CREATE TABLE `routedb` (
  `node` int(11) DEFAULT NULL,
  `Destination_Name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `routedb`
--

INSERT INTO `routedb` (`node`, `Destination_Name`) VALUES
(0, 'House_buliding'),
(1, 'Airport'),
(2, 'Kuril'),
(3, 'Cantonment'),
(4, 'Banani'),
(5, 'Gulsan'),
(6, 'Mohakhali'),
(7, 'Tejgaon'),
(8, 'Framget'),
(9, 'Agargaon'),
(10, 'Mirpur'),
(11, 'Diabari');

-- --------------------------------------------------------

--
-- Table structure for table `routedb1`
--

CREATE TABLE `routedb1` (
  `node1` int(11) DEFAULT NULL,
  `node2` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `routedb1`
--

INSERT INTO `routedb1` (`node1`, `node2`, `weight`) VALUES
(0, 1, 4),
(1, 2, 1),
(2, 3, 2),
(2, 5, 6),
(3, 4, 3),
(5, 4, 6),
(4, 6, 2),
(6, 7, 3),
(7, 8, 5),
(7, 9, 4),
(8, 9, 3),
(9, 10, 2),
(10, 3, 8),
(10, 11, 3),
(0, 11, 5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
