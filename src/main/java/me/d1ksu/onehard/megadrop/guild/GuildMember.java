package me.d1ksu.onehard.megadrop.guild;

import java.util.Set;
import java.util.UUID;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildMember {

    private final String name;
    private final Set<GuildPermissionType> permissions;

    public GuildMember(final String name, final Set<GuildPermissionType> permissions){
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public Set<GuildPermissionType> getPermissions() {
        return permissions;
    }

    public boolean hasPermission(GuildPermissionType guildPermissionType){
        // TODO if is leader return true
        return this.permissions.contains(guildPermissionType);
    }

}
