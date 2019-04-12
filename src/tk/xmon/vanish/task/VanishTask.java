package tk.xmon.vanish.task;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import tk.xmon.vanish.Vanish;
import tk.xmon.vanish.managers.VanishManager;
import tk.xmon.vanish.reflection.packet.ActionBar;
import tk.xmon.vanish.utils.ChatUtil;

public class VanishTask extends BukkitRunnable {
    public void run() {
        for(Player all : Bukkit.getOnlinePlayers()){
            if(VanishManager.isOnVanish(all)){
                new ActionBar(ChatUtil.fixColor("&7{O} &eAktualnie masz włączonego Vanisha! &7{O}")).send(all);
                //only 1.12-1.13
                //all.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatUtil.fixColor("&7{O} &eAktualnie masz włączonego Vanisha! &7{O}")));
            }
        }
    }
    @Deprecated
    public void start() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(Vanish.getInstance(), this, 40, 40);
    }
}
