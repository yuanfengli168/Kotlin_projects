# Kotlin_projects
Including basic practice and implementations for Kotlin, spring MVC, spring data, etc

## 03032022: 
Resources: 
- google doc for design is [here](https://docs.google.com/document/d/1ieBGVTwmUyke1EScc_R843HqBAQszUCoJqMopxeKQtE/edit?usp=sharing)
- designed the prototype for the small backend
- implement the basics


## 0304 - 03082022:
1. followed guidance: (but outdated) [guidance link](https://kotlination.com/kotlin-spring-jpa-postgresql-spring-boot-example/)

2. YouTube also gave hints! [youtube link](https://www.youtube.com/watch?v=OX40aNnR74U&t=131s)

3. other helpful debugging materials can be found here with 0308/0307 as the date [doc link](https://docs.google.com/document/d/176FhO8TLhA75-_DzcyMtiAMICzVlVHp3zYnUq_CJIBQ/edit?usp=sharing)
4. My summary and showcase in a video can be found [here](https://youtu.be/F3sz-AU1q-I)
5. prototype in MarchSeventh package, enjoy!


## 0309 - ...: 
1. optimizing controller, adding posting method, using postman to test
2. (optional) adding service level

## 0314 - ...: 
1. has been reading _Spring in Action_
2. using JPA (Java Persistence API) and JDBC (Java Database Connectivity)
3. I have upgraded the MarchSeventh to MarchThirteenth, which has better structures, and more functions, the postman tests are here:
   - https://go.postman.co/workspace/My-Workspace~9b98a38e-dff7-4a21-8861-8dc6e21b6426/collection/18812364-a8054686-6d65-4ff5-8792-6e278e6d48b4?action=share&creator=18812364
4. keep working on Kotlin/OAth 2.0/etc ...

## 0315 - ...: 
1. Doing some research on Projection in Spring: there are two good urls: 
   1. [spring data jpa projections](https://www.baeldung.com/spring-data-jpa-projections)
   2. [详解 spring data jpa 之投影](https://m.yisu.com/zixun/215930.html)
2. Research on OAth2.0's 4 different patterns: 
   1. [Outh2协议有哪四种授权模式？](https://blog.csdn.net/qq_45076180/article/details/117364161): 1)authorization code; 2) password; 3) implicit; 4) client_credentials
      1. things to know: their difference
      2. things to know: their application scenarios
3. Research on the 常用微服务工具链： 
   1. [微服务架构 - 宏观需要了解的东西](https://www.zhihu.com/question/24013141)
   2. [微服务工具](https://www.infoq.cn/article/jdfmjp6cwppvogu4heww)
   3. [微服务架构中的常用开源工具](https://www.jianshu.com/p/64ecd80536a2)
4. Research on JPA in spring boot, again T-T ...
   1. [Java persistence API - Tutorial](https://www.vogella.com/tutorials/JavaPersistenceAPI/article.html#:~:text=JPA%20permits%20the%20developer%20to,is%20defined%20via%20persistence%20metadata.)

## 0317 - ...:
   1. OAuth 2.0 different type has been learned and understand, each implementing scenarios has been discussed. 
   2. Clean the code on my local drive, - MarchThirteenth, including migration service and logic from data access layer to logic layer. etc. 
   3. (optional) will update the code here on github repo. 

## 0324 - ...:
Working on researching the spring security including:

   1. Authentication
   2. Authorization
   3. Web security - filters in spring
   4. Threads and Processing methods Asynchronously 

Here are two very good resources:
- [Original Guide on Spring.io](https://spring.io/guides/topicals/spring-security-architecture)
- [Chinese version and more explanation](https://blog.csdn.net/chuixue24/article/details/89382434)
- [My personal notes with according dates](https://docs.google.com/document/d/176FhO8TLhA75-_DzcyMtiAMICzVlVHp3zYnUq_CJIBQ/edit#)
- [17.8k projects](https://github.com/elunez/eladmin)

## 0328 - ...:
1. Researching on spring config: [here](https://spring.io/projects/spring-cloud-config)
2. Researching on spring Consul: [here](https://spring.io/projects/spring-cloud-consul)
3. Code Refactoring on WebController in MarchThirteenth: 
   1. Uri optimized with less verb, more nouns
   2. Differentiate uris with different @RequestMapping body code, such as params, method, path; Its called URIs overloading. 
   A very good resource to read on [stack over flow - Accessing multiple controllers with same request mapping](https://stackoverflow.com/questions/34587254/accessing-multiple-controllers-with-same-request-mapping#:~:text=Unfortunately%2C%20this%20is%20not%20possible,request%20should%20be%20mapped%20to.)
   ; In summary, you can overloading in one class with additional information, but please don't create more confusion in different classes. 
   3. Changed @PathVariable to @RequestParam
   4. Created new uri with new postman tests: [Postman import link](https://go.postman.co/workspace/My-Workspace~9b98a38e-dff7-4a21-8861-8dc6e21b6426/collection/18812364-499335b9-bf43-45a3-90a5-724b93edc103?action=share&creator=18812364)
   5. Deprecated entityManager in WebController.kt and SaveDao.kt, reasons are: 
      1. We usually don't need to access the EntityManager directly when working on a Spring Data application. [online link](https://www.baeldung.com/spring-data-entitymanager)
      2. Deleted @PersistenceContext as well, but what does it mean?
         1. The @PersistenceContext annotation in your code is being used to indicate that the EntityManager must be automatically injected, in other words its lifecycle will be managed by the container running your application (which is a good thing).Sep 8, 2017
         [link here](https://stackoverflow.com/questions/46114254/spring-boot-persistence-context-annotation#:~:text=The%20%40PersistenceContext%20annotation%20in%20your,which%20is%20a%20good%20thing)
      3. Deleted deleteTableCustomer method in SaveDao.kt as well, due to the reason that we generally do not manage tables in our DAO code, 
      if you want to delete code, please manage them using SQL database system for more security. 
4. 
- Continuing projects: 
  1. Refactorings code in MarchThirteenth locally and then version control... in 2 weeks. 
  2. Redo the precious java project by my self only in ... 2 months.
  3. Redo the previous project written by java to Kotlin in ... 1 month.
  4. 