-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 30, 2016 at 01:44 
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agentemaps`
--

-- --------------------------------------------------------

--
-- Table structure for table `abastecimento_agua`
--

CREATE TABLE `abastecimento_agua` (
  `familia_id` int(11) NOT NULL,
  `rede_geral` int(11) NOT NULL,
  `poco_nascente` int(11) NOT NULL,
  `outros` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `administrador`
--

CREATE TABLE `administrador` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `login` varchar(30) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `cpf` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `administrador`
--

INSERT INTO `administrador` (`id`, `nome`, `login`, `senha`, `cpf`) VALUES
(10, 'sSaturnino', 'leviSaturnino', '1234', '432432423423'),
(11, '', '', '', ''),
(12, 'levi', 'fdasfd', 'fdasf', 'fads');

-- --------------------------------------------------------

--
-- Table structure for table `agente`
--

CREATE TABLE `agente` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(16) NOT NULL,
  `sexo` char(1) NOT NULL,
  `login` varchar(30) NOT NULL,
  `senha` varchar(16) NOT NULL,
  `foto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `agente`
--

INSERT INTO `agente` (`id`, `nome`, `cpf`, `sexo`, `login`, `senha`, `foto`) VALUES
(47, 'ewrew', '2343423', '\0', 'rew', 'rewr', 'rew'),
(48, 'rewq', '3243242', '\0', 'rewqr', 'rewqr', ''),
(49, '', '', '\0', '', '', ''),
(50, 'rewq', '432423342', '\0', 'rewqrr', 'rewer', '');

-- --------------------------------------------------------

--
-- Table structure for table `destino_fezes`
--

