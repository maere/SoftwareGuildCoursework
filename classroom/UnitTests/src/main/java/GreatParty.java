/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class GreatParty {
    
    public boolean greatParty(int cigars, boolean isWeekend){
        if (isWeekend){
            if (cigars >=40){
                return true;
            } else if (cigars==20){
            return true;
            }
            else{return false;}
      
        } else {
            if (cigars>=40 && cigars<=60){
                return true;
            }
            else {
                return false;
            }
        
        }
    }
    public int numberOfGuests(){
        return 35;
    }
}
