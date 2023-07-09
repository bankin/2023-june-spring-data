import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CourseDTO;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class MainDates {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
//                .setDateFormat("YYYY-MM-dd")
                .setPrettyPrinting()
                .create();

        CourseDTO math = new CourseDTO("Math", 10, Date.from(Instant.now()));

        // custom type adapter for LocalDate

        System.out.println(gson.toJson(math));

        String mathJson = """
                {
                  "name": "Math",
                  "lengthInWeeks": 10,
                  "createdAt": "2023-07-08"
                }
        """;

        CourseDTO courseDTO = gson.fromJson(mathJson, CourseDTO.class);
        System.out.println(courseDTO);
    }
}
