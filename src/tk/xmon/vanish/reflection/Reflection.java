package tk.xmon.vanish.reflection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class Reflection
{
    public static String getVersion() {
        return String.valueOf(Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3]) + ".";
    }

    public static Class<?> getClass(final String version, final String prefix, final String nmsClassString) {
        final String name = String.valueOf(prefix) + "." + version + nmsClassString;
        Class<?> nmsClass;
        try {
            nmsClass = Class.forName(name);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return nmsClass;
    }

    public static void sendPacket(final String version, final Player p, final Object packet, final String prefix) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException {
        final Object nmsPlayer = p.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(p, new Object[0]);
        final Object plrConnection = nmsPlayer.getClass().getField("playerConnection").get(nmsPlayer);
        plrConnection.getClass().getMethod("sendPacket", getClass(version, prefix, "Packet")).invoke(plrConnection, packet);
    }
}
