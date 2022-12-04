package fly.plants;

import fly.newmod.NewMod;
import fly.plants.blocks.data.AgeableModBlockDataImpl;
import fly.plants.listeners.PlantsListener;
import fly.plants.setup.PlantsAddonSetup;
import org.bukkit.Bukkit;

public class PlantsPlugin extends NewMod.ModExtension {
    private static PlantsPlugin INSTANCE;

    public PlantsPlugin() {
        INSTANCE = this;
    }

    @Override
    public void load() {
        new AgeableModBlockDataImpl.AgeableModBlockDataSerializer();

        PlantsAddonSetup.init();
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlantsListener(), this);
    }

    public static PlantsPlugin get() {
        return INSTANCE;
    }
}
