package fly.plants.blocks.data;

import fly.newmod.NewMod;
import fly.newmod.api.block.BlockManager;
import fly.newmod.api.block.data.ModBlockData;
import fly.newmod.api.block.data.ModBlockDataSerializer;
import fly.newmod.api.block.type.ModBlockType;
import fly.newmod.utils.PersistentDataUtils;

import java.util.Map;

public class AgeableModBlockDataImpl extends ModBlockData.AbstractModBlockData implements AgeableModBlockData {
    private int age;
    private long stageTicks;
    private long totalTicks;

    protected AgeableModBlockDataImpl(ModBlockType type, int age, long totalTicks, long stageTicks) {
        super(type);

        this.age = age;
        this.totalTicks = totalTicks;
        this.stageTicks = stageTicks;
    }

    @Override
    public ModBlockData cloneBlock() {
        return new AgeableModBlockDataImpl(getType(), age, totalTicks, stageTicks);
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public long getStageTicks() {
        return stageTicks;
    }

    @Override
    public void setStageTicks(long stageTicks) {
        this.stageTicks = stageTicks;
    }

    @Override
    public long getTotalTicks() {
        return totalTicks;
    }

    @Override
    public void setTotalTicks(long totalTicks) {
        this.totalTicks = totalTicks;
    }

    public static class AgeableModBlockDataSerializer extends ModBlockDataSerializer<AgeableModBlockDataImpl> {
        public AgeableModBlockDataSerializer() {
            super(AgeableModBlockDataImpl.class);
        }

        @Override
        public AgeableModBlockDataImpl getBlockData(Map<String, String> map) {
            BlockManager manager = NewMod.get().getBlockManager();

            String age = map.getOrDefault("age", "0");
            String totalTicks = map.getOrDefault("totalTicks", "0");
            String stageTicks = map.getOrDefault("stageTicks", "0");

            try {
                return new AgeableModBlockDataImpl(manager.getType(map), Integer.parseInt(age), Long.parseLong(totalTicks), Long.parseLong(stageTicks));
            } catch (Exception e) {
                return new AgeableModBlockDataImpl(manager.getType(map), 0, 0, 0);
            }
        }

        @Override
        public AgeableModBlockDataImpl defaultMeta(ModBlockType modBlockType) {
            return new AgeableModBlockDataImpl(modBlockType, 0, 0, 0);
        }

        @Override
        public boolean applyData(Map<String, String> map, AgeableModBlockDataImpl data) {
            map.put("age", String.valueOf(data.getAge()));
            map.put("stageTicks", String.valueOf(data.getStageTicks()));
            map.put("totalTicks", String.valueOf(data.getTotalTicks()));
            map.put("id", PersistentDataUtils.NAMESPACED_KEY.toPrimitive(data.getType().getId(), null));

            return true;
        }
    }
}
