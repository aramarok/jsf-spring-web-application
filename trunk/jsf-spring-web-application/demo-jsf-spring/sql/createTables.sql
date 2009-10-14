CREATE database if NOT EXISTS `jsftraining`;

USE `jsftraining`;

CREATE TABLE `users` (                                     
          `USER_NAME` varchar(50) NOT NULL,                        
          `PASSWORD` varchar(50) NOT NULL,                         
          `FIRST_NAME` varchar(50) default NULL,                   
          `LAST_NAME` varchar(50) default NULL,                    
          `CITY` varchar(32) default NULL,                         
          `AGE` int(11) default NULL,                              
          `SEX` int(11) default NULL,                              
          PRIMARY KEY  (`USER_NAME`)                               
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC

CREATE TABLE `files` (                                                                  
          `FILE_NAME` varchar(256) NOT NULL,                                                    
          `SIZE` bigint(20) default NULL,                                                       
          `USER_NAME` varchar(50) NOT NULL,                                                     
          `CONTENT` longblob,                                                                   
          `FILE_PATH` varchar(512) NOT NULL,                                                    
          PRIMARY KEY  (`FILE_NAME`),                                                           
          KEY `USER_NAME_2` (`USER_NAME`),                                                      
          CONSTRAINT `files_ibfk_1` FOREIGN KEY (`USER_NAME`) REFERENCES `users` (`USER_NAME`)  
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC
        

INSERT INTO `users`
	(`USER_NAME`,`PASSWORD`,`FIRST_NAME`,`LAST_NAME`,`CITY`,`AGE`,`SEX`)
	VALUES
		('test','test','Jim','Smith','Timisoara',25,1),
		('test2','test2','Carl','Jason','Arad',32,1);