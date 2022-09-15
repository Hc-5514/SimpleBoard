create or replace table member
(
    id       bigint auto_increment
        primary key,
    idLogin  varchar(20) not null,
    password varchar(20) not null,
    nickname varchar(20) not null,
    constraint member_loginId_uindex
        unique (idLogin),
    constraint member_nickname_uindex
        unique (nickname)
)
    comment '회원 정보';

create or replace table post
(
    id          bigint auto_increment
        primary key,
    nickname    varchar(20)  not null,
    title       varchar(20)  not null,
    dateCreated datetime     not null,
    content     varchar(255) not null,
    constraint post_member_nickname_fk
        foreign key (nickname) references member (nickname)
)
    comment '게시글 정보';
