package org.payroll.service;

import org.payroll.entity.Employee;
import org.payroll.entity.Event;
import org.payroll.utility.Month;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class EmployeeService {

    private static TreeMap<String, Employee> employeeMap = new TreeMap<>();
    private static TreeMap<String, Employee> exitEmployees = new TreeMap<>();
    private static TreeMap<Month, List<Employee>> monthMap = new TreeMap<>();
    private static TreeMap<Integer, TreeMap<Month, List<Employee>>> yearMap = new TreeMap<Integer, TreeMap<Month, List<Employee>>>();
    private static ArrayList<ArrayList<Employee>> monthList = new ArrayList<ArrayList<Employee>>();

    private TreeMap<Date, Employee> monthlyDetails = new TreeMap<>(new Comparator<Date>() {
        public int compare(Date date1, Date date2) {
            return date1.compareTo(date2);
        }
    });

    public static LocalDate convert(Date date) {
        return date.toInstant()
                .atZone(ZoneId.of("Asia/Kolkata"))
                .toLocalDate();
    }

    public void addEmployee(String empId, Employee e) {
        employeeMap.put(empId, e);
        Date onBoard = e.getEventDate();
        monthlyDetails.put(onBoard, e);
        LocalDate localDate = convert(onBoard);
        int month = localDate.getMonthValue();
        int year = localDate.getYear();
        // year map logic

        if (!yearMap.containsKey(year)) {
            TreeMap<Month, List<Employee>> yearlyMonthMap = new TreeMap<>();

            ArrayList<ArrayList<Employee>> yearWiseMonthList = new ArrayList<ArrayList<Employee>>();
            if (yearWiseMonthList.size() == 0) {
                for (int i = 0; i < 12; i++) {
                    yearWiseMonthList.add(new ArrayList<>());
                }

            }

            int counter = 0;
            for (Month months : Month.values()) {
                yearlyMonthMap.put(months, yearWiseMonthList.get(counter++));
            }

            switch (month) {
                case 1:
                    yearWiseMonthList.get(0).add(e);
                    yearlyMonthMap.put(Month.JANUARY, yearWiseMonthList.get(0));
                    break;
                case 2:
                    yearWiseMonthList.get(1).add(e);
                    yearlyMonthMap.put(Month.FEBRUARY, yearWiseMonthList.get(1));
                    break;
                case 3:
                    yearWiseMonthList.get(2).add(e);
                    yearlyMonthMap.put(Month.MARCH, yearWiseMonthList.get(2));
                    break;
                case 4:
                    yearWiseMonthList.get(3).add(e);
                    yearlyMonthMap.put(Month.APRIL, yearWiseMonthList.get(3));
                    break;
                case 5:
                    yearWiseMonthList.get(4).add(e);
                    yearlyMonthMap.put(Month.MAY, yearWiseMonthList.get(4));
                    break;
                case 6:
                    yearWiseMonthList.get(5).add(e);
                    yearlyMonthMap.put(Month.JUNE, yearWiseMonthList.get(5));
                    break;
                case 7:
                    yearWiseMonthList.get(6).add(e);
                    yearlyMonthMap.put(Month.JULY, yearWiseMonthList.get(6));
                    break;
                case 8:
                    yearWiseMonthList.get(7).add(e);
                    yearlyMonthMap.put(Month.AUGUST, yearWiseMonthList.get(7));
                    break;
                case 9:
                    yearWiseMonthList.get(8).add(e);
                    yearlyMonthMap.put(Month.SEPTEMBER, yearWiseMonthList.get(8));
                    break;
                case 10:
                    yearWiseMonthList.get(9).add(e);
                    yearlyMonthMap.put(Month.OCTOBER, yearWiseMonthList.get(9));
                    break;
                case 11:
                    yearWiseMonthList.get(10).add(e);
                    yearlyMonthMap.put(Month.NOVEMBER, yearWiseMonthList.get(10));
                    break;
                case 12:
                    yearWiseMonthList.get(11).add(e);
                    yearlyMonthMap.put(Month.DECEMBER, yearWiseMonthList.get(11));
                    break;
                default:
                    System.out.println("Please provide proper month");
                    break;

            }
            yearMap.put(year, yearlyMonthMap);

        } else {
            TreeMap<Month, List<Employee>> currentYearMap = yearMap.get(year);
            ArrayList<Employee> currentMonthList = (ArrayList<Employee>) currentYearMap.get(Month.values()[month - 1]);
            currentMonthList.add(e);
            currentYearMap.put(Month.values()[month - 1], currentMonthList);
            yearMap.put(year, currentYearMap);

        }

        // year map logic end here


        if (monthList.size() == 0) {
            for (int i = 0; i < 12; i++) {
                monthList.add(new ArrayList<>());
            }
        }

        switch (month) {
            case 1:
                monthList.get(0).add(e);
                monthMap.put(Month.JANUARY, monthList.get(0));
                break;
            case 2:
                monthList.get(1).add(e);
                monthMap.put(Month.FEBRUARY, monthList.get(1));
                break;
            case 3:
                monthList.get(2).add(e);
                monthMap.put(Month.MARCH, monthList.get(2));
                break;
            case 4:
                monthList.get(3).add(e);
                monthMap.put(Month.APRIL, monthList.get(3));
                break;
            case 5:
                monthList.get(4).add(e);
                monthMap.put(Month.MAY, monthList.get(4));
                break;
            case 6:
                monthList.get(5).add(e);
                monthMap.put(Month.JUNE, monthList.get(5));
                break;
            case 7:
                monthList.get(6).add(e);
                monthMap.put(Month.JULY, monthList.get(6));
                break;
            case 8:
                monthList.get(7).add(e);
                monthMap.put(Month.AUGUST, monthList.get(7));
                break;
            case 9:
                monthList.get(8).add(e);
                monthMap.put(Month.SEPTEMBER, monthList.get(8));
                break;
            case 10:
                monthList.get(9).add(e);
                monthMap.put(Month.OCTOBER, monthList.get(9));
                break;
            case 11:
                monthList.get(10).add(e);
                monthMap.put(Month.NOVEMBER, monthList.get(10));
                break;
            case 12:
                monthList.get(11).add(e);
                monthMap.put(Month.DECEMBER, monthList.get(11));
                break;
            default:
                System.out.println("Please provide proper month");
                break;
        }

    }


    public int totalEmployees() {
        //System.out.println("----------------------------------------");
        System.out.println("Total number of employees is:" + employeeMap.size());
        //System.out.println("------------------------------------------");
        return employeeMap.size();

    }

    public List<Employee> findAll() {
        System.out.println("-------------------------------------------------");
        List<Employee> listRecords = new ArrayList<>(employeeMap.values());
        for (int i = 0; i < listRecords.size(); i++) {
            System.out.println(listRecords.get(i).getDesignation() + "," + listRecords.get(i).getEmpFName());

        }
        System.out.println("-------------------------------------------------");
        return listRecords;
    }

    public Employee findByEmpId(String id) {
        return employeeMap.get(id);
    }

    public void printEmployeeFinancialReport() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Employee Id, Name, Surname, Total amount paid");
        for (var entry : employeeMap.entrySet()) {
            int totalpaid = 0;
            if (entry.getValue().getSalary() != null) {
                totalpaid = entry.getValue().getSalary() * 12 + entry.getValue().getBonus()
                        + entry.getValue().getReimbursement();
            }

            System.out.println(entry.getValue().getEmployeeId() + " " + entry.getValue().getEmpFName()
                    + " " + entry.getValue().getEmpLName() + " " + totalpaid);
        }
        System.out.println("----------------------------------------------------------------");

    }

    public void findAllOnboarded() {
        System.out.println("------------------------------------------------------------------------------");
        for (var entry : monthlyDetails.entrySet()) {
            Event event = entry.getValue().getEvents().get(0);
            if (event.getEvent().trim().equals("ONBOARD")) {
                String onBoarddate = event.getEventValue();
                String empid = entry.getValue().getEmployeeId();
                String name = entry.getValue().getEmpFName();
                String surname = entry.getValue().getEmpLName();
                String designation = entry.getValue().getDesignation();
                System.out.println("empId " + empid + " name" + name + "surname " + surname + " designation" + designation);

            }

        }
        for (var entry : monthMap.entrySet()) {
            System.out.println("-------------------------------------------------");
            for (int i = 0; i < entry.getValue().size(); i++) {

                System.out.println(entry.getKey() + " " + entry.getValue().get(i).getEmployeeId() + " " + entry.getValue().get(i).getDesignation()
                        + " " + entry.getValue().get(i).getEmpFName() + " " + entry.getValue().get(i).getEmpLName()
                );
            }
            System.out.println(" Total Employees onboarded in this month = " + entry.getValue().size());
        }

        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public void updateSalaryOfEmployee(String employeeId, Employee e) {
        employeeMap.put(employeeId, e);
    }

    public void updateBonusOfEmployee(String employeeId, Employee e) {
        employeeMap.put(employeeId, e);
    }

    public void updateReimbursementOfEmployee(String employeeId, Employee e) {
        employeeMap.put(employeeId, e);
    }

    public void removeEmployee(String empId) {
        Employee e = findByEmpId(empId);
        exitEmployees.put(empId, e);
        employeeMap.remove(empId);
    }

    public void findMontlySalaryReport() {
        // last 6 months

        System.out.println("------------------------------------------------------------------------------------");
        LocalDate currentDate = LocalDate.now();
        System.out.println(" Each month salary information");

        int currentYear = currentDate.getYear();
        String currentMonth = currentDate.getMonth().toString();

        // last 6 months salary details

        int totalSalary = 0;
        int totalEmployees = 0;

        // current month report
        for (var entry : yearMap.entrySet()) {
            int year = entry.getKey();
            if (year < currentDate.getYear()) {
                TreeMap<Month, List<Employee>> yearMonthlyMap = entry.getValue();
                for (Month months : Month.values()) {
                    ArrayList<Employee> empList = (ArrayList<Employee>) yearMonthlyMap.get(months);
                    if (empList.size() > 0) {
                        for (int i = 0; i < empList.size(); i++) {
                            totalSalary += empList.get(i).getSalary();
                        }
                        totalEmployees += empList.size();
                    }
                }
            } else if (year == currentDate.getYear()) {

                TreeMap<Month, List<Employee>> yearMonthlyMap = entry.getValue();

                for (int i = 0; i < Month.values().length; i++) {
                    if (Month.values()[i].toString().equals(currentDate.getMonth().toString())) {
                        ArrayList<Employee> empList = (ArrayList<Employee>) yearMonthlyMap.get(Month.values()[i]);
                        if (empList.size() > 0) {
                            for (int j = 0; j < empList.size(); j++) {
                                totalSalary += empList.get(j).getSalary();
                            }
                            totalEmployees += empList.size();
                        }
                    } else {
                        break;
                    }
                }
            }
        }


        System.out.println(currentDate.getMonth() + " " + currentDate.getYear() + " Total Salary " + totalSalary + " EmpCount " + totalEmployees);

        // correct month report

        currentDate.getYear();
        if (currentDate.getMonth().toString().equals("JANUARY")) {
            currentYear--;
        }


        for (int k = Month.values()[Month.values().length - 1].ordinal(); k >= 6; k--) {


            currentMonth = Month.values()[k].toString();
            totalSalary = 0;
            totalEmployees = 0;

            for (var entry : yearMap.entrySet()) {
                int year = entry.getKey();
                if (year < currentYear) {
                    TreeMap<Month, List<Employee>> yearMonthlyMap = entry.getValue();
                    for (Month months : Month.values()) {
                        ArrayList<Employee> empList = (ArrayList<Employee>) yearMonthlyMap.get(months);
                        if (empList.size() > 0) {
                            for (int i = 0; i < empList.size(); i++) {
                                totalSalary += empList.get(i).getSalary();
                            }
                            totalEmployees += empList.size();
                        }
                    }


                } else if (year == currentYear) {

                    TreeMap<Month, List<Employee>> yearMonthlyMap = entry.getValue();

                    for (int i = 0; i < Month.values().length; i++) {
                        if (!Month.values()[i].toString().equals(currentMonth)) {
                            ArrayList<Employee> empList = (ArrayList<Employee>) yearMonthlyMap.get(Month.values()[i]);
                            if (empList.size() > 0) {
                                for (int j = 0; j < empList.size(); j++) {
                                    totalSalary += empList.get(j).getSalary();
                                }
                                totalEmployees += empList.size();
                            }
                        } else {

                            ArrayList<Employee> empList = (ArrayList<Employee>) yearMonthlyMap.get(Month.values()[i]);
                            if (empList.size() > 0) {
                                for (int j = 0; j < empList.size(); j++) {
                                    totalSalary += empList.get(j).getSalary();
                                }
                                totalEmployees += empList.size();
                            }
                            break;
                        }
                    }
                }


            }
            System.out.println(currentMonth + " " + currentYear + " " + " Total Salary " + totalSalary + " EmpCount " + totalEmployees);

        }

        System.out.println("---------------------------------------------------------------------------");


    }

    public void findMontlySalaryBonusReport() {
        LocalDate currentDate = LocalDate.now();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(" Each month (salary + bonus + Reimbursement) information");

        int currentYear = currentDate.getYear();
        String currentMonth = currentDate.getMonth().toString();
        // last 6 months salary details

        int totalSalary = 0;
        int totalEmployees = 0;
        // current month report

        for (var entry : yearMap.entrySet()) {
            int year = entry.getKey();
            if (year < currentDate.getYear()) {
                TreeMap<Month, List<Employee>> yearMonthlyMap = entry.getValue();
                for (Month months : Month.values()) {
                    ArrayList<Employee> empList = (ArrayList<Employee>) yearMonthlyMap.get(months);
                    if (empList.size() > 0) {
                        for (int i = 0; i < empList.size(); i++) {
                            totalSalary += empList.get(i).getSalary() + empList.get(i).getBonus() + empList.get(i).getReimbursement();
                        }
                        totalEmployees += empList.size();
                    }
                }
            } else if (year == currentDate.getYear()) {

                TreeMap<Month, List<Employee>> yearMonthlyMap = entry.getValue();

                for (int i = 0; i < Month.values().length; i++) {
                    if (Month.values()[i].toString().equals(currentDate.getMonth().toString())) {
                        ArrayList<Employee> empList = (ArrayList<Employee>) yearMonthlyMap.get(Month.values()[i]);
                        if (empList.size() > 0) {
                            for (int j = 0; j < empList.size(); j++) {
                                totalSalary += empList.get(j).getSalary() + empList.get(j).getBonus() + empList.get(j).getReimbursement();
                            }
                            totalEmployees += empList.size();
                        }
                    } else {
                        break;
                    }
                }
            }
        }


        System.out.println(currentDate.getMonth() + " " + currentDate.getYear() + " Total Salary " + totalSalary + " EmpCount " + totalEmployees);
        // correct month report

        currentDate.getYear();
        if (currentDate.getMonth().toString().equals("JANUARY")) {
            currentYear--;
        }


        for (int k = Month.values()[Month.values().length - 1].ordinal(); k >= 6; k--) {


            currentMonth = Month.values()[k].toString();
            totalSalary = 0;
            totalEmployees = 0;

            for (var entry : yearMap.entrySet()) {
                int year = entry.getKey();
                if (year < currentYear) {
                    TreeMap<Month, List<Employee>> yearMonthlyMap = entry.getValue();
                    for (Month months : Month.values()) {
                        ArrayList<Employee> empList = (ArrayList<Employee>) yearMonthlyMap.get(months);
                        if (empList.size() > 0) {
                            for (int i = 0; i < empList.size(); i++) {
                                totalSalary += empList.get(i).getSalary() + empList.get(i).getBonus() + empList.get(i).getReimbursement();
                            }
                            totalEmployees += empList.size();
                        }
                    }


                } else if (year == currentYear) {

                    TreeMap<Month, List<Employee>> yearMonthlyMap = entry.getValue();

                    for (int i = 0; i < Month.values().length; i++) {
                        if (!Month.values()[i].toString().equals(currentMonth)) {
                            ArrayList<Employee> empList = (ArrayList<Employee>) yearMonthlyMap.get(Month.values()[i]);
                            if (empList.size() > 0) {
                                for (int j = 0; j < empList.size(); j++) {
                                    totalSalary += empList.get(j).getSalary() + empList.get(j).getBonus() + empList.get(j).getReimbursement();
                                }
                                totalEmployees += empList.size();
                            }
                        } else {

                            ArrayList<Employee> empList = (ArrayList<Employee>) yearMonthlyMap.get(Month.values()[i]);
                            if (empList.size() > 0) {
                                for (int j = 0; j < empList.size(); j++) {
                                    totalSalary += empList.get(j).getSalary();
                                }
                                totalEmployees += empList.size();
                            }
                            break;
                        }
                    }
                }


            }
            System.out.println(currentMonth + " " + currentYear + " " + " Total Salary " + totalSalary + " EmpCount " + totalEmployees);
        }
        System.out.println("---------------------------------------------------------------------------");

    }


    public void yearlyEventRecords() {
        System.out.println("------------------------------Yearly Event financial report--------------------------------");
        System.out.println("Year" + "   " + "Event" + "   " + " EmpId" + "   " + "EventDate" + "   " + "EventValue");
        for (var entry : yearMap.entrySet()) {
            int year = entry.getKey();
            TreeMap<Month, List<Employee>> yearMonthlyMap = entry.getValue();
            for (Month months : Month.values()) {
                ArrayList<Employee> empList = (ArrayList<Employee>) yearMonthlyMap.get(months);
                if (empList.size() > 0) {
                    for (int i = 0; i < empList.size(); i++) {

                        System.out.println(year + "  " + empList.get(i).getEvent() + " "
                                + empList.get(i).getEmployeeId() + " " + empList.get(i).getEventRecordDate() + " "
                                + empList.get(i).getEventRecordValue());
                    }
                }
            }
        }
    }


    public void showExitEmployeeDetails() {
        //   exitEmployees.
    }
}
