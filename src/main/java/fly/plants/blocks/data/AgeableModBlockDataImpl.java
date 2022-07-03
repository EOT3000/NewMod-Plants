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

    protected AgeableModBlockDataImpl(ModBlockType type, int age) {
        super(type);

        this.age = age;
    }

    @Override
    public ModBlockData cloneBlock() {
        return null;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    public static class AgeableModBlockDataSerializer extends ModBlockDataSerializer<AgeableModBlockDataImpl> {
        public AgeableModBlockDataSerializer() {
            super(AgeableModBlockDataImpl.class);
        }

        @Override
        public AgeableModBlockDataImpl getBlockData(Map<String, String> map) {
            BlockManager manager = NewMod.get().getBlockManager();

            String age = map.getOrDefault("age", "0");

            try {
                return new AgeableModBlockDataImpl(manager.getType(map), Integer.parseInt(age));
            } catch (Exception e) {
                return new AgeableModBlockDataImpl(manager.getType(map), 0);
            }
        }

        @Override
        public AgeableModBlockDataImpl defaultMeta(ModBlockType modBlockType) {
            return new AgeableModBlockDataImpl(modBlockType, 0);
        }

        @Override
        public boolean applyData(Map<String, String> map, AgeableModBlockDataImpl data) {
            map.put("age", String.valueOf(data.getAge()));
            map.put("id", PersistentDataUtils.NAMESPACED_KEY.toPrimitive(data.getType().getId(), null));

            return true;
        }
    }
}
