package cf.mrzhs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GithubUser {
    private Integer id;
    private String name;
//    描述
    private String bio;
    private String avatar_url;
}
