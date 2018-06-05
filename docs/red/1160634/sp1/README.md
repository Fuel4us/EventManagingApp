**Pedro Vieira** (1160634) - Sprint 1 - Core07.1)
===============================

# 1. General Notes

*In this section you should register important notes regarding your work during the sprint. For instance, if you spend significant time helping a colleague or if you work in more than one feature increment.*

[Had a problem on this regard](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=16911)

# 2. Requirements

Core07.1 - It should be possible to create, edit and remove text notes. A user can have one or more notes. There should be a window to list the textual notes of a user. A text note should be entered as multiline text in which the first line is interpreted as the title of the text note. The time stamp of the creation of the note should be also associated with the text note. The application should maintain the history of modifications for each text note. When a text note is selected, the application should display it's history. For each version, the application should display the time stamp and the first line (i.e., the title).

US1 - As a User of the Application I want to be able to create, edit and remove text notes and can be possible to have one or more notes.

US2 - As a User of the Application I want to be able to see in a window a list of the textual notes.

US3 - As a User of the Application I want to enter a text note that must be a multiline text in which the first line is interpreted as the title of the text note. The time stamp of the creation of the note should be also associated with the text note.

US4 - As a User of the Application I want to see the history of modifications for each text note. When a text note is selected, the application should display it's history. For each version, the application should display the time stamp and the first line (i.e., the title).


# 3. Analysis

*In this section you should describe the study/analysis/research you developed in order to design a solution.*

For this feature increment, since it is the first one to be developed in a new project I need to:  

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
		install(new NotesModule()); 
		...

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

The Notes page displays what seems to be Notes that should reside in the server.

In the method **onReveal** the Home presenter invokes a NoteService asynchronously. It uses the base communication mechanism of GWT called [GWT RPC](http://www.gwtproject.org/doc/latest/tutorial/RPC.html).

Basically, it requires the definition of an interface for the service. In this case:

	@RemoteServiceRelativePath("notesService")
	public interface NotesService extends RemoteService {
		ArrayList<NoteDTO> getNotes();
	}
	
Note: The @RemoteServiceRelativePath annotation associates the service with a default path relative to the module base URL.

When an RPC is invoked since it is always executed asynchronously we have to prove a callback: 

	// Make the call to the stock price service.
	NotesSvc.getNotes(callback);
	
The callback is simple a class that provides two methods, one for a successful result and the other for a failure:

	// Set up the callback object.
	AsyncCallback<ArrayList<NoteDTO>> callback = new AsyncCallback<ArrayList<NoteDTO>>() {
		public void onFailure(Throwable caught) {
			// TODO: Do something with errors.
		}
		public void onSuccess(ArrayList<WorkbooknDTO> result) {
			refreshView(result);
		}
	}; 

Since the interface is code that must be accessed by both server and client code it should reside in the **shared** project.

The interface must be implemented in the **server**. The implementation can be very simple, like the one presented in the project. In this case the server simply returns always the same objects:

	@Override
	public ArrayList<NoteDTO> getNotes() {
	    ArrayList<NoteDTO> Notes = new ArrayList<NoteDTO>();
	    NoteDTO note=new NoteDTO("Note1", "Esta Nota contem uma lista...");
	    Notes.add(note);
		NoteDTO note2=new NoteDTO("Note notas", "Esta Nota contem notas de disciplinas...");
	    Notes.add(note2); 
		return Notes;
	}

Since the service is a servlet it must be declared in the **web.xml** file of the project (see file nsheets/src/main/webapp/WEB-INF/web.xml).

	<!-- Servlets for the notes -->
	<servlet>
		<servlet-name>notesServiceServlet</servlet-name>
		<servlet-class>pt.isep.nsheets.server.services.NotesServiceImpl</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>notesServiceServlet</servlet-name>
		<!-- The first "part" of the url is the name of the GWT module as in "rename-to" in .gwt.xml -->
		<url-pattern>/nsheets/NotesService</url-pattern>
	</servlet-mapping> 
	

## 3.4 Analysis Diagrams

The main idea for the "workflow" of this feature increment.

**Use Cases**

![Use Cases](us.png)

- **Use Cases**. Since these use cases have a one-to-one correspondence with the User Stories we do not add here more detailed use case descriptions. We find that these use cases are very simple and may eventually add more specification at a later stage if necessary.

**Domain Model (for this feature increment)**

![Domain Model](dm.png)

- **Domain Model**. Since we found no specific requirements for the structure of Note we follow the Structure of the existing DTO (NoteDTO).

**System Sequence Diagrams**

**For US1**

![Analysis SD](analysis1.png)

**For US2**

![Analysis SD](analysis2.png)

**For US3**

![Analysis SD](analysis3.png)

**For US4**

![Analysis SD](analysis4.png)

# 4. Design

*In this section you should present the design solution for the requirements of this sprint.*



## 4.1. Tests

*In this section you should describe the design of the tests that, as much as possibe, cover the requirements of the sprint.*

Regarding tests we try to follow an approach inspired by test driven development. However it is not realistic to apply it for all the application (for instance for the UI part). Therefore we focus on the domain classes and also on the services provided by the server.

**Domain classes**

For the Domain classes we will have a class that represents the entity **Note**. This entity will have attributes that, for the moment, will be based on the class **NoteDTO**:

	- titleNote (string)
	- textNote (string)
    - dateNote (Date) 

**Test:** We should ensure that a Note can be created when all the attributes are set.  

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		System.out.println("ensureNullIsNotAllowed");
		Note instance = new Note(null, null);
	}

