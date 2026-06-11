INSERT INTO users (name, email, password, role, status) VALUES
('Administrador del sistema', 'admin@restaurante.com', '1234', 'ADMIN', 'ACTIVO'),
('Mesero Principal', 'mesero@restaurante.com', '1234', 'MESERO', 'ACTIVO');

INSERT INTO pedidos (numero_pedido, cliente, producto, cantidad, valor_unitario, estado, fecha) VALUES
('PED-001', 'Carlos Martínez', 'Almuerzo ejecutivo', 2, 18000, 'PENDIENTE', CURRENT_DATE),
('PED-002', 'Laura Gómez', 'Bandeja especial', 1, 25000, 'EN_PREPARACION', CURRENT_DATE);
