**Hilário Coelho** (1160557) - Sprint 1 - IPC01.1
===============================

# 1. General Notes

Gatekeeper não redireciona para outras páginas caso validação canReveal falhe.

Superuser pronto a ser implementado, no entanto não está a ser utilizado pois para já todos os utilizadores têm acesso a tudo.

# 2. Requirements

IPC01.1 - All the pages of the application should require an authenticated user (except the "About" page). The application should have a "Login" page (Hint: Gatekeepers in GWTP). Some hard-coded users should be defined to be initially used for authentication. There should also exist a super-user that is able to access everything.

# 3. Analysis

- Perceber como funciona o GWT e a aplicação no geral  

- Perceber para que serve e como funcionam os Gatekeepers  

- Perceber como implementar um Gatekeeper para permitir/impedir acesso a um Presenter   

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
   
## 3.2 Gatekeepers

Os gatekeepers são utilizados para que se possa impedir o acesso a utilizadores não autorizados a certas áreas da aplicação. Para se conceder acesso, o método *canReveal* da classe que será usada como Gatekeeper terá de retornar *true*.  

## 3.3 Implementação de Gatekeepers

Em primeiro lugar, para se poder utilizar gatekeepers, é necessário que exista um conceito de sessão na aplicação.  

A sessão só persiste na navegação entre páginas, ou seja, utilizadores diferentes, browsers diferentes, dispositivos diferentes ou até mesmo refresh à página faz com que a sessão seja diferente. Será na classe de sessão (*currentUser*) que será guardado o objeto *User* autenticado bem como um atributo booleano se o utilizador está ou não autenticado.  

É possível aceder à sessão nos diferentes presenters, bem como nos gatekeepers.  

O método *canReveal* do gatekeeper deve fazer a validação se o utilizador está autenticado e se tem permissões para aceder à pagina. Neste caso, apenas verifica se o utilizador está autenticado pois não existe, para já, o conceito de permissões diferentes para utilizadores diferentes, isto é, todos os utilizadores conseguem ver tudo.  
  
  
No ato de *login*, o servidor verifica na lista de utilizadores registados (para já estão hard-coded) se o e-mail e a password correspondem a algum utilizador. Caso isso aconteça, guarda na sessão o *User* e coloca o booleano de autenticação como verdadeiro.  
	

## 3.4 Analysis Diagrams

The main idea for the "workflow" of this feature increment.

**Use Cases**

![Use Cases](us.png)

- **Use Cases**. Since these use cases have a one-to-one correspondence with the User Stories we do not add here more detailed use case descriptions. We find that these use cases are very simple and may eventually add more specification at a later stage if necessary.

**Domain Model (for this feature increment)**

![Domain Model](dm.png)

- **Domain Model**. Since we found no specific requirements for the structure of Workbook Descriptions we follow the Structure of the existing DTO (WorkbookDescriptionDTO).

**System Sequence Diagrams**

**For US1**

![Analysis SD](analysis.png)

**For US2**

![Analysis SD](analysis2.png)

# 4. Design

*In this section you should present the design solution for the requirements of this sprint.*



## 4.1. Tests

*In this section you should describe the design of the tests that, as much as possibe, cover the requirements of the sprint.*

De modo a testar este caso de uso, para além dos testes unitários já implementados, devem ser realizados os seguintes testes:  
Aceder a qualquer página da aplicação -> Resultado esperado: Página em branco ou simplesmente não apresenta nada bloqueando a aplicação  
Aceder à pagina About ou Login -> Resultado esperado: As páginas devem ser corretamente apresentadas  
Efetuar Login  
Voltar a aceder a qualquer página da aplicação -> Resultado esperado: O conteúdo da página deve agora aparecer visível ao utilizador.  

## 4.2. Requirements Realization

*In this section you should present the design realization of the requirements.*

Following the guidelines for JPA from EAPLI we envision a scenario like the following for realizing the use cases for this feature increment.

**For US1**

![SD US1](design1.png)

