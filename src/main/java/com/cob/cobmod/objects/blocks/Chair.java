package com.cob.cobmod.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class Chair extends Block
{
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(3, 3, 5, 4, 8, 13),
			Block.makeCuboidShape(2, 8, 4, 4, 9, 13),
			Block.makeCuboidShape(12, 8, 4, 14, 9, 13),
			Block.makeCuboidShape(12, 3, 5, 13, 8, 13),
			Block.makeCuboidShape(4, 3, 5, 12, 5, 12),
			Block.makeCuboidShape(5, 1, 4, 11, 5, 5),
			Block.makeCuboidShape(7, 1, 8, 9, 3, 10),
			Block.makeCuboidShape(6, 0, 7, 10, 1, 11),
			Block.makeCuboidShape(4, 3, 12, 12, 14, 13),
			Block.makeCuboidShape(5, 10, 11, 11, 13, 12)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(4.5, 3, 12.5, 12.5, 8, 13.5),
			Block.makeCuboidShape(3.5, 8, 12.5, 12.5, 9, 14.5),
			Block.makeCuboidShape(3.5, 8, 2.5, 12.5, 9, 4.5),
			Block.makeCuboidShape(4.5, 3, 3.5, 12.5, 8, 4.5),
			Block.makeCuboidShape(4.5, 3, 4.5, 11.5, 5, 12.5),
			Block.makeCuboidShape(3.5, 1, 5.5, 4.5, 5, 11.5),
			Block.makeCuboidShape(7.5, 1, 7.5, 9.5, 3, 9.5),
			Block.makeCuboidShape(6.5, 0, 6.5, 10.5, 1, 10.5),
			Block.makeCuboidShape(11.5, 3, 4.5, 12.5, 14, 12.5),
			Block.makeCuboidShape(10.5, 10, 5.5, 11.5, 13, 11.5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(12.5, 3, 4.5, 13.5, 8, 12.5),
			Block.makeCuboidShape(12.5, 8, 4.5, 14.5, 9, 13.5),
			Block.makeCuboidShape(2.5, 8, 4.5, 4.5, 9, 13.5),
			Block.makeCuboidShape(3.5, 3, 4.5, 4.5, 8, 12.5),
			Block.makeCuboidShape(4.5, 3, 5.5, 12.5, 5, 12.5),
			Block.makeCuboidShape(5.5, 1, 12.5, 11.5, 5, 13.5),
			Block.makeCuboidShape(7.5, 1, 7.5, 9.5, 3, 9.5),
			Block.makeCuboidShape(6.5, 0, 6.5, 10.5, 1, 10.5),
			Block.makeCuboidShape(4.5, 3, 4.5, 12.5, 14, 5.5),
			Block.makeCuboidShape(5.5, 10, 5.5, 11.5, 13, 6.5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(4.5, 3, 2.5, 12.5, 8, 3.5),
			Block.makeCuboidShape(4.5, 8, 1.5, 13.5, 9, 3.5),
			Block.makeCuboidShape(4.5, 8, 11.5, 13.5, 9, 13.5),
			Block.makeCuboidShape(4.5, 3, 11.5, 12.5, 8, 12.5),
			Block.makeCuboidShape(5.5, 3, 3.5, 12.5, 5, 11.5),
			Block.makeCuboidShape(12.5, 1, 4.5, 13.5, 5, 10.5),
			Block.makeCuboidShape(7.5, 1, 6.5, 9.5, 3, 8.5),
			Block.makeCuboidShape(6.5, 0, 5.5, 10.5, 1, 9.5),
			Block.makeCuboidShape(4.5, 3, 3.5, 5.5, 14, 11.5),
			Block.makeCuboidShape(5.5, 10, 4.5, 6.5, 13, 10.5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public Chair(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch(state.get(FACING)) 
		{
			case NORTH:
				return SHAPE_N;
			case SOUTH:
				return SHAPE_S;
			case EAST:
				return SHAPE_E;
			case WEST:
				return SHAPE_W;
			default:
				return SHAPE_N;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) 
	{
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) 
	{
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) 
	{
		builder.add(FACING);
	}
}
