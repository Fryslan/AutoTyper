package typer.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.Strategy;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 25-12-2014
 * Time: 20:13
 */
public class Typer implements Strategy {

    private final String sentence;
    private final int maxSleep;
    private final int minSleep;

    public Typer(String sentence,int maxSleep,int minSleep) {
        this.sentence = sentence;
        this.minSleep = minSleep;
        this.maxSleep = maxSleep;
    }

    @Override
    public boolean activate() {
        return sentence != null;
    }

    @Override
    public void execute() {
        Keyboard.getInstance().sendKeys(sentence);
        Time.sleep(minSleep,maxSleep);
    }
}
