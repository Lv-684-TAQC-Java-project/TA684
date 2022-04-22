public class Data {
        private String email;
        private String password;



        public Data(){
            email = "admin@gmail.com";
            password = "admin";
        }

        // setters

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        // getters

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }


        @Override
        public String toString() {
            return "User [email=" + email + ", password=" + password + "]";
        }
}
