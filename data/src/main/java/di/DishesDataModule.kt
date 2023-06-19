package di

import base.CartDataRepository
import base.DishesDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dishes.InMemoryCartDataRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DishesDataModule {

    @Singleton
    @Binds
    fun bindDishesDataRepository(dishesDataRepository: CartDataRepository): DishesDataRepository
}