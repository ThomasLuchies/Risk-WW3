package Console;

import Risk.Core.Bord;
import Risk.Core.Country;
import Risk.Core.Field;
import Risk.Core.Player;
import Risk.Core.Troops.Troop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static BordRenderer bordRenderer;
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

        Player player1 = createPlayer(scanner, 1, bord);
        Player player2 = createPlayer(scanner, 2, bord);
        bord.addPlayer(player1);
        bord.addPlayer(player2);

        bord.createFields();
        bord.divideFields();

        System.out.println("test");
        boolean gameInProgess = true;
        while(gameInProgess)
        {
            turn(player1, bord);
            if(checkForWin(bord))
                break;
            turn(player2, bord);
            if(checkForWin(bord))
                break;
        }
    }

    public static boolean checkForWin(Bord bord)
    {
        Player player = null;
        if((player = bord.checkForWin()) != null)
        {
            System.out.println("player " + player.getPlayerNumber() + " lost");
        }

        return false;
    }

    public static void turn(Player player, Bord bord)
    {
        Scanner scanner = new Scanner(System.in);
        turnLoop: while(true)
        {
            cls();
            bordRenderer = new BordRenderer();
            System.out.println(bordRenderer.renderBord(bord));

            //player 1 turn
            System.out.println("Player " + player.getPlayerNumber() + " turn:");
            System.out.println("what do you wan't to do:");
            System.out.println("1: Place troops");
            System.out.println("2: Invade");
            System.out.println("3: End Turn");

            String playerChoice = scanner.nextLine();

            switch(Integer.parseInt(playerChoice))
            {
                case 1:
                    Field fieldToPlace = null;
                    cls();
                    System.out.println(bordRenderer.renderBord(bord));
                    while(true)
                    {
                        System.out.println("On which field do you wan't to place the troop\nPlease enter the coordinates in the following way: X-Y");
                        playerChoice = scanner.nextLine();
                        if(playerChoice.contains("-"))
                        {
                            String[] coordinates = playerChoice.split("-");
                            for(Field field : bord.getFields())
                            {
                                if(field.getCoords().getX() == Integer.parseInt(coordinates[0]) && field.getCoords().getY() == Integer.parseInt(coordinates[1]))
                                {
                                    if(field.getOwner() != null)
                                    {
                                        if(field.getOwner() == player)
                                        {
                                            fieldToPlace = field;
                                        }
                                    }
                                }
                            }

                            if(fieldToPlace == null)
                            {
                                cls();
                                System.out.println(bordRenderer.renderBord(bord));
                                System.out.println("This field is not owned by you");
                            }
                            else
                            {
                                break;
                            }
                        }
                        else
                        {
                            cls();
                            System.out.println(bordRenderer.renderBord(bord));
                            System.out.println("Invalid input");
                        }
                    }

                    cls();
                    System.out.println(bordRenderer.renderBord(bord));
                    ArrayList<Troop> troopsToPlace = new ArrayList<>();
                    int pointsSpend = 0;
                    troopPlacingLoop: while(true)
                    {
                        int maxPointsToSpend = bord.getMaxTroopsToPlace(player, fieldToPlace);
                        while(true)
                        {
                            System.out.println(pointsSpend);
                            System.out.println("Which troops do you wan't to place");
                            System.out.println("You can place troops up to " + (maxPointsToSpend - pointsSpend) + " points");
                            System.out.println("1: Infantry  -- 1 point");
                            System.out.println("2: Cavalry   -- 5 points");
                            System.out.println("3: Artillery -- 10 points");
                            playerChoice = scanner.nextLine();

                            if(Integer.parseInt(playerChoice) == 1)
                            {
                                troopsToPlace.add(bord.getTroopCreator().createInfantry(player));
                                pointsSpend += 1;
                            }
                            else if(Integer.parseInt(playerChoice)  == 2)
                            {
                                troopsToPlace.add(bord.getTroopCreator().createCavalry(player));
                                pointsSpend += 5;
                            }
                            else if(Integer.parseInt(playerChoice)  == 3)
                            {
                                pointsSpend += 10;
                                troopsToPlace.add(bord.getTroopCreator().createArtillery(player));
                            }
                            else
                            {
                                System.out.println("Invalid input");
                                cls();
                                System.out.println(bordRenderer.renderBord(bord));
                            }

                            if(maxPointsToSpend == pointsSpend)
                            {
                                break troopPlacingLoop;
                            }

                            cls();
                            System.out.println(bordRenderer.renderBord(bord));
                            System.out.println("Do you wan't to place another troop?");
                            System.out.println("1: Yes");
                            System.out.println("2: No");
                            playerChoice = scanner.nextLine();

                            cls();
                            System.out.println(bordRenderer.renderBord(bord));
                            if(Integer.parseInt(playerChoice) == 2)
                            {
                                break troopPlacingLoop;
                            }

                            break;

                        }
                    }

                    bord.placeTroop(troopsToPlace, fieldToPlace, player);
                    cls();
                    System.out.println(bordRenderer.renderBord(bord));
                    break;
                case 2:
                    Field attackingField = null;
                    Field defendingField = null;
                    cls();
                    System.out.println(bordRenderer.renderBord(bord));
                    while(true)
                    {
                        System.out.println("Which field do you want to use to attack \nPlease enter the coordinates in the following way: X-Y");
                        playerChoice = scanner.nextLine();
                        if (playerChoice.contains("-"))
                        {
                            String[] coordinates = playerChoice.split("-");
                            for (Field field : bord.getFields())
                            {
                                if (field.getCoords().getX() == Integer.parseInt(coordinates[0]) && field.getCoords().getY() == Integer.parseInt(coordinates[1]))
                                {
                                    if (field.getOwner() != null)
                                    {
                                        if (field.getOwner() == player)
                                        {
                                            if(bord.canAttack(field))
                                            {
                                                attackingField = field;
                                            }
                                            else
                                            {
                                                cls();
                                                System.out.println(bordRenderer.renderBord(bord));
                                                System.out.println("An attacking field needs to have at least 2 troops available");
                                                System.out.println("Press any key to continue");
                                                scanner.nextLine();
                                                continue turnLoop;
                                            }
                                        }
                                    }
                                }
                            }

                            if (attackingField == null)
                            {
                                cls();
                                System.out.println(bordRenderer.renderBord(bord));
                                System.out.println("This field is not owned by you");
                            } else
                            {
                                break;
                            }
                        } else
                        {
                            cls();
                            System.out.println(bordRenderer.renderBord(bord));
                            System.out.println("Invalid input");
                        }
                    }

                    attackingField.getOwner().attack(attackingField);
                    cls();
                    System.out.println(bordRenderer.renderBord(bord));
                    System.out.println("Invalid input");
                    while(true)
                    {
                        System.out.println("Which field do you want to attack\nPlease enter the coordinates in the following way: X-Y");
                        playerChoice = scanner.nextLine();
                        if (playerChoice.contains("-"))
                        {
                            String[] coordinates = playerChoice.split("-");
                            for (Field field : bord.getFields())
                            {
                                if (field.getCoords().getX() == Integer.parseInt(coordinates[0]) && field.getCoords().getY() == Integer.parseInt(coordinates[1]))
                                {
                                    if (field.getOwner() != null)
                                    {
                                        if (field.getOwner() != player)
                                        {
                                            defendingField = field;
                                        }
                                    }
                                }
                            }

                            if (attackingField == null)
                            {
                                cls();
                                System.out.println(bordRenderer.renderBord(bord));
                                System.out.println("This field is owned by you and cannot be attacked please try again");
                            } else
                            {
                                break;
                            }
                        } else
                        {
                            cls();
                            System.out.println(bordRenderer.renderBord(bord));
                            System.out.println("Invalid input");
                        }
                    }
                    defendingField.getOwner().defend(defendingField);

                    break;
                case 3:
                    bord.nextState();
                    break;
                default:
                    cls();
                    System.out.println(bordRenderer.renderBord(bord));
                    System.out.println("Invalid input please enter between a number between 1 and 3");
                    System.out.println("Press any key to continue");
                    scanner.nextLine();
                    continue turnLoop;

            }
            break;
        }
    }

    public static Player createPlayer(Scanner scanner, int playerNumber, Bord bord)
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
                Player player = new Player(playerCountry, playerNumber, bord);
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
