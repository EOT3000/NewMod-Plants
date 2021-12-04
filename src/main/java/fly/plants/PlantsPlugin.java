package fly.plants;

import fly.newmod.NewMod;
import fly.plants.setup.PlantsAddonSetup;

public class PlantsPlugin extends NewMod.ModExtension {
    @Override
    public void load() {
        PlantsAddonSetup.init();
    }
}
