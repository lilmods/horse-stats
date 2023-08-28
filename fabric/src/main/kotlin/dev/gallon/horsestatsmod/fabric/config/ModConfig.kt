package dev.gallon.horsestatsmod.fabric.config

import dev.gallon.horsestatsmod.common.HorseStatsConfig
import dev.gallon.horsestatsmod.common.ModMetadata
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.autoconfig.annotation.ConfigEntry

@Config(name = ModMetadata.MOD_ID)
class ModConfig : ConfigData {
    // documentation: https://shedaniel.gitbook.io/cloth-config/auto-config/creating-a-config-class

    @ConfigEntry.Gui.CollapsibleObject
    val config = HorseStatsConfig()
}
