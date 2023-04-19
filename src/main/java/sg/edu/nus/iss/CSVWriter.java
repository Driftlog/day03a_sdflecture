package sg.edu.nus.iss;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEWLINE_SEPARATOR = "\n";
    public static final String FILE_HEADER = "staffNo, fullName,department, role, emailaddress, salary \n";

    public List<Employee> emplyees = null;

    public List<Employee> generateEmployees() {
        List<Employee> employees = new ArrayList<>();

        Employee emp1 = new Employee("12344", "Bryan", "Customer Relation", "Relationship Manager", "bryan@visa.com", 10000);
        Employee emp2 = new Employee("12345", "Arun", "Human Resources", "Talent Manager", "arun@visa.com", 11000);
        Employee emp3 = new Employee("12346", "ffff", "Customer Relation", "Sales Manager", "ffff@visa.com", 15000);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        
        return employees;
    }
    
    public void writeTOCSV(List<Employee> employees, String fileName) throws IOException{
        FileWriter fileWriter = new FileWriter(fileName);

        fileWriter.append(FILE_HEADER.toString());

        for (Employee emp : employees) {
            fileWriter.append(emp.getStaffNo());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(emp.getFullName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(emp.getDepartment());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(emp.getEmailAddress());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(emp.getRole());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(emp.getSalary()));
            fileWriter.append(NEWLINE_SEPARATOR);

        }

        fileWriter.flush();
        fileWriter.close();

    }
}

