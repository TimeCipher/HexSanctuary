@file:JvmName("HexsanctumAbstractionsImpl")

package io.github.timecipher.hexsanctum.forge

import io.github.timecipher.hexsanctum.registry.HexsanctumRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: HexsanctumRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
