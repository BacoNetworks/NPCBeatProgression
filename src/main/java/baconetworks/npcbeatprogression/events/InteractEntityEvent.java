package baconetworks.npcbeatprogression.events;

import baconetworks.npcbeatprogression.AITarget.TargetAllNearPlayers;
import baconetworks.npcbeatprogression.commands.CommandList;
import com.pixelmonmod.pixelmon.AI.AITargetNearest;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class InteractEntityEvent {
    @SubscribeEvent
    public void onInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = (Player) event.getEntityPlayer();
        if (event.getTarget() instanceof NPCTrainer) {
            NPCTrainer npc = (NPCTrainer) event.getTarget();
            if (CommandList.CommandQue.get(player.getUniqueId()) != null) {
                final NBTTagCompound nbt = npc.getEntityData();
                String choice = CommandList.CommandQue.get(player.getUniqueId());
                if (choice.equalsIgnoreCase("listnbt")) {
                    for (String s : nbt.getKeySet()) {
                        if (s.equalsIgnoreCase("SpongeData")) {
                            continue;
                        }
                        if (s.equalsIgnoreCase("BacoGymNPC")) {
                            player.sendMessage(Text.of(TextColors.DARK_PURPLE, s, ": " + nbt.getString(s)));
                        }
                        if (s.equalsIgnoreCase("MultipleBattleEnabled")) {
                            player.sendMessage(Text.of(TextColors.DARK_PURPLE, s, ": " + nbt.getBoolean(s)));
                        }
                        if (s.equalsIgnoreCase("BacoAI")) {
                            player.sendMessage(Text.of(TextColors.DARK_PURPLE, s, ": " + nbt.getBoolean(s)));
                        }
                    }
                    CommandList.CommandQue.remove(player.getUniqueId());
                }
                if (choice.equalsIgnoreCase("mbSet")) {
                    if (nbt.getBoolean("MultipleBattleEnabled")) {
                        CommandList.CommandQue.remove(player.getUniqueId());
                        player.sendMessage(Text.of(TextColors.RED, "MultipleBattle is already set on this trainer!"));
                    } else {
                        nbt.setBoolean("MultipleBattleEnabled", true);
                        CommandList.CommandQue.remove(player.getUniqueId());
                        player.sendMessage(Text.of(TextColors.GREEN, "MultipleBattle enabled on this trainer"));
                    }
                }
                if (choice.equalsIgnoreCase("mbUnset")) {
                    if (!nbt.getBoolean("MultipleBattleEnabled")) {
                        CommandList.CommandQue.remove(player.getUniqueId());
                        player.sendMessage(Text.of(TextColors.RED, "MultipleBattle is already disabled on this trainer"));
                    } else {
                        CommandList.CommandQue.remove(player.getUniqueId());
                        nbt.removeTag("MultipleBattleEnabled");
                        player.sendMessage(Text.of(TextColors.GREEN, "MultipleBattle disabled on this trainer!"));
                    }
                }
                if (choice.equalsIgnoreCase("attSet")) {
                    if (nbt.getBoolean("BacoAI")) {
                        CommandList.CommandQue.remove(player.getUniqueId());
                        player.sendMessage(Text.of(TextColors.RED, "This trainer already has the custom baco ai!"));
                    } else {
                        nbt.setBoolean("BacoAI", true);
                        npc.tasks.addTask(5, new TargetAllNearPlayers(npc, 5));
                        for (EntityAITasks.EntityAITaskEntry task : npc.tasks.taskEntries) {
                            if (task.action instanceof AITargetNearest) {
                                npc.tasks.removeTask(task.action);
                                break;
                            }
                        }
                        CommandList.CommandQue.remove(player.getUniqueId());
                        player.sendMessage(Text.of(TextColors.GREEN, "This trainer now has the custom baco ai!"));
                    }
                }
                if (choice.equalsIgnoreCase("attUnset")) {
                    if (!nbt.getBoolean("BacoAI")) {
                        CommandList.CommandQue.remove(player.getUniqueId());
                        player.sendMessage(Text.of(TextColors.RED, "This trainer already does not have the baco ai. You might have to wait for a restart to fully remove the ai properties."));
                    } else {
                        CommandList.CommandQue.remove(player.getUniqueId());
                        nbt.removeTag("BacoAI");
                        for (EntityAITasks.EntityAITaskEntry task : npc.tasks.taskEntries) {
                            if (task.action instanceof TargetAllNearPlayers) {
                                npc.tasks.removeTask(task.action);
                                break;
                            }
                        }
                        player.sendMessage(Text.of(TextColors.GREEN, "This trainer no longer has the custom baco ai!"));
                    }
                }
            } else if (CommandList.GymQue.get(player.getUniqueId()) != null) {
                final NBTTagCompound nbt = npc.getEntityData();
                String choice = CommandList.GymQue.get(player.getUniqueId());
                if (choice.equalsIgnoreCase("remove")) {
                    if (!nbt.hasKey("BacoGymNPC")) {
                        CommandList.GymQue.remove(player.getUniqueId());
                        player.sendMessage(Text.of(TextColors.RED, "This trainer is not a gym npc to begin with!"));
                    } else {
                        CommandList.GymQue.remove(player.getUniqueId());
                        nbt.removeTag("BacoGymNPC");
                        player.sendMessage(Text.of(TextColors.GREEN, "This trainer is now no longer a gym npc!"));
                    }
                } else {
                    if (nbt.hasKey("BacoGymNPC")) {
                        CommandList.GymQue.remove(player.getUniqueId());
                        player.sendMessage(Text.of(TextColors.RED, "This trainer is already a gym npc!"));
                    } else {
                        CommandList.GymQue.remove(player.getUniqueId());
                        nbt.setString("BacoGymNPC", choice);
                        player.sendMessage(Text.of(TextColors.GREEN, "This trainer is now a gym npc of " + choice));
                    }
                }
            }
        }
    }
}
