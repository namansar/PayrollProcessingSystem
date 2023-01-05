package PayrollProcessingTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.payroll.controller.EmployeeController;
import org.payroll.entity.Employee;
import org.payroll.service.EmployeeService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class PayrollProcessingTest {

    private final PrintStream standardOut =System.out;
    private final ByteArrayOutputStream outputStreamCaptor=new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void totalEmployeeTest() {

        Date eventDate=new Date(01-11-2023);
        EmployeeService es=new EmployeeService();
        Employee e=new Employee();
        e.setEmployeeId("emp101");
        e.setEmpFName("Bill");
        e.setEvent("ONBOARD");
        e.setEventDate(eventDate);
        e.setEmpLName("Gates");
        es.addEmployee(e.getEmployeeId(),e);
        EmployeeController emp=new EmployeeController();
        emp.setEmployeeService(es);
        emp.totalEmployees();
        String expectedoutput="Total number of employees is:1";

        Assertions.assertEquals(expectedoutput, outputStreamCaptor.toString().trim());

}

    @Test
    public void employeeWiseFinancialReportTest() {
        Date eventDate=new Date(01-11-2023);

        EmployeeService es=new EmployeeService();
        Employee e=new Employee();
        e.setEmployeeId("emp101");
        e.setEmpFName("Bill");
        e.setEvent("ONBOARD");
        e.setEventDate(eventDate);
        e.setEmpLName("Gates");
        es.addEmployee(e.getEmployeeId(),e);
        EmployeeController emp=new EmployeeController();

        emp.setEmployeeService(es);
        emp.employeeWiseFinancialReport();

        String expectedoutput="----------------------------------------------------------------\n"
                + "Employee Id, Name, Surname, Total amount paid\n"
                + "emp101 Bill Gates 0\n"
                + "----------------------------------------------------------------";

        Assertions.assertEquals(expectedoutput, outputStreamCaptor.toString().trim());
    }



}
