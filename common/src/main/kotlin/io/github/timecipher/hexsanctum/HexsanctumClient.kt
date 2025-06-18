package io.github.timecipher.hexsanctum

import io.github.timecipher.hexsanctum.config.HexsanctumConfig
import io.github.timecipher.hexsanctum.config.HexsanctumConfig.GlobalConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HexsanctumClient {
    fun init() {
        HexsanctumConfig.initClient()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(GlobalConfig::class.java, parent).get()
    }
}
