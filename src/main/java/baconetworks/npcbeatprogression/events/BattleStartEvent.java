package baconetworks.npcbeatprogression.events;

import baconetworks.npcbeatprogression.AITarget.TargetAllNearPlayers;
import baconetworks.npcbeatprogression.config.DataHandler;
import baconetworks.npcbeatprogression.config.objects.GymsObject;
import baconetworks.npcbeatprogression.config.objects.PlayerObject;
import baconetworks.npcbeatprogression.methods.Functions;
import com.pixelmonmod.pixelmon.AI.AITargetNearest;
import com.pixelmonmod.pixelmon.api.events.BattleStartedEvent;
import com.pixelmonmod.pixelmon.battles.BattleRegistry;
import com.pixelmonmod.pixelmon.battles.controller.BattleControllerBase;
import com.pixelmonmod.pixelmon.battles.controller.participants.BattleParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.TrainerParticipant;
import com.pixelmonmod.pixelmon.comm.SetTrainerData;
import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.LinkedHashMap;
import java.util.List;

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
            if (nbt.hasKey("BacoGymNPC")) {
                LinkedHashMap<String, PlayerObject> PlayerGyms = DataHandler.GetPlayerObject();
                Player sponge = (Player) player;
                if (PlayerGyms.containsKey(player.getUniqueID().toString())) {
                    PlayerObject PlayerObj = PlayerGyms.get(player.getUniqueID().toString());
                    List<GymsObject> GymList = PlayerObj.getGymsObjects();
                    String GymNpc = nbt.getString("BacoGymNPC");
                    String Gym = GymNpc.split("-")[0];
                    String Npc = GymNpc.split("-")[1];
                    for (GymsObject gym : GymList) {
                        if (gym.getName().equalsIgnoreCase(Gym)) {
                            if (gym.isBeatGym()) {
                                sponge.sendMessage(Text.of(TextColors.RED, "You've already beaten this gym and can't battle it again!"));
                                event.setCanceled(true);
                                return;
                            }
                            if (Npc.contains("NPC1")) {
                                if (gym.isNPC1()) {
                                    sponge.sendMessage(Text.of(TextColors.RED, "You've already beaten this trainer and can't battle it again!"));
                                    event.setCanceled(true);
                                    return;
                                }
                            }
                            if (Npc.contains("NPC2")) {
                                if (gym.isNPC2()) {
                                    sponge.sendMessage(Text.of(TextColors.RED, "You've already beaten this trainer and can't battle it again!"));
                                    event.setCanceled(true);
                                    return;
                                }
                                if (gym.getName().equalsIgnoreCase("EliteFour")) {
                                    if (!gym.isNPC1()) {
                                        sponge.sendMessage(Text.of(TextColors.RED, "You need to beat the previous trainer to battle this one!"));
                                        event.setCanceled(true);
                                        return;
                                    }
                                }
                            }
                            if (Npc.contains("NPC3")) {
                                if (gym.isNPC3()) {
                                    sponge.sendMessage(Text.of(TextColors.RED, "You've already beaten this trainer and can't battle it again!"));
                                    event.setCanceled(true);
                                    return;
                                }
                                if (gym.getName().equalsIgnoreCase("EliteFour")) {
                                    if (!gym.isNPC2()) {
                                        sponge.sendMessage(Text.of(TextColors.RED, "You need to beat the previous trainer to battle this one!"));
                                        event.setCanceled(true);
                                        return;
                                    }
                                }
                            }
                            if (Npc.contains("NPC4")) {
                                if (gym.isNPC4()) {
                                    sponge.sendMessage(Text.of(TextColors.RED, "You've already beaten this trainer and can't battle it again!"));
                                    event.setCanceled(true);
                                    return;
                                }
                                if (gym.getName().equalsIgnoreCase("EliteFour")) {
                                    if (!gym.isNPC3()) {
                                        sponge.sendMessage(Text.of(TextColors.RED, "You need to beat the previous trainer to battle this one!"));
                                        event.setCanceled(true);
                                        return;
                                    }
                                }
                            }
                            if (Npc.contains("Leader")) {
                                if (gym.getBeatNPCS() < 4) {
                                    sponge.sendMessage(Text.of(TextColors.RED, "You can't battle this trainer because you have not beaten it's underlings!"));
                                    event.setCanceled(true);
                                    return;
                                }
                                if (gym.getName().equalsIgnoreCase("EliteFour")) {
                                    if (!gym.isNPC4()) {
                                        sponge.sendMessage(Text.of(TextColors.RED, "You need to beat the previous trainer to battle the champion!"));
                                        event.setCanceled(true);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (nbt.getBoolean("MultipleBattleEnabled")) {
                {
                    //Get the name
                    String name = trainer.getName();
                    //We need to add the task since it goes missing on restarts and yeah I cry man.
                    boolean FoundTask = false;
                    EntityAIBase ai = null;
                    for (EntityAITasks.EntityAITaskEntry task : trainer.tasks.taskEntries) {
                        if (task.action instanceof TargetAllNearPlayers) {
                            FoundTask = true;
                        }
                        if (task.action instanceof AITargetNearest) {
                            ai = task.action;
                        }
                    }
                    //If the task is not found.
                    if (!FoundTask) {
                        if (ai != null) {
                            trainer.tasks.removeTask(ai);
                        }
                        trainer.tasks.addTask(5, new TargetAllNearPlayers(trainer, 5));
                    }
                    //Set the new trainer
                    final NPCTrainer trainernew = new NPCTrainer(trainer.getEntityWorld());
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
                    //Set the name again since it fails for some reason if we don't
                    trainernew.setName(name);
                    //Add pokemon to team
                    EntityPlayer finalPlayer = player;
                    trainer.getPokemonStorage().getTeam().forEach(pokemon1 -> trainernew.getPokemonStorage().addToParty(Functions.clonePokemon((EntityPixelmon) PixelmonEntityList.createEntityFromNBT(pokemon1, finalPlayer.getEntityWorld()))));
                    //Add nbt to the new trainer (Gym)
                    if (nbt.hasKey("BacoGymNPC")) {
                        trainernew.getEntityData().setString("BacoGymNPC", nbt.getString("BacoGymNPC"));
                    }
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

