package fly.plants.blocks.plants.tea;

import fly.newmod.api.block.ModBlock;
import fly.newmod.api.event.block.ModBlockBreakEvent;
import fly.newmod.utils.Pair;
import fly.plants.PlantsPlugin;
import fly.plants.blocks.data.AgeableModBlockData;
import fly.plants.blocks.data.AgeableModBlockDataImpl;
import fly.plants.blocks.plants.StagedPlant;
import fly.plants.setup.PlantsAddonSetup;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class TeaPlantBlock extends StagedPlant {
    public static Pair<Integer, Float>[] TIMES = new Pair[]{
        p(100,0), p(100,0.01F), p(1,1)
    };

    public TeaPlantBlock() {
        super(Material.OAK_SAPLING, new NamespacedKey(PlantsPlugin.get(), "tea_plant"), AgeableModBlockDataImpl.class, stem(1),
                stem(2, TIMES), stem(3, TIMES), stem(4, TIMES),
                stem(5, TIMES), stem(6, TIMES), stem(7, TIMES),
                sapling(TIMES), block(Material.AZALEA_LEAVES), block(Material.FLOWERING_AZALEA_LEAVES));
    }

    @Override
    public boolean isRightState(Block block, ModBlock modBlock) {
        Material m = block.getType();

        return m.equals(Material.MELON_STEM) || m.equals(Material.OAK_SAPLING) || m.equals(Material.AZALEA_LEAVES) || m.equals(Material.FLOWERING_AZALEA_LEAVES);
    }

    @Override
    public ItemStack getDropStack(ModBlockBreakEvent ne) {
        AgeableModBlockData data = (AgeableModBlockData) ne.getModBlock().getData();

        switch (data.getAge()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return null;

            case 7:
                return PlantsAddonSetup.TEA_SAPLING.create();

            case 8:
                return PlantsAddonSetup.UNRIPE_TEA_BLOCK.create();

            case 9:
                return PlantsAddonSetup.RIPE_TEA_BLOCK.create();

        }

        return super.getDropStack(ne);
    }

    private static Pair<Integer, Float> p(int a, float b) {
        return new Pair<>(a,b);
    }
}
