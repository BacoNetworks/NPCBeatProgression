package baconetworks.npcbeatprogression.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class SetMultipleBattle implements CommandExecutor {
    public static HashMap<UUID, String> CommandQue = new HashMap<>();

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
        if (SetOrRemoveFin.equalsIgnoreCase("set")) {
            player.sendMessage(Text.of(TextColors.GREEN, "Right click an npc to enable multibattle support"));
            CommandQue.put(player.getUniqueId(), "set");
        }
        if (SetOrRemoveFin.equalsIgnoreCase("remove")) {
            player.sendMessage(Text.of(TextColors.GREEN, "Right click an npc to disable multibattle support"));
            CommandQue.put(player.getUniqueId(), "remove");
        }
        return CommandResult.success();
    }
}
