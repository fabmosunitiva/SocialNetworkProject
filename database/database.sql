--
-- PostgreSQL database cluster dump
--

-- Started on 2024-04-23 11:24:51

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;

--
-- User Configurations
--








--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Debian 16.2-1.pgdg120+2)
-- Dumped by pg_dump version 16.2

-- Started on 2024-04-23 11:24:51

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

-- Completed on 2024-04-23 11:24:51

--
-- PostgreSQL database dump complete
--

--
-- Database "socialdb" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Debian 16.2-1.pgdg120+2)
-- Dumped by pg_dump version 16.2

-- Started on 2024-04-23 11:24:51

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
-- TOC entry 3457 (class 1262 OID 24584)
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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 24585)
-- Name: commento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commento (
    idcommento bigint NOT NULL,
    corpo character varying(255),
    idpost bigint,
    idutente bigint
);


ALTER TABLE public.commento OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 24626)
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
-- TOC entry 216 (class 1259 OID 24590)
-- Name: like_post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.like_post (
    idpost bigint NOT NULL,
    idutente bigint NOT NULL
);


ALTER TABLE public.like_post OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24593)
-- Name: pagina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagina (
    idpagina bigint NOT NULL,
    descrizione character varying(255),
    nome character varying(255),
    idutente bigint
);


ALTER TABLE public.pagina OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 24600)
-- Name: pagina_post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagina_post (
    id_pagina bigint NOT NULL,
    id_post bigint NOT NULL
);


ALTER TABLE public.pagina_post OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 24627)
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
-- TOC entry 219 (class 1259 OID 24605)
-- Name: post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.post (
    idpost bigint NOT NULL,
    corpo character varying(255),
    titolo character varying(255),
    idutente bigint
);


ALTER TABLE public.post OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 24628)
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
-- TOC entry 220 (class 1259 OID 24612)
-- Name: ruolo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ruolo (
    idruolo bigint NOT NULL,
    descrizione character varying(255)
);


ALTER TABLE public.ruolo OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 24629)
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
-- TOC entry 221 (class 1259 OID 24617)
-- Name: utente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utente (
    idutente bigint NOT NULL,
    cognome character varying(255),
    datanascita date,
    nome character varying(255),
    idruolo bigint
);


ALTER TABLE public.utente OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 24630)
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
-- TOC entry 3440 (class 0 OID 24585)
-- Dependencies: 215
-- Data for Name: commento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commento (idcommento, corpo, idpost, idutente) FROM stdin;
\.


--
-- TOC entry 3441 (class 0 OID 24590)
-- Dependencies: 216
-- Data for Name: like_post; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.like_post (idpost, idutente) FROM stdin;
\.


--
-- TOC entry 3442 (class 0 OID 24593)
-- Dependencies: 217
-- Data for Name: pagina; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagina (idpagina, descrizione, nome, idutente) FROM stdin;
\.


--
-- TOC entry 3443 (class 0 OID 24600)
-- Dependencies: 218
-- Data for Name: pagina_post; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagina_post (id_pagina, id_post) FROM stdin;
\.


--
-- TOC entry 3444 (class 0 OID 24605)
-- Dependencies: 219
-- Data for Name: post; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.post (idpost, corpo, titolo, idutente) FROM stdin;
\.


--
-- TOC entry 3445 (class 0 OID 24612)
-- Dependencies: 220
-- Data for Name: ruolo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ruolo (idruolo, descrizione) FROM stdin;
1	Amministratore
2	Moderatore
3	Utente
\.


--
-- TOC entry 3446 (class 0 OID 24617)
-- Dependencies: 221
-- Data for Name: utente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utente (idutente, cognome, datanascita, nome, idruolo) FROM stdin;
\.


--
-- TOC entry 3458 (class 0 OID 0)
-- Dependencies: 222
-- Name: commento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commento_seq', 1, false);


--
-- TOC entry 3459 (class 0 OID 0)
-- Dependencies: 223
-- Name: pagina_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pagina_seq', 1, false);


--
-- TOC entry 3460 (class 0 OID 0)
-- Dependencies: 224
-- Name: post_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.post_seq', 1, false);


--
-- TOC entry 3461 (class 0 OID 0)
-- Dependencies: 225
-- Name: ruolo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ruolo_seq', 1, false);


--
-- TOC entry 3462 (class 0 OID 0)
-- Dependencies: 226
-- Name: utente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utente_seq', 1, false);


