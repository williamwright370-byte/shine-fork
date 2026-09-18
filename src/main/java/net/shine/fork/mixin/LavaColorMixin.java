package net.shine.fork.mixin; 
import net.minecraft.client.renderer.block.LiquidBlockRenderer; 
import net.minecraft.world.level.material.FluidState; 
import net.minecraft.tags.FluidTags; 
import net.minecraft.core.BlockPos; 
import net.minecraft.world.level.BlockAndTintView; 
import net.minecraft.world.level.biome.Biome; 
import org.spongepowered.asm.mixin.Mixin; 
import org.spongepowered.asm.mixin.injection.At; 
import org.spongepowered.asm.mixin.injection.Inject; 
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable; 
@Mixin(LiquidBlockRenderer.class) 
public class LavaColorMixin { 
    @Inject(method = "getFluidColor", at = @At("HEAD"), cancellable = true) 
    private void tintLavaByBiome(BlockAndTintView world, BlockPos pos, FluidState state, CallbackInfoReturnable<Integer> cir) { 
        if (state.is(FluidTags.LAVA)) { 
            Biome biome = world.getBiome(pos).value(); 
            if (biome.getBaseTemperature() > 1.0f) { 
                cir.setReturnValue(0xFF5500); 
            } else if (biome.getBaseTemperature() < 0.2f) { 
                cir.setReturnValue(0x8A2BE2); 
            } else { 
                cir.setReturnValue(0x7FFF00); 
            } 
        } 
    } 
}
