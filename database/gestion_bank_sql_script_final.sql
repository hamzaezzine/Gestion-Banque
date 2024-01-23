-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Jan 23, 2024 at 06:30 PM
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
-- Database: `gestion_bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `carte`
--

CREATE TABLE `carte` (
  `carte_id` int(11) NOT NULL,
  `numero` varchar(16) DEFAULT NULL,
  `date_expiration` date DEFAULT NULL,
  `pin` int(11) DEFAULT NULL,
  `compte_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `client_id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `genre` varchar(10) DEFAULT NULL,
  `date_naissance_` varchar(50) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `code_postal` varchar(50) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `nationalite` varchar(50) DEFAULT NULL,
  `numero_telephone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `compte`
--

CREATE TABLE `compte` (
  `compte_id` int(11) NOT NULL,
  `date_ouverture` date DEFAULT NULL,
  `solde` decimal(15,2) DEFAULT NULL,
  `type_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `operation`
--

CREATE TABLE `operation` (
  `operation_id` int(11) NOT NULL,
  `date_operation` date DEFAULT NULL,
  `time_operation` time NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `montant` decimal(15,2) DEFAULT NULL,
  `type_id` int(11) NOT NULL,
  `compte_id` int(11) NOT NULL,
  `destinataire_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `type_compte`
--

CREATE TABLE `type_compte` (
  `type_id` int(11) NOT NULL,
  `type_compte` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `type_compte`
--

INSERT INTO `type_compte` (`type_id`, `type_compte`) VALUES
(1, 'Courant'),
(2, 'Épargne'),
(3, 'Chèque'),
(4, 'Entreprise'),
(5, 'Jeune'),
(6, 'Étudiant');

-- --------------------------------------------------------

--
-- Table structure for table `type_operation`
--

CREATE TABLE `type_operation` (
  `type_id` int(11) NOT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `type_operation`
--

INSERT INTO `type_operation` (`type_id`, `type`) VALUES
(1, 'Dépôt'),
(2, 'Retrait'),
(3, 'Virement');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carte`
--
ALTER TABLE `carte`
  ADD PRIMARY KEY (`carte_id`),
  ADD KEY `compte_id` (`compte_id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`client_id`);

--
-- Indexes for table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`compte_id`),
  ADD KEY `type_id` (`type_id`),
  ADD KEY `client_id` (`client_id`);

--
-- Indexes for table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`operation_id`),
  ADD KEY `type_id` (`type_id`),
  ADD KEY `compte_id` (`compte_id`),
  ADD KEY `fk_operations_destinataire` (`destinataire_id`);

--
-- Indexes for table `type_compte`
--
ALTER TABLE `type_compte`
  ADD PRIMARY KEY (`type_id`);

--
-- Indexes for table `type_operation`
--
ALTER TABLE `type_operation`
  ADD PRIMARY KEY (`type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carte`
--
ALTER TABLE `carte`
  MODIFY `carte_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `compte`
--
ALTER TABLE `compte`
  MODIFY `compte_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `operation`
--
ALTER TABLE `operation`
  MODIFY `operation_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `type_compte`
--
ALTER TABLE `type_compte`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `type_operation`
--
ALTER TABLE `type_operation`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `carte`
--
ALTER TABLE `carte`
  ADD CONSTRAINT `carte_ibfk_1` FOREIGN KEY (`compte_id`) REFERENCES `compte` (`compte_id`);

--
-- Constraints for table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `type_compte` (`type_id`),
  ADD CONSTRAINT `compte_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`);

--
-- Constraints for table `operation`
--
ALTER TABLE `operation`
  ADD CONSTRAINT `fk_operations_destinataire` FOREIGN KEY (`destinataire_id`) REFERENCES `compte` (`compte_id`),
  ADD CONSTRAINT `operation_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `type_operation` (`type_id`),
  ADD CONSTRAINT `operation_ibfk_2` FOREIGN KEY (`compte_id`) REFERENCES `compte` (`compte_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
