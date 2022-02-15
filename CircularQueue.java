class CircularQueue{

  int[] array;
  int size;
  int front = -1, rear = -1;
  boolean circular = false;

  public CircularQueue(int size){
    this.size = size;
    array = new int[size];
  }

  public boolean isEmpty(){
    return front == -1;
  }

  public boolean isFull(){
    return ((front == 0 && rear == size-1) || (front-1 == rear));
  }

  public void enqueue(int elem){
    if(isFull()){
      System.out.println("Queue Full");
      return;
    }
    else{
      if(front == -1) front = 0;
      if(front > 0 && rear == size-1) {
        circular = true;
        rear = -1;
      }
      rear++;
      array[rear] = elem;
    }
  }

  public void dequeue(){
    if(isEmpty()){
      System.out.println("Queue Empty");
      return;
    }
    else{
      if(front == rear){
        front--;
        rear--;
      }
      else if(front == size-1){
        front = 0;
      }
      else front++;
    }
  }

  public void printQueue(){
    if(!isEmpty()){
      if(circular){
        for(int i=front;i<=size-1;i++) System.out.print(array[i]+" ");
        for(int i=0;i<=rear;i++) System.out.print(array[i]+" ");
        System.out.println();
      }
      else{
        for(int i=front;i<=rear;i++) System.out.print(array[i]+" ");
        System.out.println();
      }
    }
  }

}
