package tests;

import businessObjects.Table;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataBaseUtil;
import utils.DataManager;
import utils.JsonUtil;
import utils.MyLogger;

public class DbTest {

  @Test
  public void DbTest() {

    MyLogger.info("Exercise 1: Find the model number, speed and hard drive capacity for all the PCs with prices below $500.\n"
        + "Result set: model, speed, hd.");
    String request = DataManager.getRequestData("request1");
    Table request1Table = DataBaseUtil.getRequest(request);
    Assert.assertEquals(request1Table, JsonUtil.getTableFromFile("request1ExpectedTable"));
    request1Table.printTable();
  }
}
