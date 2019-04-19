/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintenance_selenium;

/**
 *
 * @author minarafla
 */
public class Student {
     String firstname;
     String lastname;
     String studentID;
     String studentEmail;
     String gender;
     String department;
     String reasons;
    
    public Student(String firstname, String lastname, String studentID, String studentEmail, String gender, 
            String department, String reasons){
        this.firstname=firstname;
        this.lastname=lastname;
        this.studentID=studentID;
        this.studentEmail=studentEmail;
        this.gender=gender;
        this.department=department;
        this.reasons=reasons;
    }
    
    String getFirstName(){
        return firstname;
    }
    String getLastName(){
        return firstname;
    }
    String getStudentID(){
        return firstname;
    }
    String getGender(){
        return firstname;
    }
    String getDepartment(){
        return firstname;
    }
    String getReasons(){
        return reasons;
    }

    
    
}
