package Utility;

import java.io.File;
import java.util.Properties;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import PageObject.A_loginPage;
import PageObject.B_Catalog_ProductPage;
import PageObject.C_Catalog_CategoriesPage;
import PageObject.D_Catalog_ManufacturePage;
import PageObject.E_Catalog_ProductReviewPage;
import PageObject.F_Catalog_ProductTagPage;
import PageObject.G_Catalog_productAttrPage;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties configProp;
	public static Logger logger;
	public static  File folder;
	
	public A_loginPage loginpage;
	public B_Catalog_ProductPage productPage;
	public C_Catalog_CategoriesPage categoryPage;
	public D_Catalog_ManufacturePage manufacturePage;
	public E_Catalog_ProductReviewPage productReviewPage;
	public F_Catalog_ProductTagPage ProductTagPage ;
	public G_Catalog_productAttrPage productAttrPage;
	
	public String GenerateProductName() {
		String generateProductName = RandomStringUtils.randomAlphabetic(10);
		return generateProductName;		
	}
	public String GenerateManufactureName() {
		String manufactureName = RandomStringUtils.randomAlphanumeric(6);
		return manufactureName;
	}
	
}
