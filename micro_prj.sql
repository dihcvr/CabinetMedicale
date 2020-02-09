-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 09, 2020 at 08:03 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `micro_prj`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `Id` int(20) NOT NULL AUTO_INCREMENT,
  `Version` int(11) NOT NULL,
  `Titre` varchar(5) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `creneaux`
--

CREATE TABLE IF NOT EXISTS `creneaux` (
  `Id` int(20) NOT NULL AUTO_INCREMENT,
  `Version` int(11) NOT NULL,
  `HDebut` int(11) NOT NULL,
  `MDebut` int(11) NOT NULL,
  `HFin` int(11) NOT NULL,
  `MFin` int(11) NOT NULL,
  `Id_Medecin` int(20) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Client_FK` (`Id_Medecin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `medecins`
--

CREATE TABLE IF NOT EXISTS `medecins` (
  `Id` int(20) NOT NULL AUTO_INCREMENT,
  `Version` int(11) NOT NULL,
  `Titre` varchar(5) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `rv`
--

CREATE TABLE IF NOT EXISTS `rv` (
  `Id` int(20) NOT NULL AUTO_INCREMENT,
  `Jour` date NOT NULL,
  `Id_Client` int(20) NOT NULL,
  `Id_Creneau` int(20) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Client_Rv_FK` (`Id_Client`),
  KEY `Id_Creneau_FK` (`Id_Creneau`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('azer', 'azer');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `creneaux`
--
ALTER TABLE `creneaux`
  ADD CONSTRAINT `Id_Medecin_FK` FOREIGN KEY (`Id_Medecin`) REFERENCES `medecins` (`Id`);

--
-- Constraints for table `rv`
--
ALTER TABLE `rv`
  ADD CONSTRAINT `Id_Client_Rv_FK` FOREIGN KEY (`Id_Client`) REFERENCES `clients` (`Id`),
  ADD CONSTRAINT `Id_Creneau_FK` FOREIGN KEY (`Id_Creneau`) REFERENCES `creneaux` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
