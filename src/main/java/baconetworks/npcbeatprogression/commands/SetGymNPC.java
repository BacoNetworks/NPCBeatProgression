package baconetworks.npcbeatprogression.commands;

import baconetworks.npcbeatprogression.methods.Functions;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.Optional;

public class SetGymNPC implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (!(src instanceof Player)) {
            throw new CommandException(Text.of(TextColors.RED, "You need to be a player to run this command"));
        }
        Player player = (Player) src;
        //Remove him from the list before running this command fully
        CommandList.GymQue.remove(player.getUniqueId());
        CommandList.CommandQue.remove(player.getUniqueId());
        Optional<String> TypeRemove = args.getOne(Text.of("type/remove"));
        if (!(TypeRemove.isPresent())) {
            throw new CommandException(Text.of(TextColors.RED, "Usage /nbp gym <type/remove>"));
        }
        String TypeRemoveFinal = TypeRemove.get();
        if (TypeRemoveFinal.equalsIgnoreCase("remove")) {
            player.sendMessage(Text.of(TextColors.GREEN, "Right click an npc to remove it's gym"));
            CommandList.GymQue.put(player.getUniqueId(), "remove");
            return CommandResult.success();
        } else {
            String TypeRemoveFinalCheck = Functions.GetGym(TypeRemoveFinal);
            if (TypeRemoveFinalCheck != null) {
                player.sendMessage(Text.of(TextColors.GREEN, "Right click an npc to add a gym to it"));
                CommandList.GymQue.put(player.getUniqueId(), TypeRemoveFinal);
                return CommandResult.success();
            } else {
                throw new CommandException(Text.of(TextColors.RED, "Usage /nbp gym <type/unset>"));
            }
        }
    }
}
