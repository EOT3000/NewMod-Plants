/*package fly.plants.blocks.food.tea;

import fly.newmod.NewMod;
import fly.newmod.api.block.ModBlock;
import fly.newmod.api.block.type.ModBlockType;
import fly.newmod.api.event.BlockEventsListener;
import fly.newmod.api.event.block.ModBlockTickEvent;
import fly.newmod.api.item.type.ModItemType;
import fly.plants.blocks.plants.complex.MultiStagePlant;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Leaves;

import java.util.Random;

public class UnwitheredTeaLeavesItem extends ModItemType {
    private final ModBlockType block;

    public UnwitheredTeaLeavesItem(ModBlockType turn, Material def, NamespacedKey key, String name, TextColor color) {
        super(def, key);

        name(name, color);

        this.block = turn;

        setBlock(new UnwitheredTeaLeafBlock(this));

        NewMod.get().getBlockManager().registerBlock(getBlock());
        NewMod.get().getItemManager().registerItem(this);
    }

    public static class UnwitheredTeaLeafBlock extends ModBlockType implements MultiStagePlant {
        private final UnwitheredTeaLeavesItem item;

        public UnwitheredTeaLeafBlock(UnwitheredTeaLeavesItem item) {
            super(item.defaultMaterial, item.id);

            this.item = item;

            setListener(new BlockEventsListener() {
                @Override
                public void onBlockTick(ModBlockTickEvent event) {
                    tick(event);
                }
            });
        }

        @Override
        public void next(Location location) {
            ModBlock block = new ModBlock(item.block);

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
*/