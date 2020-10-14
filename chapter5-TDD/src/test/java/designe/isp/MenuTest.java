package designe.isp;

import designe.isp.item.File;
import designe.isp.item.Folder;
import designe.isp.item.Item;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void createMenu() {
        Item menu = new Folder("Menu:", false, new ArrayList<>());
    }

    @Test
    public void menuAddFile() {
        Folder menu = new Folder("Menu:", false, new ArrayList<>());
        File file = new File("bornToFish.txt", true);
        menu.addToRoot(file);
        assertTrue(menu.get().contains(file));
    }

    @Test
    public void menuAddFolder() {
        Folder menu = new Folder("Menu:", false, new ArrayList<>());
        Folder title1 = new Folder("title", false, new ArrayList<>());
        menu.addToRoot(title1);
        assertTrue(menu.get().contains(title1));
    }

    @Test
    public void addFileToFolder() {
        Folder menu = new Folder("Menu:", false, new ArrayList<>());
        Folder title1 = new Folder("title", false, new ArrayList<>());
        File file = new File("bornToFish.txt", true);
        menu.addToRoot(title1);
        assertTrue(menu.addToFolder("title", file));
    }

    @Test
    public void testPrint() {
        Folder menu = new Folder("Menu:", false, new ArrayList<>());
        Folder title1 = new Folder("title1", false, new ArrayList<>());
        File file = new File("bornToFish.txt", true);

        Folder title2 = new Folder("title2", false, new ArrayList<>());
        Folder title21 = new Folder("title2.1", false, new ArrayList<>());
        File file2 = new File("helloWorld.txt", true);
        File file21 = new File("hello.txt", true);

        menu.addToRoot(title1);
        assertTrue(menu.addToFolder("title1", file));
        menu.addToRoot(title2);

        menu.addToFolder("title2", file2);
        menu.addToFolder("title2", title21);

        assertTrue(menu.addToFolder("title2.1", file21));
        PrintMenu printMenu = new PrintMenu();
        printMenu.print(menu);
    }
}