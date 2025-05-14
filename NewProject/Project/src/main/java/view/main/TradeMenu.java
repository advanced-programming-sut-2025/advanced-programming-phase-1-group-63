package view.main;

import controller.main.TradeMenuController;
import model.App;
import model.Result;
import model.regexes.GeneralCommands;
import model.regexes.TradeMenuCommands;
import view.AppMenu;

import java.util.regex.Matcher;

public class TradeMenu implements AppMenu {
    TradeMenuController controller = new TradeMenuController();

    @Override
    public Result check(App app, String command) {
        Matcher matcher;
        if (GeneralCommands.MENU_EXIT.getMatcher(command) != null)
            return controller.menuExit(app);
        if ((matcher = TradeMenuCommands.TRADE.getMatcher(command)) != null)
            return controller.trade(app, matcher.group("username"), matcher.group("type"),
                    matcher.group("item"), matcher.group("amount"), matcher.group("price"),
                    matcher.group("targetItem"), matcher.group("targetAmount"));
        if ((matcher = TradeMenuCommands.TRADE_RESPONSE.getMatcher(command)) != null)
            return controller.tradeResponse(app, matcher.group("accepting"), matcher.group("ID"));
        if (TradeMenuCommands.SHOW_TRADE_LIST.getMatcher(command) != null)
            return controller.showTradeList(app);
        if (TradeMenuCommands.SHOW_TRADE_HISTORY.getMatcher(command) != null)
            return controller.showTradeHistory(app);
        return new Result(false, "Invalid command!");
    }
}
