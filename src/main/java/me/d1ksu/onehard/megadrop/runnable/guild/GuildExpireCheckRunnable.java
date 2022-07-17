package me.d1ksu.onehard.megadrop.runnable.guild;

import me.d1ksu.onehard.megadrop.event.GuildExpireEvent;
import me.d1ksu.onehard.megadrop.entity.guild.Guild;
import me.d1ksu.onehard.megadrop.entity.guild.GuildService;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildExpireCheckRunnable implements Runnable {

    private final GuildService guildService;

    public GuildExpireCheckRunnable(GuildService guildService) {
        this.guildService = guildService;
    }

    @Override
    public void run() {
        final List<Guild> expiredGuilds = guildService.getGuildMap()
                .values()
                .stream()
                .filter(guild -> guild.getValidityTime() < System.currentTimeMillis())
                .collect(Collectors.toList());
        if (expiredGuilds.size() != 0) {
            for (Guild guild : expiredGuilds) {
                guildService.unregister(guild);
                Bukkit.getPluginManager().callEvent(new GuildExpireEvent(guild));
            }
        }
    }
}
