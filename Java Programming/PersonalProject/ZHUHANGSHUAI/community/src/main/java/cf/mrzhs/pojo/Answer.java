package cf.mrzhs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private Integer id;
    private Integer parentId;
    private String answerName;
    private String content;
    private Long gmtCreate;
    private Long gmtModified;
}
