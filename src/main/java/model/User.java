package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Timer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String uncompletedTasks;
    private String completedTasks;
}
