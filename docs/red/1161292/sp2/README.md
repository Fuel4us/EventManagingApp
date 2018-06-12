**Tiago Rios** (1161292) - Sprint 2 - IPC01.2
===============================

# 1. General Notes

Questions made to Product Owner (PRP):

```
Q: Should I add security measures, for instance, password hash?
A: Yes.
```

```
Q: Can I create business rules, like Password with minimum requirements?
A: Yes.
```

I also want to thanks my teammate [José Pedro Monteiro](https://bitbucket.org/lei-isep/lapr4-18-2db/src/master/docs/red/1160630/)for every help they gave me so I could finish this Use Case, even though it wasn't possible at all.

# 2. Requirements

IPC01.2 - The application should add the possibility of registering new users. The identification of a user should be based on his email. Each user should have an email, name, nickname and picture (i.e., face photo). The application should display the nickname and photo of the authenticated user in the top of every page.

```
US01
    As a non-registered user,
    I want to create a new account,
    So I can use all the functionalities.
```

# 3. Analysis

##### *In this section you should describe the study/analysis/research you developed in order to design a solution.*  

## 3.1 Analysis Diagrams

The main idea for the "workflow" of this feature increment.

**Use Cases**

![User Stories](us.png)

**Domain Model**

![Domain Model](domainModel.png)

**System Sequence Diagrams**

**For US1**

![US1 Analysis](analysis1.png)

# 4. Design

##### *In this section you should present the design solution for the requirements of this sprint.*


## 4.1. Tests

##### *In this section you should describe the design of the tests that, as much as possibe, cover the requirements of the sprint.*

##### Regarding tests we try to follow an approach inspired by test driven development. However it is not realistic to apply it for all the application (for instance for the UI part). Therefore we focus on the domain classes and also on the services provided by the server.

**SignupController**: This class is responsible for the communication between UI and Domain. In this case, it is where the signup begins in the server, so it can persist a new User in the database.

The information below represents the dummy information used for testing normal behaviour.

```java
private static final String EMAIL = "1161292@isep.ipp.pt";
private static final String USERNAME = "tiago";
private static final String NAME = "Tiago";
private static final String PASSWORD = "Teste123";
private static final Boolean SUPERUSER = false;
```

```java
@Test
public void testNormalBehaviour() throws Exception {
    System.out.println("testNormalBehaviour");
    
    final User expected = new User(EMAIL, NAME, USERNAME, PASSWORD, SUPERUSER);
    SignupController ctrl = new SignupController();

    User result = ctrl.signupUser(new UserDTO(EMAIL, NAME, USERNAME, PASSWORD, SUPERUSER));

    assertTrue("The added User does not have the same data as input", expected.sameAs(result));
}
```

```java
@Test
public void testIfUserWasAdded() throws Exception {
    System.out.println("testIfUserWasAdded");

    final User expected = new User(EMAIL, NAME, USERNAME, PASSWORD, SUPERUSER);
    SignupController ctrl = new SignupController();
    User result = ctrl.signupUser(new UserDTO(EMAIL, NAME, USERNAME, PASSWORD, SUPERUSER));

    ListUserController ctrlList = new ListUserController();
    Iterable<User> list = ctrlList.listUsers();

    assertTrue("The added User is not in the database", list.iterator().hasNext());
}
```

## 4.2. Requirements Realization

*In this section you should present the design realization of the requirements.*

**For US1**

![US1 Design](design1.png)


## 4.3. Classes

*Present and describe the major classes of you solution.*

## 4.4. Design Patterns and Best Practices

*Present and explain how you applied design patterns and best practices.*

- Repository
- MVP
- DTO

# 5. Integration/Demonstration

##### *In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)*

# 6. Final Remarks 

##### *In this section present your views regarding alternatives, extra work and future work on the issue.*

Some Questions/Issues identified during the work in this feature increment:

- My main concern during this sprint was implementing OOP Patterns, like Value Object and Builder.
    - Even though, Value Object could easily be implemented, GWT provides tools for input validation with Regular Expressions, so I decided to used them.
    - About Builder Pattern, I didn't find a good solution for it, since I could not initialize an UserBuilder instance in UI. 

# 7. Work Log

* []()
* [Login and Users work with hashed password](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/fb9dad00860ec69a27847b83ffd3b767a83cae49)
* [Changed method implementation and regex](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/1d130cb11ff2c8b8a573467ebbe208929559a3a5)
* [Removed default login information](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/13eeab886008d73649cb23b0d187fed377628c22)
* [Removed image preview](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/04d20b97bc808249441d5ecc5892d18c66bbccac)
* [Changed icon colors and implemented type on password textbox](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/981f9c676d9908c03eea3e68371249b771ec3b32)
* [Email attribute is now unique](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/440faeb89b60efe99281d2063a5614c2c81b2f2f)
* [Added empty file](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/64d3c258accbf8d7308127969b741608036389f6)
* [Fixed tests classes because Picture field on user](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/c8ec0a4ec81553fcefafbcbaaa4439f91fad32d5)
* [Fixed Domain classes](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/b997d81c4a02bcc272a4fff70491b6d30100a903)
* [Application goes to DB to search for registered users](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/42da2e170dac93642c12ea7da5a412ff23d226cd)
* [Fixed where files are saved in the server](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/ecc14fd968d496c3e63a4eba4c4677e77a79347e)
* [Card shows image preview after uploading](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/b053986bfa30a1c9576f742562e2195524cd4271)
* [Added picture to NavBar when logged in](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/4188985c299418b34d0d8786f91179cf743c3aa8)
* [Updated documentation](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/cfb83227236c5ed8b4a65ce1b4fe0de2ab1cb284)
* [Added IPC01.2 tests for Controller and Builder](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/e5678e861e0c82d64cdc0bdd62f81041d0fbb634)
* [Fixed UserBuilder implementation](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/e702cb059606ccaeee3a3aa5538a3be897205139)
* [Removed Password Value Object. GWT UI is working with Regex](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/3a21401073446b8c76c029d28717e3374fef6911)
* [Fixed logged in user UI bugs](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/d9ff5af8bd1064ee3ac792e766ed73d22ffc9592)
* [Application now shows who is logged in](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/ac8f96bccaf2d7cb71f974a5adc611efbfabb447)
* [Added redirection to Login Page after signup](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/c26852b13854e7fcf222225badd56570f3e1c8b0)
* [Implemented input validation](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/f2f1fcaf8c22109354ece287bfb7a9ee1b847624)
* [Fixed Login issues](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/282185efe8e19ae2a70534c074c6edbacab24a1b)
* [Fixed servlet location](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/399c1744d15985a0b35e9fea3433e1091b3afbce)
* [Created add user to database service](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/c40c22cca5b829c8aed4ec50d57f9f3885a77e66)
* [Fixed Signup UI](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/fcbf0a808cf999aea8e759183aaeffec49b8d9f3)
* [Added SignupServices in server module](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/593ef2c0a1ab0b70d24b4c4a31d0ed30e4a86df6)
* [Added SignupServlet](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/f562e3202dfb6be554235726113288c59262ff59)
* [Added all Signup Services](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/c20281b2aff243b68faa289b17c98b3f4638dbf3)
* [Added SignupController](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/e5550b84772240362e8ce65d563dc14bdd3ce120)
* [Fixed User Implementation and Login](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/3944d1cea73d739f6e8f6f28ea72c57cbed78fbb)
* [Implemented ValueObject pattern and Password class; Started Builder pattern implementation](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/f357f501be2867aae9f22d78e3db6060b09558c9)
* [Solved NameTokens merge conflict](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/4d4db65cc9a4d60abf76e0de56dfbff40de02a1e)
* [Implemented IPC01.2 UI](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/bd6b477286f62a5875b3e0f081106d9cb4aae202)
* [Application installs SignupModule](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/64fa94c53a63774e43aca54e3a7be7d2d6764c16)
* [Updated IPC01.2 Documentation](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/dd252ec54d2fb8dfee088d0b91eca52df2b25305)
* [Added all IPC01.2 diagrams](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/df682bd5185781fcef3730ac35917ebf20ed13c1)
* [Added IPC01.2 US analysis](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/b2ab8171bcb22fd2e1e19954af3a4a60d14dfc21)
* [Started IPC01.2 analysis](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/f3867671478948778f5b260af24a603b0a29ab35)