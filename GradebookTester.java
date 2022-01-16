public class GradebookTester {
   public static void main(String[] args) {
      Gradebook comp101 = new Gradebook();
      
      comp101.addStudent( "njohnson" , "Noah" , "Johnson" );
      comp101.addStudent( "gsmith" , "George" , "Smith" );

      comp101.addAsmt("Ch1 Quiz", 10);
      comp101.addAsmt("Final Exam", 70);
      comp101.addAsmt("Ch3 Quiz", 10);
      comp101.addAsmt("Ch2 Quiz", 10);
      
      comp101.setGrade("njohnson", "Ch1 Quiz", 93.2);
      comp101.setGrade("gsmith", "Ch1 Quiz", 97.2);
      //comp101.setGrade("gjohnson", "Ch1 Quiz", 97.2);
      comp101.setGrade("njohnson", "Ch3 Quiz", 97.2); 
      comp101.setGrade("njohnson", "Ch2 Quiz", 93.2); 
      // comp101.setGrade("njohnson", "Final Exam", 93.2);
     
      // System.out.println(comp101.getGrade("njohnson", "Ch1 Quiz"));
//       System.out.println(comp101.getGrade("gjohnson", "Ch1 Quiz"));
//       System.out.println(comp101.getGrade("njohnson", "Ch3 Quiz"));
      // System.out.println(comp101.getCurrentGrade("njohnson"));
       System.out.println(comp101.getAsmtAverage("Ch1 Quiz"));
       System.out.println(comp101.getAsmtAverage("Final Exam"));
   } 
} 