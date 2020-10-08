package section3_apis.part1_interfaces;

public class QuotedCombiner implements StringCombiner {
    @Override
    public String combine(String first, String second) {
        //'"one" "two"'
        return "'\"" + first + "\" \"" + second + "\"'";
    }
}
