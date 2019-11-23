create sequence hibernate_sequence MINVALUE 1 INCREMENT BY 1;

create table PERSON (
    ID          BIGINT not null primary key,
    NAME        VARCHAR(45),
    EMAIL       VARCHAR(255),
    COUNTRY     VARCHAR(255),
    AGE         INT,
    BIRTH_DATE  DATE,
    BIRTH_PLACE VARCHAR(255),
    GENDER      VARCHAR(45) not null,
    HAS_JOB     BOOLEAN
);

insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'Teszt Elek1', 'teszt.elek@gmail.com', 'Hungary', 26, '2003-02-22', 'Karakószörcsög', 'MALE', 0);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'John Doe1', 'john.doe@gmail.com', 'USA', 40, '1979-05-13', 'New Jersey', 'NOT_CERTAIN', 1);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'Teszt Elek2', 'teszt.elek@gmail.com', 'Hungary', 26, '2003-02-22', 'Karakószörcsög', 'MALE', 0);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'John Doe2', 'john.doe@gmail.com', 'USA', 40, '1979-05-13', 'New Jersey', 'NOT_CERTAIN', 1);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'Teszt Elek3', 'teszt.elek@gmail.com', 'Hungary', 26, '2003-02-22', 'Karakószörcsög', 'MALE', 0);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'John Doe3', 'john.doe@gmail.com', 'USA', 40, '1979-05-13', 'New Jersey', 'NOT_CERTAIN', 1);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'Teszt Elek4', 'teszt.elek@gmail.com', 'Hungary', 26, '2003-02-22', 'Karakószörcsög', 'MALE', 0);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'John Doe4', 'john.doe@gmail.com', 'USA', 40, '1979-05-13', 'New Jersey', 'NOT_CERTAIN', 1);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'Teszt Elek5', 'teszt.elek@gmail.com', 'Hungary', 26, '2003-02-22', 'Karakószörcsög', 'MALE', 0);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'John Doe5', 'john.doe@gmail.com', 'USA', 40, '1979-05-13', 'New Jersey', 'NOT_CERTAIN', 1);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'Teszt Elek6', 'teszt.elek@gmail.com', 'Hungary', 26, '2003-02-22', 'Karakószörcsög', 'MALE', 0);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'John Doe6', 'john.doe@gmail.com', 'USA', 40, '1979-05-13', 'New Jersey', 'NOT_CERTAIN', 1);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'Teszt Elek7', 'teszt.elek@gmail.com', 'Hungary', 26, '2003-02-22', 'Karakószörcsög', 'MALE', 0);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'John Doe7', 'john.doe@gmail.com', 'USA', 40, '1979-05-13', 'New Jersey', 'NOT_CERTAIN', 1);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'Teszt Elek8', 'teszt.elek@gmail.com', 'Hungary', 26, '2003-02-22', 'Karakószörcsög', 'MALE', 0);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'John Doe8', 'john.doe@gmail.com', 'USA', 40, '1979-05-13', 'New Jersey', 'NOT_CERTAIN', 1);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'Teszt Elek9', 'teszt.elek@gmail.com', 'Hungary', 26, '2003-02-22', 'Karakószörcsög', 'MALE', 0);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'John Doe9', 'john.doe@gmail.com', 'USA', 40, '1979-05-13', 'New Jersey', 'NOT_CERTAIN', 1);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'Teszt Elek10', 'teszt.elek@gmail.com', 'Hungary', 26, '2003-02-22', 'Karakószörcsög', 'MALE', 0);
insert into PERSON (ID, NAME, EMAIL, COUNTRY, AGE, BIRTH_DATE, BIRTH_PLACE, GENDER, HAS_JOB)
    values (hibernate_sequence.nextval, 'John Doe10', 'john.doe@gmail.com', 'USA', 40, '1979-05-13', 'New Jersey', 'NOT_CERTAIN', 1);
