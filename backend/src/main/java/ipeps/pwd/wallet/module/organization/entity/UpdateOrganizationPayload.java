package ipeps.pwd.wallet.module.organization.entity;

public class UpdateOrganizationPayload {
        private int organization_id;
        private String name;
        private String description;
        private boolean actif;

        public UpdateOrganizationPayload() {

        }

        public UpdateOrganizationPayload(int organization_id, String name,String description, boolean actif){
            this.organization_id = organization_id;
            this.name = name;
            this.description = description;
            this.actif = actif;
        }

    public int getOrganization_id() {return organization_id;}

    public void setOrganization_id(int organization_id) {this.organization_id = organization_id;}

    public String getName() {return name;}

        public void setName(String name) {this.name = name;}

        public String getDescription() {return description;}

        public void setDescription(String description) {this.description = description;}

        public boolean isActif() {return actif;}

        public void setActif(boolean actif) {this.actif = actif;}
}
