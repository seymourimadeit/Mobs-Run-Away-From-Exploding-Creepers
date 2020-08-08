package tallestegg.allmobsrunawayfromexplodingcreepers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

@EventBusSubscriber(modid = MRAFEC.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MRAFECConfig 
{
	public static final ForgeConfigSpec COMMON_SPEC;
	public static final CommonConfig COMMON;
	static {
		final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
		COMMON_SPEC = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	public static List<String> MobBlackList;
	
	public static void bakeConfig() {
		MobBlackList = COMMON.MobBlackList.get();
	}

	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
		if (configEvent.getConfig().getSpec() == MRAFECConfig.COMMON_SPEC) {
			bakeConfig();
		}
	}
	
	public static class CommonConfig 
	{

		private final ForgeConfigSpec.ConfigValue<List<String>> MobBlackList;

		public CommonConfig(ForgeConfigSpec.Builder builder) 
		{	
			 MobBlackList = builder
					.comment("Mobs in this list wont run away from creepers.")
					.define("Mob BlackList", new ArrayList<>());		
	    }
	}
}
