package io.github.timecipher.hexsanctum.forge

import io.github.timecipher.hexsanctum.HexsanctumClient
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.LOADING_CONTEXT

object ForgeHexsanctumClient {
    fun init(event: FMLClientSetupEvent) {
        HexsanctumClient.init()
        LOADING_CONTEXT.registerExtensionPoint(ConfigScreenFactory::class.java) {
            ConfigScreenFactory { _, parent -> HexsanctumClient.getConfigScreen(parent) }
        }
    }
}
