# Create JAR file
jar cf company-app.jar com/company/**/*.class

# Run from JAR
java -cp company-app.jar com.company.main.Application

# Create executable JAR with manifest
echo "Main-Class: com.company.main.Application" > manifest.txt
jar cfm company-app.jar manifest.txt com/company/**/*.class
java -jar company-app.jar