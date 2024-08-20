package org.sayandev.sayanvanish.velocity.feature.features.prevent

import com.velocitypowered.api.event.PostOrder
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.player.TabCompleteEvent
import org.sayandev.sayanvanish.api.Permission
import org.sayandev.sayanvanish.api.User
import org.sayandev.sayanvanish.api.feature.Configurable
import org.sayandev.sayanvanish.api.feature.RegisteredFeature
import org.sayandev.sayanvanish.api.feature.category.FeatureCategories
import org.sayandev.sayanvanish.velocity.api.SayanVanishVelocityAPI
import org.sayandev.sayanvanish.velocity.api.SayanVanishVelocityAPI.Companion.getOrCreateUser
import org.sayandev.sayanvanish.velocity.feature.ListenedFeature
import org.spongepowered.configurate.objectmapping.ConfigSerializable

@RegisteredFeature
@ConfigSerializable
class FeaturePreventTabComplete(
    @Configurable val checkVanishLevel: Boolean = false
): ListenedFeature("prevent_tab_complete", category = FeatureCategories.PREVENTION) {

    @Subscribe(order = PostOrder.LAST)
    fun onTabComplete(event: TabCompleteEvent) {
        if (!isActive()) return
        val player = event.player ?: return
        val user = player.getOrCreateUser()
        val vanishedUsers = SayanVanishVelocityAPI.getInstance().getVanishedUsers()
        if (!user.hasPermission(Permission.VANISH) || !checkVanishLevel) {
            event.suggestions
                .removeIf { suggestion -> vanishedUsers.map(User::username).contains(suggestion) }
            return
        }
        
        event.suggestions.removeIf { suggestion ->
            vanishedUsers
                .filter { vanishedUser -> vanishedUser.vanishLevel > user.vanishLevel }
                .map(User::username).contains(suggestion)
        }
    }

}