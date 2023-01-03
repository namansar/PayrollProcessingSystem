package org.payroll.entity;

import org.payroll.entity.Events;

import java.util.HashMap;
import java.util.List;

public class Employee {

    private int sequenceNo;

    private String employeeId;
    private String EmpFName;
    private String EmpLName;
    private String Designation;
    private String eventDate;

    private Integer salary;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEventDate() {
        return eventDate;
    }
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    private List<Events> events;


    public int getSequenceNo() {
        return sequenceNo;
    }
    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmpFName() {
        return EmpFName;
    }
    public void setEmpFName(String empFName) {
        EmpFName = empFName;
    }
    public String getEmpLName() {
        return EmpLName;
    }
    public void setEmpLName(String empLName) {
        EmpLName = empLName;
    }
    public String getDesignation() {
        return Designation;
    }
    public void setDesignation(String designation) {
        Designation = designation;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }


}