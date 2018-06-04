**José Santo** (1160629) - Sprint 1 - Core02.1
===============================

# 1. General Notes

*In this section you should register important notes regarding your work during the sprint. For instance, if you spend significant time helping a colleague or if you work in more than one feature increment.*

# 2. Requirements

A functioning Extension framework must be developed, to support extensions that allow to change cell content/style
	
# 3. Analysis




## 3.1 GWT and Project Structure

At this point in the Project, due to GWT restrictions, and as extensions must influence the Client aswell as the Server, instantiation of extensions will be hardcoded, and they will all be defined before runtime.

## 3.2 Application Startup and GWTP

## 3.3 Server and RPC

## 3.4 Analysis Diagrams

# 4. Design

*In this section you should present the design solution for the requirements of this sprint.*

## 4.1. Tests

*In this section you should describe the design of the tests that, as much as possibe, cover the requirements of the sprint.*

## 4.2. Requirements Realization

*In this section you should present the design realization of the requirements.*

## 4.3. Classes

*Present and describe the major classes of you solution.*

## 4.4. Design Patterns and Best Practices

Applied Strategy pattern for each of the Extensions
Applied Singleton pattern for ExtensionManager
DTO pattern for persistence

# 5. Implementation

As most of the implementation used in CSheets is compatible with NSheets, the main work that had to be done was to restructure the ExtensionManager class to comply with GWT restrictions.
Also, creation of a View for Extension configuration was necessary.

# 6. Integration/Demonstration

*In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)*

# 7. Final Remarks 

*In this section present your views regarding alternatives, extra work and future work on the issue.*

# 8. Work Log

*Insert here a log of you daily work. This is in essence the log of your daily work. It should reference your commits as much as possible.*