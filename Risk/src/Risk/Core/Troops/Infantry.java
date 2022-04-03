package Risk.Core.Troops;

import Risk.Core.Player;

public class Infantry extends Troop{
    public Infantry(Player player) {
        super(1, player); // An infantry is the basic troop which means it is worth 1 troop
    }
}
