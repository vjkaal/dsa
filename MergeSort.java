class MergeSort{

  public MergeSort() {
		super();
	}


  public void sort(int[] array){
    mergeSort(array, 0, array.length-1);
    // System.out.println("Called");
    //
    // for(int i:array) System.out.print(i+" ");
    // System.out.println();
  }


  private void mergeSort(int[] array, int l, int h){
    if(h>l){
      int part = (int)((l+h)/2);
      mergeSort(array,l, part);
      mergeSort(array,part+1, h);
      merge(array,l, part, h);
    }
    else return;
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
}
