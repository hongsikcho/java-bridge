package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("입력한 사이즈만큼의 다리를 생성한다.")
    @Test
    void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge.getBridgeLength()).isEqualTo(3);

    }
}