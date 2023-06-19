package base

import com.denisardent.common.ConnectionException

open class BaseRetrofitRepository{

    suspend fun <T> wrapRetrofitExceptions(block: suspend () -> T): T{
        return try {
                block()
        } catch (e: Exception){
            throw ConnectionException(e)
        }
    }
}