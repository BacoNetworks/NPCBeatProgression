package baconetworks.npcbeatprogression.events;

import com.pixelmonmod.pixelmon.api.events.AggressionEvent;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.entity.living.player.Player;

public class AggroTrainerEvent {
    @SubscribeEvent
    public void AgroPlayerEvent(AggressionEvent event) {
        if (event.aggressor instanceof NPCTrainer) {
            NPCTrainer trainer = (NPCTrainer) event.aggressor;
            if (trainer.getName().contains("[GYM]")) {
                Player player = (Player) event.player;
                String trainerName = trainer.getName();
                trainerName = trainerName.replaceAll(" ", "_");
                if (player.hasPermission("npcbeatprogression." + trainerName)) {
                    event.setCanceled(true);
                }
            }
        }
    }
}
