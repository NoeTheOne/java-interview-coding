package by.andd3dfx.queue;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Queue {

    private Item head;

    public Item revertUsingAdditionalArray() {
        List<Item> items = new ArrayList<Item>();

        Item current = head;
        while (current != null) {
            items.add(current);
            current = current.getNext();
        }

        for (int i = items.size() - 1; i > 0; i--) {
            items.get(i).setNext(items.get(i - 1));
        }
        items.get(0).setNext(null);
        return items.get(items.size() - 1);
    }

    public Item revertUsingRecursion() {
        return swapLinks(null, head);
    }

    private Item swapLinks(Item item1, Item item2) {
        if (item2 == null) return item1;

        Item next = item2.getNext();
        item2.setNext(item1);
        return swapLinks(item2, next);
    }
}
