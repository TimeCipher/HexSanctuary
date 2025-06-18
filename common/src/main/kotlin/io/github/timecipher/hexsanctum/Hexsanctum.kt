package io.github.timecipher.hexsanctum

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.timecipher.hexsanctum.config.HexsanctumConfig
import io.github.timecipher.hexsanctum.networking.HexsanctumNetworking
import io.github.timecipher.hexsanctum.registry.HexsanctumActions

object Hexsanctum {
    const val MODID = "hexsanctum"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        HexsanctumConfig.init()
        initRegistries(
            HexsanctumActions,
        )
        HexsanctumNetworking.init()
    }
}
