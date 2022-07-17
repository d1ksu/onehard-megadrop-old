package me.d1ksu.onehard.megadrop.event;

import me.d1ksu.onehard.megadrop.entity.guild.Guild;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildCreateEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    private final Player player;
    private final Guild guild;

    public GuildCreateEvent(Player player, Guild guild){
        this.player = player;
        this.guild = guild;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public Player getPlayer() {
        return player;
    }

    public Guild getGuild() {
        return guild;
    }

}
