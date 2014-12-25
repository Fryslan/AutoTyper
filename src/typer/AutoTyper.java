package typer;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import typer.presentation.TyperUI;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 25-12-2014
 * Time: 20:04
 */
@ScriptManifest(
        name = "Fryslan AutoTyper",
        author = "Fryslan",
        description = "Simple auto typer for every server.",
        version = 1.0,
        servers = "Every Server",
        category = Category.UTILITY
)
public class AutoTyper extends Script {

    public static ArrayList<Strategy> strategies;
    public static boolean initialized;

    public AutoTyper() {
        initialized = false;
        strategies = new ArrayList<>();
    }

    @Override
    public boolean onExecute() {

        TyperUI.initialize();
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return initialized;
            }
        }, Integer.MAX_VALUE);

        provide(strategies);
        return true;
    }

    @Override
    public void onFinish() {

    }

}
