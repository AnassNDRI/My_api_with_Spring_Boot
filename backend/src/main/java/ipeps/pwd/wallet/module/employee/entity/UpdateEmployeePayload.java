package ipeps.pwd.wallet.module.employee.entity;

public class UpdateEmployeePayload {
        private int employee_id;
        private String role;
        private boolean actif;


        public UpdateEmployeePayload(){

        }

        public UpdateEmployeePayload(int employee_id, String role, boolean actif ){
            this.employee_id = employee_id;
            this.role            = role;
            this.actif           = actif;
        }


        public String getRole() {return role;}

        public void setRole(String role) {this.role = role;}

        public boolean isActif() {return actif;}

        public void setActif(boolean actif) {this.actif = actif;}

        public int getEmployee_id() {return employee_id;}

        public void setEmployee_id(int employee_id) {this.employee_id = employee_id;}
}
