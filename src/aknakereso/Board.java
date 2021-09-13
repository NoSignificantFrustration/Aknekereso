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
        PlaceBombs(bombs);
    }
    
    private void PlaceBombs(int b){
        Cell cell;
        for (int i = 0; i < b; i++) {
            cell = emptyCells.get(RandomChoice(emptyCells.size()));
            cell.isBomb = true;
            emptyCells.remove(cell);
            bombCells.add(cell);
            for (Cell c : Neighbours(cell)) {
                c.adjacentBombs++;
                
            }
        }
        
    }
    
    private int RandomChoice(int max){
        Random r = new Random();
        return r.nextInt(max);
    }
    
    public ArrayList<Cell> Neighbours(Cell cell){
        
        ArrayList<Cell> neighbours = new ArrayList<>();
        int r = cell.row;
        int c = cell.col;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (r+i >= 0 && r+i < size && c+j >= 0 && c+j < size) {
                    neighbours.add(theGrid[r + i][ c + j]);
                }
            }
        }
        return  neighbours;
    }
}
