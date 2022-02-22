CREATE TABLE veeva_monitored_issue
(
    id                                  serial not null
    constraint pkey primary key,
    name                                varchar(100),
    update_date                         timestamp,
    description                         varchar,
    deleted                             boolean
);


