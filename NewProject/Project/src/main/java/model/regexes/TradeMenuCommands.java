package model.regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum TradeMenuCommands implements Command {
    BUY_TRADE("trade -u (?<username>\\S+) -t (?<type>offer|request) -i (?<item>.+) -a (?<amount>\\d+) -p (?<price>\\d+)"),
    EXCHANGE_TRADE("trade -u (?<username>\\S+) -t (?<type>offer|request) -i (?<item>.+) -a (?<amount>\\d+) -i (?<targetItem>.+) -ta (?<targetAmount>\\d+)"),
    SHOW_TRADE_LIST("trade list"),
    TRADE_RESPONSE("trade response (?<accepting>–accept|–reject) -i (?<ID>\\d+)"),
    SHOW_TRADE_HISTORY("trade history");

    private final String regex;

    TradeMenuCommands(String regex) {
        this.regex = regex;
    }

    @Override
    public Matcher getMatcher (String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches())
            return matcher;
        return null;
    }
}
