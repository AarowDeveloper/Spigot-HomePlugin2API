package dev.aarow.homepluginapi;

import dev.aarow.home.HomePlugin;
import dev.aarow.home.data.player.Profile;
import dev.aarow.homepluginapi.data.Home;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class HomePluginAPI {

    public static List<Home> getHomes(UUID uuid){
        Profile profile = HomePlugin.getInstance().getProfileManager().get(uuid);

        return profile.getHomes().stream().map(home -> new Home(uuid, home.getName(), home.getLocation())).collect(Collectors.toList());
    }

    public static Home getHomeByName(UUID uuid, String name){
        Profile profile = HomePlugin.getInstance().getProfileManager().get(uuid);

        dev.aarow.home.data.home.Home home = profile.getHomeByName(name);

        return new Home(uuid, home.getName(), home.getLocation());
    }

    public static void teleportRequest(UUID uuid, Home home){
        if(Bukkit.getPlayer(uuid) == null) return;

        Bukkit.dispatchCommand(Bukkit.getPlayer(uuid), "home " + home.getName());
    }
}
