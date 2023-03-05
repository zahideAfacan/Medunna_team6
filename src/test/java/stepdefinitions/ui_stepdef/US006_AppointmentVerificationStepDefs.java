package stepdefinitions.ui_stepdef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AppointmentPageMD;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.*;

public class US006_AppointmentVerificationStepDefs {

    ////////////////VERIFICATION\\\\\\\\\\\\\\\\
    AppointmentPageMD appointmentPageMD = new AppointmentPageMD();

    @Given("user admin clicks account menu button")
    public void user_admin_clicks_account_menu_button() {
        appointmentPageMD.accountMenu.click();
    }

    @When("user admin clicks sign in button")
    public void user_admin_clicks_sign_in_button() {
        appointmentPageMD.signIn.click();
    }

    @Then("user admin enters credentials")
    public void user_admin_enters_credentials(DataTable adminCredentials) {
        List<Map<String, String>> adminUserPass = adminCredentials.asMaps(String.class, String.class);

        for (Map<String, String> each : adminUserPass) {
            appointmentPageMD.userName.sendKeys(each.get("username"));
            ReusableMethods.waitFor(2);
            appointmentPageMD.password.sendKeys(each.get("password"));
            ReusableMethods.waitFor(2);
        }
        appointmentPageMD.submitAdmin.click();
    }

    @Then("user admin clicks itemTitles")
    public void user_admin_clicks_item_titles() {
        ReusableMethods.waitFor(1);
        appointmentPageMD.itemTitles.click();

    }

    @Then("user admin clicks patient")
    public void user_admin_clicks_patient() {
        ReusableMethods.waitFor(2);
        appointmentPageMD.patient.click();

    }

