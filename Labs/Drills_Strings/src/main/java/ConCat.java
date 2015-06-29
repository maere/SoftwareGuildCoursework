/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class ConCat {

    public String ConCat(String a, String b) {

        String newString;

        if (a.charAt(a.length() - 1) == b.charAt(0)) { //(a.charAt(a.length()-1) == b.charAt(0))
            String subB = b.substring(1);
            newString = a.concat(subB);
        } else if ("".equals(a) || "".equals(b)) {
            if (!a.isEmpty()) {
                newString = a;
            } else {
                newString = b;
            }

        } else {

            newString = a.concat(b);

        }
        return newString;
    }

}

/*
 Given two strings, append them together (known as "concatenation") and return the result. 
 However, if the concatenation creates a double-char, then omit one of the chars, 
 so "abc" and "cat" yields "abcat". 

 //ConCat("abc", "cat") -> "abcat"
 //ConCat("dog", "cat") -> "dogcat"
 //ConCat("abc", "") -> "abc"


 */
