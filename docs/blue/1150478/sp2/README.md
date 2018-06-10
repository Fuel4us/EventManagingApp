**João Pereira** (1150478) - Sprint 2 - Core02.2
===============================

# 1. General Notes

Questions made to the Product Owner (PRP):

```
	Q: What's a side bar?
	A: A side bar is an bar on the left side of the screen, wich has menu options inside (showed the example on the netbeans).
```

```
	Q: Do we need to implement what's inside the menu option, or popup option?
	A: No, the extensions just have to handle its creation.
```

# 2. Requirements

*Core02.2 - Full Extension Mechanism - Description:*
"The extensions should now contribute also with popup menus in cells, menu options in the navigator and side bars."

*Specification of the user stories:* 

```
US01
	As an user,
	I want to add an extension of a menu option, by choosing the side bar to put it, the name and the icon of the option.
```

```
US02
	As an user,
	I want to add an extension of a popup option on the menu of the spreadsheet, by choosing the name and icon.
```

```
US03
	As an user,
	I want to add an extension of a side bar, where I can create new side bars by inserting its names, and choose wich one is opened.
```
                                                                                    
# 3. Analysis

## 3.1 Analysis Plan
**Extension** - It's an option that allows the user to create new functional 


## 3.2 Analysis Diagrams

The main idea for the "workflow" of this feature increment.

**Use Cases**
![Use Cases](us.png)

**Domain Model**

**System Sequence Diagrams**

**For US1**


**For US2**


**For US3**


# 4. Design

## 4.1. Tests

### 4.1.1 Testing the use case:

		- Log in;
		- Go to the extensions section;
		- Go to the 'Add Side Bar' menu;
		- Create 2 side bars, with different names;
		- Switch the activated side bar to one recently created;
		- Go to the 'Add Menu' option, and insert a name and an icon to the new menu options;
		- Add menu options on each of the side bars (recently created ones, and the originial one);
		- Go to the 'Add Popup Menu' and choose an name and icon for the new popup option.
		- Go to the workbook and right click the spreadsheet to see the result.
		

## 4.2. Requirements Realization

*Sequence Diagrams*

**For US1**
![US1 Design](design1.png)

**For US2**
![US2 Design](design2.png)

**For US3**
![US3 Design](design3.png)

## 4.3. Classes

**Used classes**
* For this use case, it was needed to use the classes on the module *NSheets - A Web version of CleanSheets*, of the packages:

**Extensions** and its classes:
```
	- ExtensionsModule;
	- ExtensionsPresenter;
	- ExtensionsView;
	- ExtensionsView.ui.xml.
```
**Menu** and its classes:
```
	- MenuModule;
	- MenuPresenter;
	- MenuView;
	- MenuView.ui.xml.
```
**Workbook** and its classes:
```
	- WorkbookModule;
	- WorkbookPresenter;
	- WorkbookView;
	- WorkbookView.ui.xml.
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
```
	- Was implemented the collapsible menu to insert the new menu options, with a text box to insert the name of the new menu option, and a combo box so the user could choose the icon to the menu option.
	- It was also needed to discover wich side bar was activated, so the new menu option could be inserted on.
```
**For US2**
```
	- For this user storie, it was needed to implement the collapsible menu with a text box to insert the name of the new popup option on the spreadsheet, and also the icon.
	- It was also needed to insert the popup option on the menu of the spreadsheet, that can be activated by pressing the right button of the mouse on it.
```	
**For US3** 
```
	- For the user storie 3, it was needed to implement also the collapsible menu with a field to insert the name of the new side bar, and also a combo box that shows all the side bars existing on the project, so the user could switch the activated side bar.
	- It was also needed to discover wich side bar was the activated one, so when the button to switch side bars is pressed, it switch with the side bar choosed by the user.
```
# 6. Integration/Demonstration

--

# 7. Final Remarks 

Some Questions/Issues identified during the work in this feature increment

# 8. Work Log

* [ [Implementation] Lang 05.1 (Forms Edit) - Changes on formulas so forms can be displayed by them. [Implementation] Core 02.2 (Full Extension Mechanism) - ExtensionsView.ui.xml edited, added the interface for pop up menus in cells, menu items and bars ] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/8ff7bfa0b8fd4209a7733f4a7892f42882e35d81)
* [ [Documentation] Core02.2 - changes on readMe.md, documentation added. [Implementation] Core02.2 - changes on layout, and add menu option improvement. ] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/cd4f05694b5b2500542431397aced22eab5c03c4)
* [ [Implementation] Core02.2 - add menu option functional. [Documentation] Core02.2 - changes on readMe.md, documentation added. ] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/be469eb981073937e7d9dc35d4e5910aa460a66e)
* [ [Implementation] Core02.2 - add popup menu functional. ] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/f02a3435352524ee7bc9fdfb861ae61645bfbb2a)
* [ [Implementation] Core02.2 - icons in menu option and popup option added. ] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/c3e1e08482a5567a58cd3dafbad1fa86e27a36e9)
* [ [Implementation] Core02.2 - Side bars added. ] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/7e8cdfaf39d0f1f6c045e154c21d137f8857f363)
* [ [Implementation] Core02.2 - Now users can select wich side bar they want. ] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/8380a2db4c812e83591f3dc236cf0afb7c12bd97)
* [ [Implementation] Core02.2 - Now users can create more than one side bar. ] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/2785e7354b7147642d6d4fd908bbb1c1c889e677)
* [ [Implementation] Core02.2 - Now users can choose wich side bar to open. ] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/45d3ee8771094d9c6f118e2eafb729f1435142d7)
* [ [Implementation] Core02.2 - Now users can't create menu options, popup options or side bars with the same name. ] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/0a7a0e2216a0a13a241a7398a1f784279fac42a7)
* [ [Documentation] Core02.2 - ReadMe.md updated. ] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/93b1f3d8160003e8c4d6e85f3005e6878f2b6707)