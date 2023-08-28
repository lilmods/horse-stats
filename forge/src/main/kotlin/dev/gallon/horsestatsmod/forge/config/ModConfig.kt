package dev.gallon.horsestatsmod.forge.config

import dev.gallon.horsestatsmod.common.domain.ModConfig
import dev.gallon.horsestatsmod.common.domain.ModMetadata
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.autoconfig.annotation.ConfigEntry

@Config(name = ModMetadata.MOD_ID)
class ModConfig : ConfigData {
    // documentation: https://shedaniel.gitbook.io/cloth-config/auto-config/creating-a-config-class

    @ConfigEntry.Gui.CollapsibleObject
    val config = ModConfig()
}
