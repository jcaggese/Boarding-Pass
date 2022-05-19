package pkg.boardingpass;

import java.time.Duration;
import java.time.LocalDateTime;

public class ETA {

    LocalDateTime test = LocalDateTime.now();
    String time = "";

    public LocalDateTime Calculate(LocalDateTime date, String destination )
    {
        switch (destination) //This checks for the destination and matches it up
        {       //TODO: Maybe key pair values would be better afterall.
            case "LAX" -> time = "370";
        }
        var duration = Duration.ofMinutes(Integer.parseInt(time));
        int hours = (int) duration.toHours();
        int mins = (int) duration.minusHours(hours).toMinutes();

        var ETA = date.plusHours(hours).plusMinutes(mins);
        return ETA;
    }

}
