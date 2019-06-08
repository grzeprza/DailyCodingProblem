import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem_190619 {
    /*
    Problem (HARD):

    Given an array of integers, return a new array such that each element at index i
    of the new array is the product of all the numbers in the original array except
    the one at i.

    For example, if our input was [1, 2, 3, 4, 5], the expected output would be
    [120, 60, 40, 30, 24].
    If our input was [3, 2, 1], the expected output would be [2, 3, 6].

    Solution:
    We multiply left side (L) and right side (R) of current element (1), if there is not left/right side we assign 1
     1    2   3   4   5                             L*P
    (1)   2   3   4   5    L = 1, P =2*3*4*5= 120   => 120
     1   (1)  3   4   5    L = 1, P = 3*4*5 = 60    => 60
     1    2  (1)  4   5    L = 2, P = 4*5   = 20    => 40
     1    2   3  (1)  5    L = 6, P = 5     = 5     => 30
     1    2   3   4  (1)   L = 24,P = 1     = 1     => 24
    After multiplying L and R we get expected result
    Each operation step is O(n), so whole algorithm is 0(n)
    */
    public static List<Integer> solveProblem(int [] input ){
        //count left - O(n)
        List<Integer> leftArray =  new ArrayList<>();
        for(int i = 0; i<input.length; i++){
            leftArray.add( (i != 0 ? input[i-1]*leftArray.get(i-1) : 1) );
        }
        //count right and reverse - 0 (n)
        List<Integer> rightArray =  new ArrayList<>();
        for( int i=input.length-1; i>=0 ; i--){
            rightArray.add( ( i!=input.length-1? input[i+1] *  rightArray.get(input.length-1 - i -1) : 1 ) );
        }
        Collections.reverse(rightArray);
        //calc result - O(n)
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<input.length; i++){
            result.add( leftArray.get(i)*rightArray.get(i) );
        }
        return result;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        int [] test1 = {3,2,1};
        System.out.println("Exprected = [2, 3, 6],\n Result = "+solveProblem(test1));

        int [] test2 = {1, 2, 3, 4, 5};
        System.out.println("\nExpected = [120, 60, 40, 30, 24],\n Result = "+solveProblem(test2));
    }
}
