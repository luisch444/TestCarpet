package xyz.luisch444.othertestcarpet.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.luisch444.othertestcarpet.OtherTestCarpetSettings;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Shadow public abstract void sendMessage(Text message, boolean overlay);

    @Inject(method = "travel", at = @At(value = "TAIL"))
    public void jump(Vec3d movementInput, CallbackInfo ci){
        if (OtherTestCarpetSettings.testFeature){
            this.sendMessage(Text.literal("This is a test command, by OtherTestCarpet"), false);
        }
    }

}
