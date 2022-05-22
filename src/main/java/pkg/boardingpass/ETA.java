package pkg.boardingpass;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class ETA {

    String flightLength = "0";

    public LocalDateTime CalculateETA(LocalDateTime date, String destination )
    {
        switch (destination) //This checks for the destination and matches it up
        {       //TODO: Maybe key pair values would be better afterall.
            case "LAX" -> SetDuration("370");
        }
        var duration = Duration.ofMinutes(Integer.parseInt(flightLength));
        var hours = (int)duration.toHours();
        var mins = (int)duration.minusHours(hours).toMinutes();

        var arrival = date.plusHours(hours).plusMinutes(mins);

        return arrival;
    }

    public String GetDuration()
    {
        if(Objects.equals(flightLength, "0"))
        {
            System.out.println("Time has not been set yet! Calculate an ETA please!");
        }
        return flightLength;
    }

    public void SetDuration(String time)
    {
        this.flightLength = time;
    }

    public float CalculatePrice(String age, String time, String Gender)
    {
        float Age = 0, price = 0;
        try
        {
            Age = Float.parseFloat(age);
            price = Float.parseFloat(time) * 1.5f; // $1.5 per mile
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //Age checking section.
        if(Age <= 12)
        {
            return  price * .5f;
        }
        if(Age >= 60)
            return price * .6f;

        else if (Objects.equals(Gender, "Female"))
        {
            return price * .25f;
        }
        return price;
    }

}