**Services/Controllers**

For the services the application already has a service specified in the interface **NotesService**:

	@RemoteServiceRelativePath("notesService")
	public interface NotesService extends RemoteService {
		ArrayList<NoteDTO> getNotes();
	}
	

For US2 we need a method that can be used to create a new Note given a NoteDTO.

The proposal is:

	@RemoteServiceRelativePath("notesService")
	public interface NotesService extends RemoteService {
		ArrayList<NoteDTO> getNotes();
		NoteDTO addNote(NotenDTO noteDto) throws DataException;
	}

Tests:  
- The tests on the controllers require the presence of a database.
- We will use the database in memory (H2).
- We will have a *controller* from adding new Notess. This controller will be invoked by the GWT RPC service.
- We will have a *controller* from listing Notes. This controller will be invoked by the GWT RPC service.

Controller **AddNoteController**

**Test:** Verify the normal creation of an Note.  

	@Test
	public void testNormalBehaviour() throws Exception {
		System.out.println("testNormalBehaviour");
		final String titleNote = "Title of Note1";
		final String textNote = "Text for Note1";
		final Note expected = new Note(titleNote, textNote);
		AddNoteController ctrl = new AddNoteController();
		Note result = ctrl.addNote(expected.toDTO());
		assertTrue("the added Note does not have the same data as input", expected.sameAs(result));
	}

Controller **ListNoteController**

Note: We will be using the annotation @FixMethodOrder(MethodSorters.NAME_ASCENDING) to ensure the test methods are executed in order. This is useful since the memory database will have state changing between tests.
 
**Test:** At the beginning of the tests the memory database should be empty, so listNoteDiscriptions should return an empty set.

	   @Test 
	   public void testAensureGetNotesEmpty() {
		   System.out.println("testAensureGetNotesEmpty");
		   ListNoteController ctrl=new ListNoteController();
		   Iterable<Note> notes=ctrl.listNotes();
		   assertTrue("the list of Notes is not empty", !notes.iterator().hasNext());
	   } 
 
**Test:** If a Note is created it should be present in a following invocation of getNotes().

		@Test
		public void testBtestDatabaseInsertion() throws Exception {
			System.out.println("testBtestDatabaseInsertion");
			final String titleNote = "Title of Note1";
			final String textNote = "Text for Note1";
			final Note expected = new Note(titleNote, textNote);
			AddNoteController ctrlAdd = new AddNoteController();
			Note result = ctrlAdd.addNote(expected.toDTO());
			ListNoteController ctrlList=new ListNoteController();
			Iterable<Note> notes=ctrlList.listNotes();
			assertTrue("the added Note is not in the database", notes.iterator().hasNext());
		}

