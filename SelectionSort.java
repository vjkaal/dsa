class SelectionSort{
  public void sort(int[] array){
    insertionSort(array);
  }

  private void selectionSort(int[] arr){
    int smallest = 0, temp = 0;
    for(int i=0;i<arr.length-1;i++){
      smallest = i;
      for(int j=i+1;j<=arr.length-1;j++){
        if(arr[smallest] > arr[j]){
          smallest = j;
        }
      }
      temp = arr[smallest];
      arr[smallest] = arr[i];
      arr[i] = temp;
    }
  }
}
