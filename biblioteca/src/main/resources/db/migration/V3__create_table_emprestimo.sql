CREATE TABLE emprestimo (
    id BIGSERIAL PRIMARY KEY,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE,
    livros_id BIGINT NOT NULL,
    usuarios_id BIGINT NOT NULL,

    emprestimo VARCHAR(50) NOT NULL,

    CONSTRAINT fk_emprestimo_livros
        FOREIGN KEY (livros_id) REFERENCES livros(id),
    CONSTRAINT fk_emprestimo_usuarios
        FOREIGN KEY (usuarios_id) REFERENCES usuarios(id)
);