package fly.plants.blocks.plants.tea;

import fly.newmod.NewMod;
import fly.newmod.api.block.ModBlock;
import fly.newmod.api.block.type.ModBlockType;
import fly.newmod.api.event.BlockEventsListener;
import fly.newmod.api.event.block.ModBlockTickEvent;
import fly.newmod.api.item.type.ModItemType;
import fly.plants.PlantsPlugin;
import fly.plants.blocks.plants.complex.MultiStagePlant;
import fly.plants.setup.PlantsAddonSetup;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Leaves;

import java.util.Random;

public class TeaSaplingItem extends ModItemType {
    public TeaSaplingItem() {
        super(Material.OAK_SAPLING, new NamespacedKey(PlantsPlugin.get(), "tea_sapling"));

        setBlock(new TeaSaplingBlock(this));

        NewMod.get().getItemManager().registerItem(this);
        NewMod.get().getBlockManager().registerBlock(getBlock());
    }

    public static class TeaSaplingBlock extends ModBlockType implements MultiStagePlant {
        public TeaSaplingBlock(TeaSaplingItem item) {
            super(item.defaultMaterial, item.id);

            setListener(new BlockEventsListener() {
                @Override
                public void onBlockTick(ModBlockTickEvent event) {
                    tick(event);
                }
            });
        }

        @Override
        public void next(Location location) {
            ModBlock block = new ModBlock(PlantsAddonSetup.UNRIPE_TEA_BLOCK);

            block.create(location);
        }

        private void tick(ModBlockTickEvent event) {
            Random random = new Random();

            if (random.nextInt(3000) == 1) {
                Block block = event.getBlock();

                next(block.getLocation());

                // You can do this in java now apparently ¯\_(ツ)_/¯
                if (block.getBlockData() instanceof Leaves leaves) {
                    leaves.setPersistent(true);

                    block.setBlockData(leaves);
                }
            }
        }
    }
}
