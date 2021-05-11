**Evaluation**

A Mock test is a test in which some complex object (such as a ResultSet object in JDBC) is not easy to construct (such as HttpServletRequest must be constructed in a Servlet container) or is not easy to obtain. A Mock object is used to create test methods that can be tested.

Mocks are designed to solve problems that are difficult to develop and test due to coupling between different units. Therefore, mocks can be used in unit tests as well as during integration tests and system tests. The most important thing about mocks is that they help you decouple unit tests. If your code has dependencies on another class or interface, they can help you simulate those dependencies and verify the behavior of the called dependencies. For example, a piece of code has dependencies like this:  

![image](https://user-images.githubusercontent.com/73413798/117815599-38a45900-b298-11eb-8593-fe29be2deaf0.png)  


When we need to test class A, if there is no Mock, we need to construct the entire dependency tree. Using A Mock, we can break down the structure like this:  


![image](https://user-images.githubusercontent.com/73413798/117815708-5245a080-b298-11eb-82f6-5bb4e5ed6995.png)  



(1) It is necessary to separate the current tested unit from its dependent modules and construct an independent testing environment. It does not pay attention to the dependent objects of the tested unit, but only pays attention to the functional logic of the tested unit.

such as the code under test need to rely on third-party interface logic to handle the return value, probably because the network or other environmental factors, call the third party often interruption or failure, the unit to be measured not tested, at this time you can use the measured unit and to mock technology will depend on the module separated, the test can proceed.

(2) The module that the unit under test depends on has not been developed yet, and the unit under test needs the return value of the dependent module for subsequent processing.

1) In front and back end projects, before the completion of the development of the back end interface, interface joint tuning;

2) The interface of the dependent upstream project has not been developed yet, and it needs to be tested by interface coordination;

For example, the code of the Service layer contains calls to the DAO layer, but the DAO layer code has not been implemented yet

(3) The object dependent on the measured unit is difficult to simulate or complex to construct.



Advantages of Mock testing：  


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





We use springbootTest to Test the background interface under the Test package.  

And we mock the front end request to verify the correctness of the result.

login simulation  
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
    
    
The results are printed on the console.
