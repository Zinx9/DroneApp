public class DroneCommandParser {
        public void processCommand(String command, Drone drone) {
            if (command == null || command.isEmpty()) {
                return;
            }
            String[] parts = command.split("\\s+", 2);
            String cmd = parts[0].toUpperCase();
    
            switch (cmd) {
                case "LAUNCH":
                    if (parts.length < 2) {
                        System.out.println("Invalid LAUNCH command. Expected format: LAUNCH X,Y,F");
                        break;
                    }
                    parseLaunch(parts[1], drone);
                    break;
                case "FLY":
                    drone.fly();
                    break;
                case "LEFT":
                    drone.turnLeft();
                    break;
                case "RIGHT":
                    drone.turnRight();
                    break;
                case "STATUS":
                    System.out.println(drone.status());
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
        }
    
        private void parseLaunch(String paramsPart, Drone drone) {
            String[] params = paramsPart.split(",");
            if (params.length != 3) {
                System.out.println("Invalid parameters for LAUNCH. Expected: LAUNCH X,Y,F");
                return;
            }
            try {
                int x = Integer.parseInt(params[0].trim());
                int y = Integer.parseInt(params[1].trim());
                String facingStr = params[2].trim().toUpperCase();
                Drone.Direction facing = Drone.Direction.valueOf(facingStr);
                drone.launch(x, y, facing);
            } catch (Exception e) {
                System.out.println("Error processing LAUNCH command: " + e.getMessage());
            }
        }
    }
    
