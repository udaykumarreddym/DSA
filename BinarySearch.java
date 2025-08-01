import java.util.Scanner;

public class BinarySearch {
    
    public static void binarySearch(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n-1;
        int flag = 0;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid]==target){
                flag = 1;
                System.out.println("Target found at "+mid+" position");
                break;
            }
            else if(target > arr[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        if(flag == 0){
            System.out.println("Target not found");
        }
    }

    public static void lowerbound(int[] arr, int target) {
        int n = arr.length;
        int ans = n;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid]>=target){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }
        System.out.println("Lower bound found at "+ans+" position");
    }

    public static void BinaryS_rotate(int[] arr, int target) {
        int n = arr.length;
        int ans = -1;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==target){
                ans = mid;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(arr[mid]<=target && target<=arr[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        System.out.println(target+" is found at "+ans+" position");
    }

    public static void PeakElement(int[] arr) {
        int ans = Peak(arr);
        if(ans == -1){
            System.out.println("Peak not found");
        }
        else{
            System.out.println("Peak: "+ans);
        }
    }
    public static int Peak (int[] arr){
        int n = arr.length;
        if(n==1){
            return arr[0];
        }
        if(arr[0]>arr[1]){
            return arr[0];
        }
        if(arr[n-1]>arr[n-2]){
            return arr[n-1];
        }
        int low = 1;
        int high = n-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid-1]<arr[mid]&&arr[mid]>arr[mid+1]){
                return arr[mid];
            }
            else if(arr[mid]>arr[mid-1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }

    public static void twoDsearch(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;
        int low = 0;
        int high = n*m-1;
        int flag = 0;
        while(low<=high){
            int mid = (low+high)/2;
            int row = mid/m;
            int col = mid%m;
            if(arr[row][col]==target){
                System.out.println("Found");
                flag = 1;
                break;
            }
            else if(arr[row][col]<target){
                low = mid+1;
            }
            else{
                high = mid-1; 
            }
        }
        if(flag == 0){
            System.out.println("Not found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        binarySearch(arr, 5); // Example target
        //lowerbound();
        //BinaryS_rotate();
        //PeakElement();
        // twoDsearch();
    }
}
