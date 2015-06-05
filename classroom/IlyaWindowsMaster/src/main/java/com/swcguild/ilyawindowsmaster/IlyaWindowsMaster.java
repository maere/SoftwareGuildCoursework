/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.ilyawindowsmaster;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class IlyaWindowsMaster {
     public static void main(String[] args) {

        float height;
        float width;
        String stringHeight;
        String stringWidth;
        float areaOfWindow;
        double cost;
        float perimeterOfWindow;
        
Scanner sc = new Scanner(System.in);

height = readUserInputFloatWithRange("give me your height", 0, 20);
/*
System.out.println("Please enter window height:");
stringHeight = sc.nextLine();
height = Float.parseFloat(stringHeight)

System.out.println("Please enter window width:");
stringWidth = sc.nextLine();
width =Float.parseFloat(stringWidth);
*/

//height = method("Please enter window height.", 15, 1);
//width = Validator("Please enter window width.", 15, 1);

areaOfWindow = height * width;
perimeterOfWindow = 2*(height + width);
cost = ((3.50f * areaOfWindow)+(2.25f*perimeterOfWindow));
System.out.println("Window height = " + height);//stringHeight);
System.out.println("Window width = " + stringWidth);
System.out.println("Window area = " + areaOfWindow);
System.out.println("Window perimeter = " + perimeterOfWindow);
System.out.printf("Total Cost = %.2f\n", cost);
} 
     /*
      public static float readUserInputFloat(String prompt) //indciate type and parameter name
        {
            Scanner sc = new Scanner(System.in);
            System.out.println(prompt);
            String stringInput  = sc.nextLine(); //we can't reuse our height var, so we have to declare an agnostic one
            //float result = Float.parseFloat(StringInput);
            //return result;
            return Float.parseFloat(stringInput); //condensed the two lines above
        }
     */
//COMMENT: I was not able to glue together your WindowMaster code with our pair validation code
//so this was not a successful experience for me.
        public static float readUserInputFloatWithRange(String prompt, float min, float max){
            
            Scanner sc = new Scanner(System.in); 
            float result =0; //need to declare outside
            
            do{  
            System.out.println(prompt + "[" +min+", "+max+"]:"); //our message to user
            String stringInput = sc.nextLine(); // pulls in token
            result = Float.parseFloat(stringInput); //assign generic result inside
            
            }while(result < min || result > max); // while the result is bad, keep prompting
            
            return result; // our method returns the user input for height to the call ONLY IF it's a valid number
                          // so our height variable is not assigned unless valid--this is the purpose
                          // of calling the function for the variable assignment
            
          
      }
    
}
