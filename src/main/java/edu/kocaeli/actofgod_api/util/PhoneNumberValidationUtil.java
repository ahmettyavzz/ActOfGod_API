package edu.kocaeli.actofgod_api.util;

import lombok.experimental.UtilityClass;

import java.util.regex.*;

@UtilityClass
public class PhoneNumberValidationUtil {
    public boolean validate(final String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
      String PHONE_PATTERN =
                "^(05)[0-9]{9}$";

        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        return pattern.matcher(phone).matches();
    }
}
