package Sorting;


import java.util.Arrays;

public class BubbleSort
{
    static void sorting(int arr[])
    {
        int n = arr.length;
        boolean swapped;
        for(int i=0; i<n-1;i++)
        {
            swapped = false;
            for(int j =0;j<n-i-1;j++) {
                if (arr[j]>arr[j+1]) {
                    swap(arr, j);
                    swapped = true;
                }
            }
            if (!swapped)
            {
                System.out.println("\nExit at round:" + (i + 1));
                break;
            }
        }
    }

    private static void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j +1];
        arr[j +1] = temp;
    }


    public static void main(String[] args)
    {
        int[] arr = {1,3,2,4,5,6,7,8,9,10};
/*
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Total number of elements:");
        int n = sc.nextInt();
        int[] arr;
        arr = new int[n];
        IntStream.range(0, n).forEach(i -> {
            System.out.print("Element at location " + i + ":");
            arr[i] = sc.nextInt();
        });
*/
        sorting(arr);
        System.out.println("Array after the sorting : " + Arrays.toString(arr));
//        sc.close();
    }
}