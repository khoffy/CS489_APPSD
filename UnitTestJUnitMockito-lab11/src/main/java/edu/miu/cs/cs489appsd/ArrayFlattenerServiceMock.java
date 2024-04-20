package edu.miu.cs.cs489appsd;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattenerServiceMock implements ArrayFlattenerService {
    @Override
    public int[] flattenArray(int[][] nestedArray) {
        // Mock implementation to return a flattened array
        List<Integer> flattenedList = new ArrayList<>();
        for (int[] innerArray : nestedArray) {
            for (int num : innerArray) {
                flattenedList.add(num);
            }
        }
        int[] flattenedArray = new int[flattenedList.size()];
        for (int i = 0; i < flattenedList.size(); i++) {
            flattenedArray[i] = flattenedList.get(i);
        }
        return flattenedArray;
    }
}
