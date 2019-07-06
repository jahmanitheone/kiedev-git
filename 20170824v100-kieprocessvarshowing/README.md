Building Project
-----------------------------------------------------------------------------------
Requirements:
o Need JDK 1.8 not JRE 1.8
  I installed JDK on my machine at: C:\bin\jdk1.8.0_131

o Need Maven
  I installed maven based on the normal CSRA project configurations:
  C:\dev\softwares\apache-maven-3.0.4


Scripts To Ease Building
------------------------------
o setjdk18.cmd 
Here is a scripts I used to set my environment: 
echo off
cls
set JAVA_HOME=C:\bin\jdk1.8.0_131
echo .
echo JAVA_HOME=%JAVA_HOME% 
echo .

set CYGBIN=C:\cygwin64/bin
set WINPATH=C:\windows\system32;C:\windows;C:\windows\System32\Wbem;C:\windows\System32\WindowsPowerShell\v1.0 
set DEVPATH=.;C:\batch;
set PATH=%WINPATH%;%CYGBIN%;%JAVA_HOME%\bin;%DEVPATH%;
rem set PATH=%WINPATH%;%JAVA_HOME%\bin;%DEVPATH%;
echo PATH=%PATH% 
echo .

call setmvn

o setmvn.cmd
SET MAVEN_HOME=C:\dev\softwares\apache-maven-3.0.4
echo MAVEN_HOME=%MAVEN_HOME% 
              
SET PATH=%PATH%;%MAVEN_HOME%\BIN

Recommendation:
	Since I go back and for between the new CSRA JBPM and normal CSRA,	I needed these scripts.	

	
Prerequisite
-----------------------------
setjdk18


Building All Project
----------------------------------
Once this project is cloned from repository, go to that directory:
Ex: cd  C:\A-DEV\workspace-csrra-sandbox\20170822\

Issue:
mvn clean install

- All modules will compile and result in a similar output:
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] CSRA Eligibility JBPM Work Flow Processes Parent POM  SUCCESS [1.382s]
[INFO] CSRA Eligibility JBPM Domain (DTOs) ............... SUCCESS [3.466s]
[INFO] CSRA Eligibility JBPM Domain (DTOs) Test .......... SUCCESS [3.087s]
[INFO] CSRA Eligibility JBPM Work Flow Processes ......... SUCCESS [1.114s]
[INFO] CSRA Eligibility JBPM Work Flow Processes Test .... SUCCESS [1.600s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 10.381s
[INFO] Finished at: Tue Aug 22 17:34:25 EDT 2017
[INFO] Final Memory: 66M/564M
[INFO] ------------------------------------------------------------------------


DONE!

Building A Project
-----------------------------
Change directory to desired project:
Ex: cd  C:\A-DEV\workspace-csrra-sandbox\20170822\hx-eligibility-dto

Issue:
setjdk18
mvn clean install

- Code will compile and run some basic domain object test.

DONE!

Run all test only:
mvn test


