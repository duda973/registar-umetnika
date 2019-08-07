-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 25, 2017 at 07:37 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `oscar`
--
CREATE DATABASE IF NOT EXISTS `oscar` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `oscar`;

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE IF NOT EXISTS `film` (
  `idfilma` int(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `produkcija` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `godina` int(20) NOT NULL,
  PRIMARY KEY (`idfilma`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`idfilma`, `naziv`, `produkcija`, `godina`) VALUES
(1, 'Titanic', '20th Century Fox and Paramount', 1997),
(2, 'Shakespeare in Love', 'Miramax', 1998),
(3, 'Chicago', 'Miramax', 2002),
(4, 'Gladiator', 'DreamWorks and Universal', 2000),
(5, 'The Godfather Part II', 'Paramount', 1974),
(6, 'Cabaret', 'Allied Artists', 1972),
(7, 'Rocky', 'United Artists', 1976),
(8, 'Star Wars', '20th Century-Fox', 1977),
(9, 'Gravity', 'Warner Bros.', 2013),
(10, 'The Godfather', 'Paramount', 1972),
(11, 'On the Waterfront', 'Columbia', 1954);

-- --------------------------------------------------------

--
-- Table structure for table `glumac`
--

CREATE TABLE IF NOT EXISTS `glumac` (
  `idglumca` int(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idglumca`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=21 ;

--
-- Dumping data for table `glumac`
--

INSERT INTO `glumac` (`idglumca`, `ime`) VALUES
(1, 'Leonardo DiCaprio'),
(2, 'Kate Winslet'),
(3, 'Al Pacino'),
(4, 'Robert De Niro'),
(5, 'Gwyneth Paltrow'),
(6, 'Joseph Fiennes'),
(7, 'Richard Gere'),
(8, 'Renée Zellwege'),
(9, 'Russell Crowe'),
(10, 'Joaquin Phoenix'),
(11, 'Liza Minnelli'),
(12, 'Michael York'),
(13, 'Sylvester Stallone'),
(14, 'Talia Shire'),
(15, 'Harrison Ford'),
(16, 'Carrie Fisher'),
(17, 'George Clooney'),
(18, 'Sandra Bullock'),
(19, 'Marlon Brando'),
(20, 'Karl Malden');

-- --------------------------------------------------------

--
-- Table structure for table `nominacija`
--

CREATE TABLE IF NOT EXISTS `nominacija` (
  `idfilma` int(20) NOT NULL,
  `idglumca` int(20) NOT NULL,
  `razlogNominacije` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idfilma`,`idglumca`),
  KEY `idglumca` (`idglumca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nominacija`
--

INSERT INTO `nominacija` (`idfilma`, `idglumca`, `razlogNominacije`) VALUES
(1, 1, 'Neverovatna gluma');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `nominacija`
--
ALTER TABLE `nominacija`
  ADD CONSTRAINT `nominacija_ibfk_1` FOREIGN KEY (`idfilma`) REFERENCES `film` (`idfilma`),
  ADD CONSTRAINT `nominacija_ibfk_2` FOREIGN KEY (`idglumca`) REFERENCES `glumac` (`idglumca`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
