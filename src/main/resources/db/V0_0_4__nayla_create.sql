--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

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

SET default_with_oids = false;

--
-- Name: kind; Type: TABLE; Schema: public; Owner: postgres
--


CREATE TABLE IF NOT EXISTS public.kind (
    id integer NOT NULL,
    achternaam character varying(255),
    geboortedatum character varying(255),
    voornaam character varying(255)
);


ALTER TABLE public.kind OWNER TO postgres;

--
-- Name: kind_ouder; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.kind_ouder (
    kind_id integer NOT NULL,
    ouders_id integer NOT NULL
);


ALTER TABLE public.kind_ouder OWNER TO postgres;

--
-- Name: melk; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.melk (
    id integer NOT NULL,
    mililiter integer,
    tijd character varying(255),
    kind_id integer
);


ALTER TABLE public.melk OWNER TO postgres;

--
-- Name: ouder; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.ouder (
    id integer NOT NULL,
    achternaam character varying(255),
    voornaam character varying(255),
    email character varying(255),
    password character varying(255),
    username character varying(255)
);


ALTER TABLE public.ouder OWNER TO postgres;

--
-- Name: ouder_kind; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.ouder_kind (
    ouder_id integer NOT NULL,
    kinderen_id integer NOT NULL
);


ALTER TABLE public.ouder_kind OWNER TO postgres;

--
-- Name: sequence; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.sequence (
    seq_name character varying(50) NOT NULL,
    seq_count numeric(38,0)
);


ALTER TABLE public.sequence OWNER TO postgres;

--
-- Name: temperatuur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.temperatuur (
    id integer NOT NULL,
    graden double precision,
    tijd character varying(255),
    kind_id integer
);


ALTER TABLE public.temperatuur OWNER TO postgres;

--
-- Data for Name: kind; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.kind (id, achternaam, geboortedatum, voornaam) FROM stdin;
\.


--
-- Data for Name: kind_ouder; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.kind_ouder (kind_id, ouders_id) FROM stdin;
\.


--
-- Data for Name: melk; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.melk (id, mililiter, tijd, kind_id) FROM stdin;
\.


--
-- Data for Name: ouder; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ouder (id, achternaam, voornaam, email, password, username) FROM stdin;
\.


--
-- Data for Name: ouder_kind; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ouder_kind (ouder_id, kinderen_id) FROM stdin;
\.


--
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sequence (seq_name, seq_count) FROM stdin;
SEQ_GEN	0
\.


--
-- Data for Name: temperatuur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.temperatuur (id, graden, tijd, kind_id) FROM stdin;
\.


--
-- Name: kind_ouder kind_ouder_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kind_ouder
    ADD CONSTRAINT kind_ouder_pkey PRIMARY KEY (kind_id, ouders_id);


--
-- Name: kind kind_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kind
    ADD CONSTRAINT kind_pkey PRIMARY KEY (id);


--
-- Name: melk melk_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.melk
    ADD CONSTRAINT melk_pkey PRIMARY KEY (id);


--
-- Name: ouder_kind ouder_kind_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ouder_kind
    ADD CONSTRAINT ouder_kind_pkey PRIMARY KEY (ouder_id, kinderen_id);


--
-- Name: ouder ouder_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ouder
    ADD CONSTRAINT ouder_pkey PRIMARY KEY (id);


--
-- Name: sequence sequence_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sequence
    ADD CONSTRAINT sequence_pkey PRIMARY KEY (seq_name);


--
-- Name: temperatuur temperatuur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.temperatuur
    ADD CONSTRAINT temperatuur_pkey PRIMARY KEY (id);


--
-- Name: kind_ouder fk_kind_ouder_kind_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kind_ouder
    ADD CONSTRAINT fk_kind_ouder_kind_id FOREIGN KEY (kind_id) REFERENCES public.kind(id);


--
-- Name: kind_ouder fk_kind_ouder_ouders_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kind_ouder
    ADD CONSTRAINT fk_kind_ouder_ouders_id FOREIGN KEY (ouders_id) REFERENCES public.ouder(id);


--
-- Name: melk fk_melk_kind_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.melk
    ADD CONSTRAINT fk_melk_kind_id FOREIGN KEY (kind_id) REFERENCES public.kind(id);


--
-- Name: ouder_kind fk_ouder_kind_kinderen_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ouder_kind
    ADD CONSTRAINT fk_ouder_kind_kinderen_id FOREIGN KEY (kinderen_id) REFERENCES public.kind(id);


--
-- Name: ouder_kind fk_ouder_kind_ouder_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ouder_kind
    ADD CONSTRAINT fk_ouder_kind_ouder_id FOREIGN KEY (ouder_id) REFERENCES public.ouder(id);


--
-- Name: temperatuur fk_temperatuur_kind_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.temperatuur
    ADD CONSTRAINT fk_temperatuur_kind_id FOREIGN KEY (kind_id) REFERENCES public.kind(id);


--
-- PostgreSQL database dump complete
--

