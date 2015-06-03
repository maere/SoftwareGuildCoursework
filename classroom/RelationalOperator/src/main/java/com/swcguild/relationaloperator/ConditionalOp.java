/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.relationaloperator;

/**
 *
 * @author apprentice
 */
public class ConditionalOp {
    public static void main(String[] args) {
        //!=
        boolean test = true;
            System.out.println("Not true => "+ !test);
                        
        //toggle 
            test = !test; //just changed the value....
            System.out.println("Not true => " + !test);
            
           // true && true == true;
            //anything && false == false;
            test = (5>7 && 3<4);
            
            //ranges
            
            int ourValue = 7;
            test = (ourValue > 6) && (ourValue<13); 
            
            System.out.println("ourValue is in range (6..13) =>"+ test);//this is exclusive
            //to make inclusive, change value to <= 
            
            ourValue = 13;
            test = (ourValue > 6) && (ourValue<=13); //this will be true
            System.out.println("ourValue is in range (6..13] =>"+ test);
            
            //outn of range (15..42] using or -- round bracket is inclusive, square bracket is exclusive
            ourValue = 11; // 11 is less than 11 so is outside of the range
            //test == (ourValue>15) || (ourValue<42); //this will eval == before || and cause error!
            test = ((ourValue<=15) || (ourValue>42));
            System.out.println("this test is " + test);
            //exclusive excludes the value
            //inclusive includes the value named
            
            
            //XOR
            // (true^true) ==false-- if both are true returns false 
            // if only one value is true this expression/condition returns true
               //(false^false)  // if both are false....is also false
            
            //so with this test we can check if a number is in either range
            //so we'll pass two ranges and look for it to be in one or the other
            ourValue = 15;
            test = (ourValue ==15)^(ourValue ==17);
            System.out.println("This 15 or 17 test evaluates to ==>"+test);
         
            ourValue = 18;
            test = (ourValue ==15)^(ourValue ==17);
            System.out.println("With " + ourValue + " This 15 or 17 test evaluates to ==>"+test);
            
            //value is in [0.20] or in (15..42)exclusively -- there is an overlap 15-10
            ourValue = 17;
            test = (ourValue>=0 && ourValue<=20)^(ourValue>15 && ourValue<42);
            System.out.println("test value is "+ test);
            
            
    }       
    
}
