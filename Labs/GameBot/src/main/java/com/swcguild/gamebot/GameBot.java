/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.gamebot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class GameBot {
    //is our controller--doen't implement
    
    //private int gameChoice;
    //private Integer gameNumber;
    ConsoleIO con = new ConsoleIO();
    
    //Map<String, Game> games = new HashMap<>(); 
    //array list might have been better...could just call up by number vs. title
    ArrayList<Game> gameLineUp = new ArrayList<>();
    
 
    public void loadGames(){
        //if a dev wants to add new games they need to do it here....
        
        //there are two methods of adding the objects:
        //to instantiate with a name and then add (last item)...
        Game blackjack = new BlackjackRf();
        //games.put("Blackjack", blackjack);
        
        //or to just instantiate the object directly, which adds the object, bypassing naming
        //games.put("rpsRf", new RockPaperScissorsReFactor());
        
        Game luckysevens = new  LuckySevensRf();
         //games.put("Lucky Sevens", luckysevens);
         
        Game rps = new RockPaperScissorsReFactor();
        //games.put("Rock, Paper, Scissors", rps);
        
        gameLineUp.add(0, blackjack);
        gameLineUp.add(1, luckysevens);
        gameLineUp.add(2, rps);
        

    }
   
    //List all game -- main menu
    public void listGameMenu(){
        //after you load a game to the Array list you need to add it to this menu:
        con.print("Here are a list of games you can play: \n"
                + "1. Blackjack \n"
                + "2. Lucky Sevens \n"
                + "3. Rock, Paper, Scissors \n");
        //if refactoring, could tie this into the ArrayList and have the games listed by iterating through the HashMap
        //and use the .getGameTitle method provided by the interface to plug in the game names programatically as well
        //would need to get the size() of the ArrayList to spit out the numbers on the menu
        //so the menu would be generated on the fly after a game was added--wouldn't have to rewrite this method
        //everytime you add a new game--just .add in loadGames method, and implement the inteface methods --moving the 
            //run to gameRun and giving the game a name
    }
 
    
    ///Executes the game the user selected -- run()
    public void run(){
    //loadGames into the ArrayList
        loadGames();  //should this require an integer in the interface?
        listGameMenu();
        Game gameChoice = getGameObject();//gets the game object from the hash map by Tile (or number--if we refactor)
        //this next method has to call the .runGame() method on an instance of a Game obeject 
        gameChoice.runGame();

    }
    
 
    //Asks users which the what to play -- con. get integer
    public Game getGameObject(){
        //gameTitle = con.readString("Please enter the name of the game you want to play.");
        //return games.get(gameTitle);  
        
    //changed to receive integer from menu/array list (not string and hashmap)
        int userNumberChoice = con.readInt("Please enter the menu number of the game you would like to play: \n");
        return gameLineUp.get(userNumberChoice-1); //this returns the game object of their choice
    
    }
    
     
    
    
    //after completeion of game, goes back to step 1 -- while loop

    
        
    }
    
    
