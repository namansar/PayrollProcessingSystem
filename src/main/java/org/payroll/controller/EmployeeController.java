package org.payroll.controller;

import org.payroll.entity.Employee;
import org.payroll.entity.Event;
import org.payroll.service.EmployeeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();

    public void addEmp(String[] empinfo) {
        Employee emp=new Employee();
        Event ev=new Event();
        for (String part : empinfo) {
            String[] singlerecord=part.split(",");

            if(part.contains("ONBOARD")) {
                String date=singlerecord[6];

                try {
                    Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);
                    emp.setEventDate(date1);

                    System.out.println("Date1:"+date1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                emp.setSequenceNo(Integer.valueOf(singlerecord[0]));
                emp.setEmployeeId((singlerecord[1]));
                emp.setEmpFName(singlerecord[2]);
                emp.setEmpLName(singlerecord[3]);
                emp.setDesignation(singlerecord[4]);
                //emp.setEventDate(date1);
                ev.setEvent(singlerecord[5]);
                ev.setEventValue(singlerecord[6]);
                ev.setNotes((singlerecord[8]));
                ev.setEventEmpId(singlerecord[1]);
                List<Event> eventlist = List.of(ev);
                emp.setEvents(eventlist);
                employeeService.addEmployee(emp.getEmployeeId(), emp);
            }
            else if(part.contains("SALARY")) {
                Employee e = employeeService.findByEmpId(singlerecord[1]);
                e.setSalary(Integer.parseInt(singlerecord[3].trim()));
                employeeService.updateSalaryOfEmployee(e.getEmployeeId(), e);
            }

            else if(part.contains("BONUS")) {
                Employee e = employeeService.findByEmpId(singlerecord[1]);
                e.setBonus(Integer.parseInt(singlerecord[3].trim()));
                employeeService.updateBonusOfEmployee(e.getEmployeeId(), e);


            }

            else if(part.contains("REIMBURSEMENT")) {
                Employee e = employeeService.findByEmpId(singlerecord[1]);
                e.setReimbursement(Integer.parseInt(singlerecord[3].trim()));
                employeeService.updateReimbursementOfEmployee(e.getEmployeeId(), e);

            }
            else if(part.contains("EXIT")) {
                //Employee e = employeeService.findByEmpId(singlerecord[1]);
                String empId = singlerecord[1].trim();
                employeeService.removeEmployee(empId);

            }

        }


    }

    // output point 1
    public int totalEmployees() {
        return employeeService.TotalEmployees();
    }

    public List<Employee> findAllDeatils(){
        return employeeService.findAll();
    }

    // Output point 4
    public void employeeWiseFinancialReport(){
//        TotalAmountPaid = e.getsalary()*12 + e.getBonus() + reimbursment
        employeeService.printEmployeeFinancialReport();
    }

    public void findAllOnBoarded(){
        employeeService.findAllOnboarded();
    }

    //output point 3

    public void monthlySalaryReport() {

        //Monthly salary report in following format
        // Month, Total Salary, Total employees
        int totalEmployees = totalEmployees();
        employeeService.findMontlySalaryReport();
        //Dec 22 - 55556565665 - 500
        //Dec 21 - 45669488554 - 450



    }

}
