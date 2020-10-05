package design.lsp;

import design.lsp.products.Bread;
import design.lsp.products.Food;
import design.lsp.products.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        Food bread = new Bread("White Bread", LocalDate.now().plusDays(2), LocalDate.now().minusDays(5), 25);
        Food meat = new Meat("Pork Fillet", LocalDate.now().plusDays(5), LocalDate.now().minusDays(4), 120);
        List<Food> foods = new ArrayList<>();
        foods.add(bread);
        foods.add(meat);

        ControlQuality quality = new ControlQuality();
        quality.controlFood(foods);
    }
}
