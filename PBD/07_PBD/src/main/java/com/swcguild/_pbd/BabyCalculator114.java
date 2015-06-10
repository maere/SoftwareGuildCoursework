/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild._pbd;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class BabyCalculator114 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

		double a, b, c; //takes decimals
		String op; // takes a sign that is an operator

		do
		{
			System.out.print("> "); //signalling the expression
			a  = keyboard.nextDouble(); //number 1
			op = keyboard.next(); //operator
			b  = keyboard.nextDouble(); //number 2

			if ( op.equals("+") ) //evaluates operator
				c = a + b; //simple expression (could break out as a method)
                        else if(op.equals("-")){
                                c = a - b;
                        }
                        else if(op.equals("*")){
                                c = a * b;
                        }
                        else if(op.equals("/")){
                                c = a/b;
                        }
			else
			{
				System.out.println("Undefined operator: '" + op + "'.");
				c = 0;
			}

			System.out.println(c);

		} while (a!=0.0);
    }
    
}

//must add, subtract, mutiply and divide
//must loop until user enters "0" for the first of the two numbers
