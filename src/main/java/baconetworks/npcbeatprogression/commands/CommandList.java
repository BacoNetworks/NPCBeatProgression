package baconetworks.npcbeatprogression.commands;

import baconetworks.npcbeatprogression.NPCBeatProgression;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class CommandList {
    public static CommandSpec SetMultipleBattle = CommandSpec.builder()
            .description(Text.of("Set if the npc should battle multiple people at once"))
            .arguments(
                    GenericArguments.string(Text.of("setoremove"))
            )
            .executor(new SetMultipleBattle())
            .permission("npcbeatprogression.setmultiplebattle")
            .build();
    public static void RegisterCommands() {
        final NPCBeatProgression pl = NPCBeatProgression.instance;
        Sponge.getCommandManager().register(pl, CommandList.SetMultipleBattle, "multiplebattle");
    }
}
