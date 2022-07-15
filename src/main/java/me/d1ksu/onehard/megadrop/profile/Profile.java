package me.d1ksu.onehard.megadrop.profile;

import me.d1ksu.onehard.megadrop.commands.api.GroupType;

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


    public Profile(String name, UUID uuid){
        this.name = name;
        this.uuid = uuid;
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
}
