**Rúben Ribeiro** (1160998) - Sprint 1 - IPC04.1
===============================

# 1. General Notes

A big part of the development of this feature was divided by me and the two colleagues exporting to PDF and XML because the UI was really similar and our code only diverged by the time we called the controllers.

# 2. Requirements

IPC05.1 - It should be possible to export the contents of an workbook, spreadsheet or part of a spreadsheet to a CSV file. As we want to optimize as much as possible the process the solution should not rely on any third party library. The application should have a window/page to configure the CSV format (e.g, field separator or string delimiter). The export should only include the value of the cells. The generated CSV should be downloaded to the user local file system.

# 3. Analysis

- Understand how the web design and the code "behind" it works.

- Understand how to use the GWT components to a certain function. (ActionHandlers, MaterialButtons, MaterialModals, etc)

- Understand how to get together both UI and methods to export.

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

## 3.2 GWTP Manipulation

  The components used were initiated in the HomeView, where each workbook is a MaterialCard with a button to open the "Options". The position of this components
  is manipulated in the HomeView.ui.xml file, where is defined the icons, text, grid, effects, etc.
  The ActionHandlers are implemented in the HomePresenter class, where each button is a function. So:

  1. **HomeModule**
  2. **HomePresenter**
  3. **HomeView**
  4. **HomeView.ui.xml**

## 3.3 FileWriter to export to CSV

  Used FileWriter library to export to CSV, appending the information of the workbook to it.


# 4. Design
## 4.1. Tests


## 4.2. Requirements Realization

![SD](SSD.jpg)


## 4.3. Classes

**Workbook**

**WorkbookDTO**

**ExportServiceImp**  

**ExportCSVController**

## 4.4. Design Patterns and Best Practices

By memory we apply/use:  
- Interaction View/Presenter
- Interaction Services/Controller
- DTO  

# 5. Implementation

To implement this UC, we created a UI for exporting the current workbook. Then it connects to the export controller through services.

**Code Organization**  

The code for this sprint:  
Project **Server**    
- Created: pt.isep.nsheets.server.**lapr4.green.s1.ipc.n1160998** contains the controllers

Project **NShests**
- Changed: **pt.isep.nsheets.client.application.export.**
- Changed: **pt.isep.nsheets.server.services.ExportServiceImp**

Project **Shared**
- Created: **pt.isep.nsheets.shared.services.ExportService** and **pt.isep.nsheets.shared.services.ExportServiceAsync**

# 6. Integration/Demonstration

# 7. Final Remarks

It was not possible for me to export only spreadsheets or parts of it, although it is already half-implemented on the service. To make it all work we must change the UI to fit the needs. Also, due to not being able to choose the current workbook, it displays an 404 error when trying to run.
