package io.github.timecipher.hexsanctum.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.timecipher.hexsanctum.Hexsanctum
import io.github.timecipher.hexsanctum.networking.HexsanctumNetworking
import io.github.timecipher.hexsanctum.networking.handler.applyOnClient
import io.github.timecipher.hexsanctum.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface HexsanctumMessage

sealed interface HexsanctumMessageC2S : HexsanctumMessage {
    fun sendToServer() {
        HexsanctumNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface HexsanctumMessageS2C : HexsanctumMessage {
    fun sendToPlayer(player: ServerPlayer) {
        HexsanctumNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        HexsanctumNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface HexsanctumMessageCompanion<T : HexsanctumMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                Hexsanctum.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is HexsanctumMessageC2S -> msg.applyOnServer(ctx)
                    else -> Hexsanctum.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                Hexsanctum.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is HexsanctumMessageS2C -> msg.applyOnClient(ctx)
                    else -> Hexsanctum.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
