package baconetworks.npcbeatprogression.AITarget;

import baconetworks.npcbeatprogression.NPCBeatProgression;
import com.pixelmonmod.pixelmon.AI.AITarget;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;


public class TargetAllNearPlayers extends AITarget {
    EntityLivingBase targetEntity;

    public TargetAllNearPlayers(EntityCreature entity, float par3, boolean par5, boolean par6) {
        super(entity, par3, par5, par6);
        this.targetDistance = par3;
        this.taskOwner = entity;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        NPCBeatProgression.LOGGER.info("Test" + "\n");
        if (!(this.taskOwner instanceof NPCTrainer)) {
            return false;
        }
        List<EntityPlayer> nearEntities = this.taskOwner.world.getEntitiesWithinAABB(EntityPlayer.class, this.taskOwner.getCollisionBoundingBox().expand(this.targetDistance, 5.0, this.targetDistance));
        for (EntityPlayer entity : nearEntities) {
            if (entity != null) {
                NPCBeatProgression.LOGGER.info(entity.getName() + "\n");
                this.targetEntity = entity;
                return true;
            }
            return false;
        }
        return false;
    }


    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.targetEntity);
        super.startExecuting();
    }
}


