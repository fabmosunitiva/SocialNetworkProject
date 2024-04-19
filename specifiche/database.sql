--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Debian 16.2-1.pgdg120+2)
-- Dumped by pg_dump version 16.2

-- Started on 2024-04-19 13:01:39

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

DROP DATABASE postgres;
--
-- TOC entry 3430 (class 1262 OID 5)
-- Name: postgres; Type: DATABASE; Schema: -; Owner: my_custom_user
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE postgres OWNER TO my_custom_user;

\connect postgres

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
-- TOC entry 3431 (class 0 OID 0)
-- Dependencies: 3430
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: my_custom_user
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 6 (class 2615 OID 16389)
-- Name: social; Type: SCHEMA; Schema: -; Owner: my_custom_user
--

CREATE SCHEMA social;


ALTER SCHEMA social OWNER TO my_custom_user;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 223 (class 1259 OID 24690)
-- Name: commento; Type: TABLE; Schema: social; Owner: my_custom_user
--

CREATE TABLE social.commento (
    idcommento integer NOT NULL,
    corpo character varying,
    idpost integer NOT NULL,
    idutente integer NOT NULL
);


ALTER TABLE social.commento OWNER TO my_custom_user;

--
-- TOC entry 222 (class 1259 OID 24689)
-- Name: commento_idcommento_seq; Type: SEQUENCE; Schema: social; Owner: my_custom_user
--

CREATE SEQUENCE social.commento_idcommento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE social.commento_idcommento_seq OWNER TO my_custom_user;

--
-- TOC entry 3432 (class 0 OID 0)
-- Dependencies: 222
-- Name: commento_idcommento_seq; Type: SEQUENCE OWNED BY; Schema: social; Owner: my_custom_user
--

ALTER SEQUENCE social.commento_idcommento_seq OWNED BY social.commento.idcommento;


--
-- TOC entry 228 (class 1259 OID 24733)
-- Name: like_post; Type: TABLE; Schema: social; Owner: my_custom_user
--

CREATE TABLE social.like_post (
    idpost integer NOT NULL,
    idfollower integer NOT NULL
);


ALTER TABLE social.like_post OWNER TO my_custom_user;

--
-- TOC entry 227 (class 1259 OID 24732)
-- Name: like_post_idpost_seq; Type: SEQUENCE; Schema: social; Owner: my_custom_user
--

ALTER TABLE social.like_post ALTER COLUMN idpost ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME social.like_post_idpost_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 225 (class 1259 OID 24711)
-- Name: pagina; Type: TABLE; Schema: social; Owner: my_custom_user
--

CREATE TABLE social.pagina (
    idpagina integer NOT NULL,
    idutente integer NOT NULL,
    nome character varying,
    descrizione character varying
);


ALTER TABLE social.pagina OWNER TO my_custom_user;

--
-- TOC entry 224 (class 1259 OID 24710)
-- Name: pagina_idpagina_seq; Type: SEQUENCE; Schema: social; Owner: my_custom_user
--

CREATE SEQUENCE social.pagina_idpagina_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE social.pagina_idpagina_seq OWNER TO my_custom_user;

--
-- TOC entry 3433 (class 0 OID 0)
-- Dependencies: 224
-- Name: pagina_idpagina_seq; Type: SEQUENCE OWNED BY; Schema: social; Owner: my_custom_user
--

ALTER SEQUENCE social.pagina_idpagina_seq OWNED BY social.pagina.idpagina;


--
-- TOC entry 221 (class 1259 OID 24680)
-- Name: post; Type: TABLE; Schema: social; Owner: my_custom_user
--

CREATE TABLE social.post (
    idpost integer NOT NULL,
    titolo character varying,
    corpo character varying
);


ALTER TABLE social.post OWNER TO my_custom_user;

--
-- TOC entry 220 (class 1259 OID 24679)
-- Name: post_idpost_seq; Type: SEQUENCE; Schema: social; Owner: my_custom_user
--

CREATE SEQUENCE social.post_idpost_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE social.post_idpost_seq OWNER TO my_custom_user;

--
-- TOC entry 3434 (class 0 OID 0)
-- Dependencies: 220
-- Name: post_idpost_seq; Type: SEQUENCE OWNED BY; Schema: social; Owner: my_custom_user
--

