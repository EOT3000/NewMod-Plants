package fly.plants.impl;

import fly.newmod.NewMod;
import fly.plants.bases.Plant;
import fly.plants.setup.PlantsAddonSetup;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class TeaPlant extends Plant {
    private static Random random = new Random();

    public TeaPlant() {
        super(Material.OAK_SAPLING, Material.ACACIA_LEAVES, Material.JUNGLE_LEAVES, "&2Tea Plant", "tea_plant", 7200);
    }

    @Override
    public void onBreak(BlockBreakEvent event) {
        Location location = event.getBlock().getLocation();

        String data = NewMod.get().getBlockStorage().getData(location, "stage");
        ItemStack stack = new ItemStack(Material.AIR);

        if(data.equalsIgnoreCase("1")) {
            return;
        }

        if(data.equalsIgnoreCase("2")) {
            NewMod.get().getBlockStorage().changeData(location, "stage", "1");

            stack = new ItemStack(PlantsAddonSetup.UNRIPE_TEA_LEAVES);
        }

        if(data.equalsIgnoreCase("3")) {
            NewMod.get().getBlockStorage().changeData(location, "stage", "1");

            stack = new ItemStack(PlantsAddonSetup.RIPE_TEA_LEAVES);
        }

        stack.setAmount(random.nextInt(5));

        location.getBlock().setType(Material.OAK_SAPLING);

        location.getWorld().dropItem(location, stack);
    }
}
