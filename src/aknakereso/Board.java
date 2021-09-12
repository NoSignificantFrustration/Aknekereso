/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknakereso;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Bendegúz
 */
public class Board {
    public int size;
    public int bombs;
    public Cell[][] theGrid;
    public ArrayList<Cell> bombCells;
    public ArrayList<Cell> emptyCells;
    
    public Board(int s, int b){
        size = s;
        bombs = b;
        theGrid = new Cell[s][s];
        bombCells = new ArrayList<>();
        emptyCells = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                theGrid[i][j] = new Cell(i, j);
                emptyCells.add(theGrid[i][j]);
            }
        }
        
    }
    
    private void PlaceBombs(int b){
        Cell cell;
        for (int i = 0; i < b; i++) {
            cell = emptyCells.get(RandomChoice(emptyCells.size()));
            cell.isBomb = true;
            emptyCells.remove(cell);
            bombCells.add(cell);
            
            if (cell.col > 0 && cell.row > 0) {
                theGrid[cell.col-1][cell.row].adjacentBombs += 1;
                theGrid[cell.col-1][cell.row-1].adjacentBombs += 1;
                theGrid[cell.col][cell.row-1].adjacentBombs += 1;
            } else if(cell.row > 0){
                theGrid[cell.col][cell.row-1].adjacentBombs += 1;
            }
        }
        
    }
    
    private int RandomChoice(int max){
        Random r = new Random();
        return r.nextInt(max);
    }
}
