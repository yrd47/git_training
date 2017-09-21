package smallprograms;

public class BubbleSort {

	 public static void main(String[] args){
	        int[] array = {1,3,2,4,5,7,6,8,9,10};
	        sort(array);
	        for (int s:array) {
	            System.out.print(s + " " );
	        }
	    }

	    public static void sort(int[] array){
	        boolean swapped = true;
	        for (int i=1;swapped && i<array.length-1;i++){
	            swapped = false;
	            for(int j=0;j<array.length-i;j++){
	                if (array[j] > array[j+1]){
	                    int temp = array[j];
	                    array[j] = array[j+1];
	                    array[j+1] = temp;
	                    swapped = true;
	                }
	            }
	        }
	    }
	    
}
