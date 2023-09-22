ALTER TABLE usuarios ADD role varchar(10);
UPDATE usuarios SET role = 'user';