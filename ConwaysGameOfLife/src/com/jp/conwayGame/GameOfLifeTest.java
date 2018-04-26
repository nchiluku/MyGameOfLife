package com.jp.conwayGame;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class GameOfLifeTest {
	@Test
	void testConstructor() {
		GameOfLife life = new GameOfLife(5, 8, false);
		assertEquals(5, life.getGrid().getRows());
		assertEquals(8, life.getGrid().getColumns());
	}
	
	@Test
	void testDisplayFixedBoard() {
		GameOfLife life = new GameOfLife(5, 8, false);
		life.computeGenerations(1);
		assertEquals(life.getGrid().getCellValue(0, 1), 1);
	}
	
	@Test
	void testDisplayRandomBoardAndVariableSize() {
		GameOfLife life = new GameOfLife(10, 10, true);
		assertEquals(10, life.getGrid().getRows());
		assertEquals(10, life.getGrid().getColumns());
		life.computeGenerations(5);
	}
}

