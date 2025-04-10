public class DroneTestApp {
    public static void main(String[] args) {
        Drone drone = new Drone();
        DronePage dronePage = new DronePage(drone);
        dronePage.start();
    }
}
