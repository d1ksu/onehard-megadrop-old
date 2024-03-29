package me.d1ksu.onehard.megadrop.event;

import me.d1ksu.onehard.megadrop.entity.guild.Guild;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildExpireEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }


    private final Guild guild;

    public GuildExpireEvent(Guild guild){
        this.guild = guild;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public Guild getGuild() {
        return guild;
    }
}