    @Then("user admin checks appointment of patient and verify the credentials")
    public void user_admin_checks_appointment_of_patient(DataTable patientInfo) {
 //Data Table class featuredaki bilgiyi List Map yapiyor.List icinde birden fazla Map olsa idi teker teker almaak lazim idi for eacj
        //ama burda gerek yok.

        ReusableMethods.waitFor(3);
        List<Map<String, String>> patientDetails = patientInfo.asMaps(String.class, String.class);
        //patientDetails diye bir List<Map> oldu.Bu DataTable otomatik yapiyor
        System.out.println("Patient Details" + patientDetails);//Konsolda gormek icin,..Gerek yok

        //Table Headers(ID,SSN,First Name... Aliyor ve bir ArrrayList icine atiyoruz. Locatore bakarsaniz List<webElement>table header
        List<String> allHeaderNames = new ArrayList<String>();
        for (int i = 0; i < appointmentPageMD.tableHeader.size() - 1; i++) {
            //Burda int=1 ile basliyor cunku Table Index ) degil 1 den basliyor
            //appointmentPage.tableHeader.size() - 1 (Cunku en sondaki View edit Delete kismi bir columnda ve basligi yok.Lazim degil
            String headerName = appointmentPageMD.tableHeader.get(i).getText();
            allHeaderNames.add(headerName);
        }
//ALL TABLE DATA
        List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
  //LinkedHashMap normal Map degil cunku  bu sekilde insertion sirasi her zaman korunuyor,Bize bu lazim
        int rowCount = appointmentPageMD.allRowElements.size();//Kac row var oldugunu gosteriyor
        int pageItemSize = appointmentPageMD.pageItems.size(); //En alttaki next page elements.Bunun sayisini bilmek lazim.O kadar click
        System.out.println(pageItemSize+ "Page Item SIze ........................>>>>>>>>");
        for (int i = 1; i <= pageItemSize+1; i++) {//Click next icin loop
            ReusableMethods.waitFor(3);//Bekleme biraz uzun tutmak lazim cunku her pageden data almak zaman aliyor

            List<WebElement> row = Driver.getDriver().findElements(By.xpath("//*[@id='app-view-container']//table/tbody/tr"));
            //Aslinda row icin locator pagede yaptik ama..En sonuncu sayfada row sayisi ilk sayfalardaki gibi esit olmayacak.O yuzden
            //dinamik olmasi ve her loop icin row tekrar check icin locator buraya yazdim
            for (int j = 1; j <= row.size(); j++) {//Ikici loop her bir rowdaki datalari aliyor
                List<WebElement> allColumnsElements = Driver.getDriver().findElements(By.xpath("//*[@id='app-view-container']//table/tbody/tr[" + j + "]//td"));
                //Baslik sayisi kadar olacagi icin dinamik olmasi lazim
                LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
                //List icine atacagimiz Data Type LinkedHashMap olacak
                for (int k = 0; k < allHeaderNames.size(); k++) {//Header isimlerini Key olarak kullacagiz

                    String cellValue = allColumnsElements.get(k).getText();//baslik altindaki value alacak. 578-53-4460,Douglass,Barton...
                    eachRowData.put(allHeaderNames.get(k), cellValue);
                    //eachRowData.put(allHeaderNames.get(0),allColumnsElements.get(0).getText() [ ID=11648]
                    //eachRowData.put(allHeaderNames.get(1),allColumnsElements.get(1).getText() [ SSN=578-53-4460]
                    //eachRowData.put(allHeaderNames.get(14),allColumnsElements.get(14).getText() [ State/City]
                }
               // List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
                //En baslarda bunu declare etmistik..Orada degil de burda da edebilirdik

                allTableData.add(eachRowData);//List

            }
            //Bu asagidaki next buttonu normal locator ile calismiyor. Actions class kullanmak lazim .JavaScript oldugu icin
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(appointmentPageMD.next).click().perform();
            ReusableMethods.waitFor(1);
//Ilk sayfayi tamam ediyor .En tepe donguye gidiyor.ben yaparken 6 sayfa var idi. 6 kere click next oldu..sayfa arttikca artar

        }

        System.out.println(allTableData.size()); //Gerek yok..kac entry var gormek icin
        //elimizde icinde 100den fazla map olan bir liste var.Bizim aradigimiz value bu maplarin icinde
        Map<String, String> userInfo = new HashMap<>();//Kendi aradigim valur bulunca bu tek map icine atacagim..Linked gerek yok
        //Sifirdan map yapmiyoruz zaten key ve value bilinen maptan alacagimiz icin.
        //LinkedHashMap daha yavas ve daha cok memory tuketiyor.O yuzden luzumlu yerlerde kullanmak lazim

//To check how many SSN.If there are more than one , it is a bug
     int count=0;
   for(LinkedHashMap<String,String> each:allTableData ){
     boolean ssn= each.containsValue(patientDetails.get(0).get("ssn"));
     if(ssn==true){
      count++;
     }
   }
   Assert.assertEquals(1,count);

      for (int i=0;i<allTableData.size();i++) {//Tum listedekei mapleri check edecegim
          if(allTableData.get(i).get("SSN").equals(patientDetails.get(0).get("ssn"))){//Bu maplerden birinin icinde
              //allTableData.get(i).get("SSN") SSN keyi bizim hasta ssn ile esit olan patientDetails.get(0).get("ssn")
             //patientDetails bir listMap idi ama icinde sadece tek Map oldugu icin bizim hasta user bilgileri index 0 biliyoruz
              //Direkt String de yazilabilir mesela equals("578-53-4460" gibi
              userInfo.put("SSN",allTableData.get(i).get("SSN"));
              //Ilk "SSN" benim verdigim value istedigimiz key veririz.tabii ki burda SSN verdim.. case sensitivedir key
              userInfo.put("First Name",allTableData.get(i).get("First Name"));
              //allTableData.get(i).get("First Name")) Burdaki "First Name" bizim basliklardan aldigimiz Key
              userInfo.put("Last Name",allTableData.get(i).get("Last Name"));
              userInfo.put("Email",allTableData.get(i).get("Email"));
              userInfo.put("Phone",allTableData.get(i).get("Phone"));
              userInfo.put("ID",allTableData.get(i).get("ID"));
              //Burda herseyi cekebilirim. Address , Gender , CreatedDate User Country state/city

          }
      }

        System.out.println(userInfo);
        String HastaAdi=patientDetails.get(0).get("firstname");
        String HastaSoyadi=patientDetails.get(0).get("lastname");
        String Hasta_SSN=patientDetails.get(0).get("ssn");
        String Hasta_email=patientDetails.get(0).get("email");
        String Hasta_Phone=patientDetails.get(0).get("phone");
Assert.assertEquals(HastaAdi,userInfo.get("First Name"));//First_Name normal String degil.userInfo mapin name Keyi
Assert.assertEquals(Hasta_email,userInfo.get("Email"));
Assert.assertEquals(HastaSoyadi,userInfo.get("Last Name"));
    }
}

















