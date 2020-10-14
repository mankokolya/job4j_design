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
        Optional<Item> folder = findFolder(name, this.items);
        if (folder.isPresent()) {
            Folder root = (Folder) folder.get();
            root.addToRoot(item);
            added = true;
        }
        return added;
    }

    private Optional<Item> findFolder(String name, List<Item> items) {
        Optional<Item> folder = Optional.empty();
        for (Item item : items) {
            if (item.getTitle().equals(name)) {
                return Optional.of(item);
            }
            if (!item.isFile()) {
                findFolder(name, ((Folder) item).get());
            }
        }
        return folder;
    }

    @Override
    public List<Item> get() {
        return Collections.unmodifiableList(this.items);
    }
}
