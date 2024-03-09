package net.eseption.prisonrealm.item.custom;

import net.eseption.prisonrealm.block.ModBlocks;
import net.eseption.prisonrealm.block.entity.ModBlockEntities;
import net.eseption.prisonrealm.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SealedPrisonRealmItem extends BlockItem {
    public static final BooleanProperty OWNED = BooleanProperty.create("owned");
    public CompoundTag defaultTag = new CompoundTag();


    public SealedPrisonRealmItem(Block pBlock, Properties pProperties) {
        super(ModBlocks.SEALED_PRISON_REALM.get(), pProperties);
        defaultTag.putString("prisonream.item_uuid","");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pPlayer.getItemInHand(pUsedHand).hasTag() && pPlayer.isCrouching()) {
            addNbtData(pPlayer, pUsedHand);
            //|| pPlayer.getItemInHand(pUsedHand).getTag().getString("prisonrealm.item_uuid") == "" && pPlayer.isCrouching()
        } else {
            pPlayer.getItemInHand(pUsedHand).setTag(new CompoundTag());
            //CompoundTag pTag = new CompoundTag();
            //pTag.putString("prisonream.item_uuid", "");
            //pPlayer.getItemInHand(pUsedHand).setTag(pTag);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    public String playerUUID(Player player) {
        if (player.getItemInHand(player.getUsedItemHand()).hasTag()) {
            String value;
            value = player.getItemInHand(player.getUsedItemHand()).getTag().getString("prisonrealm.item_uuid");
            return value;
        } else {
            return "";
        }
    }

    private void setBlockEntity(BlockPlaceContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        BlockPos blockPos = pContext.getClickedPos();

        CompoundTag pTag = new CompoundTag();
        pTag.putString("prisonrealm.block_uuid", playerUUID(player));

        //if (player.getItemInHand(player.getUsedItemHand()).hasTag()) {
            BlockEntity bEntity = ModBlockEntities.SEALED_PRISON_REALM_BLOCK_ENTITY.get().create(blockPos, ModBlocks.SEALED_PRISON_REALM.get().defaultBlockState());
            level.setBlock(blockPos, ModBlocks.SEALED_PRISON_REALM.get().defaultBlockState(), 3);
            bEntity.load(pTag);
            bEntity.setChanged();
            assert bEntity != null;
            level.setBlockEntity(bEntity);
            bEntity.setChanged();
            player.getItemInHand(player.getUsedItemHand()).setCount(0);
            player.interact(player, player.getUsedItemHand());
        //} else {
        //    level.setBlock(blockPos, ModBlocks.SEALED_PRISON_REALM.get().defaultBlockState(), 3);
       // }

    }

    private void addNbtData(Player player, InteractionHand pHand) {
        ItemStack SealedPrisonRealm = player.getItemInHand(pHand);

        CompoundTag nbtData = new CompoundTag();
        nbtData.putString("prisonrealm.item_uuid", player.getStringUUID());

        SealedPrisonRealm.setTag(nbtData);
    }

    public BlockState getNbtData(Player player, InteractionHand pHand) {

        return null;
    }

    public ItemStack getBlockItem(Level pLevel, BlockPos pPos, Player pPlayer) {
        String tagValue;
        tagValue = pLevel.getBlockEntity(pPos).serializeNBT().getString("prisonrealm.block_uuid");

        CompoundTag pTag = new CompoundTag();
        pTag.putString("prisonrealm.item_uuid", tagValue);

        ItemStack stack = new ItemStack(ModItems.SEALED_PRISON_REALM_ITEM.get());
        stack.setTag(pTag);
        return stack;
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {

        if(pStack.hasTag()) {
            String boundPlayer = pStack.getTag().getString("prisonrealm.item_uuid");
            if (boundPlayer != "") {
                pTooltip.add(Component.literal(boundPlayer));
            }
           // pTooltip.add(Component.translatable("tooltip.prisonrealm.bound_prison_realm.tooltip"));
            //pTooltip.add(new TextComponent(boundPlayer));
           // SealedPrisonRealmItem.setBlockEntityData();
        }


        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }


    /*
    @Override
    protected boolean updateCustomBlockEntityTag(BlockPos pPos, Level pLevel, @Nullable Player pPlayer, ItemStack pStack, BlockState pState) {
        CompoundTag addedDataTag = new CompoundTag();
        //addedDataTag.putString("prisonrealm.item_uuid", "BASED");
        //addedDataTag.putString("prisonrealm.block_uuid", "BASED");

        CompoundTag blockEntityData = getBlockEntityData(pStack);
        BlockEntity bEntity = pLevel.getBlockEntity(pPos);

        if (blockEntityData !=null) {
            pPlayer.sendSystemMessage((Component.literal("Has Block Entity Data").withStyle(ChatFormatting.DARK_RED)));
            if (bEntity != null) {
                pPlayer.sendSystemMessage((Component.literal("Has Block Entity").withStyle(ChatFormatting.DARK_RED)));
                if (pLevel.isClientSide()) {
                    pPlayer.sendSystemMessage((Component.literal("Is Clientside").withStyle(ChatFormatting.DARK_RED)));
                    return false;
                }
                CompoundTag updateTag = bEntity.saveWithoutMetadata();
                CompoundTag mergeTag = updateTag.copy();
                //updateTag.merge(addedDataTag);
                if (!updateTag.equals(mergeTag)) {
                    pPlayer.sendSystemMessage((Component.literal("Data Loaded").withStyle(ChatFormatting.DARK_RED)));
                    //bEntity.load(updateTag);
                    //bEntity.setChanged();
                    return true;
                }

            }
            return false;
        }
    return false;


        //return super.updateCustomBlockEntityTag(pPos, pLevel, pPlayer, pStack, pState);
    }
*/

    @Nullable
    @Override
    public BlockPlaceContext updatePlacementContext(BlockPlaceContext pContext) {
        //pContext.getClickedPos();
        //ItemStack blockItem = pContext.getPlayer().getItemInHand(pContext.getPlayer().getUsedItemHand());
        //blockItem.getTag().getString("prisonrealm.item_uuid");
        //pContext.getLevel().getBlockState(pContext.getClickedPos());
        return super.updatePlacementContext(pContext);
    }

    protected boolean placeBlock(BlockPlaceContext pContext, BlockState pState) {

        //SealedPrisonRealmItem.setBlockEntityData(new ItemStack(ModItems.SEALED_PRISON_REALM_ITEM.get()), ModBlockEntities.SEALED_PRISON_REALM_BLOCK_ENTITY.get() ,BOUND_UUID_TAG);
        //if (pContext.getLevel().getBlockEntity(pContext.getClickedPos()) instanceof SealedPrisonRealmBlockEntity sealedPrisonRealmBlockEntity) {
        //    sealedPrisonRealmBlockEntity.getPersistentData().putString("prisonrealm.block_uuid", getBOUND_PLAYER_UUID());
        //    sealedPrisonRealmBlockEntity.setChanged();
        //}

        /*
        CompoundTag pTag = new CompoundTag();
        pTag.putString("prisonrealm.item_uuid", getPlayerUUID());

        BlockEntity bEntity = ModBlockEntities.SEALED_PRISON_REALM_BLOCK_ENTITY.get().create(pContext.getClickedPos(),ModBlocks.SEALED_PRISON_REALM.get().defaultBlockState());

        bEntity.getPersistentData().putString("prisonrealm.block_uuid", getPlayerUUID());
        bEntity.setChanged();

        pContext.getLevel().setBlockEntity(bEntity);

         */

        setBlockEntity(pContext);
        //CompoundTag pTag = new CompoundTag();
        //pTag.putString("prisonrealm.block_uuid","beaner2");


        //pContext.getLevel().setBlock(pContext.getClickedPos(), pState, 11);

        //pContext.getLevel().getBlockEntity(pContext.getClickedPos()).saveWithoutMetadata().putString("prisonrealm.block_uuid","beaner");
        //pContext.getLevel().getBlockEntity(pContext.getClickedPos().above()).load(pTag);
        //pContext.getLevel().getBlockEntity(pContext.getClickedPos()).setChanged();

        return false;//updateCustomBlockEntityTag(pContext.getClickedPos(),pContext.getLevel(), pContext.getPlayer(), pContext.getItemInHand(),pState);

        //return pContext.getLevel().setBlock(pContext.getClickedPos(), pState, 11);
    }



    /*
    @Override
    public InteractionResult place(BlockPlaceContext pContext) {
        Level pLevel = pContext.getLevel();
        Player pPlayer = pContext.getPlayer();
        BlockPos bPos = pContext.getClickedPos();

        BlockPlaceContext newContext = n;

        CompoundTag pTag = new CompoundTag();
        pTag.putString("prisonrealm.block_uuid", getBOUND_PLAYER_UUID());

        BlockEntity bEntity = ModBlockEntities.SEALED_PRISON_REALM_BLOCK_ENTITY.get().create(bPos,ModBlocks.SEALED_PRISON_REALM.get().defaultBlockState());
        // ModBlockEntities.SEALED_PRISON_REALM_BLOCK_ENTITY.get().create(pContext.getClickedPos(),pContext.getPlayer().getBlockStateOn());

        //bEntity.getUpdateTag().putString("prisonrealm.block_uuid", getBOUND_PLAYER_UUID());
        //bEntity.handleUpdateTag(pTag);
        //bEntity.getPersistentData().putString("prisonrealm.block_uuid", getBOUND_PLAYER_UUID());
        //bEntity.load(pTag);
        //setBlockEntityData(ModItems.SEALED_PRISON_REALM_ITEM.get().getDefaultInstance(), );
        //bEntity.setChanged();

        updatePlacementContext(newContext);

        //pContext.getLevel().setBlockEntity(bEntity);

        //pLevel.set

        return super.place(pContext);
        //return InteractionResult.SUCCESS;
    }
    */

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }
}
