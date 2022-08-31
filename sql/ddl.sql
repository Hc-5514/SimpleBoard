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

create or replace table post
(
    id       bigint auto_increment
        primary key,
    title    varchar(20)  not null,
    name     varchar(20)  not null,
    date     datetime     not null,
    contents varchar(255) not null,
    constraint post_member_member_id_fk
        foreign key (name) references member (member_id)
)
    comment '게시글';


