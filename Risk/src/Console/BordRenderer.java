package Console;

import Risk.Core.Bord;
import Risk.Core.Coords;
import Risk.Core.Field;
import Risk.Core.Player;
import Risk.Core.Troops.Troop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BordRenderer
{
    private final int AMOUNT_OF_FIELDS_X = 7;
    private final int AMOUNT_OF_FIELDS_Y = 6;
    private final String topRow =    "     0       1       2       3       4       5       6   ";
    private final String columnRow = " +-------+-------+-------+-------+-------+-------+-------+";
    private final String columnSide = "|";
    private final String columnInside = "       ";
    private final String ANSI_CYAN = "\u001B[106m";
    private final String ANSI_GREEN = "\u001B[92m";
    private final String ANSI_PURPLE = "\u001B[45m";
    private final String ANSI_RESET = "\u001B[0m";

    public String renderBord(Bord bord)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(topRow);
        HashMap<Coords, Field> playerFields = new HashMap<>();

        for(int i = 0; i < bord.getFields().size(); i++)
        {
            if(bord.getFields().get(i).getOwner() != null)
            {
                playerFields.put(bord.getFields().get(i).getCoords(), bord.getFields().get(i));
            }
        }

        for(int i = 0; i < AMOUNT_OF_FIELDS_Y; i++)
        {
            stringBuilder = createRow(stringBuilder, i, playerFields);
        }

        stringBuilder.append("\n");
        stringBuilder.append(columnRow);
        stringBuilder.append("\n");
        stringBuilder.append(ANSI_GREEN);
        stringBuilder.append(bord.getWeather().getName());
        stringBuilder.append(ANSI_RESET);
        return stringBuilder.toString();
    }

    private StringBuilder createRow(StringBuilder stringBuilder, int y, HashMap<Coords, Field> fields)
    {
        stringBuilder.append("\n");
        stringBuilder.append(columnRow);
        stringBuilder.append("\n");

        int troopCount = 0;
        boolean hasPlayer = false;

        for(int n = 0; n < 2; n++)
        {
            for(int x = 0; x < AMOUNT_OF_FIELDS_X; x++)
            {
                if(x == 0 && n == 0)
                {
                    stringBuilder.append(y);
                }
                else if(x == 0)
                {
                    stringBuilder.append(" ");
                }
                hasPlayer = false;
                stringBuilder.append(columnSide);
                for(Map.Entry<Coords, Field> field : fields.entrySet())
                {
                    troopCount = 0;
                    if(field.getKey().getX() == x && field.getKey().getY() == y)
                    {
                        hasPlayer = true;
                        if(field.getValue().getOwner().getPlayerNumber() == 1)
                        {
                            stringBuilder.append(ANSI_PURPLE);
                        }
                        else if(field.getValue().getOwner().getPlayerNumber() == 2)
                        {
                            stringBuilder.append(ANSI_CYAN);
                        }

                        for(Troop troop : field.getValue().getTroops())
                        {
                            troopCount += troop.getValue();
                        }

                        if(troopCount > 9)
                        {
                            stringBuilder.append("    ");
                        }
                        else
                        {
                            stringBuilder.append("   ");
                        }

                        if(n == 0)
                        {
                            stringBuilder.append(troopCount);
                        }
                        else
                        {
                            stringBuilder.append(" ");
                        }
                        stringBuilder.append("   ");
                    }
                }
                if(!hasPlayer)
                {
                    stringBuilder.append("       ");
                }
                stringBuilder.append(ANSI_RESET);
            }

            stringBuilder.append(columnSide);
            if(n == 0)
                stringBuilder.append("\n");
        }

        return stringBuilder;
    }
}
