package me.d1ksu.onehard.megadrop.profile;

import java.util.UUID;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class Profile {

    private final String name;
    private final UUID uuid;
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
}
