class Queue{

  int[] array;
  int size = 0;
  int front = -1;
  int rear = -1;

  public Queue(int size){
    this.size = size;
    array = new int[size];
  }

  public boolean isEmpty(){
    return front == -1;
  }

  public boolean isFull(){
    return (front == 0 && rear == size-1);
  }

  public void enqueue(int elem){
    if(isFull()){
      System.out.println("Queue Full");
      return;
    }
    else{
      if(front == -1) front = 0;
      if(front > 0 && rear == size-1) {
        int x = 0;
        for(int i=front;i<rear;i++){
          array[x] = array[i];
          x++;
        }
        front=0;
        rear=x;
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
      else front++;
    }
  }

  public void printQueue(){
    if(!isEmpty()){
      for(int i=front;i<=rear;i++) System.out.print(array[i]+" ");
      System.out.println();
    }
  }
}
