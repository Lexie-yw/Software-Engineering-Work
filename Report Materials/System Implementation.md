**System Implementation**  
#_System design and Stack architecture_  
 
#Class diagram  
##Sequence diagram  
#Back End - MongoDB  
##Database implementation  
##Data model  

#Stack architecture  
In this project, we used the front and back end separation method. The front-end uses Angular to render and display the page. The more popular Spring Boot is used to implement back-end services in the background. The front end obtains and uploads data through Ajax request, and the back end returns the result to show the corresponding rendering effect.  
For data storage, we chose the relatively popular MongoDB, which has good support for files and json type data.  

**Middle Tier**  
###Springboot  
Spring Boot is a new framework from the Pivotal team designed to simplify the initial setup and development process for new Spring applications.  
The framework uses a specific way to configure, eliminating the need for developers to define boilerplate configurations. As a popular Java framework, SpringBoot can be easily integrated with MongoDB. We can manipulate MongoDB with code by simply adding code and MongoDB related configuration in its configuration file Application.yml.    

![image](https://user-images.githubusercontent.com/73413798/117576452-aaee2f80-b118-11eb-86a5-fb9da6202d4d.png)  


At the same time, SpringBoot, as a server-side framework, integrates Tomcat container in spring-boot-starter-web. We just need to run it to provide services.  
![image](https://user-images.githubusercontent.com/73413798/117576474-be999600-b118-11eb-8fa9-6d5f4cce6ab1.png)  



