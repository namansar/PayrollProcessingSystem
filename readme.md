# Payroll Processing System in Java

`PPC is a Payroll solution provider company who manages the payroll of the various companies from small scale to large scale company.`

`PPC accepts the employees data from the client in either plain text format (.txt) or csv (.csv) format to manage the employee life cycle starting from date of onboarding to date of exit.`

---
## Requirements

> Java 11 or above

---

## IDE 
> IntelliJ Idea || STS || Eclipse

---

## Install
- [x]  [Java 11](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html)
- [x] [IntelliJ Idea](https://www.jetbrains.com/idea/download/#section=windows)
- [x] [STS ](https://spring.io/tools)
- [x] [Eclipse ](https://www.eclipse.org/downloads/)

---

## Framework

For this Payroll Processing System, we are using Collection framework of Java.

---

## Dependencies

In this project we have used following dependencies :-

- JUnit

---


## Directory Structure

```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org
│   │   │       └── payroll
│   │   │           ├── controller
│   │   │           ├── entity
│   │   │           ├── service
│   │   │           └── utility
│   │   └── resources
│   └── test
│       └── java
└── target
    ├── classes
    │   └── org
    │       └── payroll
    │           ├── controller
    │           ├── entity
    │           ├── service
    │           └── utility
    └── generated-sources
        └── annotations
```
---

## Steps to run the program

1. Import the zip file into your respective IDE.

2.  Check the Java version (11 or above).

3.  Go to Run configurations --> click on arguements and mention the input file name (txt/csv) --> Click on apply

4.  Click RUN.

----

## <details><summary>Field of records</summary>

| Field of Record        | Description|  
| ------------- |:-------------:| 
|SequenceNo     | Sequence number of records in file starting from 1 | 
| EmpID      | Unique Id of employee  |  
| EmpFName | First Name of employee      |    
|EmpLName | Last Name of employee|
|Designation| Post of employee|
|Event| Any one from below table|
| EventDate | Date when this event happened in DD-MM-YYYY format.|
|Notes|Date when this event happened in DD-MM-YYYY format.|
|Value| Value according to the event. Refer the following table. |

<b>Table for the value of the event</b>
| | |          
| ------------- |:-------------:| 
| ONBOARD     | Date of Joining in MM-DD-YYYY format | 
| SALARY      | Salary Amount in USD     |  
| BONUS  |Bonus Amount in USD|
|EXIT| Date of Leaving in MM-DD-YYYY format|
|REIMBURSEMENT| Reimbursement Amount in USD|

</details>

---

## Output of the solutions to the problems

1. Total number of employees in an organization.

2. Month wise following details

    a. Total number of employees joined the organization with employee details like emp id,
designation, name, surname.

    b. Total number of employees exit organization with employee details like name, surname.

3. Monthly salary report in following format

    a. Month, Total Salary, Total employees

4. Employee wise financial report in the following format

    a. Employee Id, Name, Surname, Total amount paid

5. Monthly amount released in following format

    a. Month, Total Amount (Salary + Bonus + REIMBURSEMENT), Total employees

6. Yearly financial report in the following format

    a. Event, Emp Id, Event Date, Event value
    
    
![image](https://user-images.githubusercontent.com/117452872/210829413-575dd1ff-521d-4514-b1ff-2a93004556b2.png)
![image](https://user-images.githubusercontent.com/117452872/210829520-44d62811-4bcb-49b9-98c3-266c3a347dfe.png)
![image](https://user-images.githubusercontent.com/117452872/210829561-07e015b8-f5d2-4e9f-9468-98610031209f.png)

