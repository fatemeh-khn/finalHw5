public class User {
     private int id;
     private String username;
     private String password;
     private String nationalCode;
     private String birthday;

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getNationalCode() {
          return nationalCode;
     }

     public void setNationalCode(String nationalCode) {
          this.nationalCode = nationalCode;
     }

     public String getBirthday() {
          return birthday;
     }

     public void setBirthday(String birthday) {
          this.birthday = birthday;
     }

     @Override
     public String toString() {
          return "User{" +
                  "username='" + username + '\'' +
                  ", password='" + password + '\'' +
                  ", nationalCode='" + nationalCode + '\'' +
                  ", birthday='" + birthday + '\'' +
                  '}';
     }
}
