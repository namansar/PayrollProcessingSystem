package org.payroll;

import org.payroll.controller.EmployeeController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        // Reading input

//            fileReader fr = new fileReader();
//            getList lists = new getList();
//
//            if (args[0] == null || args[0].trim().isEmpty()) {
//                System.out.println("You need to specify a path!");
//                return;
//            } else {
//                File CP_file = new File(args[0]);
//                int count = fr.fileSizeInLines(CP_file);
//                System.out.println("Total number of lines in the file are: "+count);
//
//                List<String> lines = fr.strReader(CP_file);
//
//            }

        File inFile = null;
        if(args.length>0) {

            String[] splited = null;
            inFile = new File(args[0]);
            try {
                BufferedReader br = new BufferedReader(new FileReader(inFile));
                String read = null;
                String[] data;
                EmployeeController empCont =new EmployeeController();

                while ((read = br.readLine()) != null) {
                    data = read.split("\\.");
                    empCont.addEmp(data);
//                    for (String part : data) {
//                        System.out.println(part);
//                    }
                }
                empCont.totalEmployees();
                empCont.findAllDeatils();
                empCont.EmployeeWiseFinancialReport();

//                Employee e = new Employee();
//                for(String part : splited) {
//
//                }


            } catch (IOException e) {
                System.out.println("There was a problem: " + e);
            }

    }

    }

}