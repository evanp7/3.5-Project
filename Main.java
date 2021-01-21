import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

class Main {
  static ArrayList<String> nameList = new ArrayList<String>(); // Is this how class variables should be? and Method don't call for it in the ()?
  static ArrayList<String> scoreList = new ArrayList<String>();

  static ArrayList<String> bubbleMethod (ArrayList<String> nameList)
  {
    String nameListSwap; // to hold swap
    // Loop to sort
    for (int i=0; i<nameList.size()-1; i++)
    {
      for (int j=0; j<nameList.size()-1; j++)
      {
        if (nameList.get(i).compareTo(nameList.get(j+1)) > 0)
        {
          int index = 0;
          nameListSwap = nameList.get(j);
          nameList.set(j, nameList.get(index));
          nameList.set(index, nameListSwap); 
        }
      }
    }
    return nameList;
  }

  static ArrayList<String> bubbleMethodNum (ArrayList<String> scoreList)
  {
    String numtempSwap;
    // Loop to sort
    for (int i=0; i<scoreList.size(); i++) //scoreList?
    {
      for (int j=0; j<scoreList.size(); j++)
      {
        if (scoreList.get(i).compareTo(scoreList.get(j+1)) > 0)
        {
          int indexNum = 4;
          indexNum ++;
          numtempSwap = scoreList.get(j);
          scoreList.set(j, scoreList.get(indexNum));
          scoreList.set(indexNum, numtempSwap); 
        }
      }
    }
    return scoreList;
  } // End of methods

  public static void main(String[] args) throws IOException {
    // Variables
    String userInput;
    String Answer;
    String scoreAnswer;
    boolean flag = true;
    int fileLength = 0;
    Scanner input = new Scanner(System.in);
    // File & reader
    File ListFile = new File ("file.txt"); // Declare file
    Scanner reader = new Scanner (ListFile); // File reader


    // While loop for file length
    while (reader.hasNextLine())
    {
      fileLength = fileLength + 1;
      reader.nextLine();
    }
    reader.close();
    reader = new Scanner(ListFile);


    // For loop to write the file to the ArrayLists
    for (int i=0; i<fileLength/2; i++)
    {
      nameList.add(reader.nextLine());
    }

    for (int i=0; i<fileLength/2; i++)
    {
      scoreList.add(reader.nextLine());
    }
    reader.close();


    //Adding names and scores to temp ArrayList
    System.out.println ("Would you like to add names and scores?");
    Answer = input.nextLine().toLowerCase();
    if (Answer.equals(("Yes").toLowerCase()))
    {
      System.out.println("Enter the name");
      Answer = input.nextLine();
      nameList.add(Answer);
      System.out.println("Enter the score");
      scoreAnswer = input.nextLine();
      scoreList.add(scoreAnswer);
    }
    else
    {
      System.out.println("You've exited the program. Here is the current list:");
      System.out.println(nameList);
      flag = false;
    }
    // Ask again to add to temp ArrayList
    while (flag)
    {
      System.out.println("Would you like to add more names and score?");
      Answer = input.nextLine().toLowerCase();

      if (Answer.equals(("Yes").toLowerCase()))
      {
        System.out.println("Enter the name");
        Answer = input.nextLine().toLowerCase();
        nameList.add(Answer + "\n");
        System.out.println("Enter the score");
        scoreAnswer = input.nextLine();
        scoreList.add(scoreAnswer + "\n");
        flag = true;
      }
      else
      {
        flag = false;
      }
    }


    // User entry delete
    System.out.println("Would you like to delete entries?");
    userInput = input.nextLine().toLowerCase();

    int index = 0;
    if (userInput.equals(("Yes").toLowerCase()))
    {
      System.out.println("Please enter the name that you want to delete:");
      Answer = input.nextLine().toLowerCase();
      // Find matching entry and delete
      while (index < nameList.size())
      {
        if (nameList.get(index).toLowerCase().equals(userInput))
        {
          nameList.remove(index);
          scoreList.remove(index);
          while (nameList.get(index).toLowerCase().equals(userInput))
          {
            nameList.remove(index);
            scoreList.remove(index);
          }
        }
      index = index + 1;
      } // End of loop
    }
    else
    {
      System.out.println(nameList);
      System.out.println(scoreList);
    }

    //Overwrite
    nameList.equals(nameList);
    scoreList = scoreList;


    //Sort and output the sorted data
    // bubbleMethod(nameList);
    // bubbleMethodNum(scoreList);
    System.out.println("Here is your sorted data:");
    System.out.println(nameList);
    System.out.println(scoreList);


    // Write ArrayList to file.txt
    System.out.println("Would you like to save to the file?");
    Answer = input.nextLine().toLowerCase();

    if (Answer.equals(("Yes").toLowerCase()))
    {
    FileWriter ListWriter = new FileWriter ("file.txt"); 
    for (int i=0; i<nameList.size(); i++)
    {
      ListWriter.write(nameList.get(i) + "\n");
    }
    for (int j=0; j<scoreList.size(); j++)
    {
      ListWriter.write(scoreList.get(j) + "\n");
    }
    ListWriter.close();
    }

  }
}