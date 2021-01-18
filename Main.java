import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Main {
  static char[] bubbleMethod (char charList[])
  {
    char tempSwap; // to hold swap

    // Loop to sort
    for (int i=0; i<charList.length-1; i++)
    {
      for (int j=0; j<charList.length-1; j++)
      {
        if (Character.toLowerCase(charList[j])>Character.toLowerCase(charList[j+1]))
        {
          tempSwap = charList[j];
          charList[j] = charList[j+1];
          charList[j+1] = tempSwap; 
        }
      }
    }
    return charList;
  }

  public static void main(String[] args) throws IOException {
    // Variables
    String userInput;
    String Answer;
    int scoreAnswer;
    Scanner input = new Scanner(System.in);

    // File & reader
    File nameListFile = new File ("file.txt"); // Declare file
    File scoreListFile = new File ("file.txt");
    Scanner nameListReader = new Scanner (nameListFile); // File reader
    Scanner scoreListReader = new Scanner (scoreListFile);

    // Name and score ArrayList
    ArrayList<String> nameList = new ArrayList<String>();
    ArrayList<Integer> scoreList = new ArrayList<Integer>();

    // Temporary ArrayList, copies content from original ArrayLists -- This should not share same reference as the original
    ArrayList<String> nameTemp = new ArrayList<String>(nameList);
    ArrayList<Integer> scoreTemp = new ArrayList<Integer>(scoreList);   


    // Writing file to temporary ArrayLists
    Scanner reader = new Scanner ("file.txt");
    // For loop to write the file to the ArrayLists
    for (int i=0; i<=3; i++)
    {
      for (int index=i; index<=scoreList.size(); index++)
      {
        reader.nextInt();
        nameTemp.add(reader.next(i));
        scoreTemp.add(reader.nextInt(index));
      }
    }
    // while (reader.hasNext())
    // {
    //   nameList.add(reader.next());
    // }
    // reader.close();


    // Measure number of lines 
    Scanner lineCounter = new Scanner (new FileReader("file.txt"));
    int numofLines = 0;
    While (lineCounter.hasNextLine());
    {
      lineCounter.nextLine();
      numofLines ++;
    }

    //Adding names and scores to temp ArrayList
    System.out.println ("Would you like to add names and scores?");
    Answer = input.nextLine().toLowerCase();
    
    if (Answer.equals(("Yes").toLowerCase()))
    {
      System.out.println("Enter the name");
      Answer = input.nextLine().toLowerCase();
      nameTemp.add(Answer);
      System.out.println("Enter the score");
      scoreAnswer = Integer.parseInt(input.nextLine());
      scoreTemp.add(scoreAnswer);
    }
    else
      System.out.println("You've exited the program. Here is the current list:");
      System.out.println(nameList);


    // Ask again to add to temp ArrayList
    boolean flag = true;
    while (flag)
    {
      System.out.println("Would you like to add more names and score?");
      Answer = input.nextLine().toLowerCase();

      if (Answer.equals(("Yes").toLowerCase()))
      {
        System.out.println("Enter the name");
        Answer = input.nextLine().toLowerCase();
        nameTemp.add(Answer);
        System.out.println("Enter the score");
        scoreAnswer = Integer.parseInt(input.nextLine());
        scoreTemp.add(scoreAnswer);
        flag = true;
      }
      else
      {
        flag = false;
      }
    }
    
    // Write ArrayList to file.txt

    // FileWriter nameListWriter = new FileWriter ("file.txt"); // File writer
    // FileWriter scoreListWriter = new FileWriter ("file.txt");
    


    System.out.println(nameList);
    System.out.println(nameTemp);









































  }
}