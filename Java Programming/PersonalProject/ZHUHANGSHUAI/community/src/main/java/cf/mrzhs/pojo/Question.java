package cf.mrzhs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private String tag;

    public void setGmt_create(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public void setGmt_modified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public void setView_count(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public void setComment_count(Integer commentCount) {
        this.commentCount = commentCount;
    }
}
