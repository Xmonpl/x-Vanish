package tk.xmon.vanish.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import tk.xmon.vanish.command.VanishSettingCommand;
import tk.xmon.vanish.utils.ChatUtil;
import tk.xmon.vanish.utils.ItemBuilder;

import java.util.ArrayList;
import java.util.UUID;

public class VanishSettinglistener implements Listener {
    public static ArrayList<Player> podnoszenie = new ArrayList<Player>();
    public static ArrayList<Player> niszczenie = new ArrayList<Player>();
    public static ArrayList<Player> budowanie = new ArrayList<Player>();
    public static ArrayList<Player> wyrzucanie = new ArrayList<Player>();
    public static ArrayList<Player> bicie = new ArrayList<Player>();
    public static ArrayList<Player> god = new ArrayList<Player>();
    ItemBuilder podnoszenieno = new ItemBuilder(Material.WOOL, (short) 14).setTitle(ChatUtil.fixColor("&7{O} &3Podnoszenie &7{O}")).addLore(ChatUtil.fixColor("&7Aktywny: &cNie"));
    ItemBuilder podnoszenieyes = new ItemBuilder(Material.WOOL, (short) 5).setTitle(ChatUtil.fixColor("&7{O} &3Podnoszenie &7{O}")).addLore(ChatUtil.fixColor("&7Aktywny: &eTak"));
    ItemBuilder niszczenieno = new ItemBuilder(Material.WOOL, (short) 14).setTitle(ChatUtil.fixColor("&7{O} &3Niszczenie &7{O}")).addLore(ChatUtil.fixColor("&7Aktywny: &cNie"));
    ItemBuilder niszczenieyes = new ItemBuilder(Material.WOOL, (short) 5).setTitle(ChatUtil.fixColor("&7{O} &3Niszczenie &7{O}")).addLore(ChatUtil.fixColor("&7Aktywny: &eTak"));
    ItemBuilder budowanieno = new ItemBuilder(Material.WOOL, (short) 14).setTitle(ChatUtil.fixColor("&7{O} &3Budowanie &7{O}")).addLore(ChatUtil.fixColor("&7Aktywny: &cNie"));
    ItemBuilder budowanieyes = new ItemBuilder(Material.WOOL, (short) 5).setTitle(ChatUtil.fixColor("&7{O} &3Budowanie &7{O}")).addLore(ChatUtil.fixColor("&7Aktywny: &eTak"));
    ItemBuilder wyrzucanieno = new ItemBuilder(Material.WOOL, (short) 14).setTitle(ChatUtil.fixColor("&7{O} &3Wyrzucanie &7{O}")).addLore(ChatUtil.fixColor("&7Aktywny: &cNie"));
    ItemBuilder wyrzucanieyes = new ItemBuilder(Material.WOOL, (short) 5).setTitle(ChatUtil.fixColor("&7{O} &3Wyrzucanie &7{O}")).addLore(ChatUtil.fixColor("&7Aktywny: &eTak"));
    ItemBuilder bicieno = new ItemBuilder(Material.WOOL, (short) 14).setTitle(ChatUtil.fixColor("&7{O} &3Bicie &7{O}")).addLore(ChatUtil.fixColor("&7Aktywny: &cNie"));
    ItemBuilder bicieyes = new ItemBuilder(Material.WOOL, (short) 5).setTitle(ChatUtil.fixColor("&7{O} &3Bicie &7{O}")).addLore(ChatUtil.fixColor("&7Aktywny: &eTak"));
    ItemBuilder godno = new ItemBuilder(Material.WOOL, (short) 14).setTitle(ChatUtil.fixColor("&7{O} &3Nieśmiertelność &7{O}")).addLore(ChatUtil.fixColor("&7Aktywny: &cNie"));
    ItemBuilder godyes = new ItemBuilder(Material.WOOL, (short) 5).setTitle(ChatUtil.fixColor("&7{O} &3Nieśmiertelność &7{O}")).addLore(ChatUtil.fixColor("&7Aktywny: &eTak"));


