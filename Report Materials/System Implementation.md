# System Implementation

&nbsp;

* [**Stack architecture and system design**](#stack-architecture-and-system-design)
* [**Front End**](#front-end)
* [**Middle Tier**](#middle-tier)
* [**Back End**](#back-end)
* [**Additional elements and components**](#additional-elements-and-components)
* [**Continuous Integration**](#continuous-integration)



&nbsp;

&nbsp;


## **Stack architecture and system design**



&nbsp;



A single-page application (SPA) is a web application or website that interacts with the user by dynamically rewriting the current web page with new data from the web server, instead of the default method of a web browser loading entire new pages. The goal is faster transitions that make the website feel more like a native app.  

&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117964075-c2fdc300-b353-11eb-8725-7e4caba877b7.png)

&nbsp;
Advantages of Single-Page Applications:  

1. Faster Page Load Time  
2. Easier and Faster to Develop  
3. Ability to Work Offline  
4. Enhanced User Experience







&nbsp;

The three-tier development is to divide the whole business application of the system into the presentation layer, the business logic layer and the data access layer, which is conducive to the development, maintenance, deployment and expansion of the system.  

&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117966841-f42bc280-b356-11eb-9fa3-d00c5a77319f.png)


&nbsp;

The layering is to achieve "high cohesion, low coupling". The idea of "divide and conquer" is adopted to divide problems into different solutions, which is easy to control, easy to extend, and easy to allocate resources.  


* Presentation layer: responsible for direct interaction with the user, generally refers to the interface of the system, used for data entry, data display, etc. It means to only do the work related to the appearance display, and do not do the work that does not belong to him.  

* Business logic layer: used to do some validation work, to better ensure the robustness of the program running. Such as the completion of data add, modify and query business; The specified text box is not allowed to enter an empty string, data format is correct and data type verification; The legitimacy of the user's authority and so on, through the above many judgments to decide whether the operation will continue to pass back, as far as possible to ensure the normal operation of the program.  

* Data access layer: As the name suggests, it is dedicated to interacting with the database. Perform data addition, deletion, modification, display, etc. It is important to note that all Data objects are referenced only at this level, such as System.Data.SQLClient, and should not be referenced anywhere outside of the Data level.
   
 &nbsp;  
   
Three-tier Architecture provides the following benefits:  


Scalability — Each tier can scale horizontally. For example, you can load-balance the Presentation tier among three servers to satisfy more Web requests without adding servers to the Application and Data tiers.  

Performance — Because the Presentation tier can cache requests, network utilization is minimized, and the load is reduced on the Application and Data tiers. If needed, you can load-balance any tier.  

Availability — If the Application tier server is down and caching is sufficient, the Presentation tier can process Web requests using the cache.   

As we can see from the figure, the two-tier architecture has some compelling advantages. While any of the above is debatable, and some of it boils down to subjective preference, there is no doubt that two-tier applications can be easier to build, cheaper, and easier to deploy. However, when it comes to the Internet, the performance of two-tier applications can suffer. Because more data needs to be transferred to the client in a two-tier architecture, the speed of the network can have a significant impact on application performance.

So we chose a three-tier architecture.

&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117959785-ec682000-b34e-11eb-9bb9-7aca0c8eec03.png)


&nbsp;


The stack consists of three components: Angular, SpringBoot and MongoDB. Spring Boot and Angular form a powerful stack to build modern production grade web applications quickly and test it effectively.

In this project, we used the front and back end separation method. The front end uses Angular to render and display the page. The more popular Spring Boot is used to implement back end services in the background. The front end obtains and uploads data through Ajax request, and the back end returns the result to show the corresponding rendering effect.    


&nbsp;


![image](https://user-images.githubusercontent.com/73413798/117623119-fb5f9e80-b1a5-11eb-9eb6-a292a0f3dfda.png)![image](https://user-images.githubusercontent.com/73413798/117623140-01557f80-b1a6-11eb-9b1b-0208fa07491f.png)![image](https://user-images.githubusercontent.com/73413798/117623165-0adee780-b1a6-11eb-8edd-1f49635d08fc.png)     

&nbsp;

* Angular is a popular and easy-to-use front end framework that leverages the power of a modern Web platform with high performance, offline, and zero installation. 



* The Springboot framework is an open source application framework on the Java platform that provides a container with inversion of control features.    



* For data storage, we chose the relatively popular MongoDB, which has good support for files and json type data.   
&nbsp;

&nbsp;

## **Front End**



## **Middle Tier**

&nbsp;
&nbsp;

### SpringBoot  

&nbsp;

SpringBoot is a new framework from the Pivotal team designed to simplify the initial setup and development process for new Spring applications. 
* Using the Spring project boot page we can build a project in a few seconds
* Easy to export various forms of services such as REST API, WebSocket, Web, Streaming, Tasks
* Very concise security policy integration
* Support both relational and non-relational databases
* Support for runtime nested containers, such as Tomcat, Jetty
* Powerful development kit, support hot start
* Automatic management relies on its own application monitoring.
* At the same time, with Spring Boot, our micro-service can start small and iterate quickly.

The framework uses a specific way to configure, eliminating the need for developers to define boilerplate configurations. As a popular Java framework, SpringBoot can be easily integrated with MongoDB. We can manipulate MongoDB with code by simply adding code and MongoDB related configuration in its configuration file Application.yml.   

&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117576452-aaee2f80-b118-11eb-86a5-fb9da6202d4d.png)  

&nbsp;

At the same time, SpringBoot, as a server-side framework, integrates Tomcat container in spring-boot-starter-web. We just need to run it to provide services.  

&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117576474-be999600-b118-11eb-8fa9-6d5f4cce6ab1.png)  

&nbsp;

The background adopts MVC hierarchical management method. Under the com.work package, AppStart serves as the startup entry, and we place it in the root directory. Then we put the object entity under the Entity package, with user information and goal information, respectively. With the user Id, we can get all the goals under that user. The user ID and goal ID will exist in the database as unique indexes, which are strings automatically generated by MongoDB. 

&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117577115-0e795c80-b11b-11eb-9dd5-de4c961ad8d1.png)  
 
 &nbsp;
 
The Server layer holds the service interface, and the specific implementation of the service is in the server.impl. We also created the underlying return information under the resp package.  

The RESTful architectural style dictates that meta-operations on data, namely CRUD(create, read, update, and delete) operations correspond to HTTP methods, respectively: GET is used to obtain resources, POST is used to create resources (which can also be used to update resources), PUT is used to update resources, and DELETE is used to DELETE resources, thus unifying the interface of data operation. All the work of adding, deleting and changing data can be done only through the HTTP method.

&nbsp;

That is:

Get (SELECT) : fetches resources (one or more) from the server.  

POST (CREATE) : Create a new resource on the server.  

PUT (UPDATE) : Updates the resource on the server (the client provides the complete resource data).  

PATCH (UPDATE) : Update the resource on the server (the client provides the resource data that needs to be modified).  

Delete (Delete) : Deletes a resource from the server.  


The Response class is returned as a uniformly formatted data format, with code identifying the return code. msg is the message prompt and data is the data returned. Finally, the Controller provides the interface path and the mapping implementation. It is in a RESTful style, and the return type is json, which is convenient for passing down and receiving.  
  
Advantages of adopting JSON:
1. JSON is faster:

The JSON syntax is very easy to use. We can use only the syntax to provide us with simple data parsing and faster data execution. Because its syntax is very small and light, this is why it performs the response in a faster way.

2. wide compatibility:

It has a wide range of support for browser and operating system compatibility, so applications generated using JSON encoding can be made compatible with all browsers without much effort. During development, the developers considered using different browsers, but JSON provided the capability.

3. Best tools for sharing data:

JSON is the best tool for sharing data of any size, even audio, video, etc. This is because JSON stores data in arrays, so data transfer is easier. Therefore, JSON is an excellent file format for Web APIs and Web development.

4. Parse on the server:

Parsing on the server side is an important part of what developers want. If parsing is fast on the server side, then only the user can get their response fast, so in this case JSON server-side parsing is a strong point indicating that we are using JSON on the server side.

&nbsp;
&nbsp;



## **Back End**  

MongoDB is a database based on distributed file storage, which aims to provide scalable high-performance data storage solution for Web applications.  

It is characterized by high performance, easy to deploy, easy to use, and easy to store data. The main functional features are: 

* Collection-oriented storage, easy to store object type data.
* Mode freedom.
* Support for dynamic queries.
* Supports full indexes, including internal objects.
* Support for queries.
* Support replication and failover.
* Use efficient binary data storage, including large objects (like video, etc.).
* Automated fragmentation processing to support cloud level scalability
* The file storage format is BSON (an extension of JSON).
* Accessible via the network.  

&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117675038-cae82680-b1de-11eb-8ddd-7c0001058be6.png)