**Test Coverage**  
- The actual coverage for domain classes: 61%
- The actual coverage for application(controller) classes: 100%


## 4.2. Requirements Realization

*In this section you should present the design realization of the requirements.*

Following the guidelines for JPA from EAPLI we envision a scenario like the following for realizing the use cases for this feature increment.

**For US1**

![SD US1](design1.png)

**For US2**

![SD US2](design2.png)

**For US3**

![SD US3](design3.png)

**For US4**

![SD US4](design4.png)

Notes:
- For US1, it is intended that a user can have one or moore Notes
- For US3, the modal has a MaterialTextBox for the Title of the Note and a MaterialTextArea for the Text of the Note, for the porpuse of clarity in the UI.
- The diagrams only depicts the less technical details of the scenario;  
- For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in this diagram.   
- **NoteServices** realizes the GWT RPC mechanism;
- **AddNoteController** is one *use case controller*;   
- **ListNoteController** is one *use case controller*;
- **AddNoteServices** is to add a Note to the noteRepository;
- **ListNoteServices** is to group together all the services related to Note.


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

**For US1**

The UI for this US was implemented according the Home and About implementations.

	**UI: Button for adding a new Note**

	For this concern we decided to use a Material Widget called Material FAB (Floating Action Button). This is a kind of button that usually appears at the left bottom part of the screen and contains actions available for the elements of the page.  

	We updated the NotesView.ui.xml accordingly and declare two elements with the tags *ui:field="openModalBtn"* and *ui:field="saveBtn"*. In the corresponding class View (i.e., NotesView) we bind that button to the corresponding widget class: 	

		@UiField
		MaterialButton openModalBtn, saveBtn;

	We must now add the code that invokes the server to add a new Note when the user clicks in the button. This is an event. To implement this behavior we could use GWT Events such as the SetPageTitleEvent already used in the application. These are special type of events that GWT manages and are available to all pages in the application. 

	We chose to provide our click event globally but to simple use the click event handler of the button and connect it to a method in the NotesPresenter.

	Since Presenters should only depend on a View interface we added a new method to the NotesPresenter.MyView:

		interface MyView extends View {
			void addClickHandlerOpenModal(ClickHandler ch);
			void buttonClickHandlerSaveNote(ClickHandler ch);
			...
		}

	Then, we implemented both *addClickHandler* in the NotesView class and call this method in the constructor of the NotesPresenter. In the constructor our handler class the server method that adds a new Note.

	**UI: Creating a Card for the Note**

	The method createCard(NoteDTO note) on NotesView shows how a card it's implemented, with a title, a text (both adding to a MaterialCardContent) and 3 buttons, check, edit and remove (with the help of a MaterialCardAction).

	**UI: Buttons for editing a new Note**

	This is done with the edit and check buttons and it's similar to add button.

	In NotesView, the checkBtn it's created invivible for the user and when the user clicks the edit button, the check button shows, so that the user can edit the Note.

	**UI: Button for removing a new Note**

	This is done with the remove button and it's similar to add button.

	In NotesView, the removeBtn have a addClickHandler (similar to all buttons) that when clicked the card of that Note stays invisible.

**For US2**

This UC is done with the help of setContents(ArrayList<NoteDTO> contents) of NotesView. First, it's important to metion that this method it's called by the refreshView() of NotesPresenter, that it's called by onReveal() and this.view.buttonClickHandlerSaveNote(event -> ...), both in NotesPresenter. This is important to know, because when we don't have note's it shows a ma:emptystate.MaterialEmptyState, basically a beatiful optional logo that informs that you don't have Notes yet. This changes when:

if (!contents.isEmpty()) 
    emptyState.setVisible(false);

in setContents(...), that does disappear that logo when you add a new Note. The grid it's done with the help of a card that have all the cards done in the NotesView.ui.xml that have a m:MaterialCollection, which is added a MaterialRow and the card (of each Note) is added to a MaterialColumn, that bassically allows to have a 3 horizontal Notes.

**For US3**

This US, it's done with the help of a modal created in the xml and two methods of the interface MyView of NotesPresenter, which have openModalToAddNote() and closeModalToAddNote(), whose open() and closes() the modal corresponding, and, titleNote() and textNote(), they return the getValue() of MaterialTextBox and MaterialTextArea corresponding.

