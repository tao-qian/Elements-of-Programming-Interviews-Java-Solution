package chapter17;

import java.util.*;

public class question1708 {
	
	public static void main(String[] args)
	{
		int[][] sudoku = new int[9][9];
		for(int i = 0;i<9;i++)
		{
			for(int j = 0;j<9;j++)
			{
				sudoku[i][j] = 0;
			}
		}
		sudoku[0][0] = 2;
		sudoku[8][8] = 3;
		Util.Utility.print(solveSudoku(sudoku));
	}
	
	public static class Cell
	{
		int x;
		int y;
		public Cell(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	public static int[][] solveSudoku(int[][] sudoku)
	{
		LinkedList<Cell> unfilled = new LinkedList<Cell>();
		for(int i = 0;i<sudoku.length;i++)
		{
			for(int j = 0;j<sudoku[i].length;j++)
			{
				if(sudoku[i][j] > 9 || sudoku[i][j] < 1)
				{
					unfilled.add(new Cell(i,j));
				}
			}
		}
		return solveSudokuRecur(unfilled, sudoku);
	}
	
	public static int[][] solveSudokuRecur(LinkedList<Cell> unfilled, int[][] sudoku)
	{
		if(unfilled.size() == 0)
		{
			return sudoku;
		}
		Cell cell = unfilled.peekFirst();
		List<Integer> possible = getPossibleValues(cell, sudoku);
		// Not possible
		if(possible.size() == 0)
		{
			return null;
		}
		unfilled.pollFirst();
		for(Integer i : possible)
		{
			sudoku[cell.x][cell.y] = i;
			int[][] result = solveSudokuRecur(unfilled, sudoku);
			if(result != null)
			{
				return result;
			}
		}
		// We reverse the change made in this recursive call, 
		// if there is no valid solution
		unfilled.addFirst(cell);
		sudoku[cell.x][cell.y] = 0;
		return null;
	}
	
	public static List<Integer> getPossibleValues(Cell cell, int[][] sudoku)
	{
		boolean[] appeared = new boolean[10];
		// Get the matches in the rows and columns
		for(int i = 0;i<9;i++)
		{
			appeared[sudoku[i][cell.y]] = true;
			appeared[sudoku[cell.x][i]] = true;
		}
		// Get the matches in the 3*3 matrix around
		int upperX = cell.x/3*3;
		int upperY = cell.y/3*3;
		for(int i = 0;i<3;i++)
		{
			for(int j = 0;j<3;j++)
			{
				appeared[sudoku[upperX+i][upperY+j]] = true;
			}
		}
		//Added the possible ones to the list
		LinkedList<Integer> possible = new LinkedList<Integer>();
		for(int i = 1;i<appeared.length;i++)
		{
			if(!appeared[i])
			{
				possible.add(i);
			}
		}
		return possible;
	}
	
}
