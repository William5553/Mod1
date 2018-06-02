package ga.williamk.mod1;

import ga.williamk.mod1.init.RegistryHandler;
import ga.williamk.mod1.reference.Reference;
import ga.williamk.mod1.tabs.ModTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.SUPPORTED_MC_VERSIONS)
public class Mod1 {

    public static CreativeTabs tabMod1 = new ModTab("tabMod1");


    @Mod.Instance(Reference.MOD_ID)
    public static Mod1 instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Log.debug("Starting Pre-Init...");
        RegistryHandler.preInitRegistries();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        Log.debug("Starting Init...");
        RegistryHandler.initRegistries();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Log.debug("Starting Post-Init...");
        RegistryHandler.postInitRegistries();
    }


}
