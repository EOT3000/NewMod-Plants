package e.impl.listeners;

import e.bases.Plant;
import fly.newmod.NewMod;
import fly.newmod.bases.ModItem;
import e.bases.SeedsItem;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.inventory.ItemStack;

public class PlantsListener implements Listener {
    @EventHandler
    public void onCropGrow(BlockGrowEvent event) {
        if (isPlant(event.getBlock().getLocation())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onGrow(StructureGrowEvent event) {
        if (isPlant(event.getLocation())) {
            event.setCancelled(true);
        }
    }

    private boolean isPlant(Location location) {
        String data = NewMod.get().getBlockStorage().getData(location, "id");

        if(data.isEmpty()) {
            return false;
        }

        ItemStack item = NewMod.get().getBlockStorage().getType(data);

        if(item instanceof Plant || item instanceof SeedsItem) {
            return true;
        }

        return false;
    }
}
