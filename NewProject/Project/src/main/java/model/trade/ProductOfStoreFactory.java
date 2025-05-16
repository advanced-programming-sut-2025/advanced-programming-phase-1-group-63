package model.trade;

import java.util.Set;

public class ProductOfStoreFactory {
    public static Object createAll() {
        return Set.of(
                // Stock
                new Stock("Copper Ore",
                        "A common ore that can be smelted into bars.",
                        75, DayLimit.unlimited),
                new Stock("Iron Ore",
                        "A fairly common ore that can be smelted into bars."
                        , 150, DayLimit.unlimited),
                new Stock("Coal",
                        "A combustible rock that is useful for crafting and smelting.",
                        150, DayLimit.unlimited),
                new Stock("Gold Ore",
                        "A precious ore that can be smelted into bars.",
                        400, DayLimit.unlimited),
                // Upgrade Tools
                new UpgradeTool("Copper Tool",
                        "Copper Bar (5)",
                        2000, 1),
                new UpgradeTool("Steel Tool",
                        "Iron Bar (5)",
                        5000, 1),
                new UpgradeTool("Gold Tool",
                        "Gold Bar (5)",
                        10000, 1), // limited = one day!!!
                new UpgradeTool("Iridium Tool",
                        "Iridium Bar (5)",
                        25000, 1),
                new UpgradeTool("Copper Trash Can",
                        "Iridium Bar (5)",
                        25000, 1),
                new UpgradeTool("Copper Trash Can",
                        "Copper Bar (5)",
                        1000, 1),
                new UpgradeTool("Steel Trash Can",
                        "Iron Bar (5)",
                        2500, 1),
                new UpgradeTool("Gold Trash Can",
                        "Gold Bar (5)",
                        5000, 1),
                new UpgradeTool("Iridium Trash Can",
                        "Iridium Bar (5)",
                        12500, 1)
        );

    }
}
