package com.martmists.jumpoverfences

import net.minecraft.block.Block
import net.minecraft.block.FenceBlock
import net.minecraft.block.WallBlock
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


object JumpChecker {
    fun shouldJumpFence(player: ClientPlayerEntity): Boolean {
        return (player.input.jumping && nextToFence(player))
    }

    private fun nextToFence(player: ClientPlayerEntity): Boolean {
        val x = player.pos.x
        val z = player.pos.z
        for (i in -1..1) {
            for (j in -1..1) {
                if (i.toDouble() != x || j.toDouble() != z) {
                    val block = getBlock(player.entityWorld, BlockPos(x + i.toDouble(), player.pos.getY(), z + j.toDouble()))
                    if (block is FenceBlock || block is WallBlock) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun getBlock(world: World, pos: BlockPos): Block {
        return world.getBlockState(pos).block
    }
}