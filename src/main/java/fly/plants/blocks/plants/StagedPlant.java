package fly.plants.blocks.plants;

import fly.newmod.NewMod;
import fly.newmod.api.block.ModBlock;
import fly.newmod.api.block.data.ModBlockData;
import fly.newmod.api.block.type.ModBlockType;
import fly.newmod.api.event.BlockEventsListener;
import fly.newmod.api.event.block.ModBlockTickEvent;
import fly.newmod.utils.Pair;
import fly.plants.blocks.data.AgeableModBlockData;
import fly.plants.blocks.plants.stage.PlantStage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.type.Leaves;

public class StagedPlant extends ModBlockType {
    private PlantStage[] stages;
    private PlantStage def;

    public StagedPlant(Material type, NamespacedKey id, Class<? extends ModBlockData> clazz, PlantStage def, PlantStage... stages) {
        super(type, id, clazz);

        this.def = def;
        this.stages = stages;

        setListener(new DefaultStagedPlantListener());

        NewMod.get().getBlockManager().registerBlock(this);
    }

    public PlantStage getStage(int i) {
        if(i < 0) {
            return null;
        }

        if(i == 0) {
            return def;
        }

        if(stages.length > i-1) {
            return stages[i-1];
        }

        return null;
    }

    public static void tick(ModBlockTickEvent event, StagedPlant plant) {
        AgeableModBlockData data = (AgeableModBlockData) event.getModBlock().getData();

        PlantStage cstage = plant.getStage(data.getAge());
        PlantStage nstage = plant.getStage(data.getAge()+1);

        if(cstage == null || nstage == null) {
            return;
        }

        //TODO: plant grow event (bukkit, not mod system)
        if(nstage.shouldPlace(event.getBlock(), event.getModBlock())) {
            nstage.place(event.getBlock(), event.getModBlock());

            data.setAge(data.getAge()+1);
            data.setStageTicks(0);
        }

        data.setTotalTicks(data.getTotalTicks()+1);
        data.setStageTicks(data.getStageTicks()+1);

        event.getModBlock().setData(data);
        event.getModBlock().update();
    }

    @Override
    public void place(Block block, ModBlock modBlock) {
        AgeableModBlockData data = (AgeableModBlockData) modBlock.getData();

        getStage(data.getAge()).place(block, modBlock);
    }

    @SafeVarargs
    protected static PlantStage stem(int stage, Pair<Integer, Float>... pairs) {
        return new PlantStage(15, pairs) {
            @Override
            public boolean place(Block block, ModBlock modBlock) {
                block.setType(Material.MELON_STEM);

                Ageable data = (Ageable) block.getBlockData();

                data.setAge(stage);

                return true;
            }
        };
    }

    @SafeVarargs
    protected static PlantStage sapling(Pair<Integer, Float>... pairs) {
        return new PlantStage(15, pairs) {
            @Override
            public boolean place(Block block, ModBlock modBlock) {
                block.setType(Material.OAK_SAPLING);

                return true;
            }
        };
    }

    @SafeVarargs
    protected static PlantStage block(Material material, Pair<Integer, Float>... pairs) {
        return new PlantStage(15, pairs) {
            @Override
            public boolean place(Block block, ModBlock modBlock) {
                block.setType(material);

                if(block.getBlockData() instanceof Leaves) {
                    Leaves data = (Leaves) block.getBlockData();

                    data.setPersistent(true);
                }

                return true;
            }
        };
    }

    @SafeVarargs
    protected static PlantStage yamb(ModBlockType type, Pair<Integer, Float>... pairs) {
        return new PlantStage(15, pairs) {
            @Override
            public boolean place(Block block, ModBlock modBlock) {


                if(block.getBlockData() instanceof Leaves) {
                    Leaves data = (Leaves) block.getBlockData();

                    data.setPersistent(true);
                }

                return true;
            }
        };
    }

    public class DefaultStagedPlantListener implements BlockEventsListener {
        @Override
        public void onBlockTick(ModBlockTickEvent event) {
            tick(event, StagedPlant.this);
        }
    }
}
