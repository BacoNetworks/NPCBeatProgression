package baconetworks.npcbeatprogression.config.objects.EliteFour;

public class EliteFourObject {
    private boolean NPC1;
    private boolean NPC2;
    private boolean NPC3;
    private boolean NPC4;
    private boolean BeatChampion;
    private int BeatNPCS;

    public EliteFourObject(boolean NPC1, boolean NPC2, boolean NPC3, boolean NPC4, boolean BeatChampion, int BeatNPCS) {
        this.NPC1 = NPC1;
        this.NPC2 = NPC2;
        this.NPC3 = NPC3;
        this.NPC4 = NPC4;
        this.BeatChampion = BeatChampion;
        this.BeatNPCS = BeatNPCS;
    }

    public boolean GetBeatNPC1() {
        return this.NPC1;
    }

    public boolean GetBeatNPC2() {
        return this.NPC2;
    }

    public boolean GetBeatBeatNPC3() {
        return this.NPC3;
    }

    public boolean GetBeatBeatNPC4() {
        return this.NPC4;
    }

    public boolean GetBeatChampion() {
        return this.BeatChampion;
    }

    public int GetBeatNPCS() {
        return this.BeatNPCS;
    }
}
