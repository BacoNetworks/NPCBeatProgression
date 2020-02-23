package baconetworks.npcbeatprogression.config.objects;

public class GymsObject {
    private String name;
    private boolean NPC1;
    private boolean NPC2;
    private boolean NPC3;
    private boolean NPC4;
    private boolean BeatGym;
    private int BeatNPCS;

    public GymsObject(String name, boolean NPC1, boolean NPC2, boolean NPC3, boolean NPC4, boolean beatGym, int beatNPCS) {
        this.name = name;
        this.NPC1 = NPC1;
        this.NPC2 = NPC2;
        this.NPC3 = NPC3;
        this.NPC4 = NPC4;
        BeatGym = beatGym;
        BeatNPCS = beatNPCS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNPC1() {
        return NPC1;
    }

    public void setNPC1(boolean NPC1) {
        this.NPC1 = NPC1;
    }

    public boolean isNPC2() {
        return NPC2;
    }

    public void setNPC2(boolean NPC2) {
        this.NPC2 = NPC2;
    }

    public boolean isNPC3() {
        return NPC3;
    }

    public void setNPC3(boolean NPC3) {
        this.NPC3 = NPC3;
    }

    public boolean isNPC4() {
        return NPC4;
    }

    public void setNPC4(boolean NPC4) {
        this.NPC4 = NPC4;
    }

    public boolean isBeatGym() {
        return BeatGym;
    }

    public void setBeatGym(boolean beatGym) {
        BeatGym = beatGym;
    }

    public int getBeatNPCS() {
        return BeatNPCS;
    }

    public void setBeatNPCS(int beatNPCS) {
        BeatNPCS = beatNPCS;
    }

    public void increaseBeatNPCS(int num) {
        this.BeatNPCS += num;
    }
}
