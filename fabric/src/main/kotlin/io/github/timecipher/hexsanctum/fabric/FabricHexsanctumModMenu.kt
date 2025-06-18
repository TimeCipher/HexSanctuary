package io.github.timecipher.hexsanctum.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.timecipher.hexsanctum.HexsanctumClient

object FabricHexsanctumModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HexsanctumClient::getConfigScreen)
}
