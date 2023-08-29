import retrofit2.http.Query
import okhttp3.ResponseBody
import retrofit2.http.GET

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apikey: String
    ): ResponseBody


    companion object {
        const val API_KEY = "3W2VSYLPGOYHETCN"
        const val BASE_URL = "https://www.alphavantage.co"
    }
}