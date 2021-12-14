package fly.plants.setup;

import fly.newmod.bases.ModItem;
import fly.plants.impl.TeaPlant;
import org.bukkit.Material;

public class PlantsAddonSetup {
    public static void init() {

    }

    public static ModItem TEA_PLANT = new TeaPlant();

    public static ModItem UNRIPE_TEA_LEAVES = new ModItem(Material.KELP, "&2Unripe Tea Leaves", "unripe_tea_leaves");
    public static ModItem RIPE_TEA_LEAVES = new ModItem(Material.KELP, "&2Ripe Tea Leaves", "ripe_tea_leaves");

    public static ModItem WITHERED_UNRIPE_TEA_LEAVES = new ModItem(Material.KELP, "&2Withered Unripe Tea Leaves", "withered_unripe_tea_leaves");
    public static ModItem WITHERED_RIPE_TEA_LEAVES = new ModItem(Material.KELP, "&2Withered Ripe Tea Leaves", "withered_ripe_tea_leaves");



}
