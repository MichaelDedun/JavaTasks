package net.thumbtack.school.introduction;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.sun.xml.internal.rngom.digested.DValuePattern;

public class FirstSteps {
    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x <= xRight && x >= xLeft && y <= yBottom && y >= yTop;
    }

    public int sum(int[] array) {
        int sum = 0;
        for (int value : array) sum += value;
        return sum;
    }

    public int mul(int[] array) {
        int mul = 1;
        if (array.length == 0) return 0;
        for (int value : array) mul *= value;
        return mul;
    }

    public int min(int[] array) {
        if (array.length == 0) return Integer.MAX_VALUE;
        int min = array[0];
        for (int value : array)
            if (value < min)
                min = value;
        return min;
    }

    public int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int value : array)
            if (value > max)
                max = value;
        return max;
    }

    public double average(int[] array) {
        if (array.length == 0) return 0;
        return (double) sum(array) / array.length;
    }

    public boolean isSortedDescendant(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] <= array[i + 1])
                return false;
        return true;

    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = (int) Math.pow(array[i], 3);
    }

    public boolean find(int[] array, int value) {
        for (int element : array) if (element == value) return true;
        return false;
    }

    public void reverse(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[array.length - i - 1];
            array[array.length - i - 1] = array[i];
            array[i] = temp;
        }
    }

    public boolean isPalindrome(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] != array[array.length - i - 1])
                return false;
        return true;
    }

    public int sum(int[][] matrix) {
        int sum = 0;
        for (int[] value : matrix) sum += sum(value);
        return sum;
    }

    public int max(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++)
            if (max(matrix[i]) > max)
                max = max(matrix[i]);
        return max;
    }

    public int diagonalMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < matrix.length; i++) {
            if (max < matrix[i][i]) {
                max = matrix[i][i];
            }
        }
        return max;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            if (!isSortedDescendant(matrix[i])) {
                return false;
            }
        }
        return true;
    }
}
