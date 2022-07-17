package me.d1ksu.onehard.megadrop.data.configuration;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Exclude;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildMessagesConfiguration extends OkaeriConfig {

    @Exclude
    private final MiniMessage miniMessage = MiniMessage.miniMessage();


    private final Component[] guildCommands = new Component[]{this.miniMessage.deserialize("g zaloz")};

    public Component[] getGuildCommands() {
        return guildCommands;
    }


}
