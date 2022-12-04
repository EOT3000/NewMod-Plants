package fly.plants.listeners;

import fly.newmod.NewMod;
import fly.newmod.api.block.type.ModBlockType;
import fly.plants.blocks.plants.StagedPlant;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.world.StructureGrowEvent;

public class PlantsListener implements Listener {
    @EventHandler
    public void onCropGrow(BlockGrowEvent event) {
        if (isPlant(event.getBlock())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onGrow(StructureGrowEvent event) {
        if (isPlant(event.getLocation().getBlock())) {
            event.setCancelled(true);
        }
    }

    private boolean isPlant(Block location) {
        ModBlockType type = NewMod.get().getBlockManager().getType(location);

        return type instanceof StagedPlant;
    }
}
