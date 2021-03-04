-- Table: db_prueba."Users"

-- DROP TABLE db_prueba."Users";

CREATE TABLE db_prueba."Users"
(
    "ID_User" bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 99999999999999 CACHE 1 ),
    "Name" character varying(150) COLLATE pg_catalog."default",
    "Login" character varying(30) COLLATE pg_catalog."default",
    "Password" character varying(200) COLLATE pg_catalog."default",
    "Password_alt" character varying(200) COLLATE pg_catalog."default",
    "Mail" character varying(120) COLLATE pg_catalog."default",
    "Enabled" bigint,
    "Edad" bigint,
    "Cargo" character varying(150) COLLATE pg_catalog."default",
    "Fh_Ingreso" date,
    CONSTRAINT "none" PRIMARY KEY ("ID_User")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE db_prueba."Users"
    OWNER to postgres;