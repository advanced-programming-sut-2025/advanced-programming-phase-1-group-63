package model.regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMainMenuCommands implements Command {
    EXIT_GAME("exit game"),
    DELETE_GAME("delete game"),
    NEXT_TURN("next turn"),
    SHOW_TIME("time"),
    SHOW_DATE("date"),
    SHOW_DATE_TIME("datetime"),
    SHOW_DAY_OF_THE_WEEK("day of the week"),
    SHOW_SEASON("season"),
    SHOW_WEATHER("weather"),
    SHOW_TOMORROW_WEATHER("weather forecast"),
    GREENHOUSE_BUILD("greenhouse build"),
    WALK("walk -l \\((?<x>\\d+), (?<y>\\d+)\\)"),
    PRINT_MAP("print map -l \\((?<x>\\d+), (?<y>\\d+)\\) -s (?<size>\\d+)"),
    HELP_READ_MAP("help reading map"),
    SHOW_ENERGY("energy show"),
    SHOW_INVENTORY("inventory show"),
    DELETE_INVENTORY_ITEM("inventory trash -i (?<itemName>\\S+) -n (?<number>\\S+)"),
    TOOLS_EQUIP("tools equip (?<toolName>\\S+)"),
    CHOW_CURRENT_TOOL("tools show current"),
    SHOW_TOOLS_LIST("tools show available"),
    UPGRADE_TOOL("tools upgrade (?<toolName>\\S+)"),
    USE_TOOL("tool use -d (?<direction>\\S+)"),
    SHOW_CRAFT_INFO("craftinfo -n (?<craftName>\\S+)"),
    PLANT("plant -s (?<seed>\\S+) -d (?<direction>\\S+)"),
    SHOW_PLANT("show plant -l \\((?<x>\\d+), (?<y>\\d+)\\)"),
    FERTILIZE("-f (?<fertilizer>\\S+) -d (?<direction>\\S+)"),
    SHOW_WATER("howmuch water"),
    SHOW_CRAFT_RECIPES("crafting show recipes"),
    CRAFTING("crafting craft (?<itemName>\\S+)"),
    PLACE_ITEM("place item -n (?<itemName>\\S+) -d (?<direction>\\S+)"),
    PUT_REFRIGERATOR("cooking refrigerator put (?<item>\\S+)"),
    PICK_REFRIGERATOR("cooking refrigerator pick (?<item>\\S+)"),
    SHOW_COOK_RECIPES("cook show recipes"),
    PREPARE_COOKING("cooking prepare (?<recipeName>\\S+)"),
    EAT("eat (?<foodName>\\S+)"),
    BUILD("build -a (?<name>\\S+) -l \\((?<x>\\d+), (?<y>\\d+)\\)"),
    BUY_ANIMAL("buy animal -a (?<animal>\\S+) -n (?<name>\\S+)"),
    PET("pet -n (?<name>\\S+)"),
    SHOW_ANIMALS("animals"),
    SHEPHERD_ANIMAL("shepherd animals -n (?<name>\\S+) -l \\((?<x>\\d+), (?<y>\\d+)\\)"),
    FEED_HAY("feed hay -n (?<name>\\S+)"),
    SHOW_PRODUCES("produces"),
    COLLECT_PRODUCE("collect produce -n (?<name>\\S+)"),
    SELL_ANIMAL("sell animal -n (?<name>\\S+)"),
    FISHING("fishing -p (?<pole>\\S+)"),
    ARTISAN_USE("artisan use -A (?<artisanName>.+) -I (?<itemName>.+)"),
    ARTISAN_GET("artisan get -A (?<artisanName>.+)"),
    START_BUY("start buy"),
    SELL_PRODUCT("sell (?<productName>.+)( -n (?<count>\\d+))?"),
    SHOW_FRIENDSHIPS("friendships"),
    TALK("talk -u (?<username>\\S+) -m (<message>.+)"),
    TALK_HISTORY("talk history -u (?<username>\\S+)"),
    GIFT("gift -u (?<username>\\S+) -i (?<item>.+) -a (<amount>\\d+)"),
    SHOW_GIFT_LIST("gift list"),
    GIFT_RATE("gift rate -i (?<giftID>\\d+) -r (?<rate>\\d+)"),
    GIFT_HISTORY("gift history -u (?<username>\\S+)"),
    HUG("hug -u (?<username>\\S+)"),
    FLOWER("flower -u (?<username>\\S+)"),
    ASK_MARRIAGE("ask marriage -u (?<username>\\S+) -r (?<ring>.+)"),
    RESPOND_MARRIAGE("respond (?<accepting>–accept|–reject) -u (?<username>\\S+)"),
    MEET_NPC("meet NPC (?<name>\\S+)"),
    GIFT_NPC("gift NPC (?<name>\\S+) -i (?<item>\\S+)"),
    SHOW_NPC_FRIENDSHIP("friendship NPC list"),
    SHOW_QUESTS_LIST("quests list"),
    FINISH_QUEST("quests finish -i (?<index>\\d+)"),
    CHEAT_TIME("cheat advance time (?<hour>\\d+)h"),
    CHEAT_DATE("cheat advance date (?<day>\\d+)d"),
    CHEAT_THOR("cheat Thor -l \\((?<x>\\d+), (?<y>\\d+)\\)"),
    CHEAT_WEATHER("cheat weather set (?<type>\\S+)"),
    CHEAT_ENERGY("energy set -v (?<value>\\d+)"),
    CHEAT_ENERGY_LIMIT("energy unlimited"),
    CHEAT_ITEM("cheat add item -n (?<itemName>\\S+) -c (?<count>\\d+)"),
    CHEAT_ANIMAL_FRIENDSHIP("cheat set friendship -n (?<animalName>\\S+) -c (?<amount>\\S+)"),
    CHEAT_BALANCE("cheat add (?<count>\\d+) dollars");

    private final String regex;

    GameMainMenuCommands(String regex) {
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
