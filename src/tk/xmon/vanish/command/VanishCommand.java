package tk.xmon.vanish.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.xmon.vanish.Vanish;
import tk.xmon.vanish.managers.VanishManager;
import tk.xmon.vanish.utils.ChatUtil;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!sender.hasPermission("xmonvanish.vanish")){
            sender.sendMessage(ChatUtil.fixColor("&4Blad: &7Nie masz permisji! &3(xmonvanish.vanish)"));
            return false;
        }
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatUtil.fixColor("&4Blad: &7Musisz być graczem!"));
            return false;
        }
        Player p = (Player)sender;
        if(VanishManager.isOnVanish(p)){
            VanishManager.removePlayer(p);
            for(Player all : Bukkit.getOnlinePlayers()){
                all.showPlayer(p);
            }
            p.sendMessage(ChatUtil.fixColor("&7>> &cVanish &7został &4wyłączony!"));
        }else {
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (all.hasPermission("xmonvanish.showonvanish")) {
                    all.showPlayer(p);
                } else {
                    all.hidePlayer(p);
                }
            }
            VanishManager.addPlayer(p);
            p.sendMessage(ChatUtil.fixColor("&7>> &cVanish &7został &ewłączony!"));
        }
        return false;
    }
}
