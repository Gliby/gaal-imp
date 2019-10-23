package gliby.gaal.impl;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import gliby.gaal.GAALCommonHandler;
import gliby.gaal.GAALMod;

import java.util.Arrays;
import java.util.Map;


//@IFMLLoadingPlugin.MCVersion("1.7.10")
//@IFMLLoadingPlugin.TransformerExclusions({"gliby.gaal.impl"})
@IFMLLoadingPlugin.MCVersion(value = "1.7.10")
@IFMLLoadingPlugin.DependsOn("forge")
public class FMLCoreGAALPlugin implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        System.out.println("mod container class: " + GAALModContainer.class.getCanonicalName());
        return GAALModContainer.class.getName();
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    public static class GAALModContainer extends DummyModContainer {

        public GAALModContainer() {
            super(new ModMetadata());
            GAALMod mod = GAALCommonHandler.instance().loadMod();
            if (mod != null) {
                ModMetadata meta = getMetadata();
                meta.modId = mod.modId();
                meta.name = mod.name();
                meta.description = "";
                meta.version = mod.version();
                meta.authorList = Arrays.asList("");

            }
        }

        @SubscribeEvent
        public void modConstruction(FMLConstructionEvent evt){

        }

        @SubscribeEvent
        public void preInit(FMLPreInitializationEvent evt) {

        }

        @SubscribeEvent
        public void init(FMLInitializationEvent evt) {

        }


        @SubscribeEvent
        public void postInit(FMLPostInitializationEvent evt) {

        }



        @Override
        public boolean registerBus(com.google.common.eventbus.EventBus bus, LoadController controller) {
            bus.register(this);
            return false;
        }
    }
}
