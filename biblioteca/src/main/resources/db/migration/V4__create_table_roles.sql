CREATE TABLE usuario_roles(
    user_id BIGINT NOT NULL,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY(user_id) REFERENCES usuarios(id) ON DELETE CASCADE
);