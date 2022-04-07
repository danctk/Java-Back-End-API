CREATE TABLE IF NOT EXISTS public.tasks
(
    id SERIAL PRIMARY KEY,
    title character varying(20) COLLATE pg_catalog."default",
    description character varying(100) COLLATE pg_catalog."default",
    due character varying(10) COLLATE pg_catalog."default",
    done boolean
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tasks
    OWNER to postgres;
    
