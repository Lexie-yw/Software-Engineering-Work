﻿# **Evaluation**


&nbsp;

[**Design evaluation**](#design-evaluation)


[**Unit testing and Functional testing**](#unit-testing-and-functional-testing)  
  * [**Front end testing**](#Front-end-testing)
  * [**Back end testing**](#back-end-testing)  

[**User acceptance testing**](#user-acceptance-testing)  



&nbsp;

## Design evaluation
We first designed a prototype of the product based on its functionality. Each group member drew a portion of the product prototype after the initial imagination. That was just a preliminary idea, and we quickly took the following approach to evaluate and improve the design.

### Prototype feedback
After we finished prototyping our product, we showed our design to friends and family and asked them to suggest improvements. For example, there are some button position setting habits and the position of the navigation bar were improved in this step. We considered that the different positions of the buttons that users clicked during goal setting and goal completion might affect whether they could complete the goals easily, and changed the positions of some buttons, including functional improvements. For example, we changed the pause goal to abandon goal, because if users see that they have a pause goal, it is likely to affect their confidence to complete the next goal, so we simply let those goals users no longer want to complete disappear.

### Questionnaire
We posted a questionnaire that included questions asking if the person filling it had experience setting goals but not accomplishing them, if they had used apps that helped accomplish them and what they thought were their benefits. We then asked the respondents to fill in any inconveniences they had encountered while using other similar products. The questionnaire was set up to help us establish our target users and set the tone for the rest of the product design. It also helped us discover features that we hadn't thought of before to add to the prototyping.

link is here (https://docs.google.com/forms/d/e/1FAIpQLScY10gd5m1Xo-fxFQ2uITVq4KF75BZSPWpJlo2t_HcHHjfmwg/viewform?usp=sf_link)

### Interviews and try out
It is essential to interview users or listen to their experiences.There are many issues that were not considered during the design process, such as the lack of a logout function, that were revealed during the process. We have improved a lot from them. Existing progress-tracking/habit-forming applications are generally good at progress visualization but problems like hard to use, lack of gamification or support for cross-platform accessibility are main pain points users have while using the products. In order to design a product that users enjoy to use, we shoud avoid user pain points and value features users valued, like progress visualization.


## Unit testing and functional testing

### Front end testing
In the front-end testing, we divided into two parts. First, we test whether the front-end can load the page independently and the successful rendering of the page, as well as the interaction between the front-end and back-end.


Home Page
   * home page is set as default page when using the app, so it should be loaded automatically 
   * The page should load an entity:‘total goals achieved’
   * Navigation bar should work

Login Page
   * When clicking the ‘create a new account’button, user info should be set correctly in registration.component.ts
   * When clicking the ‘login’button, user info should be set correctly in registration.component.ts
   * User could tap their information in the correct position
   * Navigation bar should work

Goals Page
   * Three text areas should be loaded successfully, and Hints should be at the correct location.
   * When user tap their goalName, Duration and description, their input should be stored in the goal-setting.component.ts file and the hint should disappear.
   * When user click the ‘cancel’button, their input in this page should be set to null, so that they could tap it again easily.
   * When user click the ‘confirm button’, their input should be sent to the server.
   * Navigation bar should work

Progress Tracker Page
   * This page should load all goals and their goal_id
   * The Correspondence of goal and id is correct
   * When click the goal, link should router link the user to the goal-content page, and the id should be passed together as a parameter to the new page
```@test
<ul>
   <li *ngFor= "let item of goal_list">
             <a class="goal-list-item" [routerLink]="['/goal-content/',item.goal_num ]" >{{item.goal_num}}--{{item.goal_name}}</a>      
   </li>
</ul>
```
  * Navigation bar should work

Progress Content Page
   * The parameter ‘goal_id’is received successfully
   * The goalName, Duration and description should be loaded correctly as the goal_id has been passed in this page 
   * When click the ‘check’ button, the entity ‘numbersNow’ should be add one and passed to the backend
   * When click the ‘suspend’ button, the goal should be cancelled and will not appear in the front page later
   * Navigation bar should work

Rewards Library Page
   * This page should load the card has been rewarded to the user successfully
   * The number of the card should be the same as the number of goals accomplished 
   * The card has been rewarded will not be changed 
   * Navigation bar should work

Navigation bar
   * The “Home” link should router link the user to the Homepage page.
   * The “Goals” link should router link the user to the Goals setting page.
   * The “Progress Tracker” link should router link the user to the Progress Tracker page.
   * The “Rewards Library” link should router link the user to the Rewards Library page.
   * The “Login” link should router link the user to the Login page.

 User Authentification(login page)
   * When click the ‘create a new account’ button, if the username appears the first time, user should create successfully
   * When click the ‘create a new account’ button, if the username has been registered, user should get an error ‘user exists’
   * When click the ‘login’ button, if the email has not been registered, user should get an error ‘user not exists’
   * When click the ‘login’ button, if the information is correct, the user should login successfully
   * When click the ‘login’ button, if the user’s password is wrong, the user should git an error ‘password is not correct’

<p align = "center">
<img src="https://github.com/Lexie-yw/Software-Engineering-Work/blob/main/Report%20Materials/test/login_success.PNG?raw=true" alt="login_success" width="600"/>
</p>



&nbsp;


## Back end testing

&nbsp;

A Mock test is a test in which some complex object (such as a ResultSet object in JDBC) is not easy to construct (such as HttpServletRequest must be constructed in a Servlet container) or is not easy to obtain. A Mock object is used to create test methods that can be tested.

Mocks are designed to solve problems that are difficult to develop and test due to coupling between different units. Therefore, mocks can be used in unit tests as well as during integration tests and system tests. The most important thing about mocks is that they help you decouple unit tests. If your code has dependencies on another class or interface, they can help you simulate those dependencies and verify the behavior of the called dependencies. For example, a piece of code has dependencies like this:  
&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117815599-38a45900-b298-11eb-8593-fe29be2deaf0.png)  


&nbsp;

When we need to test class A, if there is no Mock, we need to construct the entire dependency tree. Using A Mock, we can break down the structure like this:  

&nbsp;


![image](https://user-images.githubusercontent.com/73413798/117815708-5245a080-b298-11eb-82f6-5bb4e5ed6995.png)  

&nbsp;



(1) It is necessary to separate the current tested unit from its dependent modules and construct an independent testing environment. It does not pay attention to the dependent objects of the tested unit, but only pays attention to the functional logic of the tested unit.

such as the code under test need to rely on third-party interface logic to handle the return value, probably because the network or other environmental factors, call the third party often interruption or failure, the unit to be measured not tested, at this time you can use the measured unit and to mock technology will depend on the module separated, the test can proceed.

(2) The module that the unit under test depends on has not been developed yet, and the unit under test needs the return value of the dependent module for subsequent processing.

1) In front and back end projects, before the completion of the development of the back end interface, interface joint tuning;

2) The interface of the dependent upstream project has not been developed yet, and it needs to be tested by interface coordination;

For example, the code of the Service layer contains calls to the DAO layer, but the DAO layer code has not been implemented yet.  


(3) The object dependent on the measured unit is difficult to simulate or complex to construct.

&nbsp; 



Advantages of Mock test：  


(1) Teams can work in parallel

With mocks, back-end people can simply define the interface document and start working in parallel, interacting with each other only during the final syndation phase. If there is interface coupling between the back end and the back end, it can also be mocked; Mocks can also be used if you encounter dependent interfaces that are not ready. There is no situation where one team is waiting for the other. In this way, the development of self-testing stage can be carried out as early as possible, so as to find the timing of defects in advance, conducive to the quality of the entire product and progress assurance.

&nbsp;

(2) Enable TDD mode, i.e. Test-Driven Development

Unit tests are a cornerstone of TDD implementations, and TDD often encounters situations where collaborative modules are not yet developed, but with mocks, these are not a problem. Once the interface is defined, testers can create a Mock to add the interface to the automated test environment, creating tests ahead of time.

&nbsp;

(3) You can simulate resources that are not accessible

For example, if you need to call a resource outside the "wall" for debugging purposes, you can Mock it yourself.

&nbsp;

(4) isolation system

If we need to call a POST request to get a response and see if the current system is handling the "response" correctly, but the POST request is polluting the data in the database, then we can take full use of the Mock and construct a virtual POST request that we specify to return.


&nbsp;


We use springbootTest to Test the background interface under the Test package.  

And we mock the front end request to verify the correctness of the result.

&nbsp;  


Login mock: 

```@Test
    public void login() throws Exception{
        User user=new User();
        user.setEmail("123@164.com");
        user.setPassword("123");
        String param= JSONObject.toJSONString(user);
      this.mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
              .contentType(MediaType.APPLICATION_JSON).content(param))
      .andDo(print()).andReturn().getResponse();
    }
```
    
    
The results are printed on the console.  

```
MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Vary:"Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers", Content-Type:"application/json"]
     Content type = application/json
             Body = {"code":200,"msg":"success","data":{"userId":"6087d963120dda53a75f6149","userName":"test4","email":"123@164.com","password":"123"}}
    Forwarded URL = null
   Redirected URL = null
          Cookies = []

```  

Registration mock:  
```
@Test
    public void register() throws Exception{
        User user=new User();
        user.setUserName("test4");
        user.setEmail("123@164.com");
        user.setPassword("123");
        String param= JSONObject.toJSONString(user);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/register")
                .contentType(MediaType.APPLICATION_JSON).content(param))
                .andDo(print()).andReturn().getResponse();
    }
```  


Return result

```
MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Vary:"Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers", Content-Type:"application/json"]
     Content type = application/json
             Body = {"code":10003,"msg":"user is exists","data":null}
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
 ```
 The user is prompted that the user already exists because the user already exists.   
 
 AddGoal mock:  
 
 ```
 @Test
    public void addGoal() throws Exception{
        Goal goal=new Goal();
        goal.setUserId("6087d963120dda53a75f6149");
        goal.setGoalName("test4");
        goal.setDescription("desc");
        goal.setTotalTimes(10);
        goal.setNowTimes(0);
        goal.setStatus(0);
        String param= JSONObject.toJSONString(goal);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goal/add")
                .contentType(MediaType.APPLICATION_JSON).content(param))
                .andDo(print()).andReturn().getResponse();
    }
 ``` 
 
 Return result  
 
 ```
 MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Vary:"Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers", Content-Type:"application/json"]
     Content type = application/json
             Body = {"code":200,"msg":"success","data":null}
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
```
Get goal mock:  
```
@Test
    public void getGoal() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/goal/get/6087d963120dda53a75f6149"))
                .andDo(print()).andReturn().getResponse();
    }
```
Get goal 6087d963120dda53a75f6149 as user ID mock:  
```
@Test
    public void getGoal() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/goal/get/6087d963120dda53a75f6149"))
                .andDo(print()).andReturn().getResponse();
    }
```   
Return result  
```
MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Vary:"Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers", Content-Type:"application/json"]
     Content type = application/json
             Body = {"code":200,"msg":"success","data":[{"goalId":"609a22c7fbc24d11cb84cae0","userId":"6087d963120dda53a75f6149","goalName":"test4","description":"desc","startTime":null,"endTime":null,"status":0,"totalTimes":10,"nowTimes":0},{"goalId":"609a23b97487b70b7bfd64c5","userId":"6087d963120dda53a75f6149","goalName":"test4","description":"desc","startTime":null,"endTime":null,"status":0,"totalTimes":10,"nowTimes":0},{"goalId":"609a24660628c1106461e934","userId":"6087d963120dda53a75f6149","goalName":"test4","description":"desc","startTime":null,"endTime":null,"status":0,"totalTimes":10,"nowTimes":0}]}
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
``` 
Get picture mock:
``` 
@Test
    public void getpic() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/reward/get/pic"))
                .andDo(print()).andReturn().getResponse();
    }
``` 

 Return result  
 ```  
MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Vary:"Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers", Content-Type:"application/json"]
     Content type = application/json
             Body = {"code":200,"msg":"success","data":{"id":"60992465ad200000e1003ccc","img_index":"10.0","img_url":"https://github.com/Lexie-yw/Software-Engineering-Work/blob/main/little-planet/src/assets/Countries/America_north/Canada/pic.png?raw=true","img_achieved":"0.0"}}
    Forwarded URL = null
   Redirected URL = null
          Cookies = []	 
 ```
 
 &nbsp;
 
 
 
## User acceptance testing
   In order to test whether our products can meet the needs of users as designed, We undertook the user-acceptance testing.  
    Our main test subjects are friends around us, and the app patch we used for test is our front-end patch. In order to facilitate users to provide feedback, 
    We recommend our users to suggest from the following aspects:  

<p align="center">
<img src="https://github.com/Blind4life/Tech/blob/main/mutong.jpg?raw=true" width = 30%>
</p>  


* Functional completeness 
      Our application designed to provides the following functions:
      - Recording functions. Including target's content, including title, description and other details
      - Tracking function. User can keep tracking their app-using process
      - Review function. User can review their achievement through app
      - Reward system. User can get corresponding reward by app.
      We hope users give their opinion whether we complete these function.
+ Ease to use 
      we hope that our app not only function well, but also easy to use, this means, we try to simplify the user interface as much 
      as possible while maintaining the completeness of the functions, so as to make it easier for users to interact. We hope users to suggest from following aspects:
      - Pages/Button easy to find
      - Whether the page layout is reasonable 
      - Any other inconvenience about interaction
+ APP UI aesthetics
      At this part, we hope that users can give feedback on the look of our UI, including the overall style, color tone, layout etc.
+ App design logic
      We also hope that users could give us some suggestion about our app design logic, like our motivation and our strategy, Are they attractive enough, 
      or whether our strategy solves the problem we aim at. 
+ Other suggestion(Strengh/weakness)  
        


   And finally we get some feedback from our user, We use the following diagram to summarize the representative opinions of test users. 
<p align="center">
<img src="https://github.com/Blind4life/Tech/blob/main/%E5%9B%BE%E7%89%871.png?raw=true" width = 65%>
</p>  
    
   According to user feedback, most test users believe that our existing design is sufficient to meet our original design intentions, and can complete a series of processes such as setting goals, tracking goals, reviewing, and rewarding, and these functional pages or buttons are easy to find; Some test users think that the simple design style of our APP is very neat, while other users think that our page design is a bit simple; Many test users suggested that our reward system is a little bit simple and not attractive enough; Most test users said they have had the same troubles about habit forming, they think our APP has certain practical value, but they also said that our current model is not enough.
   
   
   
   

### **Future improvement points**

   From the feedback given by our users, we want to do some future improvement about our app:
   * Beautify the interface of the program
   * Add more types of bonus cards, not just city views, and add relevant descriptions to the cards 
   * Add card exchange system between users 
   * More user-friendly program interface 