--
-- TOC entry 3275 (class 2606 OID 24589)
-- Name: commento commento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commento
    ADD CONSTRAINT commento_pkey PRIMARY KEY (idcommento);


--
-- TOC entry 3277 (class 2606 OID 24599)
-- Name: pagina pagina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagina
    ADD CONSTRAINT pagina_pkey PRIMARY KEY (idpagina);


--
-- TOC entry 3279 (class 2606 OID 24604)
-- Name: pagina_post pagina_post_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagina_post
    ADD CONSTRAINT pagina_post_pkey PRIMARY KEY (id_pagina, id_post);


--
-- TOC entry 3281 (class 2606 OID 24611)
-- Name: post post_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_pkey PRIMARY KEY (idpost);


--
-- TOC entry 3283 (class 2606 OID 24616)
-- Name: ruolo ruolo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ruolo
    ADD CONSTRAINT ruolo_pkey PRIMARY KEY (idruolo);


--
-- TOC entry 3285 (class 2606 OID 24625)
-- Name: utente uk_8siome9nrptojs98if1i98p0h; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utente
    ADD CONSTRAINT uk_8siome9nrptojs98if1i98p0h UNIQUE (idruolo);


--
-- TOC entry 3287 (class 2606 OID 24623)
-- Name: utente utente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utente
    ADD CONSTRAINT utente_pkey PRIMARY KEY (idutente);


--
-- TOC entry 3296 (class 2606 OID 24671)
-- Name: utente fk11x9qu6ose7vrnj8d9n0oiwqo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utente
    ADD CONSTRAINT fk11x9qu6ose7vrnj8d9n0oiwqo FOREIGN KEY (idruolo) REFERENCES public.ruolo(idruolo);


--
-- TOC entry 3292 (class 2606 OID 24651)
-- Name: pagina fkakouq6bw565r5cftpo6dasu06; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagina
    ADD CONSTRAINT fkakouq6bw565r5cftpo6dasu06 FOREIGN KEY (idutente) REFERENCES public.utente(idutente);


--
-- TOC entry 3293 (class 2606 OID 24656)
-- Name: pagina_post fkcvylocgcdy6nt3ysia6b8jgp4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagina_post
    ADD CONSTRAINT fkcvylocgcdy6nt3ysia6b8jgp4 FOREIGN KEY (id_post) REFERENCES public.pagina(idpagina);


--
-- TOC entry 3290 (class 2606 OID 24641)
-- Name: like_post fkg9pab9yn73x6rw5cdc62lnvd0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.like_post
    ADD CONSTRAINT fkg9pab9yn73x6rw5cdc62lnvd0 FOREIGN KEY (idutente) REFERENCES public.utente(idutente);


--
-- TOC entry 3295 (class 2606 OID 24666)
-- Name: post fkh9y9pq4o96qhjra95puw0jly5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT fkh9y9pq4o96qhjra95puw0jly5 FOREIGN KEY (idutente) REFERENCES public.utente(idutente);


--
-- TOC entry 3294 (class 2606 OID 24661)
-- Name: pagina_post fkj1ph1sewp00jpmj2hkun9byih; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagina_post
    ADD CONSTRAINT fkj1ph1sewp00jpmj2hkun9byih FOREIGN KEY (id_pagina) REFERENCES public.post(idpost);


--
-- TOC entry 3288 (class 2606 OID 24631)
-- Name: commento fklc2fsx85qd6d8l37rdtuqq2x8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commento
    ADD CONSTRAINT fklc2fsx85qd6d8l37rdtuqq2x8 FOREIGN KEY (idpost) REFERENCES public.post(idpost);


--
-- TOC entry 3289 (class 2606 OID 24636)
-- Name: commento fkpjvh5frjed6sjp83wlgj51qw2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commento
    ADD CONSTRAINT fkpjvh5frjed6sjp83wlgj51qw2 FOREIGN KEY (idutente) REFERENCES public.utente(idutente);


--
-- TOC entry 3291 (class 2606 OID 24646)
-- Name: like_post fkqkx5s140srjls8hp4wm9sdou9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.like_post
    ADD CONSTRAINT fkqkx5s140srjls8hp4wm9sdou9 FOREIGN KEY (idpost) REFERENCES public.post(idpost);


-- Completed on 2024-04-23 11:24:52

--
-- PostgreSQL database dump complete
--

-- Completed on 2024-04-23 11:24:52

--
-- PostgreSQL database cluster dump complete
--

