package tk.xmon.vanish.reflection.packet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import tk.xmon.vanish.Vanish;
import tk.xmon.vanish.reflection.Reflection;

import java.lang.reflect.Constructor;

public class ActionBar {
    private Object packet;
    private String version;
    public ActionBar(String message){
        this.version = Vanish.getInstance().getVersion();
        try {
            if(message == null){
                message = "";
            }
            message = message.replace("&", "§");
            if (this.version.equalsIgnoreCase("v1_8_R1")) {
                final Object chat = Reflection.getClass(this.version, "net.minecraft.server", "ChatSerializer").getMethod("a", String.class).invoke(null, "{text:\"" + message + "\"}");
                this.packet = Reflection.getClass(this.version, "net.minecraft.server", "PacketPlayOutChat").getConstructor(Reflection.getClass(this.version, "net.minecraft.server", "IChatBaseComponent"), Byte.TYPE).newInstance(chat, (byte)2);
            }else if (this.version.startsWith("v1_12_") || this.version.startsWith("v1_13_")) {
                final Object chat = Reflection.getClass(this.version, "net.minecraft.server", "ChatComponentText").getConstructor(String.class).newInstance(message);
                final Class<?> chatMessageTypeClass = Reflection.getClass(this.version, "net.minecraft.server", "ChatMessageType");
                final Object[] chatMessageTypes = (Object[])chatMessageTypeClass.getEnumConstants();
                Object chatMessageType = null;
                Object[] array;
                for (int length = (array = chatMessageTypes).length, i = 0; i < length; ++i) {
                    final Object obj = array[i];
                    if (obj.toString().equals("GAME_INFO")) {
                        chatMessageType = obj;
                    }
                }
                this.packet = Reflection.getClass(this.version, "net.minecraft.server", "PacketPlayOutChat").getConstructor(Reflection.getClass(this.version, "net.minecraft.server", "IChatBaseComponent"), chatMessageTypeClass).newInstance(chat, chatMessageType);
            }else{
                final Object chat = Reflection.getClass(this.version, "net.minecraft.server", "ChatComponentText").getConstructor(String.class).newInstance(message);
                this.packet = Reflection.getClass(this.version, "net.minecraft.server", "PacketPlayOutChat").getConstructor(Reflection.getClass(this.version, "net.minecraft.server", "IChatBaseComponent"), Byte.TYPE).newInstance(chat, (byte)2);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void send(final Player player) {
        if (!player.isOnline() || player == null) {
            return;
        }
        try {
            Reflection.sendPacket(this.version, player, this.packet, "net.minecraft.server");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendToAll() {
        for (final Player p : Bukkit.getOnlinePlayers()) {
            this.send(p);
        }
    }
}
