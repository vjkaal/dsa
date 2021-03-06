class DoublyLinkedList{

  Node head;
  Node tail;
  Node current, prev;

  private static int size = 0;

  public DoublyLinkedList(){}
  public DoublyLinkedList(int data){head = new Node(data);size++;}

  private static class Node{
    Node prev;
    int data;
    Node next;

    public Node(int data){this.data = data;}

    public void setPrev(Node prev){this.prev = prev;}
    public void setData(int data){this.data = data;}
    public void setNext(Node next){this.next = next;}

    public Node getPrev(){return this.prev;}
    public int getData(){return this.data;}
    public Node getNext(){return this.next;}
  }

  public void insert(int data){
    if(head == null){
      head = new Node(data);
      head.setPrev(null);
      prev = head;
    }
    else{
      current = new Node(data);
      current.setPrev(prev);
      prev.setNext(current);
      prev = current;
    }
    size++;
  }

  public void insertHead(int data){
    current = new Node(data);
    current.setPrev(null);
    current.setNext(head);
    head.setPrev(current);
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

        temp.setPrev(current);
        temp.getNext().setPrev(temp);
        size++;
      }
      current = current.getNext();
    }
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

  public void traverseListR(){
    if(head == null) return;
    tail = prev;
    current = tail;
    while(current != null){
      System.out.print(current.getData()+"->");
      current = current.getPrev();
    }
    System.out.println("null");
  }


  public void remove(){
    if(head == null) return;
    prev = prev.getPrev();
    prev.setNext(null);
    size--;
  }

  public void removeHead(){
    if(head == null) return;
    head = head.getNext();
    head.setPrev(null);
    size--;
  }

  public void removeS_Elem(int data){
    if(head == null) return;
    else if(head.getData() == data){
      head = head.getNext();
      head.setPrev(null);
      size--;
      return;
    }
    else if(prev.getData() == data){
      prev = prev.getPrev();
      prev.setNext(null);
      size--;
      return;
    }
    Node currF = head.getNext();
    Node currB = tail.getPrev();
    while(currF != currB){
      if(currF.getData() == data){
        currF.getPrev().setNext(currF.getNext());
        currF.getNext().setPrev(currF.getPrev());
        size--;
        break;
      }
      else if(currB.getData() == data){
        currB.getPrev().setNext(currB.getNext());
        currB.getNext().setPrev(currB.getPrev());
        size--;
        break;
      }
      else if(currF == currB && currF.getData() == data){
        currF.getPrev().setNext(currF.getNext());
        currF.getNext().setPrev(currF.getPrev());
        size--;
        break;
      }
      currF = currF.getNext();
      currB = currB.getPrev();
    }
  }

}
