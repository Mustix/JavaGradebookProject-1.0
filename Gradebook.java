import java.util.ArrayList;
import java.util.ListIterator;
import java.util.*;

public class Gradebook {
   double grades[][];     // First index is assignment, second index is student
   boolean isGradeSet[][];
   ArrayList students = new ArrayList();
   ArrayList asmts =  new ArrayList();
   
   
   private class Student {
      String stuID;
      String firstName;
      String lastName;
      
   }

   private class Asmt { 
      String name;
      double weight;
   }


   public Gradebook() {
   }  
   
   public void addStudent(String parmStuID, String parmFirstName, String parmLastName) { 
      Student aStu = new Student();
      aStu.stuID = parmStuID;
      aStu.firstName = parmFirstName;
      aStu.lastName = parmLastName;
      this.students.add(aStu);
      
   }
      
   
   public void addAsmt(String parmName, double parmWeight) { 
      Asmt aAsmt = new Asmt();
      aAsmt.name = parmName;
      aAsmt.weight = parmWeight;
      this.asmts.add(aAsmt);
   } 
 
   public int getStuPos(String parmStuID) { 
      int stuIdx = 0;
      Student aStu;
      ListIterator stuIter = students.listIterator();
         while (stuIter.hasNext()) {
            aStu = (Student)stuIter.next();
            if (aStu.stuID == parmStuID){
               break;
            }
            stuIdx++;
            if (stuIdx >= students.size()) {      
               System.out.println("Student ID not found " + parmStuID);
               return -1;  
            }   
         } return stuIdx;
    }  
    
    
    
   public int getAsmtPos(String parmAsmtName) {
      int asmtIdx = 0;
      Asmt aAsmt;
      ListIterator aAsmtIter = asmts.listIterator();
      while (aAsmtIter.hasNext()) {
         aAsmt = (Asmt)aAsmtIter.next();
         if (aAsmt.name == parmAsmtName){
         break;
         }
            asmtIdx++;
      }
       
           // Did we find a matching Asmt name?
           if (asmtIdx >= asmts.size()) {      
               System.out.println("Assigment name not found " + parmAsmtName); 
               return -1; 
           }
           return asmtIdx;
   }
   
 
   public void setGrade(String parmStuId, String parmAsmtName, double parmGrade) { 
   
      // If this is the first call to setGrade, allocate the 2 dimensional array of doubles called "grades"
      //     Simplified example:  grades = new double[3][5];
     
      if (grades == null) {
          grades = new double[asmts.size()][students.size()];
          isGradeSet = new boolean[asmts.size()][students.size()];   
      }
   
      int stuIdx = 0;
      stuIdx = getStuPos(parmStuId);
      if (stuIdx >= 0) {
      
          int asmtIdx = 0; 
          asmtIdx = getAsmtPos(parmAsmtName);
          if (asmtIdx >= 0) {
 
               // Now put the grade into the 2 dimensional array of grades
                grades[asmtIdx][stuIdx] = parmGrade;                   
                isGradeSet[asmtIdx][stuIdx] = true;
           }
       }

  }
   
  public double getGrade(String parmStuId, String parmAsmtName) { 
      
      int stuIdx = 0;
      int asmtIdx = 0;
      stuIdx = getStuPos(parmStuId);
      if (stuIdx >= 0) {
         asmtIdx = getAsmtPos(parmAsmtName);
         if (asmtIdx >= 0) {
            return grades[asmtIdx][stuIdx];     
         } 
      }
      return -1.0;
   }
   
   
public double getCurrentGrade(String parmStuID) { 
        // System.out.println("Gradebook method getCurrentGrade starting");
        Student aStu;
        Asmt aAsmt;
        Integer stuPos;
        Integer asmtPos;
        double totalWeights = 0;
        double sumWeightedGrades = 0;

        // Find the index of this student in the stuList
        stuPos = getStuPos(parmStuID);
        if (stuPos >= 0) {

            // Loop through all the grades for this student
            for (asmtPos = 0; asmtPos < asmts.size(); ++asmtPos) {
                if (isGradeSet[asmtPos][stuPos]) {
                    totalWeights += ((Asmt)asmts.get(asmtPos)).weight;
                    sumWeightedGrades += grades[asmtPos][stuPos] * ((Asmt)asmts.get(asmtPos)).weight;
                }
            }
        }
        if (totalWeights > 0) {
            return sumWeightedGrades / totalWeights;
        } else {
            System.out.println("Gradebook method getCurrentGrade: No grades set for student ID: " +
                    parmStuID);
            return -1;
        }
    }

        
       // Get the index of student parmStuId in the 2-dimension arrays
       // set the total grade to 0
       // Loop thru the assignments for this student 
       //     if a grade for this assigment has been set then 
       //         add this grade to the total grade
       //         BUT: deal with the weighting factor
       //     End if
       // End Loop  
       // Calculate average grade from the total grade   
     public double getAsmtAverage(String parmAsmts) { 
         int asmtIdx = 0;
         double sum = 0;
         double aAsmtAverage = -1.0;
         int i;
         int counterGrade = 0;
         asmtIdx = getAsmtPos(parmAsmts);
         
         if (asmtIdx >= 0) { 
            for (i = 0; i < students.size(); i++) { 
               if (isGradeSet[asmtIdx][i] == true) { 
                  sum = sum + grades[asmtIdx][i];
                  counterGrade++;
               }
            } 
            if ( counterGrade == 0) { 
                  System.out.println("No Grades set for assigment " + parmAsmts);
            } else {
                  aAsmtAverage = sum /counterGrade;
            }   
            return aAsmtAverage;  
         }
         return aAsmtAverage;  
      }
}

