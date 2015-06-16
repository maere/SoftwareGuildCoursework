/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classroster;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author apprentice
 */
public class ClassRosterController {
    //add our ConsoleIO to our ClassRosterControllerClass -- it's in the same package so it shouldn't be a probleym
    private ConsoleIO con = new ConsoleIO();
    
    //now that we have added our ClassRoster stuff, we need to instantiate one into THIS particular controller class
    private ClassRoster roster = new ClassRoster();
    
    //we create a run method to run all of our methods for this controller class
    public void run() throws IOException{
        
        //we will put this into a while loop and controll with a boolean (stop/start)
        boolean keepGoing = true;
        int menuSelection = 0;
        
        
        try{
                roster.loadRoster(); //this filewriting is handles in ClassRoster data class
                while(keepGoing) {
                    printMenu();
                    menuSelection = con.readInt("Please select from the above choices.", 1, 5); //have to set the result to a variable

                        switch (menuSelection) {
                    case 1:
                        con.print("Listing Student IDs...");
                        listStudents(); //doesn't exist yet, will build--the IDE let's you click on the error and will create the method structure for you below
                        break;                                          //way to code faster                   
                    case 2:
                        con.print("We're creating student...");
                        createStudent();
                        break;
                    case 3:
                        con.print("Viewing student info...");
                          viewStudent();
                        break;
                    case 4:
                        con.print("Removing Studen....");
                          removeStudent();
                        break;
                    case 5:
                        con.print("Exiting....");
                          keepGoing = false;
                        break;
                    default:
                        con.print("Unknown Input.");
                        }    
                //let's put the menu together
                /*
                while(keepGoing){
                    printMenu(); // we know we will create a menu method -- see below
                                            //to use Console IO we need a console IO object--which we instantiated above--we will use htis obj everytime we want input
                    menuSelection = con.readInt("Please select from the above choices.", 1, 5); //this is the first time we use our console IO class to request info
                                              //readInt is an overloaded method--so we can also pass in our min and max as parameters
                }; //while loop has a semicolon!
                */        
                }
                
                //after we exit our while loop we 
                con.print("Thank you for using our system.");
                roster.writeRoster(); //need to write this method now for the data -- had to import for both classes--this one, as well as the class we made writeRostyer in
               
            }catch (FileNotFoundException e)
                {
                System.out.println("Error loading roster");
            } catch (IOException e)
            {
                System.out.println("Errory writing to file");
            }
        
        
    }
        
        
  

    
    
    //menu
    public void printMenu(){
    con.print("Main Menu:");  //console IO will prevent us from using anything besides these
    con.print("1. LIst Student IDs");
    con.print("2. create new student");
    con.print("3. View a studeent");
    con.print("4. Remove student");
    con.print("5. Exit");
    }
    
    //we'll put our methods for accessing student data in the controller along with the printMenu method
 

    private void listStudents() {
        
        //we declare a private variable for our listStudents method....but we haven't created getAllStudentIds method yet
      String[] studentIds = roster.getAllStudentIds();
      
      for(int i=0; i<studentIds.length; i++)
        {
          Student currentStudent = roster.getStudent(studentIds[i]); // we are creating a variable of type student
          con.print(studentIds[i] + ":" + currentStudent.getFirstName() + " " + currentStudent.getLastName());          //
         
        }
      con.readString("Please hit enter to continue."); //another console IO bit
    }

    private void createStudent() { //this is the function/object that will allow us to input a student
      String studentId = con.readString("Please enter student ID");
      String firstName = con.readString("Please enter first name");
      String lastnname = con.readString("Please enter last name.");
      String cohohort = con.readString("Please enter cohort.");
      
      Student currentStudent = new Student(studentId); //here's our abstraction of the instantiation on the fly
      currentStudent.setFirstName(firstName); //it uses the getters and setters of the class to do this
      currentStudent.setLastName(lastnname);
      currentStudent.setCohort(cohohort);
      
      roster.addStudent(studentId, currentStudent); //in this method we ask the roster object/class
                                    //to do some data retrieval/removal...for us on behalf of the user
      con.readString("Student successfully created. Please hit enter to continue.");
                                    //we communicate back ot the user
    }

    private void viewStudent() {
        
      String studentId = con.readString("Please enter id for student");
      Student currentStudent = roster.getStudent(studentId); //variable of Type student is equal to the given student id from the roster
        if (currentStudent != null)
          {
              con.print(currentStudent.getStudentId());
              con.print(currentStudent.getFirstName() + currentStudent.getLastName());
              con.print(currentStudent.getCohort());
              con.print("");
          }
        else{
            con.print("There is no student with ID " + studentId);
        }
                
        con.readString("Please hit enter to continue.");
    }

    private void removeStudent() {
        String studentId = con.readString("Please enter ID");
        roster.removeStudent(studentId); //this is not recursive, we are making another method called removeStudent for the data object as well
        con.readString(studentId);
    }

  
}
