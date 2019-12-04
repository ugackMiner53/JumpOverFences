package com.martmists.jumpoverfences

import net.minecraft.block.FenceBlock
import net.minecraft.block.WallBlock
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.util.math.BlockPos


object JumpChecker {
    private val offsets = arrayOf(
        arrayOf(-1, 0),
        arrayOf(1, 0),
        arrayOf(0, 1),
        arrayOf(0, -1),
        arrayOf(1, 1),
        arrayOf(-1, 1),
        arrayOf(1, -1),
        arrayOf(-1, -1)
    )

    fun shouldJumpFence(player: ClientPlayerEntity): Boolean {
        return player.input.jumping && offsets.any {
            val block = player.entityWorld.getBlockState(
                BlockPos(
                    player.x + it[0],
                    player.y,
                    player.z + it[1]
                )
            ).block
            block is FenceBlock || block is WallBlock
        }
    }
}
