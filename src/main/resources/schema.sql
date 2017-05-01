--user table
create table PUBLIC.USER_INFO(
NAME VARCHAR(100) NOT NULL,
SURNAME VARCHAR(100),
USER_ROLE_ID NUMBER NOT NULL
);

alter table PUBLIC.USER_INFO add constraint PUBLIC.USER_INFO_ID primary key(NAME);

--Role table
create table PUBLIC.TUSERROLE(
ROLEiD NUMBER NOT NULL,
ROLENAME VARCHAR2(100),
USERNAME VARCHAR2(100)
);

alter table PUBLIC.TUSERROLE add constraint PUBLIC.TUSERROLE_PK primary key(ROLEID);
alter table PUBLIC.TUSERROLE add constraint PUBLIC.TUSERROLE_FK FOREIGN KEY (USERNAME) REFERENCES PUBLIC.USER_INFO(NAME);
alter table PUBLIC.USER_INFO add constraint PUBLIC.TUSER_FK FOREIGN KEY (USER_ROLE_ID) REFERENCES PUBLIC.TUSERROLE(ROLEID);

--User can have mutiple phones
create table PUBLIC.USER_PHONES(
USER_PHONES_ID NUMBER NOT NULL,
USERNAME VARCHAR2(2000),
USER_PHONE_COMPANY VARCHAR2(2000),
CONSTRAINT USER_PHONES_ID_PK PRIMARY KEY(USER_PHONES_ID),
CONSTRAINT USER_PHONES_FK FOREIGN KEY(USERNAME) REFERENCES PUBLIC.USER_INFO(NAME)
);

--ManyToMany relationships between client and company

--client Table
CREATE TABLE PUBLIC.CLIENT(
CLIENT_ID NUMBER NOT NULL,
COMPANT_NAME VARCHAR2(1000),
CONSTRAINT CLIENT_PK PRIMARY KEY(CLIENT_ID)
);

--COMPANY TABLE
CREATE TABLE PUBLIC.COMPANY(
COMPANY_ID NUMBER NOT NULL,
CLIENT_NAME VARCHAR2(1000),
CONSTRAINT COMPANY_PK PRIMARY KEY(COMPANY_ID)
);

--RELATIONSHIP TABLE
CREATE TABLE PUBLIC.COMPANY_CLIENT(
COMPANY_CLIENT_ID NUMBER NOT NULL,
CLIENT_ID NUMBER,
COMPANY_ID NUMBER,
CONSTRAINT COMPANY_CLIENT_PK PRIMARY KEY(COMPANY_CLIENT_ID),
CONSTRAINT COMPANY_CLIENT_FK FOREIGN KEY(CLIENT_ID) REFERENCES PUBLIC.CLIENT(CLIENT_ID),
CONSTRAINT COMPANY_CLIENT_FKK FOREIGN KEY(COMPANY_ID) REFERENCES PUBLIC.COMPANY(COMPANY_ID)
);

--named query test
create table PUBLIC.GENERAL_TEST(
ID NUMBER NOT NULL,
MOVIE VARCHAR(1000),
USER_ID VARCHAR(1000),
CONSTRAINT GENERAL_TEST_PK PRIMARY KEY(ID)
)