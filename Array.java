import java.util.*;

public class Array{
    public static void main(String[] args){
        //selectionsort();
        //bubblesort();
        //insertionsort();
        //mergeSort();
        //quicksort();
        //largestElement();
        //secondLargest();
        //sortedArray();
        //removeduplicates();
        //rotateLeftK();
        rotateRightK();
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


    public static void mergeSort(){
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

        mergeSort1(arr,0,arr.length-1);
        
        System.out.println("\nSorted array:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void mergeSort1(int[] arr,int l,int r){
        if(l==r){
            return;
        }
        int m = (l+r)/2;
        mergeSort1(arr,l,m);
        mergeSort1(arr,m+1,r);
        merge(arr,l,m,r);
        
    }
    public static void merge(int[] arr, int l, int m, int r){
        
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        System.arraycopy(arr, l, leftArray, 0, n1);
        System.arraycopy(arr, m + 1, rightArray, 0, n2);
        
        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static void quicksort(){
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

        quickSort1(arr,0,arr.length-1);

        System.out.println("\nSorted array:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void quickSort1(int[] arr, int low, int high){
        if(low<high){
            int pIndex = partition(arr,low,high);
            quickSort1(arr, low, pIndex-1);
            quickSort1(arr, pIndex+1, high);
        }
    }
    public static int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i<j){
            while(arr[i] <= pivot && i <= high-1){
                i++;
            }
            while(arr[j] > pivot && j >= low){
                j--;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,low,j);
        return j;
    }


    public static void largestElement(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("Maximun element is "+max);
    }
    

    public static void secondLargest(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int secmax = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
            if(arr[i]>max){
                secmax = max;
                max = arr[i];
            }
            if(arr[i]>secmax && arr[i] != max){
                secmax = arr[i];
            }
        }
        if(secmax == Integer.MIN_VALUE){
            System.out.println("-1");
        }
        else{
            System.out.println("Second largest element:"+secmax);
        }
    }

    public static void sortedArray(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int flag = 0;
        for(int i = 1; i < n; i++){
            if(arr[i] > arr[(i+1)%n]){
                flag += 1;
            }
        }
        if(flag > 1){
            System.out.println("Not sorted");
        }
        else{
            System.out.println("Sorted");
        }
    }

    public static void removeduplicates(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int i = 0;
        for(int j = 1; j < arr.length; j++){
            if(arr[i] != arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        System.out.println("After removing duplicates");
        for(int j = 0; j < i; j++){
            System.out.print(arr[j]+" ");
        }
    }

    public static void rotateLeftK(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter K value:");
        int k = sc.nextInt();
        for(int i = 1; i <= k; i++){
            int temp = arr[0];
            for(int j = 0; j < arr.length-1; j++){
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] = temp;
        }
        System.out.println("After rotating left:");
        for(int j = 0; j < arr.length; j++){
            System.out.print(arr[j]+" ");
        }
    }

    public static void rotateRightK(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter K value:");
        int k = sc.nextInt();
        for(int i = 1; i <= k; i++){
            int temp = arr[arr.length-1];
            for(int j = arr.length-2; j >= 0; j--){
                arr[j+1] =  arr[j];
            }
            arr[0] = temp;
        }
        System.out.println("After rotating right:");
        for(int j = 0; j < arr.length; j++){
            System.out.print(arr[j]+" ");
        }
    }
    
}