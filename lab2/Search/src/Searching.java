import java.util.Scanner;
import java.util.Arrays;

public class Searching {
	
	
	public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
	
    public static int interpolationSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high && key >= arr[low] && key <= arr[high]) {
            if (low == high) {
                if (arr[low] == key) {
                    return low;
                }
                return -1;
            }
            
            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            
            if (arr[pos] == key) {
                return pos;
            } else if (arr[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        
        return -1;
    }
	
    // We assume that improved linear search works best when provided with a sorted array and uniformly distributed array
    public static int improvedLinearSearch(int[] arr, int key) {
    	if ((arr.length>1) && (key-arr[0] < arr[arr.length-1]-key))
    	{
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    	} else {
    		for (int i = arr.length-1; i >= 0; i--) {
                if (arr[i] == key) {
                    return i;
                }
            }
            return -1;
        	}	
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the size of array : ");
		int sizeOfArray = scan.nextInt();
		int[] arr = new int[sizeOfArray];
		System.out.println("Enter the elements in the array :");
		for (int i= 0; i< arr.length; i++)
		{
			arr[i]=scan.nextInt();
		}
		
		System.out.print("Enter the search key : ");
        int key = scan.nextInt();
        
        
        long startTime = System.nanoTime();
        
        // Using Linear Search
        int linearResult = linearSearch(arr, key);
        
        long endTime = System.nanoTime();
        
        long durationLinear = (endTime-startTime);//duration in nano seconds
        
        if (linearResult != -1) {
            System.out.println("\n\nUsing Linear Search:");
            System.out.println("Search key FOUND at index " + linearResult);
        } else {
            System.out.println("\n\nUsing Linear Search:");
            System.out.println("Search key NOT FOUND");
        }
        
        System.out.println("\nDuration for Linear Search in Nano Seconds : " + durationLinear );
        
        
        int[] arr3 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr3);
        
        long startTime1 = System.nanoTime();
        
        // Using Interpolation Search
        int interpolationResult = interpolationSearch(arr3, key);
        
        long endTime1 = System.nanoTime();
        
        long durationInterpolation = (endTime1-startTime1);//duration in nano seconds
        
        if (interpolationResult != -1) {
            System.out.println("\n\nUsing Interpolation Search:");
            System.out.println("Search key FOUND at index " + interpolationResult);
        } else {
            System.out.println("\n\nUsing Interpolation Search:");
            System.out.println("Search key NOT FOUND");
        }
        
        System.out.println("\nDuration for Interpolation Search in Nano Seconds : " + durationInterpolation );
        
        
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr2);
        long startTime2 = System.nanoTime();
        
        // Using Interpolation Search
        
        int improvedLinearResult = improvedLinearSearch(arr2, key);
        
        long endTime2 = System.nanoTime();
        
        long durationImproved = (endTime2-startTime2);//duration in nano seconds
        
        if (improvedLinearResult != -1) {
            System.out.println("\n\nUsing Improved Linear Search:");
            System.out.println("Search key FOUND at index " + improvedLinearResult);
        } else {
            System.out.println("\n\nUsing Improved Linear Search:");
            System.out.println("Search key NOT FOUND");
        }
        
        System.out.println("\nDuration for Improved Linear Search in Nano Seconds : " + durationImproved );
        
        scan.close();
    }
		

}


