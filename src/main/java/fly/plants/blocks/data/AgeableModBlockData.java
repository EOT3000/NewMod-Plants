package fly.plants.blocks.data;

import fly.newmod.api.block.data.ModBlockData;

public interface AgeableModBlockData extends ModBlockData {
    long getTotalTicks();

    void setTotalTicks(long ticks);

    long getStageTicks();

    void setStageTicks(long ticks);

    int getAge();

    void setAge(int age);
}
