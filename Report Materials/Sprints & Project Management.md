# Sprints & Project Management

&nbsp;

* [**Group working methods**](#group-working-methods)
* [**Communication channels and team roles**](#communication-channels-and-team-roles)
* [**Documentation of sprints**](#documentation-of-sprints)
* [**Team use of Git**](#team-use-of-git)

&nbsp;

## Group working methods

&nbsp;

Typical development models are:  

① Waterfall Model;  

② Incremental Model/Evolution/Iteration;   

③ Prototype Model;

④ Spiral model;   

⑤ fountAInmodel;  

⑥ Intelligent models;  

⑦ Hybrid Model


The fountain model was used in our group work. Fountain Model is a kind of model driven by user demand and object, which is mainly used to describe the object-oriented software development process. The model considers that the stages of the bottom-up cycle of software development process are mutually iterative and have no gap.   

Fountain models are mainly used in software development projects using object technology. The model considers that the stages of the bottom-up cycle of software development process are mutually iterative and have no gap. A piece of software is often reworked many times, with related objects adding incremental software components to each iteration. No gap means that there is no obvious boundary between various activities, such as analysis and design activities. Due to the introduction of the object concept, the expression of analysis, design, implementation and other activities only uses object classes and relations, so it is easier to realize the iteration and no gap of activities, so that its development naturally includes reuse.  


&nbsp;






![image](https://user-images.githubusercontent.com/73413798/117652063-49d06580-b1c5-11eb-825c-9604cc61057a.png)  



&nbsp;



The Fountain model is essentially a slightly improved version of its stricter relative – The Waterfall model. This model allows for the advancement from (and return to) various stages of software development regardless of whether or not enough tasks have been completed to reach it.  


&nbsp;




 Fountain Model Phases:
 * Analysis
 * Requirements Specification Design
 * Coding
 * Testing and Integration Operation
 * Maintenance or Evolution


&nbsp;


Advantages of the fountain model:  

Unlike waterfall models, fountain models need to start designing activities after the analysis activities and coding activities after the design activities. The phases of the model are not clearly demarcated and developers can develop simultaneously. Its advantage is that it can improve the software project development efficiency, save the development time, and adapt to the object-oriented software development process.  

&nbsp;

Disadvantages of the fountain model：  

Because the fountain model overlaps in each development stage, it requires a large number of developers during the development process, which is not conducive to project management. In addition, this model requires strict management of documents, which makes auditing more difficult, especially when various information, requirements, and materials may be added at any time.

Since the project development time is limited and our project focuses on the needs of users, we want to be able to carry out the project development more efficiently. So we chose the fountain model, so that we could clearly divide the work and each of us could focus on what we were responsible for. In addition, we set stage goals for everyone, and we will have regular meetings in the team channel to communicate progress and requirements, so as to ensure the smooth progress of the project.


&nbsp;

&nbsp;


## Communication channels and team roles

Because of COVID-19, we couldn't meet and communicate offline, so most of our work was done online, mainly on Teams and WeChat.

&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117953594-bf187380-b348-11eb-955f-3604d78d54e8.png)  

&nbsp;

![image](https://user-images.githubusercontent.com/73413798/117953650-d0fa1680-b348-11eb-87af-f806be7c23bc.png)

  




&nbsp;



## Documentation of sprints

Our development can be divided into five stages, basically follows the waterfall model, At each stage of development, we introduced our current achievements to people
around us, sought advice from them, and do some improvement to our project. Figure below shows the project development flow.
Because of the cov-19 epidemic, we rarely meet offline, we use online apps such as teams and wechat to communicate.

**Sprint 1. Brain Storm/Forming prototype**(3.15-4.1)  
At this sprint stage, we analyzed some of our current problems, Several creative models were proposed, such as sports recording app. But finally, we found that due to 
the cov-19 epidemic, the pace of our lives has been disrupted, so we decided to develop a app that can help people form habits which can restore people's lives to normal.
after discussion, we decided to introduce CCG mode in our app; We completed a app paper model at the end of this stage.   

**Stage Achievement:**  
1. Determined the task objective.
2. Completed a app model.
3. Tasks were assigned to every teammate;
4. We show our app prototype to user and collect some feedback

User      | Feedback
--------- | -------------
Mr Lungaho| Nice idea to help people form habit
Lady Alba | It would be nice to review achievement

**Reflections:**  
Through user feedback, we believe that our design is valuable, and we decided to introduce collection room in our app.

**Sprint 2. Technical development stage**(4.1-4.23)  
At this stage, we start to work on develop application, we exchange learning progress and problems encountered every Monday. And this stage can be subdivided into 3 small stages。
 * Front-end prototype develop(4.1-4.11).  
   We used angular to make a program prototype, which can carry out basic dynamic interaction and page jump.  
 * Database structure design completed(4.11-4.16)  
   We analyzed the requests required by the front-end and completed the design of database.
 * JAVA springboot back-end design(4.16-4.23)  
   According to the actual situation of our group, our team members choose to use springboot for back-end construction, and at the end of this stage, we got different parts of the software separately.

**Stage Achievement:**  
1. Got a front end that can run independently.
2. Completed database design.
3. Got the program running on the server side.
4. We show our front-end to our users and collect some user experience feedback.

User      | Feedback
--------- | -------------
Mr Lungaho| Maybe it’s better to move the navigation bar to the top 
Lady Alba | Can I delete some targets that I am no longer interested in 

**Reflections:**  
Based on user feedback, we adjusted the page layout and added new attributes to the database to make the function more complete.

**Sprint 3. Independent testing of different parts**(4.23-4.30)  
At this sprint stage, we started independent testing of different parts of the program, we used the front end to conduct user acceptance tests at this 
stage, We have also fixed some bugs in the backend. At this stage, we and the people around us have conducted a lot of tests on the program, and 
received a lot of user experience feedback. At the end of this stage, we made some modifications to the UI of the program to improve the user experience.

**Stage Achievement:**  
1. Completed the unit test of the program.
2. Optimized the UI .
3. Get a lot of user feedback data.

User      | Feedback
--------- | -------------
Mr Lungaho| Try not to use too many colors, it will distract people 
Lady Alba | Interactive animation should be added to the buttons 
Mr Ares   | Can I log out the program?

**Reflections:**  
Fix some bugs, and do some improvement for app UI.

**Sprint 4. Bringing Things Together/More test**(4.30-5.7)  
At this sprint stage, we have added interfaces to the front-end and back-end code to enable the front-end to send requests to the server and the back-end to read and write data to the database. 
And try to assemble the different parts of our program, and conducted more tests.  
**Stage Achievement:**  
1. Add an interface in the front end to request different data from the server.
2. Add an interface in the back end to interact with database.

see more details in [evaluation](https://github.com/Lexie-yw/Software-Engineering-Work/blob/main/Report%20Materials/Evaluation.md).

**Sprint 5. Documentation**(5.7-)  
At this stage, we summarized our work content, and planned the next work based on feedback and new ideas. The goal of this stage is to complete the document.



&nbsp;

## Team use of Git

Apart from teams, Git can be counted as our second communication tool. We created different branches to do tests separately and merged the successful working pieces into the main branch. As a version control and online collaboration tool, Git provided so much ease for our collaboration.

We followed a routine to always git fetch before starting working to see if there are new changes added by coworkers, and git push our own contribution with a commit message stating what scripts had been updated. When there was a real conflict, we would discuss through teams and then make the decision.

While we were making progress in our project, we were also getting more and more familiar with git and managed to store everything in an organized structure and streamlined our workflow. 

