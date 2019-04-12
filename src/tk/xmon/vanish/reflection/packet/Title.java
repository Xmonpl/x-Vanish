package tk.xmon.vanish.reflection.packet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import tk.xmon.vanish.Vanish;
import tk.xmon.vanish.reflection.Reflection;

import java.lang.reflect.Constructor;

public class Title {
    private Object packet;
    private String version;
    public Title(Player player, String title, String subtitle) {
        this.version = Vanish.getInstance().getVersion();
        try {
            if (title == null) {
                title = "";
            }
            if (subtitle == null) {
                subtitle = "";
            }
            title = title.replace("&", "§");
            subtitle = subtitle.replace("&", "§");
            if (this.version.equalsIgnoreCase("v1_8_R1")) {
                Object enumTitle = Reflection.getClass(this.version,"net.minecraft.server", "PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
                Object titleChat = Reflection.getClass(this.version,"net.minecraft.server", "IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + title + "\"}");

                Object enumSubtitle = Reflection.getClass(this.version,"net.minecraft.server", "PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
                Object subtitleChat = Reflection.getClass(this.version,"net.minecraft.server", "IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + subtitle + "\"}");

                Constructor<?> titleConstructor = Reflection.getClass(this.version,"net.minecraft.server", "PacketPlayOutTitle").getConstructor(Reflection.getClass(this.version,"net.minecraft.server", "PacketPlayOutTitle").getDeclaredClasses()[0], Reflection.getClass(this.version,"net.minecraft.server", "IChatBaseComponent"), int.class, int.class, int.class);
                Object titlePacket = titleConstructor.newInstance(enumTitle, titleChat, 20 , 120 ,10);
                Object subtitlePacket = titleConstructor.newInstance(enumSubtitle, subtitleChat, 20 , 120 ,10);

                send(player, titlePacket);
                send(player, subtitlePacket);
            }
            else if (this.version.startsWith("v1_12_")) {
                Object enumTitle = Reflection.getClass(this.version,"net.minecraft.server", "PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
                Object titleChat = Reflection.getClass(this.version,"net.minecraft.server", "IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + title + "\"}");

                Object enumSubtitle = Reflection.getClass(this.version,"net.minecraft.server", "PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
                Object subtitleChat = Reflection.getClass(this.version,"net.minecraft.server", "IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + subtitle + "\"}");

                Constructor<?> titleConstructor = Reflection.getClass(this.version,"net.minecraft.server", "PacketPlayOutTitle").getConstructor(Reflection.getClass(this.version,"net.minecraft.server", "PacketPlayOutTitle").getDeclaredClasses()[0], Reflection.getClass(this.version,"net.minecraft.server", "IChatBaseComponent"), int.class, int.class, int.class);
                Object titlePacket = titleConstructor.newInstance(enumTitle, titleChat, 20 , 120 ,10);
                Object subtitlePacket = titleConstructor.newInstance(enumSubtitle, subtitleChat, 20 , 120 ,10);

                send(player, titlePacket);
                send(player, subtitlePacket);
            }
            else {
                Object enumTitle = Reflection.getClass(this.version,"net.minecraft.server", "PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
                Object titleChat = Reflection.getClass(this.version,"net.minecraft.server", "IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + title + "\"}");

                Object enumSubtitle = Reflection.getClass(this.version,"net.minecraft.server", "PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
                Object subtitleChat = Reflection.getClass(this.version,"net.minecraft.server", "IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + subtitle + "\"}");

                Constructor<?> titleConstructor = Reflection.getClass(this.version,"net.minecraft.server", "PacketPlayOutTitle").getConstructor(Reflection.getClass(this.version,"net.minecraft.server", "PacketPlayOutTitle").getDeclaredClasses()[0], Reflection.getClass(this.version,"net.minecraft.server", "IChatBaseComponent"), int.class, int.class, int.class);
                Object titlePacket = titleConstructor.newInstance(enumTitle, titleChat, 20 , 120 ,10);
                Object subtitlePacket = titleConstructor.newInstance(enumSubtitle, subtitleChat, 20 , 120 ,10);

                send(player, titlePacket);
                send(player, subtitlePacket);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void send(final Player player, Object packet) {
        if (!player.isOnline() || player == null) {
            return;
        }
        try {
            Reflection.sendPacket(this.version, player, packet, "net.minecraft.server");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendToAll() {
        for (final Player p : Bukkit.getOnlinePlayers()) {
            this.send(p, packet);
        }
    }

    public void sendTitle(Player p) {
        this.send(p, packet);
    }
}
