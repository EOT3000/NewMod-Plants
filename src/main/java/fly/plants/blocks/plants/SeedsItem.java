package fly.plants.blocks.plants;

import fly.newmod.api.block.ModBlock;
import fly.newmod.api.event.ItemEventsListener;
import fly.newmod.api.event.both.ModBlockItemUseEvent;
import fly.newmod.api.item.type.ModItemType;
import fly.plants.blocks.data.AgeableModBlockData;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class SeedsItem extends ModItemType {
    public SeedsItem(Material defaultMaterial, NamespacedKey id) {
        super(defaultMaterial, id);
    }

    public static class SeedsItemListener implements ItemEventsListener {
        @Override
        public void onItemUseLowest(ModBlockItemUseEvent event) {
            if(event.getBlock() == null) {
                return;
            }

            Material type = event.getBlock().getType();

            if(event.getBlockFace().equals(BlockFace.UP) && (type.equals(Material.DIRT) || type.equals(Material.GRASS_BLOCK) || type.equals(Material.COARSE_DIRT))) {
                Block r = event.getBlock().getRelative(0, 1, 0);

                if(r.getType().equals(Material.AIR)) {
                    ModBlock block = new ModBlock(event.getModItem().getType().getBlock());
                    AgeableModBlockData data = (AgeableModBlockData) block.getData();

                    data.setAge(1);

                    block.setData(data);

                    block.create(event.getBlock().getLocation().clone().add(0,1,0));
                }
            }
        }
    }
}
