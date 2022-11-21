package bridge.controller;

import bridge.domain.User;
import bridge.service.BridgeGame;
import bridge.service.BridgeService;
import bridge.service.UserService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    public void run() {
        String bridgeSize;
        do {
            bridgeSize = InputView.readBridgeSize();
        } while (bridgeSize == "error");

        List<String> bridge = BridgeService.initBridge(bridgeSize);
        User user = UserService.generateUser();

        startGame(bridge, user);
        endGame(bridge, user);
    }

    private void startGame(List<String> bridge, User user) {
        UserService.initUser(user);
        move(bridge, user);

        if (user.sameBridgeSize(bridge.size())) {
            return;
        }
        retry(bridge, user);
    }

    private void move(List<String> bridge, User user) {
        while (user.lessThanBridgeSize(bridge.size())) {
            String position;
            do {
                position = InputView.readMoving();
            } while (position.equals("error"));

            if(BridgeGame.move(position, bridge, user)){
                OutputView.printMap(user);
                return;
            }
            OutputView.printMap(user);
        }
    }

    private void retry(List<String> bridge, User user) {
        OutputView.printRetry();
        String retryInput;
        do {
            retryInput = InputView.readGameCommand();
        } while (retryInput == "error");
        if (BridgeGame.retry(retryInput, user)) {
            startGame(bridge, user);
        }
    }

    private static void endGame(List<String> bridge, User user) {
        OutputView.printResult(user);
        if (user.sameBridgeSize(bridge.size())) {
            OutputView.printSuccess();
            return;
        }
        OutputView.printFail();
    }
}
