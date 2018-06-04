**José Monteiro** (1160630) - Sprint 1 - Core04.1
===============================

# 1. General Notes
In Application Engineering (EAPLI) were shown several standards/patterns for project development.
The of LAPR4 is to take advantage of the knowledge acquired in EAPLI and apply it, however for this iteration, as we are limited in a matter of time and it is the first time that we came in contact with the project, I found it well to ignore the TDD standard (test-driven development) for at least this iteration. This way I tried as hard as I could to implement my Use Case based on the domain model, and as I was implementing it, I improved my project structure skills.



# 2. Requirements

**Core04.1 - Basic Chart Wizard**

The application should have a new menu option to launch a wizard to help the user create a bar chart. The wizard should have 2 steps. In the first step, the user should input the name of the chart and the range of cells that contains the data for the plot of the chart. The user should also select if the data is in the rows or columns of the range and if the first row or the first column are to be considered labels. In the second step the wizard should display a preview of the chart. The wizard should allow the user to move between steps 1 and 2. If the wizard is confirmed the cell in the left upper corner of the range should have a mark (e.g., icon) that indicates that the cell has a chart associated with it. A popup menu option in the cell should provide access to the chart.

We can specify this requirements in 2 User Stories:

* US1 - As a user I want a wizard to help me to insert the data to create the bar chart;

* US2 - As a user I want to save the created chart;

# 3. Analysis

As this iteration is our first contact with the project, we have to deepen our knowledge about the project itself, and the libraries and toolkits that it uses.
This way 3 research points were established:
* Study of the project organization,this is: classes, packages and layers...;
* Read the main GWT toolkit documentation;
* Explore more about Material Design guidelines;
* Deepen the knowledge about this "new" UI;
* Find out if the project's database is close to the one learned in the EAPLI curricular unit, if not, investigate it;


## 3.1 Project Structure and new "UI"

Our project is composed by 5 modules:
    * server;
    * shared;
    * nsheets;
    * util;
    * framework;

In this project we can see a new User Interface/ Front-end different from what We used to. Each view/page is composed by at least 4 files:
    1. A module: that binds the UI elements;
    2. A presenter: in the documentation a class that extends a Presenters, buils a block of the model-view-presenter architecture.;
    3. A view: extends a ViewImpl, this is completly related with the ui.xml file, basically we can add elements/behaviours to the ui.xml file;
    4. A ui.xml file: looks like an html file, where we can insert the GWT components;

   
## 3.2 GWT Toolkit
Google Web Toolkit, it's a open source toolkit which allows users to create ajax applications through java. 
**How it works?** GWT uses a technique known as "transpilation" to translate Java code to Javascript.
**Prequesites:** For GWT it will be good if we understand a little of: HTML, CSS and AJAX. But the "main" language it's JAVA sure.

## 3.3 Material Design
Its a "design language" developed by Google. It was announced in 2014. This new interface is based in shadow elements, with smooth animations. 
* We can find more information in [Google Material Design website](https://material.io/design/);
* For this specific GWT project we can find all the Material Design components [here](https://gwtmaterialdesign.github.io/gwt-material-demo/);



## 3.4 Persistence
For this project it seems like we are using the same API that we used in EAPLI for data persistence - JPA - Java Persistence API and we also have a configuration to save the data in memory.
Based on JPA, in this project, we usually find:
* **Entities:** used to inform that the class it's an Entity, since that JPA will establish a connection between the entity and a table in the DB (with the same name) where the data of the object can be persisted;




## 3.45 Analysis Diagrams



# 4. Design


## 4.1. Tests


## 4.2. Requirements Realization



## 4.3. Classes


## 4.4. Design Patterns and Best Practices



# 5. Implementation



# 6. Integration/Demonstration



# 7. Final Remarks 



# 8. Work Log

