package dev.aarow.homepluginapi.data;

import dev.aarow.home.HomePlugin;
import dev.aarow.home.data.player.Profile;
import org.bukkit.Location;

import java.util.UUID;

public class Home {
    private UUID uuid;

    private String name;
    private Location location;

    public Home(UUID uuid, String name, Location location){
        this.uuid = uuid;

        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Profile profile = HomePlugin.getInstance().getProfileManager().get(uuid);

        dev.aarow.home.data.home.Home home = profile.getHomeByName(name);
        if(home == null) return;
        home.setName(name);

        profile.save();

        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        Profile profile = HomePlugin.getInstance().getProfileManager().get(uuid);

        dev.aarow.home.data.home.Home home = profile.getHomeByName(name);
        if(home == null) return;
        home.setLocation(location);

        profile.save();

        this.location = location;
    }
}
