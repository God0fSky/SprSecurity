create schema if not exists store_security;

create sequence if not exists store_security.store_security_id_sequence;

create table if not exists store_security.product
(
    id              integer not null default nextval('store_security.store_security_id_sequence'),
    name            text not null,
    cost            numeric not null,
    primary key(id)
    );
