/*package fly.plants.blocks.food.tea;

import fly.newmod.NewMod;
import fly.newmod.api.block.type.ModBlockType;
import fly.newmod.api.event.BlockEventsListener;
import fly.newmod.api.event.block.ModBlockBreakEvent;
import fly.newmod.api.item.ModItemStack;
import fly.newmod.api.item.type.ModItemType;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import java.util.Random;

public class WitheredTeaLeavesBlock extends ModBlockType {
    private final ModItemType item;
    private final int min;
    private final int max;

    private Random random = new Random();

    public WitheredTeaLeavesBlock(Material defaultMaterial, NamespacedKey id, ModItemType item, int min, int max) {
        super(defaultMaterial, id);

        this.item = item;
        this.min = min;
        this.max = max;

        setListener(new BlockEventsListener() {
            @Override
            public void onBlockBreakHighest(ModBlockBreakEvent event) {
                event.setVanillaDrop(false);
            }

            @Override
            public void onBlockBreakMonitor(ModBlockBreakEvent event) {
                Location loc = event.getBlock().getLocation();

                ModItemStack modItemStack = new ModItemStack(item);

                modItemStack.setAmount(random.nextInt(max-min)+min);

                loc.getWorld().dropItem(loc, modItemStack.create());
            }
        });

        NewMod.get().getBlockManager().registerBlock(this);
    }

    public ModItemType getDroppedItem() {
        return item;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
*/