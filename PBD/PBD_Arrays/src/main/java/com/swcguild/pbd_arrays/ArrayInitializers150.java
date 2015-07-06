/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_arrays;

/**
 *
 * @author apprentice
 */
public class ArrayInitializers150 {
    public static void main(String[] args) {
        String[] arr1 = { "alpha", "bravo", "charlie", "dogpatch", "echo" };

		System.out.print("The first array is filled with the following values:\n\t");
                
		for ( int i=0; i<arr1.length; i++ )
                {
                System.out.print( arr1[i] + " " );
		System.out.println();
                
                }
			
                int [] arr2 = {11, 22, 33, 44, 55};
                
                System.out.println("The second array contains: ");
                
                for(int i=0; i<arr2.length; i++){
                    System.out.println(arr2[i] + " ");
                }
    }
    
}
