package com.besson.tutorialmod.block.custom;

import com.besson.tutorialmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class ScallionCropBlock extends CropBlock {
    public static final int FIRST_STAGE_AGE = 5;
    public static final int SECOND_STAGE_AGE = 1;
    public static final IntProperty AGE = IntProperty.of("age", 0, 6);

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)
    };

    public ScallionCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[state.get(AGE)];
    }

    @Override
    public int getMaxAge() {
        return FIRST_STAGE_AGE + SECOND_STAGE_AGE;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.SCALLION_SEEDS;
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState block = world.getBlockState(pos.down());
        return super.canPlaceAt(state, world, pos) ||
                block.isOf(this) && block.get(AGE) == 5;
    }

    @Override
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getGrowthAmount(world);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }
        BlockState upState = world.getBlockState(pos.up());
        if(upState.isOf(Blocks.AIR) && this.getAge(state)==5) {
            world.setBlockState(pos.up(), this.withAge(i), Block.NOTIFY_LISTENERS);
        } else{
            world.setBlockState(pos, this.withAge(i - 1), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBaseLightLevel(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getAvailableMoisture(this, world, pos);
                if (random.nextInt((int)(25.0F / f) + 1) == 0) {
                    if (i == FIRST_STAGE_AGE){
                        BlockState upState = world.getBlockState(pos.up());
                        if (upState.isOf(Blocks.AIR)) {
                            world.setBlockState(pos.up(), this.withAge(i + 1), Block.NOTIFY_LISTENERS);
                        }
                    }
                }
            }
        } else{
            world.setBlockState(pos, this.withAge(this.getAge(state) + 1), Block.NOTIFY_LISTENERS);
        }
    }
}
