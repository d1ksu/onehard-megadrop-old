package me.d1ksu.onehard.megadrop.listener.guild;

import me.d1ksu.onehard.megadrop.event.GuildExpireEvent;
import me.d1ksu.onehard.megadrop.entity.guild.Guild;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildExpireListener implements Listener {




    @EventHandler
    public void onGuildExpire(GuildExpireEvent event) {
        Guild guild = event.getGuild();
        // TODO BROADCAST MESSAGEs FROM CONFIG ABOUT CORDINATES ETC
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage("gildia " + guild.getTag() + " wygasla");
        });
    }

}
