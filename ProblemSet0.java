import java.util.*;
public class ProblemSet0 {
    public static void main(String[] args) {
        //testing code
        //1)
        int[] test1 = {14, 1, 22, 17, 36, 7, -43, 5};
        int result1 = countInRange(test1, 4, 17);
        //should print 4
        System.out.println(result1);

        int[] test1Extra = {4, 1, 9, 3, 5, 7, -98, 3};
        int result1Extra = countInRange(test1Extra, 3, 10);
        //should print 6
        System.out.println(result1Extra);

        int[] test1Extra1 = {-5, -2, 74, -19, 49, 100, 0, 2};
        int result1Extra1 = countInRange(test1Extra1, -5, 100);
        //should print 6
        System.out.println(result1Extra1);

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
        
        ArrayList<String> test2Extra = new ArrayList<>();
        test2Extra.add("hello");
        test2Extra.add("my");
        test2Extra.add("name");
        test2Extra.add("is");
        test2Extra.add("Elaine");
        test2Extra.add("Cheng");
        clump(test2Extra);
        //should print [(hello my), (name is), (Elaine Cheng)]
        System.out.println(test2Extra);  
        
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
    int numRows = square.length;
    //not square (if rows not the same as the column length)
    for (int[] row : square) {
        if (row.length != numRows){
            return false;
        }
    }
    //get sum of first row
    int sum = 0;
    for (int i = 0; i < numRows; i++) {
        sum += square[0][i];
    }
    //check rows w/ target sum
    for (int r = 1; r < numRows; r++) {
        int rowSum = 0;
        for (int x = 0; x < numRows; x++) {
            rowSum += square[r][x];
        }
        if (rowSum != sum) {
            return false;
        }
    }
    //check columns w/ target sum
    for (int c = 0; c < numRows; c++) {
        int colSum = 0;
        for (int y = 0; y < numRows; y++) {
            colSum += square[y][c];
        }
        if (colSum != sum){
            return false;  
        }
    }
    //check major diagonal
    int diagonal = 0;
    for (int d = 0; d < numRows; d++) {
        diagonal += square[d][d];
    }
    if (diagonal != sum){
        return false;
    }
    //done checking
    return true;
    }

    //4)
    public static int median(int[] arr) {
        int[] counter = new int[100];
        //set only vals in original array in the new array to 1 (to know which values are in it)
        for (int x: arr) {
            counter[x]++;
        }
        //making an array to add up total counted in the counter array to find which values to include
        int add = 0;
        //find the spot of the median (odd num) - index if sorted
        int middle = arr.length / 2;
        //using for loop to iterate through the counter array
        for (int i = 0; i < 100; i++) {
            //add the count to the total (1 if it is within the array, 0 if not)
            add += counter[i];
            //if the total (of added ones) is greater than the middle index, return i of the counter array
            //this gets the median value
            if (add > middle) {
                return i;
            }
        }
        //need to return -1 bc otherwise wont run
        return -1; 
    }
}