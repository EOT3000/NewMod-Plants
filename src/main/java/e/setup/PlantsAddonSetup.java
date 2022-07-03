package e.setup;

import e.PlantsPlugin;
import e.impl.plants.tomato.TomatoPlantBlock;
import fly.metals.setup.MetalsAddonSetup;
import fly.newmod.api.item.type.ModItemType;
import fly.newmod.bases.ModItem;
import e.bases.SeedsItem;
import e.impl.plants.tea.Tea;
import e.impl.plants.tea.TeaPlant;
import e.impl.plants.tea.UnwitheredTeaLeaf;

import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;

public class PlantsAddonSetup {
    public static void init() {

    }

    public static final TeaPlant TEA_PLANT = new TeaPlant();

    public static final ModItemType WITHERED_UNRIPE_TEA_LEAVES = ModItemType.createAndRegister(Material.SPRUCE_LEAVES, PlantsPlugin.get(), "withered_unripe_tea_leaves", "Withered Unripe Tea Leaves", 0X608F51);
    public static final ModItemType WITHERED_RIPE_TEA_LEAVES = ModItemType.createAndRegister(Material.JUNGLE_LEAVES, PlantsPlugin.get(), "withered_ripe_tea_leaves", "Withered Ripe Tea Leaves", 0x508F50);

    public static final UnwitheredTeaLeaf UNRIPE_TEA_LEAVES = new UnwitheredTeaLeaf(Material.BIRCH_LEAVES, "Unripe Tea Leaves", 0xAAFF90, "unripe_tea_leaves", PlantsPlugin.get(), WITHERED_UNRIPE_TEA_LEAVES);
    public static final UnwitheredTeaLeaf RIPE_TEA_LEAVES = new UnwitheredTeaLeaf(Material.FLOWERING_AZALEA_LEAVES, "Ripe Tea Leaves", 0x90FF90, "ripe_tea_leaves", PlantsPlugin.get(), WITHERED_RIPE_TEA_LEAVES);

    public static final SeedsItem TEA_SEEDS_ITEM = new SeedsItem(Material.WHEAT_SEEDS, "Tea SeedsItem", NamedTextColor.DARK_GREEN, "tea_seeds", TEA_PLANT, RIPE_TEA_LEAVES);

    public static final ModItemType OXIDIZER = new ModItem(Material.SUGAR, "Oxidizer", 0xFFFFFF, "tea_oxidizer", MetalsAddonSetup.SALT);

    public static final ModItemType SLIGHTLY_OXIDIZED_UNRIPE_TEA_LEAF = new ModItem(Material.KELP, "Slightly Oxidized Unripe Tea Leaf", 0x00FF00, "slightly_oxidized_unripe_tea_leaf", 4, OXIDIZER, WITHERED_UNRIPE_TEA_LEAVES);

    public static final ModItemType SLIGHTLY_OXIDIZED_RIPE_TEA_LEAF = new ModItem(Material.KELP, "Slightly Oxidized Ripe Tea Leaf", 0x00FF00, "slightly_oxidized_ripe_tea_leaf", 4, OXIDIZER, WITHERED_RIPE_TEA_LEAVES);
    public static final ModItemType MODERATELY_OXIDIZED_RIPE_TEA_LEAF = new ModItem(Material.KELP, "Moderately Oxidized Ripe Tea Leaf", 0x00A800, "moderately_oxidized_ripe_tea_leaf", 4, OXIDIZER, OXIDIZER, WITHERED_RIPE_TEA_LEAVES);
    public static final ModItemType VERY_OXIDIZED_RIPE_TEA_LEAF = new ModItem(Material.KELP, "Very Oxidized Ripe Tea Leaf", 0x005400, "very_oxidized_ripe_tea_leaf", 4, OXIDIZER, OXIDIZER, OXIDIZER, WITHERED_RIPE_TEA_LEAVES);

    public static final Tea TEA = new Tea();

    public static final Tea.TeaLeaf WHITE_TEA = new Tea.TeaLeaf("White Tea", 0xFFFDE8, "white_tea", SLIGHTLY_OXIDIZED_UNRIPE_TEA_LEAF, false);

    public static final Tea.TeaLeaf GREEN_TEA = new Tea.TeaLeaf("Green Tea", 0xA9BF37, "green_tea", SLIGHTLY_OXIDIZED_RIPE_TEA_LEAF, false);
    public static final Tea.TeaLeaf OOLONG_TEA = new Tea.TeaLeaf("Oolong Tea", 0xFCD483, "oolong_tea", MODERATELY_OXIDIZED_RIPE_TEA_LEAF, false);
    public static final Tea.TeaLeaf BLACK_TEA = new Tea.TeaLeaf("Black Tea", 0xC25C40, "black_tea", VERY_OXIDIZED_RIPE_TEA_LEAF, false);

    public static final Tea.TeaLeaf SMOKED_BLACK_TEA = new Tea.TeaLeaf("Black Tea (Lapsang Souchong)", 0xBA7552, "smoked_black_tea", VERY_OXIDIZED_RIPE_TEA_LEAF, true);

    public static final ModItemType TOMATO_PLANT = new TomatoPlantBlock();

    public static final ModItemType TOMATO = new ModItem(Material.POPPY, "Tomato", 0xFF0000, "tomato");

    public static final SeedsItem TOMATO_SEEDS_ITEM = new SeedsItem(Material.WHEAT_SEEDS, "Tomato SeedsItem", TextColor.color(0xA00000), "tomato_seeds", TOMATO_PLANT, TOMATO);
}
