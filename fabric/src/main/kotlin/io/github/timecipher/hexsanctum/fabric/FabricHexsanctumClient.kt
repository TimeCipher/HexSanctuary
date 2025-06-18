package io.github.timecipher.hexsanctum.fabric

import io.github.timecipher.hexsanctum.HexsanctumClient
import net.fabricmc.api.ClientModInitializer

object FabricHexsanctumClient : ClientModInitializer {
    override fun onInitializeClient() {
        HexsanctumClient.init()
    }
}
