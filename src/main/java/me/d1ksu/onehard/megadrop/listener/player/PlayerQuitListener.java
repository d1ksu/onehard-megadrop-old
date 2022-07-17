package me.d1ksu.onehard.megadrop.listener.player;

import me.d1ksu.onehard.megadrop.entity.profile.ProfileService;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class PlayerQuitListener implements Listener {

    private final ProfileService profileService;

    public PlayerQuitListener(ProfileService profileService){
        this.profileService = profileService;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        profileService.findProfile(player.getUniqueId()).ifPresent(profile -> {
            profile.setLeftAt(System.currentTimeMillis());
        });
    }
}
