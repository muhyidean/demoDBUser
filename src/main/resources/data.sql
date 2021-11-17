
INSERT into USER (id, name) VALUES (111, 'Dean');
INSERT into USER (id, name) VALUES (112, 'Blen');
INSERT into USER (id, name) VALUES (113, 'Samson');
INSERT into USER (id, name) VALUES (114, 'John');

INSERT into POST (id, title, content, author, USER_ID) VALUES (1, 'MIU','Life is structured in layers','Dean', 111);
INSERT into POST (id, title, content, author, USER_ID) VALUES (2, 'React','React is a good SPA library','Dean', 111);
INSERT into POST (id, title, content, author, USER_ID) VALUES (3, 'Spring','Spring is awesome','Blen', 112);
INSERT into POST (id, title, content, author, USER_ID)  VALUES (4, 'SpringBoot','This is a module that works over spring modules','John',114);

-- INSERT into USER_POSTS (USER_ID, POSTS_ID) VALUES (111,1);
-- INSERT into USER_POSTS (USER_ID, POSTS_ID) VALUES (111,2);
-- INSERT into USER_POSTS (USER_ID, POSTS_ID) VALUES (112,3);
-- INSERT into USER_POSTS (USER_ID, POSTS_ID) VALUES (113,4);
