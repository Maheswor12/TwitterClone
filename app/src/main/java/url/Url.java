package url;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {
    // public static final String base_url = "http://192.168.1.11:3000/";
    public static final String base_url = "http://10.0.2.2:8001/";
    // public static final String base_url = "http://172.100.100.5:3000/";
    public static String token = "Bearer ";
//    public static String imagePath = base_url + "images/" ;
public static String accessToken="";
    public static int id;
    public static Retrofit getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
