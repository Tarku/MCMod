package net.tarkstudios.mcmod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FrenzyBlock extends Block {
    public FrenzyBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(SPECIAL, 0));
    }
    public static final IntProperty SPECIAL = IntProperty.of("special", 0, 2);
    public static final FrenzyBlock FRENZY_BLOCK = new FrenzyBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f));

    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        if(!world.isClient)
        {
            player.sendMessage(Text.of("Added 1 to special"), false);

            if(world.getBlockState(pos).get(SPECIAL) < 2)
            {
                world.setBlockState(pos, blockState.with(SPECIAL, world.getBlockState(pos).get(SPECIAL) + 1));
            } else {
                world.setBlockState(pos, blockState.with(SPECIAL, 0));
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(SPECIAL);
    }
}
