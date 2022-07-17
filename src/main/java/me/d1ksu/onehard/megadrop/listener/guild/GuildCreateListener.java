package me.d1ksu.onehard.megadrop.listener.guild;

import me.d1ksu.onehard.megadrop.data.configuration.GuildMessagesConfiguration;
import me.d1ksu.onehard.megadrop.event.GuildCreateEvent;
import me.d1ksu.onehard.megadrop.entity.guild.Guild;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildCreateListener implements Listener {

    private final GuildMessagesConfiguration guildMessagesConfiguration;

    public GuildCreateListener(GuildMessagesConfiguration guildMessagesConfiguration) {
        this.guildMessagesConfiguration = guildMessagesConfiguration;
    }

    @EventHandler
    public void onGuildCreate(GuildCreateEvent event){
        Player player = event.getPlayer();
        Guild guild = event.getGuild();
        // TODO MESSAGES ETC AFTER CREATE
        Bukkit.getOnlinePlayers().forEach(player1 -> player1.sendMessage("nowa gildia" + guild.getName()));

    }
}
