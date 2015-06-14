/*.addS
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.studentquizgrades;

/**
 *
 * @author Clay McMullen
 */
public class StudentQuizApp {
    public static void main(String[] args) {
       Class course = new Class();
       
       Student bob = new Student("bob");
       bob.addScore(100);
       bob.addScore(10);
       bob.addScore(72);
       bob.printStudentScore("bob");

       Student jim = new Student("jim");
       jim.addScore(100);
       jim.addScore(90);
       jim.addScore(42);
       jim.printStudentScore("jim");

       Student jane = new Student("jane");
       jane.addScore(1007);
       jane.addScore(10);
       jane.addScore(72);
       jane.printStudentScore("jane");

       course.addStudent("bob",bob);
       course.addStudent("jane", jane);
       course.addStudent("jim", jim);

       course.viewAllStudents();
       bob.averageScore();
       
       
    }
}
