package io.github.timecipher.hexsanctum.networking.msg

import io.github.timecipher.hexsanctum.config.HexsanctumConfig
import net.minecraft.network.FriendlyByteBuf

data class MsgSyncConfigS2C(val serverConfig: HexsanctumConfig.ServerConfig) : HexsanctumMessageS2C {
    companion object : HexsanctumMessageCompanion<MsgSyncConfigS2C> {
        override val type = MsgSyncConfigS2C::class.java

        override fun decode(buf: FriendlyByteBuf) = MsgSyncConfigS2C(
            serverConfig = HexsanctumConfig.ServerConfig.decode(buf),
        )

        override fun MsgSyncConfigS2C.encode(buf: FriendlyByteBuf) {
            serverConfig.encode(buf)
        }
    }
}
