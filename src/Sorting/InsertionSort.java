package Sorting;
import java.util.*;

public class
InsertionSort
{
    static void sorting(int[] arr)
    {
        int n = arr.length;
        for (int i=1; i<n; i++)
        {
            int key = arr[i];
            int j = i-1;
            
            // Moving element position if it's greater than key
            while (j>=0 && arr[j]>key) {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1]=key;
        }
    }
    
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Total number of elements:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n ; i++){
            System.out.print("Element at location "+ i +":");
            arr[i]=sc.nextInt();
        }
        System.out.println("Array before the sorting");
        printArray(arr);
        sorting(arr);
        System.out.println("Array after the sorting:");
        printArray(arr);
        sc.close();
    } 
}