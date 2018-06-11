**Josué Lapa** (1160713) - Sprint 2 - Core05.1
===============================

# 1. General Notes

Questions made to the Product Owner:

```

```

# 2. Requirements

*Core05.1 - Contacts - Description:*
"Each user of the applications should have a list of contacts. A contact is another user of the application that has established a contact with the user of the application. A user of the application may establish a contact with another user by sending an invitation if he/she knows the email of the other user. A user may or not accept an invitation. A user can block/unblock invitations from other users."

*Specification of the User Stories:* 

```
US01
	As an user,
	I want to send an invitation to another user
```

```
US02
	As an user,
	I want to be able to accept/deny/block/unblock invitations from other users
```
                                                                       
# 3. Analysis

## 3.1 Analysis Plan
**Contact** - Registry owned by an user containing information from another other
**Invite** - Contact waiting for acception/denial by the end user


## 3.2 Analysis Diagrams

The main idea for the "workflow" of this feature increment.

**Use Cases**

User: 
US1: Send Invitation
US2: Accept/Deny/Block/Unblock Invitations from User

**Domain Model**

**System Sequence Diagrams**



# 4. Design

## 4.1. Tests

### 4.1.1 Testing the use case:

	1. User1 selects Contacts tab

	2. System redirects user1 to the correct module

	3. User1 sends an invitation to User2 by inserting the correspondent email address

	4. System informs User2 of the invitation and asks for an action (Acception or Denial)

	5.1 User2 accepts or denies invitation from User1

	5.2 User2 blocks invitations from User1 (Ends Use Case) (User1 is added to User1 blacklist)

	6. System saves contact (Acception) or dismisses it (Denial)
		

## 4.2. Requirements Realization

*Sequence Diagrams*

**For US1 - Invitation Dispatch**

![US1 Design](Core05.1 - Contacts (Invitation Dispatch).png)

**For US2 - Invitation Reception**

![US2 Design](Core05.1 - Contacts (Invitation Reception).png)


## 4.3. Classes

**Used classes**

**Contacts** and its classes:
```
	- ContactsModule;
	- ContactsPresenter;
	- ContactsView;
	- ContactsView.ui.xml.
	- Contact
	- ContactsController
	- ContactsService
	- ContactsServiceImpl
	- ContactsRepository
	- JpaContactsRepositoryImpl
```
**User** and its classes:
```
	- User;
	- UserRepository;
	- JpaUserRepositoryImpl;
```
## 4.4. Design Patterns and Best Practices

By memory we apply/use:
```
	- Repository  
	- DTO
	- MVP
```
# 5. Implementation

*If required you should present in this section more details about the implementation. For instance, configuration files, grammar files, etc. You may also explain the organization of you code. You may reference important commits.*

**For US1**

		- In order that a user was able to send an invitation to another user, a button was placed in the Contacts User Interface Module allowing an user to send a invitation only if the end user's email is known by the sender. After the button is clicked the System creates a Contact waiting for approval and sends it to the end user. The contact will only be available for the end user after further acception.

**For US2**

		- When an invitation is sent, the receiver will see the it in a collapsible menu items that only shows the invitations sent by other users. The user could choose to accept the invitation (a new contact is added), deny it (the invitation is dismissed and not added to the contact list), block invitations from the other user or unblock invitations from the other user.
	

# 6. Integration/Demonstration

--

# 7. Final Remarks 

Some Questions/Issues identified during the work in this feature increment

# 8. Work Log
