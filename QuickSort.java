class QuickSort{
  public void sort(int[] array){
    quickSort(array, 0, array.length-1);
  }

  private void quickSort(int[] array, int l, int h){
    if(h>l){
      int partition = partition(array, l, h);
      quickSort(array, l, partition-1);
      quickSort(array, partition+1, h);
    }
  }

  private int partition(int[] array, int l, int h){
    int pivot = array[h];
    // System.out.println(pivot);
    int i = l, j = l-1, temp = 0;
    for(;i<h;i++){
      if(array[i] <= pivot){
        ++j;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    j++;
    temp = array[j];
    array[j] = array[h];
    array[h] = temp;

    // for(int x:array) System.out.print(x+" ");
    // System.out.println();

    return j;
  }
}
