package missingdrift;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class joinmessage extends JavaPlugin implements Listener {
    private FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        getServer().getPluginManager().registerEvents(this, this);

        System.out.println("\n" +
                "     _  ___ ___ _  _ __  __ ___ ___ ___   _   ___ ___ \n" +
                "  _ | |/ _ \\_ _| \\| |  \\/  | __/ __/ __| /_\\ / __| __|\n" +
                " | || | (_) | || .` | |\\/| | _|\\__ \\__ \\/ _ \\ (_ | _| \n" +
                "  \\__/ \\___/___|_|\\_|_|  |_|___|___/___/_/ \\_\\___|___|\n" +
                "                                                      \n" +
                "\n" +
                "Version: 1.0.0\n" +
                "Author: MissingDrift");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        Player player = event.getPlayer();
        List<String> welcomeMessage = config.getStringList("welcome-message");
        for (String message : welcomeMessage) {
            message = message.replace("{player}", player.getName());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }
}