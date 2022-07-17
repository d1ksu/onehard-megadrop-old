package me.d1ksu.onehard.megadrop.runnable.guild;

import me.d1ksu.onehard.megadrop.entity.guild.Guild;
import me.d1ksu.onehard.megadrop.entity.guild.GuildService;
import me.d1ksu.onehard.megadrop.entity.profile.ProfileService;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildBossBarRunnable implements Runnable {

    private final GuildService guildService;
    private final ProfileService profileService;


    public GuildBossBarRunnable(GuildService guildService, ProfileService profileService) {
        this.guildService = guildService;
        this.profileService = profileService;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            Guild guild = guildService.findGuildInside(player.getLocation()).orElse(null);
            profileService.findProfile(player.getUniqueId()).ifPresent(profile -> {
               BossBar bossBar = profile.getBossBarList().get(0);
                if (guild != null) {
                    final Location location = player.getLocation();
                    location.setY(guild.getGuildArea().getCenterLocation().getY());
                    if(guild.getTag().equalsIgnoreCase(profile.getGuild())){
                        bossBar.setColor(BarColor.GREEN);
                        bossBar.setTitle("Teren twojej gildii: " + guild.getTag());
                    } else if(guild.isAlly(profile.getGuild())){
                        bossBar.setColor(BarColor.YELLOW);
                        bossBar.setTitle("Teren sojuszniczej gildii: " + guild.getTag());
                    } else {
                        bossBar.setColor(BarColor.RED);
                        bossBar.setTitle("Teren wrogiej gildii: " + guild.getTag());
                    }
                    float progress = (float) (location.distance(guild.getGuildArea().getCenterLocation()) / (
                            guild.getGuildArea().getSize() / 2));
                    if(progress >= 1){
                        progress = 1;
                    }
                    bossBar.setProgress(progress);
                    bossBar.addPlayer(player);
                } else {
                    bossBar.removePlayer(player);
                }
            });


        }
    }
}
