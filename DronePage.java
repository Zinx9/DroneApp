import java.util.Scanner;

public class DronePage {
    private Drone drone;
    private DroneCommandParser parser;

    public DronePage(Drone drone) {
        this.drone = drone;
        this.parser = new DroneCommandParser();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter drone commands (type EXIT to quit):");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("EXIT")) {
                break;
            }
            parser.processCommand(line, drone);
        }
        scanner.close();
    }
}

