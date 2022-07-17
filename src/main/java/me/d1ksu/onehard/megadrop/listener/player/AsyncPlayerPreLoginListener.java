package me.d1ksu.onehard.megadrop.listener.player;

import me.d1ksu.onehard.megadrop.entity.profile.Profile;
import me.d1ksu.onehard.megadrop.entity.profile.ProfileService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class AsyncPlayerPreLoginListener implements Listener {

    private final ProfileService profileService;

    public AsyncPlayerPreLoginListener(ProfileService profileService){
        this.profileService = profileService;
    }

    @EventHandler
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event){
        Profile profile = profileService.findProfile(event.getUniqueId()).orElseGet(() ->
                profileService.create(event.getName(), event.getUniqueId()));
        profile.setJoinedAt(System.currentTimeMillis());


    }


}
