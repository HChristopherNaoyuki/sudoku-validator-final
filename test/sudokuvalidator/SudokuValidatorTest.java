package sudokuvalidator;

import org.junit.Test;
import static org.junit.Assert.*;

public class SudokuValidatorTest 
{
    @Test
    public void testValidSudoku() 
    {
        int[][] validGrid = {
            {9, 6, 3, 1, 7, 4, 2, 5, 8},
            {1, 7, 8, 3, 2, 5, 6, 4, 9},
            {2, 5, 4, 6, 8, 9, 7, 3, 1},
            {8, 2, 1, 4, 3, 7, 5, 9, 6},
            {4, 9, 6, 8, 5, 2, 3, 1, 7},
            {7, 3, 5, 9, 6, 1, 8, 2, 4},
            {5, 8, 9, 7, 1, 3, 4, 6, 2},
            {3, 1, 7, 2, 4, 6, 9, 8, 5},
            {6, 4, 2, 5, 9, 8, 1, 7, 3}
        };
        assertTrue(SudokuValidator.isValidSudoku(validGrid));
    }

    @Test
    public void testInvalidSudokuDueToDuplicateInRow() 
    {
        int[][] invalidGrid = {
            {9, 6, 3, 1, 7, 4, 2, 5, 8},
            {1, 7, 8, 3, 2, 5, 6, 4, 9},
            {2, 5, 4, 6, 8, 9, 7, 3, 1},
            {8, 2, 1, 4, 3, 7, 5, 9, 6},
            {4, 9, 6, 8, 5, 2, 3, 1, 7},
            {7, 3, 5, 9, 6, 1, 8, 2, 4},
            {5, 8, 9, 7, 1, 3, 4, 6, 2},
            {3, 1, 7, 2, 4, 6, 9, 8, 5},
            {6, 4, 2, 5, 9, 8, 1, 7, 1} // Invalid row (duplicate 1)
        };
        assertFalse(SudokuValidator.isValidSudoku(invalidGrid));
    }

    @Test
    public void testInvalidSudokuDueToDuplicateInColumn() 
    {
        int[][] invalidGrid = {
            {2, 6, 3, 1, 7, 4, 2, 5, 8}, // Duplicate in column
            {1, 7, 8, 3, 2, 5, 6, 4, 9},
            {2, 5, 4, 6, 8, 9, 7, 3, 1},
            {8, 2, 1, 4, 3, 7, 5, 9, 6},
            {4, 9, 6, 8, 5, 2, 3, 1, 7},
            {7, 3, 5, 9, 6, 1, 8, 2, 4},
            {5, 8, 9, 7, 1, 3, 4, 6, 2},
            {3, 1, 7, 2, 4, 6, 9, 8, 5},
            {6, 4, 2, 5, 9, 8, 1, 7, 3}
        };
        assertFalse(SudokuValidator.isValidSudoku(invalidGrid));
    }

    @Test
    public void testInvalidSudokuDueToDuplicateInSubGrid() 
    {
        int[][] invalidGrid = {
            {9, 6, 3, 1, 7, 4, 2, 5, 8},
            {1, 7, 8, 3, 2, 5, 6, 4, 9},
            {2, 5, 4, 6, 8, 9, 7, 3, 1},
            {8, 2, 1, 4, 3, 7, 5, 9, 6},
            {4, 9, 6, 8, 5, 2, 3, 1, 7},
            {7, 3, 5, 9, 6, 1, 8, 2, 4},
            {5, 8, 9, 7, 1, 3, 4, 6, 2},
            {3, 1, 7, 2, 4, 6, 9, 8, 5},
            {6, 4, 2, 5, 9, 8, 5, 7, 3} // Duplicate 5 in the last sub-grid
        };
        assertFalse(SudokuValidator.isValidSudoku(invalidGrid));
    }

    @Test
    public void testEmptySudoku() 
    {
        int[][] emptyGrid = new int[9][9]; // All cells are 0
        assertTrue(SudokuValidator.isValidSudoku(emptyGrid)); // Should be valid as no conflicts are present
    }

    @Test
    public void testAlmostValidSudoku() 
    {
        int[][] almostValidGrid = {
            {9, 6, 3, 1, 7, 4, 2, 5, 8},
            {1, 7, 8, 3, 2, 5, 6, 4, 9},
            {2, 5, 4, 6, 8, 9, 7, 3, 1},
            {8, 2, 1, 4, 3, 7, 5, 9, 6},
            {4, 9, 6, 8, 5, 2, 3, 1, 7},
            {7, 3, 5, 9, 6, 1, 8, 2, 4},
            {5, 8, 9, 7, 1, 3, 4, 6, 2},
            {3, 1, 7, 2, 4, 6, 9, 8, 5},
            {6, 4, 2, 5, 9, 8, 1, 7, 2} // Duplicate 2 in the last row
        };
        assertFalse(SudokuValidator.isValidSudoku(almostValidGrid));
    }
}
