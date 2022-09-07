package org.mainproject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Adactin_Hotel_App {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dilli\\eclipse-workspace\\Main_Project\\Chrome_Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://adactinhotelapp.com/");

		// LogIn

		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("SriniSankar");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("Srini@123");
		
		WebElement signInbtn = driver.findElement(By.xpath("//input[@type='Submit']"));
		signInbtn.click();

		// Search Hotel

		WebElement location = driver.findElement(By.xpath("//select[@name='location']"));
		Select sc = new Select(location);
		sc.selectByValue("Paris");

		WebElement hotels = driver.findElement(By.xpath("//select[@name='hotels']"));
		Select sc2 = new Select(hotels);
		sc2.selectByIndex(4);

		WebElement roomType = driver.findElement(By.xpath("//select[@name='room_type']"));
		Select sc3 = new Select(roomType);
		sc3.selectByVisibleText("Super Deluxe");

		WebElement numOfRooms = driver.findElement(By.xpath("//select[@name='room_nos']"));
		Select sc4 = new Select(numOfRooms);
		sc4.selectByValue("2");

		WebElement checkIn = driver.findElement(By.xpath("//input[@name='datepick_in']"));
		checkIn.clear();
		checkIn.sendKeys("25/06/2022");

		WebElement checkOut = driver.findElement(By.xpath("//input[@name='datepick_out']"));
		checkOut.clear();
		checkOut.sendKeys("29/06/2022");

		WebElement adultsPerRoom = driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select sc5 = new Select(adultsPerRoom);
		sc5.selectByValue("3");

		WebElement childPerRoom = driver.findElement(By.xpath("//select[@name='child_room']"));
		Select sc6 = new Select(childPerRoom);
		sc6.selectByIndex(2);

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// Select Hotel

		driver.findElement(By.xpath("//input[@name='radiobutton_0']")).click();
		driver.findElement(By.xpath("//input[@name='continue']")).click();

		// Book a hotel

		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Srinivasan");
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Sankar");
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@name='cc_num']")).sendKeys("1234567890987654");

		WebElement cardNumber = driver.findElement(By.xpath("//select[@name='cc_type']"));
		Select sc7 = new Select(cardNumber);
		sc7.selectByValue("MAST");

		WebElement expiryMonth = driver.findElement(By.xpath("//select[@name='cc_exp_month']"));
		Select sc8 = new Select(expiryMonth);
		sc8.selectByValue("12");

		WebElement expiryYear = driver.findElement(By.xpath("//select[@name='cc_exp_year']"));
		Select sc9 = new Select(expiryYear);
		sc9.selectByValue("2022");

		driver.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys("876");

		driver.findElement(By.xpath("//input[@name='book_now']")).click();

		// Book Itinerary
		driver.findElement(By.xpath("//input[@name='my_itinerary']")).click();

		// Screenshot Booked Itinerary

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\dilli\\eclipse-workspace\\Main_Project\\Screenshot\\Booked_Itinerary.png");
		FileUtils.copyFile(source, des);

		driver.findElement(By.xpath("//input[@name='logout']")).click();

		// Screenshot LogedOut

		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		File des1 = new File("C:\\Users\\dilli\\eclipse-workspace\\Main_Project\\Screenshot\\logedOut.png");
		FileUtils.copyFile(source1, des1);

		System.out.println("Room Booking Completed");

	}

}
