package com.martmists.jumpoverfences;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;

public class JumpChecker {
	private static Integer[] offsetsX = new Integer[] { -1, 1, 0, 0, 1, -1, 1, -1 };
	private static Integer[] offsetsZ = new Integer[] { 0, 0, 1, -1, 1, 1, -1, -1 };

	public static boolean shouldJumpFence(ClientPlayerEntity player) {
		if (player.input.jumping) {
			for (int i = 0; i < offsetsX.length; i++) {
				BlockPos blockPosToCheck = new BlockPos((player.getX() + offsetsX[i]), player.getY(), (player.getZ() + offsetsZ[i]));
				BlockState blockState = player.clientWorld.getBlockState(blockPosToCheck);
				if (blockState.getBlock().getClass() == FenceBlock.class || blockState.getBlock().getClass() == WallBlock.class) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}  
}