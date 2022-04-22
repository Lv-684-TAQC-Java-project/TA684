public class userData {
        private static String email;
        private static String password;
        private String url;



        public userData(){
            email = "admin@gmail.com";
            password = "admin";
            url = "https://speak-ukrainian.org.ua/dev/";
        }

        // setters

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

         public void setUrl(String url) {
        this.url = password;
    }


        // getters

        public static String getEmail() {
            return email;
        }

        public static String getPassword() {
            return password;
        }

        public String getUrl() {
        return url;
    }

        @Override
        public String toString() {
            return "User [email=" + email + ", password=" + password + "]";
        }
}
