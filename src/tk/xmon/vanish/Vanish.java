package tk.xmon.vanish;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tk.xmon.vanish.Listeners.VanishListener;
import tk.xmon.vanish.Listeners.VanishSettinglistener;
import tk.xmon.vanish.command.VanishCommand;
import tk.xmon.vanish.command.VanishSettingCommand;
import tk.xmon.vanish.reflection.Reflection;
import tk.xmon.vanish.task.VanishTask;

public class Vanish extends JavaPlugin {
    private static Vanish instance;
    private String version;

    @Override
    public void onEnable() {
        this.getCommand("vanish").setExecutor(new VanishCommand());
        this.getCommand("vanishsettings").setExecutor(new VanishSettingCommand());
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new VanishSettinglistener(), this);
        pm.registerEvents(new VanishListener(), this);
        this.version = Reflection.getVersion();
        this.version();
        new VanishTask().start();
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static Vanish getInstance(){
        return instance;
    }

    private void version() {
        if (this.version.contains("1_8") || this.version.contains("1_9") || this.version.contains("1_10") || this.version.contains("1_11") || this.version.contains("1_12") || this.version.contains("1_13")) {
            System.out.println("Uzywasz wersji serwera: " + this.version.replace("_R1", "").replace("_R2", "").replace("_R3", "").replace("_R4", "").replace(".", "").replace("_", ".").replace("v", ""));
            return;
        }
        System.err.println("Uzywasz wersji serwera < 1.8, ktora nie wspolpracuje z tym pluginem.");
        Bukkit.getPluginManager().disablePlugin(this);
    }
    public String getVersion() {
        return this.version;
    }
}
