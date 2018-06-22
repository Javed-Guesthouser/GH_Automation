package Utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;

import java.lang.ref.PhantomReference;

import javax.imageio.ImageIO;

import com.TestProject.myPack.Browser.GlobalVars;

public class ScreenCapture {

	public void passCapture() throws Exception {
		try {
			Robot robot = new Robot();
			String format = "png";
			// String fileName = "FullScreenshot." + format;

			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			// ImageIO.write(screenFullImage,format, new
			// File("D:/Generic/"+GlobalVar.USER_NAME+"/Snapshots\\Pass
			// Images\\"+GlobalVar.SCREEN_SHOT_NAME+" .png"));
			ImageIO.write(screenFullImage, format, new File("/Users/ahmedjaved/Desktop/" + GlobalVars.PROJ_NAME + "/Iteration/Snapshots/Pass Images/" + GlobalVars.SCREEN_SHOT_NAME + " .png"));
		} catch (AWTException | IOException ex) {
			System.err.println(ex);
		}
	}

	public void failCapture() throws Exception {
		try {
			Robot robot = new Robot();
			String format = "png";
			// String fileName = "FullScreenshot." + format;

			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			// ImageIO.write(screenFullImage,format, new
			// File("D:/Generic/"+GlobalVar.USER_NAME+"/Snapshots\\Fail
			// Images\\"+GlobalVar.SCREEN_SHOT_NAME+" .png"));
			ImageIO.write(screenFullImage, format, new File("/Users/ahmedjaved/Desktop/" + GlobalVars.PROJ_NAME + "/Iteration"
					+ GlobalVars.ITERATION_FLAG + "/Snapshots\\Fail Images\\" + GlobalVars.SCREEN_SHOT_NAME + " .png"));

		} catch (AWTException | IOException ex) {
			System.err.println(ex);
		}
	}
}
