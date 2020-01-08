import java.util.*;
import java.io.*;

public class PrintArgs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i <args.length;i++) {
			System.out.println("Element "+ i +" is "+args[i]);
		}
		
		int [][] matrix= null;
		int R = matrix.length;
		int [][] newMatrix = new int [R][];
		
		for (int i=0; i<R;i++) {
			newMatrix[i]= Arrays.copyOf(matrix[i]);
		}
		}
	}

