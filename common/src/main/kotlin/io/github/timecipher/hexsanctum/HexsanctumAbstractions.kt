@file:JvmName("HexsanctumAbstractions")

package io.github.timecipher.hexsanctum

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.timecipher.hexsanctum.registry.HexsanctumRegistrar

fun initRegistries(vararg registries: HexsanctumRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HexsanctumRegistrar<T>) {
    throw AssertionError()
}
