/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknakereso;

/**
 *
 * @author Bendegúz
 */
public class Cell {
    public int row;
    public int col;
    public boolean isBomb;
    public boolean isDiscovered;
    public int adjacentBombs;
    
    public Cell(int x, int y){
        row = x;
        col = y;
        isBomb = false;
        isDiscovered = false;
        adjacentBombs = 0;
    }
}
