package me.d1ksu.onehard.megadrop.commands.guild;

import me.d1ksu.onehard.megadrop.commands.api.Command;
import me.d1ksu.onehard.megadrop.commands.api.CommandArgs;
import me.d1ksu.onehard.megadrop.data.configuration.GuildMessagesConfiguration;
import me.d1ksu.onehard.megadrop.helper.ChatHelper;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildCommand {


    private GuildMessagesConfiguration guildMessagesConfiguration;

    public GuildCommand(GuildMessagesConfiguration guildMessagesConfiguration){
        this.guildMessagesConfiguration = guildMessagesConfiguration;
    }



    @Command(name= "g", aliases = {""})
    public void execute(CommandArgs commandArgs){
        Player player = commandArgs.getPlayer();
        for(Component component : guildMessagesConfiguration.getGuildCommands()){
            player.sendMessage(component);
        }
    }
}
