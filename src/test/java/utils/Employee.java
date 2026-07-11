package PracticeSoftware.pages.utils;

import java.io.BufferedReader;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class Employee {

    String name;
    int age;
    String email;

    public Employee(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() { return this.name; }
    public int getAge() {
        return this.age;
    }
    public String getEmail() {
        return this.email;
    }

    public static ArrayList<Employee> getEmployeesFromCSVFile(String csvFileName) {
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.println("Reading file: " + csvFileName);
        try (FileReader fileReader = new FileReader(csvFileName);
             CSVReader reader = new CSVReaderBuilder(fileReader)
                     .withSkipLines(1) // skip the header (first) line
                     .build()) {
            String[] line;
            // readNext() reads the file line-by-line automatically handling escape quotes
            while ((line = reader.readNext()) != null) {
                Employee emp = new Employee(line[0], Integer.parseInt(line[1]), line[2]);
                employees.add(emp);
                //System.out.println(emp.name + " | " + emp.age + " | " + emp.email);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public static ArrayList<Employee> getEmployeesFromFixedFile(String fixedFileName) {
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.println("Reading file: " + fixedFileName);
        try (BufferedReader br = new BufferedReader(new FileReader(fixedFileName))) {
            String line;

            // Skip the first line (header)
            String firstLine = br.readLine();

            // Process the remaining lines
            while ((line = br.readLine()) != null) {
                // Use substring with exact starting and ending indices
                String name = line.substring(0, 12).trim();
                int age = Integer.parseInt(line.substring(13, 24).trim());
                String email = line.substring(25).trim();
                Employee emp = new Employee(name, age, email);
                employees.add(emp);
                //System.out.println(emp.name + " | " + emp.age + " | " + emp.email);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

}
