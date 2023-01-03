package org.payroll.service;

import org.payroll.entity.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class EmployeeService {

    private TreeMap<String, Employee> hm=new TreeMap<>();

    public void addEmployee(String empId,Employee e) {
        System.out.println("employee to be added in hm ->" + e.getEmployeeId() + " " + e.getDesignation() + " " + e.getEmpFName());
        if(hm.containsKey(empId)) {
            hm.put(empId, hm.get(empId));
        }else {
            hm.put(empId, e);
        }
    }




    public void TotalEmployees() {
        System.out.println("Total number of employees is:"+hm.size());
    }

    public List<Employee> findAll(){
       // System.out.println(hm.values());
        List<Employee> listRecords = new ArrayList<>(hm.values());
        for(int i=0;i<listRecords.size();i++) {
            System.out.println(listRecords.get(i).getDesignation()+","+listRecords.get(i).getEmpFName());

        }
        return listRecords;
    }

    public Employee findByEmpId(String id) {
        return hm.get(id);
    }


    public void printEmployeeFinancialReport() {

        //TotalAmountPaid = e.getsalary()*12 + e.getBonus() + reimbursment

        System.out.println("Employee Id, Name, Surname, Total amount paid");
        for (var entry : hm.entrySet()) {
            int totalpaid = 0;
            if(entry.getValue().getSalary() != null) {
                totalpaid = entry.getValue().getSalary()*12;
            }

            System.out.println(entry.getValue().getEmployeeId() + " " +entry.getValue().getEmpFName()
                    + " " + entry.getValue().getEmpLName() + " " + totalpaid);

        }

    }
}