    @EventHandler
    public void onclick(InventoryClickEvent event){
        Player p = (Player)event.getWhoClicked();
        Inventory inv = p.getInventory();
        if (ChatUtil.fixColor("&7{O} &3Vanish &7{O}").equalsIgnoreCase(event.getInventory().getName())){
            event.setCancelled(true);
            if (event.getSlot() == 1) {
                if(p.hasPermission("xmonvanish.settings.podnoszenie")){
                    if(podnoszenie.contains(p)){
                        podnoszenie.remove(p);
                        event.setCurrentItem(podnoszenieno.build());
                        p.sendMessage(ChatUtil.fixColor("&7>> &3Vanish&8: Podnoszenie zostało &cwylaczone!"));
                    }else {
                        podnoszenie.add(p);
                        event.setCurrentItem(podnoszenieyes.build());
                        p.sendMessage(ChatUtil.fixColor("&7>> &3Vanish&8: Podnoszenie zostało &ewlaczone!"));
                    }
                }else {
                    p.sendMessage(ChatUtil.fixColor("&4Blad: &7Nie masz permisji! &3(xmonvanish.settings.podnoszenie)"));
                }
            }
            if(event.getSlot() == 2){
                if(p.hasPermission("xmonvanish.settings.niszczenie")){
                    if(niszczenie.contains(p)){
                        niszczenie.remove(p);
                        event.setCurrentItem(niszczenieno.build());
                        p.sendMessage(ChatUtil.fixColor("&7>> &3Vanish&8: Niszczenie zostało &cwylaczone!"));
                    }else {
                        event.setCurrentItem(niszczenieyes.build());
                        niszczenie.add(p);
                        p.sendMessage(ChatUtil.fixColor("&7>> &3Vanish&8: Niszczenie zostało &ewlaczone!"));
                    }
                }else {
                    p.sendMessage(ChatUtil.fixColor("&4Blad: &7Nie masz permisji! &3(xmonvanish.settings.niszczenie"));
                }
            }
            if(event.getSlot() == 3){
                if(p.hasPermission("xmonvanish.settings.budowanie")){
                    if(budowanie.contains(p)){
                        event.setCurrentItem(budowanieno.build());
                        budowanie.remove(p);
                        p.sendMessage(ChatUtil.fixColor("&7>> &3Vanish&8: Budowanie zostało &cwylaczone!"));
                    }else {
                        event.setCurrentItem(budowanieyes.build());
                        budowanie.add(p);
                        p.sendMessage(ChatUtil.fixColor("&7>> &3Vanish&8: Budowanie zostało &ewlaczone!"));
                    }
                }else {
                    p.sendMessage(ChatUtil.fixColor("&4Blad: &7Nie masz permisji! &3(xmonvanish.settings.budowanie"));
                }
            }
            if(event.getSlot() == 5){
                if(p.hasPermission("xmonvanish.settings.wyrzucanie")){
                    if(wyrzucanie.contains(p)){
                        event.setCurrentItem(wyrzucanieno.build());
                        wyrzucanie.remove(p);
                        p.sendMessage(ChatUtil.fixColor("&7>> &3Vanish&8: Wyrzucanie zostało &cwylaczone!"));
                    }else {
                        event.setCurrentItem(wyrzucanieyes.build());
                        wyrzucanie.add(p);
                        p.sendMessage(ChatUtil.fixColor("&7>> &3Vanish&8: Wyrzucanie zostało &ewlaczone!"));
                    }
                }else {
                    p.sendMessage(ChatUtil.fixColor("&4Blad: &7Nie masz permisji! &3(xmonvanish.settings.wyrzucanie"));
                }
            }
            if(event.getSlot() == 6){
                if(p.hasPermission("xmonvanish.settings.bicie")){
                    if(bicie.contains(p)){
                        event.setCurrentItem(bicieno.build());
                        bicie.remove(p);
                        p.sendMessage(ChatUtil.fixColor("&7>> &3Vanish&8: Bicie zostało &cwylaczone!"));
                    }else {
                        event.setCurrentItem(bicieyes.build());
                        bicie.add(p);
                        p.sendMessage(ChatUtil.fixColor("&7>> &3Vanish&8: Bicie zostało &ewlaczone!"));
                    }
                }else {
                    p.sendMessage(ChatUtil.fixColor("&4Blad: &7Nie masz permisji! &3(xmonvanish.settings.bicie"));
                }
            }
            if(event.getSlot() == 7){
                if(p.hasPermission("xmonvanish.settings.god")){
                    if(god.contains(p)){
                        event.setCurrentItem(godno.build());
                        god.remove(p);
                        p.sendMessage(ChatUtil.fixColor("&7>> &3Vanish&8: God zostało &cwylaczone!"));
                    }else {
                        event.setCurrentItem(godyes.build());
                        god.add(p);
                        p.sendMessage(ChatUtil.fixColor("&7>> &3Vanish&8: God zostało &ewlaczone!"));
                    }
                }else {
                    p.sendMessage(ChatUtil.fixColor("&4Blad: &7Nie masz permisji! &3(xmonvanish.settings.god"));
                }
            }
        }
    }
}