Notes:  
- The diagram only depicts the less technical details of the scenario;  
- For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in this diagram.   
- **WorkbookServices** realizes the GWT RPC mechanism;  
- **ListWorkbookDescriptionController** is the *use case controller*;  
- **ListWorkbookDescriptionServices** is to group together all the services related to WorkbookDescription. 

**For US2**

![SD US2](design2.png)

## 4.3. Classes

*Present and describe the major classes of you solution.*

## 4.4. Design Patterns and Best Practices

*Present and explain how you applied design patterns and best practices.*

By memory we apply/use:  
- Singleton  
- Repository  
- DTO  
- MVP  

**TODO:** Exemplify the realization of these patterns using class diagrams and/or SD with roles marked as stereotypes. 

# 5. Implementation

*If required you should present in this section more details about the implementation. For instance, configuration files, grammar files, etc. You may also explain the organization of you code. You may reference important commits.*

**For US1**

The UI for this US was already implemented. We simply implemented the server as described previously.

**For US2**

**UI: Button for adding a new Workbook Description**

For this concern we decided to use a Material Widget called Material FAB (Floating Action Button). This is a kind of button that usually appears at the left bottom part of the screen and contains actions available for the elements of the page.  

We updated the HomeView.ui.xml accordingly and declare the element with a tag *ui:field="newWorkbookButton"*. In the corresponding class View (i.e., HomeView) we bind that button to the corresponding widget class: 	

	@UiField
	MaterialButton newWorkbookButton;

We must now add the code that invokes the server to add a new workbook description when the user clicks in the button. This is an event. To implement this behavior we could use GWT Events such as the SetPageTitleEvent already used in the application. These are special type of events that GWT manages and are available to all pages in the application. 

We chose to provide our click event globally but to simple use the click event handler of the button and connect it to a method in the HomePresenter.

Since Presenters should only depend on a View interface we added a new method to the HomePresenter.MyView:

	interface MyView extends View {
		void setContents(ArrayList<WorkbookDescriptionDTO> contents);
		void addClickHandler(ClickHandler ch);
	}

Then, we implemented the *addClickHandler* in the HomeView class and call this method in the constructor of the HomePresenter. In the constructor our handler class the server method that adds a new workbook description.   

**Code Organization**  

The code for this sprint:  
Project **server**    
- pt.isep.nsheets.server.**lapr4.green.s1.core.n1160557**.users.application: contains the controllers  
- pt.isep.nsheets.server.**lapr4.green.s1.core.n1160557**.users.domain: contains the domain classes  
- pt.isep.nsheets.server.**lapr4.green.s1.core.n1160557**.users.persistence: contains the persistence/JPA classes  
- Created class: **pt.isep.nsheets.server.UsersServiceImpl**  

Project **shared**  
- Added the class: **pt.isep.nsheets.shared.services.UserDTO**: This class is new and is used as a Data Transfer Object for the class User  
- Created interfaces for the UsersService  

Project **NShests** 
- Created the UI: **pt.isep.nsheets.client.application.login**  
- Created the Security Package to handle Gatekeeper: **pt.isep.nsheets.client.security**


# 6. Integration/Demonstration

# 7. Final Remarks 

Some Questions/Issues identified during the work in this feature increment:

1. O atributo superUser na classe User não está a ser utilizado para já.  
2. O utilizador não é automaticamente redirecionado para a página de login se não estiver autenticado e tentar aceder a uma página que não tem acesso.  

# 8. Work Log

Commits:

[Creation of UI](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/91e696e5dde5d8bebdc7f1a09e2e128666c8a573)

[Improvement of UI and Button click handler](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/88224024947d516849cc54e87aaf2af8ffdf2be5)  

[Creation of User domain class, DB](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/bffdff6feba45ba469e8ad168ab5e3b71d0e927c)

[Added some attributes to User class](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/8ef99dd74e39c98976789c8cc0210b3fd1b6f22d)

[Gatekeeper](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/f08976736f2b25a57822b77b1512239e802338c9)

[Controller Unit Tests](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/6ebc75653a2e56c790f3976701dc878f7e0440a8)







