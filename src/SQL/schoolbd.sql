-- Crear usuari per a accés local.

CREATE USER 'schoolusr'@'localhost' IDENTIFIED BY 'schoolpsw';

-- Crear base de dades.

CREATE DATABASE dbschool
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

-- Assignar permisos a l'usuari local sobre la base de dades.

GRANT SELECT, INSERT, UPDATE, DELETE ON dbschool.* TO 'schoolusr'@'localhost';

USE dbschool;

-- creació taula students.
CREATE TABLE students (
id INT(4) NOT NULL AUTO_INCREMENT,
name VARCHAR(40) NOT NULL,
age INT(2) NOT NULL,
groupid INT(2) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE = InnoDB;


INSERT INTO students
(`id`, `name`, `age`, `groupid`) VALUES
(1, 'Daniel Morales', 20, 1),
(2, 'Miguel Morales', 20, 2),
(3, 'Daniel Ponce', 21, 3),
(4, 'Antonio Aguilera', 20, 4);

-- creació taula groups.
CREATE TABLE groups (
id INT(4) NOT NULL AUTO_INCREMENT,
code VARCHAR(20) UNIQUE,
grade VARCHAR(50),
level INT(1),
PRIMARY KEY (`id`)
) ENGINE = InnoDB;



INSERT INTO groups
(`id`, `code`, `grade`, `level`) VALUES
(1, 'DAM1', 'Desenvolupament Aplicacions Multiplataforma', 1),
(2, 'DAM2', 'Desenvolupament Aplicacions Multiplataforma', 2),
(3, 'DAW1', 'Desenvolupament Aplicacions Web', 1),
(4, 'DAW2', 'Desenvolupament Aplicacions Web', 2);
