package Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {

    /**
     * To print the array
     * @param arr
     */
    public void printArray(int[] arr){
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    /**
     * Inserts an element at a specific position in the array.
     * Shifts the elements to the right.
     */
    public int[] insertElement(int[] arr, int pos, int num) {
        if (pos < 1 || pos > arr.length + 1) {
            System.out.println("Invalid position! Returning original array.");
            return arr;
        }

        int[] newArr = new int[arr.length + 1];

        int j = 0;
        for (int i = 0; i < newArr.length; i++) {
            if (i == pos - 1) {
                newArr[i] = num;
            } else {
                newArr[i] = arr[j];
                j++;
            }
        }
        return newArr;
    }


    /**
     *  Deletes the first occurrence of a number from the array.
     */
    public int[] delElement(int[] arr, int num){
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty!");
            return arr;
        }
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Element not found!");
            return arr;
        }

        int[] newArr = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) continue;
            newArr[j++] = arr[i];
        }
        return newArr;
    }


    public int smallestElement(int[] arr){
        int smallest=arr[0];
        for (int i : arr) {
            if (i < smallest)
                smallest = i;
        }
        return smallest;
    }

    public int largestElement(int arr[]){
        int largest=arr[0];
        for (int i : arr) {
            if (i > largest) {
                largest = i;
            }
        }
        return largest;
    }


    public static void main(String [] args)
    {
        ArrayOperations ob = new ArrayOperations();
        Scanner sc = new Scanner(System.in);

        /*
        System.out.print("Enter the size of array:");
        int s = sc.nextInt();
        int[] arr = new int[s];
        */

        int[] arr = {10,56,43,23,78,69,54,29,1,2};

        /*
        System.out.print("Enter the elements of array:");
        for(int i=0; i<s ; i++){
            arr[i]=sc.nextInt();
            sc.useDelimiter("[\\s,]+");
        }*/

        System.out.println("Following operations are available --------");
        System.out.println("press 1 to print the entire array:");
        System.out.println("press 2 to insert Element in an array:");
        System.out.println("press 3 to delete Element from array:");
        System.out.println("press 4 to find smallest Element in array:");
        System.out.println("press 5 to find largest Element in array:");


        char con='y';
        while(con=='y'|| con =='Y'){
            System.out.print("\nMake a choice for operation you want to perform:");
            int sel = sc.nextInt();
            switch (sel) {
                case 1 -> {
                    System.out.print("Elements of array: ");
                    ob.printArray(arr);
//                    System.out.println(Arrays.toString(arr));
                }
                case 2 -> {
                    System.out.print("Enter the location : \t");
                    int pos = sc.nextInt();
                    System.out.print("Enter the element to be inserted : \t");
                    int num = sc.nextInt();
                    arr = ob.insertElement(arr, pos, num);
                    System.out.printf("Element %d added at location %d", num, pos);
                }
                case 3 -> {
                    System.out.print("Enter the number which you want to delete from array:");
                    int del_num = sc.nextInt();
                    arr = ob.delElement(arr, del_num);
                    System.out.println("Array after deleting the element : " + Arrays.toString(arr));
                }
                case 4 -> System.out.println("Smallest Element of array:" + ob.smallestElement(arr));
                case 5 -> System.out.println("Smallest Element of array:" + ob.largestElement(arr));
            }
            System.out.print("\nDid you want to continue : \t");
            con = sc.next().charAt(0);
        }
        sc.close();
    }

}
