**Pedro Vieira** (1160634) - Sprint 3 - IPC06.2)
===============================

# 1. General Notes



# 2. Requirements

IPC06.2 - The application should now support multiple macros. Each macro should have a name and should be associated with an workbook. The grammar of the macros should also have a mechanism to support the invocation of macros. It only should be possible to invoke macros of the same workbook. Special attention should be devoted to recursion (i.e., avoiding infinite recursion).


# 3. Analysis

## 3.1 GWT and Project Structure

## 3.2 Messages

(In previous iteration)
Messages are entities composed with an atribute text wich is stored the content of the message, user wich is stored the user who send the message and a date, wich saves the date wich the message was sent.

(My iteration)
Added the attribute of the index of the chat.

## 3.3 Refreshing the Messages

(In previous iteration)
In this application i used a pooling method, wich consists of in a certain time interval the client asks the server for all of is messages. In that way we can "delete" all the messages currently in the client and replace them with the new ones. This method can become slow because the client can be asking for new messages and updating them but nothing changes, so it becomes inefficent.

Another solution is the server pushes the new messages when they are creted, resulting in a better perfoming server. This solution is a lot harder to develop and brings little to none beneficts to this particular application, so I opted for the polling method.

(My iteration)
I tested using threads, but GWT didn't support and by events, using a class Wath Dog and same result, so I opted to stay on the polling method.

## 3.4 Analysis Diagrams


**Domain Model (for this feature increment)**

![Domain Model](dm.png)


**System Sequence Diagrams**

![Analysis SD](analysis.png)


# 4. Design

## 4.1. Tests

They are done and addapted for the new attribute of the Message, on packages:

	pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.application

	pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain


## 4.2. Requirements Realization

*In this section you should present the design realization of the requirements.*

Following the guidelines for JPA from EAPLI we envision a scenario like the following for realizing the use cases for this feature increment.


![SD US](design.png)


Notes:
- The diagrams only depicts the less technical details of the scenario;  
- For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in this diagram.   
- **MessageServices** realizes the GWT RPC mechanism;
- **AddMessageController** is one *use case controller*;   
- **ListMessageController** is one *use case controller*;
- **AddMessageServices** is to add a Message to the messageRepository;
- **ListMessageServices** is to group together all the services related to Message.


## 4.3. Classes

*Present and describe the major classes of you solution.*

The most important classes i used were the following:
-MessageRegister
-Message
-MessageDTO
-AddMessageController
-ListMessagesController
-ChatService
-MessagesService
-MessagesServiceAsync
-MessagesServiceImpl
-ChatPresenter
-ChatView


## 4.4. Design Patterns and Best Practices

*Present and explain how you applied design patterns and best practices.*

By memory we apply/use:
- Singleton, across multiple classes
- Repository, in the package Server
- DTO, in the package Shared
- MVP, in the package NSheets
- GRASP, GoF, SOLID and DDD, where shown in some classes and relations bettween classes.
	For instance, we have controller pattern in controller classes, pure fabrication in the factory's done by Server,  high cohesion and low coupling especially important for Shared package and many moore.


# 5. Implementation

**Code Organization**  


The code for this sprint:  
Project **server**    
- pt.isep.nsheets.server.**lapr4.green.s1.ipc.n1160815**.users.application: contains the controllers and a Service
- pt.isep.nsheets.server.**lapr4.green.s1.ipc.n1160815**.users.domain: contains the domain classes  
- pt.isep.nsheets.server.**lapr4.green.s1.ipc.n1160815**.users.persistence: contains the persistence/JPA classes  
- Created class: **pt.isep.nsheets.server.MessagesServiceImpl**  

Project **shared**  
- Added the class: **pt.isep.nsheets.shared.services.MessagesDTO**: This class is new and is used as a Data Transfer Object for the class Message  

Project **NShests**
- Created the UI: **pt.isep.nsheets.client.application.Chat**


# 6. Integration/Demonstration

*In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)*

Nothing to report, all that is important to mention, has already been mentioned.

# 7. Final Remarks 

*In this section present your views regarding alternatives, extra work and future work on the issue.*

The UI informs when there is no messages on that chat.
The message is on MaterialBubbles, rather than the MaterialCards, because that's more appealing.

# 8. Work Log

Commits:

[All my commits](https://bitbucket.org/PedroVieira1160634/)

