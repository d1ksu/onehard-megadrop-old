package me.d1ksu.onehard.megadrop.data.configuration;

import eu.okaeri.configs.OkaeriConfig;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class MainConfiguration extends OkaeriConfig {

    private String serversPrefix = "Serwerowy prefix";

    public String getServersPrefix() {
        return serversPrefix;
    }

}
