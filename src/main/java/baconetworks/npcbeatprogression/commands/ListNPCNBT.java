package baconetworks.npcbeatprogression.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class ListNPCNBT implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (!(src instanceof Player)) {
            throw new CommandException(Text.of(TextColors.RED, "You need to be a player to run this command"));
        }
        Player player = (Player) src;
        //Remove him from the list before running this command fully
        CommandList.CommandQue.remove(player.getUniqueId());
        player.sendMessage(Text.of(TextColors.GREEN, "Right click an npc list all of his nbt tags and values"));
        CommandList.CommandQue.put(player.getUniqueId(), "listnbt");
        return CommandResult.success();
    }
}
