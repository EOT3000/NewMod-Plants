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
    private long ticks;

    protected AgeableModBlockDataImpl(ModBlockType type, int age, long ticks) {
        super(type);

        this.age = age;
        this.ticks = ticks;
    }

    @Override
    public ModBlockData cloneBlock() {
        return new AgeableModBlockDataImpl(getType(), age, ticks);
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
    public long getTicks() {
        return ticks;
    }

    @Override
    public void setTicks(long ticks) {
        this.ticks = ticks;
    }

    public static class AgeableModBlockDataSerializer extends ModBlockDataSerializer<AgeableModBlockDataImpl> {
        public AgeableModBlockDataSerializer() {
            super(AgeableModBlockDataImpl.class);
        }

        @Override
        public AgeableModBlockDataImpl getBlockData(Map<String, String> map) {
            BlockManager manager = NewMod.get().getBlockManager();

            String age = map.getOrDefault("age", "0");
            String ticks = map.getOrDefault("ticks", "0");

            try {
                return new AgeableModBlockDataImpl(manager.getType(map), Integer.parseInt(age), Long.parseLong(ticks));
            } catch (Exception e) {
                return new AgeableModBlockDataImpl(manager.getType(map), 0, 0);
            }
        }

        @Override
        public AgeableModBlockDataImpl defaultMeta(ModBlockType modBlockType) {
            return new AgeableModBlockDataImpl(modBlockType, 0, 0);
        }

        @Override
        public boolean applyData(Map<String, String> map, AgeableModBlockDataImpl data) {
            map.put("age", String.valueOf(data.getAge()));
            map.put("id", PersistentDataUtils.NAMESPACED_KEY.toPrimitive(data.getType().getId(), null));

            return true;
        }
    }
}
