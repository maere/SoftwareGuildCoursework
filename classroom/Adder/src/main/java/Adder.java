
import java.util.Scanner; //had to import the Scanner package

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Adder { //declaring a class
    public static void main(String[] args) { //our entry and main is the function...is a static function
        int sum=0;
        
        int op1 = 3;
        int op2 = 2;
        //we had to import the Scanner library/package
        Scanner sc = new Scanner(System.in);  //we instantiate this object and declare it as the variable sc
       //System.in is an enum--he doesn't want to explain yet, but takes either:
        //an input stream object as a paramenter (System.in) or a file reader (...
        //(new FileReader("myFile"))
        //see http://www.cs.utexas.edu/users/ndale/Scanner.html
        
        String strOp1 = ""; //here we declare and assigns an empty string
        String strOp2 = "";
        
        System.out.println("Please enter the first number to add.");
        strOp1 = sc.nextLine(); //changes value of the prev decl var to the user's console input
                    //this method waits for user input and returns line without line separator at end (/n)
        //other options are nextInt(),next(), nextFloat()...and void close() closes the scanner
        
        System.out.println("Please enter the next number to add.");
        strOp2 = sc.nextLine(); //this is a method that belongs to the scanner class
        
        op1 = Integer.parseInt(strOp1); //this does type conversion from string to int--must look like an int
        op2 = Integer.parseInt(strOp2);
        
        
        sum= op1 +op2;
        
        System.out.println("sum is:" + sum); //println prints what we pass as param
    }
    
}
