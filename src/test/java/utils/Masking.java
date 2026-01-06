package utils;

public class Masking {

    public static String maskPassword(String payload) {
    return payload.replaceAll(
        "(\"password\"\\s*:\\s*\")[^\"]+",
        "$1****"
    );
    }

    public static String maskEndpoint(String apiEndpoint) {
        return apiEndpoint.replaceAll(".*", "***MASKED_ENDPOINT***");
    }

}
