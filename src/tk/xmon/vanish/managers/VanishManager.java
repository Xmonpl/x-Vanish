package tk.xmon.vanish.managers;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VanishManager {
    public static ArrayList<Player> vanishedPlayers = new ArrayList<Player>();

    public static boolean isOnVanish(Player u) {
        return VanishManager.vanishedPlayers.contains(u);
    }

    public static void addPlayer(Player u) {
        VanishManager.vanishedPlayers.add(u);
    }

    public static void removePlayer(Player u) {
        VanishManager.vanishedPlayers.remove(u);
    }
}
