package tk.xmon.vanish.utils;

import org.bukkit.ChatColor;

public class ChatUtil {
    public static String fixColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text.replace(">>", "»").replace("<<", "«").replace("*", "¢").replace("{O}", "\u2022"));
    }
}
