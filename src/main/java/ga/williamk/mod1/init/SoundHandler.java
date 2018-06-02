package ga.williamk.mod1.init;

import ga.williamk.mod1.reference.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundHandler
{
    public static SoundEvent NUKE_EXPLOSION;

    public static void registerSounds()
    {
        NUKE_EXPLOSION = registerSound("explosion");
    }

    private static SoundEvent registerSound(String name)
    {
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}