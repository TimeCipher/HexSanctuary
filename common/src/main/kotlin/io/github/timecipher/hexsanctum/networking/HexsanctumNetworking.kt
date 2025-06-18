package io.github.timecipher.hexsanctum.networking

import dev.architectury.networking.NetworkChannel
import io.github.timecipher.hexsanctum.Hexsanctum
import io.github.timecipher.hexsanctum.networking.msg.HexsanctumMessageCompanion

object HexsanctumNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Hexsanctum.id("networking_channel"))

    fun init() {
        for (subclass in HexsanctumMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
