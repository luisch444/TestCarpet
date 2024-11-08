package xyz.luisch444.testcarpet.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.luisch444.testcarpet.TestCarpetSettings;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Shadow public abstract void sendMessage(Text message, boolean overlay);

    @Inject(method = "jump", at = @At(value = "TAIL"))
    public void jump(CallbackInfo ci){
        if (TestCarpetSettings.testFeature){
            this.sendMessage(Text.literal("This is a test command, by TestCarpet"), false);
        }
    }

}
