package tallestegg.allmobsrunawayfromexplodingcreepers;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.monster.CreeperEntity;

public class AvoidExplodingCreepersGoal <T extends LivingEntity> extends AvoidEntityGoal<T> {

	public AvoidExplodingCreepersGoal(CreatureEntity p_i46404_1_, Class<T> p_i46404_2_, float p_i46404_3_, double p_i46404_4_, double p_i46404_6_) 
	{
		super(p_i46404_1_, p_i46404_2_, p_i46404_3_, p_i46404_4_, p_i46404_6_);
	}
	
	@Override
	public boolean shouldExecute() 
	{
		return super.shouldExecute() && this.avoidTarget instanceof CreeperEntity && ((CreeperEntity) this.avoidTarget).hasIgnited() || this.avoidTarget instanceof CreeperEntity && ((CreeperEntity) this.avoidTarget).getCreeperState() == 1;
	}

}
