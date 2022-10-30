package Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output=new StringBuilder();
        urls.stream()
                .forEach(url->{
                    if (url.matches(".*\\d.*")){
                        output.append("Invalid URL!\n");
                    }else{
                        output.append("Browsing: "+url+"!\n");
                    }
                });
        return String.valueOf(output);
    }

    @Override
    public String call() {
        StringBuilder output=new StringBuilder();
        numbers.stream()
                .forEach(n-> {
                    if (n.matches("[0-9]+")){
                        output.append("Calling... "+n+"\n");
                    }else{
                        output.append("Invalid number!\n");
                    }
                });
        return String.valueOf(output);
    }
}
