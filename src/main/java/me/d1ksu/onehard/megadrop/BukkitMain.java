package me.d1ksu.onehard.megadrop;


import me.d1ksu.onehard.megadrop.listener.player.AsyncPlayerPreLoginListener;
import me.d1ksu.onehard.megadrop.listener.player.PlayerQuitListener;
import me.d1ksu.onehard.megadrop.profile.ProfileService;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class BukkitMain extends JavaPlugin {

    private static BukkitMain bukkitMain;
    private ProfileService profileService;

    @Override
    public void onEnable() {

        this.profileService = new ProfileService();

        Listener[] listeners = new Listener[]{
                new AsyncPlayerPreLoginListener(profileService),
                new PlayerQuitListener(profileService)
        };
        Arrays.stream(listeners).forEach(listener -> Bukkit.getPluginManager().registerEvents(listener, this));
    }

    @Override
    public void onDisable() {

    }

    public static BukkitMain getBukkitMain() {
        return bukkitMain;
    }

    public ProfileService getProfileService() {
        return profileService;
    }


}
