package cf.mrzhs.provider;

import cf.mrzhs.dto.AccessTokenPOJO;
import cf.mrzhs.dto.GithubUser;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
//    此方法时为了通过使用用户的code来获取用户的token
    public String getAccessToken(AccessTokenPOJO tokenPOJO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
//        设置请求体,内容类型和对象的json格式
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(tokenPOJO));//将对象转换成json

        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String responseString = response.body().string();
            String token = responseString.split("&")[0].split("=")[1];
            return token;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public GithubUser getUser(String accessToken){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
//                此处token需要加个空格
                .header("Authorization","token " + accessToken)
                .get()
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
//            返回的是一组json数据
            String objectJson = response.body().string();

//            通过json数据创建对象
            GithubUser githubUser = JSON.parseObject(objectJson, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
