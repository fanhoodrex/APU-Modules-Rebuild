package cf.mrzhs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private Integer githubId;
    private String accountName;
    private String accountToken;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

    public void setAvatar_url(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setGithub_id(Integer accountId) {
        this.githubId = accountId;
    }

    public void setAccount_name(String accountName) {
        this.accountName = accountName;
    }

    public void setAccount_token(String accountToken) {
        this.accountToken = accountToken;
    }

    public void setGmt_create(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public void setGmt_modified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}
