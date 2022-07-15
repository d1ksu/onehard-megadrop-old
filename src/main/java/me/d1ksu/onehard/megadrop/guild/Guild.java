package me.d1ksu.onehard.megadrop.guild;

import org.bukkit.Location;

import java.util.HashSet;
import java.util.Set;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class Guild {

    private final String tag;
    private String name;

    private String
            founder,
            leader;

    private String
            serializedBaseLocation,
            serializedDeposit;

    private long
            createdAt,
            validityTime,
            protectionTime,
            tntExplosionTime;

    private boolean pvpGuild, pvpAlly;

    private int lives, health, maxSlots;

    private Set<GuildMember> guildMembers;
    private Set<String> guildAllies;
    private GuildArea guildArea;


    public Guild(final String tag, String name, String founder, GuildArea guildArea){
        this.tag = tag;
        this.name = name;
        this.founder = founder;
        this.leader = founder;

        this.serializedBaseLocation = null;

        this.guildAllies = new HashSet<>();
        this.guildMembers = new HashSet<>();
        GuildMember founderGuildMember = new GuildMember(name, new HashSet<>());
        guildMembers.add(founderGuildMember);


        this.createdAt = System.currentTimeMillis();
        this.guildArea = guildArea;
    }

    public String getTag() {
        return tag;
    }

    public String getName() {
        return name;
    }

    public String getFounder() {
        return founder;
    }

    public String getLeader() {
        return leader;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getValidityTime() {
        return validityTime;
    }

    public long getProtectionTime() {
        return protectionTime;
    }

    public long getTntExplosionTime() {
        return tntExplosionTime;
    }

    public boolean isPvpGuild() {
        return pvpGuild;
    }

    public boolean isPvpAlly() {
        return pvpAlly;
    }

    public int getLives() {
        return lives;
    }

    public int getHealth() {
        return health;
    }

    public GuildArea getGuildArea() {
        return guildArea;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public Set<GuildMember> getGuildMembers() {
        return guildMembers;
    }

    public boolean isGuildMember(GuildMember guildMember){
        return this.guildMembers.contains(guildMember);
    }

    public void setValidityTime(long validityTime) {
        this.validityTime = validityTime;
    }

    public boolean isAlly(String tag){
        return this.guildAllies.contains(tag);
    }
}
