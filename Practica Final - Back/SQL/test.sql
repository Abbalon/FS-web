DROP schema `practica_test` ;
CREATE SCHEMA `practica_test` ;

-- EMPLEADOS

INSERT INTO `practica_test`.`em_empleados` (`TX_NIF`, `TX_NOMBRE`, `TX_APELLIDO1`, `TX_APELLIDO2`, `F_NACIMIENTO`, `N_TELEFONO1`, `N_TELEFONO2`, `TX_EMAIL`, `F_ALTA`, `CX_EDOCIVIL`, `B_SERVMILITAR`) VALUES ( '123456789', 'Empleado', 'Asignado', 'a un proyecto', '2001-09-21', 'N_TELEFONO1', 'N_TELEFONO2', 'TX_EMAIL', '2018-04-21', 'S', 'N');
INSERT INTO `practica_test`.`em_empleados` (`TX_NIF`, `TX_NOMBRE`, `TX_APELLIDO1`, `TX_APELLIDO2`, `F_NACIMIENTO`, `N_TELEFONO1`, `N_TELEFONO2`, `TX_EMAIL`, `F_ALTA`, `CX_EDOCIVIL`, `B_SERVMILITAR`) VALUES ( '223456789', 'Empleado', 'No asignado', 'a un proyecto', '2001-09-21', 'N_TELEFONO1', 'N_TELEFONO2', 'TX_EMAIL_2', '2018-04-21', 'S', 'N');
INSERT INTO `practica_test`.`em_empleados` 
	(`TX_NIF`, `TX_NOMBRE`, `TX_APELLIDO1`, `TX_APELLIDO2`, `F_NACIMIENTO`, `N_TELEFONO1`, `N_TELEFONO2`, `TX_EMAIL`, `F_ALTA`, `CX_EDOCIVIL`, `B_SERVMILITAR`, `F_BAJA`) 
VALUES 
	( '113456789', 'TX_NOMBRE', 'TX_APELLIDO1', 'TX_APELLIDO2', '2001-09-21', 'N_TELEFONO1', 'N_TELEFONO2', 'TX_EMAIL2', '2018-04-21', 'S', 'N','2020-01-01');
INSERT INTO `practica_test`.`em_empleados` 
	(`ID_EMPLEADO`,`TX_NIF`, `TX_NOMBRE`, `TX_APELLIDO1`, `TX_APELLIDO2`, `F_NACIMIENTO`, `N_TELEFONO1`, `N_TELEFONO2`, `TX_EMAIL`, `F_ALTA`, `CX_EDOCIVIL`, `B_SERVMILITAR`) 
VALUES 
	( '1','111111111', 'TX_NOMBRE', 'TX_APELLIDO1', 'TX_APELLIDO2', '2001-09-21', 'N_TELEFONO1', 'N_TELEFONO2', 'TX_EMAIL11', '2018-04-21', 'S', 'N');


SELECT 
    *
FROM
    practica_test.em_empleados;
    
--  PROYECTOS

INSERT INTO `practica_test`.`pr_proyectos` (`f_Inicio`, `tx_Descripcion`, `tx_Lugar`, `tx_Observaciones`) VALUES ('2018-05-15', 'Proyecto con asignaciones', '', '');
INSERT INTO `practica_test`.`pr_proyectos` (`f_Inicio`, `tx_Descripcion`, `tx_Lugar`, `tx_Observaciones`) VALUES ('2018-05-15', 'Proyecto sin asignaciones', '', '');
INSERT INTO `practica_test`.`pr_proyectos` 
		(`id_proyecto`,`f_Inicio`, `tx_Descripcion`, `tx_Lugar`, `tx_Observaciones`) 
	VALUES 
		('1','2018-04-21', 'tx_Description', 'tx_Lugar', 'tx_Observaciones');

SELECT * FROM practica_test.pr_proyectos;

-- EMPLEADOS-PROYECTO

INSERT INTO `practica_test`.`pr_empleados_proyecto` (`id_Empleado`, `id_Proyecto`, `f_Alta`) VALUES (1, 1, '2018-05-10');
-- INSERT INTO `practica_test`.`pr_empleados_proyecto` (`id_Empleado`, `id_Proyecto`, `f_Alta`) VALUES (15, 15, NULL);
DELETE FROM `practica_test`.`pr_empleados_proyecto` WHERE `id_Empleado`='15' and`id_Proyecto`='15';



SELECT * FROM practica_test.pr_empleados_proyecto;
