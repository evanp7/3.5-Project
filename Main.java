import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

class Main {
  static ArrayList<String> nameList; // Is this how class variables should be? and Method don't call for it in the ()?
  static ArrayList<String> nameTemp;
  static ArrayList<Integer> scoreList;
  static ArrayList<Integer> scoreTemp;


  static ArrayList<String> bubbleMethod () //ArrayList<String> nameList, ArrayList<String> tempName
  {
    String nametempSwap; // to hold swap
    // Loop to sort
    for (int i=0; i<nameTemp.size(); i++)
    {
      for (int j=0; j<nameTemp.size(); j++)
      {
        if (nameTemp.get(i).compareTo(nameTemp.get(j+1)) > 0)
        {
          int index = 0;
          nametempSwap = nameTemp.get(j);
          nameTemp.set(j, nameTemp.get(index));
          nameTemp.set(index, nametempSwap); 
        }
      }
    }
    return nameList;
  }

  static ArrayList<Integer> bubblemethod2 ()
  {
    int numtempSwap;
    // Loop to sort
    for (int i=0; i<scoreTemp.size(); i++) //scoreTemp?
    {
      for (int j=0; j<scoreTemp.size(); j++)
      {
        if (scoretemp.get(i) > scoreTemp.get(j+1))
        {
          int index = 4;
          index ++;
          numtempSwap = scoreTemp.get(j);
          scoreTemp.set(j, scoreTemp.get(index));
          scoreTemp.set(index, numtempSwap); 
        }
      }
    }
    return scoreList;
  } // End of methods


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
        reader.next();
        nameList.add(reader.next());
    }

    for (int i=4; i<=scoreList.size(); i++)
    {
      reader.nextInt();
      scoreList.add(reader.next());
    }
    reader.close();


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
      if (Integer.parseInt(nameList.get(i)) != 0)
      {
        nameListWriter.write(nameTemp.get(i) + "\n");
      }
    }
    nameListWriter.close();
    for (int j=0; j<scoreList.size(); j++)
    {
      if (scoreList.get(j)!=0)
      {
        scoreListWriter.write(scoreTemp.get(j) + "\n");
      }
    }
    scoreListWriter.close();
    }
    else 
    System.out.println(nameTemp, scoreTemp);


    // User entry delete
    System.out.println("Would you like to delete entries?");
    userInput = input.nextLine().toLowerCase();

    if (userInput.equals(("Yes").toLowerCase()))
    {
      System.out.println("Please enter the name that you want to delete:");
      userInput = input.nextLine().toLowerCase();
      // Find matching entry and delete them
      for (int i=0; i<pokemonList.size(); i++){
        if (nameList.get(i).toLowerCase().indexOf(userInput) > -1)
        {
          pokemonList.remove(i);
          while (pokemonList.get(i).toLowerCase().indexOf(userInput) > -1) {
            pokemonList.remove(i);
          }
        }
      } // End of loop

      System.out.println("Please enter the score that you want to delete:");
      userInput = input.nextLine().toLowerCase();
      // To find Pokemons with matching letters
      for (int i=0; i<pokemonList.size(); i++){
        if (pokemonList.get(i).toLowerCase().indexOf(userInput) > -1)
        {
          pokemonList.remove(i);
          while (pokemonList.get(i).toLowerCase().indexOf(userInput) > -1) {
            pokemonList.remove(i);
          }
        }
      } // End of loop
    }
    else
      System.out.println(nameTemp, scoreTemp);




  }
}