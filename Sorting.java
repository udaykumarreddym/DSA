
public class Sorting {

    public static void printarr(int[] a){
        for(int num : a){
            System.out.print(num + " , ");
        }System.out.println("");
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void bubblesort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }
    public static void selectionsort(int[] arr){
        int n = arr.length;
        for(int i=0;i<=n-2;i++){
            int min = i;
            for(int j=i;j<=n-1;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
    }
    public static void insertionsort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int j = i;
            while(j>0 && arr[j-1]>arr[j]){
                swap(arr,j-1,j);
                j--;
            }
        }
    }
    public static void mergeSort(int[] arr,int l,int r){
        if(l==r){
            return;
        }
        int m = (l+r)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
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
    public static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pIndex = partition(arr,low,high);
            quickSort(arr, low, pIndex-1);
            quickSort(arr, pIndex+1, high);
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

    public static void main(String[] args) {
        int[] a = {5, 2, 8, 9, 6, 2, 1, 4, 3};
        printarr(a);
        bubblesort(a);
        printarr(a);
        //selectionsort();
        //insertionsort();
        //mergeSort();
        // quicksort();
    }
}
