package ga.williamk.mod1.entity;

public class EntityWill extends EntityZombie {
    public EntityWill(World worldIn) {
        super(WorldIn);
    }

    @Override
    protected void entityInit() {

    }

    @Override
    public EntityZombie createChild(EntityAgeable ageable) {
        return new EntityNukePrimed(world);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return super.getHurtSound(source);
	}
	
	@Override 
	protected SoundEvent getDeathSound() {
		return super.getDeathSound();
	}
}
