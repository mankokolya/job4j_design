package designe.isp.item;


public abstract class Item {
    private final String title;
    private final boolean isFile;

    public Item(String title, boolean isFile) {
        this.title = title;
        this.isFile = isFile;
    }

    public String getTitle() {
        return title;
    }

    public boolean isFile() {
        return isFile;
    }

    @Override
    public String toString() {
        return title;
    }
}
