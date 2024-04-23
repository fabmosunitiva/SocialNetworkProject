--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Debian 16.2-1.pgdg120+2)
-- Dumped by pg_dump version 16.2

-- Started on 2024-04-23 09:29:37

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

DROP DATABASE socialdb;
--
-- TOC entry 3420 (class 1262 OID 16572)
-- Name: socialdb; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE socialdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE socialdb OWNER TO postgres;

\connect socialdb

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
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 3421 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 220 (class 1259 OID 24764)
-- Name: commento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commento (
    idcommento bigint NOT NULL,
    idpost bigint,
    idutente bigint,
    corpo character varying(255)
);


ALTER TABLE public.commento OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24761)
-- Name: commento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commento_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.commento_seq OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 24769)
-- Name: like_post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.like_post (
    idpost bigint NOT NULL,
    idutente bigint NOT NULL
);


ALTER TABLE public.like_post OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 24772)
-- Name: pagina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagina (
    idpagina bigint NOT NULL,
    idutente bigint,
    descrizione character varying(255),
    nome character varying(255)
);


ALTER TABLE public.pagina OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 24779)
-- Name: pagina_post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagina_post (
    id_pagina bigint NOT NULL,
    id_post bigint NOT NULL
);


ALTER TABLE public.pagina_post OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 24762)
-- Name: pagina_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pagina_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pagina_seq OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 24785)
-- Name: post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.post (
    idpost bigint NOT NULL,
    idutente bigint,
    corpo character varying(255),
    titolo character varying(255)
);


ALTER TABLE public.post OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 24784)
-- Name: post_idpost_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.post_idpost_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.post_idpost_seq OWNER TO postgres;

--
-- TOC entry 3422 (class 0 OID 0)
-- Dependencies: 224
-- Name: post_idpost_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.post_idpost_seq OWNED BY public.post.idpost;


--
-- TOC entry 215 (class 1259 OID 24578)
-- Name: post_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.post_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.post_seq OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 24794)
-- Name: ruolo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ruolo (
    idruolo bigint NOT NULL,
    descrizione character varying(255)
);


ALTER TABLE public.ruolo OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 24793)
-- Name: ruolo_idruolo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ruolo_idruolo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ruolo_idruolo_seq OWNER TO postgres;

--
-- TOC entry 3423 (class 0 OID 0)
-- Dependencies: 226
-- Name: ruolo_idruolo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ruolo_idruolo_seq OWNED BY public.ruolo.idruolo;


--
-- TOC entry 216 (class 1259 OID 24579)
-- Name: ruolo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ruolo_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ruolo_seq OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 24800)
-- Name: utente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utente (
    datanascita date,
    idruolo bigint,
    idutente bigint NOT NULL,
    cognome character varying(255),
    nome character varying(255)
);


ALTER TABLE public.utente OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 24763)
-- Name: utente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.utente_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.utente_seq OWNER TO postgres;

--
-- TOC entry 3233 (class 2604 OID 24788)
-- Name: post idpost; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post ALTER COLUMN idpost SET DEFAULT nextval('public.post_idpost_seq'::regclass);


--
-- TOC entry 3234 (class 2604 OID 24797)
-- Name: ruolo idruolo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ruolo ALTER COLUMN idruolo SET DEFAULT nextval('public.ruolo_idruolo_seq'::regclass);


--
-- TOC entry 3406 (class 0 OID 24764)
-- Dependencies: 220
-- Data for Name: commento; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3407 (class 0 OID 24769)
-- Dependencies: 221
-- Data for Name: like_post; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3408 (class 0 OID 24772)
-- Dependencies: 222
-- Data for Name: pagina; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3409 (class 0 OID 24779)
-- Dependencies: 223
-- Data for Name: pagina_post; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3411 (class 0 OID 24785)
-- Dependencies: 225
-- Data for Name: post; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3413 (class 0 OID 24794)
-- Dependencies: 227
-- Data for Name: ruolo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.ruolo VALUES (1, 'Amministratore');
INSERT INTO public.ruolo VALUES (2, 'Moderatore');
INSERT INTO public.ruolo VALUES (3, 'Utente');


--
-- TOC entry 3414 (class 0 OID 24800)
-- Dependencies: 228
-- Data for Name: utente; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3424 (class 0 OID 0)
-- Dependencies: 217
-- Name: commento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commento_seq', 1, false);


--
-- TOC entry 3425 (class 0 OID 0)
-- Dependencies: 218
-- Name: pagina_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pagina_seq', 1, false);


--
-- TOC entry 3426 (class 0 OID 0)
-- Dependencies: 224
-- Name: post_idpost_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.post_idpost_seq', 1, false);


--
-- TOC entry 3427 (class 0 OID 0)
-- Dependencies: 215
-- Name: post_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.post_seq', 1, false);


