package gliby.gaal.impl;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.Side;
import gliby.gaal.GAALCommonHandler;
import gliby.gaal.GAALMod;

import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.Map;


//@IFMLLoadingPlugin.MCVersion("1.7.10")
//@IFMLLoadingPlugin.TransformerExclusions({"gliby.gaal.impl"})
//@IFMLLoadingPlugin.MCVersion(value = "1.7.10")
//@IFMLLoadingPlugin.DependsOn("forge")
public class FMLCoreGAALPlugin implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
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

        @Override
        public Certificate getSigningCertificate()
        {
            if (FMLLaunchHandler.side() != Side.CLIENT)
                return null;

            try
            {
                Class<?> cbr = Class.forName("net.minecraft.client.ClientBrandRetriever", false, getClass().getClassLoader());
                Certificate[] certificates = cbr.getProtectionDomain().getCodeSource().getCertificates();
                return certificates != null ? certificates[0] : null;
            }
            catch (Exception e){} // Errors don't matter just return null.
            return null;
        }

        @SubscribeEvent
        public void modConstruction(FMLConstructionEvent evt){

        }

        @SubscribeEvent
        public void preInit(FMLPreInitializationEvent evt) {
            System.out.println("pre-init gaal");
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
