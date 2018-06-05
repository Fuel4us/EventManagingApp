cd lapr4-18-2db\
START /B powershell mvn clean install
cd lapr4-18-2db\
START /B powershell mvn tomcat7:run-war-only
cd lapr4-18-2db\
START /B powershell mvn gwt:run -pl nsheets