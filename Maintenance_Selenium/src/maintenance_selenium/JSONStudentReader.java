/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintenance_selenium;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author minarafla
 */
public class JSONStudentReader {
    public static ArrayList<Student> students = new ArrayList<Student>();

    public void readJson(String jsonFilePath){
        try{
            Object obj = new JSONParser().parse(new FileReader(jsonFilePath)); 

            // typecasting obj to JSONObject 
            JSONObject jo = (JSONObject) obj; 

            JSONArray solutions = (JSONArray)jo.get("testCases");
            for (int i = 0; i < solutions.size(); i++) {
                JSONObject jsonobject = (JSONObject)solutions.get(i);
                String firstName = (String)jsonobject.get("first_name");
                String lastName = (String)jsonobject.get("last_name");
                String studentID = (String) jsonobject.get("student_ID"); 
                String studentEmail = (String) jsonobject.get("student_mail");
                String gender = (String) jsonobject.get("gender");
                String department = (String) jsonobject.get("department");
                String reasonToJoin = (String) jsonobject.get("reasonToJoin");
                
                students.add(new Student(firstName,lastName,studentID,studentEmail,gender,department,reasonToJoin));

            }
        }
        catch(Exception e){   
        }
    }
}
