package fly.plants.blocks.data;

import fly.newmod.api.block.data.ModBlockData;

public interface AgeableModBlockData extends ModBlockData {
    int getAge();

    void setAge(int age);
}