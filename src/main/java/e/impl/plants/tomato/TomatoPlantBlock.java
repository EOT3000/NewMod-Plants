package e.impl.plants.tomato;

import fly.newmod.NewMod;
import fly.newmod.api.item.type.ModItemType;
import fly.newmod.bases.ModItem;
import fly.newmod.setup.BlockStorage;
import e.PlantsPlugin;
import fly.plants.blocks.plants.complex.ComplexPlant;
import e.setup.PlantsAddonSetup;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.Bisected;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class TomatoPlantBlock extends ModItemType implements ComplexPlant {
    public TomatoPlantBlock() {
        super(Material.ROSE_BUSH, new NamespacedKey(PlantsPlugin.get(), "tomato_plant"));

        name("Tomato Plant", TextColor.color(0xC9A100));

        NewMod.get().getItemManager().registerItem(this);
    }

    @Override
    public void onBreak(BlockBreakEvent event) {
        Location location = event.getBlock().getLocation();

        ItemStack stack = new ItemStack(PlantsAddonSetup.TOMATO);

        stack.setAmount(new Random().nextInt(6)+2);

        location.getWorld().dropItem(location, stack);
    }

    @Override
    public void place(Location location) {
        Block block = location.clone().add(0, 1, 0).getBlock();

        block.setType(Material.ROSE_BUSH, false);

        Bisected bisected = (Bisected) block.getBlockData();

        bisected.setHalf(Bisected.Half.TOP);

        block.setBlockData(bisected);

        NewMod.get().getBlockManager().changeData(block.getLocation(), "id", getId());
    }
}