CREATE TABLE `destino_fezes` (
  `familia_id` int(11) NOT NULL,
  `sistema_esgoto` tinyint(4) DEFAULT NULL,
  `fossa` tinyint(4) DEFAULT NULL,
  `ceu_aberto` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `destino_lixo`
--

CREATE TABLE `destino_lixo` (
  `familia_id` int(11) NOT NULL,
  `coletado` tinyint(4) DEFAULT NULL,
  `queimado_enterrado` tinyint(4) DEFAULT NULL,
  `ceu_aberto` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `diabetico`
--

CREATE TABLE `diabetico` (
  `membro_id` int(11) NOT NULL,
  `faz_dieta` tinyint(4) DEFAULT NULL,
  `usa_insulina` tinyint(4) DEFAULT NULL,
  `toma_hipoglicemiante` tinyint(4) DEFAULT NULL,
  `data_utilma` tinyint(4) DEFAULT NULL,
  `observacoes` tinyint(4) DEFAULT NULL,
  `faz_exercicios` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `familia`
--

CREATE TABLE `familia` (
  `id` int(11) NOT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(2) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `codigo_municipio` varchar(7) DEFAULT NULL,
  `segmento` varchar(2) DEFAULT NULL,
  `area` varchar(3) DEFAULT NULL,
  `microarea` varchar(2) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `cpf_chefe` varchar(16) NOT NULL,
  `chefe_familia` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `familia`
--

INSERT INTO `familia` (`id`, `uf`, `logradouro`, `numero`, `bairro`, `cep`, `codigo_municipio`, `segmento`, `area`, `microarea`, `data`, `cpf_chefe`, `chefe_familia`) VALUES
(1, NULL, '', '', '', '', '', '', '', '', NULL, '', 'luiz'),
(2, 'ro', '2', '23', '32', '342', '323', '22', '332', '32', NULL, '3213', '32'),
(3, 'ro', '2', '23', '32', '342234324', '323432', '22', '332', '32', NULL, '3213', '32'),
(4, 'ro', '2', '23', '32', '342234324', '323432', '22', '332', '32', NULL, '3213', '32');

-- --------------------------------------------------------

--
-- Table structure for table `fatores_risco`
--

CREATE TABLE `fatores_risco` (
  `gestante_id` int(11) NOT NULL,
  `seis_mais_gestacoes` tinyint(4) DEFAULT NULL,
  `natimorto_aborto` tinyint(4) DEFAULT NULL,
  `trintaseis_mais` tinyint(4) DEFAULT NULL,
  `menos_vinte` tinyint(4) DEFAULT NULL,
  `sangramento` tinyint(4) DEFAULT NULL,
  `edema` tinyint(4) DEFAULT NULL,
  `diabetes` tinyint(4) DEFAULT NULL,
  `pressao_alta` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `gestante`
--

CREATE TABLE `gestante` (
  `membro_id` int(11) NOT NULL,
  `data_ultimo` date DEFAULT NULL,
  `data_provavel` date DEFAULT NULL,
  `data_vacina` date DEFAULT NULL,
  `data_prenatal` date DEFAULT NULL,
  `fatores_risco_id` int(11) DEFAULT NULL,
  `agente_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `hipertenso`
--

CREATE TABLE `hipertenso` (
  `membro_id` int(11) NOT NULL,
  `fumante` tinyint(4) DEFAULT NULL,
  `faz_dieta` tinyint(4) DEFAULT NULL,
  `toma_medicacao` tinyint(4) DEFAULT NULL,
  `faz_exercicio` tinyint(4) DEFAULT NULL,
  `pressao_arterial` tinyint(4) DEFAULT NULL,
  `data_ultima` date DEFAULT NULL,
  `observacoes` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `membro`
--

CREATE TABLE `membro` (
  `id` int(11) NOT NULL,
  `familia_id` int(11) NOT NULL,
  `cpf` varchar(16) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `idade` int(11) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `escolaridade` varchar(255) DEFAULT NULL,
  `ocupacao` varchar(255) NOT NULL,
  `condicoes_saude` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `situacao`
--

CREATE TABLE `situacao` (
  `familia_id` int(11) NOT NULL,
  `tijolo_adobe` tinyint(1) NOT NULL,
  `taipa_revestida` tinyint(1) NOT NULL,
  `taipa_nao_revistida` tinyint(1) NOT NULL,
  `mandeira` tinyint(1) NOT NULL,
  `material_aproveitado` tinyint(1) NOT NULL,
  `outro_especificar` varchar(255) NOT NULL,
  `numero_comodo` tinyint(1) NOT NULL,
  `energia_eletrica` tinyint(1) NOT NULL,
  `coletado` tinyint(1) NOT NULL,
  `queimado_enterrado` tinyint(1) NOT NULL,
  `ceu_aberto` tinyint(1) NOT NULL,
  `filtracao` tinyint(1) NOT NULL,
  `fervura` tinyint(1) NOT NULL,
  `cloracao` tinyint(1) NOT NULL,
  `sem_tratamento` tinyint(1) NOT NULL,
  `rede_geral` tinyint(1) NOT NULL,
  `poco_nascente` tinyint(1) NOT NULL,
  `outros` tinyint(1) NOT NULL,
  `sistema_esgoto` tinyint(1) NOT NULL,
  `fossa` tinyint(1) NOT NULL,
  `ceu_exposto` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tipo_casa`
--

CREATE TABLE `tipo_casa` (
  `familia_id` int(11) NOT NULL,
  `tijolo_adobe` tinyint(4) DEFAULT NULL,
  `taipa_revestida` tinyint(4) DEFAULT NULL,
  `taipa_nao_revistida` tinyint(4) DEFAULT NULL,
  `mandeira` tinyint(4) DEFAULT NULL,
  `material_aproveitado` tinyint(4) DEFAULT NULL,
  `outro_especificar` varchar(255) DEFAULT NULL,
  `numero_comodo` tinyint(4) DEFAULT NULL,
  `energia_eletrica` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tratamento_agua`
--

CREATE TABLE `tratamento_agua` (
  `familia_id` int(11) NOT NULL,
  `filtracao` tinyint(4) DEFAULT NULL,
  `fervura` tinyint(4) DEFAULT NULL,
  `cloracao` tinyint(4) DEFAULT NULL,
  `sem_tratamento` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `visita`
--

CREATE TABLE `visita` (
  `id` int(11) NOT NULL,
  `familia_id` int(11) NOT NULL,
  `data` date NOT NULL,
  `hora` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `abastecimento_agua`
--
ALTER TABLE `abastecimento_agua`
  ADD PRIMARY KEY (`familia_id`);

--
-- Indexes for table `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `agente`
--
ALTER TABLE `agente`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `destino_fezes`
--
ALTER TABLE `destino_fezes`
  ADD PRIMARY KEY (`familia_id`);

--
-- Indexes for table `destino_lixo`
--
ALTER TABLE `destino_lixo`
  ADD PRIMARY KEY (`familia_id`);

--
-- Indexes for table `diabetico`
--
ALTER TABLE `diabetico`
  ADD PRIMARY KEY (`membro_id`);

--
-- Indexes for table `familia`
--
ALTER TABLE `familia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fatores_risco`
--
ALTER TABLE `fatores_risco`
  ADD PRIMARY KEY (`gestante_id`);

--
-- Indexes for table `gestante`
--
ALTER TABLE `gestante`
  ADD PRIMARY KEY (`membro_id`),
  ADD KEY `fatores_risco_id` (`fatores_risco_id`),
  ADD KEY `agente_id` (`agente_id`);

--
-- Indexes for table `hipertenso`
--
ALTER TABLE `hipertenso`
  ADD PRIMARY KEY (`membro_id`);

--
-- Indexes for table `membro`
--
ALTER TABLE `membro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `familia_id` (`familia_id`);

--
-- Indexes for table `situacao`
--
ALTER TABLE `situacao`
  ADD PRIMARY KEY (`familia_id`);

--
-- Indexes for table `tipo_casa`
--
ALTER TABLE `tipo_casa`
  ADD PRIMARY KEY (`familia_id`);

--
-- Indexes for table `tratamento_agua`
--
ALTER TABLE `tratamento_agua`
  ADD PRIMARY KEY (`familia_id`);

--
-- Indexes for table `visita`
--
ALTER TABLE `visita`
  ADD PRIMARY KEY (`id`),
  ADD KEY `familia_id` (`familia_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `agente`
--
ALTER TABLE `agente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT for table `familia`
--
ALTER TABLE `familia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `membro`
--
ALTER TABLE `membro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `abastecimento_agua`
--
ALTER TABLE `abastecimento_agua`
  ADD CONSTRAINT `fk_abastecimento_agua_familia` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `destino_fezes`
--
ALTER TABLE `destino_fezes`
  ADD CONSTRAINT `fk_destino_fezes_familia` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `destino_lixo`
--
ALTER TABLE `destino_lixo`
  ADD CONSTRAINT `fk_destino_lixo_familia` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `diabetico`
--
ALTER TABLE `diabetico`
  ADD CONSTRAINT `fk_diabetico_membro` FOREIGN KEY (`membro_id`) REFERENCES `membro` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `fatores_risco`
--
ALTER TABLE `fatores_risco`
  ADD CONSTRAINT `fk_fatores_risco_gestante` FOREIGN KEY (`gestante_id`) REFERENCES `gestante` (`membro_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `gestante`
--
ALTER TABLE `gestante`
  ADD CONSTRAINT `fk_gestante_membro` FOREIGN KEY (`membro_id`) REFERENCES `membro` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `hipertenso`
--
ALTER TABLE `hipertenso`
  ADD CONSTRAINT `fk_hipertenso_membro` FOREIGN KEY (`membro_id`) REFERENCES `membro` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `situacao`
--
ALTER TABLE `situacao`
  ADD CONSTRAINT `fk_situacao_familia` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `tipo_casa`
--
ALTER TABLE `tipo_casa`
  ADD CONSTRAINT `fk_tipo_casa_familia` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `tratamento_agua`
--
ALTER TABLE `tratamento_agua`
  ADD CONSTRAINT `fk_tratamento_agua_familia` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
