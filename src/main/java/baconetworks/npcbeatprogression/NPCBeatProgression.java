package baconetworks.npcbeatprogression;

import baconetworks.npcbeatprogression.commands.CommandList;
import baconetworks.npcbeatprogression.config.ConfigLoader;
import baconetworks.npcbeatprogression.events.*;
import com.google.inject.Inject;
import com.pixelmonmod.pixelmon.Pixelmon;
import net.minecraftforge.common.MinecraftForge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;

import java.io.File;

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

    //Inject the config dir
    @Inject
    @ConfigDir(sharedRoot = true)
    public File defaultConfigDir;

    @Inject
    private Game game;

    @Inject
    private Logger logger;

    public Game getGame() {
        return this.game;
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        Pixelmon.EVENT_BUS.register(new TrainerBeatEvent());
        Pixelmon.EVENT_BUS.register(new AggroTrainerEvent());
        Pixelmon.EVENT_BUS.register(new BattleStartEvent());
        MinecraftForge.EVENT_BUS.register(new InteractEntityEvent());
        MinecraftForge.EVENT_BUS.register(new PlayerConnectionEvent());
        instance = this;
        CommandList.RegisterCommands();
        logger.info("I started just fine. Running on version " + "@VERSION@" + " of NPCBeatProgression");
    }

    @Listener
    public void onPreInit(GamePreInitializationEvent event) {
        File rootDir = new File(defaultConfigDir, "NPCBeatProgression");
        ConfigLoader.init(rootDir);
        ConfigLoader.load();
        ConfigLoader.loadPlayers();
    }
}
