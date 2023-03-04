package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Appointment {

   private String status;
   private String startDate;
   private String endDate;
   private String phone;
   private String email;
   private String firstname;
   private String lastname;
   private String ssn;
   private String gender;

   public Appointment(String status, String startDate, String endDate, String phone, String email, String firstname, String lastname, String ssn, String gender) {
      this.status = status;
      this.startDate = startDate;
      this.endDate = endDate;
      this.phone = phone;
      this.email = email;
      this.firstname = firstname;
      this.lastname = lastname;
      this.ssn = ssn;
      this.gender = gender;
   }

   public Appointment() {
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getStartDate() {
      return startDate;
   }

   public void setStartDate(String startDate) {
      this.startDate = startDate;
   }

   public String getEndDate() {
      return endDate;
   }

   public void setEndDate(String endDate) {
      this.endDate = endDate;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getFirstname() {
      return firstname;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public String getLastname() {
      return lastname;
   }

   public void setLastname(String lastname) {
      this.lastname = lastname;
   }

   public String getSsn() {
      return ssn;
   }

   public void setSsn(String ssn) {
      this.ssn = ssn;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   @Override
   public String toString() {
      return "Appointment{" +
              "status='" + status + '\'' +
              ", startDate='" + startDate + '\'' +
              ", endDate='" + endDate + '\'' +
              ", phone='" + phone + '\'' +
              ", email='" + email + '\'' +
              ", firstname='" + firstname + '\'' +
              ", lastname='" + lastname + '\'' +
              ", ssn='" + ssn + '\'' +
              ", gender='" + gender + '\'' +
              '}';
   }
}


