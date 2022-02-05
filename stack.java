import java.util.Arrays;

class stack{

  int size = 0;
  int top = -1;

  int[] array;

  public stack(int size){
    this.size = size;
    array = new int[size];
    Arrays.fill(array, -1);
    // printStack();
  }

  public void push(int a){
    if(!isFull()){
      top++;
      array[top] = a;
    }
    else System.out.println("Error: Stack full");
  }

  public void pop(){
    if(!isEmpty()){
      array[top] = -1;
      --top;
    }
    else System.out.println("Error: Stack already empty");
  }

  public int peek(){
    if(!isEmpty()){
      return array[top];
    }
    else return -1;
  }

  public int getSize(){
    return this.size;
  }

  public boolean isFull(){
    return top == size-1;
  }

  public boolean isEmpty(){
    return top == -1;
  }

  private void printStack(){
    for(int i:array) System.out.print(i+" ");
    System.out.println();
  }
}
