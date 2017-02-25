/**
 * Created by bgc82 on 2016-10-29.
 */
public interface Command {
    void execute();

    default boolean canUndo(){return false;}

    default void undo(){

    }
}
