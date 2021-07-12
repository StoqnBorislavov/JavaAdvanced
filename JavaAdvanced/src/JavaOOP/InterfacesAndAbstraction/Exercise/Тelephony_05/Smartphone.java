package JavaOOP.InterfacesAndAbstraction.Exercise.Тelephony_05;

import java.util.List;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        boolean isValid = true;
        StringBuilder builder = new StringBuilder();
        for (String url : urls) {
           isValid = true;
            char[] chars = url.toCharArray();
            for (char c :chars){
                if(Character.isDigit(c)) {
                    builder.append("Invalid URL!");
                    builder.append(System.lineSeparator());
                    isValid = false;
                    break;
                }
            }
            if(!isValid){
                continue;
            }
            builder.append(String.format("Browsing: %s!", url));
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

    @Override
    public String call() {
        boolean isValid = true;
        StringBuilder builder = new StringBuilder();
        for (String number : numbers) {
            isValid = true;
            char[] chars = number.toCharArray();
            for (char c :chars){
                if(!Character.isDigit(c)) {
                    builder.append("Invalid number!");
                    builder.append(System.lineSeparator());
                    isValid = false;
                    break;
                }
            }
            if(!isValid){
                continue;
            }
            builder.append(String.format("Calling... %s", number));
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
