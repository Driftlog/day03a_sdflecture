package sg.edu.nus.iss;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App  //Creates directory and txt.file
{
    public static void main( String[] args ) throws IOException
    {
        String dirPath = args[0]; //c:\data
        String fileName = args[1]; //employee.txt
        String dirPathFileName = dirPath + File.separator + fileName;

        File newDir = new File(dirPath); //Create directory if it does not exist
        if (newDir.exists()) {
            System.out.println("Dir already exists.");
        } else {
            newDir.mkdir();
        }

        File myFile = new File(dirPathFileName); //Create file if it does not exist

        if (myFile.exists()) {
            System.out.println("File" + myFile + "already exists.");
        } else {
            myFile.createNewFile();
        }

        CSVWriter csvWriter = new CSVWriter();
        List<Employee> empList = csvWriter.generateEmployees();
        csvWriter.writeTOCSV(empList, dirPathFileName);

        CSVReader csvReader = new CSVReader();
        List<Employee> retrievedList = csvReader.readCSV(dirPathFileName);
        System.out.println(retrievedList);


    }
}
