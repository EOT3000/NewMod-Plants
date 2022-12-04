package fly.plants.blocks.plants.stage;

import fly.newmod.api.block.ModBlock;
import fly.newmod.utils.Pair;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.function.Consumer;

public class SimpleStage extends PlantStage {
    private Consumer<Block> bottom;
    private Consumer<Block> top;

    public SimpleStage(Consumer<Block> bottom, Consumer<Block> top, float bestLight, Pair<Integer, Float>... times) {
        super(bestLight, times);

        this.bottom = bottom;
        this.top = top;
    }

    @Override
    public boolean place(Block block, ModBlock modBlock) {
        if(top != null) {
            bottom.accept(block);
        }

        Block above = block.getRelative(0,1,0);

        if(above.getType() != Material.AIR) {
            return false;
        }

        top.accept(block);

        return true;
    }

    //Returns an estimate of the amount of light at a specific time point. 18000 is darkest (0.0); 6000 is lightest (1.0). Returns -1 if the time is too high or too low
    private static double light(int time) {
        if(0 <= time && time < 12000) {
            return (-Math.abs(6000-time))/12000.0+1;
        }

        if(12000 <= time && time < 24000) {
            return Math.abs(18000-time)/12000.0;
        }

        return -1;
    }
}
