package me.d1ksu.onehard.megadrop.event;

import me.d1ksu.onehard.megadrop.guild.Guild;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildMemberJoinEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }


    private final Guild guild;
    private final Player player;

    public GuildMemberJoinEvent(Guild guild, Player player){
        this.guild = guild;
        this.player = player;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public Guild getGuild() {
        return guild;
    }

    public Player getPlayer() {
        return player;
    }
}
