public class Paket {
    int volume = 0;
    String PLZ = "";

    public Paket(int[] size, String PLZ) {
        this.volume = getVolume(size);
        this.PLZ = PLZ;
    }

    private int getVolume(int[] size) {
        return size != null ? size[0] * size[1] * size[2] : 0;
    }

}
