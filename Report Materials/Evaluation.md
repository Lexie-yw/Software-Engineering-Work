# **Evaluation**


&nbsp;

## Back end test

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
