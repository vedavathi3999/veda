import java.io.File;                     // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;       // Import the Scanner class to read text files
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
	

public class ReadFile {
   public static int[] sortArray(int array[], int n)   
	{  
	for (int i = 1; i < n; i++)  
	{  
	int j = i;  
	int a = array[i];  
	while ((j > 0) && (array[j-1] > a))     
	{  
	array[j] = array[j-1];  
	j--;  
	}  
	array[j] = a;  
	}  
        return array;  
	}

    static int minDiff(int array[], int N, int M)
    {
        int result = Integer.MAX_VALUE;
        array = sortArray(array,N);
        for (int i=0; i<= N-M;i++)
            result = Math.min(result, array[i + M - 1] - array[i]);
        return result;
    }

    static int findelements(int res,int array[], int N, int M)
    {
        int result = Integer.MAX_VALUE;
        for(int i=0; i<=N; i++)
        {
            result = Math.min(result, array[i + M - 1] - array[i]);
            if (res==result)
                return i;
        }
        return 0;
     }
  public static void main(String[] args) {
    try {
      File myObj = new File("sample_input.txt");
      int i=0;
      String items[] = new String[10];
      int array[] = new int[10];
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
  
        String data = myReader.nextLine();
         items[i] = data;
        i++;
      }
       for(int j=0;j<i;j++)
      {
          
         array[j]=Integer.parseInt(items[j].split(": ")[1]);
            
       }
     System.out.println("Enter the number of employees");
     // writing output to file 
      File file = new File("sample_output.txt");
      PrintStream stream = new PrintStream(file);
      System.setOut(stream);
        int N = array.length;
        Scanner s = new Scanner(System.in);
        int M=s.nextInt();
        int result=minDiff(array, N, M);
        System.out.println("Number of the employees:"+M);
        System.out.println("\n");
        int startindex=findelements(result,array,N,M);
        System.out.println("Here the goodies that are selected for distribution are:");
        for(int m=startindex;m<startindex+M;m++)
            System.out.println(items[m]);
        System.out.println("\n");
        System.out.println("And the difference between the chosen goodies with highest price and the lowest price is:"+result);





      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
     
    
  }


    


}
