import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


class Main {

  static ArrayList<String> nameList; // Is this how class variable should be? and Method don't call for it in the ()?
  static ArrayList<String> nameTemp;
  static ArrayList<Integer> scoreList;
  static ArrayList<Integer> scoreTemp;

  static String[] bubbleMethod () //ArrayList<String> nameList, ArrayList<String> tempName
  {
    String nametempSwap; // to hold swap
    int numtempSwap;

    // Loop to sort
    for (int i=0; i<nameList.size(); i++)
    {
      for (int j=0; j<nameList.size(); j++)
      {
        if (nameList.get(i).compareTo(nameList.get(j+1)) > 0)
        {
          int index = 0;
          nametempSwap = nameList.get(j);
          nameList.set(j, nameList.get(index));
          nameList.set(index, nametempSwap); 
        }
      }
    }
    return nameList;
    // Loop to sort
    for (int i=0; i<scoreList.size(); i++) //scoreTemp?
    {
      for (int j=0; j<scoreList.size(); j++)
      {
        if (scoreList.get(i) > scoreList.get(j+1))
        {
          int index = 0;
          numtempSwap = scoreList.get(j);
          scoreList.set(j, scoreList.get(index));
          scoreList.set(index, numtempSwap); 
        }
      }
    }
    return scoreList;
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


    Scanner reader = new Scanner ("file.txt");
    // For loop to write the file to the ArrayLists
    for (int i=0; i<=3; i++)
    {
        reader.nextInt();
        nameList.add(reader.next(i));
    }

    for (int i=4; i<=scoreList.size(); i++)
    {
      scoreList.add(reader.next(i));
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

    //Sort and output the sorted data
    bubbleMethod();
    System.out.println("Here is your sorted data:");
    System.out.println(nameList);
    System.out.println(scoreList);


    // Write ArrayList to file.txt, if the user chooses yes
    System.out.println("Would you like to save to the file?");
    Answer = input.nextLine().toLowerCase();

    if (Answer.equals(("Yes").toLowerCase()))
    {
    FileWriter nameListWriter = new FileWriter ("file.txt"); 
    FileWriter scoreListWriter = new FileWriter ("file.txt");
    for (int i=0; i<nameList.size(); i++)
    {
      if (nameList(i)!=0) //Or should it be nameList.get(i)?
      {
        nameListWriter.write(nameTemp(i) + "\n");
      }
    }
    nameListWriter.close();
    for (int j=0; j<scoreList.size(); j++)
    {
      if (scorelist.get(j)!=0)
      {
        scoreListWriter.write(scoreTemp(j) + "\n");
      }
    }
    scoreListWriter.close();
    }
    else 
    System.out.println(nameList);
    System.out.println(nameTemp);

  }
}