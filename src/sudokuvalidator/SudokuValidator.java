package sudokuvalidator;

import java.util.Scanner;

public class SudokuValidator 
{
    public static void main(String[] args) 
    {
        int[][] grid = new int[9][9];
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a Sudoku puzzle solution:");
        for (int i = 0; i < 9; i++) 
        {
            for (int j = 0; j < 9; j++) 
            {
                grid[i][j] = input.nextInt();
            }
        }

        if (isValidSudoku(grid)) 
        {
            System.out.println("Valid solution");
        } 
        else 
        {
            System.out.println("Invalid solution");
        }
    }

    public static boolean isValidSudoku(int[][] grid) 
    {
        for (int i = 0; i < 9; i++) 
        {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] boxCheck = new boolean[9];

            for (int j = 0; j < 9; j++) 
            {
                if (!check(grid[i][j], rowCheck)) 
                {
                    return false;
                }
                if (!check(grid[j][i], colCheck)) 
                {
                    return false;
                }
                if (!check(grid[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3], boxCheck)) 
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(int num, boolean[] check) 
    {
        if (num == 0) 
        {
            return true; // Skip zero values for empty cells
        }
        if (num < 1 || num > 9 || check[num - 1]) 
        {
            return false;
        }
        check[num - 1] = true;
        return true;
    }
}
