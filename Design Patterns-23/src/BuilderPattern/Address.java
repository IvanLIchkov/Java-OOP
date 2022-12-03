package BuilderPattern;

public class Address {
    private String country;
    private String city;
    private String postcode;
    private String street;
    private String email;
    private String phoneNumber;
    private String recipientName;

    public static class Builder {

        private Address address;

        public Builder() {
            this.address = new Address();
        }

        public Builder withCountry(String country) {
            address.country = country;
            return this;
        }

        public Builder withCity(String city) {
            address.city = city;
            return this;
        }

        public Builder withPostcode(String postcode) {
            address.postcode = postcode;
            return this;
        }

        public Builder withStreet(String street) {
            address.street = street;
            return this;
        }

        public Builder withEmail(String email) {
            address.email = email;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            address.phoneNumber = phoneNumber;
            return this;


        }

        public Builder withRecipientName(String recipientName) {
            address.recipientName = recipientName;
            return this;

        }

        public Address build(){//терминиращ метод целта му е да каже край на чайнването искм да ми върнеш готовия резултат;
            return address;
        }
    }

    public static Builder builder(){
        return new Builder();
    }
}
