package net.shine.fork.mixin; 
import net.minecraft.world.level.block.state.BlockState; 
import net.minecraft.world.level.block.LeavesBlock; 
import net.minecraft.core.particles.ParticleTypes; 
import net.minecraft.core.BlockPos; 
import net.minecraft.util.RandomSource; 
import net.minecraft.world.level.Level; 
import org.spongepowered.asm.mixin.Mixin; 
import org.spongepowered.asm.mixin.injection.At; 
import org.spongepowered.asm.mixin.injection.Inject; 
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo; 
@Mixin(LeavesBlock.class) 
public class InteractiveLeavesMixin { 
    @Inject(method = "animateTick", at = @At("TAIL")) 
    private void spawnLeafParticles(BlockState state, Level world, BlockPos pos, RandomSource random, CallbackInfo ci) { 
        if (random.nextInt(40) == 0) { 
            if (world.getBlockState(pos.below()).isAir()) { 
                double x = pos.getX() + random.nextDouble(); 
                double y = pos.getY() - 0.05; 
                double z = pos.getZ() + random.nextDouble(); 
                world.addParticle(ParticleTypes.WHITE_ASH, x, y, z, 0.0, -0.1, 0.0); 
            } 
        } 
    } 
}
