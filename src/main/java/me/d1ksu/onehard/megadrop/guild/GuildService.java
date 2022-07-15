package me.d1ksu.onehard.megadrop.guild;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildService {

    private final Map<String, Guild> guildMap = new ConcurrentHashMap<>();

    public Optional<Guild> findGuildByTag(String tag){
        return Optional.ofNullable(this.guildMap.get(tag));
    }

    public void register(Guild guild){
        this.guildMap.put(guild.getTag(), guild);
    }

    public void unregister(Guild guild){
        this.guildMap.remove(guild);
    }

    public Optional<Guild> findGuildByGuildMember(GuildMember guildMember){
        return this.guildMap
                .values()
                .stream()
                .filter(guild -> guild.isGuildMember(guildMember))
                .findFirst();
    }

    public Optional<Guild> findGuildByName(String name){
        return this.guildMap
                .values()
                .stream()
                .filter(guild -> guild.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public Map<String, Guild> getGuildMap() {
        return guildMap;
    }
}
