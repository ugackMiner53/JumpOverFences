package org.anticrustlicensinginitiative.jumpoverfences.mixin;

import com.mojang.authlib.GameProfile;
import org.anticrustlicensinginitiative.jumpoverfences.JumpChecker;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientPlayerEntity.class)
class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {
    public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    @Override
    protected float getJumpVelocity(){
        if (JumpChecker.shouldJumpFence((ClientPlayerEntity)(Object)this)) {
            return super.getJumpVelocity() + 0.05f;
        } else {
            return super.getJumpVelocity();
        }
    }
}
