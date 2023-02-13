create table if not exists store_security.user
(
    id              integer not null default nextval('store_security.store_security_id_sequence'),
    name            text not null,
    password        text not null,
    role            text not null,
    primary key(id)
    );