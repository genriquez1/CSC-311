/* ********************************************************************************* *
 * Gerardo Enriquez																	 *
 * CSC 311 Data Structures														 	 *
 * Project 1																	 	 *
 * 02/22/2017																	 	 *
 * This Project is on using Arrays to simulate an NFL draft 						 *
 * for Chaterjee's CSC 311 Data Structures class, Spring 2017 Semester				 *
 * at CSU Dominguez Hills.															 *
 * For this project I exchanged ideas with classmates Kris Giddens and Mario Aguirre *
 * along with additional method tips from Jacob Gharibian 						 	 *
 * ********************************************************************************* *
 */

import java.util.*;	//Import statment


public class NFLDraft1 
{   
	//Declaration
	private static final String[] firstRoundDraft = new String[8];
	private static final String[] secondRoundDraft = new String[8];
	private static final String[] thirdRoundDraft = new String[8];
	private static final String[] fourthRoundDraft = new String[8];
	private static final String[] ranked = new String[8];
    private static final String [][] playerRounds = new String[2][32];
	
	//Main Method
    public static void main (String[] args) 
    {
        //Array of Teams
        String[] teams = {"Team 1","Team 2","Team 3","Team 4",			
                          "Team 5","Team 6","Team 7","Team 8"};
        //Array of Players
        String[] players = {"Player 1","Player 2","Player 3","Player 4","Player 5", "Player 6", "Player 7", "Player 8",
                            "Player 9","Player 10","Player 11","Player 12","Player 13","Player 14","Player 15",
                            "Player 16","Player 17","Player 18","Player 19","Player 20","Player 21","Player 22","Player 23",
                            "Player 24","Player 25","Player 26","Player 27","Player 28","Player 29","Player 30","Player 31","Player 32"};
        teamSorting(teams);
        playerSorting(players);
        nflDraft();
    } 
    // Sort Method in args, assigns random percents to teams each time it is iterated 
    //After it sorts them and prints them from 
    public static void teamSorting(String[] teams)
    {   	
    	    String[][] teamWinLoss = new String[2][8];
    	
    	    double winpercent;
    	    double[] winRatio = new double[8];
    	     	    
        System.arraycopy(teams, 0, teamWinLoss[0], 0, 8); 	//copys team array to teamwinloss
        
        System.out.println("TEAM:\tPercentage: \n");
        for (int i = 0; i < 8; i++)
        {
            winpercent = (int)(Math.random()* 10001.0)/100.0;    // used Math.random to generate random win percentage 
            teamWinLoss[1][i] = String.valueOf(winpercent); 	// and 10001.0... to truncate
            
            System.out.println(teamWinLoss[0][i] + " won " + teamWinLoss[1][i] + "% percent of their games last season!"); 
        }
        
        for(int i = 0; i < 8; i++)
        {
            winRatio[i] = Double.parseDouble(teamWinLoss[1][i]);
        }
        
        Arrays.sort(winRatio);
        
        System.out.println("\nBased On Win Percentage: \n");  
     
        for(int i = 0; i < 8; i++)
        {   
            for(int j = 0; j < 8; j++)
            {
                if(Double.parseDouble(teamWinLoss[1][i]) == winRatio[j])
                {
                    ranked[j] = teamWinLoss[0][i];
                    System.out.println("The " + teamWinLoss[0][i] + " is ranked " + (j+1));
                }
            }
        }
        
        System.out.println();
    }

	//Player sorting using random number generator
    //Reference Java from the ground up
    public static void playerSorting(String[] players) 
    {       	
    	int round1 = 0;
    	int round2 = 0;
    	int round3 = 0;
    	int round4 = 0;
    	int draft1 = 0;
    	int draft2 = 0;
    	int draft3 = 0;
    	int draft4 = 0;
    	Random numberGenerator = new Random();
        int round;
    	
        System.arraycopy(players, 0, playerRounds[0], 0, 32); 
      
        do 
        {
            for (int i = 0; i < 32; i++)
            {   
                round = numberGenerator.nextInt(4) + 1;
            
                if(round == 1 && round1 < 8 && playerRounds[1][i] == null)
                {
                    playerRounds[1][i] = String.valueOf(round);
                    ++round1;
                }
         
                if(round == 2 && round2 < 8 && playerRounds[1][i] == null)
                {
                    playerRounds[1][i] = String.valueOf(round);
                    ++round2;
                }

                if(round == 3 && round3 < 8 && playerRounds[1][i] == null)
                {
                    playerRounds[1][i] = String.valueOf(round);
                    ++round3;
                }

                if(round == 4 && round4 < 8 && playerRounds[1][i] == null)
                {
                    playerRounds[1][i] = String.valueOf(round);
                    ++round4;
                }
            }
        }
        while (round1 < 8 || round2 < 8 || round3 < 8 || round4 < 8);  // while loop that sorts players into their respective round
        															  
        for (int i = 0; i < 32; i++)
        {
            System.out.println(playerRounds[0][i] + " has been selected to drafted in round " + playerRounds[1][i]); // print results
        }
        
        
        for (int i = 0; i < 32; i++)   // for loop that places players into their round/array 
        {
        	        	         	 
            if(Integer.parseInt(playerRounds[1][i]) == 1)				// Round 1
            {
                firstRoundDraft[draft1] = playerRounds[0][i];
                draft1++;
            }
            
            if(Integer.parseInt(playerRounds[1][i]) == 2)			// Round 2
            {
                secondRoundDraft[draft2] = playerRounds[0][i];
                draft2++;
            }
            
            if(Integer.parseInt(playerRounds[1][i]) == 3)			// Round 3
            {
                thirdRoundDraft[draft3] = playerRounds[0][i];
                draft3++;
            }
            
            if(Integer.parseInt(playerRounds[1][i]) == 4)			// Round 4
            {
                fourthRoundDraft[draft4] = playerRounds[0][i];
                draft4++;
            }
        }
        
        System.out.println(); 
    } 
    
    
    // Start of Draft
    public static void nflDraft() 
    {
    	
    	
    	Integer[] draftPicks = {0,1,2,3,4,5,6,7};  // 8 total picks per round
    	    	
        Collections.shuffle(Arrays.asList(draftPicks));    // Collections Shuffle method used to shuffle from 1 -7 
                
        for(int i = 0; i < 8; i++)
        {
            System.out.println("Round :1 Team:  " + ranked[i] + " selected: " + firstRoundDraft[draftPicks[i]]);
        }
        
        Collections.shuffle(Arrays.asList(draftPicks));		// Collections Shuffle method used to shuffle from 1 -7 
        System.out.println(); 
        for(int i = 0; i < 8; i++)
        {
            System.out.println("Round :2 Team:  " + ranked[i] + " selected: " + secondRoundDraft[draftPicks[i]]);
        }
        
        Collections.shuffle(Arrays.asList(draftPicks)); 	// Collections Shuffle method used to shuffle from 1 -7 
        System.out.println();
        
        for(int i = 0; i < 8; i++)
        {
            System.out.println("Round :3 Team:  " + ranked[i] + " selected: " + thirdRoundDraft[draftPicks[i]]);
        }
        
        Collections.shuffle(Arrays.asList(draftPicks)); 	// Collections Shuffle method used to shuffle from 1 -7 
        System.out.println(); 
			
        for(int i = 0; i < 8; i++)
        {
            System.out.println("Round :4 Team:  " + ranked[i] + " selected: " + fourthRoundDraft[draftPicks[i]]);
        }
		
    } 
	
   
} 