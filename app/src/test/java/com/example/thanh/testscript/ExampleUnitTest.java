package com.example.thanh.testscript;

import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import static org.junit.Assert.*;

public class ExampleUnitTest {
    MobileDriver driver;

    @Test(dataProvider = "DataTest")
    public void testRun(String sTenChuyenDi, String sTenDiemDi, String sTenDiemDen, String sSoTien) {
        System.out.println("testrun");

        AndroidTouchAction touchAction = new AndroidTouchAction(driver);
//        Bấm vào nút thêm mới
        MobileElement btnAdd = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='+']"));
        if(btnAdd.isDisplayed()) {
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(btnAdd))).perform();
            MobileElement txtTenChuyenDi = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@instance='0']");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(txtTenChuyenDi))).perform();
            txtTenChuyenDi.clear();
            txtTenChuyenDi.setValue(sTenChuyenDi);

            MobileElement txtDiemDi = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@instance='1']");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(txtDiemDi))).perform();
            txtDiemDi.clear();
            txtDiemDi.setValue(sTenDiemDi);

            MobileElement diaDiemDiDauTien = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@instance='3']");
            assertEquals(diaDiemDiDauTien.isDisplayed(),true);
            diaDiemDiDauTien.click();

            MobileElement txtDiemDen = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@instance='2']");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(txtDiemDen))).perform();
            txtDiemDen.clear();
            txtDiemDen.setValue(sTenDiemDen);

            MobileElement diaDiemDenDauTien = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@instance='4']");
            assertEquals(diaDiemDenDauTien.isDisplayed(),true);
            diaDiemDenDauTien.click();

            driver.findElementByXPath("//android.widget.TextView[@instance='6']").click();
            MobileElement el7 = (MobileElement) driver.findElementById("android:id/button1");
            el7.click();

            MobileElement txtSoTien = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]");
            txtSoTien.sendKeys(sSoTien);

            MobileElement dauTich = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@instance='1']");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(dauTich))).perform();

            MobileElement titleTaoLoTrinh = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@instance='0']");
            assertEquals(titleTaoLoTrinh.getText(),"Tạo lộ trình");

            dauTich = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@instance='1']");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(dauTich))).perform();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dauTich = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@instance='1']");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(dauTich))).perform();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            Phan so sanh xem chuyen di co duoc tao hay khong
            MobileElement txtTen = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@instance='2']");
            assertEquals(txtTen.getText(),"Hotake Kakashi");

            MobileElement txtTrangThai = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@instance='3']");
            assertEquals(txtTrangThai.getText(),"vài giây trước");

        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "DataTest")
    public static Object[][] datas() {
        return new Object[][] {
                {"Test1","Ha Noi","Da Nang","120000"},
                {"","","",""},
                {"Test3","","Da Nang","120000"},
                {"Test4","Ha Noi","","120000"},
                {"Test5","Ha Noi","Da Nang",""},
                {"Test6","sjsjsjskwiwwkkiz","Da Nang","120000"},
                {"Test7","Ha Noi","anvmvmhdndhnkkg","120000"},
                {"Test8","Ha Noi","Da Nang","yturnjfn"},
                {"Test9","New York","Da Nang","120000"},
                {"Test10","Ha Noi","Ha Noi","0"},
        };
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        System.out.println("start");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.7.1"); // Version Appium đang sử dụng, có hay không cũng được
        capabilities.setCapability("platformName", "Android"); //plaftFrom đang chạy (Android/IOS)
        capabilities.setCapability("platformVersion", "9");// Phiên bản adnroid máy dang dung để test
        capabilities.setCapability("deviceName", "emulator-5554"); // Tên thiết bị dùng để test

        capabilities.setCapability("appPackage", "vn.rure"); //App Package name
        capabilities.setCapability("appActivity", "vn.rure.MainActivity");// Activity name
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("unicodeKeyboard", true);


        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        System.out.println("end");
        driver.quit();
    }

}