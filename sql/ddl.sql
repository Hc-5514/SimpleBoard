create or replace table member
(
    id        bigint auto_increment
        primary key,
    member_id varchar(20) not null,
    password  varchar(20) not null,
    nickname  varchar(10) not null,
    constraint member_member_id_uindex
        unique (member_id),
    constraint member_nickname_uindex
        unique (nickname)
)
    comment '회원 정보';

