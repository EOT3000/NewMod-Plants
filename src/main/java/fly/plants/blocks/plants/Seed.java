package fly.plants.blocks.plants;

import fly.newmod.NewMod;
import fly.newmod.api.block.ModBlock;
import fly.newmod.api.event.ItemEventsListener;
import fly.newmod.api.event.both.ModBlockItemUseEvent;
import fly.newmod.api.item.type.ModItemType;
import fly.plants.blocks.data.AgeableModBlockData;
import fly.plants.setup.PlantsAddonSetup;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

public class Seed extends ModItemType {
    private final int stage;
    private final StagedPlant plant;
    
    public Seed(int stage, StagedPlant plant, Material item, NamespacedKey id) {
        super(item, id);
        
        this.stage = stage;
        this.plant = plant;

        setListener(new ItemEventsListener() {
            @Override
            public void onItemUseLowest(ModBlockItemUseEvent event) {
                if(event.getBlockFace().equals(BlockFace.UP)) {
                    Material type = event.getBlock().getType();

                    Block rel = event.getBlock().getRelative(0,1,0);

                    if(type.equals(Material.DIRT) && rel.getType().equals(Material.AIR)) {
                        ItemStack item = event.getItem();

                        item.setAmount(item.getAmount()-1);

                        ModBlock created = new ModBlock(plant);

                        AgeableModBlockData data = (AgeableModBlockData) created.getData();

                        data.setAge(stage);

                        created.setData(data);

                        created.create(rel.getLocation());
                    }
                }

                event.setCancelled(true);
            }
        });

        NewMod.get().getItemManager().registerItem(this);
    }
}
