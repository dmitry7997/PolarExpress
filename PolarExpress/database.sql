SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

CREATE TABLE public.post_mail (
    id integer NOT NULL,
    recipient character varying(250),
    type character varying(250),
    recipient_postcode integer,
    recipient_address character varying(250),
    status character varying(250)
);

ALTER TABLE public.post_mail OWNER TO postgres;

CREATE TABLE public.post_office (
    id integer NOT NULL,
    postcode integer,
    name character varying(250),
    address character varying(250)
);

ALTER TABLE public.post_office OWNER TO postgres;

CREATE TABLE public.tracking (
    moving character varying(250),
    creation_date time with time zone,
    post_office_id integer,
    post_mail_id integer,
    id integer NOT NULL,
    CONSTRAINT check_moving_values CHECK (((moving)::text = ANY ((ARRAY['Регистрация'::character varying, 'Прибытие'::character varying, 'Убытие'::character varying, 'Получение'::character varying])::text[])))
);

ALTER TABLE public.tracking OWNER TO postgres;

CREATE SEQUENCE public.tracking_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.tracking_id_seq OWNER TO postgres;

ALTER SEQUENCE public.tracking_id_seq OWNED BY public.tracking.id;

ALTER TABLE ONLY public.tracking ALTER COLUMN id SET DEFAULT nextval('public.tracking_id_seq'::regclass);

INSERT INTO public.post_mail (id, recipient, type, recipient_postcode, recipient_address, status) VALUES (1, 'Ann', 'Письмо', 245862, 'Белгородская область, город Шатура, ул. Космонавтов, 84', 'Заказное');
INSERT INTO public.post_mail (id, recipient, type, recipient_postcode, recipient_address, status) VALUES (2, 'Helen', 'Посылка', 238530, 'Калининградская область, город Зеленоградск, ул. Приморская 31', 'Срочное');
INSERT INTO public.post_mail (id, recipient, type, recipient_postcode, recipient_address, status) VALUES (3, 'Sarah', 'Бандероль', 301177, 'Архангельская область, город Одинцово, пер. 1905 года, 81', 'Международное');
INSERT INTO public.post_mail (id, recipient, type, recipient_postcode, recipient_address, status) VALUES (4, 'Andrew', 'Открытка', 809402, 'Новосибирская область, город Лотошино, спуск Славы, 87', 'Международное');
INSERT INTO public.post_mail (id, recipient, type, recipient_postcode, recipient_address, status) VALUES (5, 'Antony', 'Посылка', 445360, 'Новосибирская область, город Луховицы, пр. Гоголя, 15', 'Срочное');

INSERT INTO public.post_office (id, postcode, name, address) VALUES (1, 245862, 'Шатура', 'Белгородская область, город Шатура, ул. Космонавтов, 84');
INSERT INTO public.post_office (id, postcode, name, address) VALUES (2, 238530, 'Зеленоградск', 'Калининградская область, город Зеленоградск, ул. Приморская 31');
INSERT INTO public.post_office (id, postcode, name, address) VALUES (3, 301177, 'Одинцово', 'Архангельская область, город Одинцово, пер. 1905 года, 81');
INSERT INTO public.post_office (id, postcode, name, address) VALUES (4, 809402, 'Лотошино', 'Новосибирская область, город Лотошино, спуск Славы, 87');
INSERT INTO public.post_office (id, postcode, name, address) VALUES (5, 445360, 'Луховицы', 'Новосибирская область, город Луховицы, пр. Гоголя, 15');

INSERT INTO public.tracking (moving, creation_date, post_office_id, post_mail_id, id) VALUES ('Регистрация', NULL, 1, 2, 1);
INSERT INTO public.tracking (moving, creation_date, post_office_id, post_mail_id, id) VALUES ('Убытие', NULL, 1, 2, 2);
INSERT INTO public.tracking (moving, creation_date, post_office_id, post_mail_id, id) VALUES ('Прибытие', NULL, 2, 2, 3);
INSERT INTO public.tracking (moving, creation_date, post_office_id, post_mail_id, id) VALUES ('Убытие', NULL, 2, 2, 4);
INSERT INTO public.tracking (moving, creation_date, post_office_id, post_mail_id, id) VALUES ('Прибытие', NULL, 4, 2, 5);
INSERT INTO public.tracking (moving, creation_date, post_office_id, post_mail_id, id) VALUES ('Получение', NULL, 4, 2, 6);
INSERT INTO public.tracking (moving, creation_date, post_office_id, post_mail_id, id) VALUES ('Регистрация', '18:24:53.562157+03', 4, 1, 7);
INSERT INTO public.tracking (moving, creation_date, post_office_id, post_mail_id, id) VALUES ('Регистрация', '18:25:37.913683+03', 4, 1, 8);
INSERT INTO public.tracking (moving, creation_date, post_office_id, post_mail_id, id) VALUES ('Убытие', '18:34:35.699453+03', 4, 1, 9);
INSERT INTO public.tracking (moving, creation_date, post_office_id, post_mail_id, id) VALUES ('Прибытие', '19:21:26.983291+03', 5, 1, 10);
INSERT INTO public.tracking (moving, creation_date, post_office_id, post_mail_id, id) VALUES ('Получение', '19:28:13.075073+03', 5, 1, 11);
INSERT INTO public.tracking (moving, creation_date, post_office_id, post_mail_id, id) VALUES ('Получение', '20:39:02.425938+03', 3, 1, 13);

SELECT pg_catalog.setval('public.tracking_id_seq', 13, true);

ALTER TABLE ONLY public.post_mail
    ADD CONSTRAINT post_mail_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.post_office
    ADD CONSTRAINT post_office_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.tracking
    ADD CONSTRAINT tracking_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.tracking
    ADD CONSTRAINT post_mail_id FOREIGN KEY (post_mail_id) REFERENCES public.post_mail(id) NOT VALID;

ALTER TABLE ONLY public.tracking
    ADD CONSTRAINT post_office_id FOREIGN KEY (post_office_id) REFERENCES public.post_office(id) NOT VALID;
