package me.d1ksu.onehard.megadrop.listener.guild.block;

import me.d1ksu.onehard.megadrop.guild.Guild;
import me.d1ksu.onehard.megadrop.guild.GuildService;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class BlockBreakListener implements Listener {

    private final GuildService guildService;

    public BlockBreakListener(GuildService guildService){
        this.guildService = guildService;
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Guild guild = guildService.findGuildInside(block.getLocation()).orElse(null);
        if(guild != null){
            event.setCancelled(true);
            player.sendMessage("gildia : " + guild.getTag());
        }
    }

}