&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117674564-590fdd00-b1de-11eb-8f6d-b2a91cd5103f.png)

&nbsp;

We save the reward pictures into the database, and the user collects the pictures by completing the goal. The corresponding relationship is shown in the figure.


&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117832356-000c7b80-b2a8-11eb-8583-ca6e528b114a.png)  



&nbsp;

The dao package implements database operations. They all inherit from MongoRepository, which provides support for various database operations. We can manipulate the database as if it were an object call. The Server layer holds the service interface, and the specific implementation of the service is in the server.impl. We also created the underlying return information under the resp package. The response class is returned as a uniformly formatted data format, with code identifying the return code. msg is the message prompt and data is the data returned. Finally, the controller provides the interface path and the mapping implementation.

&nbsp;


&nbsp;



## Additional elements and components



&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117981817-fcd8c480-b367-11eb-913f-5c6360c564e1.png)


&nbsp;

PostMan is an extensible collaborative platform tool for API development and testing that can be quickly integrated into the CI/CD pipeline. Designed to simplify API workflows in testing and development. For the interface document, we use the interface document generated by postman. 


&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117616934-66a57280-b19e-11eb-82ff-9d97a8aa7ca1.png)


&nbsp;


Postman is very easy to use. All we need to do is log in and import the documentation we provide, so we can view the relevant interface request parameters and returns under the collection, as well as perform relevant tests locally.  

