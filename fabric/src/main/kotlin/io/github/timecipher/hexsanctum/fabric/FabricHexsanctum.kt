package io.github.timecipher.hexsanctum.fabric

import io.github.timecipher.hexsanctum.Hexsanctum
import net.fabricmc.api.ModInitializer

object FabricHexsanctum : ModInitializer {
    override fun onInitialize() {
        Hexsanctum.init()
    }
}
