package sc.gads2020_aadpp;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<Void> submit( @Field("entry.1824927963") String email, @Field("entry.1877115667") String name, @Field("entry.2006916086") String surname, @Field("entry.284483984") String link);

}