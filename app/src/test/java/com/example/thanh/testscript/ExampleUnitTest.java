package com.example.thanh.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    @DataProvider(name = "DataTest")
    public static Object[][] datas() {
        return new Object[][] {
                {"Test1","Ha Noi","Da Nang","120000", "Pass"},
                {"","","","", "Fail"},
                {"","Ha noi","Da Nang","120000","Fail"},
                {"Test4","","Da Nang","120000", "Fail"},
                {"Test5","Ha Noi","","120000", "Fail"},
                {"Test6","Ha Noi","Da Nang","", "Fail"},
                {"Test7","sjsjsjskwiwwkkiz","Da Nang","120000", "Fail"},
                {"Test8","Ha Noi","anvmvmhdndhnkkg","120000", "Fail"},
                {"Test9","Ha Noi","Da Nang","yturnjfn","Fail"},
                {"Test10","New York","Da Nang","-120000","Fail"},
                {"Test11","Tp HCM","Da Nang","120000","Pass"},
                {"Test12","+-/","Da Nang","120000","Fail"},
                {"Test13","Ha Noi","/*-+","120000","Fail"},
                {"/*--/*","New York","Da Nang","120000","Fail"},
                {"Test15","New York","Da Nang","/*-+","Fail"},
                {"Test16","Da Nang","Da Nang","120000","Pass"},
                {"Test17","","Da Nang","120000","Pass"},
                {"Test18","hcm","Da Nang","120000 + 40000","Pass"},
                {"Test19","hcm","Da Nang","120000 - 50000","Pass"},
                {"Test20","hcm","Da Nang","120000/4","Pass"},
        };
    }

    @Test(dataProvider = "DataTest")
//    @org.junit.Test
    public void testRun(String sTenChuyenDi, String sTenDiemDi, String sTenDiemDen, String sSoTien, String kq) {
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
            MobileElement txtTen = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@instance='1']");
            assertEquals(txtTen.getText(),"Hotake Kakashi");
//            System.out.println("Ten: " + txtTen.getText());

            MobileElement txtTrangThai = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@instance='2']");
            assertEquals(txtTrangThai.getText(),"vài giây trước");
//            System.out.println("txtTrangThai: " + txtTrangThai.getText());
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws MalformedURLException {
        System.out.println("start");

        DesiredCapabilities capabilities = new DesiredCapabilities();
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
    public void testAfter() {
        System.out.println("end");
        driver.quit();
    }

}