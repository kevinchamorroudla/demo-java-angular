INSERT INTO clientes(id, identificacion, nombre)
VALUES (nextval('hibernate_sequence'), '1799999999001', 'Udla');

INSERT INTO clientes(id, identificacion, nombre)
VALUES (nextval('hibernate_sequence'), '1799999998001', 'Supermaxi');

INSERT INTO clientes(id, identificacion, nombre)
VALUES (nextval('hibernate_sequence'), '1799999997001', 'Cigarra');

INSERT INTO clientes(id, identificacion, nombre)
VALUES (nextval('hibernate_sequence'), '1799999969001', 'whatever');

INSERT INTO contratos(id, descripcion, monto, cliente_id)
VALUES (nextval('hibernate_sequence'), 'Tour Virtual Udla', 4000,
        (select id from clientes where nombre = 'Udla' fetch first 1 row only ));

INSERT INTO contratos(id, descripcion, monto, cliente_id)
VALUES (nextval('hibernate_sequence'), 'SEO Website', 2000,
        (select id from clientes where nombre = 'Udla' fetch first 1 row only ));

INSERT INTO contratos(id, descripcion, monto, cliente_id)
VALUES (nextval('hibernate_sequence'), 'Nueva App Movil', 6000,
        (select id from clientes where nombre = 'Supermaxi' fetch first 1 row only ));

INSERT INTO contratos(id, descripcion, monto, cliente_id)
VALUES (nextval('hibernate_sequence'), 'Facturación electronica', 2500,
        (select id from clientes where nombre = 'Cigarra' fetch first 1 row only ));
