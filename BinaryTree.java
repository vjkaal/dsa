public class BinaryTree{

  Node root;

  public BinaryTree(){
    root = null;
  }

  public void createTreeFromArray(int[] arr){
    root = createTree(root, 0, arr);
    inOrderTree();
  }

  private Node createTree(Node current,int i,int[] arr){
    if(i<arr.length){
      current = new Node(arr[i]);
      current.left = createTree(current.left, 2*i+1, arr);
      current.right = createTree(current.right, 2*i+2, arr);
    }
    return current;
  }

  public void inOrderTree(){
    inOrder(root);
    System.out.println();
  }

  private void inOrder(Node node){
    if (node != null){
      System.out.print(" " + '<');
      inOrder(node.left);
      System.out.print(node.data);
      inOrder(node.right);
      System.out.print('>' + " ");
    }
  }

  static class Node{
    int data;
    Node left = null, right = null;
    Node(int data){
      this.data = data;
    }
  }

}
