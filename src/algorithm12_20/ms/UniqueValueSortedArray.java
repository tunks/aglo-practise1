package algorithm12_20.ms;

import java.util.ArrayList;
import java.util.List;

public class UniqueValueSortedArray {
	public static void main(String[] args) {
        int[] test = {-1, -1, -1, -1, 0, 0, 0, 0,2,3,4,5,5,6,7,8};
        System.out.println(getUniqueValues(test, 0, test.length - 1));
    }

    // i must be start index, j must be end index
    public static List<Integer> getUniqueValues(int[] array, int i, int j) {
        if (array == null || array.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        if (array[i] == array[j]) {
            result.add(array[i]);
        } else {
            int mid = (i + j) / 2;
            result.addAll(getUniqueValues(array, i, mid));

            // avoid duplicate divide
            while (mid < j && array[mid] == array[++mid]);
            if (array[(i + j) / 2] != array[mid]) {
                result.addAll(getUniqueValues(array, mid, j));
            }
        }
        return result;
    }
}
