package todoserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {
    private String title;
    private Long order;
    private Boolean completed;

    @Override
    public String toString() {
        return "TodoRequest{" +
                "title='" + title + '\'' +
                ", order=" + order +
                ", completed=" + completed +
                '}';
    }
}
