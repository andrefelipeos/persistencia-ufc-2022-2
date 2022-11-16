--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3
-- Dumped by pg_dump version 14.3

-- Started on 2022-11-15 21:05:06 -03

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

--
-- TOC entry 4340 (class 1262 OID 16702)
-- Name: persistencia; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE persistencia WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'pt_BR.UTF-8';


ALTER DATABASE persistencia OWNER TO postgres;

\connect persistencia

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

--
-- TOC entry 210 (class 1259 OID 19330)
-- Name: atores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.atores (
    identificador integer NOT NULL,
    data_de_nascimento date,
    nome character varying(255)
);


ALTER TABLE public.atores OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 19329)
-- Name: atores_identificador_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.atores_identificador_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.atores_identificador_seq OWNER TO postgres;

--
-- TOC entry 4341 (class 0 OID 0)
-- Dependencies: 209
-- Name: atores_identificador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.atores_identificador_seq OWNED BY public.atores.identificador;


--
-- TOC entry 212 (class 1259 OID 19337)
-- Name: filmes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.filmes (
    identificador integer NOT NULL,
    ano_de_lancamento integer,
    titulo character varying(255)
);


ALTER TABLE public.filmes OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 19343)
-- Name: filmes_atores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.filmes_atores (
    filmes_identificador integer NOT NULL,
    atores_identificador integer NOT NULL
);


ALTER TABLE public.filmes_atores OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 19336)
-- Name: filmes_identificador_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.filmes_identificador_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.filmes_identificador_seq OWNER TO postgres;

--
-- TOC entry 4342 (class 0 OID 0)
-- Dependencies: 211
-- Name: filmes_identificador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.filmes_identificador_seq OWNED BY public.filmes.identificador;


--
-- TOC entry 4181 (class 2604 OID 19333)
-- Name: atores identificador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atores ALTER COLUMN identificador SET DEFAULT nextval('public.atores_identificador_seq'::regclass);


--
-- TOC entry 4182 (class 2604 OID 19340)
-- Name: filmes identificador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.filmes ALTER COLUMN identificador SET DEFAULT nextval('public.filmes_identificador_seq'::regclass);


--
-- TOC entry 4331 (class 0 OID 19330)
-- Dependencies: 210
-- Data for Name: atores; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.atores VALUES (1, '1989-07-23', 'Daniel Radcliffe');
INSERT INTO public.atores VALUES (2, '1990-04-15', 'Emma Watson');
INSERT INTO public.atores VALUES (3, '1988-08-24', 'Rupert Grint');
INSERT INTO public.atores VALUES (4, '1942-07-13', 'Harrison Ford');
INSERT INTO public.atores VALUES (5, '1980-11-12', 'Ryan Gosling');
INSERT INTO public.atores VALUES (6, '1988-11-06', 'Emma Stone');


--
-- TOC entry 4333 (class 0 OID 19337)
-- Dependencies: 212
-- Data for Name: filmes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.filmes VALUES (1, 2001, 'Harry Potter e a pedra filosofal');
INSERT INTO public.filmes VALUES (2, 2002, 'Harry Potter e câmara secreta');
INSERT INTO public.filmes VALUES (3, 2017, 'Blade Runner 2049');
INSERT INTO public.filmes VALUES (4, 2011, 'Drive');
INSERT INTO public.filmes VALUES (5, 2016, 'La La Land');
INSERT INTO public.filmes VALUES (6, 2014, 'Magia ao luar');


--
-- TOC entry 4334 (class 0 OID 19343)
-- Dependencies: 213
-- Data for Name: filmes_atores; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.filmes_atores VALUES (1, 1);
INSERT INTO public.filmes_atores VALUES (2, 1);
INSERT INTO public.filmes_atores VALUES (1, 2);
INSERT INTO public.filmes_atores VALUES (2, 2);
INSERT INTO public.filmes_atores VALUES (1, 3);
INSERT INTO public.filmes_atores VALUES (2, 3);
INSERT INTO public.filmes_atores VALUES (3, 4);
INSERT INTO public.filmes_atores VALUES (3, 5);
INSERT INTO public.filmes_atores VALUES (4, 5);
INSERT INTO public.filmes_atores VALUES (5, 5);
INSERT INTO public.filmes_atores VALUES (5, 6);
INSERT INTO public.filmes_atores VALUES (6, 6);


--
-- TOC entry 4343 (class 0 OID 0)
-- Dependencies: 209
-- Name: atores_identificador_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.atores_identificador_seq', 6, true);


--
-- TOC entry 4344 (class 0 OID 0)
-- Dependencies: 211
-- Name: filmes_identificador_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.filmes_identificador_seq', 6, true);


--
-- TOC entry 4184 (class 2606 OID 19335)
-- Name: atores atores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atores
    ADD CONSTRAINT atores_pkey PRIMARY KEY (identificador);


--
-- TOC entry 4188 (class 2606 OID 19347)
-- Name: filmes_atores filmes_atores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.filmes_atores
    ADD CONSTRAINT filmes_atores_pkey PRIMARY KEY (filmes_identificador, atores_identificador);


--
-- TOC entry 4186 (class 2606 OID 19342)
-- Name: filmes filmes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.filmes
    ADD CONSTRAINT filmes_pkey PRIMARY KEY (identificador);


--
-- TOC entry 4190 (class 2606 OID 19353)
-- Name: filmes_atores fkppxr1a4qs2u8le6rvxj7gjei0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.filmes_atores
    ADD CONSTRAINT fkppxr1a4qs2u8le6rvxj7gjei0 FOREIGN KEY (filmes_identificador) REFERENCES public.filmes(identificador);


--
-- TOC entry 4189 (class 2606 OID 19348)
-- Name: filmes_atores fkq116ih5nirqsb1cllbj40x81u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.filmes_atores
    ADD CONSTRAINT fkq116ih5nirqsb1cllbj40x81u FOREIGN KEY (atores_identificador) REFERENCES public.atores(identificador);


-- Completed on 2022-11-15 21:05:09 -03

--
-- PostgreSQL database dump complete
--

