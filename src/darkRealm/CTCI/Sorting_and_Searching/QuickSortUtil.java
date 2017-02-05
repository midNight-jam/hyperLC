package darkRealm.CTCI.Sorting_and_Searching;

import java.util.Random;

/**
 * Created by Jayam on 1/10/2017.
 */
public class QuickSortUtil {
  public static void quicksort(int[] arr, int low, int high) {

    int partition = findPivot(arr, low, high);
    if (low < partition - 1)
      quicksort(arr, low, partition - 1);
    if (partition < high)
      quicksort(arr, partition, high);
  }

  private static int findPivot(int[] arr, int low, int high) {
    int pivot = arr[(low + high) / 2];
    while (low <= high) {
      while (arr[low] < pivot) {
        low++;
      }
      while (pivot < arr[high]) {
        high--;
      }
      if (low <= high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        low++;
        high--;
      }
    }
    return low;
  }

  public static int kthSmallestElement(int[] arr, int low, int high, int k) {
    int pos = findModifiedPivot(arr, low, high, k);
    if (pos - 1 == k - 1) {
      return arr[pos];
    }
    // if postion is more we will find the kt samllest on further left, thus recur in left
    if (pos - 1 > k - 1) {
      return kthSmallestElement(arr, low, pos - 1, k);
    }
    // if postion is less we will find the kt samllest on further right , thus recur in right
    else {
      return kthSmallestElement(arr, pos, high, k);
    }
  }

  private static int findModifiedPivot(int[] arr, int low, int high, int k) {
    int pivot = arr[(low + high) / 2];
    while (low <= high) {
      while (arr[low] < pivot) {
        low++;
      }
      while (pivot < arr[high]) {
        high--;
      }
      if (low <= high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        low++;
        high--;
      }
    }
    return low;
  }

  public static int[] randomizedQuickSort(int[] arr, int low, int high) {
    int pivot = randomPartition(arr, low, high);
    if (low < pivot - 1) {
      randomizedQuickSort(arr, low, pivot - 1);
    }
    if (pivot < high) {
      randomPartition(arr, pivot, high);
    }
    return arr;
  }

  private static int randomPartition(int[] arr, int low, int high) {
    Random rand = new Random();
    int randIndex = low + rand.nextInt(high - low);
    int temp = arr[randIndex];
    arr[randIndex] = arr[low];
    arr[low] = temp;
    return findPivot(arr, low, high);
  }


  public static void quickSortZZ(int[] arr, int low, int high) {
    int pivot = findPivotZZ(arr, low, high);
    if (low < pivot - 1) {
      quickSortZZ(arr, low, pivot - 1);
    }
    if (pivot < high) {
      quickSortZZ(arr, pivot, high);
    }
  }

  private static int findPivotZZ(int[] arr, int low, int high) {
    int pivot;
    while (low <= high) {
      pivot = arr[low + (high - low) / 2];
      while (arr[low] < pivot) {
        low++;
      }
      while (pivot < arr[high]) {
        high--;
      }
      if (low <= high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        low++;
        high--;
      }
    }
    return low;
  }
}