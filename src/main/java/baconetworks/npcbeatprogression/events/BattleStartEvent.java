package baconetworks.npcbeatprogression.events;

import baconetworks.npcbeatprogression.AITarget.TargetAllNearPlayers;
import baconetworks.npcbeatprogression.methods.CloneStuff;
import com.pixelmonmod.pixelmon.api.events.BattleStartedEvent;
import com.pixelmonmod.pixelmon.battles.BattleRegistry;
import com.pixelmonmod.pixelmon.battles.controller.BattleControllerBase;
import com.pixelmonmod.pixelmon.battles.controller.participants.BattleParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.TrainerParticipant;
import com.pixelmonmod.pixelmon.comm.SetTrainerData;
import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BattleStartEvent {
    @SubscribeEvent
    public void StartedBattleEvent(BattleStartedEvent event) {
        BattleControllerBase base = event.bc;

        EntityPlayer player = null;
        NPCTrainer trainer = null;
        BattleParticipant PlayerParticipant = null;

        for (BattleParticipant participant : base.participants) {
            if (participant.getEntity() instanceof EntityPlayer) {
                player = (EntityPlayer) participant.getEntity();
                PlayerParticipant = participant;
            }
            if (participant.getEntity() instanceof NPCTrainer) {
                trainer = (NPCTrainer) participant.getEntity();
            }
        }
        if (trainer != null && player != null) {
            final NBTTagCompound nbt = trainer.getEntityData();
            if (nbt.getBoolean("MultipleBattleEnable")) {
                {
                    //Set the new trainer
                    final NPCTrainer trainernew = new NPCTrainer(trainer.getEntityWorld());
                    //Get the name
                    String name = trainer.getName();
                    //Get the TrainerData
                    final SetTrainerData trainerdata = new SetTrainerData(name, trainer.getGreeting("en_US"), trainer.getWinMessage("en_US"), trainer.getLoseMessage("en_US"), trainer.getWinMoney(), trainer.getWinnings());
                    //Update the new trainer
                    trainernew.update(trainerdata);
                    //Set the entity data
                    trainernew.getEntityData().setString("UUID", trainer.getUniqueID().toString());
                    //Add Commands
                    trainernew.forfeitCommands.addAll(trainer.forfeitCommands);
                    trainernew.loseCommands.addAll(trainer.loseCommands);
                    trainernew.preBattleCommands.addAll(trainer.preBattleCommands);
                    trainernew.winCommands.addAll(trainer.winCommands);
                    //Add Drops
                    trainernew.updateDrops(trainer.getWinnings());
                    //Add task (FIx)
                    trainernew.targetTasks.addTask(1, new TargetAllNearPlayers(trainernew, 20, true, true));
                    //Add pokemon to team
                    EntityPlayer finalPlayer = player;
                    trainer.getPokemonStorage().getTeam().forEach(pokemon1 -> trainernew.getPokemonStorage().addToParty(CloneStuff.clonePokemon((EntityPixelmon) PixelmonEntityList.createEntityFromNBT(pokemon1, finalPlayer.getEntityWorld()))));
                    //Defined participant
                    final TrainerParticipant trainerParticipant = new TrainerParticipant(trainernew, trainer.getBattleType().numPokemon);
                    //We cancel the event and register a new battle with the new npc we set
                    event.setCanceled(true);
                    BattleRegistry.registerBattle(new BattleControllerBase(new BattleParticipant[]{PlayerParticipant}, new BattleParticipant[]{trainerParticipant}, trainer.battleRules));
                }
            }
        }
    }
}

