package me.d1ksu.onehard.megadrop;


import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import me.d1ksu.onehard.megadrop.data.configuration.MainConfiguration;
import me.d1ksu.onehard.megadrop.listener.player.AsyncPlayerPreLoginListener;
import me.d1ksu.onehard.megadrop.listener.player.PlayerQuitListener;
import me.d1ksu.onehard.megadrop.profile.ProfileService;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Arrays;
import java.util.logging.Level;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class BukkitMain extends JavaPlugin {

    private static BukkitMain bukkitMain;
    private ProfileService profileService;
    private MainConfiguration mainConfiguration;

    @Override
    public void onEnable() {
        bukkitMain = this;
        try {
            mainConfiguration = ConfigManager.create(MainConfiguration.class, (it) -> {
                it.withConfigurer(new YamlBukkitConfigurer(), new SerdesBukkit());
                it.withBindFile(new File(this.getDataFolder(), "config.yml"));
                it.saveDefaults();
                it.load(true);

            });
        } catch (Exception exception) {
            this.getLogger().log(Level.SEVERE, "Error loading configs", exception);
            this.getPluginLoader().disablePlugin(this);
            return;
        }

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

    public MainConfiguration getMainConfiguration() {
        return mainConfiguration;
    }
}
