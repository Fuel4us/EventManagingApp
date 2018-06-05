**João Pereira** (1150478) - Sprint 1 - Lang05.1
===============================

# 1. General Notes

---

# 2. Requirements

*Lang05.1 - Forms Editor - Description:*
"The application should have a new option to launch a window for editing a form. 
A Form is a window that is designed by the end user and is used for interacting with the user (input and output). 
The new window should support the creation and testing of a Form. Forms should be very simple. 
A Form should be composed of rows, each row can be empty or have one or two visual widgets. 
The supported visual widgets are: button (to invoke actions); edit box (to enter data) and static text box (to display data). 
It should be possible to set the core properties of these widgets (like the text to display in a static text box, for instance). 
In the edit form window it should be possible to: add a new row; remove an existing row; edit an existing row; "play" the form and close the edit form window. 
The "play" button is for testing the appearance of a form during its design (see example in the next Figure). 
At the moment it is only required to support a single Form for each workbook. 
Macros and formulas should have a new function that can be used to display the form of the current workbook. 
Forms should have an icon or button to close the form. When the form is closed the function (in macros or formulas) who call it returns."

*Specification of the user stories:* 

```
US01
	As an user,
	I want to see the form and the edit form windows.
```

```
US02
	As an user,
	I want to add an row to the form, by choosing the widgets that will appear on the form, edit the properties of them, and play the form to see the final design.
```

```
US03
	As an user,
	I want to remove and edit an existing row on the form, and play the form to see the final design.
```

```
US04
	As an user,
	I want to edit an existing row on the form, and play the form to see the final design.
```

# 3. Analysis

## 3.1 Analysis Plan
**Form** - A form is composed by rows;
**Row** - Each row can have zero, one or two widgets;
**Widget** - The widgets can be: buttons, static text fields or text fields to insert data;
**EditForm** - A window with options that can edit a form;
**Options** - Add row, edit row, remove row.

## 3.2 GWT and Project Structure

**Modules**. From the pom.xml file we can see that the application is composed of 5 modules:  
- **server**. It is the "server part" of the web application.  
- **shared**. It contains code that is shared between the client (i.e., web application) and the server.   
- **nsheets**. It is the web application (i.e., Client).  
- **util**. This is the same module as the one of EAPLI.  
- **framework**. This is the same module as the one of EAPLI.   
  
