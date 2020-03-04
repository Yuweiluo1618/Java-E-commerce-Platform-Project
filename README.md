# Java-E-commerce-Platform-Project
1.User Module(CRUD)
2.User Table design:
 Field               Type        Constrain
USER_ID            varchar(32)    Not Null(PK)
USER_NAME          varchar(20)    Not Null
USER_PASSWORD      varchar(20)    Not Null
USER_SEX           varchar(1)     Not Null
USER_BIRTHDAY      datatime       DEFAULT Null
USER_IDENTITY      varchar(60)    DEFAULT Null
USER_EMAIL         varchar(60)    DEFAULT Null
USER_MOBILE        varchar(11)    DEFAULT Null
USER_ADDRESS       varchar(200)   NOT NULL
USER_STATUS        decimal(6,0)   NOT NULL