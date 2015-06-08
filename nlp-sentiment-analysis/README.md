Following are steps to make it run:
- Unzip the code.
- Opening it in Eclipse:
    - Open Eclipse
    - Eclipse -> File -> Import -> Maven -> Existing Maven project -> Link to the code location -> Next -> Finish
- You will now able to see the project.
- Run the code and be happy. :)

===================================
Command line :

- First install Maven: http://maven.apache.org/download.cgi
- cd "code folder"
- mvn clean assembly-single
- You will see a JAR file inside "target" folder
- To run type: java -cp target/jar_file_name  org.postdoc.algorithm.sentiment.impl.TestStanfordSentiment

Note you have to add: a) Java compiler plug-in, and compile jar with dependencies in pom.xml
Useful link:
1. http://stackoverflow.com/questions/574594/how-can-i-create-an-executable-jar-with-dependencies-using-maven
2. http://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html
