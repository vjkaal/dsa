class LinkedList{

  Node head;
  Node current, prev;
  Node PreviousOfPrev;

  private static int SIZE = 0;

  public LinkedList(){}
  public LinkedList(int data){head = new Node(data);SIZE++;}

  public int getSize(){ return SIZE; }

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
    SIZE++;
  }

  public void insertHead(int data){
    current = new Node(data);
    current.setNext(head);
    head = current;
    SIZE++;
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
        SIZE++;
      }
      current = current.getNext();
    }
  }

  public void removeS_Elem(int data){
    if(head == null) return;

    if(head.getData() == data){
      head = head.getNext();
      return;
    }
    if(prev.getData() == data){
      remove();
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
      SIZE--;
    }
  }

  public void remove(){
    if(head == null) return;
    // System.out.println(prev.getData());
    PreviousOfPrev.setNext(null);
    setPreviousOfPrev();
    SIZE--;
  }

  private void setPreviousOfPrev(){
    if(head == null) return;
    else if(SIZE < 2) return;

    current = head;
    while(current != null){
      if(current.getNext().getNext() == null){
        PreviousOfPrev = current;
        System.out.println("set for next remove");
        return;
      }
      current = current.getNext();
    }
  }

  public void removeHead(){
    if(head == null) return;
    head = head.getNext();
    SIZE--;
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
    for(int i=0;i<SIZE/2;i++){
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
    int[] array = new int[SIZE];
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
    while(current!=null || i < SIZE){
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

  public int getNthNode(int n){
    if(head == null) return -1;
    if(n > SIZE) return -1;

    current = head;
    int curr = 0;
    int elem = 0;
    while(current!=null){
      if(n == curr){
        elem = current.getData();
      }
      current = current.getNext();
      curr++;
    }
    return elem;
  }

  public int getNthNodeRev(int n){
    if(head == null) return -1;
    if(n > SIZE) return -2;

    current = head;
    int curr = 0;
    int elem = 0;
    while(current!=null){
      if(n == (SIZE-curr)){
        elem = current.getData();
      }
      current = current.getNext();
      curr++;
    }
    return elem;
  }

  public int totalOccurences(int num){
    if(head == null) return -1;

    current = head;
    int occ = 0;
    while(current!=null){
      if(num == current.getData()) occ++;
      current = current.getNext();
    }
    return occ;
  }

  public boolean detectLoop(){
    if(head == null) return -1;

    if(prev.getNext() == null) return false;
    return true;
  }


  // CYCLING HERE

  private Node findNthNode(int n){
    if(head == null) return null;
    if(n > SIZE) return prev;

    current = head;
    int curr = 0;
    Node elem = null;
    while(current!=null){
      if(n == curr){
        elem = current;
        break;
      }
      current = current.getNext();
      curr++;
    }
    return elem;
  }

  public void createLoop(){
    Random rand = new Random();
    int n = rand.nextInt(SIZE)+1;
    System.out.println("n: "+ n);
    Node curr = findNthNode(n);
    prev.setNext(curr);
  }

  public boolean chkCycle(){
    Node curr1 = head.getNext();
    Node curr2 = head.getNext().getNext();

    while(curr2 != null || curr2.getNext() != null){
      System.out.println(curr1.getData()+" - "+curr2.getData());
      if(curr2 == curr1) return true;
      curr1 = curr1.getNext();
      if(curr2.getNext().getNext() == null) return false;
      curr2 = curr2.getNext().getNext();
    }
    return false;
  }
}
