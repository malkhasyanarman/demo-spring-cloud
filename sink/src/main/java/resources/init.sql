CREATE USER fileserviceadmin WITH
    PASSWORD 'Password123'
    LOGIN
    NOSUPERUSER
    INHERIT
    NOCREATEDB
    NOCREATEROLE
    NOREPLICATION;

CREATE DATABASE file_service
WITH
    OWNER = fileserviceadmin
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    TEMPLATE = template0
    CONNECTION LIMIT = -1;

GRANT ALL ON DATABASE file_service TO fileserviceadmin;
GRANT TEMPORARY, CONNECT ON DATABASE file_service TO PUBLIC;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO fileserviceadmin;