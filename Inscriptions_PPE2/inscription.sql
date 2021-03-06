-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 09 Mai 2017 à 08:18
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `inscription`
--

DELIMITER $$
--
-- Procédures
--
CREATE PROCEDURE `ajouterCandidatCompetition` (IN `id_candidat` INT(4), IN `id_competition` INT(4))  BEGIN
INSERT INTO inscrire VALUES (id_candidat, id_competition);
END$$

CREATE PROCEDURE `ajouterEquipeCompetition` (`id_candidat` INT(4), `id_competition` INT(4))  BEGIN
INSERT INTO inscrire VALUES (id_candidat, id_competition);
END$$

CREATE PROCEDURE `ajouterPersonneEquipe` (IN `numpersonne` INT, IN `numequipe` INT)  BEGIN
INSERT INTO APPARTENIR(idCandidatPersonne,idCandidatEquipe)
VALUES (numpersonne,numequipe);
END$$

CREATE PROCEDURE `candidatsInscritsCompetition` (IN `Numcompetition` INT)  BEGIN

    SELECT candidat.idCandidat, candidat.nom
    FROM competition, inscrire, candidat
    WHERE candidat.idCandidat = inscrire.idCandidat
    AND competition.idCompetition = inscrire.idCompetition
    AND inscrire.idCompetition = Numcompetition;
 
END$$

CREATE PROCEDURE `creerCompetition` (`nomC` VARCHAR(255), `dateClotureC` DATE, `enEquipeC` BOOLEAN)  BEGIN
INSERT INTO competition (epreuve,dateCloture,enEquipe) VALUES (nomC,dateClotureC,enEquipeC);
END$$

CREATE PROCEDURE `creerEquipe` (IN `nomE` VARCHAR(50))  BEGIN
INSERT INTO candidat (nom, prenom, email, estEquipe) VALUES (nomE, NULL, NULL, 1);
END$$

CREATE PROCEDURE `creerPersonne` (IN `nomP` VARCHAR(50), IN `prenomP` VARCHAR(50), IN `mailP` VARCHAR(100))  BEGIN
INSERT INTO candidat (nom, prenom, email, estEquipe) VALUES (nomP, prenomP, mailP, 0);
END$$

CREATE PROCEDURE `dateClotureInscription` (`Numcompetition` INT)  BEGIN
    SELECT dateCloture FROM COMPETITION WHERE idCompetition = Numcompetition;
END$$

CREATE PROCEDURE `desinscrireCandidat` (IN `numCandidat` INT, IN `numCompet` INT)  BEGIN
DELETE FROM INSCRIRE
WHERE idCandidat = numCandidat
AND idCompetition = numCompet;
END$$

CREATE PROCEDURE `enEquipe` (`id_competition` INT)  BEGIN
SELECT enEquipe 
FROM COMPETITION 
WHERE idCompetition = id_competition;
END$$

CREATE PROCEDURE `getAcrEquipe` (`Numcandidat` INT)  BEGIN
SELECT nom
FROM CANDIDAT
WHERE idCandidat = Numcandidat
AND estEquipe = 1;
END$$

CREATE PROCEDURE `getAICandidat` ()  BEGIN
SHOW TABLE STATUS FROM inscription LIKE 'candidat';
END$$

CREATE PROCEDURE `getAICompetition` ()  BEGIN
SHOW TABLE STATUS FROM inscription LIKE 'competition';
END$$

CREATE PROCEDURE `getCompetition` ()  BEGIN
SELECT *
FROM competition;
END$$

CREATE PROCEDURE `getEquipe` ()  BEGIN
SELECT *
FROM candidat
WHERE estEquipe = 1;
END$$

CREATE PROCEDURE `getEquipePersonne` (`Numcandidat` INT)  BEGIN

SELECT prenom
FROM APPARTENIR,CANDIDAT
WHERE idCandidatPersonne = Numcandidat
AND Appartenir.idCandidatEquipe = CANDIDAT.idCandidat;

END$$

CREATE PROCEDURE `getMail` (`Numcandidat` INT)  BEGIN
SELECT email
FROM CANDIDAT
WHERE idCandidat = Numcandidat
AND estEquipe = 0;
END$$

CREATE PROCEDURE `getMailEquipe` (`Numcandidat` INT)  BEGIN
SELECT email
FROM CANDIDAT
WHERE idCandidat = Numcandidat
AND estEquipe = 1;
END$$

