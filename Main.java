import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Main {
  static String[] bubbleMethod (ArrayList<String> nameList, ArrayList<Integer> scoreList)
  {
    String [] nametempSwap; // to hold swap
    int [] numtempSwap;

    // Loop to sort
    for (int i=0; i<nameList.size(); i++)
    {
      for (int j=0; j<nameList.size(); j++)
      {
        if (nameList.get(i)>nameList.get(j+1))
        {
          tempSwap = nameList.get(j);
          nameList.get(j) = nameList.get(j+1);
          nameList.get(j+1) = tempSwap; 
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

    //ArrayList
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
    

    //Before writing to the file.txt, overwrite the original ArrayLists w/ temporary ArrayLists
    nameTemp.equals(nameList);
    scoreTemp = scoreList;

    // Output
    System.println()


    // Write ArrayList to file.txt, if the user chooses yes
    FileWriter nameListWriter = new FileWriter ("file.txt"); 
    FileWriter scoreListWriter = new FileWriter ("file.txt");
    for (i=0; i<nameList.size(); i++)
    {
      if (nameList(i)!=0) //Or should it be nameList.get(i)?
      {
        nameListWriter.write(nameTemp(i) + "\n");
      }
    }
    nameListWriter.close();
    for (j=0; j<scoreList.size(); j++)
    {
      if (scorelist.get(j)!=0)
      {
        scoreListWriter.write(scoreTemp(j) + "\n");
      }
    }
    scoreListWriter.close();

    System.out.println(nameList);
    System.out.println(nameTemp);









































  }
}