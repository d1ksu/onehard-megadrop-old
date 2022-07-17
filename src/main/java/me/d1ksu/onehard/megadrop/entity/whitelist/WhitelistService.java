package me.d1ksu.onehard.megadrop.entity.whitelist;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author d1ksu
 * @Date 17.07.2022
 */
public class WhitelistService {

    private final Set<Whitelist> whitelists = new HashSet<>();

    public Whitelist createWithReason(boolean status, String reason){
        Whitelist whitelist = new Whitelist(status, reason);
        this.whitelists.add(whitelist);
        return whitelist;
    };

    public Whitelist getWhitelist(){
        if(whitelists.size() == 1){
            for(Whitelist whitelist : whitelists){
                return whitelist;
            }

        }
        return null;
    };

    public Set<Whitelist> getWhitelists() {
        return whitelists;
    }
}
