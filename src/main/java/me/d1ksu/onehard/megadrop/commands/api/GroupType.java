package me.d1ksu.onehard.megadrop.commands.api;

import java.util.Arrays;

public enum GroupType {

    GRACZ("&7", "&f", "&f", 0),
    VIP("&6VIP", "&6", "&f",1),
    SVIP("&6SVIP", "&6", "&7",2),
    SPONSOR("&9SPONSOR", "&9", "&7",3),
    ELITA("&5ELITA", "&5", "&7",4),
    BLAZE("&eBLAZE", "&e", "&7",5),
    HELPER("&3HELPER", "&3", "&7", 6),
    MODERATOR("&aMOD", "&a", "&7",7),
    ADMIN("&cADMIN", "&c", "&7",8),
    WLASCICIEL("&4Wlasciciel", "&4", "&7", 999),
    DEV("&cDEV", "&c", "&c", 999);

    private final String prefix;
    private final String suffix;
    private final String chatColor;
    private final int levelAccess;


    GroupType(String prefix, String suffix, String chatColor, int levelAccess) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.chatColor = chatColor;
        this.levelAccess = levelAccess;
    }


    public boolean cant(GroupType other) {
        return this.levelAccess < other.levelAccess;
    }

    public boolean equalsLevel(GroupType other) {
        return this.levelAccess == other.levelAccess;
    }

    public boolean can(GroupType other) {
        return this.levelAccess > other.levelAccess || this.levelAccess == other.levelAccess;
    }

    public static GroupType findByName(String name) {
        return Arrays.stream(values()).filter(groupType -> groupType.name().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getChatColor() {
        return chatColor;
    }

    public int getLevelAccess() {
        return levelAccess;
    }


}