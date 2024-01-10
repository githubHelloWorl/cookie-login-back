use sportsreservesys;
-- auto-generated definition

drop table if exists user;
create table user
(
    id           bigint auto_increment comment '用户ID'
        primary key,
    userAccount  varchar(256)                           not null comment '账号',
    userPassword varchar(512)                           not null comment '密码',
    unionId      varchar(256)                           null comment '微信开放平台ID',
    mpOpenId     varchar(256)                           null comment '公众号OpenID',
    userName     varchar(256)                           null comment '用户昵称',
    userAvatar   varchar(1024)                          null comment '用户头像',
    userProfile  varchar(512)                           null comment '用户简介',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
) comment '用户';

create index idx_unionId on user (unionId);

select *
from user;
insert into user(id, userAccount, userPassword)
values (1, 'admin', '12345678');

drop table if exists venue;
create table venue
(
    venue_id    int auto_increment comment '场馆ID'
        primary key,
    venue_name  varchar(255)                       not null comment '场馆名称',
    venue_type  varchar(255)                       not null comment '场馆类型',
    location    varchar(255)                       not null comment '场馆位置',
    facilities  text                               null comment '场馆设施',
    fee         double                             not null comment '场地费用',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '体育场馆信息表';

-- auto-generated definition
select *
from venue;


drop table if exists reservation;
create table reservation
(
    reservation_id   int auto_increment comment '预定ID'
        primary key,
    user_id          bigint                                                    null comment '用户ID',
    venue_id         int                                                       null comment '场馆ID',
    date             date                                                      not null comment '预定日期',
    start_time       time                                                      not null comment '预定时间',
    end_time         time                                                      not null comment '结束时间',
    number_of_people int                                                       not null comment '预定人数',
    status           enum ('CONFIRMED', 'CANCELLED') default 'CONFIRMED'       null comment '预定状态',
    create_time      datetime                        default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time      datetime                        default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    constraint reservation_ibfk_1
        foreign key (user_id) references user (id),
    constraint reservation_ibfk_2
        foreign key (venue_id) references venue (venue_id)
)
    comment '预定信息表';

create index user_id
    on reservation (user_id);

create index venue_id
    on reservation (venue_id);


-- auto-generated definition
-- auto-generated definition
drop table if exists message;
create table message
(
    message_id int auto_increment comment '留言ID'
        primary key,
    user_id    bigint                             null comment '用户ID',
    content    text                               not null comment '留言内容',
    createTime datetime default CURRENT_TIMESTAMP not null comment '留言时间',
    constraint message_ibfk_1
        foreign key (user_id) references user (id)
)
    comment '留言信息表';

create index user_id
    on message (user_id);


select *
from message;

-- auto-generated definition
create table message_reply
(
    message_reply_id int auto_increment comment '回复ID'
        primary key,
    user_id          bigint                             null comment '用户ID',
    message_id       int                                null comment '留言ID',
    content_reply    text                               not null comment '留言回复',
    createTime       datetime default CURRENT_TIMESTAMP not null comment '回复时间',
    constraint fk_message_id
        foreign key (message_id) references message (message_id),
    constraint fk_user_id
        foreign key (user_id) references user (id)
)
    comment '留言回复信息表';

create index idx_user_id
    on message_reply (user_id);

