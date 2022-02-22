package fly.plants;

import fly.newmod.NewMod;
import fly.plants.impl.listeners.PlantsListener;
import fly.plants.setup.PlantsAddonSetup;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class PlantsPlugin extends NewMod.ModExtension {
    @Override
    public void load() {
        PlantsAddonSetup.init();
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlantsListener(), this);
    }
}
