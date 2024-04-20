package edu.miu.cs.cs489appsd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ArrayReversorTest {
    @Test
    public void testReverseArrayWithLegitInput() {
        // Mock the ArrayFlattenerService
        ArrayFlattenerService arrayFlattenerServiceMock = mock(ArrayFlattenerService.class);
        when(arrayFlattenerServiceMock.flattenArray(any())).thenReturn(new int[] {1, 3, 0, 4, 5, 9});

        // Create ArrayReversor instance with the mock service
        ArrayReversor arrayReversor = new ArrayReversor(arrayFlattenerServiceMock);

        // Test reverseArray method
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {9, 5, 4, 0, 3, 1};
        int[] result = arrayReversor.reverseArray(input);

        // Verify that the ArrayFlattenerService was invoked
        verify(arrayFlattenerServiceMock).flattenArray(input);

        // Check the result
        assertNotNull(result);
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testReverseArrayWithNullInput() {
        // Mock the ArrayFlattenerService
        ArrayFlattenerService arrayFlattenerServiceMock = mock(ArrayFlattenerService.class);
        when(arrayFlattenerServiceMock.flattenArray(any())).thenReturn(new int[0]);

        // Create ArrayReversor instance with the mock service
        ArrayReversor arrayReversor = new ArrayReversor(arrayFlattenerServiceMock);

        // Test reverseArray method
        int[][] input = null;
        int[] result = arrayReversor.reverseArray(input);

        // Verify that the ArrayFlattenerService was invoked
        verify(arrayFlattenerServiceMock).flattenArray(input);

        // Check the result
        assertNotNull(result);
        assertArrayEquals(new int[0], result);
    }
}
