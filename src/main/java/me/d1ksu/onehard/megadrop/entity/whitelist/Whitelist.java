package me.d1ksu.onehard.megadrop.entity.whitelist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author d1ksu
 * @Date 17.07.2022
 */
public class Whitelist {

    private boolean status;
    private String reason;
    private final Set<String> addedPlayers;

    public Whitelist(boolean status){
        this.status = status;
        this.reason = null;
        this.addedPlayers = new HashSet<>();
    }
    public Whitelist(boolean status, String reason){
        this.status = status;
        this.reason = reason;
        this.addedPlayers = new HashSet<>();
    }

    public boolean isStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    public Set<String> getAddedPlayers() {
        return addedPlayers;
    }

    public void addPlayer(String player){
        this.addedPlayers.add(player);
    }

    public void removePlayer(String player){
        this.addedPlayers.remove(player);
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
