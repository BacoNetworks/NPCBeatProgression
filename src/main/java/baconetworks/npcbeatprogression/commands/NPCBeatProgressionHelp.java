package baconetworks.npcbeatprogression.commands;

import baconetworks.npcbeatprogression.methods.Pagination;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextTemplate;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import java.util.ArrayList;
import java.util.List;

public class NPCBeatProgressionHelp implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {

        if (!(src instanceof Player)) {
            throw new CommandException(Text.of(TextColors.RED, "You need to be a player to run this command"));
        }

        String[] Commands = {"/nbp mb <set/unset>", "/nbp att <set/unset>", "/nbp gym <type/remove>", "/nbp listnbt"};
        String[] CommandsSuggest = {"/nbp mb set", "/nbp att set", "/nbp gym type", "/nbp listnbt"};
        String[] Descriptions = {"Set/unset if an npc can battle multiple people at once", "Set/unset if an npc should use the baco ai that attacks all nearby players", "Add a gym type to the npc. Example : EliteFour-NPC1", "List all custom nbt data of an npc"};
        //Some definitions
        List<Text> texts = new ArrayList<>();
        //We defined the builder here
        for (int i = 0; i < Commands.length; i++) {
            texts.add(Text.builder()
                    .append(Text.builder()
                            .color(TextColors.GOLD)
                            .style(TextStyles.BOLD)
                            .append(Text.of(Commands[i]))
                            .onClick(TextActions.suggestCommand(CommandsSuggest[i]))
                            .onHover(TextActions.showText(Text.of(Descriptions[i])))
                            .build())
                    .build());
        }

        TextTemplate Title = TextTemplate.of(TextColors.RED, TextStyles.BOLD, "NPCBeatProgression");
        PaginationList paginationlist = new Pagination().getPaginationService().builder().footer(Text.of(TextColors.GRAY, TextStyles.BOLD, "Made by kristi71111")).padding(Text.of("-")).title(Title.apply().build()).contents(texts).build();
        paginationlist.sendTo(src);
        return CommandResult.success();
    }
}