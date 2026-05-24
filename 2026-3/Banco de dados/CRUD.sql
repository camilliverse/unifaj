CREATE USER 'crud'@'localhost' IDENTIFIED BY '2006';

GRANT SELECT, INSERT, UPDATE, DELETE
ON primeiro_db.*
TO 'crud'@'localhost';