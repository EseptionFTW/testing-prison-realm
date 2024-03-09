package net.eseption.prisonrealm.block.custom;

import net.eseption.prisonrealm.block.entity.SealedPrisonRealmBlockEntity;
import net.eseption.prisonrealm.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SealedPrisonRealmBlock extends BaseEntityBlock {
    public SealedPrisonRealmBlock(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new SealedPrisonRealmBlockEntity(pPos,pState);
    }
    private static final VoxelShape SHAPE =
            Block.box(4, 0, 4, 12, 8, 12);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.isCrouching()) {
            if (pPlayer.getItemInHand(pHand) == ItemStack.EMPTY) {
                pPlayer.setItemInHand(pHand, getBlockItem(pLevel, pPos, pPlayer));
            } else {
                pPlayer.addItem(getBlockItem(pLevel, pPos, pPlayer));
            }
            pLevel.destroyBlock(pPos, false);
            return InteractionResult.SUCCESS;
        } else {

            return InteractionResult.FAIL;
        }
    }

    //created
    public ItemStack getBlockItem(Level pLevel, BlockPos pPos, Player pPlayer) {
        String tagValue;
        tagValue = pLevel.getBlockEntity(pPos).serializeNBT().getString("prisonrealm.block_uuid");

        CompoundTag pTag = new CompoundTag();

        if (tagValue != "") {
            pTag.putString("prisonrealm.item_uuid", tagValue);
        }

        ItemStack stack = new ItemStack(ModItems.SEALED_PRISON_REALM_ITEM.get());
        stack.setTag(pTag);
        return stack;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return super.getTicker(pLevel, pState, pBlockEntityType);
    }

}