--------------------------------------------------------
--  ÆÄÀÏÀÌ »ý¼ºµÊ - ¼ö¿äÀÏ-12¿ù-26-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table FISH
--------------------------------------------------------

  CREATE TABLE "GAME"."FISH" 
   (	"FNO" NUMBER, 
	"FNAME" VARCHAR2(50 BYTE), 
	"SEA" VARCHAR2(50 BYTE), 
	"SALEPRICE" NUMBER, 
	"MOVEMENT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into GAME.FISH
SET DEFINE OFF;
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (12,'µ¥¸Þ´Ï±â½º','1,2',1200,4);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (6,'µ¿°¥»ïÄ¡','1,3',1100,4);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (7,'ÆÄ·é»þÅ©','1',7500,12);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (8,'º´Ä¡µ¼','1,2',2000,6);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (9,'Àå¼ö°ÅºÏ','1',3500,9);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (10,'°í·¡»ó¾î','1',15000,17);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (11,'»ûºñ´ÃÄ¡','2,3',600,3);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (13,'µ¾µ¼','2,3',2000,6);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (14,'Åõ¸í»ó¾î','2',3500,9);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (15,'½ÉÇØ¸ÅÅüÀÌ','2,3',2500,7);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (1,'ÀÚÀÌ¾ðÆ®°¡¿À¸®','1,3',1500,5);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (2,'º£Å¸','1,3',550,3);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (3,'½ÄºÐ¾î','1,3',450,3);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (4,'ÀÚÀÌ¾ðÆ®±¸¶ó¹Ì','1',1000,4);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (5,'Çª¸¥¹Ù´Ù°ÅºÏ','1',2250,7);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (16,'¸¶±Í»ó¾î','2',6500,11);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (17,'·¯ÇÁ»þÅ©','2,3',3300,8);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (18,'¼¼ÁÙ µ¾µ¼','2,3',2300,7);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (19,'º¥ÅÙ¾î','1,2,3',3800,9);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (20,'½ºÇÇ³ë½º','2',20000,20);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (21,'ÃÊ·Õ¾Æ±Í','1,3',3500,9);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (22,'Áãµ£°í±â','1,2,3',1200,4);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (23,'´ë¿Õ»ê°¥Ä¡','3',5000,10);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (24,'µÎÅú»ó¾î','1,3',2500,7);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (25,'¸Þ°¡¸¶¿ì½º»ó¾î','3',7500,12);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (26,'±â¸§°¥Ä¡²¿Ä¡','2,3',1500,5);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (27,'Æç¸®Ä­Àå¾î','1,3',700,4);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (28,'³³ÀÛ¾ÙÅüÀÌ','2,3',550,3);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (29,'°¡½Ã³ª¹«»ó¾î','3',9000,14);
Insert into GAME.FISH (FNO,FNAME,SEA,SALEPRICE,MOVEMENT) values (30,'¼î´Ï½ÃÄ­½º','3',35000,25);
--------------------------------------------------------
--  DDL for Index FISH_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GAME"."FISH_PK" ON "GAME"."FISH" ("FNO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
