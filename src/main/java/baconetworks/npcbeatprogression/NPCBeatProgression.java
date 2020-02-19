package baconetworks.npcbeatprogression;

import baconetworks.npcbeatprogression.commands.CommandList;
import baconetworks.npcbeatprogression.events.AggroTrainerEvent;
import baconetworks.npcbeatprogression.events.BattleStartEvent;
import baconetworks.npcbeatprogression.events.InteractEntityEvent;
import baconetworks.npcbeatprogression.events.TrainerBeatEvent;
import com.google.inject.Inject;
import com.pixelmonmod.pixelmon.Pixelmon;
import net.minecraftforge.common.MinecraftForge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "npcbeatprogression",
        name = "NPCBeatProgression",
        description = "Beat the npcs to progress",
        dependencies = {
                @Dependency(id = "pixelmon")
        },
        version = "@VERSION@"
)
public class NPCBeatProgression {

    public static final String PLUGIN_NAME = "NPCBeatProgression";
    public static final Logger LOGGER = LoggerFactory.getLogger(PLUGIN_NAME);

    public static CommandManager commandManager = Sponge.getCommandManager();
    public static NPCBeatProgression instance;

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        Pixelmon.EVENT_BUS.register(new TrainerBeatEvent());
        Pixelmon.EVENT_BUS.register(new AggroTrainerEvent());
        Pixelmon.EVENT_BUS.register(new BattleStartEvent());
        MinecraftForge.EVENT_BUS.register(new InteractEntityEvent());
        instance = this;
        CommandList.RegisterCommands();
        logger.info("I started just fine. Running on version " + "@VERSION@" + " of NPCBeatProgression");
    }
}
