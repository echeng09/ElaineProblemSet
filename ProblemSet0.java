import java.util.*;
public class ProblemSet0 {
    public static void main(String[] args) {
        //testing code
        //1)
        int[] test1 = {14, 1, 22, 17, 36, 7, -43, 5};
        int result1 = countInRange(test1, 4, 17);
        //should print 4
        System.out.println(result1);

        //2)
        ArrayList<String> test2 = new ArrayList<>();
        test2.add("hi");
        test2.add("there");
        test2.add("what");
        test2.add("is");
        test2.add("up?");
        clump(test2);
        //should print [(hi there), (what is), up?]
        System.out.println(test2);  
        
        //3)
        int[][] testTrue = {
        {2, 7, 6},
        {9, 5, 1},
        {4, 3, 8}
        };

        int[][] testFalse = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        //should print true
        System.out.println(isMagicSquare(testTrue));
        //should print false
        System.out.println(isMagicSquare(testFalse));

        //4)
        int[] arr4 = {2, 3, 10, 1, 5};
        int result4 = median(arr4);
        //should print 3
        System.out.println("Median: " + result4);

        int[] arrTest= {1, 7, 85, 82, 80};
        int resultTest = median(arrTest);
        //should print 80 (just an extra test bc this one was hard)
        System.out.println("Median: " + resultTest);

    }

    //1)
    public static int countInRange(int[] list, int min, int max) {
        //create counter var
        int count = 0;
        //for loop to traverse through array
        for (int x: list) {
            //if its within the min/max inclusive
            if (x >= min && x <= max) {
                //update counter
                count++;
            }
        }
        //return
        return count;
    }

    //2)
    public static void clump(ArrayList<String> words) {
    //index
    int i = 0;
    //use while loop bc have to change the array (makes it easier)
    while (i < words.size() - 1) {
        //clumped holder
        String clumped = "(" + words.get(i) + " " + words.get(i + 1) + ")";
        //set the index as clumped
        words.set(i, clumped);
        //delete the one after bc clumped 2 into 1
        words.remove(i + 1);
        //move on
        i++; 
        }
    }

    //3)
    public static boolean isMagicSquare(int[][] square) {
    int n = square.length;
    //not square
    for (int[] row : square) {
        if (row.length != n){
            return false;
        }
    }
    //get sum of first row
    int sum = 0;
    for (int j = 0; j < n; j++) {
        sum += square[0][j];
    }
    //check rows w/ target sum
    for (int i = 1; i < n; i++) {
        int rowSum = 0;
        for (int j = 0; j < n; j++) {
            rowSum += square[i][j];
        }
        if (rowSum != sum) {
            return false;
        }
    }
    //check columns w/ target sum
    for (int j = 0; j < n; j++) {
        int colSum = 0;
        for (int i = 0; i < n; i++) {
            colSum += square[i][j];
        }
        if (colSum != sum){
            return false;  
        }
    }
    //check major diagonal
    int diagonal = 0;
    for (int i = 0; i < n; i++) {
        diagonal += square[i][i];
    }
    if (diagonal != sum){
        return false;
    }
    //done checking
    return true;
    }

    //4)
    public static int median(int[] arr) {
        int[] count = new int[100];
        //set only vals in original array in the new array to 1 (to know which values are in it)
        for (int num : arr) {
            count[num]++;
        }
        //making an array to add up total counted in the counter array to find which values to include
        int total = 0;
        //find the spot of the median (odd num) - index if sorted
        int mid = arr.length / 2;
        //using for loop to iterate through the counter array
        for (int i = 0; i < 100; i++) {
            //add the count to the total (1 if it is within the array, 0 if not)
            total += count[i];
            //if the total (of added ones) is greater than the middle index, return i of the counter array
            //this gets the median value
            if (total > mid) {
                return i;
            }
        }
        //need to return -1 bc otherwise wont run
        return -1; 
    }
}