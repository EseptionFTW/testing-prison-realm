package net.eseption.prisonrealm.block.entity;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.eseption.prisonrealm.item.custom.SealedPrisonRealmItem;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SealedPrisonRealmBlockEntity extends BlockEntity {

    protected String bound_uuid = "";
    //protected String bound_uuid2;

    public SealedPrisonRealmBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.SEALED_PRISON_REALM_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    public void onLoad(CompoundTag pTag) {
        //CompoundTag pTag = new CompoundTag();
        super.onLoad();
        this.bound_uuid = pTag.getString("prisonrealm.block_uuid");

    }

    @Override
    public void setBlockState(BlockState pBlockState) {
        super.setBlockState(pBlockState);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.putString("prisonrealm.block_uuid", this.bound_uuid);
        //pTag.putString("prisonrealm.item_uuid", this.bound_uuid2);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        CompoundTag bound_uuid_data = pTag.getCompound(PrisonRealmMod.MOD_ID);
        this.bound_uuid = pTag.getString("prisonrealm.block_uuid");
        //this.bound_uuid2 = pTag.getString("prisonrealm.item_uuid");
    }


    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

    public String getBound_uuid() {
        return this.bound_uuid;
    }

    @Override
    public void saveToItem(ItemStack pStack) {
        super.saveToItem(pStack);
    }
}
