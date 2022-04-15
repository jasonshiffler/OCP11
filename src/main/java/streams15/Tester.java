package streams15;

import okhttp3.OkHttpClient;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Tester {

    public static void main(String[] args) {

        Tester tester = new Tester();
        tester.run();


    }

    private void run() {
        Train train = new Train();
        System.out.println(Optional.ofNullable(train)
                .map(Train::getWheels)
                .map(Wheels::getBearings)
                .orElse("no Bearings"));

    }


}
class Train {

    private Wheels wheels;

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }
}

class Wheels {
    private String bearings = "The Bearings";

    public String getBearings() {
        return bearings;
    }

    public void setBearings(String bearings) {
        this.bearings = bearings;
    }
}


