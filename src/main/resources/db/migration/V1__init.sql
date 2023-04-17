create table public.users
(
    id          serial
        primary key,
    country     varchar(255),
    email       varchar(255),
    is_deleted  boolean,
    name        varchar(255),
    passport_id integer
        constraint fkddyjnd93b8x7gdng15k7g429p
            references public.passports
);

create table public.fotos
(
    id            serial
        primary key,
    creation_time timestamp,
    is_visible    boolean,
    length        integer,
    link          varchar(255),
    width         integer,
    employee_id   integer
        constraint fkw2iktuv1pwk9mmmty9unt2dd
            references public.users
);