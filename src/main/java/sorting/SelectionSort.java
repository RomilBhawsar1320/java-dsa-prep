
package sorting;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};
        int n = arr.length;

        // Move boundary of unsorted array one step at a time
        for(int i = 0; i < n - 1; i++) {

            // Assume current element is the minimum
            int minIndex = i;

            // Find the smallest element in the remaining unsorted part
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Place the smallest element at its correct position
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        // Print sorted array
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// Selection Sort
// Strategy:
// 1. Assume the current index has the minimum element.
// 2. Search the remaining unsorted part to find the actual minimum.
// 3. Swap the minimum element with the current index.
// 4. After each pass, one element is placed in its correct sorted position.
// 5. best , worst and average case time complexity is O(n^2) and space complexity is O(1)
//6. why Selection Sort is not stable: Because it swaps elements, it can change the relative order of equal elements. For example,
// if two equal elements are present,
// the one that appears later in the array may be moved before the one that appears earlier, thus changing their original order.
// 7. why space complexity is O(1): Selection Sort sorts the array in place, meaning it does not require any additional storage
// that scales with the input size. It only uses a fixed amount of extra space for variables like minIndex and temp,
// regardless of the size of the input array.

