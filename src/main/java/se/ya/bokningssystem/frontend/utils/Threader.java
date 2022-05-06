package se.ya.bokningssystem.frontend.utils;

import javafx.application.Platform;
import javafx.scene.control.ProgressIndicator;
import se.ya.bokningssystem.frontend.switcher.Switcher;

public class Threader {

    public static void execute(Runnable task, Runnable fx) {
        Switcher.get().getLoading_bar().setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
        new Thread(() -> {
            task.run();
            Platform.runLater(() -> {
                fx.run();
                Switcher.get().getLoading_bar().setProgress(0);
            });
        }).start();
    }

    public static void execute(Runnable task) {
        Switcher.get().getLoading_bar().setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
        new Thread(() -> {
            task.run();
            Platform.runLater(() -> {
                Switcher.get().getLoading_bar().setProgress(0);
            });
        }).start();
    }
}
