package designe.isp.item;

import designe.isp.Add;
import designe.isp.Get;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Folder extends Item implements Add, Get {

    List<Item> items;

    public Folder(String title, boolean isFile, List<Item> items) {
        super(title, isFile);
        this.items = items;
    }

    @Override
    public void addToRoot(Item item) {
        this.items.add(item);
    }

    @Override
    public boolean addToFolder(String name, Item item) {
        boolean added = false;
        Optional<Item> item2 = this.items.stream().filter(item1 -> item1.getTitle().equals(name)).findAny();
        if (item2.isPresent() && !item2.get().isFile()) {
            Folder folder = (Folder) item2.get();
            folder.addToRoot(item);
            added = true;
        }
        return added;
    }

    @Override
    public List<Item> get() {
        return Collections.unmodifiableList(this.items);
    }
}
