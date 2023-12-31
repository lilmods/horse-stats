package dev.gallon.horsestatsmod.fabric.mixins;

import dev.gallon.horsestatsmod.fabric.events.SingleEventBus;
import dev.gallon.horsestatsmod.fabric.events.TickEvent;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(method = "tick()V", at = @At("TAIL"))
    private void tickEvent(CallbackInfo info) {
        SingleEventBus.INSTANCE.send(new TickEvent("something"));
    }
}
