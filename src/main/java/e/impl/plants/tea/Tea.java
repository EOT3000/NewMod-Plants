package e.impl.plants.tea;

import e.PlantsPlugin;
import e.setup.PlantsAddonSetup;
import fly.newmod.bases.ModItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.ArrayList;
import java.util.List;

public class Tea extends ModItem {
    public Tea() {
        super(Material.POTION, "Tea", NamedTextColor.GREEN, "tea");
    }

    public static class TeaLeaf extends ModItem {
        private final int color;

        public TeaLeaf(String name, int color, String id, ModItem base, boolean smoked) {
            super(Material.DRIED_KELP, name, color, id);

            CookingRecipe<?> recipe;

            if(smoked) {
                recipe = new SmokingRecipe(new NamespacedKey(PlantsPlugin.getPlugin(PlantsPlugin.class), id), this, new RecipeChoice.ExactChoice(base), 5, 300);
            } else {
                recipe = new FurnaceRecipe(new NamespacedKey(PlantsPlugin.getPlugin(PlantsPlugin.class), id), this, new RecipeChoice.ExactChoice(base), 5, 500);
            }

            addRecipe(recipe);

            this.color = color;

            ShapelessRecipe liquid = new ShapelessRecipe(new NamespacedKey(PlantsPlugin.getPlugin(PlantsPlugin.class), id + "_liquid"), getLiquidTeaVariant());

            liquid.addIngredient(this);
            liquid.addIngredient(Material.POTION);

            addRecipe(liquid);
        }

        public ItemStack getLiquidTeaVariant() {
            ItemStack stack = new ItemStack(PlantsAddonSetup.TEA);
            PotionMeta meta = (PotionMeta) stack.getItemMeta();

            List<Component> lore = new ArrayList<>();

            lore.add(Component.text(""));
            lore.add(getComponentName());

            meta.lore(lore);

            meta.setColor(Color.fromRGB(color));

            stack.setItemMeta(meta);

            return stack;
        }
    }
}
