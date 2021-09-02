INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_ADM');
INSERT INTO PERFIL(id, nome) VALUES(2, 'ROLE_USR');

INSERT INTO USUARIO(id, nome, email, senha) VALUES(1,'Administrador', 'adm@email.com', '$2a$10$MiEcjNiew5EEn5AYi2a74O0XVRxpmOihcBplhKB0ES7SEpqwXGA7.');
INSERT INTO USUARIO(id, nome, email, senha) VALUES(2,'Aluno', 'aluno@email.com', '$2a$10$MiEcjNiew5EEn5AYi2a74O0XVRxpmOihcBplhKB0ES7SEpqwXGA7.');

INSERT INTO USUARIO_PERFIL(usuario_id, perfil_id) VALUES(1, 1);
INSERT INTO USUARIO_PERFIL(usuario_id, perfil_id) VALUES(2, 2);

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:50:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 2', 'Projeto não compila', '2020-05-05 19:56:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 3', 'Tag HTML', '2021-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 4', 'Erro ao criar projeto React', '2020-05-05 17:05:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 5', 'Projeto não compila Intellij', '2019-05-05 19:20:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 6', 'CssL', '2021-05-05 21:00:00', 'NAO_RESPONDIDO', 1, 2);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 7', 'Erro ao criar projeto Angular', '2021-05-05 13:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 8', 'Projeto não compila Eclipse', '2017-05-05 19:10:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 9', 'BootStrap', '2020-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 10', 'Erro ao criar projeto Java', '2020-05-05 18:40:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 11', 'Projeto não roda maven', '2021-05-05 16:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 12', 'HTML5 ', '2019-05-05 22:00:00', 'NAO_RESPONDIDO', 1, 2);