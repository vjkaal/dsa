class LinkedList{

  Node head;
  Node current, prev;
  Node PreviousOfPrev;

  private static int size = 0;

  public LinkedList(){}
  public LinkedList(int data){head = new Node(data);size++;}

  private static class Node{
    int data;
    Node next;

    public Node(int data){this.data = data;}

    public void setData(int data){this.data = data;}
    public void setNext(Node next){this.next = next;}

    public int getData(){return this.data;}
    public Node getNext(){return this.next;}
  }

  public void insert(int data){
    if(head == null){
      head = new Node(data);
      prev = head;
    }
    else{
      PreviousOfPrev = prev;
      current = new Node(data);
      prev.setNext(current);
      prev = current;
    }
    size++;
  }

  public void insertHead(int data){
    current = new Node(data);
    current.setNext(head);
    head = current;
    size++;
  }

  public void insertAfter(int elem, int data){
    if(head == null) return;
    current = head;
    while(current != null){
      // System.out.println(current.getData());
      if(current.getData()==elem){
        Node temp = new Node(data);
        temp.setNext(current.getNext());
        current.setNext(temp);
        size++;
      }
      current = current.getNext();
    }
  }

  public void removeS_Elem(int data){
    if(head == null) return;
    else if(head.getData() == data){
      head = head.getNext();
      return;
    }
    else{
      current = head.getNext();
      Node previous = head; // only for this specific method, DONOT confuse with prev(global var)
      while(current != null){
        if(current.getNext() == null && current.getData() == data) previous.setNext(null);
        else if(current.getData() == data) previous.setNext(current.getNext());
        else current = current.getNext();
        previous = current;
      }
      size--;
    }
  }

  public void remove(){
    if(head == null) return;
    // System.out.println(prev.getData());
    PreviousOfPrev.setNext(null);
  }

  public void removeHead(){
    if(head == null) return;
    head = head.getNext();
    size--;
  }

  public void traverseList(){
    if(head == null) return;
    current = head;
    while(current != null){
      System.out.print(current.getData()+"->");
      current = current.getNext();
    }
    System.out.println("null");
  }

  public int getMidElem(){
    if(head == null) return -1;
    current = head;
    for(int i=0;i<size/2;i++){
      current = current.getNext();
    }
    return current.getData();
  }

  public String search(int elem){
    if(head == null) return "-1";
    current = head;
    int i=0;
    while(current != null){
      if(current.getData() == elem) return String.format("found at position: "+i);
      else i++;
    }
    return "not found";
  }

  private int largestElem(){
    current = head;
    int elem = current.getData();
    while(current!=null){
      if(elem < current.getData()) elem = current.getData();
      current = current.getNext();
    }
    return elem;
  }

  private int smallestElem(){
    current = head;
    int elem = current.getData();
    while(current!=null){
      if(elem > current.getData()) elem = current.getData();
      current = current.getNext();
    }
    return elem;
  }

  public void sortList(){
    current = head;
    int[] array = new int[size];
    int i=0;
    while(current != null){
      array[i] = current.getData();
      current = current.getNext();
      i++;
    }
    // printArray(array);
    sort(array);

    System.out.println(smallestElem());
    System.out.println(largestElem());

    current = head;
    i=0;
    while(current!=null || i < size){
      current.setData(array[i]);
      current=current.getNext();
      i++;
    }
  }

  // private void printArray(int[] arr){
    //   for(int i:arr) System.out.print(i+" ");
    //   System.out.println();
    // }

  private void sort(int[] array){
    mergeSort(array, 0, array.length-1);
  }

  private void mergeSort(int[] array, int l, int h){
    if(h-l>64){
      int part = (int)((l+h)/2);
      mergeSort(array,l, part);
      mergeSort(array,part+1, h);
      merge(array,l, part, h);
    }
    else insertionSort(array, l, h);
  }


  private void merge(int[] array,int l, int m, int h){
    int p = m-l+1;
    int q = h-m;

    int[] a1 = new int[p];
    int[] a2 = new int[q];
    for(int i=0;i<p;i++) a1[i] = array[l+i];
    for(int j=0;j<q;j++) a2[j] = array[m+1+j];

    // for(int i:a1) System.out.print(i+" ");
    // System.out.println();
    //
    // for(int i:a2) System.out.print(i+" ");
    // System.out.println();

    // for(int i:a1) std::cout<<i<<" ";
    // std::cout<<"\n";

    // for(int j:a2) std::cout<<j<<" ";
    // std::cout<<"\n";

    int x=0, y=0, z=l;
    while(x<p && y<q){
      if(a1[x] < a2[y]){
        array[z] = a1[x];
        x++;
      }
      else{
        array[z] = a2[y];
        y++;
      }
      z++;
    }

    while(x<p){
      array[z] = a1[x];
      z++;
      x++;
    }
    while(y<q){
      array[z] = a2[y];
      z++;
      y++;
    }

    // for(int i:array) System.out.print(i+" ");
    // System.out.println();
  }

  private void insertionSort(int[] array, int l, int h){
    for(int i=l+1;i<=h;i++){
      int key = array[i];
      int j=i-1;
      for(;j>=l && array[j]> key;j--){
        array[j+1] = array[j];
      }
      j++;
      array[j] = key;
      // if(i == 2) break;
    }
  }

  public boolean deleteList(){
    head = null;
    return head == null;
  }
}
