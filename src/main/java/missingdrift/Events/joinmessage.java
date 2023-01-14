package missingdrift.Events;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class joinmessage implements Listener {
    private FileConfiguration config;

    public void OnJoinMessage(FileConfiguration config) {
        this.config = config;
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
