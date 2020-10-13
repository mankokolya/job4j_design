package designe.isp;

import designe.isp.item.Item;

public interface Add {
    void addToRoot(Item item);
    boolean addToFolder(String name, Item item);
}
