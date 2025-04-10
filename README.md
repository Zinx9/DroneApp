# Drone Testing Application (Java)

This application simulates a drone flying within a 5x5 meter testing area using a command-based interface. It was developed using Java and follows Object-Oriented Programming (OOP) principles.

## 📘 Description

- The drone starts inactive and can only respond to commands after a valid `LAUNCH`.
- The testing area is a 5x5 grid where the origin (0,0) is the top-left (Northwest) corner.
- The drone accepts the following commands:
  - `LAUNCH X,Y,F` – Places the drone at coordinates X,Y facing direction F (NORTH, SOUTH, EAST, WEST)
  - `FLY` – Moves the drone one step forward in its current direction
  - `LEFT` / `RIGHT` – Rotates the drone 90° in the respective direction
  - `STATUS` – Prints the current position and facing direction
  - `EXIT` – Ends the program

## 🧱 Project Structure

- `Drone.java` - Contains the Drone class with logic for movement, rotation, and state management.
- `DroneCommandParser.java` - Parses and interprets text commands into drone actions.
- `DronePage.java` - Handles console interaction (input/output).
- `DroneTestApp.java` - Main class that runs the application.

## ✅ Sample Commands

```text
LAUNCH 1,2,EAST
FLY
FLY
LEFT
FLY
STATUS
```

**Expected Output:**
```
3,1,NORTH
```

## 🚀 How to Run

1. **Compile all Java files:**

   ```bash
   javac DroneTestApp.java Drone.java DronePage.java DroneCommandParser.java
   ```

2. **Run the application:**

   ```bash
   java DroneTestApp
   ```

3. **Start entering commands:**

   ```text
   LAUNCH 0,0,SOUTH
   FLY
   STATUS
   EXIT
   ```

##  Boundary Rules

- The drone **cannot move outside** the 5x5 testing grid.
- Invalid moves or commands before a valid `LAUNCH` are ignored with a message.
