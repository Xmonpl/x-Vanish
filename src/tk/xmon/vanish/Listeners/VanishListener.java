package tk.xmon.vanish.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.*;
import tk.xmon.vanish.managers.VanishManager;

public class VanishListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        for(Player po : Bukkit.getOnlinePlayers()){
            if(VanishManager.isOnVanish(po)){
                if(!e.getPlayer().hasPermission("xmonvanish.showonvanish")){
                    e.getPlayer().hidePlayer(po);
                }
            }
        }
    }
    @EventHandler
    public void podnoszenie(PlayerPickupItemEvent e){
        if(VanishManager.isOnVanish(e.getPlayer())){
            if(!VanishSettinglistener.podnoszenie.contains(e.getPlayer())){
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void niszczenie(PlayerInteractEvent e){
        if(VanishManager.isOnVanish(e.getPlayer())){
            if(!VanishSettinglistener.niszczenie.contains(e.getPlayer())){
                if(e.getAction() == Action.LEFT_CLICK_BLOCK){
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void budowanie(PlayerInteractEvent e){
        if(VanishManager.isOnVanish(e.getPlayer())){
            if(!VanishSettinglistener.budowanie.contains(e.getPlayer())){
                if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void wyrzucanie(PlayerDropItemEvent e){
        if(VanishManager.isOnVanish(e.getPlayer())){
            if(!VanishSettinglistener.wyrzucanie.contains(e.getPlayer())){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void god(EntityDamageEvent e){
        if (e.getEntity() instanceof Player) {
            if (VanishManager.isOnVanish((Player) e.getEntity())) {
                if (!VanishSettinglistener.god.contains((Player) e.getEntity())) {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void bicie(EntityDamageByEntityEvent e){
        Entity damage = e.getDamager();
        if(damage instanceof Player) {
            if (VanishManager.isOnVanish((Player) damage)) {
                if(!VanishSettinglistener.bicie.contains((Player) damage)){
                    e.setCancelled(true);
                }
            }
        }
    }
}