The reasons for using Postman are as follows:
* Easy to use - To use PostMan, you simply log in to your account, and with the PostMan application installed on your computer, you can easily access files anytime, anywhere.
* Using collection-postman allows users to create collections for their API calls. Each collection can create subfolders and multiple requests. This helps organize the test structure.
* Collaborate with multiple people - Collections and environments can be imported or exported to facilitate file sharing. Direct use of links can also be used for shared collections.
* Create environments - Creating multiple environments helps reduce test duplication (dev/QA /STG/ uat/prod) because the same collection can be used for different environments. This is where parameterization takes place and will be described later.
* Create tests - Test checkpoints, such as verifying that the HTTP response status was successful, can be added to each API call to help ensure test coverage.
* Automated tests - By using the collection Runner or Newman, tests can be run in multiple iterations, saving time for repeated tests.
* The Debug-PostMan console helps to examine the retrieved data, making it easy to debug tests.
* Continuous Integration - Through its ability to support continuous integration, development practices can be maintained.



&nbsp;


## Continuous Integration


&nbsp;


Our team set up a Github account. When creating the repository, we had to grant permissions to each programmer separately, because each person needed to upload his or her own content. We mainly set up the front end, back end, database and report files.

Git continuous integration and overall continuous deployment mainly involve basic Git commands, including Git clone, Git delete, Git add, Git commit, Git push, etc., to complete the deployment of project code through basic Git commands.


