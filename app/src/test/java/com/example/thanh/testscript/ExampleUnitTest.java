package com.example.thanh.testscript;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

import static org.junit.Assert.*;

public class ExampleUnitTest {
    MobileDriver driver;

    @Test
    public void testRun() {
        System.out.println("testrun");

//        By txtPass = By.id("com.example.thanh.myapplication2:id/txtPass");
//        By btnDangNhap = By.id("com.example.thanh.myapplication2:id/btnDangNhap");
//
//        driver.findElement(txtName).sendKeys(sName);
//        driver.findElement(txtPass).sendKeys(sPass);
        MobileElement btnAdd = (MobileElement) driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.support.v4.view.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));
        if(btnAdd.isDisplayed()) {
            System.out.println("Dang hien thi");
            AndroidTouchAction touchAction = new AndroidTouchAction(driver);
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(btnAdd))).perform();
        }
        else {
            System.out.println("Meo");
        }

//
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        WebElement message = driver.findElement(By.id("android:id/message"));
//        Assert.assertEquals(message.getText(),sExpectedResult);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @DataProvider(name = "newData")
//    public static Object[][] datas() {
//        return new Object[][] {
//                {"aaa","123","Dang nhap thanh cong"},
//                {"20","142","Dang nhap that bai"},
//                {"aaa","125","Dang nhap thanh cong"},
//                {"awfaa","ss","Dang nhap that bai"}
//        };
//    }

//    @BeforeMethod(alwaysRun = true)
    @Before
    public void setUp() throws MalformedURLException {
        System.out.println("start");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.7.1"); // Version Appium đang sử dụng, có hay không cũng được
        capabilities.setCapability("platformName", "Android"); //plaftFrom đang chạy (Android/IOS)
        capabilities.setCapability("platformVersion", "6.0");// Phiên bản adnroid máy dang dung để test
        capabilities.setCapability("deviceName", "emulator-5554"); // Tên thiết bị dùng để test

        capabilities.setCapability("appPackage", "vn.rure"); //App Package name
        capabilities.setCapability("appActivity", "vn.rure.MainActivity");// Activity name


        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

//    @AfterMethod(alwaysRun = true)
    @After
    public void afterTest() {
        System.out.println("end");
        driver.quit();
    }

}