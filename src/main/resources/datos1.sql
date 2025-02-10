-- Inserts para la tabla usuario
INSERT INTO usuario (user_name, email, password) VALUES ('john_doe', 'john.doe@example.com', 'password123');
INSERT INTO usuario (user_name, email, password) VALUES ('jane_smith', 'jane.smith@example.com', 'securepassword');

-- Inserts para la tabla establecimiento
INSERT INTO establecimiento (nombre, descripcion, ubicacion, puntuacion) VALUES ('Café Central', 'Un lugar acogedor para desayunar', 'Calle Mayor, 123', 4.5);
INSERT INTO establecimiento (nombre, descripcion, ubicacion, puntuacion) VALUES ('Panadería La Baguette', 'Desayunos frescos y deliciosos', 'Avenida Libertad, 45', 4.7);

-- Inserts para la tabla desayuno
INSERT INTO desayuno (nombre, precio, imagen, puntuacion, establecimiento_Id) VALUES ('Café con leche', 1.50, 'cafe_con_leche.jpg', 4.8, 1);
INSERT INTO desayuno (nombre, precio, imagen, puntuacion, establecimiento_Id) VALUES ('Croissant', 2.00, 'croissant.jpg', 4.6, 2);