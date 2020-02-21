package baconetworks.npcbeatprogression.commands;

import baconetworks.npcbeatprogression.NPCBeatProgression;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

import java.util.HashMap;
import java.util.UUID;

public class CommandList {
    public static HashMap<UUID, String> CommandQue = new HashMap<>();
    public static HashMap<UUID, String> GymQue = new HashMap<>();

    public static CommandSpec MultiBattle = CommandSpec.builder()
            .description(Text.of("Set/unset if an npc can battle multiple people at once"))
            .arguments(
                    GenericArguments.string(Text.of("set/unset"))
            )
            .executor(new SetMultipleBattle())
            .permission("npcbeatprogression.command.multibattle")
            .build();

    public static CommandSpec AttackAllAround = CommandSpec.builder()
            .description(Text.of("Set/unset if a npc has the custom ai that battles all nearby players enabled"))
            .arguments(
                    GenericArguments.string(Text.of("set/unset"))
            )
            .executor(new SetAttackAllAround())
            .permission("npcbeatprogression.command.attackall")
            .build();

    public static CommandSpec GymNPC = CommandSpec.builder()
            .description(Text.of("Set/unset if an npc is a gym npc"))
            .arguments(
                    GenericArguments.string(Text.of("type/remove"))
            )
            .executor(new SetGymNPC())
            .permission("npcbeatprogression.command.gymnpc")
            .build();

    public static CommandSpec NBTList = CommandSpec.builder()
            .description(Text.of("List the npcs nbt data"))
            .executor(new ListNPCNBT())
            .permission("npcbeatprogression.command.nbtlist")
            .build();

    public static CommandSpec NPCBeatHelp = CommandSpec.builder()
            .executor(new NPCBeatProgressionHelp())
            .permission("npcbeatprogression.command.help")
            .build();

    public static CommandSpec NPCBeatProgressionBase = CommandSpec.builder()
            .executor(new NPCBeatProgressionHelp())
            .permission("npcbeatprogression.command.help")
            .child(MultiBattle, "multibattle", "mb")
            .child(NPCBeatHelp, "help")
            .child(GymNPC, "gymnpc", "gym")
            .child(AttackAllAround, "att", "attack")
            .child(NBTList, "nbtlist", "listnbt")
            .build();

    public static void RegisterCommands() {
        final NPCBeatProgression pl = NPCBeatProgression.instance;
        Sponge.getCommandManager().register(pl, CommandList.NPCBeatProgressionBase, "nbp", "npcbeatprogression");
    }
}
