INSERT into USER (id, name, username, password, IS_Enabled)  VALUES (111, 'Dean','dean','$2y$12$ZULYuC/Cz4RQhK4DngP8s.SfhJA35gNayrpKGZTHCryBvcnKL8u4a',true);
INSERT into USER (id, name, username, password, IS_Enabled)  VALUES (112, 'Zaineh','zaineh','$2y$12$ZULYuC/Cz4RQhK4DngP8s.SfhJA35gNayrpKGZTHCryBvcnKL8u4a',true);

INSERT into POST (id, title, content, author, USER_ID) VALUES (1, 'MIU','Life is structured in layers','Dean', 111);
INSERT into POST (id, title, content, author, USER_ID) VALUES (2, 'React','React is a good SPA library','Dean', 111);
INSERT into POST (id, title, content, author, USER_ID) VALUES (3, 'Spring','Spring is awesome','Blen', 112);
INSERT into POST (id, title, content, author, USER_ID)  VALUES (4, 'SpringBoot','This is a module that works over spring modules','John',112);

INSERT INTO ROLE(ROLE_ID, ROLE) VALUES (1, 'USER');
INSERT INTO ROLE(ROLE_ID, ROLE) VALUES (2, 'ADMIN');

insert into USER_ROLES(USER_ID, ROLE_ID) values (111, 2);
insert into USER_ROLES(USER_ID, ROLE_ID) values (112, 1);