From [GWT Overview](http://www.gwtproject.org/overview.html): *"The GWT SDK contains the Java API libraries, compiler, and development server. It lets you write client-side applications in Java and deploy them as JavaScript."*

Therefore:
  - The project is totally developed in Java, event for the UI parts.
  - GWT uses a technique know as "transpilation" to translate Java code to Javascript. This is totally transparent to the user
  - A GWT application is comprised of "GWT modules" (see [GWT Tutorial](http://www.gwtproject.org/doc/latest/tutorial/create.html)). These GWT modules are described in .gwt.xml files.
   The nsheets project contains a .gwt.xml file named nsheets.gwt.xml (nsheets/src/main/resources/pt/isep/nsheets/nsheets.gwt.xml). One of the important contents of the file is the specification of the entry point of the application. However, since the application uses the [GWTP framework](http://dev.arcbees.com/gwtp/) the entry point is automatically provided (no need to specify it in the .gwt.xml file). In this case what is specified is the GIN client module pt.isep.nsheets.client.gin.ClientModule:
   
	    <extend-configuration-property name="gin.ginjector.modules"
                                   value="pt.isep.nsheets.client.gin.ClientModule"/>
                                   
   It is from this **ClientModule** that the application starts.
   Another important content of a .gwt.xml file is setting the paths for translatable code, .i.e., java code that should be translated to javascript. Usually the default source path is the client subpackage underneath where the .gwt.xml File is stored. In this case every code inside package pt.isep.nsheets.client and pt.isep.nsheets.shared will be translated to javascript. 
   
	<!-- Specify the paths for translatable code                    -->
    <source path='client'/>
    <source path='shared'/>
        
   The shared package is where shared code between server and client should reside. See [GWT - What to put in the shared folder?](https://stackoverflow.com/questions/5664601/gwt-what-to-put-in-the-shared-folder?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa) and also [using GWT RPC](http://www.gwtproject.org/doc/latest/tutorial/RPC.html).
   
   In this project the shared, server and client (i.e, nsheets) code are separated also in Maven modules (but they could all be in the same project/maven module). 
   
## 3.3 Application Startup and GWTP

As described before the entry point for the application is the class **pt.isep.nsheets.client.gin.ClientModule**.

GWTP follows the MVP (Model-View-Presenter) pattern. It uses [GIN dependency injection](http://dev.arcbees.com/gwtp/core/presenters/gin-bindings.html) to put together the parts of each MVP. How the GWTP structures the application and uses GIN to bind all the required elements is described in [GWTP Beginner's Tutorial](http://dev.arcbees.com/gwtp/tutorials/index.html).

We can see that **ClientModule** installs the base presenter of the application:

	    install(new ApplicationModule());
	        
The **ApplicationModule** module install all the other modules of the application:

	    install(new HomeModule());
		install(new MenuModule());
		install(new AboutModule());
		install(new WorkbookModule());   

Each module represents an MVP page in the application.

In this MVP pattern each presenter defines a specific interface that is use to communicate with the UI (i.e., the View). Therefore the presenter can be fully isolated from dependencies related to the UI. For instance, the View interface that is defined by the ApplicationPresenter only has one method:

	interface MyView extends View {
    		void setPageTitle(String title, String description, String link, String specification);
    } 

In this specific case the only type that is "shared" between Presenter and View is the String.

The View class is where all the UI code should be implemented. In GWT it is possible to create UI elements programmatically (see [GWT Build the UI](http://www.gwtproject.org/doc/latest/tutorial/buildui.html)). The UI can also be described in .ui.xml files using [UIBinder](http://www.gwtproject.org/doc/latest/DevGuideUiBinder.html). The NSheets project is using [GWT Material Design](https://github.com/GwtMaterialDesign/gwt-material) and therefore all the UI widgets are from that library. 

In the case of the Application module we can see that there is a ApplicationView.ui.xml. This file declares some widgets. The attribute ui:field can be used to specify an id that can be then used to bind that element to a class in the code. For instance, in ApplicationView.ui.xml:

	<m:MaterialPanel ui:field="panel">
		<m:MaterialLabel ui:field="title" text="NSheets" fontSize="2.3em"/>
		<m:MaterialLabel ui:field="description" text="A Sophisticated Web Spreadsheet Application." fontSize="1.1em"/>
	</m:MaterialPanel>
	
It is set the ui:field attribute for two existing labels. In the code (ApplicationView.java) one can bind to Widgets classes. For instance:

	@UiField
    MaterialLabel title, description;
    
Then we can use this instances to access the widgets link in:

	@Override
	public void setPageTitle(String title, String description, String link, String specification) {
        this.title.setText(title);
        this.description.setText(description);
        new MaterialAnimation().transition(Transition.BOUNCEINLEFT).animate(this.title);
        new MaterialAnimation().transition(Transition.BOUNCEINLEFT).animate(this.description);
    }    

## 3.4 Server and RPC

The Home page displays what seems to be Workbooks that should reside in the server.

In the method **onReveal** the Home presenter invokes a WorkbookService asynchronously. It uses the base communication mechanism of GWT called [GWT RPC](http://www.gwtproject.org/doc/latest/tutorial/RPC.html).

Basically, it requires the definition of an interface for the service. In this case:

	@RemoteServiceRelativePath("workbooksService")
	public interface WorkbooksService extends RemoteService {
		ArrayList<WorkbookDescriptionDTO> getWorkbooks();
	}
	
Note: The @RemoteServiceRelativePath annotation associates the service with a default path relative to the module base URL.

When an RPC is invoked since it is always executed asynchronously we have to prove a callback: 

	// Make the call to the stock price service.
	workbooksSvc.getWorkbooks(callback);
	
The callback is simple a class that provides two methods, one for a successful result and the other for a failure:

	// Set up the callback object.
	AsyncCallback<ArrayList<WorkbookDescriptionDTO>> callback = new AsyncCallback<ArrayList<WorkbookDescriptionDTO>>() {
		public void onFailure(Throwable caught) {
			// TODO: Do something with errors.
		}
		public void onSuccess(ArrayList<WorkbookDescriptionDTO> result) {
			refreshView(result);
		}
	}; 

Since the interface is code that must be accessed by both server and client code it should reside in the **shared** project.

The interface must be implemented in the **server**. The implementation can be very simple, like the one presented in the project. In this case the server simply returns always the same objects:

	@Override
	public ArrayList<WorkbookDescriptionDTO> getWorkbooks() {
	    ArrayList<WorkbookDescriptionDTO> workbooks = new ArrayList<WorkbookDescriptionDTO>();
	    WorkbookDescriptionDTO wb=new WorkbookDescriptionDTO("workbook1", "Este workbook contem uma lista...");
	    workbooks.add(wb);
		WorkbookDescriptionDTO wb2=new WorkbookDescriptionDTO("workbook notas", "Este workbook contem notas de disciplinas...");
	    workbooks.add(wb2);	    
		return workbooks;
	}

Since the service is a servlet it must be declared in the **web.xml** file of the project (see file nsheets/src/main/webapp/WEB-INF/web.xml).

	<!-- Servlets for the workbooks -->
	<servlet>
		<servlet-name>workbooksServiceServlet</servlet-name>
		<servlet-class>pt.isep.nsheets.server.services.WorkbooksServiceImpl</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>workbooksServiceServlet</servlet-name>
		<!-- The first "part" of the url is the name of the GWT module as in "rename-to" in .gwt.xml -->
		<url-pattern>/nsheets/workbooksService</url-pattern>
	</servlet-mapping> 
	

## 3.5 Analysis Diagrams

The main idea for the "workflow" of this feature increment.

**System Sequence Diagrams**

**For US1**
![Use Cases](us1.png)

**For US2**
![Use Cases](us2.png)

**For US3**
![Use Cases](us3.png)

**For US4**
![Use Cases](us4.png)

# 4. Design

## 4.1. Tests

### 4.1.1 Testing the use case:

		- Log in;
		- Go to the workbook section;
		- Click on the button "forms" or write the formula to display the forms;
		- Go to the edit form option;
		- In the edit form window, you can add new rows and choose wich widgets will appear on the form;
		- On the remove rows option, you can remove rows from the form by the index;
		- On the edit rows option, you can edit rows on the form, by the index.
		

## 4.2. Requirements Realization

*Sequence Diagram:*
![Use Cases](ds.png)

## 4.3. Classes

*Present and describe the major classes of you solution.*

## 4.4. Design Patterns and Best Practices

By memory we apply/use:
- Repository  
- DTO
- MVP

# 5. Implementation

*If required you should present in this section more details about the implementation. For instance, configuration files, grammar files, etc. You may also explain the organization of you code. You may reference important commits.*

**For US1**
	- It was needed to implement the xml code to create the buttons on the form field, that is invoked by a button or formula on the workbook area.
	- Also it was needed to implement the xml code to create the windows, the window of the form and the and the window of the form edit.

**For US2**
	- To do the use storie 2, we needed to create the combo box so that the user can choose witch widget/widgets would appear on the form.
	- It was also needed to create on the same field the label to write any data on the widget, and the buttons to add the row, and play the design of the form.
	
**For US3** 

	- Here it was needed to implement the label to get the index of the row to be removed.
	- It was also needed to implement the buttons to remove the row and play the design of the form.
	
**For US4** 

	- Here it was needed to implement the label to get the index of the row to be edited.
	- It was also needed to implement the buttons to edit the row and play the design of the form.


# 6. Integration/Demonstration

--

# 7. Final Remarks 

Some Questions/Issues identified during the work in this feature increment

# 8. Work Log

* [Documentation](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/73fa7376c16d864f906acb1d6c4330e11339b0af)
* [Lang 05.1 - Creation of form package and its classes (FormModule, FormPresenter, FormView, FormView.ui (XML)). Some modifications.] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/9a876d02eddc867c8f003fc0f9651d2d177cba06)
* [Lang 05.1 - Layout of Forms changed. Other changes.] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/4b359bb67c9a695d6d640bac266e1f8329eb8d01)
* [Lang 05.1 - Changes on the form edit.] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/27ad41501217c27674512fd028b54b91a7b2b214)
* [Lang 05.1 - Adding row and Removing row working. Layout Changed.] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/779bc7b834ad89b886b62f4b5892a9d22b68de55)
* [[Implementation] Lang 05.1 (Forms Edit) - Now users can choose wich widget will appear. Changes on the layout.] (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/1651cc727b6c82d09de8e3f80934ba846fb49099)