-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: archfacts
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chamado`
--

DROP TABLE IF EXISTS `chamado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chamado` (
  `idChamado` char(36) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `descricao` varchar(250) NOT NULL,
  `abertura` datetime NOT NULL,
  `fechamento` datetime DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  `lucro` double DEFAULT NULL,
  `fkProjeto` char(36) NOT NULL,
  PRIMARY KEY (`idChamado`,`fkProjeto`),
  KEY `fk_Ticket_Projeto1_idx` (`fkProjeto`),
  CONSTRAINT `fk_Ticket_Projeto1` FOREIGN KEY (`fkProjeto`) REFERENCES `projeto` (`idProjeto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento` (
  `idEvento` char(36) NOT NULL,
  `idEntidade` char(36) NOT NULL,
  `dataInicio` varchar(45) DEFAULT NULL,
  `dataTermino` varchar(45) DEFAULT NULL,
  `dataCriacao` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `prioridade` varchar(45) DEFAULT NULL,
  `fkProjeto` char(36) NOT NULL,
  `fkNegocio` char(36) NOT NULL,
  PRIMARY KEY (`idEvento`,`fkProjeto`,`fkNegocio`),
  KEY `fk_Evento_Projeto1_idx` (`fkProjeto`,`fkNegocio`),
  CONSTRAINT `fk_Evento_Projeto1` FOREIGN KEY (`fkProjeto`, `fkNegocio`) REFERENCES `projeto` (`idProjeto`, `fkNegocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `financeiro`
--

DROP TABLE IF EXISTS `financeiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `financeiro` (
  `idFinanceiro` char(36) NOT NULL,
  `lucroTotal` double NOT NULL,
  `despesaTotal` double NOT NULL,
  `Receita` double DEFAULT NULL,
  `dataCriacao` datetime DEFAULT NULL,
  `fkProjeto` char(36) NOT NULL,
  PRIMARY KEY (`idFinanceiro`,`fkProjeto`),
  KEY `fk_Financeiro_Projeto1_idx` (`fkProjeto`),
  CONSTRAINT `fk_Financeiro_Projeto 1` FOREIGN KEY (`fkProjeto`) REFERENCES `projeto` (`idProjeto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `negocio`
--

DROP TABLE IF EXISTS `negocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `negocio` (
  `idNegocio` char(36) NOT NULL,
  `nome` varchar(125) NOT NULL,
  `codigo` varchar(125) NOT NULL,
  `cep` char(9) NOT NULL,
  `cpf` char(11) DEFAULT NULL,
  `cnpj` char(14) DEFAULT NULL,
  `dataRegistro` datetime NOT NULL,
  `avaliacao` int DEFAULT NULL,
  `ativado` varchar(45) NOT NULL,
  PRIMARY KEY (`idNegocio`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  UNIQUE KEY `cep_UNIQUE` (`cep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `parcela`
--

DROP TABLE IF EXISTS `parcela`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parcela` (
  `idParcela` char(36) NOT NULL,
  `valor` double DEFAULT NULL,
  `dataInicio` datetime DEFAULT NULL,
  `dataTermino` datetime DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `fkChamado` char(36) NOT NULL,
  `fkProjeto` char(36) NOT NULL,
  PRIMARY KEY (`idParcela`,`fkChamado`,`fkProjeto`),
  KEY `fk_Parcela_Chamado1_idx` (`fkChamado`,`fkProjeto`),
  CONSTRAINT `fk_Parcela_Chamado1` FOREIGN KEY (`fkChamado`, `fkProjeto`) REFERENCES `chamado` (`idChamado`, `fkProjeto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `projeto`
--

