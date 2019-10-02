package javaBasics;



import java.util.Arrays;

public class multihw {
	public static void main(String[] args) {
		Arrays.toString(bubbleSort4(new int[]{95663},1));
	}
	
	public static int[] bubbleSort4(int[] array, int threshold) {
		if( array.length == 0 )
			return new int[] {};
	    int middle = array.length/2;

	    // two arrays to store two halfs
	    int[] array1;
	    int[] array2;

	    // print out the original array
	    System.out.println("Whole array before sort" + Arrays.toString(array));

	    // copy using Arrays function and print them out
	    array1 = Arrays.copyOfRange(array, 0, middle);
	    System.out.println("Division before sort" + Arrays.toString(array1));
	    array2 = Arrays.copyOfRange(array, middle, array.length);
	    System.out.println("Division before sort" + Arrays.toString(array2));

	    // create two threads to handle
	    Thread t1 = new Thread(new BubbleSort4(array2, threshold));
	    Thread t2 = new Thread(new BubbleSort4(array1, threshold));

	    t1.start();
	    t2.start();

	    try {
	        t1.join();
	        t2.join();
	    } catch (InterruptedException ie) {
	        ie.printStackTrace();
	    }


	    System.out.println("Divided array after sort" + Arrays.toString(array1));
	    System.out.println("Divided array after sort" + Arrays.toString(array2));


	    int[] result = merge(array1, array2);

	    System.out.println("Merged divided arrays" + Arrays.toString(result));
	    return result;

	}

	public static int[] merge(int[] array1, int[] array2){
	    int[] rtn = new int[array1.length + array2.length];
	    int i1 = array1.length - 1, i2 = array2.length - 1, i3 = rtn.length - 1;
	    while( i1 > -1 && i2 > -1 ){
	        if( array1[i1] > array2[i2] ){
	            rtn[i3--] = array1[i1--];
	        }else{
	            rtn[i3--] = array2[i2--];
	        }
	    }
	    if( i1 < 0 ){
	        while( i2 > -1 ){
	            rtn[i3--] = array2[i2--];
	        }
	        if( i3 != -1 ){
	            System.out.println("Error in i3i2");
	            return new int[] {};
	        }
	    }else{
	        while( i1 > -1 ){
	            rtn[i3--] = array1[i1--];
	        }
	        if( i3 != -1 ){
	            System.out.println("Error in i3i1");
	            return new int[] {};
	        }
	    }
	    return rtn;
	}
}

class BubbleSort4 implements Runnable{ 
	int[] array;
	int threshold;
	
	public BubbleSort4(int[] array2, int threshold) {
		array = array2;
		this.threshold = threshold;
	}

	@Override
	public void run(){
        if( array.length > threshold) {
            // print out the original array
        	int middle = array.length / 2;
            System.out.println("Whole array before sort" + Arrays.toString(array));

            // copy using Arrays function and print them out
            int[] array1 = Arrays.copyOfRange(array, 0, middle);
            System.out.println("Division before sort" + Arrays.toString(array1));
            int[] array2 = Arrays.copyOfRange(array, middle, array.length);
            System.out.println("Division before sort" + Arrays.toString(array2));

            //
            Thread t1 = new Thread(new BubbleSort4(array2, threshold));
            Thread t2 = new Thread(new BubbleSort4(array1, threshold));

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            
    	    System.out.println("Divided array after sort" + Arrays.toString(array1));
    	    System.out.println("Divided array after sort" + Arrays.toString(array2));

            merge(array1, array2, array);

        }
        else {
            // start from the last index
            int len = array.length - 1;
            while( len > 0 ) {
                for( int i = 0; i < len; ++i ) {
                    if( array[i] > array[i+1] ) {
                        int temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                    }
                }
                --len;
            }
        }

    }

    public void merge(int[] array1, int[] array2, int[] array){
        if( array1.length + array2.length != array.length) {
            System.out.println("wrong!");
            return;
        }
        int i1 = array1.length - 1, i2 = array2.length - 1, i3 = array.length - 1;
        while( i1 > -1 && i2 > -1 ){
            if( array1[i1] > array2[i2] ){
                array[i3--] = array1[i1--];
            }else{
                array[i3--] = array2[i2--];
            }
        }
        if( i1 < 0 ){
            while( i2 > -1 ){
                array[i3--] = array2[i2--];
            }
            if( i3 != -1 )
                System.out.println("Error in i3i2");
        }else{
            while( i1 > -1 ){
                array[i3--] = array1[i1--];
            }
            if( i3 != -1 )
                System.out.println("Error in i3i1");
        }
    }
}