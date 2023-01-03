package org.payroll.controller;

import org.payroll.entity.Employee;
import org.payroll.entity.Events;
import org.payroll.service.EmployeeService;

import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();

    public void addEmp(String[] empinfo) {
        Employee emp=new Employee();
        Events ev=new Events();
        for (String part : empinfo) {
            String[] singlerecord=part.split(",");

            if(part.contains("ONBOARD")) {
                emp.setSequenceNo(Integer.valueOf(singlerecord[0]));
                emp.setEmployeeId((singlerecord[1]));
                emp.setEmpFName(singlerecord[2]);
                emp.setEmpLName(singlerecord[3]);
                emp.setDesignation(singlerecord[4]);
                ev.setEvent(singlerecord[5]);
                ev.setEventValue(singlerecord[6]);
                ev.setNotes((singlerecord[6]));
                List<Events> eventlist = List.of(ev);
                emp.setEvents(eventlist);
                employeeService.addEmployee(emp.getEmployeeId(), emp);
            }
            else if(part.contains("SALARY")) {
                Employee e = employeeService.findByEmpId(singlerecord[1]);
                e.setSalary(Integer.parseInt(singlerecord[3].trim()));
                employeeService.addEmployee(e.getEmployeeId(), e);
            }

            else if(part.contains("BONUS")) {

            }

            else if(part.contains("REIMBURSEMENT")) {

            }
            else if(part.contains("EXIT")) {

            }

        }


    }

    public void totalEmployees() {
        employeeService.TotalEmployees();
    }

    public List<Employee> findAllDeatils(){
        return employeeService.findAll();
    }

    public void EmployeeWiseFinancialReport(){
//        TotalAmountPaid = e.getsalary()*12 + e.getBonus() + reimbursment
//        sout( e.getId + e.getEName + TotalAmountPaid)
//        Employee {
//            salary , reimbursment=0, bonus =0;
//        }

        employeeService.printEmployeeFinancialReport();




    }

}
