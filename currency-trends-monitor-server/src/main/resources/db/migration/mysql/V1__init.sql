create table country
(
    id         integer      not null,
    iso_2_code varchar(255) not null,
    name       varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table currency
(
    id       integer      not null,
    iso_code varchar(255) not null,
    name     varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table trade
(
    id               binary(255)    not null,
    amount_from      decimal(19, 2) not null,
    amount_to        decimal(19, 2) not null,
    time_placed      datetime       not null,
    country_id       integer        not null,
    currency_from_id integer        not null,
    currency_to_id   integer        not null,
    user_id          binary(255)    not null,
    primary key (id)
) engine = InnoDB;

create table user
(
    id        binary(255)  not null,
    system_id varchar(255) not null,
    primary key (id)
) engine = InnoDB;

alter table country
    add constraint UK_qn6hsk7e0138qb7p5et26qbrs unique (iso_2_code);
alter table currency
    add constraint UK_dhojf2wec2hrj9euxk980grkp unique (iso_code);
alter table user
    add constraint UK_dtsihhxwfe3a0qxyqw66jx8gy unique (system_id);
alter table trade
    add constraint FKd8wogme0h72joiskufathb7cy foreign key (country_id) references country (id);
alter table trade
    add constraint FKpwyot1bledn93a4dvqelc0ehs foreign key (currency_from_id) references currency (id);
alter table trade
    add constraint FKam373pyqtdq3mg468u34humbn foreign key (currency_to_id) references currency (id);
alter table trade
    add constraint FK1dqm16mo3cntjlxap3iusqvyt foreign key (user_id) references user (id);