DROP TABLE IF EXISTS `projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projeto` (
  `idProjeto` char(36) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `custo` varchar(45) NOT NULL,
  `dataInicio` datetime NOT NULL,
  `dataEntrega` datetime NOT NULL,
  `status` varchar(45) NOT NULL,
  `fkNegocio` char(36) NOT NULL,
  `fkBeneficiario` char(36) NOT NULL,
  PRIMARY KEY (`idProjeto`,`fkNegocio`),
  KEY `fk_Projeto_Negocio1_idx` (`fkNegocio`),
  KEY `fk_Projeto_Usuario_idx` (`fkBeneficiario`),
  CONSTRAINT `fk_Projeto_Negocio1` FOREIGN KEY (`fkNegocio`) REFERENCES `negocio` (`idNegocio`),
  CONSTRAINT `fk_Projeto_Usuario` FOREIGN KEY (`fkBeneficiario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proposta`
--

DROP TABLE IF EXISTS `proposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proposta` (
  `idProposta` char(36) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `cep` char(10) NOT NULL,
  `dataEntrega` datetime DEFAULT NULL,
  `dataEnvio` datetime DEFAULT NULL,
  `endereco` varchar(100) NOT NULL,
  `numero` int NOT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `fkRemetente` char(36) NOT NULL,
  `fkDestinatario` char(36) NOT NULL,
  PRIMARY KEY (`idProposta`),
  KEY `fk_Proposta_Usuario1_idx` (`fkRemetente`),
  KEY `fk_Proposta_Negocio1_idx` (`fkDestinatario`),
  CONSTRAINT `fk_Proposta_Negocio1` FOREIGN KEY (`fkDestinatario`) REFERENCES `negocio` (`idNegocio`),
  CONSTRAINT `fk_Proposta_Usuario1` FOREIGN KEY (`fkRemetente`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `propostaservico`
--

DROP TABLE IF EXISTS `propostaservico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propostaservico` (
  `idPropostaServico` char(36) NOT NULL,
  `idProposta` char(36) NOT NULL,
  `fkRemetente` char(36) DEFAULT NULL,
  `fkDestinatario` char(36) DEFAULT NULL,
  `idServico` char(36) NOT NULL,
  `fkNegocio` char(36) DEFAULT NULL,
  `dataCriacao` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idPropostaServico`),
  KEY `fk_Proposta` (`idProposta`),
  KEY `fk_Servico` (`idServico`),
  KEY `fk_Remetente` (`fkRemetente`),
  KEY `fk_Destinatario` (`fkDestinatario`),
  KEY `fk_Negocio` (`fkNegocio`),
  CONSTRAINT `fk_Destinatario` FOREIGN KEY (`fkDestinatario`) REFERENCES `negocio` (`idNegocio`),
  CONSTRAINT `fk_Negocio` FOREIGN KEY (`fkNegocio`) REFERENCES `negocio` (`idNegocio`),
  CONSTRAINT `fk_Proposta` FOREIGN KEY (`idProposta`) REFERENCES `proposta` (`idProposta`) ON DELETE CASCADE,
  CONSTRAINT `fk_Remetente` FOREIGN KEY (`fkRemetente`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `fk_Servico` FOREIGN KEY (`idServico`) REFERENCES `servico` (`idServico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servico` (
  `idServico` char(36) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `fkNegocio` char(36) NOT NULL,
  PRIMARY KEY (`idServico`,`fkNegocio`),
  KEY `fk_Servico_Negocio1_idx` (`fkNegocio`),
  CONSTRAINT `fk_Servico_Negocio1` FOREIGN KEY (`fkNegocio`) REFERENCES `negocio` (`idNegocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tarefa`
--

DROP TABLE IF EXISTS `tarefa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarefa` (
  `idTarefa` char(36) NOT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `despesa` double DEFAULT NULL,
  `dataInicio` datetime DEFAULT NULL,
  `dataTermino` datetime DEFAULT NULL,
  `prioridade` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `fkProjeto` char(36) NOT NULL,
  PRIMARY KEY (`idTarefa`,`fkProjeto`),
  KEY `fk_Tarefa_Projeto1_idx` (`fkProjeto`),
  CONSTRAINT `fk_Tarefa_Projeto1` FOREIGN KEY (`fkProjeto`) REFERENCES `projeto` (`idProjeto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` char(36) NOT NULL,
  `nome` varchar(125) NOT NULL,
  `email` varchar(125) NOT NULL,
  `senha` varchar(125) NOT NULL,
  `telefone` char(12) NOT NULL,
  `dataRegistro` datetime NOT NULL,
  `ativado` tinyint NOT NULL,
  `role` varchar(45) NOT NULL,
  `fkNegocio` char(36) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `telefone_UNIQUE` (`telefone`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_Usuario_Negocio_idx` (`fkNegocio`),
  CONSTRAINT `fk_Usuario_Negocio` FOREIGN KEY (`fkNegocio`) REFERENCES `negocio` (`idNegocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-22 12:59:58
