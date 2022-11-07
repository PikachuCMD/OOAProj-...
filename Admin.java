public class Admin {
    
   private int UserAdmin ;
   private int pinAdmin;

   public Admin(int UserAdmin, int pinAdmin) {
    this.UserAdmin = UserAdmin;
    this.pinAdmin = pinAdmin;
   }

   public boolean validatePIN(int pin) {
      if (pinAdmin == pin) {
           return true;
      }
      else {
        return false;
      }
   }

   public int getNumberAdmin() {
       return UserAdmin;
   }


}
