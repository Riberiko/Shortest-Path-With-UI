import App.AppLoop;
import App.Controllers.KeyController;
import App.Controllers.MouseController;

import Frame.FrameManager;

public class AppLauncher {

    public static void main(String[] args) {
        KeyController keyController = new KeyController();
        MouseController mouseController = new MouseController();

        FrameManager frameManager = new FrameManager("Graph Project");
        keyController.setFrame(frameManager);
        frameManager.setKeyController(keyController);
        frameManager.setMouseController(mouseController);

        AppLoop loop = new AppLoop();
        loop.setCurrentFrame(frameManager.getCurrentFrame());

        Thread thread = new Thread(loop);
        frameManager.setLoop(loop);

        thread.start();
    }

}
