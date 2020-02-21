package baconetworks.npcbeatprogression.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.Optional;

public class SetAttackAllAround implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (!(src instanceof Player)) {
            throw new CommandException(Text.of(TextColors.RED, "You need to be a player to run this command"));
        }
        Player player = (Player) src;
        //Remove him from the list before running this command fully
        CommandList.CommandQue.remove(player.getUniqueId());
        Optional<String> SetOrRemove = args.getOne(Text.of("set/unset"));
        if (!(SetOrRemove.isPresent())) {
            throw new CommandException(Text.of(TextColors.RED, "Usage /nbp att <set/unset>"));
        }
        String SetOrRemoveFin = SetOrRemove.get();
        if (SetOrRemoveFin.equalsIgnoreCase("set")) {
            player.sendMessage(Text.of(TextColors.GREEN, "Right click an npc to enable the custom ai that battles all nearby players!"));
            CommandList.CommandQue.put(player.getUniqueId(), "attSet");
            return CommandResult.success();
        }
        if (SetOrRemoveFin.equalsIgnoreCase("unset")) {
            player.sendMessage(Text.of(TextColors.GREEN, "Right click an npc to disable the custom ai that battles all nearby players!"));
            CommandList.CommandQue.put(player.getUniqueId(), "attUnset");
            return CommandResult.success();
        } else {
            throw new CommandException(Text.of(TextColors.RED, "Usage /nbp att <set/unset>"));
        }
    }
}
