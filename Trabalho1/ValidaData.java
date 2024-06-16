

public class ValidaData {
    public static boolean isDia(String x) {
        int y;
        try {
            y = Integer.parseInt(x.replaceAll("[\\D]", "").substring(0, 2));
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
        return y <= 31 && y > 0;
    }

    public static boolean isMes(String x) {
        int y;
        try {
            y = Integer.parseInt(x.replaceAll("[\\D]", "").substring(2, 4));
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }

        return y <= 12 && y >= 1;
    }

    public static boolean isAno(String x) {
        int y;
        try {
            y = Integer.parseInt(x.replaceAll("[\\D]", "").substring(4, 8));
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
        return y <= 2023 && y >= 0;
    }

    public static int parseDia(String x) {
        int y;
        y = Integer.parseInt(x.replaceAll("[\\D]", "").substring(0, 2));
        return y;
    }

    public static int parseMes(String x) {
        int y;
        y = Integer.parseInt(x.replaceAll("[\\D]", "").substring(2, 4));
        return y;
    }

    public static int parseAno(String x) {
        int y;
        y = Integer.parseInt(x.replaceAll("[\\D]", "").substring(4, 8));
        return y;

    }

}


