**Tiago Correia** (1140403) - Sprint 2 - Core07.2
===============================

# 1. General Notes

*In this section you should register important notes regarding your work during the sprint. For instance, if you spend significant time helping a colleague or if you work in more than one feature increment.*

# 2. Requirements

Core07.2 - Lists

It should be possible to create, edit and remove list notes. A list note is 
similar to a textual note but each line is displayed as a check box (that can 
be checked or unchecked). The first line is also interpreted as the title of 
the list note. It should be possible to generate a new version of a text note 
or list based on an old version of it. When this happens, the application should 
"open" the new version for edit with the same contents of the old version. This 
is the only "trace" that may eventually link to the old version.

In a more brief text:

The use case is pratically the same as Core07.1 . The only difference is that
The "form" of the ListNotes should be a check box with the ability to check or 
uncheck every line of the ListNotes.

In addiction, it should be possible to edit old Notes and to convert a Note into
a ListNotes.

US1 - As a User of the Application I want to be able to edit a already existing note

US2 - As a User of the Application I want to be able to convert a already existing
note into a ListNotes

US3 - As a User I want to be able to edit the ListNotes

US4 - As a User I want to be able to delete ListNotes

# 3. Analysis

*In this section you should describe the study/analysis/research you developed in order to design a solution.*

For this feature increment I need to:  

- Understand how the application works and also understand the key aspects of GWT, since it is the main technology behind the application  

- Understand how the Notes Page is implemented (for instance, how the UI gets the Note that are displayed)  

- Understand how to integrate a relational database into the project (Will be assuming JPA since it is studied in EAPLI)  

## 3.1 GWT and Project Structure

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
   
## 3.2 Application Startup and GWTP

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

## 3.3 Server and RPC

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
	



# 4. Design

*In this section you should present the design solution for the requirements of this sprint.*



## 4.1. Tests

*In this section you should describe the design of the tests that, as much as possibe, cover the requirements of the sprint.*

Regarding tests we try to follow an approach inspired by test driven development. However it is not realistic to apply it for all the application (for instance for the UI part). Therefore we focus on the domain classes and also on the services provided by the server.

**Domain classes**

For the Domain classes we will have a class that represents the entity **ListNotes**. This entity will have attributes that, for the moment, will be based on the class **ListNotesDTO**:

	- titleNote (string)
	- textNote (string)
        - dateNote (Date) 

**Test:** We should ensure that a ListNotes can be created when all the attributes are set.  

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		System.out.println("ensureNullIsNotAllowed");
		ListNotes instance = new ListNotes(null, null);
	}

**Services/Controllers**

For the services the application already has a service specified in the interface **ListNotesService**:

	@RemoteServiceRelativePath("listNotesService")
	public interface ListNotesService extends RemoteService {
		ArrayList<ListNotesDTO> getListNotes();
	}
	

For US2 we need a method that can be used to create a new ListNotes given a NoteDTO.

The proposal is:

	@RemoteServiceRelativePath("listNotesService")
	public interface ListNotesService extends RemoteService {
		ArrayList<ListNotesDTO> getListNotes();
		ListNotesDTO addListNotes(ListNotesDTO listNotesDto) throws DataException;
	}

Tests:  
- The tests on the controllers require the presence of a database.
- We will use the database in memory (H2).
- We will have a *controller* from adding new ListNotes. This controller will be invoked by the GWT RPC service.
- We will have a *controller* from listing ListNotes. This controller will be invoked by the GWT RPC service.

Controller **AddListNotesController**

**Test:** Verify the normal creation of an ListNotes.  

	@Test
	public void testNormalBehaviour() throws Exception {
		System.out.println("testNormalBehaviour");
		final String titleNote = "Title of ListNote";
		final String textNote = "Text for ListNote";
		final ListNotes expected = new ListNotes(titleNote, textNote);
		AddListNotesController ctrl = new AddListNotesController();
		ListNotes result = ctrl.addListNotes(expected.toDTO());
		assertTrue("the added ListNotes does not have the same data as input", expected.sameAs(result));
	}




## 4.2. Requirements Realization

*In this section you should present the design realization of the requirements.*

Following the guidelines for JPA from EAPLI we envision a scenario like the following for realizing the use cases for this feature increment.

**SD**
![SD](SD ListNotes.png)

Notes:
- It is intended that a user can have one or more ListNotes
- For  the modal has a MaterialTextBox for the Title of the ListNotes and a MaterialTextArea for the Text of the ListNotes, for the porpuse of clarity in the UI.
- For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in this diagram.   
- **ListNotesServices** realizes the GWT RPC mechanism;
- **AddListNotesController** is one *use case controller*;   
- **ListListNotesController** is one *use case controller*;
- **AddListNotesServices** is to add a ListNotes to the noteRepository;
- **ListListNotesServices** is to group together all the services related to ListNotes.


## 4.3. Classes

*Present and describe the major classes of you solution.*

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

*If required you should present in this section more details about the implementation. For instance, configuration files, grammar files, etc. You may also explain the organization of you code. You may reference important commits.*


The UI for this US was implemented according the Home and About implementations.

	**UI: Button for adding a new Note**

	For this concern we decided to use a Material Widget called Material FAB (Floating Action Button). This is a kind of button that usually appears at the left bottom part of the screen and contains actions available for the elements of the page.  

	We updated the NotesView.ui.xml accordingly and declare two elements with the tags *ui:field="openModalBtn"* and *ui:field="saveBtn"*. In the corresponding class View (i.e., ListNotesView) we bind that button to the corresponding widget class: 	

		@UiField
		MaterialButton openModalBtn, saveBtn;

	We must now add the code that invokes the server to add a new Note when the user clicks in the button. This is an event. To implement this behavior we could use GWT Events such as the SetPageTitleEvent already used in the application. These are special type of events that GWT manages and are available to all pages in the application. 

	We chose to provide our click event globally but to simple use the click event handler of the button and connect it to a method in the ListNotesPresenter.

	Since Presenters should only depend on a View interface we added a new method to the ListNotesPresenter.MyView:

		interface MyView extends View {
			void addClickHandlerOpenModal(ClickHandler ch);
			void buttonClickHandlerSaveNote(ClickHandler ch);
			...
		}

	Then, we implemented both *addClickHandler* in the ListNotesView class and call this method in the constructor of the ListNotesPresenter. In the constructor our handler class the server method that adds a new ListNotes.

	**UI: Creating a Card for the ListNotes**

	The method createCard(ListNotesDTO notes) on NotesView shows how a card it's implemented, with a title, a text (both adding to a MaterialCardContent) and 4 buttons, check, edit, remove and covert to ListNotes (with the help of a MaterialCardAction).

	**UI: Buttons for editing a new ListNotes**

	This is done with the edit and check buttons and it's similar to add button.

	In ListNotesView, the checkBtn it's created invivible for the user and when the user clicks the edit button, the check button shows, so that the user can edit the ListNotes.

	**UI: Button for removing a new ListNotes**

	This is done with the remove button and it's similar to add button.

	In ListNotesView, the removeBtn have a addClickHandler (similar to all buttons) that when clicked the card of that ListNotes stays invisible.