ALTER SEQUENCE social.post_idpost_seq OWNED BY social.post.idpost;


--
-- TOC entry 230 (class 1259 OID 24760)
-- Name: post_pagina; Type: TABLE; Schema: social; Owner: my_custom_user
--

CREATE TABLE social.post_pagina (
    idpost integer NOT NULL,
    idpagina integer NOT NULL
);


ALTER TABLE social.post_pagina OWNER TO my_custom_user;

--
-- TOC entry 229 (class 1259 OID 24743)
-- Name: post_utente; Type: TABLE; Schema: social; Owner: my_custom_user
--

CREATE TABLE social.post_utente (
    idpost integer NOT NULL,
    idutente integer NOT NULL
);


ALTER TABLE social.post_utente OWNER TO my_custom_user;

--
-- TOC entry 217 (class 1259 OID 24645)
-- Name: ruolo; Type: TABLE; Schema: social; Owner: my_custom_user
--

CREATE TABLE social.ruolo (
    descrizione character varying,
    idruolo integer NOT NULL
);


ALTER TABLE social.ruolo OWNER TO my_custom_user;

--
-- TOC entry 216 (class 1259 OID 24644)
-- Name: ruolo_idruolo_seq; Type: SEQUENCE; Schema: social; Owner: my_custom_user
--

CREATE SEQUENCE social.ruolo_idruolo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE social.ruolo_idruolo_seq OWNER TO my_custom_user;

--
-- TOC entry 3435 (class 0 OID 0)
-- Dependencies: 216
-- Name: ruolo_idruolo_seq; Type: SEQUENCE OWNED BY; Schema: social; Owner: my_custom_user
--

ALTER SEQUENCE social.ruolo_idruolo_seq OWNED BY social.ruolo.idruolo;


--
-- TOC entry 219 (class 1259 OID 24654)
-- Name: utente; Type: TABLE; Schema: social; Owner: my_custom_user
--

CREATE TABLE social.utente (
    idutente integer NOT NULL,
    idruolo integer NOT NULL,
    nome character varying,
    cognome character varying,
    idfollower integer NOT NULL
);


ALTER TABLE social.utente OWNER TO my_custom_user;

--
-- TOC entry 226 (class 1259 OID 24724)
-- Name: utente_idfollower_seq; Type: SEQUENCE; Schema: social; Owner: my_custom_user
--

CREATE SEQUENCE social.utente_idfollower_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE social.utente_idfollower_seq OWNER TO my_custom_user;

--
-- TOC entry 3436 (class 0 OID 0)
-- Dependencies: 226
-- Name: utente_idfollower_seq; Type: SEQUENCE OWNED BY; Schema: social; Owner: my_custom_user
--

ALTER SEQUENCE social.utente_idfollower_seq OWNED BY social.utente.idfollower;


--
-- TOC entry 218 (class 1259 OID 24653)
-- Name: utente_idutente_seq; Type: SEQUENCE; Schema: social; Owner: my_custom_user
--

CREATE SEQUENCE social.utente_idutente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE social.utente_idutente_seq OWNER TO my_custom_user;

--
-- TOC entry 3437 (class 0 OID 0)
-- Dependencies: 218
-- Name: utente_idutente_seq; Type: SEQUENCE OWNED BY; Schema: social; Owner: my_custom_user
--

ALTER SEQUENCE social.utente_idutente_seq OWNED BY social.utente.idutente;


--
-- TOC entry 3242 (class 2604 OID 24693)
-- Name: commento idcommento; Type: DEFAULT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.commento ALTER COLUMN idcommento SET DEFAULT nextval('social.commento_idcommento_seq'::regclass);


--
-- TOC entry 3243 (class 2604 OID 24714)
-- Name: pagina idpagina; Type: DEFAULT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.pagina ALTER COLUMN idpagina SET DEFAULT nextval('social.pagina_idpagina_seq'::regclass);


--
-- TOC entry 3241 (class 2604 OID 24683)
-- Name: post idpost; Type: DEFAULT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.post ALTER COLUMN idpost SET DEFAULT nextval('social.post_idpost_seq'::regclass);


