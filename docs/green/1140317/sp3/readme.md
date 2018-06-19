 **Carlos Figueiredo** (1140317) - Sprint 3 - Core08.2
===============================

# 1. General Notes
The application should have a new extension to associate textual comments with cells. The functionality should be similar to the one present in the desktop version of Cleansheets.
The similarities are in the use of extensions . This application is a web app and has next way of approach. This UC has lots of other UC that depend on it.
The challenge is to make something that is easily applied by everyone.



# 2. Requirements

The application should have a new extension to associate textual comments with cells. The functionality should be similar to the one present in the desktop version of Cleansheets.


Proposal:

US1 - As a User I want the textual comments of a cell to be persisted in the repository, updated everytime the user changes it and I want to be able to change textual comments.


# 3. Analysis

*In this section you should describe the study/analysis/research you developed in order to design a solution.*

For this feature increment, since it is the first one to be developed in a new project I need to:  


- Understand how to integrate a relational database into the project (Will be assuming JPA since it is studied in EAPLI)   
	The CellComment is the class that stores the textual comments of a cell. 
	
	The CellCommentExtension have a list of CellComments that stores in memory while Client app is running. Anytime a setting is changed in the list, the list is check to see if the CellComment already exists to be created or updated. 
	The same happens with the repository database. The CellCommentServiceImp sends the CellCommentDTO to the server, where the CellCommentController checks if exists any Cellcomment with same address as this one. If exists,
	removes the last one and saves the new one. this way, there is only CellComment per Cell. The save in the repository returns a CellComment that is store. It is this cellComment, after Success, that updates in memory
	the list of CellComments in the first mentioned CellCommentExtension 
	

## 3.4 Analysis Diagrams

**System Sequence Diagrams**

![sd](SD1_sp3.jpg)


# 4. Design

*In this section you should present the design solution for the requirements of this sprint.*



## 4.1. Tests

Only function tests were done.


As a User I want the textual comments of a cell to be persisted in the repository and updated everytime the user changes it.

The CellComments changes shall be created in real-time in the database
The CellCOmments if change shall be updated with concurrency care
The CellComents shall be uploaded when we open the WorkbookView



## 4.2. Requirements Realization

*In this section you should present the design realization of the requirements.*

Following the guidelines for JPA from EAPLI we envision a scenario like the following for realizing the use cases for this feature increment.

Notes:  
- The diagram only depicts the less technical details of the scenario;  
- For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in this diagram.   
- **CellCommentServices** realizes the connection with the controller from the UI;  
- **CellCommentController** is the *use case controller* and manages the repository;  



## 4.3. Classes

CellComment is the main class of this Core08.2. It has the textual comments and has a One to One relation with the cell Address.

CellCommentExtension is the main responsible for this funcionality. It has the list of CellComments .

## 4.4. Design Patterns and Best Practices

*Present and explain how you applied design patterns and best practices.*

By memory we apply/use:  
- Singleton  
- Repository  
- DTO  
- MVP

**TODO:** Exemplify the realization of these patterns using class diagrams and/or SD with roles marked as stereotypes. 

# 5. Implementation

To implement this UI it was created a textbox to store the textual comments. We introduce for each cell a textual comment and
it is stored and updated in memory

# 6. Integration/Demonstration

*In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)*

# 7. Final Remarks 

*In this section present your views regarding alternatives, extra work and future work on the issue.*

It was not possible for me to implement a full functional Use Case. 
