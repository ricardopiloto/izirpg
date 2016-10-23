-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.16-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para rpg
CREATE DATABASE IF NOT EXISTS `rpg` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rpg`;


-- Copiando estrutura para tabela rpg.chars
CREATE TABLE IF NOT EXISTS `chars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) DEFAULT '1',
  `name` char(50) DEFAULT '0',
  `player_name` char(50) DEFAULT '0',
  `classe` char(50) DEFAULT '0',
  `race` char(50) DEFAULT '0',
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela rpg.chars: ~2 rows (aproximadamente)
DELETE FROM `chars`;
/*!40000 ALTER TABLE `chars` DISABLE KEYS */;
INSERT INTO `chars` (`id`, `level`, `name`, `player_name`, `classe`, `race`) VALUES
	(1, 7, 'William Pendragon', 'Piloto', 'Paladin', 'Human'),
	(2, 7, 'Elanorien Andriel', 'Rafa', 'Bard', 'Elf');
/*!40000 ALTER TABLE `chars` ENABLE KEYS */;


-- Copiando estrutura para tabela rpg.usr
CREATE TABLE IF NOT EXISTS `usr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela rpg.usr: ~1 rows (aproximadamente)
DELETE FROM `usr`;
/*!40000 ALTER TABLE `usr` DISABLE KEYS */;
INSERT INTO `usr` (`id`, `email`, `pass`) VALUES
	(1, 'teste', '123');
/*!40000 ALTER TABLE `usr` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
