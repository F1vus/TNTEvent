package net.fiv.tnteventborukva.event;

import me.lucko.fabric.api.permissions.v0.Permissions;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TNTEvent implements UseBlockCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        ItemStack itemInHand = player.getStackInHand(hand);

        String itemNameInHand = itemInHand.getItem().toString();

        BlockPos blockPos = hitResult.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        
        if(itemNameInHand.equals("minecraft:flint_and_steel")){
            if(blockState.getBlock().getTranslationKey().equals("block.minecraft.tnt")){
                for(PlayerEntity p: world.getPlayers()){
                    if(Permissions.check(p, "tntevent.permission")){
                        String playerName = player.getName().getLiteralString();
                        p.sendMessage(Text.of("[УВАГА] Гравець "+playerName+" підпалив TNT"));
                    }
                }
            }
        }

        return ActionResult.PASS;
    }
}
