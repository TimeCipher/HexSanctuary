package io.github.timecipher.hexsanctum.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.timecipher.hexsanctum.config.HexsanctumConfig
import io.github.timecipher.hexsanctum.networking.msg.*

fun HexsanctumMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            HexsanctumConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
