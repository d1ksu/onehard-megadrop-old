package me.d1ksu.onehard.megadrop.profile;

import me.d1ksu.onehard.megadrop.commands.api.GroupType;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class Profile {

    private final String name;
    private final UUID uuid;
    private GroupType groupType;
    private String guild;
    private long joinedAt;
    private long leftAt;
    private List<BossBar> bossBarList;

    private ProfileCooldown profileCooldown;


    public Profile(String name, UUID uuid){
        this.name = name;
        this.uuid = uuid;
        this.groupType = GroupType.GRACZ;


        this.bossBarList = Arrays.asList(
                Bukkit.createBossBar("GUILD", BarColor.GREEN, BarStyle.SOLID, BarFlag.PLAY_BOSS_MUSIC),
                Bukkit.createBossBar("MESSAGE", BarColor.BLUE, BarStyle.SOLID, BarFlag.PLAY_BOSS_MUSIC)
             );
        this.profileCooldown = new ProfileCooldown();
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getGuild() {
        return guild;
    }

    public void setGuild(String guild) {
        this.guild = guild;
    }

    public void removeGuild(){
        this.guild = null;
    }

    public long getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(long joinedAt) {
        this.joinedAt = joinedAt;
    }

    public void setLeftAt(long leftAt) {
        this.leftAt = leftAt;
    }

    public long getLeftAt() {
        return leftAt;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public ProfileCooldown getProfileCooldown() {
        return profileCooldown;
    }

    public List<BossBar> getBossBarList() {
        return bossBarList;
    }
}
