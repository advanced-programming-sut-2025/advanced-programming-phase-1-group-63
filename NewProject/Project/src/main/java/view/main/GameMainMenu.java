package view.main;

import controller.main.GameMainMenuController;
import model.App;
import model.Result;
import model.regexes.GameMainMenuCommands;
import view.AppMenu;

import java.util.regex.Matcher;

public class GameMainMenu implements AppMenu {
    GameMainMenuController controller = new GameMainMenuController();

    @Override
    public Result check(App app, String command) {
        Result result;
        if ((result = checkPrimaryLogic(app, command)) != null)
            return result;
        if ((result = checkMapEnergy(app, command)) != null)
            return result;
        if ((result = checkDateTimeWeather(app, command)) != null)
            return result;
        if ((result = checkTool(app, command)) != null)
            return result;
        if ((result = checkFarming(app, command)) != null)
            return result;
        if ((result = checkCraftCookArtisan(app, command)) != null)
            return result;
        if ((result = checkBuySell(app, command)) != null)
            return result;
        if ((result = checkAnimalFish(app, command)) != null)
            return result;
        if ((result = checkInteraction(app, command)) != null)
            return result;
        if ((result = checkNPC(app, command)) != null)
            return result;
        if ((result = checkCheatCode(app, command)) != null)
            return result;
        return new Result(false, "invalid command");
    }
    private Result checkPrimaryLogic(App app, String command) {
        if (GameMainMenuCommands.EXIT_GAME.getMatcher(command) != null)
            return controller.exitGame(app);
        if (GameMainMenuCommands.DELETE_GAME.getMatcher(command) != null)
            return controller.deleteGame(app);
        if (GameMainMenuCommands.NEXT_TURN.getMatcher(command) != null)
            return controller.nextTurn(app);
        return null;
    }
    private Result checkMapEnergy(App app, String command) {
        Matcher matcher;
        if ((matcher = GameMainMenuCommands.WALK.getMatcher(command)) != null)
            return controller.walk(app, matcher.group("x"), matcher.group("y"));
        if ((matcher = GameMainMenuCommands.PRINT_MAP.getMatcher(command)) != null)
            return controller.printMap(app, matcher.group("x"), matcher.group("y"), matcher.group("size"));
        if (GameMainMenuCommands.HELP_READ_MAP.getMatcher(command) != null)
            return controller.helpReadMap(app);
        if (GameMainMenuCommands.SHOW_ENERGY.getMatcher(command) != null)
            return controller.showEnergy(app);
        return null;
    }
    private Result checkDateTimeWeather(App app, String command) {
        if (GameMainMenuCommands.SHOW_TIME.getMatcher(command) != null)
            return controller.showTime(app);
        if (GameMainMenuCommands.SHOW_DATE.getMatcher(command) != null)
            return controller.showDate(app);
        if (GameMainMenuCommands.SHOW_DATE_TIME.getMatcher(command) != null)
            return controller.showDateTime(app);
        if (GameMainMenuCommands.SHOW_DAY_OF_THE_WEEK.getMatcher(command) != null)
            return controller.showWeekDay(app);
        if (GameMainMenuCommands.SHOW_SEASON.getMatcher(command) != null)
            return controller.showSeason(app);
        if (GameMainMenuCommands.SHOW_WEATHER.getMatcher(command) != null)
            return controller.showWeather(app);
        if (GameMainMenuCommands.SHOW_TOMORROW_WEATHER.getMatcher(command) != null)
            return controller.showTomorrowWeather(app);
        if (GameMainMenuCommands.GREENHOUSE_BUILD.getMatcher(command) != null)
            return controller.greenhouseBuild(app);
        return null;
    }
    private Result checkTool(App app, String command) {
        Matcher matcher;
        if (GameMainMenuCommands.SHOW_INVENTORY.getMatcher(command) != null)
            return controller.showInventory(app);
        if ((matcher = GameMainMenuCommands.DELETE_INVENTORY_ITEM.getMatcher(command)) != null)
            return controller.deleteInventoryItem(app, matcher.group("itemName"), matcher.group("number"));
        if ((matcher = GameMainMenuCommands.TOOLS_EQUIP.getMatcher(command)) != null)
            return controller.toolsEquip(app, matcher.group("toolName"));
        if (GameMainMenuCommands.CHOW_CURRENT_TOOL.getMatcher(command) != null)
            return controller.showCurrentTool(app);
        if (GameMainMenuCommands.SHOW_TOOLS_LIST.getMatcher(command) != null)
            return controller.showToolsList(app);
        if ((matcher = GameMainMenuCommands.UPGRADE_TOOL.getMatcher(command)) != null)
            return controller.upgradeTool(app, matcher.group("toolName"));
        if ((matcher = GameMainMenuCommands.USE_TOOL.getMatcher(command)) != null)
            return controller.useTool(app, matcher.group("direction"));
        return null;
    }
    private Result checkFarming(App app, String command) {
        Matcher matcher;
        if ((matcher = GameMainMenuCommands.SHOW_CRAFT_INFO.getMatcher(command)) != null)
            return controller.showCraftInfo(app, matcher.group("craftName"));
        if ((matcher = GameMainMenuCommands.PLANT.getMatcher(command)) != null)
            return controller.plant(app, matcher.group("seed"), matcher.group("direction"));
        if ((matcher = GameMainMenuCommands.SHOW_PLANT.getMatcher(command)) != null)
            return controller.showPlant(app, matcher.group("x"), matcher.group("y"));
        if ((matcher = GameMainMenuCommands.FERTILIZE.getMatcher(command)) != null)
            return controller.fertilize(app, matcher.group("fertilizer"), matcher.group("direction"));
        if (GameMainMenuCommands.SHOW_WATER.getMatcher(command) != null)
            return controller.showWater(app);
        return null;
    }
    private Result checkCraftCookArtisan(App app, String command) {
        Matcher matcher;
        if (GameMainMenuCommands.SHOW_CRAFT_RECIPES.getMatcher(command) != null)
            return controller.showCraftRecipes(app);
        if ((matcher = GameMainMenuCommands.CRAFTING.getMatcher(command)) != null)
            return controller.crafting(app, matcher.group("itemName"));
        if ((matcher = GameMainMenuCommands.PLACE_ITEM.getMatcher(command)) != null)
            return controller.placeItem(app, matcher.group("itemName"), matcher.group("direction"));
        if ((matcher = GameMainMenuCommands.PUT_REFRIGERATOR.getMatcher(command)) != null)
            return controller.putRefrigerator(app, matcher.group("item"));
        if ((matcher = GameMainMenuCommands.PICK_REFRIGERATOR.getMatcher(command)) != null)
            return controller.pickRefrigerator(app, matcher.group("item"));
        if (GameMainMenuCommands.SHOW_COOK_RECIPES.getMatcher(command) != null)
            return controller.showCookRecipes(app);
        if ((matcher = GameMainMenuCommands.PREPARE_COOKING.getMatcher(command)) != null)
            return controller.prepareCooking(app, matcher.group("recipeName"));
        if ((matcher = GameMainMenuCommands.EAT.getMatcher(command)) != null)
            return controller.eat(app, matcher.group("foodName"));
        if ((matcher = GameMainMenuCommands.ARTISAN_USE.getMatcher(command)) != null)
            return controller.artisanUse(app, matcher.group("artisanName"), matcher.group("itemName"));
        if ((matcher = GameMainMenuCommands.ARTISAN_GET.getMatcher(command)) != null)
            return controller.artisanGet(app, matcher.group("artisanName"));
        return null;
    }
    private Result checkBuySell(App app, String command) {
        Matcher matcher;
        if (GameMainMenuCommands.START_BUY.getMatcher(command) != null)
            return controller.startBuy(app);
        if ((matcher = GameMainMenuCommands.SELL_PRODUCT.getMatcher(command)) != null)
            return controller.sellProduct(app, matcher.group("productName"), matcher.group("count"));
        return null;
    }
    private Result checkAnimalFish(App app, String command) {
        Matcher matcher;
        if ((matcher = GameMainMenuCommands.BUILD.getMatcher(command)) != null)
            return controller.build(app, matcher.group("name"), matcher.group("x"), matcher.group("y"));
        if ((matcher = GameMainMenuCommands.BUY_ANIMAL.getMatcher(command)) != null)
            return controller.buyAnimal(app, matcher.group("animal"), matcher.group("name"));
        if ((matcher = GameMainMenuCommands.PET.getMatcher(command)) != null)
            return controller.pet(app, matcher.group("name"));
        if (GameMainMenuCommands.SHOW_ANIMALS.getMatcher(command) != null)
            return controller.showAnimals(app);
        if ((matcher = GameMainMenuCommands.SHEPHERD_ANIMAL.getMatcher(command)) != null)
            return controller.shepherdAnimal(app, matcher.group("name"), matcher.group("x"), matcher.group("y"));
        if ((matcher = GameMainMenuCommands.FEED_HAY.getMatcher(command)) != null)
            return controller.feedHay(app, matcher.group("name"));
        if (GameMainMenuCommands.SHOW_PRODUCES.getMatcher(command) != null)
            return controller.showProduces(app);
        if ((matcher = GameMainMenuCommands.COLLECT_PRODUCE.getMatcher(command)) != null)
            return controller.collectProduce(app, matcher.group("name"));
        if ((matcher = GameMainMenuCommands.SELL_ANIMAL.getMatcher(command)) != null)
            return controller.sellAnimal(app, matcher.group("name"));
        if ((matcher = GameMainMenuCommands.FISHING.getMatcher(command)) != null)
            return controller.fishing(app, matcher.group("pole"));
        return null;
    }
    private Result checkInteraction(App app, String command) {
        Matcher matcher;
        if (GameMainMenuCommands.SHOW_FRIENDSHIPS.getMatcher(command) != null)
            return controller.showFriendships(app);
        if ((matcher = GameMainMenuCommands.TALK.getMatcher(command)) != null)
            return controller.talk(app, matcher.group("username"), matcher.group("message"));
        if ((matcher = GameMainMenuCommands.TALK_HISTORY.getMatcher(command)) != null)
            return controller.talkHistory(app, matcher.group("username"));
        if ((matcher = GameMainMenuCommands.GIFT.getMatcher(command)) != null)
            return controller.gift(app, matcher.group("username"), matcher.group("item"), matcher.group("count"));
        if (GameMainMenuCommands.SHOW_GIFT_LIST.getMatcher(command) != null)
            return controller.showGiftList(app);
        if ((matcher = GameMainMenuCommands.GIFT_RATE.getMatcher(command)) != null)
            return controller.giftRate(app, matcher.group("giftID"), matcher.group("rate"));
        if ((matcher = GameMainMenuCommands.GIFT_HISTORY.getMatcher(command)) != null)
            return controller.giftHistory(app, matcher.group("username"));
        if ((matcher = GameMainMenuCommands.HUG.getMatcher(command)) != null)
            return controller.hug(app, matcher.group("username"));
        if ((matcher = GameMainMenuCommands.FLOWER.getMatcher(command)) != null)
            return controller.flower(app, matcher.group("username"));
        if ((matcher = GameMainMenuCommands.ASK_MARRIAGE.getMatcher(command)) != null)
            return controller.askMarriage(app, matcher.group("username"), matcher.group("ring"));
        if ((matcher = GameMainMenuCommands.RESPOND_MARRIAGE.getMatcher(command)) != null)
            return controller.respondMarriage(app, matcher.group("accepting"), matcher.group("username"));
        return null;
    }
    private Result checkNPC(App app, String command) {
        Matcher matcher;
        if ((matcher = GameMainMenuCommands.MEET_NPC.getMatcher(command)) != null)
            return controller.meetNPC(app, matcher.group("name"));
        if ((matcher = GameMainMenuCommands.GIFT_NPC.getMatcher(command)) != null)
            return controller.giftNPC(app, matcher.group("name"), matcher.group("item"));
        if (GameMainMenuCommands.SHOW_NPC_FRIENDSHIP.getMatcher(command) != null)
            return controller.showNPCFriendship(app);
        if (GameMainMenuCommands.SHOW_QUESTS_LIST.getMatcher(command) != null)
            return controller.showQuestsList(app);
        if ((matcher = GameMainMenuCommands.FINISH_QUEST.getMatcher(command)) != null)
            return controller.finishQuest(app, matcher.group("index"));
        return null;
    }
    private Result checkCheatCode(App app, String command) {
        Matcher matcher;
        if ((matcher = GameMainMenuCommands.CHEAT_TIME.getMatcher(command)) != null)
            return controller.cheatTime(app, matcher.group("hour"));
        if ((matcher = GameMainMenuCommands.CHEAT_DATE.getMatcher(command)) != null)
            return controller.cheatDate(app, matcher.group("day"));
        if ((matcher = GameMainMenuCommands.CHEAT_THOR.getMatcher(command)) != null)
            return controller.cheatThor(app, matcher.group("x"), matcher.group("y"));
        if ((matcher = GameMainMenuCommands.CHEAT_WEATHER.getMatcher(command)) != null)
            return controller.cheatWeather(app, matcher.group("type"));
        if ((matcher = GameMainMenuCommands.CHEAT_ENERGY.getMatcher(command)) != null)
            return controller.cheatEnergy(app, matcher.group("value"));
        if (GameMainMenuCommands.CHEAT_ENERGY_LIMIT.getMatcher(command) != null)
            return controller.cheatEnergyLimit(app);
        if ((matcher = GameMainMenuCommands.CHEAT_ITEM.getMatcher(command)) != null)
            return controller.cheatItem(app, matcher.group("itemName"), matcher.group("count"));
        if ((matcher = GameMainMenuCommands.CHEAT_ANIMAL_FRIENDSHIP.getMatcher(command)) != null)
            return controller.cheatAnimalFriendship(app, matcher.group("animalName"), matcher.group("amount"));
        if ((matcher = GameMainMenuCommands.CHEAT_BALANCE.getMatcher(command)) != null)
            return controller.cheatBalance(app, matcher.group("count"));
        return null;
    }
}
