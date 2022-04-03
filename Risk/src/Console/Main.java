package Console;

import Risk.Core.Bord;
import Risk.Core.Country;
import Risk.Core.Player;

import java.io.IOException;
import java.util.Scanner;

public class Main
{

    public static void main(String args[]) throws IOException
    {

        Bord bord = new Bord();
        cls();
        System.out.println("--------------------");
        System.out.println("      RISK WW3      ");
        System.out.println("Press enter to start");
        System.out.println("--------------------");


        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        Player player1 = createPlayer(scanner, 1);
        Player player2 = createPlayer(scanner, 2);
        bord.addPlayer(player1);
        bord.addPlayer(player2);

        bord.createFields();
        bord.divideFields();

        boolean gameInProgess = true;
        String playerChoice = 0;
        while(gameInProgess)
        {
            cls();
            BordRenderer bordRenderer = new BordRenderer();
            System.out.println(bordRenderer.renderBord(bord.getFields()));

            //player 1 turn
            System.out.println("Player 1 turn:");
            System.out.println("what do you wan't to do:");
            System.out.println("1: Place troops");
            System.out.println("2: Invade");
            System.out.println("3: End Turn");

            playerChoice = scanner.nextLine();

            switch(Integer.parseInt(playerChoice))
            {
                case 1:
                    System.out.println("On which field do you wan't to place the troop\nPlease enter the coordinates in the following way: X-Y");
                    playerChoice = scanner.nextLine();

                    System.out.println("Which troops do you wan't to place");
                    System.out.println("1: Infantry -- 1 point");
                    System.out.println("2: Cavalry  -- 5 points");
                    System.out.println("3: Artillery     -- 10 points");
                    playerChoice = scanner.nextLine();

                    if(Integer.parseInt(playerChoice) == 1)
                    {

                    }
                    else if(Integer.parseInt(playerChoice)  == 2)
                    {

                    }
                    else if(Integer.parseInt(playerChoice)  == 3)
                    {

                    }
                    break;
                case 2:
                    break;
            }
        }
    }

    public static Player createPlayer(Scanner scanner, int playerNumber)
    {
        Country[] countries = new Country[]{Country.COLDCOUNTRY, Country.NORMALCOUNTRY, Country.WARMCOUNTRY};

        boolean inputValid = false;
        while(!inputValid)
        {
            cls();
            System.out.println("Player " + playerNumber);
            System.out.println("Please select a country");
            System.out.println("1: Cold Country");
            System.out.println("2: Normal Country");
            System.out.println("3: Warm Country");
            int playerCountrySelection = scanner.nextInt();

            if(playerCountrySelection <= 3 && playerCountrySelection >= 1)
            {
                Country playerCountry = countries[playerCountrySelection - 1];
                Player player = new Player(playerCountry, playerNumber);
                inputValid = true;
                return player;
            }
            else
            {
                System.out.println("Input was not valid please enter an input between 1 and 3");
                System.out.println("Press any key to continue");
                scanner.nextLine(); // to be fixed
            }
        }

        return null;
    }

    static void cls()
    {
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (InterruptedException | IOException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Press any key to continue...");
        }
    }
}
