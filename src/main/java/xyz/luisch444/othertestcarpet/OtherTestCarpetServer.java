package xyz.luisch444.othertestcarpet;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.utils.Translations;
import net.fabricmc.api.ModInitializer;

import java.util.Map;

public class OtherTestCarpetServer implements CarpetExtension, ModInitializer {

    @Override
    public void onInitialize() {
        OtherTestCarpetServer.loadExtension();
    }

    public static void loadExtension() {
        CarpetServer.manageExtension(new OtherTestCarpetServer());
    }

    @Override
    public void onGameStarted() {
        // let's /carpet handle our few simple settings
        CarpetServer.settingsManager.parseSettingsClass(OtherTestCarpetSettings.class);
    }


    @Override
    public Map<String, String> canHasTranslations(String lang) {
        return Translations.getTranslationFromResourcePath("assets/othertestcarpet/lang/" + lang + ".json");
    }

}
