class InsertionSort{
  public void sort(int[] array){
    insertionSort(array);
  }

  private void insertionSort(int[] array){
    for(int i=1;i<array.length;i++){
      int key = array[i];
      int j=i-1;
      for(;j>=0 && array[j]> key;j--){
        array[j+1] = array[j];
      }
      j++;
      array[j] = key;
      // if(i == 2) break;
    }
  }
}
