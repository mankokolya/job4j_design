package designe.isp;

import designe.isp.item.Folder;
import designe.isp.item.Item;

import java.util.List;

public class PrintMenu implements Print {

    @Override
    public void print(Folder menu) {
        List<Item> items = menu.get();
        for (Item item : items) {
            if (!item.isFile()) {
                Folder folder = (Folder) item;
                List<Item> items1 = folder.get();
                for (Item item1 : items1) {
                    System.out.println(item1);
                }
            }
            System.out.println(item);
        }
    }
}
