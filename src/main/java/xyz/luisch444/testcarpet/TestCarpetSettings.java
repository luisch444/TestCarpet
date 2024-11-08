package xyz.luisch444.testcarpet;

import carpet.api.settings.Rule;
import carpet.api.settings.RuleCategory;

public class TestCarpetSettings {


    public static final String TEST = "test";

    @Rule(
            categories = {RuleCategory.FEATURE, TEST}
    )
    public static boolean testFeature = false;

}
