**José Monteiro** (1160630) - Sprint 3 - LANG08.2
===============================

# 1. General Notes
For this iteration I incremented the simple javascript compiler, and I added an additional feature - (persisted) functions.
To do this, I looked at the LPROG notes and provided documents.




# 2. Requirements
**Lang08.2 - Javascript with Methods without parameters**
This feature increment should have the same functionality as **Lang06.2** but with the adaptations required by the syntax of the language.

 * **Lang06.2** - The application should now support multiple macros. Each macro should have a name and should be associated with an workbook. The grammar of the macros should also have a mechanism to support the invocation of macros. It only should be possible to invoke macros of the same workbook. Special attention should be devoted to recursion (i.e., avoiding infinite recursion).

 We can specify this requirements in 3 User Story only:
+ US1 - As a user I want to create and save a function;
+ US2 - As a user I want to get an exisiting function;
+ US3 - (aditional) As a user I want to remove a function;


# 3. Analysis
In this part of the project I had to get in contact with the use of Antlr in Java.
It was hard at the beginning to understand, but after a step-by-step debug, it seems pretty easy actually.

## 3.1 Antlr

Some information that I got from the internet, to learn the tool:

In computer-based language recognition, ANTLR (pronounced Antler), or Another Tool For Language Recognition, is a parser generator that uses LL(*) for parsing. ANTLR is the successor to the Purdue Compiler Construction Tool Set (PCCTS).

**LL PARSER** -  An LL parser is a top-down parser for a subset of context-free languages. It parses the input from Left to right, performing Leftmost derivation of the sentence.

[From wikipedia](https://en.wikipedia.org/wiki/ANTLR)

   
## 3.2 Antlr in Java
To make a language reconizer, We need at least to create 2 files:
* Create a G4 file, this file is the grammar;
* After created this file, and run mvn clean install we'll get 6 auto generated files;
* Now we'll create our eval visitor, this class will extend the generated BaseVisitor, in here we'll also define the behaviour of the grammar;


## 3.4 Analysis Diagrams

####USE CASES
![Use Case 1](usecases.png)

####DOMAIN MODEL (For this feauture increment)
![Domain Model](domain.png)

####SHORT SEQUENCE DIAGRAMS
#####FOR US1 - As a user I want to create and save a function;
![US1](ssd1.png)
#####FOR US2 - As a user I want to get an exisiting function;
![US2](ssd2.png)
#####FOR US3 - (aditional) As a user I want to remove a function;
![US3](ssd3.png)

# 4. Design




## 4.1. Requirements Realization
#####FOR UC1
![UC1](design1.png)
#####FOR UC2
![UC2](design2.png)
#####FOR UC3
![UC3](design3.png)


## 4.4. Design Patterns and Best Practices
* MVP;
* SOLID (Interface segregation principle);

# 5. Implementation

Code Organization

We followed the recommended organization for packages:
- Code should be added (when possible) inside packages that identify the group, sprint, functional area and author; - For instance, we used lapr4.red.s3.lang.1160630

The code for this sprint:
Project server 
- pt.isep.nsheets.server.lapr4.red.s3.lang.n1160630.Js: Contains the Function Repository interface and Service and the JavaScript controller;

* Updated the existing packages: 
    * pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;
        * Added JpaFunctionRepository;
    * pt.isep.nsheets.server.services;
        * Added FunctionServiceImpl;

Project shared
- Added the classes (in pt.isep.nsheets.shared.core.js_complex): 
    * EvalVisitor; 
    * Function;
    * Main (for tests only); 

- Generated the classes (in pt.isep.nsheets.shared.core.js_complex.compiler): 
    * Js_complexBaseListener; 
    * Js_complexBaseVisitor; 
    * Js_complexLexer; 
    * Js_complexListener; 
    * Js_complexParser; 
    * Js_complexVisitor; 

Project NShests - Updated the classes: 
* pt.isep.nsheets.client.aaplication.home.Code_JavascriptView and 
* pt.isep.nsheets.client.aaplication.home.Code_JavascriptPresenter
* pt.isep.nsheets.client.application.home.Code_JavascriptView.ui.xml






# 8. Work Log

* [Added domain diagram, use cases and some information about the UC](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/54b60cd2fb64bc7bbb5c142175ca4c591e181e78)
* [README.md edited online with Bitbucket](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/a000463d26daf1a95cadb5c667618d338def12e8)
* [Added option to remove function; Final adjustments](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/d319f41ad0de2d0b66254b63e50a3176d531b04c)
* [UC almost functional](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/77fbe594c4066b1895df967d9e3293491a7d6264)
* [Added function class](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/615a4c4ae9d54d32d66d07388d7878013c1500ff)
* [Added functions with return](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/703324f872cab559e25acd86ea1cf4081b0f2951)
* [Added functional functions (without return)](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/133169b10aa18df2d8cc55c49d3b3b275b1b2d3d)
* [Added new Interface for JavaScript with parameters](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/a566c7961ad63c26ee707efedae9e1ce7d72dbda)