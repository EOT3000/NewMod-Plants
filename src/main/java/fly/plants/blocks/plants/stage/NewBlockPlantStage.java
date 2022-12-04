package fly.plants.blocks.plants.stage;

import fly.newmod.api.block.ModBlock;
import fly.newmod.utils.Pair;
import org.bukkit.block.Block;

public class NewBlockPlantStage extends PlantStage {
    public NewBlockPlantStage(float bestLight, Pair<Integer, Float>... times) {
        super(bestLight, times);
    }

    @Override
    public boolean place(Block block, ModBlock modBlock) {
        return false;
    }
}
