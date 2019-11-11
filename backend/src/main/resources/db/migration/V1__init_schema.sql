create sequence hibernate_sequence MINVALUE 1 INCREMENT BY 1;

create table PERSON (
    ID          BIGINT not null primary key,
    NAME        VARCHAR(45),
    EMAIL       VARCHAR(255),
    AGE         INT,
    BIRTH_DATE  DATE,
    BIRTH_PLACE VARCHAR(255),
    GENDER      VARCHAR(45) not null,
    HAS_JOB     BOOLEAN
);

insert into PERSON (ID, NAME, EMAIL, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'Teszt Elek', 'teszt.elek@gmail.com', 26, '2003-02-22', 'Karakószörcsög', 'MALE', 0);
insert into PERSON (ID, NAME, EMAIL, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'John Doe', 'john.doe@gmail.com', 40, '1979-05-13', 'New Jersey', 'NOT_CERTAIN', 1);
