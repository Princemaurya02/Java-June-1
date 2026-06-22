
// //finding Worst case and Best case time complexity of Bubble Sort
// public class sortingBubble {
//     public static void main(String[] args) {
//         int arr[] = {5, 4, 3, 2, 1}; // Worst case
//         bubbleSort(arr);
//         System.out.println("Sorted array in worst case:");
//         printArray(arr);

//         int arr2[] = {1, 2, 3, 4, 5}; // Best case
//         bubbleSort(arr2);
//         System.out.println("Sorted array in best case:");
//         printArray(arr2);
//     }

//     public static void bubbleSort(int[] arr) {
//         int n = arr.length;
//         boolean swapped;
//         for (int i = 0; i < n - 1; i++) {
//             swapped = false;
//             for (int j = 0; j < n - i - 1; j++) {
//                 if (arr[j] > arr[j + 1]) {
//                     // Swap arr[j] and arr[j+1]
//                     int temp = arr[j];
//                     arr[j] = arr[j + 1];
//                     arr[j + 1] = temp;
//                     swapped = true;
//                 }
//             }
//             // If no two elements were swapped in the inner loop, then the array is already sorted
//             if (!swapped) {
//                 break;
//             }
//         }
//     }

//     public static void printArray(int[] arr) {
//         for (int num : arr) {
//             System.out.print(num + " ");
//         }
//         System.out.println();
//     }
// }
