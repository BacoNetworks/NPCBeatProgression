package baconetworks.npcbeatprogression.commands;

import com.flowpowered.math.vector.Vector3d;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.blockray.BlockRay;
import org.spongepowered.api.util.blockray.BlockRayHit;
import org.spongepowered.api.world.World;

import java.util.Collection;
import java.util.Optional;

public class SetMultipleBattle implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (!(src instanceof Player)) {
            throw new CommandException(Text.of(TextColors.RED, "You need to be a player to run this command"));
        }
        Player player = (Player) src;
        Optional<String> SetOrRemove = args.getOne(Text.of("setoremove"));
        if (!(SetOrRemove.isPresent())) {
            throw new CommandException(Text.of(TextColors.RED, "Usage /multiplebattle <set/remove>"));
        }
        String SetOrRemoveFin = SetOrRemove.get();
        Optional<BlockRayHit<World>> optHit = BlockRay.from(player).skipFilter(BlockRay.onlyAirFilter()).build().end();
        if (optHit.isPresent()) {
            Vector3d lookPos = optHit.get().getBlockPosition().toDouble();
            Collection<Entity> entities = player.getWorld().getEntities(entity -> entity != player && entity.getLocation().getPosition().distanceSquared(lookPos) < 4);
            for (Entity entity : entities) {
                if (entity instanceof NPCTrainer) {
                    final NPCTrainer trainer = (NPCTrainer) entity;
                    final NBTTagCompound nbt = trainer.getEntityData();
                    if (SetOrRemoveFin.equalsIgnoreCase("set")) {
                        if (nbt.getBoolean("MultipleBattleEnable")) {
                            throw new CommandException(Text.of(TextColors.RED, "NBT already set on this trainer!"));
                        }
                        nbt.setBoolean("MultipleBattleEnable", true);
                        player.sendMessage(Text.of(TextColors.GREEN, "MultipleBattle enabled on this trainer"));
                        return CommandResult.success();
                    }
                    if (SetOrRemoveFin.equalsIgnoreCase("remove")) {
                        nbt.removeTag("MultipleBattleEnable");
                        player.sendMessage(Text.of(TextColors.GREEN, "MultipleBattle disabled on this trainer"));
                        return CommandResult.success();
                    }
                }else{
                    throw new CommandException(Text.of(TextColors.RED, "You must be looking at a trainer!"));
                }
            }
        }
        return CommandResult.success();
    }
}
