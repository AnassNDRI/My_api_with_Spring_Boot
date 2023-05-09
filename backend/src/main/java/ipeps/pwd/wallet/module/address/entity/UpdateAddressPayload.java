package ipeps.pwd.wallet.module.address.entity;

public class UpdateAddressPayload {

        private int address_id;
        private AddressTypeEnum type;
        private String road;
        private int number;
        private String box;
        private  String cp;
        private String town;
        private String country;

        public UpdateAddressPayload(int address_id, AddressTypeEnum type,String road,int number,String box, String cp,String town, String country) {
            this.address_id = address_id;
            this.type    = type;
            this.road    = road;
            this.box     =  box;
            this.number  = number;
            this.cp      = cp;
            this.town    = town;
            this.country = country;
        }

        public UpdateAddressPayload(){

        }

    public int getAddress_id() {return address_id;}

    public void setAddress_id(int address_id) {this.address_id = address_id;}

    public AddressTypeEnum getType() {return type;}

        public void setType(AddressTypeEnum type) {this.type = type;}

        public String getRoad() {return road;}

        public void setRoad(String road) {this.road = road;}

        public int getNumber() {return number;}

        public void setNumber(int number) {this.number = number;}

        public String getBox() {return box;}

        public void setBox(String box) {this.box = box;}

        public String getCp() {return cp;}

        public void setCp(String cp) {this.cp = cp;}

        public String getTown() {return town;}

        public void setTown(String town) {this.town = town;}

        public String getCountry() {return country;}

        public void setCountry(String country) {this.country = country;}
}
