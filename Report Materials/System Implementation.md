# System Implementation

&nbsp;

* [**Stack architecture and system design**](#stack-architecture-and-system-design)
* [**Front end**](#front-end)
* [**Middle tier**](#middle-tier)
* [**Back end**](#back-end)
* [**Additional elements and components**](#additional-elements-and-components)
* [**Continuous integration**](#continuous-integration)


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


* SpringBoot exports REST APIs using Spring Web MVC & interacts with MongoDB Database using Spring Data MongoDB
* Angular Client sends HTTP Requests and retrieve HTTP Responses, and shows data on the components.  


In this project, we used the front and back end separation method. The front end uses Angular to render and display the page. The more popular SpringBoot is used to implement back end services in the background. The front end obtains and uploads data through Ajax request, and the back end returns the result to show the corresponding rendering effect.    


&nbsp;


![image](https://user-images.githubusercontent.com/73413798/117623119-fb5f9e80-b1a5-11eb-9eb6-a292a0f3dfda.png)![image](https://user-images.githubusercontent.com/73413798/117623140-01557f80-b1a6-11eb-9b1b-0208fa07491f.png)![image](https://user-images.githubusercontent.com/73413798/117623165-0adee780-b1a6-11eb-8edd-1f49635d08fc.png)     

&nbsp;

* Angular is a popular and easy-to-use front end framework that leverages the power of a modern Web platform with high performance, offline, and zero installation. 



* The SpringBoot framework is an open source application framework on the Java platform that provides a container with inversion of control features.    



* For data storage, we chose the relatively popular MongoDB, which has good support for files and json type data.   
&nbsp;

&nbsp;

## **Front end**

&nbsp;

**There are a few features we confirmed with Little Planet after early UX process, which we used to guide our frontend development:**

  * A Single Page Application
  * Simple in UI style & Streamlined user experience
  * Easiness to build, maintain and upgrade

**Based on this criteria, we chose Angular as our frontend frame as it has the following advantages:**

  * **Stability:**
    Angular is an open source framework built with Typescripts. It's currently maintained by google and individual developers. With code reviewed by thousands     of developers,  bugs in Angular should be identified very quickly and the overall software quality of Angular should be in a relatively high level. Therefore, Angular is able to provide long term support for Little Planet.
  * **Easy to Use & Maintain:**
    * **Component-based architecture:**
      * Organized working flow:
        Angular organizes codes in small chunks, i.e. components. This would allow us to implement each elements (Home, Progress Tracker, Login, etc.) of Little Planet in an organized way and provide easiness for us to link the elements referencing the Interaction flow diagrams we created during UX design. 
      * Easiness in testing & debugging:
        Since features of Little Planet can be developed separately as  components, it would be easy for us to conduct tests and detect which part goes wrong.
      * Efficiency in programming:
        Codes grouped into components can prevent us from coding repetitively and reuse available resources, which can ensure a smooth development process.
    * **Simplified MVC pattern MVVM: **
      <p align = "center">
      <img src="/Report%20Materials/System%20Implementation/MVVM%20theory.png" alt="Changes Tracking" width="600"/>
      </p>
      Angular uses a simplified Model-View-Control (MVC) pattern which is similar to Model-View-View-Model. Such pattern enable Angular achieve two-way data binding between View and ViewModel and streamlined the coding flow developers as there is no need to write getters and setters. With  such feature, using angular can help us speed up our working process while maintaining the quality of our scripts.
  * **Strong Community Support:**
      As a mature and popular framework, there are tons of tutorials on Youtube and websites, like https://angular.io/start. Supports could also be found through forums like stackoverflow(https://stackoverflow.com/).

**Below are detailed explanations on our frontend system implementation:**
We took advantages of Angular's component-based architecture and managed to develop pages of our website application in an organized way.
<p align = "center">
<img src="/Report%20Materials/System%20Implementation/FrontEnd.png" alt="App Components" width="600"/>
</p>

With MVVC-like feature of Angular, we could easy track changes on the screen after we updated source codes:
<p align = "center">
<img src="/Report%20Materials/System%20Implementation/MVVM.png" alt="Changes Tracking" width="600"/>
</p>

**Reference Materials & Picture Source:**

	* https://en.wikipedia.org/wiki/Angular_(web_framework)
	* https://www.altexsoft.com/blog/engineering/the-good-and-the-bad-of-angular-development/
	* https://www.grazitti.com/blog/8-proven-reasons-you-need-angular-for-your-next-development-project/#:~:text=Angular%20helps%20build%20interactive%20and,dependency%20injection%2C%20and%20AJAX%20handling.
	* https://medium.com/@maaouikimo/why-angular-is-your-best-choice-for-you-next-projects-9d754fb18f91#:~:text=Simplified%20MVC%20Pattern%20MVVM&text=Angular%20does%20not%20ask%20developers,%2DView%2DController)%20one.
  
&nbsp;

&nbsp;

## **Middle tier**

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

The RESTful architectural style dictates that meta-operations on data, namely CRUD(create, read, update, and delete) operations correspond to HTTP methods, respectively:  

* GET is used to obtain resources  

* POST is used to create resources (which can also be used to update resources)  

* PUT is used to update resources  

* DELETE is used to DELETE resources, thus unifying the interface of data operation.  

All the work of adding, deleting and changing data can be done only through the HTTP method.  

The advantages of REST:

* Caching can be used more efficiently to improve response time.

* The statelessness of the communication itself allows different servers to handle different requests in a series of requests and improves the scalability of the server.

* The browser can act as a client, simplifying software requirements.

* REST has fewer software dependencies than other mechanisms that stack on top of the HTTP protocol.

* No additional resource discovery mechanism is required.

* Better long-term compatibility in the evolution of software technology.


&nbsp;




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



## **Back end**  

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


Here is our ER diagram for database building, We use 3 table to store our data, Including User_data table to store our user's account(u_id) and password, goal table to store all goals created by our users, whether it's achieved or not(if achieved, attribute is_achieved will be updated to 1, if user give up their goal, we won't delete this document but update attribute is_deleted from 0 to 1), and an already created table reward to store all our reward pictures' url and owner of a certain picture.  

&nbsp;


<p align="center">
<img src="https://user-images.githubusercontent.com/73413798/117675038-cae82680-b1de-11eb-8ddd-7c0001058be6.png" width = 50%>
</p>
<p align="center">
<img src="https://user-images.githubusercontent.com/73413798/117674564-590fdd00-b1de-11eb-8f6d-b2a91cd5103f.png" width = 50%>
</p>


&nbsp;


We use a NoSQL visualization tool "NoSQL Manager for MongoDB" to manage our data. reward table as shown below:  

&nbsp;



<p align="center">
<img src="https://github.com/Blind4life/trash/blob/main/%7DXZ14RHZ_L2L%25GY8B~49KHN.png?raw=true" width = 85%>
</p>  


&nbsp;

   Or for future expansion, we can also store these data at cloud by import [script](https://github.com/Lexie-yw/Software-Engineering-Work/blob/main/database/planetdb.txt).  
A manual created goal table for test look like this:  


&nbsp;


<p align="center">
<img src="https://github.com/Blind4life/trash/blob/main/%5DB(HKH1R)F~MOC32AG7%7DV%7B6.png?raw=true" width = 85%>
</p>


&nbsp;

The home directory is divided into three packages: one for users, one for goals, and one for reward images.
We save the reward pictures into the database, and the user collects the pictures by completing the goal.   




&nbsp;

```
User dbUser=userService.getUserByEamil(user.getEmail());
        if(dbUser!=null){
            response.hasUser();
            return response;
        }
```

```
  User dbUser=userService.getUserByUserId(user.getUserId());
        if(dbUser==null){
            response.noUser();
            return response;
        }
 ```       
&nbsp;

When a user fills in an email address or a user name and password, the first step is to determine whether the user has filled in correctly through a number of parameter checks. When the user has filled in all correctly, through the user name interface, through the mailbox to judge whether the mailbox has existed, if it has existed, then it proves that the user has registered, then we give him back a prompt: "the user has existed". If not, we'll add a new user.


&nbsp;

 ```
  public List<Goal> getAllGoalByUserId(String userId) {
        Goal goal=new Goal();
        goal.setUserId(userId);
        ExampleMatcher matcher=ExampleMatcher
                .matching()
                .withMatcher("userId",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Goal> example=Example.of(goal,matcher);
        return goalRepository.findAll(example);
    }
 ```
 
&nbsp;

The way to add a goal is through the username. Each goal is bound to a user, so the goal is bound to a user ID. Through the URL, we can find the goal set by the user and the goal update operation, and some simple add, delete and change functions.


&nbsp;



 ```
@Service
public class RewardServiceImpl implements RewardService {
    @Autowired
    private RewardRepository rewardRepository;
    @Override
    public Reward getReward() {
        List<Reward>  list=rewardRepository.findAll();
        int size=list.size();
        Random random=new Random();
        return list.get(random.nextInt(size));
    }
}
 ```
 
&nbsp;


The whole process of getting the reward picture is as follows:  

check how many groups of pictures there are in the database, such as 10 groups of pictures, create a random number from 0 to 10, such as 5 randomly, call the picture with ID of 5 to the URL of the front-end database, and request the user mailbox to get the picture.


&nbsp;



```
import com.work.entity.Goal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends MongoRepository<Goal,String> {
}
```

```
import com.work.entity.Reward;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends MongoRepository<Reward,String> {

}
```

```
import com.work.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
```

&nbsp;

The dao package implements database operations. They all inherit from MongoRepository, which provides support for various database operations. We can manipulate the database as if it were an object call. The Server layer holds the service interface, and the specific implementation of the service is in the server.impl. 

&nbsp;

```
public Response success(){
        this.code=200;
        this.msg="success";
        return this;
    }

    public Response paramEmpty(){
        this.code=10001;
        this.msg="param is fail";
        return this;
    }
    public Response noUser(){
        this.code=10002;
        this.msg="user not exists";
        return this;
    }
    public Response hasUser(){
        this.code=10003;
        this.msg="user is exists";
        return this;
    }
```


We also created the underlying return information under the resp package. The response class is returned as a uniformly formatted data format, with code identifying the return code. msg is the message prompt and data is the data returned. Finally, the controller provides the interface path and the mapping implementation.

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


## Continuous integration


&nbsp;


Our team set up a Github account. When creating the repository, we had to grant permissions to each programmer separately, because each person needed to upload his or her own content. We mainly set up the front end, back end, database and report files.

Git continuous integration and overall continuous deployment mainly involve basic Git commands, including Git clone, Git delete, Git add, Git commit, Git push, etc., to complete the deployment of project code through basic Git commands.


