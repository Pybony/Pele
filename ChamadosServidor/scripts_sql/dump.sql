SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `chamados` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `chamados` ;

-- -----------------------------------------------------
-- Table `chamados`.`pais`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`pais` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  `sigla` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`estado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`estado` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `pais_id` INT NOT NULL ,
  `sigla` VARCHAR(45) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_estado_pais1_idx` (`pais_id` ASC) ,
  CONSTRAINT `fk_estado_pais1`
    FOREIGN KEY (`pais_id` )
    REFERENCES `chamados`.`pais` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`cidade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`cidade` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `estado_id` INT NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `cep` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_cidade_estado1_idx` (`estado_id` ASC) ,
  CONSTRAINT `fk_cidade_estado1`
    FOREIGN KEY (`estado_id` )
    REFERENCES `chamados`.`estado` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`bairro`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`bairro` (
  `id` INT NOT NULL ,
  `descricao` VARCHAR(45) NOT NULL ,
  `cidade_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_bairro_cidade1_idx` (`cidade_id` ASC) ,
  CONSTRAINT `fk_bairro_cidade1`
    FOREIGN KEY (`cidade_id` )
    REFERENCES `chamados`.`cidade` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`empresa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`empresa` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `cidade_id` INT NOT NULL ,
  `bairro_id` INT NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `cgc` VARCHAR(45) NOT NULL ,
  `endereco` VARCHAR(45) NOT NULL ,
  `telefone` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_cliente_cidade1_idx` (`cidade_id` ASC) ,
  INDEX `fk_cliente_bairro1_idx` (`bairro_id` ASC) ,
  CONSTRAINT `fk_cliente_cidade1`
    FOREIGN KEY (`cidade_id` )
    REFERENCES `chamados`.`cidade` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_bairro1`
    FOREIGN KEY (`bairro_id` )
    REFERENCES `chamados`.`bairro` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`pessoa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`pessoa` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `empresa_id` INT NOT NULL ,
  `cidade_id` INT NOT NULL ,
  `bairro_id` INT NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `idade` INT NOT NULL ,
  `data_nascimento` DATETIME NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `telefone` VARCHAR(45) NOT NULL ,
  `cpf` VARCHAR(45) NOT NULL ,
  `rg` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_pessoa_cliente1_idx` (`empresa_id` ASC) ,
  INDEX `fk_pessoa_cidade1_idx` (`cidade_id` ASC) ,
  INDEX `fk_pessoa_bairro1_idx` (`bairro_id` ASC) ,
  CONSTRAINT `fk_pessoa_cliente1`
    FOREIGN KEY (`empresa_id` )
    REFERENCES `chamados`.`empresa` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pessoa_cidade1`
    FOREIGN KEY (`cidade_id` )
    REFERENCES `chamados`.`cidade` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pessoa_bairro1`
    FOREIGN KEY (`bairro_id` )
    REFERENCES `chamados`.`bairro` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`nivel`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`nivel` (
  `id` INT NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`funcao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`funcao` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nivel_id` INT NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_funcao_nivel1_idx` (`nivel_id` ASC) ,
  CONSTRAINT `fk_funcao_nivel1`
    FOREIGN KEY (`nivel_id` )
    REFERENCES `chamados`.`nivel` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`setor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`setor` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(45) NOT NULL ,
  `senha` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`funcionario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `pessoa_id` INT NOT NULL ,
  `funcao_id` INT NOT NULL ,
  `setor_id` INT NOT NULL ,
  `cidade_id` INT NOT NULL ,
  `bairro_id` INT NOT NULL ,
  `empresa_id` INT NOT NULL ,
  `usuario_id` INT NOT NULL ,
  `data_admicao` DATETIME NOT NULL ,
  `data_desligamento` DATETIME NULL ,
  INDEX `fk_call_funcionario_call_pessoa` (`pessoa_id` ASC) ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_call_funcionario_funcao1_idx` (`funcao_id` ASC) ,
  INDEX `fk_funcionario_setor1_idx` (`setor_id` ASC) ,
  INDEX `fk_funcionario_cidade1_idx` (`cidade_id` ASC) ,
  INDEX `fk_funcionario_bairro1_idx` (`bairro_id` ASC) ,
  INDEX `fk_funcionario_cliente1_idx` (`empresa_id` ASC) ,
  INDEX `fk_funcionario_usuario1` (`usuario_id` ASC) ,
  CONSTRAINT `fk_call_funcionario_call_pessoa`
    FOREIGN KEY (`pessoa_id` )
    REFERENCES `chamados`.`pessoa` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_call_funcionario_funcao1`
    FOREIGN KEY (`funcao_id` )
    REFERENCES `chamados`.`funcao` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_setor1`
    FOREIGN KEY (`setor_id` )
    REFERENCES `chamados`.`setor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_cidade1`
    FOREIGN KEY (`cidade_id` )
    REFERENCES `chamados`.`cidade` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_bairro1`
    FOREIGN KEY (`bairro_id` )
    REFERENCES `chamados`.`bairro` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_cliente1`
    FOREIGN KEY (`empresa_id` )
    REFERENCES `chamados`.`empresa` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_usuario1`
    FOREIGN KEY (`usuario_id` )
    REFERENCES `chamados`.`usuario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`categoria_um`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`categoria_um` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`tipo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`tipo` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`prioridade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`prioridade` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`origim`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`origim` (
  `id` INT NOT NULL ,
  `descricao` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`situacao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`situacao` (
  `id` INT NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`chamado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`chamado` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `empresa_id` INT NULL ,
  `pessoa_id` INT NULL ,
  `categoria_um_id` INT NOT NULL ,
  `funcionario_id` INT NULL ,
  `tipo_id` INT NOT NULL ,
  `prioridade_id` INT NOT NULL ,
  `origem_id` INT NOT NULL ,
  `situacao_id` INT NOT NULL ,
  `id_chamado_principal` INT NULL ,
  `id_abertura` INT NOT NULL ,
  `titulo` VARCHAR(45) NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  `data_abertura` DATETIME NULL ,
  `data_fechamento` DATETIME NULL ,
  `data_prevista` DATETIME NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_call_chamado_categoria_um1_idx` (`categoria_um_id` ASC) ,
  INDEX `fk_call_chamado_call_funcionario1_idx` (`funcionario_id` ASC) ,
  INDEX `fk_call_chamado_tipo1_idx` (`tipo_id` ASC) ,
  INDEX `fk_call_chamado_prioridade1_idx` (`prioridade_id` ASC) ,
  INDEX `fk_call_chamado_origim1_idx` (`origem_id` ASC) ,
  INDEX `fk_call_chamado_call_chamado1_idx` (`id_chamado_principal` ASC) ,
  INDEX `fk_call_chamado_situacao1_idx` (`situacao_id` ASC) ,
  INDEX `fk_chamado_cliente1` (`empresa_id` ASC) ,
  INDEX `fk_chamado_pessoa1` (`pessoa_id` ASC) ,
  CONSTRAINT `fk_call_chamado_categoria_um1`
    FOREIGN KEY (`categoria_um_id` )
    REFERENCES `chamados`.`categoria_um` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_call_chamado_call_funcionario1`
    FOREIGN KEY (`funcionario_id` )
    REFERENCES `chamados`.`funcionario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_call_chamado_tipo1`
    FOREIGN KEY (`tipo_id` )
    REFERENCES `chamados`.`tipo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_call_chamado_prioridade1`
    FOREIGN KEY (`prioridade_id` )
    REFERENCES `chamados`.`prioridade` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_call_chamado_origim1`
    FOREIGN KEY (`origem_id` )
    REFERENCES `chamados`.`origim` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_call_chamado_call_chamado1`
    FOREIGN KEY (`id_chamado_principal` )
    REFERENCES `chamados`.`chamado` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_call_chamado_situacao1`
    FOREIGN KEY (`situacao_id` )
    REFERENCES `chamados`.`situacao` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chamado_cliente1`
    FOREIGN KEY (`empresa_id` )
    REFERENCES `chamados`.`empresa` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chamado_pessoa1`
    FOREIGN KEY (`pessoa_id` )
    REFERENCES `chamados`.`pessoa` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`acompanhamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`acompanhamento` (
  `id` INT NOT NULL ,
  `descricao` VARCHAR(100) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`interacao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`interacao` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `chamado_id` INT NOT NULL ,
  `acompanhamento_id` INT NOT NULL ,
  `descricao` VARCHAR(45) NOT NULL ,
  `data` DATETIME NOT NULL DEFAULT now() ,
  `autor_id` INT NULL ,
  `tipoAutor` CHAR NULL ,
  `solucao` TINYINT(1)  NULL ,
  `privado` TINYINT(1)  NULL ,
  `email` TINYINT(1)  NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_call_interacao_call_chamado1_idx` (`chamado_id` ASC) ,
  INDEX `fk_interacao_acompanhamento1_idx` (`acompanhamento_id` ASC) ,
  CONSTRAINT `fk_call_interacao_call_chamado1`
    FOREIGN KEY (`chamado_id` )
    REFERENCES `chamados`.`chamado` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_interacao_acompanhamento1`
    FOREIGN KEY (`acompanhamento_id` )
    REFERENCES `chamados`.`acompanhamento` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`categoria_dois`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`categoria_dois` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `categoria_um_id` INT NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_categoria_dois_categoria_um1_idx` (`categoria_um_id` ASC) ,
  CONSTRAINT `fk_categoria_dois_categoria_um1`
    FOREIGN KEY (`categoria_um_id` )
    REFERENCES `chamados`.`categoria_um` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`categoria_tres`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`categoria_tres` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `categoria_dois_id` INT NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_categoria_tres_categoria_dois1_idx` (`categoria_dois_id` ASC) ,
  CONSTRAINT `fk_categoria_tres_categoria_dois1`
    FOREIGN KEY (`categoria_dois_id` )
    REFERENCES `chamados`.`categoria_dois` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`tela`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`tela` (
  `id` INT NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chamados`.`permissoes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `chamados`.`permissoes` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `usuario_id` INT NOT NULL ,
  `tela_id` INT NOT NULL ,
  `alterar` TINYINT(1)  NULL ,
  `inserir` TINYINT(1)  NULL ,
  `deletar` TINYINT(1)  NULL ,
  `consultar` TINYINT(1)  NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_permissoes_usuario1` (`usuario_id` ASC) ,
  INDEX `fk_permissoes_tela1` (`tela_id` ASC) ,
  CONSTRAINT `fk_permissoes_usuario1`
    FOREIGN KEY (`usuario_id` )
    REFERENCES `chamados`.`usuario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_permissoes_tela1`
    FOREIGN KEY (`tela_id` )
    REFERENCES `chamados`.`tela` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
