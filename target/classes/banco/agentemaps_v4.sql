-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 27-Set-2016 às 21:30
-- Versão do servidor: 5.6.19
-- PHP Version: 5.5.38

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
-- Estrutura da tabela `abastecimento_agua`
--

CREATE TABLE `abastecimento_agua` (
  `familia_id` int(11) NOT NULL,
  `rede_geral` int(11) NOT NULL,
  `poco_nascente` int(11) NOT NULL,
  `outros` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `administrador`
--

CREATE TABLE `administrador` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `login` varchar(30) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `cpf` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `agente`
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

-- --------------------------------------------------------

--
-- Estrutura da tabela `destino_fezes`
--

CREATE TABLE `destino_fezes` (
  `familia_id` int(11) NOT NULL,
  `sistema_esgoto` tinyint(4) DEFAULT NULL,
  `fossa` tinyint(4) DEFAULT NULL,
  `ceu_aberto` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `destino_lixo`
--

CREATE TABLE `destino_lixo` (
  `familia_id` int(11) NOT NULL,
  `coletado` tinyint(4) DEFAULT NULL,
  `queimado_enterrado` tinyint(4) DEFAULT NULL,
  `ceu_aberto` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `diabetico`
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
-- Estrutura da tabela `familia`
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
  `chefe_familia` varchar(255) NOT NULL,
  `cpf_chefe` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fatores_risco`
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
-- Estrutura da tabela `gestante`
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
-- Estrutura da tabela `hipertenso`
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
-- Estrutura da tabela `membro`
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
-- Estrutura da tabela `tipo_casa`
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
-- Estrutura da tabela `tratamento_agua`
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
-- Estrutura da tabela `visita`
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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `agente`
--
ALTER TABLE `agente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `familia`
--
ALTER TABLE `familia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `membro`
--
ALTER TABLE `membro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `abastecimento_agua`
--
ALTER TABLE `abastecimento_agua`
  ADD CONSTRAINT `fk_abastecimento_agua_familia` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limitadores para a tabela `destino_fezes`
--
ALTER TABLE `destino_fezes`
  ADD CONSTRAINT `fk_destino_fezes_familia` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limitadores para a tabela `destino_lixo`
--
ALTER TABLE `destino_lixo`
  ADD CONSTRAINT `fk_destino_lixo_familia` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limitadores para a tabela `diabetico`
--
ALTER TABLE `diabetico`
  ADD CONSTRAINT `fk_diabetico_membro` FOREIGN KEY (`membro_id`) REFERENCES `membro` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limitadores para a tabela `fatores_risco`
--
ALTER TABLE `fatores_risco`
  ADD CONSTRAINT `fk_fatores_risco_gestante` FOREIGN KEY (`gestante_id`) REFERENCES `gestante` (`membro_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limitadores para a tabela `gestante`
--
ALTER TABLE `gestante`
  ADD CONSTRAINT `fk_gestante_membro` FOREIGN KEY (`membro_id`) REFERENCES `membro` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limitadores para a tabela `hipertenso`
--
ALTER TABLE `hipertenso`
  ADD CONSTRAINT `fk_hipertenso_membro` FOREIGN KEY (`membro_id`) REFERENCES `membro` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limitadores para a tabela `tipo_casa`
--
ALTER TABLE `tipo_casa`
  ADD CONSTRAINT `fk_tipo_casa_familia` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limitadores para a tabela `tratamento_agua`
--
ALTER TABLE `tratamento_agua`
  ADD CONSTRAINT `fk_tratamento_agua_familia` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