--
-- TOC entry 3428 (class 0 OID 0)
-- Dependencies: 226
-- Name: ruolo_idruolo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ruolo_idruolo_seq', 1, false);


--
-- TOC entry 3429 (class 0 OID 0)
-- Dependencies: 216
-- Name: ruolo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ruolo_seq', 1, false);


--
-- TOC entry 3430 (class 0 OID 0)
-- Dependencies: 219
-- Name: utente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utente_seq', 1, false);


--
-- TOC entry 3236 (class 2606 OID 24768)
-- Name: commento commento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commento
    ADD CONSTRAINT commento_pkey PRIMARY KEY (idcommento);


--
-- TOC entry 3238 (class 2606 OID 24778)
-- Name: pagina pagina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagina
    ADD CONSTRAINT pagina_pkey PRIMARY KEY (idpagina);


--
-- TOC entry 3240 (class 2606 OID 24783)
-- Name: pagina_post pagina_post_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagina_post
    ADD CONSTRAINT pagina_post_pkey PRIMARY KEY (id_pagina, id_post);


--
-- TOC entry 3242 (class 2606 OID 24792)
-- Name: post post_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_pkey PRIMARY KEY (idpost);


--
-- TOC entry 3244 (class 2606 OID 24799)
-- Name: ruolo ruolo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ruolo
    ADD CONSTRAINT ruolo_pkey PRIMARY KEY (idruolo);


--
-- TOC entry 3246 (class 2606 OID 24808)
-- Name: utente utente_idruolo_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utente
    ADD CONSTRAINT utente_idruolo_key UNIQUE (idruolo);


--
-- TOC entry 3248 (class 2606 OID 24806)
-- Name: utente utente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utente
    ADD CONSTRAINT utente_pkey PRIMARY KEY (idutente);


--
-- TOC entry 3257 (class 2606 OID 24849)
-- Name: utente fk11x9qu6ose7vrnj8d9n0oiwqo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utente
    ADD CONSTRAINT fk11x9qu6ose7vrnj8d9n0oiwqo FOREIGN KEY (idruolo) REFERENCES public.ruolo(idruolo);


--
-- TOC entry 3253 (class 2606 OID 24829)
-- Name: pagina fkakouq6bw565r5cftpo6dasu06; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagina
    ADD CONSTRAINT fkakouq6bw565r5cftpo6dasu06 FOREIGN KEY (idutente) REFERENCES public.utente(idutente);


--
-- TOC entry 3254 (class 2606 OID 24834)
-- Name: pagina_post fkcvylocgcdy6nt3ysia6b8jgp4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagina_post
    ADD CONSTRAINT fkcvylocgcdy6nt3ysia6b8jgp4 FOREIGN KEY (id_post) REFERENCES public.pagina(idpagina);


--
-- TOC entry 3251 (class 2606 OID 24819)
-- Name: like_post fkg9pab9yn73x6rw5cdc62lnvd0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.like_post
    ADD CONSTRAINT fkg9pab9yn73x6rw5cdc62lnvd0 FOREIGN KEY (idutente) REFERENCES public.utente(idutente);


--
-- TOC entry 3256 (class 2606 OID 24844)
-- Name: post fkh9y9pq4o96qhjra95puw0jly5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT fkh9y9pq4o96qhjra95puw0jly5 FOREIGN KEY (idutente) REFERENCES public.utente(idutente);


--
-- TOC entry 3255 (class 2606 OID 24839)
-- Name: pagina_post fkj1ph1sewp00jpmj2hkun9byih; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagina_post
    ADD CONSTRAINT fkj1ph1sewp00jpmj2hkun9byih FOREIGN KEY (id_pagina) REFERENCES public.post(idpost);


--
-- TOC entry 3249 (class 2606 OID 24809)
-- Name: commento fklc2fsx85qd6d8l37rdtuqq2x8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commento
    ADD CONSTRAINT fklc2fsx85qd6d8l37rdtuqq2x8 FOREIGN KEY (idpost) REFERENCES public.post(idpost);


--
-- TOC entry 3250 (class 2606 OID 24814)
-- Name: commento fkpjvh5frjed6sjp83wlgj51qw2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commento
    ADD CONSTRAINT fkpjvh5frjed6sjp83wlgj51qw2 FOREIGN KEY (idutente) REFERENCES public.utente(idutente);


--
-- TOC entry 3252 (class 2606 OID 24824)
-- Name: like_post fkqkx5s140srjls8hp4wm9sdou9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.like_post
    ADD CONSTRAINT fkqkx5s140srjls8hp4wm9sdou9 FOREIGN KEY (idpost) REFERENCES public.post(idpost);


-- Completed on 2024-04-23 09:29:38

--
-- PostgreSQL database dump complete
--

