package dev.gallon.horsestatsmod.forge

import dev.gallon.horsestatsmod.common.domain.ModMetadata
import dev.gallon.horsestatsmod.forge.config.ModConfig
import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.animal.horse.AbstractHorse
import net.minecraftforge.client.ConfigScreenHandler
import net.minecraftforge.client.event.ContainerScreenEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod

@Mod(ModMetadata.MOD_ID)
class HorseStatsMod {
    init {
        // Init config screen
        AutoConfig.register(ModConfig::class.java, ::JanksonConfigSerializer)
        ModLoadingContext
            .get()
            .registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory::class.java) {
                ConfigScreenHandler.ConfigScreenFactory { _: Minecraft?, parent: Screen? ->
                    AutoConfig.getConfigScreen(
                        ModConfig::class.java,
                        parent,
                    ).get()
                }
            }

        // Use config
        val config = AutoConfig.getConfigHolder(ModConfig::class.java).config
        println("Hello world, $config")
        // TODO: use config

        // Register event listeners
        MinecraftForge.EVENT_BUS.addListener(this::onEntityInteractEvent)
        MinecraftForge.EVENT_BUS.addListener(this::onDrawForegroundEvent)
    }

    private fun onEntityInteractEvent(event: PlayerInteractEvent.EntityInteractSpecific) {
        val target = event.target
        if (target is AbstractHorse) {
            // TODO: use the stats
            val stats = target.getStats()

            Minecraft.getInstance()
                .gui
                .setOverlayMessage(
                    Component.translatable("horsestatsmod.health"),
                    false,
                )
        }
    }

    private fun onDrawForegroundEvent(event: ContainerScreenEvent.Render.Foreground) {
        // TODO: render text if mouse is on the horse name
    }
}
