package me.d1ksu.onehard.megadrop.listener.guild;

import me.d1ksu.onehard.megadrop.event.GuildCreateEvent;
import me.d1ksu.onehard.megadrop.guild.Guild;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildCreateListener implements Listener {

    @EventHandler
    public void onGuildCreate(GuildCreateEvent event){
        Player player = event.getPlayer();
        Guild guild = event.getGuild();

    }
}
