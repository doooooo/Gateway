--Ref: https://www.javatpoint.com/spring-boot-h2-database

DROP TABLE IF EXISTS GATEWAY;  
CREATE TABLE GATEWAY (  
serial VARCHAR(20) PRIMARY KEY,  
name VARCHAR(50) NOT NULL,  
ipv4 VARCHAR(20) 
);  

DROP TABLE IF EXISTS PERIPHERAL;  
CREATE TABLE PERIPHERAL (  
uid int AUTO_INCREMENT PRIMARY KEY,  
vendor VARCHAR(50),  
date_created TIMESTAMP,
status VARCHAR(10),
gid VARCHAR(20) --FOREIGN KEY(gid) REFERENCES GATEWAY(serial)
);  

--Ref: https://razorsql.com/features/h2_add_foreign_key.html

ALTER TABLE PERIPHERAL
ADD FOREIGN KEY (gid) 
REFERENCES GATEWAY(serial);