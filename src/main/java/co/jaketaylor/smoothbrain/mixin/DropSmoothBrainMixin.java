package co.jaketaylor.smoothbrain.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import co.jaketaylor.smoothbrain.SmoothBrainMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class DropSmoothBrainMixin extends Entity {
    // this just shuts up the compiler
    public DropSmoothBrainMixin(EntityType<?> e, World w) {
        super(e, w);
    }

    @Inject(at = @At("RETURN"), method="dropInventory")
    private void dropInventory(CallbackInfo info) {
        // he who has smooth brain
        LiteralText name = new LiteralText("billiambamer");

        if (this.hasCustomName() && this.getCustomName().equals(name)) {
            // Create a stack of one smooth brain
            ItemStack itemStack = new ItemStack(SmoothBrainMod.SMOOTH_BRAIN);

            // Create the smooth brain entity
            ItemEntity entity = new ItemEntity(this.world, this.x, this.y, this.z, itemStack);
            entity.setPickupDelay(40);
            entity.setThrower(this.uuid);

            // spawn the smooth brain
            this.world.spawnEntity(entity);
        }
    }
}
