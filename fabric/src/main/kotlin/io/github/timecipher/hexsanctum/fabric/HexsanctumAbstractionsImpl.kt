@file:JvmName("HexsanctumAbstractionsImpl")

package io.github.timecipher.hexsanctum.fabric

import io.github.timecipher.hexsanctum.registry.HexsanctumRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HexsanctumRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
