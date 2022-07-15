package me.d1ksu.onehard.megadrop.commands.guild;

import me.d1ksu.onehard.megadrop.commands.api.Command;
import me.d1ksu.onehard.megadrop.commands.api.CommandArgs;
import me.d1ksu.onehard.megadrop.event.GuildCreateEvent;
import me.d1ksu.onehard.megadrop.guild.Guild;
import me.d1ksu.onehard.megadrop.guild.GuildArea;
import me.d1ksu.onehard.megadrop.guild.GuildService;
import me.d1ksu.onehard.megadrop.helper.ChatHelper;
import me.d1ksu.onehard.megadrop.profile.ProfileService;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildCreateCommand {

    private final GuildService guildService;
    private final ProfileService profileService;


    public GuildCreateCommand(GuildService guildService, ProfileService profileService) {
        this.guildService = guildService;
        this.profileService = profileService;
    }

    @Command(name = "create", aliases = "zaloz", inGameOnly = true)
    public void execute(CommandArgs commandArgs) {
        Player player = commandArgs.getPlayer();
        if (commandArgs.length() != 2) {
            player.sendMessage(ChatHelper.fixColor("&cPoprawne uzycie: /zaloz <tag> <nazwa>")); // TODO config messages
            return;
        }
        // TODO checks if player can create guild properly


        profileService.findProfile(player.getUniqueId()).ifPresent(profile -> {
            final Location centerLocation = player.getLocation().clone();
            centerLocation.setY(40); // TODO CONFIG

            Guild guild = new Guild(
                    commandArgs.getArgs(0)
                    , commandArgs.getArgs(1)
                    , player.getName(),
                    new GuildArea(centerLocation, 50)); // TODO SIZE TO CONFIG

            profile.setGuild(guild.getTag());

            guildService.register(guild);
            Bukkit.getPluginManager().callEvent(new GuildCreateEvent(player, guild));
        });



}
}
