package com.test.java.webui.project;

import com.test.java.webui.PageFactory.InvokeData;
import com.test.java.webui.project.Page.LoginPage;
import com.test.java.webui.project.Page.OrderViewPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by beigui on 2016/5/19.
 */
public class AutoOrder extends InvokeData {
    private WebDriverPlus driverPlus;

    @BeforeClass
    public void before() {
        driverPlus = new WebDriverPlus();
        driverPlus.get("https://passport.suning.com/ids/login");
        System.out.println("打开网页：" + driverPlus.getTitle());
    }

    @Test(dataProvider = "csv")
    public void order(String username, String password, String ware_url, String order_view) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driverPlus);
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.login();
        Assert.assertTrue(loginPage.isLoginedIn("170"), "登录失败");

//        System.out.println("转到商品页，url=" + ware_url);
//        driverPlus.get(ware_url);
//
//        WarePage warePage = new WarePage(driverPlus);
//        System.out.println("添加商品到购物车");
//        //TODO 系统判定操作为机器人，如何破
//        warePage.addCart();
//
//        //简单流程，已经有默认收货地址，选择门店付款避免在线支付流程
//        CartPage cartPage = new CartPage(driverPlus);
//        cartPage.submitOrder();

        driverPlus.get(order_view);
        OrderViewPage ovPage = new OrderViewPage(driverPlus);
        Assert.assertTrue(ovPage.checkOrder("汪峰"), "没有找到期望的订单信息");
    }

    @AfterClass
    public void tearDown() {
        driverPlus.quit();
    }
}