**For US4**

First it's importatnt to meation how the dateNote it's implemented by the NoteDTO (in Shared) and Note (in Server). They instantiate the date with new Date(), in the default constructor and in the setters of the titleNote and textNote, and obviously the dateNote doens't have a setter, for that reason. Second, the MaterialTextBox cardHistory, cardHistory.setText(note.getDateNote().toString()), that way the Note displays the Date of when was created.

**Code Organization**  

We followed the recommended organization for packages:  
- Code should be added (when possible) inside packages that identify the group, sprint, functional area and author;
- For instance, I used **lapr4.red.s1.core.n1160634**

The code for this sprint:  
Project **server**    
- pt.isep.nsheets.server.**lapr4.red.s1.core.n1160634**.notes.application: contains the controllers  
- pt.isep.nsheets.server.**lapr4.red.s1.core.n1160634**.notes.domain: contains the domain classes
- pt.isep.nsheets.server.**lapr4.red.s1.core.n1160634**.notes.persistence: contains the persistence/JPA classes  
- pt.isep.nsheets.server.**lapr4.white.s1.core.n4567890**.workbooks.persistence: contains the persistence/JPA classes 
- Created the class: **pt.isep.nsheets.server.NoteServiceImpl**

Project **shared**  
- Updated the classes: **pt.isep.nsheets.shared.services.NoteService** and **pt.isep.nsheets.shared.services.NoteServiceAsync**  

Project **NShests** 
- Updated the classes: **pt.isep.nsheets.client.aaplication.notes.NotesView** and **pt.isep.nsheets.client.aaplication.notes.NotesPresenter**  
- Updated the file: **pt.isep.nsheets.client.aaplication.Notes.NotesView.ui.xml**  
- Created the package (and the classes of that package): **pt.isep.nsheets.client.aaplication.notes** 


# 6. Integration/Demonstration

*In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)*

Nothing to report, all that is important to mention, has already been mentioned

# 7. Final Remarks 

*In this section present your views regarding alternatives, extra work and future work on the issue.*

Some Questions/Issues identified during the work in this feature increment:

The only "extra work" I have done was with the ma:emptystate.MaterialEmptyState of xml, that I already meation in Implementation - for US2.


# 8. Work Log

*Insert here a log of you daily work. This is in essence the log of your daily work. It should reference your commits as much as possible.*

Commits:

[Started new example documentation for Pedro Vieira Core07.1](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/3cb1ed5e49861986f0eff43531d37a13df259959)

[Core07.1 Added all US Analysis SD, us and dm](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/3b1c2f95dcea4f67814f5fc7fd0efcf663f9b979)

[Core07.1 Beggining of UI](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/854ec17d61203923b9682e875fd3292d6dfe1d21)

[Core07.1 Beggining of Server and Database of US1, 2 and 3](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/2247e70ba43932a5e174ae8b58be4958221048eb)

[Core07.1 Fix package problem, added class needed to both persistance.xml and beggining of javaDoc](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/7476a0ed3036b836cb709bd3d7f9fb0f0ad02904)

[Core07.1 Database, beggining of units testing of database / persistance and beggining of javaDoc](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/041c34f94ab5f2297e918f76715ca0d2383cc1ab)

[Core07.1 dm](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/0f7d0fbbd462fbef5ce077746d40e5ceebe264f4)

[Core07.1 UI](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/fe2f4de0f98bc5cc2bf30cca72fa1a21a5ebeaf7)

[Core07.1 server / database](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/09a93f41016e31faf57e06ad018034ac789a7397)

[Core07.1 Doc: dm and design 1 to 4](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/a22806ab324df69894a8b18a5fe2f2f1a2aca930)

[Core07.1 UI, Server and Database fixes](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/64568258634d136f475582771ec79342dfb85da2)

[Core07.1 US1 and 2 done](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/9845442527aa2ed8c376e623e2b455c3c03ac234)

[Core07.1 US1, 2 and 3 improvments](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/d8de2b7b98087c964c6869a706f2c45443a8e276)

[Core07.1 All US done with small things missing]()

