package controller.main;

import controller.GeneralAppController;
import model.*;
import model.enums.Menu;

public class GameMainMenuController extends GeneralAppController { //extends GeneralAppController {
    public Result exitGame(App app) {
        Game game = app.getOpenedGame();
        for (Player player : game.getPlayers()) {
            if (player.getIncome() > player.getBestGameIncome())
                player.setBestGameIncome(player.getIncome());
            player.setCurrentGame(game);
            int index = findIndexByUser(app, player);
            app.setAUser(index, player);
        }
        app.setOpenedGame(null);
        app.setCurrentMenu(Menu.GAME);
        return new Result(true, "Game saved! You are now in game menu!");
    }

    public Result deleteGame(App app) {
        Game game = app.getOpenedGame();
        for (Player player : game.getPlayers()) {
            if (player.getIncome() > player.getBestGameIncome())
                player.setBestGameIncome(player.getIncome());
            player.setCurrentGame(null);
            int index = findIndexByUser(app, player);
            app.setAUser(index, player);
        }
        app.setOpenedGame(null);
        app.setCurrentMenu(Menu.GAME);
        return new Result(true, "Game deleted! You are now in game menu!");
    }

    public Result nextTurn(App app) {
        Game game = app.getOpenedGame();
        game.nextTurn();
        app.setOpenedGame(game);
        return new Result(true, "turn player: " + game.getTurnPlayer().getUsername());
    }

    public Result walk(App app, String x, String y) {
        // TODO
    }

    public Result printMap(App app, String x, String y, String size) {
        // TODO
    }

    public Result helpReadMap(App app) {
        // TODO
    }

    public Result showEnergy(App app) {
        Player player = app.getOpenedGame().getMainPlayer();
        return new Result(true, "Energy: " + player.getEnergy());
    }

    public Result showTime(App app) {
        Game game = app.getOpenedGame();
        return new Result(true, "Time: " + game.getDateTime().getHour() + ":00");
    }

    public Result showDate(App app) {
        Game game = app.getOpenedGame();
        return new Result(true, "Date: day " + game.getDateTime().getDay() + " of month");
    }

    public Result showDateTime(App app) {
        Game game = app.getOpenedGame();
        return new Result(true, "Time: " + game.getDateTime().getHour() + ":00\n" +
                "Date: day " + game.getDateTime().getDay() + " of month");
    }

    public Result showWeekDay(App app) {
        Game game = app.getOpenedGame();
        return new Result(true, "day \"" + game.getDateTime().getWeekDay() + "\" of week");
    }

    public Result showSeason(App app) {
        Game game = app.getOpenedGame();
        return new Result(true, "Season: " + game.getDateTime().getSeason());
    }

    public Result showWeather(App app) {
        Game game = app.getOpenedGame();
        return new Result(true, "Weather: " + game.getTodayWeather().string);
    }

    public Result showTomorrowWeather(App app) {
        Game game = app.getOpenedGame();
        return new Result(true, "Weather: " + game.getTomorrowWeather().string);
    }

    public Result greenhouseBuild(App app) {\
        // TODO
    }

    public Result showInventory(App app) {
        // TODO
    }

    public Result deleteInventoryItem(App app, String itemName, String number) {
        // TODO
    }

    public Result toolsEquip(App app, String toolName) {
        // TODO
    }

    public Result showCurrentTool(App app) {
        // TODO
    }

    public Result showToolsList(App app) {
        // TODO
    }

    public Result upgradeTool(App app, String toolName) {
        // TODO
    }

    public Result useTool(App app, String direction) {
        // TODO
    }

    public Result showCraftInfo(App app, String craftName) {
        // TODO
    }

    public Result plant(App app, String seed, String direction) {
        // TODO
    }

    public Result showPlant(App app, String x, String y) {
        // TODO
    }

    public Result fertilize(App app, String fertilizer, String direction) {
        // TODO
    }

    public Result showWater(App app) {
        // TODO
    }

    public Result showCraftRecipes(App app) {
        // TODO
    }

    public Result crafting(App app, String itemName) {
        // TODO
    }

    public Result placeItem(App app, String itemName, String direction) {
        // TODO
    }

    public Result putRefrigerator(App app, String item) {
        // TODO
    }

    public Result pickRefrigerator(App app, String item) {
        // TODO
    }

    public Result showCookRecipes(App app) {
        // TODO
    }

    public Result prepareCooking(App app, String recipeName) {
        // TODO
    }

    public Result eat(App app, String foodName) {
        // TODO
    }

    public Result artisanUse(App app, String artisanName, String itemName) {
        // TODO
    }

    public Result artisanGet(App app, String artisanName) {
        // TODO
    }

    public Result sellProduct(App app, String productName, String count) {
        // TODO
    }

    public Result startBuy(App app) {
        // TODO
    }

    public Result build(App app, String name, String x, String y) {
        // TODO
    }

    public Result buyAnimal(App app, String animal, String name) {
        // TODO
    }

    public Result pet(App app, String name) {
        // TODO
    }

    public Result showAnimals(App app) {
        // TODO
    }

    public Result shepherdAnimal(App app, String name, String x, String y) {
        // TODO
    }

    public Result feedHay(App app, String name) {
        // TODO
    }

    public Result showProduces(App app) {
        // TODO
    }

    public Result collectProduce(App app, String name) {
        // TODO
    }

    public Result sellAnimal(App app, String name) {
        // TODO
    }

    public Result fishing(App app, String pole) {
        // TODO
    }

    public Result showFriendships(App app) {
        // TODO
    }

    public Result talk(App app, String username, String message) {
        // TODO
    }

    public Result talkHistory(App app, String username) {
        // TODO
    }

    public Result gift(App app, String username, String item, String count) {
        // TODO
    }

    public Result showGiftList(App app) {
        // TODO
    }

    public Result giftRate(App app, String giftID, String rate) {
        // TODO
    }

    public Result giftHistory(App app, String username) {
        // TODO
    }

    public Result hug(App app, String username) {
        // TODO
    }

    public Result flower(App app, String username) {
        // TODO
    }

    public Result askMarriage(App app, String username, String ring) {
        // TODO
    }

    public Result respondMarriage(App app, String accepting, String username) {
        // TODO
    }

    public Result meetNPC(App app, String name) {
        // TODO
    }

    public Result giftNPC(App app, String name, String item) {
        // TODO
    }

    public Result showNPCFriendship(App app) {
        // TODO
    }

    public Result showQuestsList(App app) {
        // TODO
    }

    public Result finishQuest(App app, String index) {
        // TODO
    }

    public Result cheatTime(App app, String hour) {
        // TODO
    }

    public Result cheatDate(App app, String day) {
        // TODO
    }

    public Result cheatThor(App app, String x, String y) {
        // TODO
    }

    public Result cheatWeather(App app, String type) {
        // TODO
    }

    public Result cheatEnergy(App app, String value) {
        // TODO
    }

    public Result cheatEnergyLimit(App app) {
        // TODO
    }

    public Result cheatItem(App app, String itemName, String count) {
        // TODO
    }

    public Result cheatAnimalFriendship(App app, String animalName, String amount) {
        // TODO
    }

    public Result cheatBalance(App app, String count) {
        // TODO
    }
}
