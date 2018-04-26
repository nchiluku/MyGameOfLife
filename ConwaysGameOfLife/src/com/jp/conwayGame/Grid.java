package com.jp.conwayGame;

import java.util.Random;

public class Grid {
	
	public Grid(int row, int cols, boolean randomGrid) {
		rows = row;
		columns = cols;
		if(randomGrid) {
			grid = new int[rows][columns];
			createRandomGrid();
		}
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public int getCellValue(int i, int j) {
		if(i>=rows && j>=columns) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return grid[i][j];
	}
	
	// Creates the cell values randomly
	private void createRandomGrid() {
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Boolean random = rand.nextBoolean();
                if (random) {
                    grid[i][j] = 1;
                }
                else {
                    grid[i][j] = 0;
                }
            }
        }
    }
	
	public void displayGrid() {
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				if(grid[i][j] == 1) {
				   System.out.print(" " + ALIVE + " ");
				} else {
					System.out.print(" " + DEAD + " ");
				}
            }
			System.out.println();
        }
        System.out.println();
	}
	
	public int[][] getGrid() {
		return grid;
	}
	
	public void setGrid(int[][] localGrid) {
		grid = localGrid;
	}
	
	private static final String ALIVE = "O";
    private static final String DEAD = ".";
    // Fixed grid values
    private int[][] grid = {
			{0, 0, 0, 0, 0, 0, 1, 0 },
			{1, 1, 1, 0, 0, 0, 1, 0},
			{0, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 1, 0, 0, 1},
			{0, 0, 0, 1, 1, 0, 0, 1},
	};
	private int rows;
	private int columns;
}
