--
-- PostgreSQL database dump
--

-- Dumped from database version 17.3 (Debian 17.3-3.pgdg120+1)
-- Dumped by pg_dump version 17.3 (Debian 17.3-3.pgdg120+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- Name: auth; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auth (
    id integer,
    user_name character varying(25) NOT NULL,
    password text NOT NULL,
    roll character varying(35) DEFAULT 'user'::character varying NOT NULL
);


ALTER TABLE public.auth OWNER TO postgres;

--
-- Name: crop; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.crop (
    crop_id integer NOT NULL,
    name character varying(25)
);


ALTER TABLE public.crop OWNER TO postgres;

--
-- Name: crop_crop_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.crop_crop_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.crop_crop_id_seq OWNER TO postgres;

--
-- Name: crop_crop_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.crop_crop_id_seq OWNED BY public.crop.crop_id;


--
-- Name: experts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.experts (
    id integer,
    crop_id integer,
    experience double precision NOT NULL,
    ratings double precision,
    pending_req integer DEFAULT 0
);


ALTER TABLE public.experts OWNER TO postgres;

--
-- Name: files; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.files (
    message_id integer,
    file_url character varying(56) NOT NULL
);


ALTER TABLE public.files OWNER TO postgres;

--
-- Name: groups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.groups (
    room_id integer,
    profile character varying(56),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    created_by integer,
    validity timestamp without time zone
);


ALTER TABLE public.groups OWNER TO postgres;

--
-- Name: messages; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.messages (
    message_id integer NOT NULL,
    message character varying(1024),
    from_user integer,
    to_user integer,
    "timestamp" timestamp without time zone,
    read boolean DEFAULT false,
    room_id integer
);


ALTER TABLE public.messages OWNER TO postgres;

--
-- Name: messages_message_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.messages_message_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.messages_message_id_seq OWNER TO postgres;

--
-- Name: messages_message_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.messages_message_id_seq OWNED BY public.messages.message_id;


--
-- Name: room_participant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room_participant (
    room_id integer,
    participant_id integer
);


ALTER TABLE public.room_participant OWNER TO postgres;

--
-- Name: rooms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rooms (
    room_id integer NOT NULL,
    is_group boolean DEFAULT false,
    initial_image character varying(56) NOT NULL
);


ALTER TABLE public.rooms OWNER TO postgres;

--
-- Name: rooms_room_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rooms_room_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.rooms_room_id_seq OWNER TO postgres;

--
-- Name: rooms_room_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rooms_room_id_seq OWNED BY public.rooms.room_id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    phone_no character varying(25) NOT NULL,
    profile_picture character varying(128),
    status boolean DEFAULT true,
    last_seen timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: crop crop_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.crop ALTER COLUMN crop_id SET DEFAULT nextval('public.crop_crop_id_seq'::regclass);


--
-- Name: messages message_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages ALTER COLUMN message_id SET DEFAULT nextval('public.messages_message_id_seq'::regclass);


--
-- Name: rooms room_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rooms ALTER COLUMN room_id SET DEFAULT nextval('public.rooms_room_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: auth; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.auth (id, user_name, password, roll) FROM stdin;
39	abc_pqr	{bcrypt}$2a$10$q9tCQkr.qsbTP4NOXJ8csOLyv.Y40RE3ULAMmn7/n6cDdHIDNzQaG	USER
41	admin	{bcrypt}$2a$10$l3N3KGW0KjjmaGXem61xzeOSGq8.lkTT1ZwUkuiGJBFIecwHJ37Pa	ADMIN
42	expert_1	{bcrypt}$2a$10$sYNfd4hY0RMNkc0xhe2Qw.m7/4r3REbpZ6MSSMIvrJhPE842WJix2	EXPERT
43	expert_2	{bcrypt}$2a$10$akwcQ2DsQS2tHGaHy5ahkeVKRFTDdHbf5RMPjz.CflS.oi7HiDAi2	EXPERT
44	expert_3	{bcrypt}$2a$10$ZOJebika.kcOXQbLvwfGm.sUjk/D3po.mREpVopnCGHQEGVoVMPbK	EXPERT
45	expert_4	{bcrypt}$2a$10$I85PypcK/TPS9m2dcAEUZOu0UB8fRdHWN4p5tRWacZPMLe0rPCcOa	EXPERT
46	expert_5	{bcrypt}$2a$10$Z3zRQwg8xi.pIMyuGfJqYO/GaKzIcikM4Dtar8tEyYZXs2RR3A61e	EXPERT
\.


--
-- Data for Name: crop; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.crop (crop_id, name) FROM stdin;
1	Soyabean
2	Onion
3	Cotton
4	SugerCane
\.


--
-- Data for Name: experts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.experts (id, crop_id, experience, ratings, pending_req) FROM stdin;
42	1	3.2	\N	0
43	1	3.2	\N	0
44	1	3.2	\N	0
45	1	3.2	\N	0
46	1	3.2	\N	0
\.


--
-- Data for Name: files; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.files (message_id, file_url) FROM stdin;
\.


--
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.groups (room_id, profile, created_at, created_by, validity) FROM stdin;
\.


--
-- Data for Name: messages; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.messages (message_id, message, from_user, to_user, "timestamp", read, room_id) FROM stdin;
\.


--
-- Data for Name: room_participant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.room_participant (room_id, participant_id) FROM stdin;
\.


--
-- Data for Name: rooms; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rooms (room_id, is_group, initial_image) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, phone_no, profile_picture, status, last_seen) FROM stdin;
39	8010269748	http://localhost:8080/api/file/07e59a89-0dd4-4377-98fa-4406ca5670b3.png	t	2025-04-30 14:01:05.239535
41	9960824505	http://localhost:8080/api/file/3d1b7b99-8cc3-4eb1-a7bd-4599ed329349.png	t	2025-04-30 15:32:32.892589
42	8010269765	http://localhost:8080/api/file/3351eeeb-4966-4fee-baa7-f0364809c4e3.png	t	2025-05-05 11:16:34.192258
43	918010269765	http://localhost:8080/api/file/8288dcbe-c3e7-4679-97ac-16b76b722f25.png	t	2025-05-07 12:44:28.152021
44	918010269790	http://localhost:8080/api/file/f21b2aa5-7bfd-48af-a60d-33462148e7ed.png	t	2025-05-07 12:46:41.47578
45	918010269791	http://localhost:8080/api/file/41a72060-51ab-40ec-873e-63d672f62773.png	t	2025-05-07 12:48:51.500995
46	918010269749	http://localhost:8080/api/file/d5a9ef5f-b85b-42fd-8bb9-0d3fc0d84268.png	t	2025-05-07 13:10:52.290654
\.


--
-- Name: crop_crop_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.crop_crop_id_seq', 4, true);


--
-- Name: messages_message_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.messages_message_id_seq', 1, false);


--
-- Name: rooms_room_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rooms_room_id_seq', 1, false);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 46, true);


--
-- Name: auth auth_user_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth
    ADD CONSTRAINT auth_user_name_key UNIQUE (user_name);


--
-- Name: crop crop_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.crop
    ADD CONSTRAINT crop_pkey PRIMARY KEY (crop_id);


--
-- Name: groups groups_room_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT groups_room_id_key UNIQUE (room_id);


--
-- Name: messages messages_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT messages_pkey PRIMARY KEY (message_id);


--
-- Name: rooms rooms_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rooms
    ADD CONSTRAINT rooms_pkey PRIMARY KEY (room_id);


--
-- Name: users users_phone_no_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_phone_no_key UNIQUE (phone_no);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: auth auth_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth
    ADD CONSTRAINT auth_id_fkey FOREIGN KEY (id) REFERENCES public.users(id);


--
-- Name: experts experts_crop_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.experts
    ADD CONSTRAINT experts_crop_id_fkey FOREIGN KEY (crop_id) REFERENCES public.crop(crop_id);


--
-- Name: experts experts_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.experts
    ADD CONSTRAINT experts_id_fkey FOREIGN KEY (id) REFERENCES public.users(id);


--
-- Name: files files_message_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.files
    ADD CONSTRAINT files_message_id_fkey FOREIGN KEY (message_id) REFERENCES public.messages(message_id);


--
-- Name: groups groups_created_by_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT groups_created_by_fkey FOREIGN KEY (created_by) REFERENCES public.users(id);


--
-- Name: groups groups_room_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT groups_room_id_fkey FOREIGN KEY (room_id) REFERENCES public.rooms(room_id);


--
-- Name: messages messages_from_user_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT messages_from_user_fkey FOREIGN KEY (from_user) REFERENCES public.users(id);


--
-- Name: messages messages_room_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT messages_room_id_fkey FOREIGN KEY (room_id) REFERENCES public.rooms(room_id);


--
-- Name: messages messages_to_user_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT messages_to_user_fkey FOREIGN KEY (to_user) REFERENCES public.users(id);


--
-- Name: room_participant room_participant_participant_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room_participant
    ADD CONSTRAINT room_participant_participant_id_fkey FOREIGN KEY (participant_id) REFERENCES public.users(id);


--
-- Name: room_participant room_participant_room_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room_participant
    ADD CONSTRAINT room_participant_room_id_fkey FOREIGN KEY (room_id) REFERENCES public.rooms(room_id);


--
-- PostgreSQL database dump complete
--

