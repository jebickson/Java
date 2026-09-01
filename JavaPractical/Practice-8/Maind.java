# Compile all Java files
javac -d . com/company/employee/*.java
javac -d . com/company/employee/hr/*.java
javac -d . com/company/employee/tech/*.java
javac -d . com/company/data/*.java
javac -d . com/company/util/*.java
javac -d . com/company/interfaces/*.java
javac -d . com/company/interfaces/impl/*.java
javac -d . com/company/interfaces/functional/*.java
javac -d . com/company/interfaces/constants/*.java
javac -d . com/company/main/*.java

# Or compile all at once
javac -d . com/company/**/*.java

# Run the application
java com.company.main.Application