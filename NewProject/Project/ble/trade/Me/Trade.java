package model.trade;

import model.Player;

import java.util.HashMap;
import java.util.Map;

public class Trade {
    private Player player1;
    private Player player2;
    private Map<String, Integer> player1Items;
    private Map<String, Integer> player2Items;
    private boolean isCompleted;

    public Trade(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Items = new HashMap<>();
        this.player2Items = new HashMap<>();
        this.isCompleted = false;
    }

    // Add item to the first party of the transaction
    public void addItemToPlayer1(String item, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }
        if (player1.removeItem(item, quantity)) {
            player1Items.put(item, player1Items.getOrDefault(item, 0) + quantity);
            System.out.println(quantity + " " + item + " added to " + player1.getName() + "'s side.");
        } else {
            System.out.println(player1.getName() + " does not have enough of " + item);
        }
    }

    // Add item to the second party of the transaction
    public void addItemToPlayer2(String item, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }
        if (player2.removeItem(item, quantity)) {
            player2Items.put(item, player2Items.getOrDefault(item, 0) + quantity);
            System.out.println(quantity + " " + item + " added to " + player2.getName() + "'s side.");
        } else {
            System.out.println(player2.getName() + " does not have enough of " + item);
        }
    }

    public void completeTrade() {
        if (!player1Items.isEmpty() && !player2Items.isEmpty()) {
            isCompleted = true;
            System.out.println("Trade completed between " + player1.getName() + " and " + player2.getName());
            // Transfer items
            player1Items.forEach((item, qty) -> player2.addItem(item, qty));
            player2Items.forEach((item, qty) -> player1.addItem(item, qty));
            player1Items.clear();
            player2Items.clear();
        } else {
            System.out.println("Trade cannot be completed, please add items.");
        }
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}

