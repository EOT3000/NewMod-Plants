package fly.plants;

import e.impl.listeners.PlantsListener;
import e.setup.PlantsAddonSetup;
import fly.newmod.NewMod;
import fly.plants.blocks.data.AgeableModBlockDataImpl;
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
