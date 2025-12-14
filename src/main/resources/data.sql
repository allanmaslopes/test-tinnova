-- INSERT DE USUARIOS
INSERT INTO tb_user (id, username, password, role) VALUES ('7487844c-b89c-4207-8ca6-e6761cff0959', 'user', '', 'ROLE_USER');
INSERT INTO tb_user (id, username, password, role) VALUES ('65a146e2-1acb-420d-96f0-57c70dc3d174', 'admin', 'admin', 'ROLE_ADMIN');
-- Alguns veiculos para teste
INSERT INTO tb_car (id, plate, model, make, price, model_year, color, active)
VALUES (71, 'EVL-7957', 'sandeiro', 'renault', 950.50, 2008, 'white', 1);
INSERT INTO tb_car (id, plate, model, make, price, model_year, color, active)
VALUES (72, 'LXL-4557', 'FIT', 'HONDA', 1200.55, 2014, 'BLACK', 1);