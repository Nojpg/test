package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Nojpg on 03.06.17.
 */
public class testTableCollection implements ITestTable{

    private ObservableList<testTable> testsList = FXCollections.observableArrayList();

    @Override
    public void delTest(testTable testTable) {
        testsList.remove(testTable);
    }

    @Override
    public void add(testTable testTable) {
        testsList.add(testTable);
    }

    public ObservableList<testTable> getTestsList(){
        return testsList;
    }
}
