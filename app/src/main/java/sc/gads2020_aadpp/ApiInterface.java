package sc.gads2020_aadpp;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sc.gads2020_aadpp.models.IQItem;
import sc.gads2020_aadpp.models.LearningItem;
import sc.gads2020_aadpp.models.SubmitItem;

public interface ApiInterface {

    @GET("hours")
    Call<List<LearningItem>> getLearningItems();

    @GET("skilliq")
    Call<List<IQItem>> getSkillIQItems();

    @POST("formResponse")
    Call<SubmitItem> submit(@Body SubmitItem item);

}