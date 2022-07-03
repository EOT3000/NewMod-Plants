package e.bases;

import fly.plants.blocks.data.AgeableModBlockData;
import fly.newmod.NewMod;
import fly.newmod.api.block.BlockManager;
import fly.newmod.api.block.ModBlock;
import fly.newmod.api.block.type.ModBlockType;
import fly.newmod.api.event.BlockEventsListener;
import fly.newmod.api.event.block.ModBlockTickEvent;
import fly.newmod.api.item.type.ModItemType;
import fly.plants.blocks.data.AgeableModBlockDataImpl;
import fly.plants.blocks.plants.complex.ComplexPlant;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;

import java.util.Random;

public class SeedsBlock extends ModBlockType {
    public SeedsBlock(Material defaultMaterial, NamespacedKey id) {
        super(defaultMaterial, id, AgeableModBlockDataImpl.class);

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
                ModItemType plant = ((SeedsItem) getItem()).getPlant();

                b.setType(plant.getDefaultMaterial(), false);

                if(plant instanceof ComplexPlant) {
                    ((ComplexPlant) plant).place(l);
                }
            }
        }
    }
}
