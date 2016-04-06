CREATE TABLE  "USERS" 
   (    "EMPNO" NUMBER, 
    "USERNAME" VARCHAR2(15), 
    "PASSWORD" VARCHAR2(20), 
    "EMAIL" VARCHAR2(30), 
    "REGDATE" DATE, 
      UNIQUE ("USERNAME", "EMAIL") ENABLE
   ) ;
/
ALTER TABLE  "USERS" ADD FOREIGN KEY ("EMPNO")
      REFERENCES  "EMPL" ("EMPNO") ENABLE;
/
Insert into users values (1,'admin','admin','admin',sysdate);​
/