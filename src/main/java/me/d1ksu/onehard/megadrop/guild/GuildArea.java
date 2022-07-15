package me.d1ksu.onehard.megadrop.guild;


import org.bukkit.Location;
import org.bukkit.util.Vector;


/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class GuildArea {

    private final Location centerLocation;
    private volatile Vector minimumPoint, maximumPoint;
    private int size;

    public GuildArea(final Location centerLocation, final int size) {
        this.centerLocation = centerLocation;
        this.size = size;
        this.updatePoints();
    }


    public Location getCenterLocation() {
        return this.centerLocation;
    }

    public synchronized Vector getMinimumPoint() {
        return this.minimumPoint;
    }

    public synchronized Vector getMaximumPoint() {
        return this.maximumPoint;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(final int size) {
        this.size = size;
        this.updatePoints();
    }

    public boolean isInsideCenter(final Location location) {
        if (!this.centerLocation.getWorld().equals(location.getWorld())) {
            return false;
        }

        return location.getBlockX() >= (this.centerLocation.getBlockX() - 4)
                && location.getBlockX() <= (this.centerLocation.getBlockX() + 4)
                && location.getBlockY() >= (this.centerLocation.getBlockY() - 4)
                && location.getBlockY() <= (this.centerLocation.getBlockY() + 4)
                && location.getBlockZ() >= (this.centerLocation.getBlockZ() - 4)
                && location.getBlockZ() <= (this.centerLocation.getBlockZ() + 4);
    }

    public boolean isInside(final Location location) {
        if (!this.centerLocation.getWorld().equals(location.getWorld())) {
            return false;
        }
        return location.toVector().isInAABB(this.minimumPoint, this.maximumPoint);
    }

    private synchronized void updatePoints() {
        final int fixedSize = this.size / 2;
        this.minimumPoint = new Vector(this.centerLocation.getBlockX() - fixedSize, 0D,
                this.centerLocation.getBlockZ() - fixedSize);
        this.maximumPoint = new Vector(this.centerLocation.getBlockX() + fixedSize, 256D,
                this.centerLocation.getBlockZ() + fixedSize);
    }


}
