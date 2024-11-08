package xyz.luisch444.testcarpet;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.script.language.Sys;
import carpet.utils.Translations;
import net.fabricmc.api.ModInitializer;

import java.util.Map;

public class TestCarpetServer implements CarpetExtension, ModInitializer {

    @Override
    public void onInitialize() {
        TestCarpetServer.loadExtension();
    }

    public static void loadExtension() {
        CarpetServer.manageExtension(new TestCarpetServer());
    }

    @Override
    public void onGameStarted() {
        // let's /carpet handle our few simple settings
        CarpetServer.settingsManager.parseSettingsClass(TestCarpetSettings.class);
    }


    @Override
    public Map<String, String> canHasTranslations(String lang) {
        return Translations.getTranslationFromResourcePath("assets/testcarpet/lang/" + lang + ".json");
    }

}
