package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.GameResult;

import java.util.ArrayList;
import java.util.List;

public class BridgeService {

    public static Bridge makeBridge(Integer bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeStatus = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridgeStatus);
    }

    public static GameResult makeInitialGameResult() {
        return new GameResult(new ArrayList<>(),new ArrayList<>());
    }
}
