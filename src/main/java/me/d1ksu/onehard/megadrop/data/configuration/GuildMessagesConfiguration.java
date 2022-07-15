package me.d1ksu.onehard.megadrop.data.configuration;

import eu.okaeri.configs.OkaeriConfig;

import java.util.Arrays;
import java.util.List;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildMessagesConfiguration extends OkaeriConfig {


    private List<String> guildCommads = Arrays.asList(
            "/zaloz",
            "/zapros",
            "/panel"
    );


    public List<String> getGuildCommads() {
        return guildCommads;
    }
}
