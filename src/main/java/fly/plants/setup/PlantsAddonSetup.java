package fly.plants.setup;

import fly.metals.setup.MetalsAddonSetup;
import fly.newmod.NewMod;
import fly.newmod.api.item.type.ModItemType;
import fly.plants.PlantsPlugin;
import fly.plants.blocks.food.tea.UnwitheredTeaLeavesItem;
import fly.plants.blocks.food.tea.WitheredTeaLeavesBlock;
import fly.plants.blocks.plants.SeedsItem;
import fly.plants.blocks.plants.tea.RipeTeaBlock;
import fly.plants.blocks.plants.tea.TeaSaplingItem;
import fly.plants.blocks.plants.tea.UnripeTeaBlock;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class PlantsAddonSetup {

    public static final ModItemType UNRIPE_TEA_LEAF = ModItemType.createAndRegister(Material.KELP, PlantsPlugin.get(), "unripe_tea_leaf", "Unripe Tea Leaf", 0x80FF80);
    public static final ModItemType RIPE_TEA_LEAF = ModItemType.createAndRegister(Material.KELP, PlantsPlugin.get(), "ripe_tea_leaf", "Ripe Tea Leaf", 0x40FF40);


    public static final ModItemType SLIGHTLY_OXIDIZED_UNRIPE_TEA_LEAF = tl(UNRIPE_TEA_LEAF, 1, "slightly_oxidized_unripe_tea_leaf", "Slightly Oxidized Unripe Tea Leaf");
    public static final ModItemType SLIGHTLY_OXIDIZED_RIPE_TEA_LEAF = tl(RIPE_TEA_LEAF, 1, "slightly_oxidized_unripe_tea_leaf", "Slightly Oxidized Ripe Tea Leaf");
    public static final ModItemType MODERATELY_OXIDIZED_RIPE_TEA_LEAF = tl(RIPE_TEA_LEAF, 2, "slightly_oxidized_unripe_tea_leaf", "Moderately Oxidized Ripe Tea Leaf");
    public static final ModItemType VERY_OXIDIZED_RIPE_TEA_LEAF = tl(RIPE_TEA_LEAF, 3, "slightly_oxidized_unripe_tea_leaf", "Very Oxidized Ripe Tea Leaf");

    public static final RipeTeaBlock RIPE_TEA_BLOCK = new RipeTeaBlock();
    public static final UnripeTeaBlock UNRIPE_TEA_BLOCK = new UnripeTeaBlock();
    public static final TeaSaplingItem TEA_SAPLING = new TeaSaplingItem();

    public static final WitheredTeaLeavesBlock WITHERED_UNRIPE_TEA_LEAVES_BLOCK = new WitheredTeaLeavesBlock(Material.BIRCH_LEAVES, new NamespacedKey(PlantsPlugin.get(), "withered_unripe_tea_leaves"), UNRIPE_TEA_LEAF, 2, 6);
    public static final WitheredTeaLeavesBlock WITHERED_RIPE_TEA_LEAVES_BLOCK = new WitheredTeaLeavesBlock(Material.JUNGLE_LEAVES, new NamespacedKey(PlantsPlugin.get(), "withered_ripe_tea_leaves"), RIPE_TEA_LEAF, 2, 6);

    public static final UnwitheredTeaLeavesItem UNWITHERED_UNRIPE_TEA_LEAVES = new UnwitheredTeaLeavesItem(WITHERED_UNRIPE_TEA_LEAVES_BLOCK, Material.SPRUCE_LEAVES, new NamespacedKey(PlantsPlugin.get(), "unwithered_unripe_tea_leaves"));
    public static final UnwitheredTeaLeavesItem UNWITHERED_RIPE_TEA_LEAVES = new UnwitheredTeaLeavesItem(WITHERED_RIPE_TEA_LEAVES_BLOCK, Material.AZALEA_LEAVES, new NamespacedKey(PlantsPlugin.get(), "unwithered_ripe_tea_leaves"));

    public static final SeedsItem TEA_SEEDS = new SeedsItem(Material.WHEAT_SEEDS, new NamespacedKey(PlantsPlugin.get(), "tea_seeds"), TEA_SAPLING.getBlock());

    public static ModItemType tl(ModItemType type, int count, String id, String name) {
        ModItemType ret = new ModItemType(Material.KELP, new NamespacedKey(PlantsPlugin.get(), id));

        ret.name(name, 0x00FF00);

        ItemStack[] ingredients = new ItemStack[count+1];

        ingredients[0] = type.create();

        for(int i = 0; i < count; i++) {
            ingredients[i+1] = MetalsAddonSetup.SALT.create();
        }

        ret.shapelessRecipe(1, ingredients);

        NewMod.get().getItemManager().registerItem(ret);

        return ret;
    }
}
