package model.tools;

import model.tools.ToolException;
import model.enums.ToolTier;
import model.enums.Direction;
import model.trading.Player;

import java.util.List;

public class ToolsManager {
    private final Player player;
    private Tool current;

    public ToolsManager(Player player) { this.player = player; }

    public void equip(String toolName) throws ToolException {
        Tool t = player.findToolInInventory(toolName);
        if (t == null) throw new ToolException("Tool not found: " + toolName);
        current = t;
    }

    public String showCurrent() throws ToolException {
        if (current == null) throw new ToolException("No tool equipped");
        return current.getName();
    }

    public List<String> showAvailable() {
        return player.listInventoryTools();
    }

    public void upgrade(String toolName, ToolTier tier) throws ToolException {
        Tool t = player.findToolInInventory(toolName);
        if (t == null) throw new ToolException("Tool not found");
        t.upgrade(tier, player);
    }

    public void use(Direction dir, GameMap map) throws ToolException {
        if (current == null) throw new ToolException("No tool equipped");
        current.use(dir, player, map);
    }
}
