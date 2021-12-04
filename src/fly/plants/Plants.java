package fly.plants;

import fly.newmod.NewMod;
import fly.plants.setup.PlantsAddonSetup;

public class Plants extends NewMod.ModExtension {
    @Override
    public void load() {
        PlantsAddonSetup.init();
    }
}
