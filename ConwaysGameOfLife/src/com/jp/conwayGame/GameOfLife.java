package com.jp.conwayGame;

public class GameOfLife {

	public static void main(String[] args) {
		// Fixed grid for testing the code
		GameOfLife conway = new GameOfLife(6, 8, false);
		conway.computeGenerations(1);
	}

	public GameOfLife(int inputRows, int inputColumns, boolean randomGrid) {
		if(inputRows <= 0 || inputColumns <= 0) {
			throw new NullPointerException();
		}
		grid = new Grid(inputRows, inputColumns, randomGrid);
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public void displayGrid() {
		grid.displayGrid();
	}
	
	// noOfGen -- number of generations
	public void computeGenerations(int noOfGen)
	{
		// display the initial state
		System.out.println("Generation 0 : ");
		displayGrid();
		// loops through the generations
		for (int i=0; i<noOfGen; i++){  
			getUpdatedState(grid.getGrid());
			// display every generation
			System.out.println("Generation " + (i+1) + ":");
			displayGrid();
		}
	}
	
	private void getUpdatedState(int[][] localGrid) {
		int m = localGrid.length;
        int n = localGrid[0].length;
		for (int i = 0; i < m; ++i) {
	        for (int j = 0; j < n; ++j) {
	            int lives = countOfLiveNeighbors(localGrid, i, j);
	            if (localGrid[i][j] == 1) {
	                if (lives < 2 || lives > 3) {
	                	localGrid[i][j] = 2;
	                }
	            } else if (localGrid[i][j] == 0 && lives == 3) {
	            	localGrid[i][j] = 3;
	            }
	        }
	    }
	    for (int i = 0; i < m; ++i) {
	        for (int j = 0; j < n; ++j) {
	            if (localGrid[i][j] == 2) {
	            	localGrid[i][j] = 0;
	            }
	            if (localGrid[i][j] == 3) {
	            	localGrid[i][j] = 1;
	            }
	        }
	    }
	    grid.setGrid(localGrid);
	}
	
	private int countOfLiveNeighbors(int[][] localGrid, int row, int column) {
	    int lives = 0;
	    for (int i=row-1; i<=row+1; i++) {
	        for (int j=column-1; j<=column+1; j++) {
	            if (i >= 0 && i < localGrid.length && 
	            	j >=0 && j < localGrid[0].length && 
	            	(localGrid[i][j] == 1 || localGrid[i][j] == 2)) {
	            	lives++;
	            }
	        }
	    }
	    // Subtract for localGrid[row][column]; as it is added
	    return lives - localGrid[row][column];
	}
	private Grid grid;
}
