package fly.plants.blocks.plants;

import fly.plants.blocks.plants.complex.ComplexPlant;
import fly.newmod.NewMod;
import fly.newmod.api.block.BlockManager;
import fly.newmod.api.block.ModBlock;
import fly.newmod.api.block.type.ModBlockType;
import fly.newmod.api.event.BlockEventsListener;
import fly.newmod.api.event.block.ModBlockTickEvent;
import fly.newmod.api.item.type.ModItemType;
import fly.plants.blocks.data.AgeableModBlockData;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;

import java.util.Random;

public class PrePlantBlock extends ModBlockType {
    public PrePlantBlock(SeedsItem item) {
        super(Material.MELON_STEM, item.getId());

        item.setBlock(this);

        setListener(new BlockEventsListener() {
            @Override
            public void onBlockTick(ModBlockTickEvent event) {
                tick(event);
            }
        });
    }

    private void tick(ModBlockTickEvent event) {
        BlockManager storage = NewMod.get().getBlockManager();

        Block b = event.getBlock();
        Location l = b.getLocation();
        ModBlock modBlock = storage.deserializeModBlock(b);

        Ageable ageable = (Ageable) b.getBlockData();
        AgeableModBlockData data = (AgeableModBlockData) modBlock.getData();

        ageable.setAge(data.getAge());

        b.setBlockData(ageable);

        Random random = new Random();

        if(random.nextDouble() < 0.5 && random.nextDouble() < 0.5) {
            ageable.setAge(ageable.getAge()+1);

            data.setAge(ageable.getAge());

            if(ageable.getAge() >= 4) {
                ModItemType plant = ((e.bases.SeedsItem) getItem()).getPlant();

                b.setType(plant.getDefaultMaterial(), false);

                if(plant instanceof ComplexPlant) {
                    ((ComplexPlant) plant).place(l);
                }
            }
        }
    }
}
