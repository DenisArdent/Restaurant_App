package di

import base.CartDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dishes.InMemoryCartDataRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CartDataModule {

    @Singleton
    @Binds
    fun bindCartDataRepository(cartDataRepository: InMemoryCartDataRepository): CartDataRepository
}