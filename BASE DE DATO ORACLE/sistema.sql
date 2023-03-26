DROP TABLE USUARIO;
CREATE TABLE USUARIO(
LOGIN VARCHAR2(20) PRIMARY KEY,
PASSWORD VARCHAR2(60) NOT NULL,
NOMBRE VARCHAR2(50) NOT NULL,
CLIENTE FLOAT NOT NULL,
EMAIL VARCHAR2(50),
FECHA_ALTA DATE NOT NULL,
FECHA_BAJA DATE,
STATUS CHAR NOT NULL,
INTENTOS FLOAT NOT NULL,
FECHA_REVOCADO  DATE,
FECHA_VIGENCIA DATE,
NO_ACCESO NUMBER DEFAULT 0,
APELLIDO_PATERNO VARCHAR2(50),
APELLIDO_MATERNO VARCHAR2(50),
AREA NUMBER(4),
FECHA_MODIFICACION DATE NOT NULL
);

INSERT INTO USUARIO  VALUES(?,?,?,?,?,SYSDATE,NULL,'A',0,NULL,SYSDATE +7,0,?,?,?,SYSDATE);
--USUARIOS CREADOS DESDE ORACLE
--contraseña=juan
INSERT INTO USUARIO VALUES('jlopez','7QjCkNfiL3uzJLFcutzjWws0hWT9LV+VdSOI2G1xvMo=','Juan',1,'juan@gmail.com',SYSDATE,NULL,'A',0,NULL,SYSDATE+7,0,'Lopez','Sanchez',1,SYSDATE);
--contraseña=pedro
INSERT INTO USUARIO VALUES('ppedro','7lzX1dlsiHQReJGyySoDb5aRjmbBArxpiud1QsGG+YE=','Pedro',2,'jose@gmail.com',SYSDATE,NULL,'A',0,NULL,SYSDATE+7,0,'Perez','Gonzalez',2,SYSDATE);

--contraseña=12345
INSERT INTO USUARIO VALUES('jrobles','WZRHGrsBESr8wYFZ9sx0tPURuZgG2lmzyvWpwXPKz8U=','Jose',3,'pedro@gmail.com',SYSDATE,NULL,'B',0,NULL,SYSDATE+7,0,'Robles','Bermudes',3,SYSDATE);
COMMIT;


SELECT * FROM USUARIO;
DELETE FROM USUARIO;

----secuencia sql de pruebas para el crud de usuario
SELECT U.NOMBRE || ' ' || U.APELLIDO_PATERNO AS NOMBRE, U.LOGIN, U.FECHA_ALTA, U.STATUS FROM USUARIO U WHERE STATUS='A';

SELECT U.NOMBRE, U.LOGIN, TO_CHAR(U.FECHA_ALTA, 'DD/MM/YYYY') AS FECHA_ALTA FROM USUARIO U WHERE STATUS='A';

SELECT U.NOMBRE, U.LOGIN,U.PASSWORD FROM USUARIO U WHERE STATUS='A';
SELECT * FROM USUARIO U WHERE U.LOGIN='ppedro' AND PASSWORD='7lzX1dlsiHQReJGyySoDb5aRjmbBArxpiud1QsGG+YE=';
--ACTUALIZAR STATUS  DEL USUARIO
UPDATE USUARIO SET status='B',fecha_modificacion=SYSDATE, fecha_baja=SYSDATE WHERE LOGIN='ppedro';
--ACTUALIZAR STATUS  DEL USUARIO
UPDATE USUARIO SET status='A',fecha_modificacion=SYSDATE, fecha_baja=SYSDATE WHERE LOGIN='ppedro';

SELECT login,nombre, apellido_paterno,apellido_materno,fecha_baja FROM USUARIO WHERE login='ppedro';
--actualizar registro
UPDATE USUARIO u
SET u.nombre='Jose', u.apellido_paterno='Lopez', u.apellido_materno='Martinez', u.password='123',u.email='jose@gmail.com', u.cliente='3',u.area=3
WHERE u.login='pperez';

SELECT login,nombre,apellido_paterno,apellido_materno,email,password,fecha_baja,cliente, area FROM USUARIO WHERE login='ppedro';
--
SELECT PASSWORD  FROM USUARIO WHERE LOGIN='U1';

--buscar por nombre 
SELECT nombre, login, TO_CHAR(fecha_alta, 'DD/MM/YYYY') AS fecha_alta,status FROM USUARIO WHERE LOWER(nombre) LIKE LOWER('%jose%');

--SENTENCIA  para buscar filtro de busqueda por fecha
SELECT nombre || ' ' || apellido_paterno AS nombre, login, TO_CHAR(fecha_alta, 'DD/MM/YYYY') AS fecha_alta,status FROM USUARIO WHERE FECHA_ALTA BETWEEN to_date('2023-03-24', 'YYYY-MM-DD') AND to_date('2023-03-25', 'YYYY-MM-DD')+1;

--SELECT ADD_DAYS(sysdate, 7) AS fecha_final FROM usuario;
--GUARDAR CUANDO SE GUARDE EL USUARIO
SELECT sysdate + 7 AS fecha_vigencia FROM dual;

--
SELECT TO_CHAR(FECHA_VIGENCIA, 'DD/MM/YYYY' ) AS FECHA_VIGENCIA  FROM USUARIO WHERE LOGIN='ppedro';
--SENTENCIA PARA VALIDAR SI LA FECHA ACTUAL ES MENOR A LA FECHA VIGENCIA
SELECT login, password FROM USUARIO WHERE  SYSDATE < fecha_vigencia AND LOGIN='ppedro';

SELECT login, password FROM USUARIO WHERE FECHA_VIGENCIA > SYSDATE AND LOGIN='ppedro';

UPDATE USUARIO SET fecha_modificacion=SYSDATE, fecha_baja=SYSDATE WHERE LOGIN='ppedro';

SELECT LOGIN FROM USUARIO WHERE LOGIN='jrobles';