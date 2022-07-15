package me.d1ksu.onehard.megadrop.guild;

import java.util.*;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class Guild {

    private String leader;
    private final String tag;
    private String fullName;
    private Set<String> members;
    private Map<String, Long> invites;
    private Set<String> allies;
    private Set<String> alliesInvites;
    private String serializedDepositInventory;
    private boolean pvp;
    private final long createdAt;
    private long expireTime;
    private long protectionTime;

    public Guild(String leader, String tag, String fullName){
        this.leader = leader;
        this.tag = tag;
        this.fullName = fullName;
        this.members = new HashSet<>();
        this.invites = new HashMap<>();
        this.allies = new HashSet<>();
        this.alliesInvites = new HashSet<>();
        this.pvp = true;
        this.serializedDepositInventory = null;
        this.createdAt = System.currentTimeMillis();
        this.protectionTime = 0L;
        this.expireTime = 0L;
        this.members.add(leader);
    }

    public String getLeader() {
        return leader;
    }

    public String getTag() {
        return tag;
    }

    public String getFullName() {
        return fullName;
    }

    public Set<String> getMembers() {
        return members;
    }

    public Map<String, Long> getInvites() {
        return invites;
    }

    public Set<String> getAllies() {
        return allies;
    }

    public Set<String> getAlliesInvites() {
        return alliesInvites;
    }

    public String getSerializedDepositInventory() {
        return serializedDepositInventory;
    }

    public boolean isPvp() {
        return pvp;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public long getProtectionTime() {
        return protectionTime;
    }
}