--
-- TOC entry 3238 (class 2604 OID 24648)
-- Name: ruolo idruolo; Type: DEFAULT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.ruolo ALTER COLUMN idruolo SET DEFAULT nextval('social.ruolo_idruolo_seq'::regclass);


--
-- TOC entry 3239 (class 2604 OID 24657)
-- Name: utente idutente; Type: DEFAULT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.utente ALTER COLUMN idutente SET DEFAULT nextval('social.utente_idutente_seq'::regclass);


--
-- TOC entry 3240 (class 2604 OID 24725)
-- Name: utente idfollower; Type: DEFAULT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.utente ALTER COLUMN idfollower SET DEFAULT nextval('social.utente_idfollower_seq'::regclass);


--
-- TOC entry 3417 (class 0 OID 24690)
-- Dependencies: 223
-- Data for Name: commento; Type: TABLE DATA; Schema: social; Owner: my_custom_user
--



--
-- TOC entry 3422 (class 0 OID 24733)
-- Dependencies: 228
-- Data for Name: like_post; Type: TABLE DATA; Schema: social; Owner: my_custom_user
--



--
-- TOC entry 3419 (class 0 OID 24711)
-- Dependencies: 225
-- Data for Name: pagina; Type: TABLE DATA; Schema: social; Owner: my_custom_user
--



--
-- TOC entry 3415 (class 0 OID 24680)
-- Dependencies: 221
-- Data for Name: post; Type: TABLE DATA; Schema: social; Owner: my_custom_user
--



--
-- TOC entry 3424 (class 0 OID 24760)
-- Dependencies: 230
-- Data for Name: post_pagina; Type: TABLE DATA; Schema: social; Owner: my_custom_user
--



--
-- TOC entry 3423 (class 0 OID 24743)
-- Dependencies: 229
-- Data for Name: post_utente; Type: TABLE DATA; Schema: social; Owner: my_custom_user
--



--
-- TOC entry 3411 (class 0 OID 24645)
-- Dependencies: 217
-- Data for Name: ruolo; Type: TABLE DATA; Schema: social; Owner: my_custom_user
--



--
-- TOC entry 3413 (class 0 OID 24654)
-- Dependencies: 219
-- Data for Name: utente; Type: TABLE DATA; Schema: social; Owner: my_custom_user
--



--
-- TOC entry 3438 (class 0 OID 0)
-- Dependencies: 222
-- Name: commento_idcommento_seq; Type: SEQUENCE SET; Schema: social; Owner: my_custom_user
--

SELECT pg_catalog.setval('social.commento_idcommento_seq', 1, false);


--
-- TOC entry 3439 (class 0 OID 0)
-- Dependencies: 227
-- Name: like_post_idpost_seq; Type: SEQUENCE SET; Schema: social; Owner: my_custom_user
--

SELECT pg_catalog.setval('social.like_post_idpost_seq', 1, false);


--
-- TOC entry 3440 (class 0 OID 0)
-- Dependencies: 224
-- Name: pagina_idpagina_seq; Type: SEQUENCE SET; Schema: social; Owner: my_custom_user
--

SELECT pg_catalog.setval('social.pagina_idpagina_seq', 1, false);


--
-- TOC entry 3441 (class 0 OID 0)
-- Dependencies: 220
-- Name: post_idpost_seq; Type: SEQUENCE SET; Schema: social; Owner: my_custom_user
--

SELECT pg_catalog.setval('social.post_idpost_seq', 1, false);


--
-- TOC entry 3442 (class 0 OID 0)
-- Dependencies: 216
-- Name: ruolo_idruolo_seq; Type: SEQUENCE SET; Schema: social; Owner: my_custom_user
--

SELECT pg_catalog.setval('social.ruolo_idruolo_seq', 1, false);


--
-- TOC entry 3443 (class 0 OID 0)
-- Dependencies: 226
-- Name: utente_idfollower_seq; Type: SEQUENCE SET; Schema: social; Owner: my_custom_user
--

SELECT pg_catalog.setval('social.utente_idfollower_seq', 1, false);


--
-- TOC entry 3444 (class 0 OID 0)
-- Dependencies: 218
-- Name: utente_idutente_seq; Type: SEQUENCE SET; Schema: social; Owner: my_custom_user
--

