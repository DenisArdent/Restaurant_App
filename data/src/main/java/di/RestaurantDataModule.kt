package di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit.RetrofitRestaurantDataRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RestaurantDataModule {

    @Singleton
    @Binds
    fun bindsRestaurantDataRepository(
        retrofitRestaurantDataRepository: RetrofitRestaurantDataRepository
    ): base.RestaurantDataRepository
}
