package edu.miu.cs.cs489appsd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayFlattenerTest {
    @Test
    public void testFlattenArrayWithLegitInput() {
        ArrayFlattener arrayFlattener = new ArrayFlattener();
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {1, 3, 0, 4, 5, 9};

        int[] result = arrayFlattener.flattenArray(input);

        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testFlattenArrayWithNullInput() {
        ArrayFlattener arrayFlattener = new ArrayFlattener();
        int[][] input = null;

        int[] result = arrayFlattener.flattenArray(input);

        assertNotNull(result);
        assertEquals(0, result.length);
    }
}