CREATE PROCEDURE `getNom` (`Numcandidat` INT)  BEGIN
SELECT nom
FROM CANDIDAT
WHERE idCandidat = Numcandidat
AND estEquipe = 0;
END$$

CREATE PROCEDURE `getNomEquipe` (`Numcandidat` INT)  BEGIN
SELECT prenom
FROM CANDIDAT
WHERE idCandidat = Numcandidat
AND estEquipe = 1;
END$$

CREATE PROCEDURE `getPersonne` ()  BEGIN
SELECT *
FROM candidat
WHERE estEquipe = 0;
END$$

CREATE PROCEDURE `getPersonneEquipe` (IN `num_equipe` INT)  BEGIN
SELECT *
FROM candidat, appartenir
WHERE appartenir.idCandidatPersonne = candidat.idCandidat
AND idCandidatEquipe = num_equipe;
END$$

CREATE PROCEDURE `getPrenom` (`Numcandidat` INT)  BEGIN
SELECT prenom
FROM CANDIDAT
WHERE idCandidat = Numcandidat
AND estEquipe = 0;
END$$

CREATE PROCEDURE `modifierDateCloture` (`id_competition` INT, `modifdatecloture` DATE)  BEGIN
UPDATE COMPETITION
SET dateCloture = modifdatecloture
WHERE idCompetition = id_competition;

END$$

CREATE PROCEDURE `modifierMail` (IN `Numcandidat` INT, IN `NomMail` VARCHAR(25))  BEGIN
UPDATE CANDIDAT
SET email = NomMail
WHERE idCandidat = Numcandidat;
END$$

CREATE PROCEDURE `modifierNomCandidat` (IN `numCandidat` INT, IN `nomCandidat` VARCHAR(25))  BEGIN
UPDATE candidat
SET nom = nomCandidat
WHERE idCandidat = numCandidat;
END$$

CREATE PROCEDURE `modifierNomCompetition` (`id_competition` INT, `nom_competition` VARCHAR(25))  BEGIN
UPDATE COMPETITION
SET  epreuve = nom_competition
WHERE idCompetition = id_competition;

SELECT * from COMPETITION;
END$$

CREATE PROCEDURE `modifierPrenom` (IN `Numcandidat` INT, IN `Prenompersonne` VARCHAR(25))  BEGIN
UPDATE CANDIDAT
SET prenom = Prenompersonne
WHERE idCandidat = Numcandidat;
END$$

CREATE PROCEDURE `nomCompetition` (IN `NumCompetition` INT)  BEGIN 
SELECT epreuve FROM COMPETITION 
WHERE idCompetition = NumCompetition;

END$$

CREATE PROCEDURE `supprimerCandidat` (IN `NumCandidat` INT)  BEGIN

DELETE FROM CANDIDAT
WHERE idCandidat = NumCandidat;

DELETE FROM APPARTENIR
WHERE idCandidatPersonne = NumCandidat
OR idCandidatEquipe = NumCandidat;

DELETE FROM inscrire
WHERE idCandidat = NumCandidat;

END$$

CREATE PROCEDURE `supprimerCompetition` (IN `idComp` INT)  BEGIN

DELETE FROM COMPETITION 
WHERE idCompetition = idComp;

DELETE FROM INSCRIRE
WHERE idCompetition = idComp;
   
END$$

CREATE PROCEDURE `supprimerPersonneEquipe` (`id_personne` INT, `id_equipe` INT)  BEGIN
DELETE FROM APPARTENIR
WHERE idCandidatPersonne = id_personne
AND idCandidatEquipe = id_equipe;
END$$

--
-- Fonctions
--
CREATE FUNCTION `inscriptionsOuvertes` (`id_competition` INT) RETURNS VARCHAR(60) CHARSET latin1 BEGIN
DECLARE retour varchar(60);
DECLARE date_Cloture date;
DECLARE resultat int;

SET date_Cloture = (SELECT dateCloture FROM COMPETITION WHERE idCompetition = id_competition);
SET resultat = DATEDIFF(date_Cloture,(SELECT NOW()));

IF resultat > 0 THEN 
SET retour = "1";
ELSE 
SET retour = "0"; 
END IF;
RETURN retour;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `appartenir`
--

