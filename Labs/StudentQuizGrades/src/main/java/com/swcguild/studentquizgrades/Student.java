/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class Student {
    String name;
    ArrayList<Integer>quizScores;
    Map<String, ArrayList<Integer>> studentQuizzes;
    
    public Student(String name)
    {
        studentQuizzes = new HashMap<>();
        quizScores = new ArrayList<>();
        this.name = name;
    }
    
    
    public void printStudentScore(String studentName)
    {
        System.out.println("This student's quiz scores are: "+quizScores);
    }
    
    public void addScore(int testScore)
    {
        quizScores.add(testScore);
    }
    
    public void averageScore()
    {
        int total=0;
        int count=0;
//        for(int i=0; i<quizScores.size()-1;i++)
//        {
//            total+=quizScores
//        }
        for(int k: quizScores)
        {
            count++;
            total+=k;
        }
        System.out.println("This student's average score is "+total/count);
    }
    
    
}
