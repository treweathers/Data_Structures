import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      /* Type your code here. */
      
   }
   public static int bunnyEars2(int n) {
      if (n == 0) {
         return 0;
      }
      
      if (n % 2 == 0) {
         return 3 + bunnyEars2(n - 1);
      }
      else {
         return 2 + bunnyEars2(n - 1);
      }
   }
   
   public static int sumDigits(int num) {
      if (num < 10) {
         return num;
      }
      
      return (num % 10) + sumDigits(num / 10);
   }
   
   public static int rangeSum(int from, int to) {
      if (from == to) {
         return to;
      }
      
      return from + rangeSum(from + 1, to);
   }
   
   public static boolean arrayX10(int[] nums, int index) {
      if (index >= nums.length - 1) {
         return false;
      }
      
      if (nums[index + 1] == nums[index] * 10) {
         return true;
      }
      
      return arrayX10(nums, index + 1);
   }
   
   public static int triangle(int rows) {
      if (rows == 0) {
         return 0;
      }
      
      return rows + triangle(rows - 1);
   }
   
   public static int array11(int[] nums, int index) {
      if (index >= nums.length) {
         return 0;
      }
      
      int count = 0;
      
      if (nums[index] == 11) {
         count = 1;
      }
      
      return count + array11(nums, index + 1);
   }
   
   public static boolean arrayVal(int[] nums, int index, int Val) {
      if (index >= nums.length) {
         return false;
      }
      
      if (nums[index] == Val) {
         return true;
      }
      
   return arrayVal(nums, index + 1, Val);
   }
}