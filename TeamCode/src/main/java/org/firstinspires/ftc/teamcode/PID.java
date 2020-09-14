package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

// Initialize with DC Motor class with arm. Implement this system for fast and consistent
// motor control. Use with arm and wheels.

public class PID {
    double targetPosition = 500;
    double integral = 0;
    double iterations = 0;
    ElapsedTime timer = new ElapsedTime();

    public void launch() {
        double error = part.getCurrentPosition() - targetPosition;
        double lastError = 0;
        double Constant1 = 0.01;
        double Constant2 = 0.001;
        double Constant3 = 0.001;
        while (Math.abs(error) <= 5) {
            error = part.getCurrentPosition() - targetPosition;
            double deltaError = lastError - error;
            integral += deltaError * timer.time();
            double derivative = deltaError / timer.time();
            part.setPower(Constant1 * error + Constant1 * integral + Constant3 * derivative);
            error = lastError;
            iterations++;
            timer.reset();
        }
    }
}
