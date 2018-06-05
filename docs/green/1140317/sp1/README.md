--Carlos Figueiredo-- 1140317 - Sprint 1 - IPC04.1
===============================

# 1. General Notes

     The main goal of this application is to export a XML file.


# 2. Requirements #


IPC04.1: It should be possible to export the contents of an workbook, spreadsheet or part of a spreadsheet to a XML file. 
As we want to optimize as much as possible the process the solution should not rely on any third party library.
The application should have a window/page to configure the XML tags to use for each type of element. 
The export should only include the value of the cells. 
The generated XML should be downloaded to the user local file system.

    
# 3. Analysis

## 3.1 GWT and Project Structure ##



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
   

## 3.4 Analysis Diagrams



# 4. Design

## 4.1. Tests

There were no tests for this use case

## 4.2. Requirements Realization


## 4.3. Classes

ExportPresenter , ExportServiceImp

## 4.4. Design Patterns and Best Practices



By memory we apply/use:  

By memory we apply/use: - DTO


# 5. Implementation

To implement this UC was created an UI to export the current workbook.
After that I had to connect the export to xml with my controller so I could export the workbook to xml


**Code Organization**  

The code for this sprint:  
Project **Server**    
- pt.isep.nsheets.server.**lapr4.green.s1.ipc.n1140317** contains the controllers 

Project **NShests** 
- Changed: **pt.isep.nsheets.client.application.export.**

# 6. Integration/Demonstration

     

# 7. Final Remarks

     No final remarks.