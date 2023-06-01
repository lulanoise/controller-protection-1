package co.develhope.loginDemo.auth.entities;

public class SignupActivationDTO {

    private String activationCode;

    public String getActivationCode() {

        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    @Override
    public String toString() {
        return "SignupActivationDTO{" +
                "activationCode='" + activationCode + '\'' +
                '}';
    }
}
