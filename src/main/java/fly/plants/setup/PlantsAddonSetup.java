package fly.plants.setup;

import fly.newmod.api.item.type.ModItemType;
import fly.plants.PlantsPlugin;
import fly.plants.blocks.food.tea.UnwitheredTeaLeavesItem;
import fly.plants.blocks.food.tea.WitheredTeaLeavesBlock;
import fly.plants.blocks.plants.tea.RipeTeaBlock;
import fly.plants.blocks.plants.tea.TeaSaplingItem;
import fly.plants.blocks.plants.tea.UnripeTeaBlock;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class PlantsAddonSetup {
    public static final ModItemType UNRIPE_TEA_LEAF;
    public static final ModItemType RIPE_TEA_LEAF;

    public static final RipeTeaBlock RIPE_TEA_BLOCK = new RipeTeaBlock();
    public static final UnripeTeaBlock UNRIPE_TEA_BLOCK = new UnripeTeaBlock();
    public static final TeaSaplingItem TEA_SAPLING = new TeaSaplingItem();

    public static final WitheredTeaLeavesBlock WITHERED_UNRIPE_TEA_LEAVES_BLOCK = new WitheredTeaLeavesBlock(Material.BIRCH_LEAVES, new NamespacedKey(PlantsPlugin.get(), "withered_unripe_tea_leaves"), UNRIPE_TEA_LEAF, 2, 6);
    public static final WitheredTeaLeavesBlock WITHERED_RIPE_TEA_LEAVES_BLOCK = new WitheredTeaLeavesBlock(Material.JUNGLE_LEAVES, new NamespacedKey(PlantsPlugin.get(), "withered_ripe_tea_leaves"), RIPE_TEA_LEAF, 2, 6);

    public static final UnwitheredTeaLeavesItem UNWITHERED_UNRIPE_TEA_LEAVES = new UnwitheredTeaLeavesItem(WITHERED_UNRIPE_TEA_LEAVES_BLOCK, Material.SPRUCE_LEAVES, new NamespacedKey(PlantsPlugin.get(), "unwithered_unripe_tea_leaves"));
    public static final UnwitheredTeaLeavesItem UNWITHERED_RIPE_TEA_LEAVES = new UnwitheredTeaLeavesItem(WITHERED_RIPE_TEA_LEAVES_BLOCK, Material.AZALEA_LEAVES, new NamespacedKey(PlantsPlugin.get(), "unwithered_ripe_tea_leaves"));
}
