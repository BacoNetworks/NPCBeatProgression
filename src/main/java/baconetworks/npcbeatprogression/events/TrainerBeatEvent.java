package baconetworks.npcbeatprogression.events;

import com.pixelmonmod.pixelmon.api.events.BeatTrainerEvent;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;

import static baconetworks.npcbeatprogression.NPCBeatProgression.commandManager;

public class TrainerBeatEvent {
    @SubscribeEvent
    public void BeatTrainerEvent(BeatTrainerEvent event) {
        NPCTrainer trainer = event.trainer;
        Player player = (Player) event.player;
        if (trainer.getName().contains("[GYM]")) {
            String trainerName = trainer.getName();
            trainerName = trainerName.replaceAll(" ", "_");
            if ((!player.hasPermission("npcbeatprogression." + trainerName))) {
                commandManager.process(Sponge.getServer().getConsole(), "lp user " + player.getUniqueId() + " permission set npcbeatprogression." + trainerName + " pixelgen");
            }
        }
    }
}
