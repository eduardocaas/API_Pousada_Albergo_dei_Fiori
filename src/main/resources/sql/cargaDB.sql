#SCRIPT DE EXECUÇÃO ÚNICA

/*
 --- CRIAÇÃO DE BANCO DE DADOS ---
*/

DROP DATABASE IF EXISTS albergo_db;
CREATE DATABASE albergo_db;
USE albergo_db;

/*
 --- CRIAÇÃO DE TABELAS ---
*/

DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS cabana_1;
DROP TABLE IF EXISTS cabana_2;
DROP TABLE IF EXISTS cabana_3;
DROP TABLE IF EXISTS cabana_4;

CREATE TABLE usuario
(
    data_nascimento DATETIME(6)  NOT NULL,
    id              BIGINT AUTO_INCREMENT
        PRIMARY KEY,
    cpf             VARCHAR(11)  NOT NULL,
    telefone        VARCHAR(50)  NOT NULL,
    email           VARCHAR(80)  NOT NULL,
    nome            VARCHAR(100) NOT NULL,
    senha           VARCHAR(200) NOT NULL,
    CONSTRAINT UK_5171l57faosmj8myawaucatdw
        UNIQUE (email),
    CONSTRAINT UK_692bsnqxa8m9fmx7m1yc6hsui
        UNIQUE (cpf)
);

CREATE TABLE cabana_1
(
    id     INT AUTO_INCREMENT,
    data   DATE          NOT NULL ,
    status BIT DEFAULT 0 NOT NULL,
    CONSTRAINT cabana_1_pk
        PRIMARY KEY (id)
);

CREATE TABLE cabana_2
(
    id     INT AUTO_INCREMENT,
    data   DATE          NOT NULL ,
    status BIT DEFAULT 0 NOT NULL,
    CONSTRAINT cabana_2_pk
        PRIMARY KEY (id)
);

CREATE TABLE cabana_3
(
    id     INT AUTO_INCREMENT,
    data   DATE          NOT NULL ,
    status BIT DEFAULT 0 NOT NULL,
    CONSTRAINT cabana_3_pk
        PRIMARY KEY (id)
);

CREATE TABLE cabana_4
(
    id     INT AUTO_INCREMENT,
    data   DATE          NOT NULL ,
    status BIT DEFAULT 0 NOT NULL,
    CONSTRAINT cabana_4_pk
        PRIMARY KEY (id)
);

/* --------------------------


 --- CRIAÇÃO DE PROCEDURE - INSERÇÃO DE DATAS PADRÃO (10 ANOS) ---
*/

DROP PROCEDURE IF EXISTS sp_insereDatas;

CREATE PROCEDURE sp_insereDatas(
    IN cabana_num INT)
BEGIN
    DECLARE iterador INT;
    SET iterador = 1;
    WHILE iterador < 3650 DO
        IF (cabana_num = 1) THEN
            INSERT INTO cabana_1 VALUES (NULL, DATE_ADD(CURRENT_DATE, INTERVAL iterador DAY), DEFAULT);
        ELSEIF (cabana_num = 2) THEN
            INSERT INTO cabana_2 VALUES (NULL, DATE_ADD(CURRENT_DATE, INTERVAL iterador DAY), DEFAULT);
        ELSEIF (cabana_num = 3) THEN
            INSERT INTO cabana_3 VALUES (NULL, DATE_ADD(CURRENT_DATE, INTERVAL iterador DAY), DEFAULT);
        ELSEIF (cabana_num = 4) THEN
            INSERT INTO cabana_4 VALUES (NULL, DATE_ADD(CURRENT_DATE, INTERVAL iterador DAY), DEFAULT);
        END IF;
        SET iterador = iterador + 1;
    END WHILE;
END;

/* ---
   EXECUÇÃO PERSISTÊNCIA PROCEDURE - PARA AS 4 TABELAS (CABANA) --- */

CALL sp_insereDatas(1);
CALL sp_insereDatas(2);
CALL sp_insereDatas(3);
CALL sp_insereDatas(4);

/* --------------------------


 --- CRIAÇÃO DE PROCEDURE - ATUALIZAÇÃO DE DATAS ---
*/

DROP PROCEDURE IF EXISTS sp_atualizaData;

CREATE PROCEDURE sp_atualizaData(
    IN cabana_num INT,
    IN dataInicio DATE,
    IN dataFim DATE)
BEGIN
    DECLARE res INT;
    DECLARE dataIteravel DATE;
    SET res = 1;
    SET dataIteravel = dataInicio;
    WHILE dataIteravel <= dataFim
        DO
        IF (cabana_num = 1) THEN
            UPDATE cabana_1 SET status = 1 WHERE data = dataIteravel;
        ELSEIF (cabana_num = 2) THEN
            UPDATE cabana_2 SET status = 1 WHERE data = dataIteravel;
        ELSEIF (cabana_num = 3) THEN
            UPDATE cabana_3 SET status = 1 WHERE data = dataIteravel;
        ELSEIF (cabana_num = 4) THEN
            UPDATE cabana_4 SET status = 1 WHERE data = dataIteravel;
        END IF;
        SET dataIteravel = DATE_ADD(dataIteravel, INTERVAL 1 DAY);
    END WHILE;
    SELECT res AS result;
END;

/* --- EXEMPLO DE EXEUÇÃO:
CALL sp_atualizaData(1, DATE '2023-11-19', DATE '2023-11-23');
 */


 /* --- FIM DO SCRIPT INICIAL --- */