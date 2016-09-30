# Karatube backend

### Environment

+ Eclipse Mars.2
+ MySQL 5.7.15

### Testing Environment Settings

#####Create logs file path 
`$ mkdir /chomica/karatube/log`

#####Define Server DataSource
+ MySQL connector 5.1 or later
+ DataSource name: `karatubeMysqlDS`
+ JNDI name: `java:jboss/datasources/karatubeMysqlDS`

#####Optional
+ Outer config path 

	`/chomica/karatube/config/karatube.properties`
