import java.util.*;

public class Array{
    public static void main(String[] args){
        //selectionsort();
        //bubblesort();
        insertionsort();
    }
    public static void bubblesort(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Initial array:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        for(int i=arr.length-1;i>=1;i--){
            int didSwap =0;
            for(int j=0;j<=i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    didSwap = 1;
                }
            }
            if(didSwap==0){
                break;
            }
        }
        System.out.println("\nSorted array:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void selectionsort(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Initial array:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        for(int i=0;i<=n-2;i++){
            int min = i;
            for(int j=i;j<=n-1;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
        System.out.println("\nSorted array:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void insertionsort(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Initial array:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        for(int i=0;i<arr.length;i++){
            int j = i;
            while(j>0 && arr[j-1]>arr[j]){
                swap(arr,j-1,j);
                j--;
            }
        }
        System.out.println("\nSorted array:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}