CREATE TABLE `appartenir` (
  `idCandidatPersonne` int(11) NOT NULL,
  `idCandidatEquipe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `appartenir`
--

INSERT INTO `appartenir` (`idCandidatPersonne`, `idCandidatEquipe`) VALUES
(1, 8),
(2, 9),
(3, 9),
(6, 9),
(4, 10),
(5, 10),
(7, 14),
(11, 14);

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

CREATE TABLE `candidat` (
  `idCandidat` int(11) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `estEquipe` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `candidat`
--

INSERT INTO `candidat` (`idCandidat`, `nom`, `prenom`, `email`, `estEquipe`) VALUES
(1, 'Doux', 'Jesus', 'jesus@ledoux.fr', 0),
(2, 'Bamba', 'Anais', 'roi@bienveillant.fr', 0),
(3, 'Plard', 'Antoine', 'cool@gauchiste.fr', 0),
(4, 'Ramarlina', 'Felana', 'madagascar@malgachie.mg', 0),
(5, 'Neto', 'Adrien', 'portugais@loreal.fr', 0),
(6, 'Fervil', 'Darwin', 'kinder@bueno.fr', 0),
(7, 'Sabbak', 'Nicolas', 'leader@gauchiste.fr', 0),
(8, 'FC Barcelone', NULL, NULL, 1),
(9, 'Hermes-Berthecourt AC', NULL, NULL, 1),
(10, 'Paris-Saint-Germain', NULL, NULL, 1),
(11, 'Bouillennec', 'Valentin', 'val.bouillennec@gmail.com', 0),
(14, 'San Antonio Spurs', NULL, NULL, 1),
(15, 'Nadal', 'Rafael', 'rafa.nadal@espagne.es', 0);

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

CREATE TABLE `competition` (
  `idCompetition` int(11) NOT NULL,
  `epreuve` varchar(25) DEFAULT NULL,
  `dateCloture` date DEFAULT NULL,
  `enEquipe` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `competition`
--

INSERT INTO `competition` (`idCompetition`, `epreuve`, `dateCloture`, `enEquipe`) VALUES
(1, 'Sweet Christmas', '2018-01-08', 0),
(2, 'Football', '2018-01-21', 1),
(3, 'Cyclisme', '2018-03-18', 0),
(4, 'Basket', '2018-01-22', 1),
(5, 'Natation', '2018-02-09', 0),
(6, 'Jeux Olympiques', '2018-04-03', 1),
(7, 'Tennis', '2018-12-12', 0);

-- --------------------------------------------------------

--
-- Structure de la table `inscrire`
--

CREATE TABLE `inscrire` (
  `idCandidat` int(11) NOT NULL,
  `idCompetition` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `inscrire`
--

INSERT INTO `inscrire` (`idCandidat`, `idCompetition`) VALUES
(8, 2),
(9, 2),
(10, 2),
(4, 3),
(14, 4),
(1, 5),
(7, 7),
(15, 7);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `appartenir`
--
ALTER TABLE `appartenir`
  ADD PRIMARY KEY (`idCandidatPersonne`,`idCandidatEquipe`),
  ADD KEY `FK_APPARTENIR_idCandidatEquipe` (`idCandidatEquipe`);

--
-- Index pour la table `candidat`
--
ALTER TABLE `candidat`
  ADD PRIMARY KEY (`idCandidat`);

--
-- Index pour la table `competition`
--
ALTER TABLE `competition`
  ADD PRIMARY KEY (`idCompetition`);

--
-- Index pour la table `inscrire`
--
ALTER TABLE `inscrire`
  ADD PRIMARY KEY (`idCandidat`,`idCompetition`),
  ADD KEY `FK_INSCRIRE_idCompetition` (`idCompetition`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `candidat`
--
ALTER TABLE `candidat`
  MODIFY `idCandidat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `competition`
--
ALTER TABLE `competition`
  MODIFY `idCompetition` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `appartenir`
--
ALTER TABLE `appartenir`
  ADD CONSTRAINT `FK_APPARTENIR_idCandidatEquipe` FOREIGN KEY (`idCandidatEquipe`) REFERENCES `candidat` (`idCandidat`),
  ADD CONSTRAINT `FK_APPARTENIR_idCandidatPersonne` FOREIGN KEY (`idCandidatPersonne`) REFERENCES `candidat` (`idCandidat`);

--
-- Contraintes pour la table `inscrire`
--
ALTER TABLE `inscrire`
  ADD CONSTRAINT `FK_INSCRIRE_idCandidat` FOREIGN KEY (`idCandidat`) REFERENCES `candidat` (`idCandidat`),
  ADD CONSTRAINT `FK_INSCRIRE_idCompetition` FOREIGN KEY (`idCompetition`) REFERENCES `competition` (`idCompetition`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
