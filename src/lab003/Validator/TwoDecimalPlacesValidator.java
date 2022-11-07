package lab003.Validator;

public class TwoDecimalPlacesValidator {
    public static boolean checkTwoDecimalPlaces(float amount) {
        String text = Float.toString(Math.abs(amount));
        int integerPlaces = text.indexOf('.');
        int decimalPlaces = text.length() - integerPlaces - 1;

        if (decimalPlaces > 2) {
            return false;
        }
        
        return true;
    }
}
