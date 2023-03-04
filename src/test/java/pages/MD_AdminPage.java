package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MD_AdminPage {

    public MD_AdminPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

  @FindBy (id = "admin-menu")
    public WebElement adminMenu;
  @FindBy (xpath = "//a[@class='dropdown-item']//span[.='User management']")
    public WebElement userManagement;
  @FindBy (xpath = "//*[@id='user_mdrky']//*[contains(text(),'Edit')]")
    public WebElement userEdit;

@FindBy (xpath ="//*[@id='app-view-container']//a[@aria-label='Next']")
    public WebElement next;
    @FindBy (xpath = "//li[@class='page-item']|//li[@class='page-item disabled']")
    public List<WebElement> pageItems;
    @FindBy (xpath = "//th[@class='hand']//*[contains(text(),'Created date')]")
    public WebElement createdDate;

 //Create or Edit a user
@FindBy(id = "firstName")
    public WebElement firstName;
@FindBy (id = "lastName")
public WebElement lastName;
@FindBy(id = "langKey")
    public WebElement language;
@FindBy(id = "authorities")
    public WebElement roles;
@FindBy (xpath = "//button[@type='submit']")
    public WebElement submit;
@FindBy (xpath ="//*[@id='root']/div/div/div[1]/div/div")
    public WebElement successMessage;
}

