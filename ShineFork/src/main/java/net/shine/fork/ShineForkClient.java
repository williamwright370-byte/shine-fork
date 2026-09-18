package net.shine.fork; 
import net.fabricmc.api.ClientModInitializer; 
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap; 
import net.minecraft.client.render.RenderLayer; 
import net.minecraft.world.level.material.Fluids; 
public class ShineForkClient implements ClientModInitializer { 
    @Override 
    public void onInitializeClient() { 
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.translucent(), Fluids.LAVA, Fluids.FLOWING_LAVA); 
    } 
}
