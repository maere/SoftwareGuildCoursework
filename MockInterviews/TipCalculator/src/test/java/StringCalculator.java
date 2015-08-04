/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class StringCalculator {

    public int add(String strArgs) throws Exception {

        return sum(strArgs.split(","));
    }

    int add(String strArgs, String delimiter
            
    ) throws Exception {
        return sum(strArgs.split(delimiter));
    }

    //"1,-4,-2"
    private int sum(String[] nums) throws Exception {

        String exMessage = "Negatives Not Allowed: ";

        int result = 0;
        for (int i = 0; i < nums.length; i++) {

            if (Integer.parseInt(nums[i]) < 0) {
                exMessage = exMessage + nums[i] + ",";
                
            } else {
                result += Integer.parseInt(nums[i]);
            }

        }

        if (!"Negatives Not Allowed: ".equals(exMessage)) {
            String finalExMessage = exMessage.substring(0, exMessage.length()-1);//will need to remove the last comma from the string using a substring methodZ
            
            throw new Exception(finalExMessage);
        }

        return result;
    }

    //when going through loop, will need an intermediate step where I check for negative values before adding 
    //and if true, store in array so I can add them to my string
    //soutmessage will iterate trhough negatives array and add to string
}
