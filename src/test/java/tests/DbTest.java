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

    MyLogger.info("request 1: Find the model number, speed and hard drive capacity for all the PCs with prices below $500."
        + " Result set: model, speed, hd.");
    Table request1Table = DataBaseUtil.getRequest(DataManager.getRequestData("request1"));
    Assert.assertEquals(request1Table, JsonUtil.getTableFromFile("request1ExpectedTable"),
        "actual and expected table  is not equals!");
    MyLogger.info("request 1 Table:\n" + request1Table.getTable());

    MyLogger.info("request 2:  Find the makers of PCs with a processor speed of 450 MHz or more. Result set: maker.");
    Table request2Table = DataBaseUtil.getRequest(DataManager.getRequestData("request2"));
    Assert.assertEquals(request2Table, JsonUtil.getTableFromFile("request2ExpectedTable"),
        "actual and expected table  is not equals!");
    MyLogger.info("request 2 Table:\n" + request2Table.getTable());

  }
}
