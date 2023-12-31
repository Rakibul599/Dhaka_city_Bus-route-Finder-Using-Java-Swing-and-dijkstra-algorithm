-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2023 at 07:09 AM
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
-- Table structure for table `businf`
--

CREATE TABLE `businf` (
  `node` int(11) DEFAULT NULL,
  `Destination_Name` varchar(20) DEFAULT NULL,
  `bus_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `businf`
--

INSERT INTO `businf` (`node`, `Destination_Name`, `bus_name`) VALUES
(0, 'House_buliding', 'Bikash_Brtc'),
(1, 'Airport', 'Baksh_Brtc'),
(2, 'Kuril', 'Bakash_Brtc'),
(3, 'Cantonment', 'bakash_Brtc'),
(4, 'Banani', 'bakash_Brtc'),
(5, 'Gulsan', 'Raida'),
(6, 'Mohakhali', 'Bkash'),
(7, 'Tejgaon', 'Gazipur_paribohon'),
(8, 'Framget', 'Bkash'),
(9, 'Agargaon', 'Bhoiya_Poribhan'),
(10, 'Mirpur', 'Projapoti_Poribhon'),
(11, 'Diabari', 'Raida');

-- --------------------------------------------------------

--
-- Table structure for table `reginf`
--

CREATE TABLE `reginf` (
  `FIRST_Name` varchar(50) DEFAULT NULL,
  `Last_Name` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` int(11) NOT NULL,
  `pass_word` varchar(20) DEFAULT NULL,
  `Date_of_Birth` date DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reginf`
--

INSERT INTO `reginf` (`FIRST_Name`, `Last_Name`, `user_name`, `email`, `phone`, `pass_word`, `Date_of_Birth`, `Gender`) VALUES
('Rakibul', 'Alam', 'rakib5', 'rrr@gmail.com', 17, '123', '2023-12-13', 'Male');

--
-- Triggers `reginf`
--
DELIMITER $$
CREATE TRIGGER `t1` BEFORE DELETE ON `reginf` FOR EACH ROW BEGIN
    INSERT INTO reginf_backup (FIRST_name, Last_Name, user_name, email, phone, pass_word, Date_of_Birth, Gender)
    VALUES (OLD.FIRST_name, OLD.Last_Name, OLD.user_name, OLD.email, OLD.phone, OLD.pass_word, OLD.Date_of_Birth, OLD.Gender);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `reginf_backup`
--

CREATE TABLE `reginf_backup` (
  `FIRST_Name` varchar(50) DEFAULT NULL,
  `Last_Name` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` int(11) NOT NULL,
  `pass_word` varchar(20) DEFAULT NULL,
  `Date_of_Birth` date DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reginf_backup`
--

INSERT INTO `reginf_backup` (`FIRST_Name`, `Last_Name`, `user_name`, `email`, `phone`, `pass_word`, `Date_of_Birth`, `Gender`) VALUES
('RAkib', 'al', 'al', 'all', 456, '12345', '2023-12-21', 'Male'),
('Mahmodul', 'Hasan', 'mah', 'mah@gmail.com', 65465, '123', '2023-12-28', 'Female'),
('Rakibul', 'Alam', 'rakibul', 'R@mail.com', 1512, '1234', '2023-12-20', 'Male');

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

-- --------------------------------------------------------

--
-- Table structure for table `userinf`
--

CREATE TABLE `userinf` (
  `user_name` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `pass_word` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userinf`
--

INSERT INTO `userinf` (`user_name`, `email`, `pass_word`) VALUES
('rakib5', 'rrr@gmail.com', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `reginf`
--
ALTER TABLE `reginf`
  ADD PRIMARY KEY (`user_name`,`phone`);

--
-- Indexes for table `userinf`
--
ALTER TABLE `userinf`
  ADD KEY `user_name` (`user_name`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `userinf`
--
ALTER TABLE `userinf`
  ADD CONSTRAINT `userinf_ibfk_1` FOREIGN KEY (`user_name`) REFERENCES `reginf` (`user_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