SELECT pg_catalog.setval('social.utente_idutente_seq', 1, false);


--
-- TOC entry 3251 (class 2606 OID 24704)
-- Name: commento commento_unique; Type: CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.commento
    ADD CONSTRAINT commento_unique UNIQUE (idcommento, idutente, idpost);


--
-- TOC entry 3255 (class 2606 OID 24737)
-- Name: like_post like_post_unique; Type: CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.like_post
    ADD CONSTRAINT like_post_unique UNIQUE (idpost);


--
-- TOC entry 3253 (class 2606 OID 24759)
-- Name: pagina pagina_pk; Type: CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.pagina
    ADD CONSTRAINT pagina_pk PRIMARY KEY (idpagina);


--
-- TOC entry 3249 (class 2606 OID 24687)
-- Name: post post_pk; Type: CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.post
    ADD CONSTRAINT post_pk PRIMARY KEY (idpost);


--
-- TOC entry 3257 (class 2606 OID 24747)
-- Name: post_utente post_utente_unique; Type: CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.post_utente
    ADD CONSTRAINT post_utente_unique UNIQUE (idpost, idutente);


--
-- TOC entry 3245 (class 2606 OID 24652)
-- Name: ruolo ruolo_unique; Type: CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.ruolo
    ADD CONSTRAINT ruolo_unique UNIQUE (idruolo);


--
-- TOC entry 3247 (class 2606 OID 24659)
-- Name: utente utente_unique; Type: CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.utente
    ADD CONSTRAINT utente_unique UNIQUE (idutente);


--
-- TOC entry 3259 (class 2606 OID 24698)
-- Name: commento commento_post_fk; Type: FK CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.commento
    ADD CONSTRAINT commento_post_fk FOREIGN KEY (idpost) REFERENCES social.post(idpost);


--
-- TOC entry 3260 (class 2606 OID 24705)
-- Name: commento commento_utente_fk; Type: FK CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.commento
    ADD CONSTRAINT commento_utente_fk FOREIGN KEY (idutente) REFERENCES social.utente(idutente);


--
-- TOC entry 3262 (class 2606 OID 24738)
-- Name: like_post like_post_post_fk; Type: FK CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.like_post
    ADD CONSTRAINT like_post_post_fk FOREIGN KEY (idpost) REFERENCES social.post(idpost);


--
-- TOC entry 3265 (class 2606 OID 24768)
-- Name: post_pagina newtable_pagina_fk; Type: FK CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.post_pagina
    ADD CONSTRAINT newtable_pagina_fk FOREIGN KEY (idpagina) REFERENCES social.pagina(idpagina);


--
-- TOC entry 3266 (class 2606 OID 24763)
-- Name: post_pagina newtable_post_fk; Type: FK CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.post_pagina
    ADD CONSTRAINT newtable_post_fk FOREIGN KEY (idpost) REFERENCES social.post(idpost);


--
-- TOC entry 3261 (class 2606 OID 24719)
-- Name: pagina pagina_utente_fk; Type: FK CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.pagina
    ADD CONSTRAINT pagina_utente_fk FOREIGN KEY (idutente) REFERENCES social.utente(idutente);


--
-- TOC entry 3263 (class 2606 OID 24753)
-- Name: post_utente post_utente_post_fk; Type: FK CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.post_utente
    ADD CONSTRAINT post_utente_post_fk FOREIGN KEY (idpost) REFERENCES social.post(idpost);


--
-- TOC entry 3264 (class 2606 OID 24748)
-- Name: post_utente post_utente_utente_fk; Type: FK CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.post_utente
    ADD CONSTRAINT post_utente_utente_fk FOREIGN KEY (idutente) REFERENCES social.utente(idutente);


--
-- TOC entry 3258 (class 2606 OID 24660)
-- Name: utente utente_ruolo_fk; Type: FK CONSTRAINT; Schema: social; Owner: my_custom_user
--

ALTER TABLE ONLY social.utente
    ADD CONSTRAINT utente_ruolo_fk FOREIGN KEY (idruolo) REFERENCES social.ruolo(idruolo);


-- Completed on 2024-04-19 13:01:39

--
-- PostgreSQL database dump complete
--

