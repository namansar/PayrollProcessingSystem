package org.payroll;

import org.payroll.controller.EmployeeController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File inFile = null;
        if(args.length>0) {

            inFile = new File(args[0]);

            try {
                BufferedReader br = new BufferedReader(new FileReader(inFile));
                String read = null;

                String[] data = new String[1];
                EmployeeController empCont =new EmployeeController();

                while ((read = br.readLine()) != null) {
                    data[0] = read;

                    empCont.addEmp(data);

                }


                // output methods to output records and reports on console

                // total employees
                empCont.totalEmployees();

                //empCont.findAllDeatils();

                empCont.employeeWiseFinancialReport();

                empCont.findAllOnBoarded();

                empCont.monthlySalaryReport();

                empCont.monthlySalaryBonusReport();

                empCont.yearlyEventRecords();

            } catch (IOException e) {
                System.out.println("There was a problem: " + e);
            }

    }
    }

}