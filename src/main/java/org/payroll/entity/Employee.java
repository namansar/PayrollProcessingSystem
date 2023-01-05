package org.payroll.entity;

import java.util.Date;
import java.util.List;

public class Employee {

    private int sequenceNo;

    private String employeeId;
    private String EmpFName;
    private String EmpLName;
    private String Designation;
    private Date eventDate;
    private Integer salary = 0;
    private Integer bonus = 0;
    private Integer reimbursement = 0;

    private String eventRecordDate;
    private String eventRecordValue;
    private String event;

    public String getEventRecordDate() {
        return eventRecordDate;
    }

    public void setEventRecordDate(String eventRecordDate) {
        this.eventRecordDate = eventRecordDate;
    }

    public String getEventRecordValue() {
        return eventRecordValue;
    }

    public void setEventRecordValue(String eventRecordValue) {
        this.eventRecordValue = eventRecordValue;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getEventDate() {
        return eventDate;
    }
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    private List<Event> events;


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


    public List<Event> getEvents() {
        return events;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public Integer getBonus() {
        return bonus;
    }
    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
    public Integer getReimbursement() {
        return reimbursement;
    }
    public void setReimbursement(Integer reimbursement) {
        this.reimbursement = reimbursement;
    }


}