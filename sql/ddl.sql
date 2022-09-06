create or replace table member
(
    id        bigint auto_increment,
    member_id varchar(20) not null,
    password  varchar(20) not null,
    nickname  varchar(20) not null,
    primary key (id, member_id),
    constraint member_nickname_uindex
        unique (nickname)
)
    comment '회원 정보';

create or replace table post
(
    id        bigint auto_increment,
    member_id varchar(20)  not null,
    title     varchar(20)  not null,
    date      datetime     not null,
    contents  varchar(255) not null,
    primary key (id, member_id),
    constraint post_member_id_member_id_fk
        foreign key (id, member_id) references member (id, member_id)
)
    comment '게시글 정보';

