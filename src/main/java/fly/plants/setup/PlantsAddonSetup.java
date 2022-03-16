package fly.plants.setup;

import fly.metals.setup.MetalsAddonSetup;
import fly.newmod.bases.ModItem;
import fly.plants.bases.Seeds;
import fly.plants.impl.Tea;
import fly.plants.impl.TeaPlant;
import fly.plants.impl.UnwitheredTeaLeaf;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;

public class PlantsAddonSetup {
    public static void init() {

    }

    public static TeaPlant TEA_PLANT = new TeaPlant();

    public static ModItem WITHERED_UNRIPE_TEA_LEAVES = new ModItem(Material.SPRUCE_LEAVES, "Withered Unripe Tea Leaves", 0X608F51, "withered_unripe_tea_leaves");
    public static ModItem WITHERED_RIPE_TEA_LEAVES = new ModItem(Material.JUNGLE_LEAVES, "Withered Ripe Tea Leaves", 0x508F50, "withered_ripe_tea_leaves");

    public static UnwitheredTeaLeaf UNRIPE_TEA_LEAVES = new UnwitheredTeaLeaf(Material.BIRCH_LEAVES, "Unripe Tea Leaves", 0xAAFF90, "unripe_tea_leaves", WITHERED_UNRIPE_TEA_LEAVES);
    public static UnwitheredTeaLeaf RIPE_TEA_LEAVES = new UnwitheredTeaLeaf(Material.FLOWERING_AZALEA_LEAVES, "Ripe Tea Leaves", 0x90FF90, "ripe_tea_leaves", WITHERED_RIPE_TEA_LEAVES);

    public static Seeds TEA_SEEDS = new Seeds(Material.WHEAT_SEEDS, "Tea Seeds", NamedTextColor.DARK_GREEN, "tea_seeds", TEA_PLANT, RIPE_TEA_LEAVES);

    public static ModItem OXIDIZER = new ModItem(Material.SUGAR, "Oxidizer", 0xFFFFFF, "tea_oxidizer", MetalsAddonSetup.SALT);

    public static ModItem SLIGHTLY_OXIDIZED_UNRIPE_TEA_LEAF = new ModItem(Material.KELP, "Slightly Oxidized Unripe Tea Leaf", 0x00FF00, "slightly_oxidized_unripe_tea_leaf", 4, OXIDIZER, WITHERED_UNRIPE_TEA_LEAVES);

    public static ModItem SLIGHTLY_OXIDIZED_RIPE_TEA_LEAF = new ModItem(Material.KELP, "Slightly Oxidized Ripe Tea Leaf", 0x00FF00, "slightly_oxidized_ripe_tea_leaf", 4, OXIDIZER, WITHERED_RIPE_TEA_LEAVES);
    public static ModItem MODERATELY_OXIDIZED_RIPE_TEA_LEAF = new ModItem(Material.KELP, "Moderately Oxidized Ripe Tea Leaf", 0x00A800, "moderately_oxidized_ripe_tea_leaf", 4, OXIDIZER, OXIDIZER, WITHERED_RIPE_TEA_LEAVES);
    public static ModItem VERY_OXIDIZED_RIPE_TEA_LEAF = new ModItem(Material.KELP, "Very Oxidized Ripe Tea Leaf", 0x005400, "very_oxidized_ripe_tea_leaf", 4, OXIDIZER, OXIDIZER, OXIDIZER, WITHERED_RIPE_TEA_LEAVES);

    public static Tea TEA = new Tea();

    public static Tea.TeaLeaf WHITE_TEA = new Tea.TeaLeaf("White Tea", 0xFFFDE8, "white_tea", SLIGHTLY_OXIDIZED_UNRIPE_TEA_LEAF, false);

    public static Tea.TeaLeaf GREEN_TEA = new Tea.TeaLeaf("Green Tea", 0xA9BF37, "green_tea", SLIGHTLY_OXIDIZED_RIPE_TEA_LEAF, false);
    public static Tea.TeaLeaf OOLONG_TEA = new Tea.TeaLeaf("Oolong Tea", 0xFCD483, "oolong_tea", MODERATELY_OXIDIZED_RIPE_TEA_LEAF, false);
    public static Tea.TeaLeaf BLACK_TEA = new Tea.TeaLeaf("Black Tea", 0xC25C40, "black_tea", VERY_OXIDIZED_RIPE_TEA_LEAF, false);

    public static Tea.TeaLeaf SMOKED_BLACK_TEA = new Tea.TeaLeaf("Black Tea (Lapsang Souchong)", 0xBA7552, "smoked_black_tea", VERY_OXIDIZED_RIPE_TEA_LEAF, true);
}
