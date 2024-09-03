import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        //binarySearch();
        lowerbound();
    }

    public static void binarySearch(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter target:");
        int target = sc.nextInt();
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

    public static void lowerbound(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size:");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter target:");
        int target = sc.nextInt();
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
}
