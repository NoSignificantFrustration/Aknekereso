/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknakereso;

import java.util.Scanner;

/**
 *
 * @author Bendegúz
 */
public class Aknakereso {

   private static Board myBoard = new Board(10, 20);
   private static boolean alive = true;
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        DisplayBoard();
        do {            
            
        } while (alive);
    }
    
    private static void DisplayBoard(){
        System.out.print(" ");
        for (int i = 0; i < myBoard.size; i++) {
            System.out.print(" "+ i);
        }
        System.out.println("");
        for (int i = 0; i < myBoard.size; i++) {
            System.out.print(i +" ");
            for (int j = 0; j < myBoard.size; j++) {
                if (myBoard.theGrid[i][j].isBomb) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print(myBoard.theGrid[i][j].adjacentBombs + " ");
                }
                
            }
            System.out.println("");
        }
    }
    
    private static void MakeMove(Cell c){
        
    }
}
