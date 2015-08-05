/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.codingbatproblems;

/**
 *
 * @author apprentice
 */
public class MakeTags {

    public String makeTags(String tag, String word) {

        StringBuilder addTags = new StringBuilder("<></>");
       
        int tagCharNum = tag.length();
          
        addTags.insert(4, tag);
        addTags.insert(1, tag);
               
        int insertPoint = tagCharNum + 2;
        
        addTags.insert(insertPoint, word);
        
        //System.out.println(addTags);
        
        String out = addTags.toString();
        return out;
    }

    

}
