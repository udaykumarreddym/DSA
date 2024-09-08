import java.util.*;

public class Array{
    public static void main(String[] args){
        //sortedArray();
        //removeduplicates();
        //rotateLeftK();
        //rotateRightK();
        //unionofSorted();
        //majorityBrute();
        //mooreVoting();
        //dutchNationalFlag();
        //kadanes();
        nextPermutation();
        
    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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
        for(int j = 0; j <= i; j++){
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
    
    public static void unionofSorted(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter array size:");
        int m = sc.nextInt();
        int arr1[] = new int[m];
        System.out.println("Enter elements:");
        for(int i=0;i<arr1.length;i++){
            arr1[i] = sc.nextInt();
        }
        int i = 0, j =  0;
        ArrayList<Integer> union = new ArrayList<>();
        while(i<n&&j<m){
            if(arr[i]<=arr1[j]){
                if(union.isEmpty() || union.get(union.size()-1)!=arr[i]){
                    union.add(arr[i]);
                }
                i++;
            }
            else{
                if(union.isEmpty() || union.get(union.size()-1)!=arr1[j]){
                    union.add(arr1[j]);
                }
                j++;
            }
        }
        while(i<n){
            if(union.isEmpty() || union.get(union.size()-1)!=arr[i]){
                union.add(arr[i]);
            }
            i++;
        }
        while(j<m){
            if(union.isEmpty() || union.get(union.size()-1)!=arr1[j]){
                union.add(arr1[j]);
            }
            j++;
        }
        System.out.println("Union of given two arrays:");
        for(int nums : union){
            System.out.print(nums+" ");
        }
    }

    public static void majorityBrute(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int flag = 0;
        for(int i=0; i<arr.length;i++){
            int count = 0;
            for(int j=i;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count > n/2){
                System.out.println(arr[i]+" is majority element");
                flag = 1;
                break;
            }
        }
        if(flag==0){
            System.out.println("There is no majority element");
        }
    }

    public static void mooreVoting(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int candidate = arr[0];
        int count = 1;
        for(int i = 1; i<arr.length;i++){
            if(arr[i]==candidate){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                candidate = arr[i];
                count = 1;
            }
        }
        count = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==candidate){
                count++;
            }
        }
        if(count > arr.length/2){
            System.out.println(candidate+" is majority element");
        }
        else{
            System.out.println("No majority element");
        }
    }

    public static void dutchNationalFlag(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while(mid<=high){
            switch (arr[mid]) {
                case 0:
                    swap(arr,low,mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                default:
                    swap(arr,mid,high);
                    high--;
                    break;
            }
        }
        System.out.println("After Sorting:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void kadanes(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int anStart = 0;
        int anEnd = 0;
        for(int i=0;i<arr.length;i++){
            if(sum == 0){
                start = i;
            }
            sum += arr[i];
            if(sum>max){
                max = sum;
                anStart = start;
                anEnd = i;
            }
            if(sum<0){
                sum = 0;
            }
        }
        System.out.println("Maximum subarray sum: "+max);
        System.out.println("Starting index: "+anStart+" Ending index: "+anEnd);
    }
    public static void nextPermutation(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int ind = -1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            int start = 0,end = n-1;
            while(start<end){
                swap(arr,start,end);
                start++;
                end--;
            }
            System.out.println("Next permutation:");
            for(int num : arr){
                System.out.print(num+" ");
            }
        }
        else{
            for(int i=n-1;i>ind;i--){
                if(arr[i]>arr[ind]){
                    swap(arr,i,ind);
                    break;
                }
            }
            int start = ind+1, end = n-1;
            while(start<end){
                swap(arr,start,end);
                start++;
                end--;
            }
            System.out.println("Next permutation:");
            for(int num : arr){
                System.out.print(num+" ");
            }
        }
    }
}