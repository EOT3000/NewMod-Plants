package fly.plants.blocks.plants.stage;

import fly.newmod.api.block.ModBlock;
import fly.newmod.api.block.type.ModBlockType;
import fly.newmod.utils.Pair;
import fly.plants.blocks.data.AgeableModBlockData;
import org.bukkit.block.Block;

import java.util.Random;

public abstract class PlantStage {
    private static Random random = new Random();

    private final float bestLight;
    private final Pair<Integer, Float>[] times;

    public PlantStage(float bestLight, Pair<Integer, Float>... times) {
        this.bestLight = bestLight;
        this.times = times;
    }

    public boolean shouldPlace(Block block, ModBlock modBlock) {
        AgeableModBlockData data = (AgeableModBlockData) modBlock.getData();

        double dis = (block.getLightFromSky()/15.0)*light(block.getWorld().getTime());
        long time = data.getStageTicks();

        for(Pair<Integer, Float> interval : times) {
            if(interval.getValue() < time) {
                time-=interval.getValue();
            } else {
                return random.nextDouble() < dis*interval.getValue();
            }
        }

        return false;
    }

    public abstract boolean place(Block block, ModBlock modBlock);

    //Returns an estimate of the amount of light at a specific time point. 18000 is darkest (0.0); 6000 is lightest (1.0). Returns -1 if the time is too high or too low
    private static double light(long time) {
        if(0 <= time && time < 12000) {
            return (-Math.abs(6000-time))/12000.0+1;
        }

        if(12000 <= time && time < 24000) {
            return Math.abs(18000-time)/12000.0;
        }

        return -1;
    }
}
