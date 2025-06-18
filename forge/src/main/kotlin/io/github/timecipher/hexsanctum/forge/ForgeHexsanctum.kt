package io.github.timecipher.hexsanctum.forge

import dev.architectury.platform.forge.EventBuses
import io.github.timecipher.hexsanctum.Hexsanctum
import net.minecraft.data.DataProvider
import net.minecraft.data.DataProvider.Factory
import net.minecraft.data.PackOutput
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Hexsanctum.MODID)
class HexsanctumForge {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Hexsanctum.MODID, this)
            addListener(ForgeHexsanctumClient::init)
            addListener(::gatherData)
        }
        Hexsanctum.init()
    }

    private fun gatherData(event: GatherDataEvent) {
        event.apply {
            // TODO: add datagen providers here
        }
    }
}

fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, factory: (PackOutput) -> T) =
    generator.addProvider(run, Factory { factory(it) })
