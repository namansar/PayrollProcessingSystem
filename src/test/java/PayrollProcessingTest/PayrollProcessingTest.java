package PayrollProcessingTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.payroll.entity.Employee;
import org.payroll.service.EmployeeService;
import org.payroll.utility.Month;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.mockito.Mockito.when;


public class PayrollProcessingTest {

    @Mock
    EmployeeService employeeService;

    @Mock
    TreeMap<String, Employee> employeeMap ;

    @Mock
    TreeMap<String, Employee> exitEmployees;

    @Mock
    TreeMap<Month, List<Employee>> monthMap;

    @Mock
    TreeMap<Integer,TreeMap<Month,List<Employee>>> yearMap ;

    @Mock
    ArrayList<ArrayList<Employee>> monthList;

    @Mock
    Employee e;


    @BeforeEach
    public void configuration() {
        Employee e = new Employee();
        e.setSequenceNo(1);


    }

    @Test
    public void addEmployee()
    {

    }

    @Test
    public void employeeServiceTotalEmployeeTest(){

        when(employeeService.totalEmployees()).thenReturn(0);

        int employeeCount = employeeService.totalEmployees();

        int expectedOutput = 0;

        Assertions.assertEquals(employeeCount, expectedOutput);



    }
}
