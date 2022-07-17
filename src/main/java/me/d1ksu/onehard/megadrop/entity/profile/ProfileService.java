package me.d1ksu.onehard.megadrop.entity.profile;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class ProfileService {

    private final Map<UUID, Profile> profileMap = new ConcurrentHashMap<>();

    public Profile create(String name, UUID uuid) {
        Profile profile = new Profile(name, uuid);
        this.profileMap.put(uuid, profile);
        return profile;
    }

    public Optional<Profile> findProfile(UUID uuid) {
        return Optional.ofNullable(this.profileMap.get(uuid));
    }

    public Optional<Profile> findProfile(String name) {
        return this.profileMap
                .values()
                .stream()
                .filter(profile -> profile.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public Map<UUID, Profile> getProfileMap() {
        return profileMap;
    }
}
