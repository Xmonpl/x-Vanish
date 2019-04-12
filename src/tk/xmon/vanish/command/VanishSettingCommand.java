package tk.xmon.vanish.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import tk.xmon.vanish.Listeners.VanishSettinglistener;
import tk.xmon.vanish.utils.ChatUtil;
import tk.xmon.vanish.utils.ItemBuilder;

public class VanishSettingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!sender.hasPermission("xmonvanish.settings")){
            sender.sendMessage(ChatUtil.fixColor("&4Blad: &7Nie masz permisji! &3(xmonvanish.settings)"));
            return false;
        }
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatUtil.fixColor("&4Blad: &7Musisz być graczem!"));
            return false;
        }
        Player p = (Player)sender;
        Inventory inv = Bukkit.createInventory(p, 9, ChatUtil.fixColor("&7{O} &3Vanish &7{O}"));
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

        ItemBuilder glass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1 , (short) 15).setTitle("§7( )");
        inv.setItem(0, glass.build());
        if(VanishSettinglistener.podnoszenie.contains(p)){
            inv.setItem(1, podnoszenieyes.build());
        }else {
            inv.setItem(1, podnoszenieno.build());
        }
        if(VanishSettinglistener.niszczenie.contains(p)){
            inv.setItem(2, niszczenieyes.build());
        }else {
            inv.setItem(2, niszczenieno.build());
        }
        if(VanishSettinglistener.budowanie.contains(p)){
            inv.setItem(3, budowanieyes.build());
        }else {
            inv.setItem(3, budowanieno.build());
        }
        inv.setItem(4, glass.build());
        if(VanishSettinglistener.wyrzucanie.contains(p)){
            inv.setItem(5, wyrzucanieyes.build());
        }else {
            inv.setItem(5, wyrzucanieno.build());
        }
        if(VanishSettinglistener.bicie.contains(p)){
            inv.setItem(6, bicieyes.build());
        }else {
            inv.setItem(6, bicieno.build());
        }
        if(VanishSettinglistener.god.contains(p)){
            inv.setItem(7, godyes.build());
        }else {
            inv.setItem(7, godno.build());
        }
        inv.setItem(8, glass.build());
        p.openInventory(inv);
        return false;
    }
}
