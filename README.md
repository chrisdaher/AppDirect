# AppDirect
In order to run this application, you will need the following:
- Gradle (2.4)
- Java (JDK 8)

Gradle Installation:

	- Go to http://gradle.org/ and download Gradle 2.4
	- Unzip the folder and save it in C:\gradle-2.4  ( in another word extract it in C:\ )
	- Go to Control Panel  --->  system  ---> Advanced System Settings  ---> Advanced tab ---> Environment Variables  --->  System Variables  --->  New
	- Variable name: GRADLE_HOME 
	- Variable value:   C:\gradle-2.4
	- Press OK
	- Go to System Variables  ---> Click on path --->  Edit
	- Add  %GRADLE_HOME%\bin;  to the path
	- Open windows cmd.exe and type gradle -v  you should be able to see the version of the installed Gradle

Java:

	- Install Jdk 1.8  compatible for windows x64 from http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
	- Go to Control Panel  --->  system  ---> Advanced System Settings  ---> Advanced tab ---> Environment Variables  --->  System Variables 
	- If you already have JAVA_HOME in your system variables, rename the existing one to JAVA_HOME_OLD 
	-  Click on New
		○ Variable name  =  JAVA_HOME
	- Variable Value   =  C:\Program Files\Java
	- Press OK
	- If you  don't have  JAVA_HOME in your Path,  click on Path ---> Edit  and  add  %JAVA_HOME%\jre\bin;  to the beginning of the existing path and press OK
	- Open windows cmd.exe and type java -version  you should be able to see the java version 1.8
