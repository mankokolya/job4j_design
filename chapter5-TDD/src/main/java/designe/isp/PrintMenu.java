package designe.isp;

import designe.isp.item.Folder;
import designe.isp.item.Item;

import java.nio.file.Files;
import java.util.List;

public class PrintMenu implements Print {

    @Override
    public void print(Folder menu) {
        List<Item> items = menu.get();
        for (Item item : items) {
            String indent = "";
            if (!item.isFile()) {
                Folder folder = (Folder) item;
                List<Item> items1 = folder.get();
                System.out.println(indent + folder);
                printEverythingFromFolder(items1, indent);
            } else {
                System.out.println(item);
            }
        }
    }

    private void printEverythingFromFolder(List<Item> items1, String indent) {
        String in = "--" + indent;
        for (Item item : items1) {
            if (!item.isFile()) {
                Folder folder = (Folder) item;
                List<Item> items = folder.get();
                System.out.println(in + folder);
                printEverythingFromFolder(items, in);
            } else {
                System.out.println(in + item);
            }
        }
    }
}
