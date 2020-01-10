package api;

import model.ResponsFromAPI;
import model.TwitterModel;
import model.TwitterModelAPI;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface TwitterApi {
    @POST("twitter/users/signup")
    Call<ResponsFromAPI> register(@Body TwitterModelAPI tapi);

    @Multipart
    @POST("twitter/imageUpload")
    Call<ResponsFromAPI> uploadImage(@Part MultipartBody.Part myImage);

    @FormUrlEncoded
    @POST("twitter/users/login")
    Call<ResponsFromAPI> login(@Field("email") String email, @Field("password")String password);

    @GET("twitter/users/get/{id}")
    Call<TwitterModelAPI> getUsersById( @Path("id") int id);






}

