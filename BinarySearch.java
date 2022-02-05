class BinarySearch{
  public void search(int[] array, int elem){
    if(array.length == 0){
      System.out.println("Array empty");
      return;
    }
    if(!chkSorted(array)){
      System.out.println("Array not sorted");
      return;
    }
    // chk front
    if(array[0] == elem){
      System.out.println(elem + " found at start");
      return;
    }

    //chk Rear
    if(array[array.length-1] == elem){
      System.out.println(elem + " found at rear");
      return;
    }

    // proper binary search
    int res = bs(array, 0, array.length-1, elem);
    if(res >= 0) System.out.println(elem + " found at position " + res);
    else System.out.println(elem + " not found");
  }

  private int bs(int[] array, int low, int high, int elem){
    if(high >= low){
      int mid = (int) (low + high)/2;
      System.out.println(array[low] + " " + array[mid] + " " + array[high] + " " + elem);
      if(elem == array[mid]) return mid;
      else if(elem < array[mid]) return bs(array, low, mid-1, elem);
      else return bs(array, mid+1, high, elem);
    }
    else return -1;
  }

  private boolean chkSorted(int[] array){
    for(int i=0;i<array.length-1;i++) if(array[i] > array[i+1]) return false;
    return true;
  }
}
