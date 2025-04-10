public class Drone {
    private int x;
    private int y;
    private Direction direction;
    private boolean isLaunched;
    public static final int BOUNDARY = 5;

    public enum Direction {
        NORTH, EAST, SOUTH, WEST;
        
        public Direction turnLeft() {
            switch (this) {
                case NORTH: return WEST;
                case WEST:  return SOUTH;
                case SOUTH: return EAST;
                case EAST:  return NORTH;
            }
            return this;
        }
        
        public Direction turnRight() {
            switch (this) {
                case NORTH: return EAST;
                case EAST:  return SOUTH;
                case SOUTH: return WEST;
                case WEST:  return NORTH;
            }
            return this;
        }
    }

    public Drone() {
        this.isLaunched = false;
    }

    public void launch(int x, int y, Direction direction) {
        if (isWithinBounds(x, y)) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.isLaunched = true;
        } else {
            System.out.println("LAUNCH position (" + x + "," + y + ") is out of bounds.");
        }
    }

    public void fly() {
        if (!isLaunched) {
            return;
        }
        int newX = this.x;
        int newY = this.y;
        switch (direction) {
            case NORTH: newY = this.y - 1; break;
            case SOUTH: newY = this.y + 1; break;
            case EAST:  newX = this.x + 1; break;
            case WEST:  newX = this.x - 1; break;
        }
        if (isWithinBounds(newX, newY)) {
            this.x = newX;
            this.y = newY;
        } else {
            System.out.println("FLY command ignored. Drone would leave testing area.");
        }
    }

    public void turnLeft() {
        if (!isLaunched) {
            return;
        }
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        if (!isLaunched) {
            return;
        }
        this.direction = this.direction.turnRight();
    }

    public String status() {
        if (!isLaunched) {
            return "Drone has not been launched.";
        }
        return String.format("%d,%d,%s", x, y, direction);
    }

    private boolean isWithinBounds(int x, int y) {
        return (x >= 0 && x < BOUNDARY && y >= 0 && y < BOUNDARY);
    }
}
