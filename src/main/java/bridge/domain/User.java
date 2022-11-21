package bridge.domain;

import java.util.List;

public class User {
    private int count;
    private int tryCount;

    private List<String> upSpace;

    private List<String> downSpace;

    public User(List<String> upSpace, List<String> downSpace) {
        this.upSpace = upSpace;
        this.downSpace = downSpace;
        this.tryCount = 1;
        this.count = 0;
    }

    public void init() {
        upSpace.clear();
        downSpace.clear();
        count = 0;
    }

    public void recordResult(String movingResult, String moving) {
        if (moving.equals("U")) {
            upSpace.add(movingResult);
            downSpace.add(" ");
            return;
        }
        downSpace.add(movingResult);
        upSpace.add(" ");

    }

    public boolean sameBridgeSize(int size) {
        if (size == count) {
            return true;
        }
        return false;
    }

    public boolean lessThanBridgeSize(int size) {
        if (size > count) {
            return true;
        }
        return false;
    }

    public String movePosition(List<String> bridge, String userMoving) {
        if (bridge.get(count).equals(userMoving)) {
            recordResult("O",userMoving);
            return "O";
        }
        recordResult("X",userMoving);
        return "X";
    }

    public void increaseTryCount() {
        tryCount++;
    }

    public void increaseCount() {
        count++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getUpSpace() {
        return upSpace;
    }

    public List<String> getDownSpace() {
        return downSpace;
    }
}
