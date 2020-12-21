package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe 
{
    static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
    static ArrayList<Integer> player2Positions = new ArrayList<Integer>();
    
    public static void main(String[] args) 
    {
        char[][] gameBoard = { 
            {' ' , ' ' , ' ' , '|' , ' ' , ' ' , ' ' , '|' , ' ' , ' ' , ' '} , 
            {'-' , '-' , '-' , '+' , '-' , '-' , '-' , '+' , '-' , '-' , '-'} , 
            {' ' , ' ' , ' ' , '|' , ' ' , ' ' , ' ' , '|' , ' ' , ' ' , ' '} , 
            {'-' , '-' , '-' , '+' , '-' , '-' , '-' , '+' , '-' , '-' , '-'} , 
            {' ' , ' ' , ' ' , '|' , ' ' , ' ' , ' ' , '|' , ' ' , ' ' , ' '} };
        
        printGameBoard(gameBoard);
        
        while(true)
        {
            Scanner in = new Scanner(System.in);
            
            // player1
            System.out.print("Enter your placement (1-9) Player1: ");
            int player1Pos = in.nextInt();
            while(player1Positions.contains(player1Pos) || player2Positions.contains(player1Pos))
            {
                System.out.println();
                System.out.print("Position taken! Enter another position: ");
                player1Pos = in.nextInt();
            }
            System.out.println();
            placePiece(gameBoard , player1Pos , "player1");
            printGameBoard(gameBoard);
            
            checkWinner();

            // player2
            System.out.print("Enter your placement (1-9) Player2: ");
            int player2Pos = in.nextInt();
            while(player1Positions.contains(player2Pos) || player2Positions.contains(player2Pos))
            {
                System.out.println();
                System.out.print("Position taken! Enter another position: ");
                player2Pos = in.nextInt();
            }
            System.out.println();
            placePiece(gameBoard , player2Pos , "player2");
            printGameBoard(gameBoard);
        }
    }
    
    public static void printGameBoard(char[][] gameBoard)
    {
        for(char[] row : gameBoard)
        {
            for(char c : row)
            {
                System.out.print(c);
            }
        System.out.println();
        }
        System.out.println();
    }
    
    public static void placePiece(char[][] gameBoard , int pos , String user)
    {
        char symbol = ' ';
        
        if(user.equals("player1"))
        {
            symbol = 'X';
            player1Positions.add(pos);
        }
        
        else
        {
            symbol = 'O';
            player2Positions.add(pos);
        }
            
    
        switch(pos)
        {
            case 1:
                gameBoard[0][1] = symbol;
                break;
                
            case 2:
                gameBoard[0][5] = symbol;
                break;
                
            case 3:
                gameBoard[0][9] = symbol;
                break;
                
            case 4:
                gameBoard[2][1] = symbol;
                break;
                
            case 5:
                gameBoard[2][5] = symbol;
                break;
                
            case 6:
                gameBoard[2][9] = symbol;
                break;
                
            case 7:
                gameBoard[4][1] = symbol;
                break;
                
            case 8:
                gameBoard[4][5] = symbol;
                break;
                
            case 9:
                gameBoard[4][9] = symbol;
                break;
            
            default:
                System.out.println("Invalid position, please try again!");
                System.out.println();
                System.exit(0);
        } 
    }
    
    public static void checkWinner()
    {
        List topRow = Arrays.asList(1 , 2 , 3);
        List midRow = Arrays.asList(4 , 5 , 6);
        List botRow = Arrays.asList(7 , 8 , 9);
        List leftCol = Arrays.asList(1 , 4 , 7);
        List midCol = Arrays.asList(2 , 5 , 8);
        List rightCol = Arrays.asList(3 , 6 , 9);
        List cross1 = Arrays.asList(1 , 5 , 9);
        List cross2 = Arrays.asList(3 , 5 , 7);
        
        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);
        
        for(List list : winningConditions)
        {
            if(player1Positions.containsAll(list))
            {
                System.out.println("Congratulations Player1 you won!!! :D\nSorry player2 D:");
                System.exit(0);
            }
            
            else if(player2Positions.containsAll(list))
            {
                System.out.println("Congratulations Player2 you won!!! :D\nSorry player1 D:");
                System.exit(0);
            }
            
            else if(player1Positions.size() + player2Positions.size() == 9)
            {
                System.out.println("The match is a draw!!!");
                System.exit(0);
            }
        }
    }
}
