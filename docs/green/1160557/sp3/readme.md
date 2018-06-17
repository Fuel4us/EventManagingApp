**Hilário Coelho** (1160557) - Sprint 3 - Core 01.3
===============================

# 1. Requirements
*Core01.3 - Full Extension Mechanism - Description:*
"It should be possible to open several workbooks at the same time. It should be possible to make references between workbooks in the formulas."

*Specification of the User Stories:* 

```
US01
	As an user,
	I want to add spreadsheets, by clicking in the button settings and Add Spreadsheet.
```

```
US02
	As an user,
	I want to edit the current Workbook, like the name, description and delete it.
```

# 2. Analysis

## 2.1 Analysis Diagrams

**Use Cases**

![Use Cases](UserStories.jpg)

**Domain Model**

![Domain Model](domainModel.jpg)

# 3. Design

##3.1 SSD For Use Cases

**For UC1**

![UC1 Design](SSD_UC1.jpg)

**For UC2**

![UC2 Design](SSD_UC2.jpg)

##3.2 Classes

**WorkBook** and its classes:
```
	- WorkbookPresenter;
	- WorkbookView;
	- WorkbookView.ui.xml.
```


**SpreadSheet** and its classes:
```
	- SpreadSheetImpl;
	- SpreadSheetExtension;
```


# 4. Implementation

*If required you should present in this section more details about the implementation. For instance, configuration files, grammar files, etc. You may also explain the organization of you code. You may reference important commits.*

**For US1**

		- It should have been implemented the creation of a list of spreadsheet and the method addSpreadSheet().
		- It was implemented the button, add SpreadSheet, after the button Settings of the WorkBook was created.

**For US2**

		- After the creation of the button Settings of the WorkBook, it was created another button to a modal called Edit WorkBook.
		- The current Name and the Description of the WorkBook where optained by the methods getName() ad getDescription() in the class WorkBookView.
        -It was created a method setProperties to edit the name and description.






















